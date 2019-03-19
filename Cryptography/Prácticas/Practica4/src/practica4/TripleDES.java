/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;
import java.security.SecureRandom;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.engines.DESedeEngine;

import org.bouncycastle.crypto.generators.DESedeKeyGenerator;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.DESedeParameters;

import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.Hex;


public class TripleDES {
	
	private static final String EXTENSION_CIFRADO = "tripleencdes";
	private static final String EXTENSION_CLAVE = "tripledeskey";
        public final int blockSize=16;
	BlockCipher engine = new DESedeEngine();

	/**
	 * Gestiona la creación de una clave 3 DES
	 */
	
        public void doGenerateKey() {
		byte[] key = generateKeyAndIV();
		if (key != null) {
			System.out.println("Clave generada:"
					+ new String(Hex.encode(Arrays.copyOfRange(key, 0, 14))));
			System.out.println("IV generado:"
					+ new String(Hex.encode(Arrays.copyOfRange(key, 14,
							blockSize + 14))));
			Utils.instance().saveFile(EXTENSION_CLAVE, Hex.encode(key));
		}
	}


	/**
	 * Gestiona el cifrado de un archivo usando el algoritmo DES y una clave alamcenada también en otro archivo
	 */
	public void doEncrypt() {
		// Archivo a cifrar
		byte[] text = Utils.instance().doSelectFile("Seleccione un archivo para cifrar", "txt");
		if (text!=null) {
			// Clave a usar
			byte[] key = Utils.instance().doSelectFile("Seleccione una clave",
					EXTENSION_CLAVE);
			if (key != null) {
				// La almacenamos en hexadecimal para que sea legible en el archivo
				byte[] res = encrypt(text,
						Arrays.copyOfRange(Hex.decode(key), 0, 14),
						Arrays.copyOfRange(Hex.decode(key), 14,14 + blockSize));
				System.out.println("Texto cifrado (en hexadecimal):"
						+ new String(Hex.encode(res)));
				Utils.instance().saveFile(EXTENSION_CIFRADO, Hex.encode(res));
			}
		} else {
			// No se desea continuar con la ejecución
		}

	}
	/**
	 * Gestiona el descifrado de un archivo usando el algoritmo DES y una clave almacenada también en otro archivo
	 */
	public void doDecrypt() {
		// Archivo a descifrar
		byte[] fileContent = Utils.instance().doSelectFile(
				"Seleccione una archivo cifrado", EXTENSION_CIFRADO);
		if (fileContent == null) {
			return;
		}
		// Clave a usar
		byte[] key = Utils.instance().doSelectFile("Seleccione una clave",
				EXTENSION_CLAVE);
		if (key != null) {
			// Desciframos el archivo
			byte[] res = decrypt(Hex.decode(fileContent),
					Arrays.copyOfRange(Hex.decode(key), 0, 14),
					Arrays.copyOfRange(Hex.decode(key), 14, blockSize + 14));
			if (res != null) {
				System.out.println("Texto en claro:"
						+ new String(res));
			}
		}

	}

	/**
	 * Realiza el cifrado DES de los datos
	 * @param key Clave
	 * @param ptBytes Texto a cifrar
	 * @return Texto cifrado
	 */
	protected byte[] encrypt(byte[] plain, byte[] key,byte[] iv) {
		// Creamos un cifrador de Bloque con Padding y con el modo de bloque CBC
                
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new CFBBlockCipher(engine,8));
                CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(
					key), iv);
		// Lo inicializamos con la clave
		cipher.init(true, new KeyParameter(iv));
		// Reservamos espacio para el texto cifrado
		byte[] rv = new byte[cipher.getOutputSize(plain.length)];
                
		// Realizamos el procesamiento con DES
		int tam = cipher.processBytes(plain, 0, plain.length, rv, 0);
		try {
			// "flush" del cifrador
			cipher.doFinal(rv, tam);
		} catch (Exception ce) {
			ce.printStackTrace();
			return null;
		}
		// Devolvemos los datos cifrados
		return rv;
	}

	/**
	 * Realiza el descifrado DES de los datos
	 * Este método podría obviarse y utilizarse el método encrypt para realizar el descifrado al ser
	 * el algoritmo DES un algoritmo simétrico, pero se mantiene por criterios de claridad para el alumno
	 * @param key Clave
	 * @param ptBytes Texto a descifrar
	 * @return Texto descifrado
	 */
	public byte[] decrypt(byte[] ciphered, byte[] key, byte[] iv) {
		// Creamos un cifrador de Bloque con Padding y con el modo de bloque CBC
		BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(
				new CFBBlockCipher(engine,8));
                CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(
					key), iv);
		// Lo inicializamos con la clave
		cipher.init(false, ivAndKey);
		// Reservamos espacio para el texto descifrado
		byte[] rv = new byte[cipher.getOutputSize(ciphered.length)];
		// Realizamos el procesamiento con DES
		int tam = cipher.processBytes(ciphered, 0, ciphered.length, rv, 0);
		try {
			// "flush" del cifrador
			cipher.doFinal(rv, tam);
		} catch (Exception ce) {
			System.out.println("Ha ocurrido un error al intentar descifrar el archivo:"+ce.getLocalizedMessage());
			//			ce.printStackTrace();
			return null;
		}
		// Devolvemos los datos descifrados
		return rv;
	}

	/**
	 * Genera una Clave para el cifrado 3 DES a partir de un número aleatorio
	 * "seguro"
	 * 
	 * @return 14+blockSize bytes (Clave+IV)
	 */
	
	public byte[] generateKeyAndIV() {
		// Usamos el generador de números aleatorios para criptografía
		SecureRandom sr = null;
		try {
			sr = new SecureRandom();
			// Lo inicializamos con una semilla
			sr.setSeed("UCTresM.".getBytes());
		} catch (Exception e) {
			System.err
					.println("Ha ocurrido un error generando el número aleatorio");
			return null;
		}
		// Lo generamos del tamaño que necesitamos (24 bytes de clave + tamaño de bloque como IV)
		byte[] key = sr.generateSeed(14 + blockSize+10);
		return key;

	}
}