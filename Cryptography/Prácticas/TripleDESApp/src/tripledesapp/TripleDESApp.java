/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tripledesapp;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.DESedeEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.util.encoders.Hex;
import static tripledesapp.TripleDES.generateKeyAndIV;

/**
 *
 * @author alber
 */
public class TripleDESApp {

    /**
     * @param args the command line arguments
     */
    static java.util.Scanner scanner;
    public static void main(String[] args) throws UnsupportedEncodingException, InvalidCipherTextException {
        TripleDESApp instance = new TripleDESApp();
        instance.doMenu();

        //System.out.println("Cipher text: "+Hex.toHexString(encrypt(key,iv,text,operationMode)));
    }

    private void doMenu() throws InvalidCipherTextException, UnsupportedEncodingException {
        //System.out.println("\t  0. Crear un archivo de texto");
        System.out.println("-----MENÚ-----");
        System.out.println("1. Generar clave para algoritmo de cifrado 3DES");
        System.out.println("2. Cifrar archivo con 3DES");
        System.out.println("3. Descifrar archivo con 3DES");
        System.out.println("4. Salir");

        System.out.print("\n\nSeleccione una opción y pulse ENTER:");
        scanner = new java.util.Scanner(System.in);
        String selectedOption = scanner.nextLine();
        switch (Integer.parseInt(selectedOption)) {
            case 1:
                new TripleDES().doGenerateKey();
                break;
            case 2:
                new TripleDES().doEncrypt();
                break;
            case 3:
                new TripleDES().doDecrypt();
                break;
            case 4:
                return;

            default:
                System.out.println("Opción incorrecta");
                break;
        }
        doMenu();

    }

}
