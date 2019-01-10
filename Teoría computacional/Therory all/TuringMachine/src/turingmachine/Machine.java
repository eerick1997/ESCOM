package turingmachine;

public class Machine {
    
    private static final String q0 = "q0", q1 = "q1", q2 = "q2", q3 = "q3", q4 = "q4";
    
    private String pointer[];
    private int position = 0;
    private char band[];
    
    public void standardInput(String str){
        System.out.println("Received: " + str);
        str = str.trim();
        str = str + ' '; 
        band = str.toCharArray();
        pointer = new String[str.length()];
        String actualState = q0;
        for(position = 0; position < str.length(); /**Param unnecessary**/){
            printBand();
            actualState = states(actualState, band[position]);
        }
        
        printBand();
    }
    
    private String states(String actualState, char symbol){
        System.out.println("turingmachine.Machine.states() " + actualState + " char " + symbol + " position " + position);
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
            case q4:
                //String accepted
                q4(actualState, symbol);
                break;
            default:
                System.err.println("Nothing todo");
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
            System.exit(0);
        }
        
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
            System.exit(0);
        }
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
            System.err.println("q2 Cadena inválida symbol " + symbol + " position band " + position);
            System.exit(0);
        }
        return newState;
    }
    
    private String q3(String actualState, char symbol){
        String newState = "";
        
        if(symbol == 'Y'){
            newState = q3;
            toRight();
        } else if(symbol == ' '){
            newState = q4;
            band[position] = ' ';
            toRight();
        } else {
            System.err.println("q3 Cadena inválida");
            System.exit(0);
        }
        
        return newState;
    }
    
    //Final state, string accepted
    private void q4(String actualState, char symbol){
        System.out.println("Accepted");
    }
    
    private void toLeft(){
        position -= 1;
        pointer[position] = "*";
    }
    
    private void toRight(){
        position++;
        //pointer[position] = "*";
    }
    
    private void printBand(){
        for(int i = 0; i < band.length-1; i++){
            System.out.print("|" + band[i] + "|");
            
        }
        System.out.println("");
    }
    
}
