package tests;

public class Tests {

    public static void main(String[] args) {
        
        int i = 0;
        float b = 0;
        char c = 'c';
        
        System.out.println(((Object)i).getClass().getName());
        System.out.println(((Object)b).getClass().getName());
        System.out.println(((Object)c).getClass().getName());
        System.out.println((Object)i instanceof Integer);
    }
    
}
