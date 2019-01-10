package MyAutomaton;

import Files.MyFile;
import java.io.FileReader;

public class Automaton {
    
    private static final int q0 = 0, q1 = 1,q2 = 2, q3 = 3, start = -1;
    private static final String FSTATES = "states.txt", FSTRINGS ="strings.txt";
    private MyFile FileHistory, FileStrigs;
    private String str = ""; 
    
    public Automaton(){
        FileHistory = new MyFile(FSTATES);
        FileStrigs = new MyFile(FSTRINGS);
    }
    
    public int states(char character, int actualState){
        
        if(isAValidCharacter(character)){
            //q0
            if(actualState == q0 || actualState == start){ //Also is initial state
                if(character == '0'){
                    if(actualState == start)
                        FileHistory.writeSth("start->q0");
                    else if(actualState == q0)
                        FileHistory.writeSth("q0->q1");
                    actualState = q1;
                    
                } else if (character == '1'){
                    
                    if(actualState == start)
                        FileHistory.writeSth("start -> q2");
                    else if(actualState == q0)
                        FileHistory.writeSth("q0 -> q2");
                    actualState = q2;
                }
            }
            else if(actualState == q1){
                if(character == '0'){
                    FileHistory.writeSth("q1 -> q0");
                    actualState = q0;
                } else if (character == '1'){
                    FileHistory.writeSth("q1 -> q3");
                    actualState = q3;
                }
            }
            else if(actualState == q2){
                if(character == '0'){
                    FileHistory.writeSth("q2 -> q3");
                    actualState = q3;
                } else if (character == '1'){
                    FileHistory.writeSth("q2 -> q0");
                    actualState = q0;
                }
            }
            else if(actualState == q3){
                if(character == '0'){
                    FileHistory.writeSth("q3 -> q2");
                    actualState = q2;
                } else if (character == '1'){
                    FileHistory.writeSth("q3 -> q1");
                    actualState = q1;
                }
            } else actualState = start;
            str = str + character;
        } else {
            if(!str.isEmpty()){
                if(actualState == q0){
                    FileStrigs.writeSth(str);
                    System.out.println("Accepted: " + str);
                } else
                    System.out.println("Not accepted " + str);
                str = "";
                actualState = start;
            }
        }
        return actualState;
    }
    
    public void readByKeyboard(String word){
        word = word + " ";
        int lastState = start;
        for(int i=0; i<word.length(); i++)
            lastState = states(word.charAt(i), lastState);
        FileHistory.closeFile();
        FileStrigs.closeFile();
    }
    
    public void readByFile(String path){
        try{
            int lastState =start;
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();
            
            while(character != -1){
                lastState =states((char)character, lastState);
                character = fileReader.read();
            }
            lastState =states((char)character, lastState);
            character = fileReader.read();
            
            fileReader.close();
        } catch(Exception e){
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        FileStrigs.closeFile();
        FileHistory.closeFile();
    }
    
    public boolean isAValidCharacter(char character){
        return (character == (char)48 || character == (char)49);
    }
    
    public String generateBinaryString(){
        String binaryString = "";
        double size = (double)Math.random()*100000+1;
        System.out.println("El sistema eligio una cadena con: " + (int)size + " caracteres");
        for(int i=0; i<= (int)size; i++){
            binaryString = binaryString + (int)Math.rint(Math.random());
        }
        return binaryString;
    }
}
