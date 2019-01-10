package ends01.Automaton;

import ends01.Files.MyFile;
import java.io.FileReader;
import java.util.ArrayList;

public class Automaton {

    private static final String q0 = "q0", q1 = "q1", q2 = "q2";
    private static final String file_history = "ends01/history.txt", file_matrix = "ends01/matrix.txt";
    private Matrix matrix;
    private MyFile fileMatrix;

    public Automaton() {
        matrix = new Matrix();
        fileMatrix = new MyFile(file_matrix);
    }
    
    private void states(char character){
        
        if(character == '0'){
            
            //Here it's possible to take two paths
            if(getLastState().equals(q0)){
                add_q1();
            } else if(getLastState().equals(q1)){
                add_q1();
                //Wrong path, process die
            } else if(getLastState().equals(q2)){
                add_q1();
                //Wrong path, process die
            }
        } else if(character == '1'){
            if(getLastState().equals(q0)){
            } else if(getLastState().equals(q1)){
                add_q2();
            } else if(getLastState().equals(q2)){
                add_q1();
                //Wrong path, process die
            }
        }
    }
    
    private void add_q1(){
        matrix.addColumn();
        matrix.addRow();
        matrix.setElement(matrix.getMaxColumns()-1, matrix.getMaxRows()-1, q1);
    }
    
    private void add_q2(){
        matrix.addRow();
        matrix.setElement(matrix.getMaxColumns()-1, matrix.getMaxRows()-1, q2);
    }

    public void readByKeyboard(String str) {
        str += "  ";
        String actualState = q0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                states(str.charAt(i));
                matrix.print();
            } else {
                if (matrix.getElement(matrix.getMaxColumns()-1, matrix.getMaxRows()-1).equals(q2)) {
                    System.out.println("Accepted");
                    matrix.print();
                    writeMatrix();
                    matrix = new Matrix();
                }
            }
        }
        fileMatrix.closeFile();
    }
    
    private String getLastState(){
        return matrix.getElement(matrix.getMaxColumns()-1, matrix.getMaxRows()-1);
    }

    public void readByFile(String path) {
        String contentFile = "";
        path = path.trim();
        path += ' ';
        try {
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();
            while (character != -1) {
                character = fileReader.read();
                contentFile += (char)character;
            }
            character = fileReader.read(); // If i delete this line 
            contentFile += (char)character;
            //This program can't read the last character

            fileReader.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        //Here isn't necessary create other function
        //readByKeyboard divide the message of the file.
        readByKeyboard(contentFile);
    }
    
    public MyFile getFileMatrix(){
        return fileMatrix;
    }
    
    public void writeMatrix(){
        System.out.println("\n");
        fileMatrix.writeSth("--- Matrix accepted last column is the accepted path---");
        for(int i=0; i<matrix.getMaxColumns(); i++){
            String addRow = " ";
            for(int j=0; j<matrix.getMaxRows(); j++){
                addRow += matrix.getElement(i, j) + " ";
            }
            fileMatrix.writeSth(addRow);
        }
    }
}
