package endsing.Automaton;

import Files.MyFile;
import java.io.FileReader;

public class Automaton {
    
    private int q0 = 0, q1 = 1, q2 = 2, start = -1;
    private static final String FSTATES = "ing/history.txt", FWORDS = "ing/words.txt";
    private String word = "";
    private MyFile states, words;
    
    public Automaton(){
        words = new MyFile(FWORDS);
        states = new MyFile(FSTATES);
    }
    public int states(char character, int actualState){
        //Is a character of our alphabet 
        if(isAValidCharacter(character)){
            //First state or q0
            if(character == 'i' || character == 'I'){
                if(actualState == start)
                    states.writeSth("start -> q0");
                else if (actualState == q1)
                    states.writeSth("q1 -> q0");
                else if (actualState == q2)
                    states.writeSth("q0 -> start");
                else
                    states.writeSth("q0 -> q0");
                actualState = q0;
            }
            //Second state or q1
            else if((character == 'n' || character == 'N')&& actualState == q0){
                actualState = q1;
                states.writeSth("q0 -> q1");
            }
            //Third state or q2
            else if((character == 'g' || character == 'G')&& actualState == q1){
                actualState = q2;
                states.writeSth("q1 -> q2");
            } else {
                if(actualState == q0)
                    states.writeSth("q0 -> start");
                else if (actualState == q1)
                    states.writeSth("q1 -> start");
                else if (actualState == q2)
                    states.writeSth("q2 -> start");
                else
                    states.writeSth("start -> start");
                actualState = start;
            }
            word = word+character;
        } else {
            if(actualState == q2){
                System.out.println("Accepted -> " + word);
                words.writeSth(word);
            }
            else if(!word.isEmpty())
                System.out.println("Not accepted -> " + word);
            actualState = start;
            word = "";
        }
        return actualState;
    }
    
    //Here I read a string and get words
    public void readByKeyboard(String str){
                
        str = str + " ";
        int lastState = start;
        for(int i=0; i<str.length(); i++)
            lastState = states(str.charAt(i), lastState);
        
        words.closeFile();
        states.closeFile();
    }
    
    public void readByFile(String path){
        try{
            int lastState =start;
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();
            
            while(character != -1){
                lastState = states((char)character, lastState);
                character = fileReader.read();
            }
            lastState = states((char)character, lastState);
            character = fileReader.read();
            
            fileReader.close();
        } catch(Exception e){
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        words.closeFile();
        states.closeFile();
    }
    
    public boolean isAValidCharacter(char character){
        return ((int)character >= 65 && (int)character <=90 || (int)character >= 97 && (int)character <=122);
    }
}
