package turingmachine;

import Files.MyFile;
import java.io.FileReader;

public class Machine {
    
    private MyFile file = new MyFile("Turing Machine/Band.txt");
    private static final String q0 = "q0", q1 = "q1", q2 = "q2", q3 = "q3", q4 = "q4";
    
    private int position = 0;
    private char band[];
    
    public void standardInput(String str, int mode){
        System.out.println("Received:" + str);
        file.writeSth(str);
        str = str.trim();
        str = str + ' '; 
        band = str.toCharArray();
        String actualState = q0;
        for(position = 0; position < str.length(); /**Param unnecessary**/){
            bandToFile();
            actualState = states(actualState, band[position]);
        }
        if(actualState.equals(q4)) 
            file.writeSth("Accepted");
        else file.writeSth("Not accepted");
        
        bandToFile();
        if(mode == 0)
            file.closeFile();
    }
    
    public void readByKeyboard(String str) {
        String combination = "";
        try{
            
            FileReader fileReader = new FileReader(str);
            int character = fileReader.read();
            
            while(character != -1){
                if((char)character == '0' || (char)character == '1')
                    combination+=(char)character;
                else if(!combination.trim().isEmpty()){
                    standardInput(combination, 1);
                    combination = "";
                }
                character = fileReader.read();
            }
            if((char)character == '0' || (char)character == '1')
                    combination+=(char)character;
            else if(!combination.trim().isEmpty()){
                    standardInput(combination, 1);
                    combination = "";
            }
                character = fileReader.read();
        } catch (Exception e){
            System.err.println("Error reading file: " + str + " error " + e);
        } finally {
            file.closeFile();
        }
    }
    
    private String states(String actualState, char symbol){
        String newState = "";
        switch(actualState){
            case q0:
                newState = q0(actualState, symbol);
                break;
            case q1:
                newState = q1(actualState, symbol);
                break;
            case q2:
                newState = q2(actualState, symbol);
                break;
            case q3:
                newState = q3(actualState, symbol);
                break;
            default:
                System.err.println("Nothing todo");
                file.closeFile();
                System.exit(0);
                break;
        }
        
        return newState;
    }
    
    private String q0(String actualState, char symbol){
        String newState = "";
        
        //Change symbol for an X;
        if(symbol == '0'){  
            newState = q1;
            band[position] = 'X';
            toRight();
        } else if(symbol == 'Y'){
            newState = q3;
            band[position] = 'Y';
            toRight();
        } else {
            System.err.println("q0 Cadena inválida");
            file.closeFile();
            System.exit(0);
        }
        file.writeSth(actualState + " - " + symbol + " ->" + newState);
        return newState;
    }
    
    private String q1(String actualState, char symbol){
        String newState = "";
        
        if(symbol == '0'){
            newState = q1;
            //band[position] = '0';
            toRight();
        } else if(symbol == '1'){
            newState = q2;
            band[position] = 'Y';
            toLeft();
        } else if(symbol == 'Y'){
            newState = q1;
            toRight();
        } else {
            System.err.println("q1 Cadena inválida");
            file.closeFile();
            System.exit(0);
        }
        file.writeSth(actualState + " - " + symbol + " ->" + newState);
        return newState;
    }
    
    private String q2(String actualState, char symbol){
        String newState = "";
        
        if(symbol == '0'){
            newState = q2;
            toLeft();
        } else if(symbol == 'X'){
            newState = q0;
            toRight();
        } else if(symbol == 'Y'){
            newState = q2;
            toLeft();
        } else {
            System.out.println("q2 cadena inválida");
            file.closeFile();
            System.exit(0);
        }
        file.writeSth(actualState + " - " + symbol + " ->" + newState);
        return newState;
    }
    
    private String q3(String actualState, char symbol){
        String newState = "";
        
        if(symbol == 'Y'){
            newState = q3;
            toRight();
        } else if(symbol == ' '){
            newState = q4;
            band[position] = 'B';
            toRight();
        } else {
            System.err.println("q3 Cadena inválida");
            file.closeFile();
            System.exit(0);
        }
        file.writeSth(actualState + " - " + symbol + " ->" + newState);
        return newState;
    }
    
    private void toLeft(){
        position -= 1;
    }
    
    private void toRight(){
        position++;
    }
    
    private void  bandToFile(){
        String str = "|";
        for(int i = 0; i < band.length-1; i++)
           str = str +  band[i] + "|";
        file.writeSth(str);
    }
}
