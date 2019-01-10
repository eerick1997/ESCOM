package Chess.forAutomaton;

import Chess.forFiles.MyFiles;


public class Automaton {

    private static final String q1 = "q1", q2 = "q2", q3 = "q3", q4 = "q4", q5 = "q5",
            q6 = "q6", q7 = "q7", q8 = "q8", q9 = "q9";

    private Path path;
    private MyFiles acceptedPath, transitions;

    public Automaton(Path path, String actualState, MyFiles acceptedPath, MyFiles transitions, String string, int index) {
        this.path = path;
        this.acceptedPath = acceptedPath;
        this.transitions = transitions;

        standardInput(string, index, actualState);
    }

    public void standardInput(String str, int index, String actualState) {
        for (int i = index; i < str.length() && !(index > str.length()); i++) {
            actualState = states(str.charAt(i), actualState, str, i);
        }
        transitions.writeSth(path.getPath());
        if (actualState.equals(q9)) {
            acceptedPath.writeSth(path.getPath());
        }
    }

    public String states(char character, String initialState, String str, int index) {
        switch (initialState) {
            case q1:
                initialState = q1(character, initialState, str, index);
                break;
            case q2:
                initialState = q2(character, initialState, str, index);
                break;
            case q3:
                initialState = q3(character, initialState, str, index);
                break;
            case q4:
                initialState = q4(character, initialState, str, index);
                break;
            case q5:
                initialState = q5(character, initialState, str, index);
                break;
            case q6:
                initialState = q6(character, initialState, str, index);
                break;
            case q7:
                initialState = q7(character, initialState, str, index);
                break;
            case q8:
                initialState = q8(character, initialState, str, index);
                break;
            case q9:
                initialState = q9(character, initialState, str, index);
                break;
        }
        return initialState;
    }

    public String q1(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        Path auxPath = new Path();
        String newState = "";
        switch (character) {
            case 'b'://black
                //I can go just to q5
                path.addMove(q5);
                newState = q5;
                break;
            case 'r'://red
                //I can go to q2 and q4
                
                //using the state q4
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q4);
                newState = q4;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Here I continue the process but
                //using the state q2
                path.addMove(q2);
                newState = q2;

                break;
            default:
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q2(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        Path auxPath = new Path();
        String newState = "";
        switch (character) {
            case 'b'://black
                //I can go to q1 or q3 or q5

                //Code for q5;
                auxPath.copyPath(path.getPath());
                newState = q5;
                auxPath.addMove(q5);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q3
                auxPath.copyPath(path.getPath());
                newState = q3;
                auxPath.addMove(q3);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q1
                newState = q1;
                path.addMove(q1);

                break;
            case 'r'://red
                //I can go to q4 or q6

                //Code for q6
                auxPath.copyPath(path.getPath());
                newState = q6;
                auxPath.addMove(q6);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q4
                path.addMove(q4);
                newState = q4;

                break;
            default:
                //Invalid character
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q3(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        String newState = "";
        Path auxPath = new Path();
        switch (character) {
            case 'b'://black
                //I can go to q5
                path.addMove(q5);
                newState = q5;

                break;
            case 'r'://red
                //I can go to q2 or q6

                //Code for q6
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q6);
                newState = q6;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q2
                newState = q2;
                path.addMove(q2);
                break;
            default:
                //Invalid character
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q4(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        String newState = "";
        Path auxPath = new Path();

        switch (character) {
            case 'b'://black
                //I can go to q1 or q5 or q7

                //Code for q7
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q7);
                newState = q7;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q5
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q5);
                newState = q5;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q1
                path.addMove(q1);
                newState = q1;

                break;
            case 'r'://red
                //I can go to q2 or q8

                //Code for q8
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q8);
                newState = q8;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q2
                path.addMove(q2);
                newState = q2;
                
                break;
            default:
                //Invalid character
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q5(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        Path auxPath = new Path();
        String newState = "";
        switch (character) {
            case 'b'://black
                //I can go to q1 or q3 or q7 or q9

                //Code for q9
                auxPath.copyPath(path.getPath());
                newState = q9;
                auxPath.addMove(q9);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q7
                auxPath.copyPath(path.getPath());
                newState = q7;
                auxPath.addMove(q7);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q3
                auxPath.copyPath(path.getPath());
                newState = q3;
                auxPath.addMove(q3);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q1
                path.addMove(q1);
                newState = q1;
                break;
            case 'r'://red
                //I can go to q2 or q4 or q6 or q8

                //Code for q8
                auxPath.copyPath(path.getPath());
                newState = q8;
                auxPath.addMove(q8);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q6
                auxPath.copyPath(path.getPath());
                newState = q6;
                auxPath.addMove(q6);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q4
                auxPath.copyPath(path.getPath());
                newState = q4;
                auxPath.addMove(q4);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q2
                path.addMove(q2);
                newState = q2;

                break;
            default:
                //Invalid character
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q6(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        Path auxPath = new Path();
        String newState = "";
        switch (character) {
            case 'b'://black
                //I can go to q3 or q5 or q9
                
                //Code for q9
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q9);
                newState = q9;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q5
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q5);
                newState = q5;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q3
                path.addMove(q3);
                newState = q3;

                break;
            case 'r'://red
                //I can go to q2 or q8
                auxPath.copyPath(path.getPath());
                newState = q8;
                auxPath.addMove(q8);
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                path.addMove(q2);
                newState = q2;

                break;
            default:
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q7(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        Path auxPath = new Path();
        String newState = "";

        switch (character) {
            case 'b'://black
                //I can go to q5
                path.addMove(q5);
                newState = q5;
                break;
            case 'r'://red
                //I can go to q4 or q8

                //Code q8
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q8);
                newState = q8;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q4;
                path.addMove(q4);
                newState = q4;
                break;
            default:
                //Invalid character
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q8(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        Path auxPath = new Path();
        String newState = "";
        switch (character) {
            case 'b'://black
                //I can go to q5 or q7 or q9

                //Code for q9
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q9);
                newState = q9;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q7
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q7);
                newState = q7;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q5
                path.addMove(q5);
                newState = q5;

                break;
            case 'r'://red
                //I can go to q4 or q6
                //Code for q6
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q6);
                newState = q6;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q4
                path.addMove(q4);
                newState = q4;

                break;
            default:
                //Invalid character
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }

    public String q9(char character, String actualState, String str, int index) {
        int auxIndex = index + 1;
        Path auxPath = new Path();
        String newState = "";
        switch (character) {
            case 'b'://black
                //I can go to q5
                path.addMove(q5);
                newState = q5;

                break;
            case 'r'://red
                //I can go to q6 or q8

                //Code for q8
                auxPath.copyPath(path.getPath());
                auxPath.addMove(q8);
                newState = q8;
                new Automaton(auxPath, newState, acceptedPath, transitions, str, auxIndex);

                //Code for q6
                path.addMove(q6);
                newState = q6;

                break;
            default:
                //Invalid character
                path.initialize();
                newState = q1;
                break;
        }
        return newState;
    }
}
