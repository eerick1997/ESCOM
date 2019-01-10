package Protocol.Automaton;

import forCharacters.ACharacter;
import Files.MyFile;

public class Ack {

    private static final String A0 = "A0", A1 = "A1", A2 = "A2", A3 = "A3", A4 = "A4",
            A5 = "A5", A6 = "A6", A7 = "A7", A8 = "A8";
    private static final String B0 = "B0", B1 = "B1", B2 = "B2", B3 = "B3",
            B4 = "B4";
    private static final String C0 = "C0", C1 = "C1", C2 = "C2", C3 = "C3", C4 = "C4",
            C5 = "C5", C6 = "C6", C7 = "C7", C8 = "C8", C9 = "C9", C10 = "C10", C11 = "C11",
            C12 = "C12", C13 = "C13";
    private static final String D0 = "D0", D1 = "D1", D2 = "D2", D3 = "D3", D4 = "D4",
            D5 = "D5", D6 = "D6", D7 = "D7";
    private static final String E0 = "E0", E1 = "E1", E2 = "E2", E3 = "E3", E4 = "E4",
            E5 = "E5";
    private static final String F0 = "F0", F1 = "F1", F2 = "F2", F3 = "F3", F4 = "F4",
            F5 = "F5", F6 = "F6", F7 = "F7", F8 = "F8", F9 = "F9", F10 = "F10";
    private static final String G0 = "G0", G1 = "G1", G2 = "G2", G3 = "G3", G4 = "G4",
            G5 = "G5", G6 = "G6", G7 = "G7";
    private static final String start = "initial";

    private static final String file_words_ack = "protocol/words_from_ack.txt", file_words_history = "protocol/history_from_ack.txt";

    private ACharacter isCharacter;
    private String wordAccepted = "", runningAckState = start;
    private MyFile words, history;

    public Ack() {
        isCharacter = new ACharacter();
        words = new MyFile(file_words_ack);
        history = new MyFile(file_words_history);
    }

    public void searchAWord(String _package) {
        for (int i = 0; i < _package.length(); i++) {
            runningAckState = AStates(runningAckState, _package.charAt(i));
            if (runningAckState.equals(A8) || runningAckState.equals(B4) || runningAckState.equals(C5)
                    || runningAckState.equals(C13) || runningAckState.equals(D7) || runningAckState.equals(D5)
                    || runningAckState.equals(E5) || runningAckState.equals(F4) || runningAckState.equals(F10)
                    || runningAckState.equals(G7)) {
                System.out.println("I find the word: " + wordAccepted);
                words.writeSth(wordAccepted);
            }
        }
    }

    //Violencia
    public String AStates(String actualState, char character) {
        String newState = "";
        if (isCharacter.isV(character)) {
            cleanWordAccepted();
            newState = A0;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(A0)) {
            newState = A1;
            wordAccepted += character;
        } else if (isCharacter.isO(character) && actualState.equals(A1)) {
            newState = A2;
            wordAccepted += character;
        } else if (isCharacter.isL(character) && actualState.equals(A2)) {
            newState = A3;
            wordAccepted += character;
        } else if (isCharacter.isE(character) && actualState.equals(A3)) {
            newState = A4;
            wordAccepted += character;
        } else if (isCharacter.isN(character) && actualState.equals(A4)) {
            newState = A5;
            wordAccepted += character;
        } else if (isCharacter.isC(character) && actualState.equals(A5)) {
            newState = A6;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(A6)) {
            newState = A7;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(A7)) {
            newState = A8;
            wordAccepted += character;
        } else {
            newState = BStates(actualState, character);
        }
        history.writeSth(actualState + "---" + character + "--->" + newState);
        return newState;
    }

    //Robar
    public String BStates(String actualState, char character) {
        String newState = "";
        if (isCharacter.isR(character) && !actualState.equals(B3) && !actualState.equals(C4)
                && !actualState.equals(C1) && !actualState.equals(C6) && !actualState.equals(D6)
                && !actualState.equals(E4) && !actualState.equals(F9) && !actualState.equals(G0)
                && !actualState.equals(G6)) {
            cleanWordAccepted();
            newState = B0;
            wordAccepted += character;
        } else if (isCharacter.isO(character) && actualState.equals(B0)) {
            newState = B1;
            wordAccepted += character;
        } else if (isCharacter.isB(character) && actualState.equals(B1)) {
            newState = B2;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(B2)) {
            newState = B3;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(B3)) {
            newState = B4;
            wordAccepted += character;
        } else {
            newState = CStates(actualState, character);
        }
        return newState;
    }

    //Copiar & Corrupción
    public String CStates(String actualState, char character) {
        String newState = "";
        if (isCharacter.isC(character) && !actualState.equals(C9) && !actualState.equals(F7)
                && !actualState.equals(G4)) {
            cleanWordAccepted();
            newState = C0;
            wordAccepted += character;
        } else if (isCharacter.isO(character) && actualState.equals(C0)) {
            newState = C1;
            wordAccepted += character;
        } else if (isCharacter.isP(character) && actualState.equals(C1)) {
            newState = C2;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(C2)) {
            newState = C3;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(C3)) {
            newState = C4;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(C4)) {
            newState = C5;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(C1)) { //rrupcion
            newState = C6;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(C6)) {
            newState = C7;
            wordAccepted += character;
        } else if (isCharacter.isU(character) && actualState.equals(C7)) {
            newState = C8;
            wordAccepted += character;
        } else if (isCharacter.isP(character) && actualState.equals(C8)) {
            newState = C9;
            wordAccepted += character;
        } else if (isCharacter.isC(character) && actualState.equals(C9)) {
            newState = C10;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(C10)) {
            newState = C11;
            wordAccepted += character;
        } else if (isCharacter.isO(character) && actualState.equals(C11)) {
            newState = C12;
            wordAccepted += character;
        } else if (isCharacter.isN(character) && actualState.equals(C12)) {
            newState = C13;
            wordAccepted += character;
        } else {
            newState = DStates(actualState, character);
        }
        return newState;
    }

    //Engaño & Engañar  
    public String DStates(String actualState, char character) {
        String newState = "";
        if (isCharacter.isE(character) && !actualState.equals(E0)) {
            cleanWordAccepted();
            newState = D0;
            wordAccepted += character;
        } else if (isCharacter.isN(character) && actualState.equals(D0)) {
            newState = D1;
            wordAccepted += character;
        } else if (isCharacter.isG(character) && actualState.equals(D1)) {
            newState = D2;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(D2)) {
            newState = D3;
            wordAccepted += character;
        } else if (isCharacter.isÑ(character) && actualState.equals(D3)) {
            newState = D4;
            wordAccepted += character;
        } else if (isCharacter.isO(character) && actualState.equals(D4)) {
            newState = D5;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(D4)) { //ar
            newState = D6;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(D6)) {
            newState = D7;
            wordAccepted += character;
        } else {
            newState = EStates(actualState, character);
        }
        return newState;
    }

    //Mentir
    public String EStates(String actualState, char character) {
        String newState = "";
        if (isCharacter.isM(character)) {
            cleanWordAccepted();
            newState = E0;
            wordAccepted += character;
        } else if (isCharacter.isE(character) && actualState.equals(E0)) {
            newState = E1;
            wordAccepted += character;
        } else if (isCharacter.isN(character) && actualState.equals(E1)) {
            newState = E2;
            wordAccepted += character;
        } else if (isCharacter.isT(character) && actualState.equals(E2)) {
            newState = E3;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(E3)) {
            newState = E4;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(E4)) {
            newState = E5;
            wordAccepted += character;
        } else {
            newState = FStates(actualState, character);
        }
        return newState;
    }

    //Falso r& Falsificar
    public String FStates(String actualState, char character) {
        String newState = "";
        if (isCharacter.isF(character) && !actualState.equals(F5) && !actualState.equals(G2)) {
            cleanWordAccepted();
            newState = F0;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(F0)) {
            newState = F1;
            wordAccepted += character;
        } else if (isCharacter.isL(character) && actualState.equals(F1)) {
            newState = F2;
            wordAccepted += character;
        } else if (isCharacter.isS(character) && actualState.equals(F2)) {
            newState = F3;
            wordAccepted += character;
        } else if (isCharacter.isO(character) && actualState.equals(F3)) {
            newState = F4;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(F3)) { //ificar
            newState = F5;
            wordAccepted += character;
        } else if (isCharacter.isF(character) && actualState.equals(F5)) {
            newState = F6;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(F6)) {
            newState = F7;
            wordAccepted += character;
        } else if (isCharacter.isC(character) && actualState.equals(F7)) {
            newState = F8;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(F8)) {
            newState = F9;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(F9)) {
            newState = F10;
            wordAccepted += character;
        } else {
            newState = GStates(actualState, character);
        }
        return newState;
    }

    //Traficar
    public String GStates(String actualState, char character) {
        String newState = "";
        if (isCharacter.isT(character)) {
            cleanWordAccepted();
            newState = G0;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(G0)) {
            newState = G1;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(G1)) {
            newState = G2;
            wordAccepted += character;
        } else if (isCharacter.isF(character) && actualState.equals(G2)) {
            newState = G3;
            wordAccepted += character;
        } else if (isCharacter.isI(character) && actualState.equals(G3)) {
            newState = G4;
            wordAccepted += character;
        } else if (isCharacter.isC(character) && actualState.equals(G4)) {
            newState = G5;
            wordAccepted += character;
        } else if (isCharacter.isA(character) && actualState.equals(G5)) {
            newState = G6;
            wordAccepted += character;
        } else if (isCharacter.isR(character) && actualState.equals(G6)) {
            newState = G7;
            wordAccepted += character;
        } else {
            newState = start;
            wordAccepted = "";
        }
        return newState;
    }

    public void cleanWordAccepted() {
        if (!wordAccepted.isEmpty()) {
            wordAccepted = "";
        }
    }

    public MyFile getWords() {
        return words;
    }

    public MyFile getHistory() {
        return history;
    }
}
