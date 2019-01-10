package ends01.Automaton;

import java.util.ArrayList;

public class Matrix {
    
    private ArrayList<ArrayList<String>> matrix;
    private ArrayList<String> row;
    
    public Matrix(){
        matrix = new ArrayList<>();
        initialize();
    }
    
    public void initialize(){
        row = new ArrayList();
        row.add("q0");
        matrix.add(row);
    }
    
    public void print(){
        for(int i = 0; i<matrix.size(); i++){
            String column = "";
            for(int j=0; j<matrix.get(i).size(); j++){
                column += " " + matrix.get(i).get(j);
            }
            System.out.println(column);
        }
    }
    
    public String getElement(int row, int column){
        return matrix.get(row).get(column);
    }
    
    public void setElement(int row, int column, String element){
        matrix.get(row).set(column, element);
    }
    
    public void deleteColumn(int column){
        for(int i = 0; i<matrix.size(); i++){
            matrix.get(i).remove(column);
        }
    }
    
    public void addColumn(){
        for(int i=0; i<matrix.size(); i++){
            matrix.get(i).add("x");
        }
        System.out.println("\n");
    }
    
    public void addRow(){
        ArrayList<String> row = new ArrayList();
        for(int i=0; i<matrix.get(0).size(); i++){
            if(i==0)row.add("q0"); else row.add("x");
        }
        matrix.add(row);
    }
    
    public int getMaxColumns(){ 
        return matrix.size();
    }
    
    public int getMaxRows(){
        return matrix.get(0).size();
    }
    
    
}
