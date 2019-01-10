package Automaton;

public class SCharacters {
    
    public boolean isA(char character){
        return(character == 'a' || character == 'á' || character == 'ä' || character == 'â'
                || character == 'A' || character == 'Á' || character == 'Ä' || character == 'Â');
    }
    
    public boolean isE(char character){
        return(character == 'e' || character == 'é' || character == 'ë' || character == 'ê' 
                || character == 'E' || character == 'É' || character == 'Ë' || character == 'Ê');
    }
    
    public boolean isI(char character){
        return(character == 'i' || character == 'í' || character == 'ï' || character == 'î'
                || character == 'I' || character == 'Í' || character == 'Ï' || character == 'Î');
    }
    
    public boolean isO(char character){
        return(character == 'o' || character == 'ó' || character == 'ö' || character == 'ô'
                || character == 'O' || character == 'Ó' || character == 'Ö' || character == 'Ô');
    }
    
    public boolean isU(char character){
        return(character == 'u' || character == 'ú' || character == 'ü' || character == 'û' 
                || character == 'U' || character == 'Ú' || character == 'Ü' || character == 'Û' );
    }
}
