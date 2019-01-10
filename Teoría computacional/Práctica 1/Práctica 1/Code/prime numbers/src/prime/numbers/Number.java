package prime.numbers;

import java.math.BigInteger;

public class Number {
    
    private BigInteger number, ones;
    private boolean prime;
    private String binary;
    
    public Number(BigInteger number){
        this.number = number;
        this.prime = isPrime(number);
        this.binary = number.toString(2);
        this.ones = countOnes(binary);
    }
    
    public BigInteger getNumber(){
        return this.number;
    }
    
    public boolean getIsPrime(){
        return this.prime;
    }
   
    public String getBinary(){
        return this.binary;
    }
    
    public BigInteger getOnes(){
        return ones;
    }
    
    private boolean isPrime(BigInteger number){
        BigInteger count = new BigInteger("0");
        for(int i = 1; i<= number.intValueExact(); i++){
            if(number.intValueExact() % i == 0)
                  count = count.add(BigInteger.ONE);
        }
        if(count.intValueExact() != 2)
            return false;
        else return true;
    }
    
    private BigInteger countOnes(String binaryString){
        BigInteger numberOnes = new BigInteger("0");
        for(int i=0; i<binaryString.length(); i++){
            if(binaryString.charAt(i) == '1')
                numberOnes = numberOnes.add(BigInteger.ONE);
        }
        return numberOnes;
    }
    
}
