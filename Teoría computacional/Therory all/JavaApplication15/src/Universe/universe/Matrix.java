package Universe.universe;

import java.math.BigInteger;
import java.util.ArrayList;

public class Matrix {

    BigInteger ones = new BigInteger("0");
    //This function receive the number of columns
    //If we raise to power two we get the number of rows
    Number fillMatrix(int k) {
        BigInteger base = new BigInteger("2");
        BigInteger alternance = new BigInteger("0");
        ArrayList<ArrayList<String>> matrix = new ArrayList<>();
        //Here I go over all the columns one by one
        //Matemathically our colums is represented by k word
        //Also our number of rows is get with 2^k or Math.pow(2,k);
        //The alternance of each column is get with 2^k-1
        //Remember that I go over each column from right to left <- <-
        for (BigInteger columns = new BigInteger("1");
                columns.compareTo(new BigInteger(Integer.toString(k + 1))) == -1;
                columns = columns.add(BigInteger.ONE)) {
            //Here I go over each row the number of row ever is the 
            //maximum number of combinations Math.pow(2,k)
            //Mathematically is 2^k
            ArrayList<String> column = new ArrayList<>();
            for (BigInteger rows = new BigInteger("0");
                    rows.compareTo(base.pow(k)) == -1;
                    rows = rows.add(BigInteger.ONE)) {
                if (alternance.compareTo(base.pow(columns.subtract(new BigInteger("1")).intValueExact())) == -1) {
                    alternance = alternance.add(BigInteger.ONE);
                    column.add("0");
                } else if ((alternance.compareTo(base.pow(columns.subtract(new BigInteger("1")).intValueExact())) == 0)
                        || alternance.compareTo(base.pow(columns.subtract(new BigInteger("1")).intValueExact())) == 1) {
                    alternance = alternance.add(BigInteger.ONE);
                    column.add("1");
                    if (alternance.compareTo(base.pow(columns.intValue())) == 0) {
                        alternance = new BigInteger("0");
                    }
                    ones = ones.add(BigInteger.ONE);
                }
            }
            //Here I add a column in our ArrayList of ArrayList
            matrix.add(column);
        }
        return new Number(matrix, ones);
    }
}
