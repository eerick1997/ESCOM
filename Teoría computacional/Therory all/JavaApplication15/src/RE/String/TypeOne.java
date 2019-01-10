package RE.String;

import Palindrome.forFiles.MyFiles;

/**
 * In this clase we have the code to generate Strings using the expression
 * given:  *
 * (0+10)*(e+1)      *
 */

//* is Kleene Closure generates an "universe"
//Important to remember + is an or
//If we don't have operand is a concatenation
//IMPORTANT Kleene Closure contains empty string
public class TypeOne {
    
    private MyFiles file = new MyFiles("RE/typeOne.txt");
    
    public TypeOne() {
        String str = "";
        for(int i = 0; i < 5; i++){
            str = firstMember() + secondMember();
            file.writeSth("[ "+(i+1)+" ] " + str);
        }
        file.closeFile();
    }

    /**
     * In this function I build the expression given:
     *
     * (0+10)*
     *
     *
     * @return 
     *
     */
    public String firstMember() {
        String str = "";

        //Here I decide the size of my Kleen Closure
        int random = (int)(Math.random()*1000);
        if (random != 0) {
            for (int i = 0; i < random; i++) {
                //I decide between a String or Epsilon
                //if is 0 add epsilon

                //If is 0 add (0)
                if (Math.rint(Math.random()) == 0) {
                    str += "0";
                } else {
                    str += "10";
                }

            }
        } else {
            if(!str.contains("e"))
                str += "e";
        }
        return str;
    }

    /**
     * In this function I build the expression given:
     *
     * (e+1)
     *
     * @return 
     *
     */
    public String secondMember() {
        String str = "";
        //If is zero add e
        if (Math.rint(Math.random()) == 0) {
            if(!str.contains("e"))
                str += "e";
        } else {
            str += "1";
        }
        return str;
    }

}
