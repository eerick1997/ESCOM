package webay.Automata;

import webay.Files.MyFile;
import java.io.FileReader;

public class Automata {
    
    String strWeb = "", strEbay = "";
    int numberWEB = 0, numberEBAY = 0;

    private MyFile transitions, words;

    //Creation of an Alphabet object
    private Alphabet alphabet = new Alphabet();

    //Here I use constants and q0 is our initial state and q7 is final state
    private static final String q0 = "q0", q1 = "q1", q2 = "q2",
            q3 = "q3", q4 = "q4", q5 = "q5", q6 = "q6", q7 = "q7";

    public Automata(MyFile transitions, MyFile words) {
        this.transitions = transitions;
        this.words = words;
    }

    public String states(char character, String actualState, int NLine, int NWord) {

        switch (actualState) {
            case q0:
                actualState = q0(character, actualState);
                break;

            case q1:
                actualState = q1(character, actualState);
                break;

            case q2:
                actualState = q2(character, actualState);
                break;

            case q3:
                actualState = q3(character, actualState);
                break;

            case q4:
                actualState = q4(character, actualState);
                break;

            case q5:
                actualState = q5(character, actualState);
                break;

            case q6:

                actualState = q6(character, actualState);
                break;

            case q7:
                actualState = q7(character, actualState);
                break;

            default:
                System.out.println("Invalid character");
                actualState = q0;
                break;
        }

        if (actualState.equals(q3)) {
            numberWEB++;
            words.writeSth(strWeb + " is the word number " + (NWord + 1) + " in line number " + (NLine + 1));
        } else if (actualState.equals(q7)) {
            numberEBAY++;
            words.writeSth(strEbay + " is the word number " + (NWord + 1) + " in line number " + (NLine + 1));
        }
        return actualState;
    }

    public void readFile(String path) {
        try {
            int line = 0, word = 0;
            String actualState = q0;
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();

            while (character != -1) {

                if (character == '\n') 
                    line++;
                
                if (character == 32) 
                    word++;
                
                actualState = states((char) character, actualState, line, word);
                character = fileReader.read();

            }

            if (character == '\r' || character == '\n') {
                line++;
            }
            if (character == 32) {
                word++;
            }

            actualState = states((char) character, actualState, line, word);
            character = fileReader.read();

            fileReader.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        words.writeSth("I found the word WEB: " + numberWEB + " times and the word EBAY " + numberEBAY + " times");
        transitions.closeFile();
        words.closeFile();
    }

    public void standardInput(String str) {
        String actualState = q0;
        str = str.trim();
        int line = 0, word = 0;
        
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '\r' || str.charAt(i) == '\n') {
                line++;
            }
            if (str.charAt(i) == 32) {
                word++;
            }

            actualState = states(str.charAt(i), actualState, line, word);
        }
        words.writeSth("I found " + numberWEB + " times and " + numberEBAY + " times");
        transitions.closeFile();
        words.closeFile();
    }

    //State q0 for all the alphabet less e and w
    public String q0(char character, String actualState) {
        String newState = "";
        strEbay = "";
        strWeb = "";

        //The character is W so I move to q1
        if (alphabet.isW(character)) {
            newState = q1;
            strWeb += character;
            //The character is E so I move to q2
        } else if (alphabet.isE(character)) {
            newState = q4;
            strEbay += character;
            //The character is neither W nor E so
            //I need to keep in q0
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }

    //Last character was W of word WEB
    public String q1(char character, String actualState) {
        String newState = "";

        //The character is W so I keep in q1
        if (alphabet.isW(character)) {
            newState = q1;
            strWeb = "";
            strWeb += character;

            //The character is E so I move to q2
        } else if (alphabet.isE(character)) {
            newState = q2;
            strWeb += character;

            strEbay += "";
            strEbay += character;
            //The character is neither W nor E so
            //I need to return to q0
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }

    //Last character was E of word WEB
    public String q2(char character, String actualState) {
        String newState = "";

        //The character is B so I move to q3
        if (alphabet.isB(character)) {
            newState = q3;
            strWeb += character;
            strEbay += character;
            //The character is W so I return to q1
        } else if (alphabet.isW(character)) {
            newState = q1;
            strWeb = "";
            strWeb += character;

            strEbay = "";
            //The character is E so I move to q4
        } else if (alphabet.isE(character)) {
            newState = q4;
            strEbay = "";
            strEbay += character;

            strWeb = "";
            //The character is neither B nor W nor E
            //so I return to q0
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }

    //Last character was B of word WEB
    public String q3(char character, String actualState) {
        String newState = "";
        //Character is W so I return to q1
        if (alphabet.isW(character)) {
            newState = q1;
            strWeb = "";
            strWeb += character;

            strEbay = "";
            //Character is E so I move to q4
        } else if (alphabet.isE(character)) {
            newState = q4;
            strWeb = "";
            strEbay = "";
            strEbay += character;
            //Character is A so I move to q6
        } else if (alphabet.isA(character)) {
            newState = q6;

            strEbay += character;
            strWeb = "";
            //Character is neither E nor A nor W
            //so I return to q0
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }

    //Last character was E of word EBAY
    public String q4(char character, String actualState) {
        String newState = "";

        //The character is B so I move to q5
        if (alphabet.isB(character)) {
            newState = q5;
            strEbay += character;
            strWeb = "";
            //Character is E so I keep in q4
        } else if (alphabet.isE(character)) {
            newState = q4;
            strEbay = "";
            strEbay += character;

            strWeb = "";
            //Character is W so I move to q1
        } else if (alphabet.isW(character)) {
            newState = q1;
            strEbay = "";
            strWeb = "";
            strWeb += character;
            //Character is neither B nor E nor W
            //So I return to q0
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }

    //Last character was B of word EBAY
    public String q5(char character, String actualState) {
        String newState = "";
        //Character is W so I move to q1
        if (alphabet.isW(character)) {
            newState = q1;
            strWeb = "";
            strWeb += character;

            strEbay = "";
            //Character is E so I return to q4
        } else if (alphabet.isE(character)) {
            newState = q4;

            strWeb = "";
            strEbay = "";
            strEbay += character;
            //Character is A so I move to q6
        } else if (alphabet.isA(character)) {
            newState = q6;
            strEbay += character;
            strWeb = "";
            //Character is neither W nor E nor A
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }

    //Last chracter was A of word EBAY
    public String q6(char character, String actualState) {
        String newState = "";

        //Character is W so I move to q1
        if (alphabet.isW(character)) {
            newState = q1;
            strWeb = "";
            strWeb += character;

            //Character is E so I return to q4
        } else if (alphabet.isE(character)) {
            newState = q4;
            strWeb = "";
            strEbay = "";
            strEbay += character;

            //Character is Y so I move to q7
        } else if (alphabet.isY(character)) {
            newState = q7;
            strWeb = "";
            strEbay += character;
            //Character is neither W nor W nor Y
            //So I return to q0
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }

    //Last character was Y of word EBAY
    public String q7(char character, String actualState) {
        String newState = "";
        //Character is W so I move to q1
        if (alphabet.isW(character)) {
            newState = q1;
            strWeb = "";
            strWeb += character;
            strEbay = "";
            //Character is E so I return to q4
        } else if (alphabet.isE(character)) {
            newState = q4;
            strWeb = "";
            strEbay = "";
            strEbay += character;
            //Character is neither E nor W
            //So I return to q0
        } else {
            newState = q0;
        }
        transitions.writeSth(actualState + "--" + character + " ->" + newState);
        return newState;
    }
}
