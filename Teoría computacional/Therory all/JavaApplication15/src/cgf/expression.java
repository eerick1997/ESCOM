package cgf;

import Palindrome.forFiles.MyFiles;
import java.io.FileReader;

public class expression {

    private MyFiles file = new MyFiles("Parse Trees/steps.txt");

    String DRfB[] = {"(RB", "e"}, DRfR[] = {")", "(RR"};

    public void evaluateExpression(String strParentheses, int mode) {
        strParentheses = strParentheses.trim();
        String process = "B", ruleSelected = "";

        if (!strParentheses.isEmpty()) {
            file.writeSth("Expression: " + strParentheses);
            file.writeSth(process);

            System.out.println(strParentheses);
            strParentheses += ' ';
            for (int i = 0; i < strParentheses.length(); i++) {
                char character = strParentheses.charAt(i);
                int positionSymbol = positionFirstCharacter(process);
                if (positionSymbol >= 0) {
                    if (character == '(') {
                        
                        if (process.charAt(positionSymbol) == 'B') {
                            ruleSelected = DRfB[0];
                            process = process.replaceFirst("B", ruleSelected);
                        } else if (process.charAt(positionSymbol) == 'R') {
                            ruleSelected = DRfR[1];
                            process = process.replaceFirst("R", ruleSelected);
                        } else {
                            System.out.println("Not accepted");
                            break;
                        }

                    } else if (character == ')') {

                        if (process.charAt(positionSymbol) == 'R') {
                            ruleSelected = DRfR[0];
                            process = process.replaceFirst("R", ruleSelected);
                        } else {
                            System.out.println("Not accepted");
                            break;
                        }

                    } else if (character == 32) {
                        if (process.charAt(positionSymbol) == 'B') {
                            ruleSelected = DRfB[1];
                            process = process.replaceFirst("B", " ");
                            System.out.println("Accepted");
                            
                        } else {
                            System.out.println("Not accepted");
                            break;
                        }
                    } else {
                        System.out.println("Not accepted, invalid character");
                    }
                    file.writeSth(ruleSelected + " -> " + process);
                    if(ruleSelected.equals(DRfB[1]))
                        file.writeSth("Accepted \r\n");
                }
            }
            if (mode == 0) {
                file.closeFile();
            }
        }
    }

    public int positionFirstCharacter(String process) {
        for (int i = 0; i < process.length(); i++) {
            if (process.charAt(i) == 'R' || process.charAt(i) == 'B') {
                return i;
            }
        }   
        return -1;
    }

    public void readByFile(String path) {
        String str = "";
        try {
            FileReader fileReader = new FileReader(path);
            int character = fileReader.read();

            while (character != -1) {

                if (character == '(' || character == ')') {
                    str += (char) character;
                } else {
                    evaluateExpression(str, 1);
                    str = "";
                }
                character = fileReader.read();
            }

            if (character == '(' || character == ')') {
                str += (char) character;
            } else {
                evaluateExpression(str, 1);
                str = "";
            }

            fileReader.close();
        } catch (Exception e) {
            System.err.println("Error reading file: " + path);
            System.err.println(e);
        }
        file.closeFile();
    }
}
