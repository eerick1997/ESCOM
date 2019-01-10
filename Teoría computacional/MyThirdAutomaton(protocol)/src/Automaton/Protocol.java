package Automaton;

import Files.MyFile;
import java.io.FileReader;

public class Protocol{

    private static final String str = "";
    private static final int start = -1, q0 = 0, q1 = 1;
    private MyFile history;
    
    public Protocol(){
        history = new MyFile("History.txt");
    }
    
    public int states(char character, int actualState){
        
        return 0;
    }
    
    public void byFile(String path){
        
    }
    
    public void readByKeyboard(String word){
        word = word + " ";
        int lastState = start;
        for(int i=0; i<word.length(); i++)
            lastState = states(word.charAt(i), lastState);
        history.closeFile();
    }
    
        public void readByFile(String path){
        try{
            int actual = start;
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();
            
            while(character != -1){
                actual = states((char)character, actual);
                character = fileReader.read();
            }
            actual = states((char)character, actual);
            character = fileReader.read();
            
            fileReader.close();
        } catch(Exception e){
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        history.closeFile();
    }
}
