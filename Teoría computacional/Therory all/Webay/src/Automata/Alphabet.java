package Automata;


public class Alphabet {
    
    /**This function return true if the character is part of
     our alphabet**/
    public boolean isPart(char character){
        return (((int)character >= 65 || (int)character <= 90) && ((int)character > 97 || (int)character <= 122 ));
    }
    
    public boolean isA(char character) {
        return (character == 'a' || character == 'á' || character == 'ä' || character == 'â'
                || character == 'A' || character == 'Á' || character == 'Ä' || character == 'Â');
    }

    public boolean isB(char character) {
        return (character == 'b' || character == 'B');
    }

    public boolean isC(char character) {
        return (character == 'c' || character == 'C');
    }

    public boolean isD(char character) {
        return (character == 'd' || character == 'D');
    }

    public boolean isE(char character) {
        return (character == 'e' || character == 'é' || character == 'ë' || character == 'ê'
                || character == 'E' || character == 'É' || character == 'Ë' || character == 'Ê');
    }

    public boolean isF(char character) {
        return (character == 'f' || character == 'F');
    }

    public boolean isG(char character) {
        return (character == 'g' || character == 'G');
    }

    public boolean isH(char character) {
        return (character == 'h' || character == 'H');
    }

    public boolean isI(char character) {
        return (character == 'i' || character == 'í' || character == 'ï' || character == 'î'
                || character == 'I' || character == 'Í' || character == 'Ï' || character == 'Î');
    }

    public boolean isJ(char character) {
        return (character == 'j' || character == 'J');
    }

    public boolean isK(char character) {
        return (character == 'k' || character == 'K');
    }

    public boolean isL(char character) {
        return (character == 'l' || character == 'L');
    }

    public boolean isM(char character) {
        return (character == 'm' || character == 'M');
    }

    public boolean isN(char character) {
        return (character == 'n' || character == 'N');
    }

    public boolean isÑ(char character) {
        return (character == 'ñ' || character == 'Ñ');
    }

    public boolean isO(char character) {
        return (character == 'o' || character == 'ó' || character == 'ö' || character == 'ô'
                || character == 'O' || character == 'Ó' || character == 'Ö' || character == 'Ô');
    }

    public boolean isP(char character) {
        return (character == 'p' || character == 'P');
    }

    public boolean isQ(char character) {
        return (character == 'q' || character == 'Q');
    }

    public boolean isR(char character) {
        return (character == 'r' || character == 'R');
    }

    public boolean isS(char character) {
        return (character == 's' || character == 'S');
    }

    public boolean isT(char character) {
        return (character == 't' || character == 'T');
    }

    public boolean isU(char character) {
        return (character == 'u' || character == 'ú' || character == 'ü' || character == 'û'
                || character == 'U' || character == 'Ú' || character == 'Ü' || character == 'Û');
    }

    public boolean isV(char character) {
        return (character == 'v' || character == 'V');
    }

    public boolean isW(char character) {
        return (character == 'w' || character == 'W');
    }

    public boolean isX(char character) {
        return (character == 'x' || character == 'X');
    }

    public boolean isY(char character) {
        return (character == 'y' || character == 'Y');
    }

    public boolean isZ(char character) {
        return (character == 'z' || character == 'Z');
    }
}
