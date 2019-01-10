package Automaton;

import Automaton.SCharacters;
import Files.MyFile;

public class Ack {
    
    private static final String A0 = "A0", A1 = "A1", A2 = "A2", A3 = "A3", A4 = "A4", 
            A5 = "A5", A6 = "A6", A7 = "A7", A8 = "A8", A9 = "A9";
    private static final String B0 = "B0", B1 = "B1", B2 = "B2", B3 = "B3", 
            B4 = "B4", B5 = "B5";
    private static final String C0 = "C0", C1 = "C1", C2 = "C2", C3 = "C3", C4 = "C4", 
            C5 = "C5", C6 = "C6", C7 = "C7", C8 = "C8", C9 = "C9", C10 = "C10", C11 = "C11", 
            C12 = "C12", C13 = "C13", C14 = "C14";
    private static final String D0 = "D0", D1 = "D1", D2 = "D2", D3 = "D3", D4 = "D4", 
            D5 = "D5", D6 = "D6", D7 = "D7", D8 = "D8";
    private static final String E0 = "E0", E1 = "E1", E2 = "E2", E3 = "E3", E4 = "E4", 
            E5 = "E5", E6 = "E6";
    private static final String F0 = "F0", F1 = "F1", F2 = "F2", F3 = "F3", F4 = "F4", 
            F5 = "F5", F6 = "F6", F7 = "F7", F8 = "F8", F9 = "F9", F10 = "F10", F11 = "F11";
    private static final String G0 = "G0", G1 = "G1", G2 = "G2", G3 = "G3", G4 = "G4", 
            G5 = "G5", G6 = "G6", G7 = "G7", G8 = "G8";
    private static final String start = "initial";
    
    private SCharacters special;
    private String wordAccepted = "";
    private MyFile words, history;
    
    private boolean way = false;
    
    
    public Ack(){
        special = new SCharacters();
        words = new MyFile("wordsAck.txt");
        history = new MyFile("historyAck.txt");
    }
    
    public String states(String packet){
        String actualState = start;
        for(int i=0; i<packet.length(); i++)
            actualState = forAS(actualState, packet.charAt(i));
        wordAccepted = "";
        for(int i=0; i<packet.length(); i++)
            actualState = forBS(actualState, packet.charAt(i));
        wordAccepted = "";
        for(int i=0; i<packet.length(); i++)
            actualState = forCS(actualState, packet.charAt(i));
        wordAccepted = "";
        for(int i=0; i<packet.length(); i++)
            actualState = forDS(actualState, packet.charAt(i));
        wordAccepted = "";
        for(int i=0; i<packet.length(); i++)
            actualState = forES(actualState, packet.charAt(i));
        wordAccepted = "";
        for(int i=0; i<packet.length(); i++)
            actualState = forFS(actualState, packet.charAt(i));
        wordAccepted = "";
        for(int i=0; i<packet.length(); i++)
            actualState = forGS(actualState, packet.charAt(i));
            /**
            
            
            
            **/
       words.closeFile();
       history.closeFile();
        return "";
    }
    
    //States for violencia word
    public String forAS(String actualState, char character){
        String newState = "";
        if((character == 'V' || character == 'v') && isInitial(actualState)){
            newState = A0;
            wordAccepted+=character;
        } else if (special.isI(character) && actualState.equals(A0)){
            newState = A1;
            wordAccepted+=character;
        } else if (special.isO(character) && actualState.equals(A1)){
            newState = A2;
            wordAccepted+=character;
        } else if ((character == 'l' || character == 'L') && actualState.equals(A2)){
            newState = A3;
            wordAccepted+=character;
        } else if (special.isE(character) && actualState.equals(A3)){
            newState = A4;
            wordAccepted+=character;
        } else if ((character == 'n' || character == 'N') && actualState.equals(A4)){
            newState = A5;
            wordAccepted+=character;
        } else if ((character == 'c' || character == 'C') && actualState.equals(A5)){
            newState = A6;
            wordAccepted+=character;
        } else if (special.isI(character) && actualState.equals(A6)){
            newState = A7;
            wordAccepted+=character;
        } else if (special.isA(character) && actualState.equals(A7)){//Word is accepted
            newState = A8;
            wordAccepted+=character;
            words.writeSth(wordAccepted);
            wordAccepted = "";
        } else {
            newState = start;
            wordAccepted = "";
        }
        history.writeSth(actualState+ "---"+ character + " --->" + newState);
        return newState;
    }
    
    //States for robar word
    public String forBS(String actualState, char character){
        String newState = "";
        if((character == 'R' || character == 'r') && !actualState.equals(B3)){
            newState = B0;
            wordAccepted+=character;
        } else if(special.isO(character) && actualState.equals(B0)){
            newState = B1;
            wordAccepted+=character;
        } else if((character == 'b' || character == 'B') && actualState.equals(B1)){
            newState = B2;
            wordAccepted+=character;
        } else if(special.isA(character) && actualState.equals(B2)){
            newState = B3;
            wordAccepted+=character;
        } else if((character == 'R' || character == 'r') && actualState.equals(B3)){
            newState = B4;
            wordAccepted+=character;
            words.writeSth(wordAccepted);
            wordAccepted = "";
        }else {
            newState = start;
            wordAccepted = "";
        }
        history.writeSth(actualState+ "---"+ character + " --->" + newState);
        return newState;
    }
    
    public String forCS(String actualState, char character){
        String newState = "";
        if((character == 'c' || character == 'C') && !actualState.equals(C8)){
            newState = C0;
            wordAccepted+=character;
        } else if((special.isO(character)) && (actualState.equals(C0))){
            newState = C1;
            wordAccepted+=character;
        } else if((character == 'p' || character == 'P') && (actualState.equals(C1))){
            newState = C2;
            wordAccepted+=character;
        }  else if((character == 'r' || character == 'R') && (actualState.equals(C1))){
            newState = C2;
            wordAccepted+=character;
        }
        else if((special.isI(character)) && (actualState.equals(C2))){
            newState = C3;
            wordAccepted+=character;
        } else if((special.isA(character)) && (actualState.equals(C3))){
            newState = C4;
            wordAccepted+=character;
        } else if((character == 'r' || character == 'R') && (actualState.equals(C4))){
            newState = C5;
            wordAccepted+=character;
            words.writeSth(wordAccepted);
            wordAccepted = "";
        } else if ((character == 'r' || character == 'R') && (actualState.equals(C2))){
            newState = C6;
            wordAccepted+=character;
        } else if ((special.isU(character)) && (actualState.equals(C6))){
            newState = C7;
            wordAccepted+=character;
        } else if ((character == 'p' || character == 'P') && (actualState.equals(C7))){
            newState = C8;
            wordAccepted+=character;
        } else if ((character == 'c' || character == 'C') && (actualState.equals(C8))){
            newState = C9;
            wordAccepted+=character;
        } else if ((special.isI(character)) && (actualState.equals(C9))){
            newState = C10;
            wordAccepted+=character;
        } else if ((special.isO(character)) && (actualState.equals(C10))){
            newState = C11;
            wordAccepted+=character;
        } else if ((character == 'n' || character == 'N') && (actualState.equals(C11))){
            newState = C12;
            wordAccepted+=character;
            words.writeSth(wordAccepted);
            wordAccepted = "";
        } else {
            newState = start;
            wordAccepted = "";
        }
        history.writeSth(actualState+ "---"+ character + " --->" + newState);
        return newState;
    }
    
    public String forDS(String actualState, char character){
        String newState = "";
        if(special.isE(character) && isInitial(actualState)){
            newState = D0;
            wordAccepted += character;
        } else if((character == 'n' || character == 'N') && actualState.equals(D0)) {
            newState = D1;
            wordAccepted += character;
        } else if((character == 'g' || character == 'G') && actualState.equals(D1)) {
            newState = D2;
            wordAccepted += character;
        } else if((special.isA(character)) && actualState.equals(D2)) {
            newState = D3;
            wordAccepted += character;
        } else if((character == 'ñ' || character == 'Ñ') && actualState.equals(D3)) {
            newState = D4;
            wordAccepted += character;
        } else if((special.isO(character)) && actualState.equals(D4)) {
            newState = D5;
            wordAccepted += character;
            words.writeSth(wordAccepted);
        } else if((special.isA(character)) && actualState.equals(D4)){
            newState = D6;
            wordAccepted += character;
        } else if ((character == 'r' || character == 'R') && actualState.equals(D6)) {
            newState = D7;
            wordAccepted += character;
            words.writeSth(wordAccepted);
            wordAccepted = "";
        }else {
            wordAccepted = "";
            newState = start;
        }
        history.writeSth(actualState+ "---"+ character + " --->" + newState);
        return newState;
    }
    
    public String forES(String actualState, char character){
        String newState = "";
        if((character == 'm' || character == 'M') && isInitial(actualState)){
            newState = E0;
            wordAccepted += character;
        } else if ((special.isI(character)) && actualState.equals(E0)) {
            newState = E1;
            wordAccepted += character;
        } else if ((character == 'n' || character == 'N') && actualState.equals(E1)) {
            newState = E2;
            wordAccepted += character;
        } else if ((character == 't' || character == 'T') && actualState.equals(E2)) {
            newState = E3;
            wordAccepted += character;
        } else if ((special.isI(character)) && actualState.equals(E3)) {
            newState = E4;
            wordAccepted += character;
        } else if ((character == 'r' || character == 'R') && actualState.equals(E4)) {
            newState = E5;
            wordAccepted += character;
            words.writeSth(wordAccepted);
            wordAccepted = "";
        }else {
            newState = start;
            wordAccepted = "";
        }
        history.writeSth(actualState+ "---"+ character + " --->" + newState);
        return newState;
    }
    
    public String forFS(String actualState, char character){
        String newState = "";
        if((character == 'f' || character == 'F') && isInitial(actualState)){
            newState = F0;
            wordAccepted += character;
        } else if ((special.isA(character)) && actualState.equals(F0)){
            newState = F1;
            wordAccepted += character;
        } else if ((character == 'l' || character == 'L') && actualState.equals(F1)){
            newState = F2;
            wordAccepted += character;
        } else if ((special.isO(character)) && actualState.equals(F2)){
            newState = F3;
            wordAccepted += character;
        } else if ((special.isI(character)) && actualState.equals(F2)){
            newState = F4;
            wordAccepted += character;
        } else if ((character == 'f' || character == 'F') && actualState.equals(F4)){
            newState = F5;
            wordAccepted += character;
        } else if ((special.isI(character)) && actualState.equals(F5)){
            newState = F6;
            wordAccepted+= character;
        } else if ((character == 'c' || character == 'C') && actualState.equals(F6)){
            newState = F7;
            wordAccepted += character;
        } else if ((special.isA(character)) && actualState.equals(F7)){
            newState = F8;
            wordAccepted += character;
        } else if ((character == 'r' || character == 'R') && actualState.equals(F8)){
            newState = F9;
            wordAccepted += character;
            words.writeSth(wordAccepted);
            wordAccepted = "";
        }else{
            newState = start;
            wordAccepted = "";
        }
        history.writeSth(actualState+ "---"+ character + " --->" + newState);
        return newState;
    }
    
    public String forGS (String actualState, char character){
        String newState = "";
        if((character == 't' || character == 'T') && isInitial(actualState)){
            newState = G0;
            wordAccepted += character;
        } else if((special.isA(character)) && actualState.equals(G0)){
            newState = G1;
            wordAccepted += character;
        } else if((character == 'r' || character == 'R') && actualState.equals(G1)){
            newState = G2;
            wordAccepted += character;
        } else if((special.isA(character)) && actualState.equals(G2)){
            newState = G3;
            wordAccepted += character;
        } else if((character == 'f' || character == 'F') && actualState.equals(G3)){
            newState = G4;
            wordAccepted += character;
        } else if((special.isI(character)) && actualState.equals(G4)){
            newState = G5;
            wordAccepted += character;
        } else if((character == 'c' || character == 'C') && actualState.equals(G5)){
            newState = G6;
            wordAccepted += character;
        } else if((special.isA(character)) && actualState.equals(G6)){
            newState = G7;
            wordAccepted += character;
        } else if((character == 'r' || character == 'R') && actualState.equals(G7)){
            newState = G8;
            wordAccepted += character;
        } else {
            newState = start;
            wordAccepted = "";
        }
        history.writeSth(actualState+ "---"+ character + " --->" + newState);
        return newState;
    }
    
    public boolean isInitial(String actualState){
        /**return (actualState.equals(A0) || actualState.equals(B0) || actualState.equals(C0) || 
                actualState.equals(D0) || actualState.equals(E0) || actualState.equals(F0) || 
                actualState.equals(G0) || actualState.equals(start));**/
        return true;
    }
}
