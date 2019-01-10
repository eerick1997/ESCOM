package Universe.universe;

import java.math.BigInteger;
import java.util.ArrayList;

public class Number {
    
    private ArrayList<ArrayList<String>> table;
    private BigInteger ones;
    
    public Number(ArrayList<ArrayList<String>> table, BigInteger ones){
        this.table = table;
        this.ones = ones;
    }
    
    public ArrayList<ArrayList<String>> getTable(){
        return this.table;
    }
    
    public BigInteger getOnes(){
        return this.ones;
    }
    
}
