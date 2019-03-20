/*
@author: Esquivel Valdez Alberto
@date: 18.03.19
@program: Implementación de TripleDES utilizando la librería BouncyCastle con los
modos de operación OFB,CTR,CFB y CBC con tamañs de llave de 16 o 24 bytes*/
package tripledesapp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FilenameFilter;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import java.util.Scanner;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.DESedeEngine;

import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.CFBBlockCipher;
import org.bouncycastle.crypto.modes.OFBBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.encoders.Hex;
import static tripledesapp.TripleDESApp.scanner;

public class TripleDES {

    private static final String KEY_EXTENSION="key";
    private static final String CIPHER_EXTENSION="tresdes";
    private String filesPath = System.getProperty("user.dir") + "/files/";
    /*El tamaño de la llave para DES debe se de 16 bytes = 128 bits o de 24 bytes = 192 bits*/
    public final int keySize = 32;
    /*El tamaño de bloque para OFB, CTR, CFB*/
    public final int blockSize = 8;

    public static String doModeMenu() {
        
        System.out.println("\tSeleccione el modo de operación:");
        System.out.println("\t1. Cipher Mode Operation (CBC)");
        System.out.println("\t2. Output FeedBack (OFB)");
        System.out.println("\t3. CounTeR (CTR)");
        System.out.println("\t4. Cipher FeedBack (CFB)");
        System.out.print("\n\nSeleccione una opción y pulse ENTER:");
        scanner = new java.util.Scanner(System.in);
        String selectedOption=scanner.nextLine();
        switch (Integer.parseInt(selectedOption)) {
            case 1:
                return "CBC";
                
            case 2:
                return "OFB";
                
            case 3:
                return "CTR";
                
            case 4:
                return "CFB";
            case 5:
                break;

            default:
                System.out.println("Opción incorrecta");
                break;
        }
        
        return null;
        
    }

    public void doEncrypt() throws UnsupportedEncodingException, InvalidCipherTextException {
        BlockCipher engine = new DESedeEngine();//Crea el método de cifrado 
        String mode=doModeMenu();
        BlockCipher operationMode = null;
        if(mode.equals("CBC")) operationMode = new CBCBlockCipher(engine);
        else if(mode.equals("OFB")) operationMode = new OFBBlockCipher(engine,blockSize);
        else if(mode.equals("CTR")) operationMode = new SICBlockCipher(engine);
        else if(mode.equals("CFB")) operationMode = new CFBBlockCipher(engine,blockSize);
        
        //String plaintext = "HOLA ESTE ES UN MENSAJE DE PRUEBA";
        //System.out.println("Texto plano: " + plaintext);
        //byte[] pT = plaintext.getBytes("utf-8");//Texto plano a bytes
        byte[] plaintext = doSelectFile("Seleccione un archivo", "");
        byte[] keyAndIV = doSelectFile("Seleccione una llave", KEY_EXTENSION);

        //System.out.println("Key + IV: " + Hex.toHexString(keyAndIV));
        byte[] key = new byte[keySize - 8];
        System.arraycopy(keyAndIV, 8, key, 0, keySize - 8);

        byte[] iv = new byte[8];
        System.arraycopy(keyAndIV, keySize, iv, 0, 8);

        System.out.println("Key: " + Hex.toHexString(key));
        //System.out.println("IV: " + Hex.toHexString(iv));
        byte[] res = encrypt(key, iv, plaintext, operationMode);
        //System.out.println("RES: " + Hex.toHexString(res));
        saveFile(CIPHER_EXTENSION, Hex.encode(res));

    }

    protected byte[] encrypt(byte[] key, byte[] iv, byte[] plain, BlockCipher operationMode) throws InvalidCipherTextException {
        
        long startTime = System.currentTimeMillis();
        PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(operationMode, new PKCS7Padding());//Padding
        KeyParameter keyParameter = new KeyParameter(key);
        ParametersWithIV parametersWithIV = new ParametersWithIV(keyParameter, iv);
        cipher.init(true, parametersWithIV);
        int maxOutputSize = cipher.getOutputSize(plain.length);
        byte[] cipherText = new byte[maxOutputSize];
        // Do the ciphering
        int finalOutputSize = cipher.processBytes(plain, 0, plain.length, cipherText, 0);
        cipher.doFinal(cipherText, finalOutputSize);
        // Concatena el vector de inicialización con el texto cifrado
        byte[] ciphertextWithIVBytes = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, ciphertextWithIVBytes, 0, iv.length);
        System.arraycopy(cipherText, 0, ciphertextWithIVBytes, iv.length, cipherText.length);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo " + endTime);
        return ciphertextWithIVBytes;
    }

    public void doDecrypt() throws UnsupportedEncodingException, DataLengthException, InvalidCipherTextException {
        BlockCipher engine = new DESedeEngine();//Crea el método de cifrado 
        
        BlockCipher operationMode = null;
        String mode=doModeMenu();
        
        if(mode.equals("CBC")) operationMode = new CBCBlockCipher(engine);
        else if(mode.equals("OFB")) operationMode = new OFBBlockCipher(engine,blockSize);
        else if(mode.equals("CTR")) operationMode = new SICBlockCipher(engine);
        else if(mode.equals("CFB")) operationMode = new CFBBlockCipher(engine,blockSize);
        byte[] cifrado = doSelectFile("Seleccione una archivo cifrado", CIPHER_EXTENSION);
        byte[] keyAux = doSelectFile("Selecciona la llave", KEY_EXTENSION);
        byte[] res = decrypt(keyAux, Hex.decode(cifrado), operationMode);
        //System.out.println("RES: " + new String(res));
        saveFile(CIPHER_EXTENSION, res);
    }

    protected byte[] decrypt(byte[] key, byte[] plain, BlockCipher operationMode) throws UnsupportedEncodingException, DataLengthException, InvalidCipherTextException {
        PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(operationMode, new PKCS7Padding());//Padding

        // Extract the iv from the ciphertext
        byte[] decipherIV = new byte[8];
        byte[] textToDecipher = new byte[plain.length - 8];
        System.arraycopy(plain, 0, decipherIV, 0, 8);
        System.arraycopy(plain, 8, textToDecipher, 0, textToDecipher.length);

        byte[] separatedKey = new byte[keySize - 8];
        System.arraycopy(key, 8, separatedKey, 0, keySize - 8);
        // Reuse the cipherer to do the deciphering with the cipher key and recovered iv
        KeyParameter decipherKey = new KeyParameter(separatedKey);
        ParametersWithIV decipherInitParams = new ParametersWithIV(decipherKey, decipherIV);
        cipher.reset();
        cipher.init(false, decipherInitParams);

        // Allocate space for the deciphered text
        int maxDecipheredOutputSize = cipher.getOutputSize(textToDecipher.length);
        byte[] decipheredOutputBytes = new byte[maxDecipheredOutputSize];

        // Perform the deciphering
        int finalDecipheredTextSize = cipher.processBytes(textToDecipher, 0, textToDecipher.length, decipheredOutputBytes, 0);
        try {
            cipher.doFinal(decipheredOutputBytes, finalDecipheredTextSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

       // System.out.println("UDOB:"+new String(decipheredOutputBytes,"utf-8"));
        /*/ Remove the padding
         byte[] unpaddedDecipheredOutputBytes = new byte[finalDecipheredTextSize];
         System.arraycopy(decipheredOutputBytes, 0, unpaddedDecipheredOutputBytes, 0, finalDecipheredTextSize);

         System.out.println("Texto descifrado: " + new String(unpaddedDecipheredOutputBytes, "utf-8"));*/
        return decipheredOutputBytes;
    }

    public void doGenerateKey() {
        byte[] key = generateKeyAndIV();
        saveFile("key", Hex.encode(key));

    }

    public static byte[] generateKeyAndIV() {
        //Genera una llave y vector de inciialización aleatorios
        SecureRandom randomGenerator = new SecureRandom();
        byte[] key = new byte[24];//Tamaño de la llave en bytes
        byte[] iv = new byte[8];//Tamaño del vector de inicialización en bytes
        randomGenerator.nextBytes(key);
        randomGenerator.nextBytes(iv);
        /*Concatenar la llave con el vector de inicialización*/
        byte[] c = new byte[iv.length + key.length];
        System.arraycopy(iv, 0, c, 0, iv.length);
        System.arraycopy(key, 0, c, iv.length, key.length);
        return c;
    }

    public byte[] doSelectFile(String message, String extension) {
        File dir = new File(filesPath);

        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(extension);
            }
        });
        if (files.length == 0) {
            System.out
                    .println("** No se ha encontrado ningún archivo con la extensión "
                            + extension);
            return null;
        }
        for (File file : files) {
            System.out.println("\t- " + file.getName());
        }
        String fileName = readTextFromConsole(message);
        if (new File(filesPath + fileName).exists()) {
            return loadFile(filesPath + fileName);
        }
        if (new File(filesPath + fileName + "." + extension).exists()) {
            return loadFile(filesPath + fileName + "." + extension);
        } else {

            System.out.println("** No se ha encontrado el archivo");
            return null;
        }
    }

    /* public void guardar(String ext, byte[] data) {
     FileWriter fichero = null;
     PrintWriter pw = null;
     String saveString = new String(generateKeyAndIV());
     System.out.println("Save String: " + saveString);
     try {
     fichero = new FileWriter("files/llave.key");
     pw = new PrintWriter(fichero);
     pw.println(saveString);
     } catch (Exception e) {
     } finally {
     pw.close();
     }
     }
     */
    public boolean saveFile(String ext, byte[] data) {
        System.out
                .print("Introduzca el nombre del archivo a grabar \n(se almacenará con la extensión "
                        + ext + "):");
        String fileName = new Scanner(System.in).nextLine();
        if (fileName.trim().length() == 0) {
            saveFile(ext, data);
        }
        String filePath = filesPath + fileName + "." + ext;
        File carpetaFile = new File(filesPath);
        if (!carpetaFile.exists()) {
            carpetaFile.mkdirs();
        }
        try {
            BufferedOutputStream keystream = new BufferedOutputStream(
                    new FileOutputStream(filePath));
            keystream.write(data, 0, data.length);
            keystream.flush();
            keystream.close();
        } catch (Exception e) {
            System.out
                    .println("** Ha ocurrido un error intentando grabar el archivo '"
                            + filePath + "'\n");
            e.printStackTrace();
            return false;
        }
        System.out.println("Archivo almacenado en " + filePath + "\n");
        return true;
    }

    public String readTextFromConsole(String message) {
        if (message != null) {
            System.out.print(message + ":");
        }
        return new Scanner(System.in).nextLine();
    }

    public byte[] loadFile(String infile) {
        try {
            // read the key, and decode from hex encoding
            BufferedInputStream keystream = new BufferedInputStream(
                    new FileInputStream(infile));
            int len = keystream.available();
            byte[] keyhex = new byte[len];
            keystream.read(keyhex, 0, len);
            return keyhex;
        } catch (Exception e) {
            System.err.println("** Error leyendo el archivo ");
            e.printStackTrace();
            return null;
        }
    }
}
