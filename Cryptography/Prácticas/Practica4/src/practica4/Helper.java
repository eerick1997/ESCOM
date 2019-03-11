package practica4;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Helper {
    
    public byte[] readFile() throws Exception {
        String path = "";
        File file;
        byte[] bytes;
        FileInputStream fis;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite the file path -> ");
        path = scanner.nextLine();
        file = new File(path);
        bytes = new byte[(int) file.length()];
        fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        return bytes;
    }
    
    public void buildFile(){
    }
}
