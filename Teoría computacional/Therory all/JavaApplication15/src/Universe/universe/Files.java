package Universe.universe;

import java.io.FileWriter;
import java.math.BigInteger;

public class Files {

    void saveUniverse(Number number, FileWriter fileWriter) throws Exception{
        
        try{
            for(BigInteger i = new BigInteger("0");
                    i.compareTo(new BigInteger(String.valueOf(number.getTable().get(0).size()))) == -1;
                    i = i.add(BigInteger.ONE)){
                fileWriter.write(", ");
                for(BigInteger j = new BigInteger("0");
                        j.compareTo(new BigInteger(String.valueOf(number.getTable().size()))) == -1;
                        j = j.add(BigInteger.ONE)){
                        String output = number.getTable().get(j.intValueExact()).get(i.intValueExact());
                        fileWriter.write(output);
                }
            }
        } catch(Exception e) {
            System.err.println("Ha ocurrido un error: " + e);
        }
    }
}
