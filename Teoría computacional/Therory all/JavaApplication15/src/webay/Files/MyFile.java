package webay.Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFile {
    
    private String name;
    private FileWriter fileWriter;
    
    public MyFile(String name){
        
        this.name = name;
        try{
            fileWriter = new FileWriter(new File(this.name));
        } catch (IOException e){
            System.err.println("Error creating file: " + this.name);
            System.err.println(e);
        }
    }
    
    public void writeSth(String str){
        try{
            fileWriter.write(str);
            fileWriter.write("\r\n");
        } catch (IOException e) {
            System.err.println("Exeption writing states file: " + this.name);
            System.err.println(e);
        }
    }
    
    public void closeFile(){
        try{
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Exception closing file: " + this.name);
            System.err.println(e);
        }
    }
}
