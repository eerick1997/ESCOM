package RE.String;

import Palindrome.forFiles.MyFiles;

/**
 * In this clase we have the code to generate Strings using the expression
 * given: [(10)*0 + 1(01)*1] [0(01)*(1+00) + 1(10)*(0+11)]*
 */
//* is Kleene Closure generates an "universe"
//Important to remember + is an or
//If we don't have operand is a concatenation
//IMPORTANT Kleene Closure contains empty string
public final class TypeTwo {
    int constant = 1000;

    /**
     * In this constructor I just generate a String and save it in a file*
     */
    public TypeTwo() {
        MyFiles file = new MyFiles("RE/typeTwo.txt");
        //First of all I generate 
        //(10)*0 + 1(01)*1
        //If is zero I concat (10)*0
        for (int j = 0; j < 5; j++) {
            String str = "";
            if (Math.rint(Math.random()) == 0) {
                str += firstMember();
            } else {
                str += secondMember();
            }

            //Then I generate
            //[0(01)*(1+00) + 1(10)*(0+11)]*
            int random = (int)(Math.random()*constant);
            if(random != 0){
                for (int i = 0; i < random ; i++) {
                    //if is 0 add epsilon
                    if (Math.rint(Math.random()) == 0) {
                        if(!str.contains("e"))
                            str += "e";
                    } //In other case I decide between concat
                    //0(01)*(1+00) or 1(10)*(0+11)
                    else {
                        //If is zero I select 0(01)*(1+00)
                        //Or ThirdMember function
                        if (Math.rint(Math.random()) == 0) {
                            str += thirdMember();
                        } else {
                            str += fourthMember();
                        }
                    }

                }
            } else {
                if(!str.contains("e"))
                    str += "e";
            }
            //str = str.replace(".", "");
            file.writeSth("[ " +(j+1)+ " ] " + str);
            
        }
        file.closeFile();
        //FINALLY SAVE THE STRING IN A FILE
    }

    /**
     * The next function makes the next part of the expression given:
     *
     * (10)*0
     *
     * @return
     *
     */
    public String firstMember() {
        String str = "";

        //A random is necessesary to know the number of concatenations
        //that I make in this Kleene Closure
        //Here I build the part (10)*
        int random = (int)(Math.random()*constant);
        if (random != 0) {
            for (int i = 0; i < random; i++) {
                str += "10";
            }
        } else {
            if(!str.contains("e"))
                str += "e";
        }
        str += "0";
        return str;
    }

    /**
     * The next function makes the second part of the expression given:
     *
     * 1(01)*1
     *
     * @return
     *
     */
    public String secondMember() {
        String str = "";

        //First I need build (01)*
        int random = (int)(Math.random()*constant);
        if (random != 0) {
            for (int i = 0; i < random; i++) {
                str += "01";
            }
        } else {
            if(!str.contains("e"))
                str += "e";
        }
        //Now I concatenate the other ones and return the string    
        str = "1" + str + "1";
        return str;
    }

    /**
     * The next function makes the third member of the expression given:
     *
     * 0(01)*(1+00)
     *
     * @return
     *
     */
    public String thirdMember() {
        String str = "";

        //First I need build (01)*
        int random = (int)(Math.random()*constant);
        if (random != 0) {
            for (int i = 0; i < random; i++) {
                str += "01";
            }
        } else {
            if(!str.contains("e"))
                str += "e";
        }
        //Here I get 0(01)*
        str = "0" + str;
        //Now I build (1+00) and add to str
        if (Math.rint(Math.random()) == 0) {
            str += "00";
        } else {
            str += "1";
        }
        return str;
    }

    /**
     * The next function makes the third member of the expression given:
     *
     * 1(10)*(0+11)
     *
     * @return
     *
     */
    public String fourthMember() {
        String str = "";
        //Here I build the part (10)*
        int random = (int)(Math.random()*constant);
        if (random != 0) {
            for (int i = 0; i < random; i++) {
                str += "10";
            }
        } else {
            if(!str.contains("e"))
                str += "e";
        }
        //Here I get 1(10)*
        str = "1" + str;
        //Now I decide between 0 or 11 to concat
        //Finally I get 1(10)*(0+11) expression
        if (Math.rint(Math.random()) == 0) {
            str += "0";
        } else {
            str += "11";
        }
        return str;
    }

    public static void main(String args[]) {
            new TypeTwo();
    }
}
