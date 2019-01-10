package Chess.forAutomaton;

import java.util.ArrayList;

public class Path {
    
    private String path = "";
     
    public void addMove(String str){
        path += "->" + str;
    }
    
    public void initialize(){
        path = "";
        path += "->" + "q1";
    }
    
    public void copyPath(String str){
        path = "";
        path = str;
    }
    
    public void setPath(String str){
        path = str;
    }
    
    public String getPath(){
        return path;
    }
    
    public void cleanPath(){
        path = "";
    }
    
    public ArrayList<String> decode(){
        ArrayList<String> list = new ArrayList<>();
        
        System.out.println(path);
        
        for(int i=0; i<path.length(); i++){
            if(isANumber(path.charAt(i)))
                list.add(path.charAt(i)+"");
        }
        return list;
    }
    
    public boolean isANumber(char character){
        return ((int)character >= 48 && (int)character <= 57);
    }
   
}
