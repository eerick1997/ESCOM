package cgf;

public class expression {
   
    
    private String process = "B", ruleSelected = "";
    String DRfB[] = {"(RB", "e"}, DRfR[] = {")","(RR"};
    
    public expression(String strParentheses){
        System.out.println(strParentheses);
        strParentheses += " ";  
        for(int i = 0; i < strParentheses.length(); i++){
            char character = strParentheses.charAt(i);
           int positionSymbol = positionFirstCharacter();
           
           if(positionSymbol >= 0){
            if(character == '('){

                if(process.charAt(positionSymbol) == 'B'){
                    ruleSelected = DRfB[0];
                    process = process.replaceFirst("B", ruleSelected);
                } else if (process.charAt(positionSymbol) == 'R'){
                    ruleSelected = DRfR[1];
                    process = process.replaceFirst("R", ruleSelected);
                }

            } else if(character == ')'){

                if (process.charAt(positionSymbol) == 'R'){
                    ruleSelected = DRfR[0];
                    process = process.replaceFirst("R", ruleSelected);
                }

            } else if(character == ' '){
                if(process.charAt(positionSymbol) == 'B'){
                    ruleSelected = DRfB[1];
                    process = process.replaceFirst("B", " ");
                }
            }
             System.out.println(ruleSelected + " : " + process);
         }
        }
    }
    
    public int positionFirstCharacter(){
        for(int i = 0; i < process.length(); i++){
            if(process.charAt(i) == 'R' || process.charAt(i) == 'B')
                return i;
        }
        return -1;
    }
    
    
    
    
    
}
