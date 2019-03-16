package prueba;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Arrays;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/**
 *
 * @author Erick
 */
public class Prueba {

   public static void main(String[] args) throws UnsupportedEncodingException, 
    InvalidCipherTextException {
       String PLAINTEXT = "hola";
      // Create the cipherer
      BlockCipher engine = new DESedeEngine();
      BlockCipher cipherInOperationMode = new CBCBlockCipher(engine);
      PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(cipherInOperationMode, 
        new PKCS7Padding());
 
      // Get the plaintext bytes
      System.out.println("Texto plano: " + PLAINTEXT);
      byte[] plainText = PLAINTEXT.getBytes("utf-8");
      System.out.println("Texto plano (longitud en bytes): " + plainText.length);
 
      // Generate the random key and initialization vector
      SecureRandom randomGenerator = new SecureRandom();
      byte[] key = new byte[24];              // 24 bytes = 192 bits
      byte[] iv = new byte[8];                // 8 bytes = 64 bits
      randomGenerator.nextBytes(key);
      randomGenerator.nextBytes(iv);
 
      // Init the cipherer with the key and initialization vector
      KeyParameter keyParameter = new KeyParameter(key);
      ParametersWithIV parametersWithIV = new ParametersWithIV(keyParameter, iv);
      cipher.init(true, parametersWithIV);
 
      // Allocate space for maximum output size when creating output array
      int maxOutputSize = cipher.getOutputSize(plainText.length);
      byte[] cipherText = new byte[maxOutputSize];
 
      // Do the ciphering
      int finalOutputSize = cipher.processBytes(plainText, 0, plainText.length, cipherText, 0);
      cipher.doFinal(cipherText, finalOutputSize);
 
      // Append the IV at the beginning of the ciphertext
      byte[] ciphertextWithIVBytes = new byte[iv.length + cipherText.length];
      System.arraycopy(iv, 0, ciphertextWithIVBytes, 0, iv.length);
      System.arraycopy(cipherText, 0, ciphertextWithIVBytes, iv.length, cipherText.length);
 
      System.out.println("Texto cifrado (bytes): " + Arrays.toString(ciphertextWithIVBytes));
      System.out.println("Texto cifrado (longitud en bytes): " + ciphertextWithIVBytes.length);
  }
}
