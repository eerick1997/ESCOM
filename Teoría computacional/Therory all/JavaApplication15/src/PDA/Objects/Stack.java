package PDA.Objects;

import PDA.forFiles.MyFiles;
import java.util.ArrayList;

public class Stack {

    private ArrayList<Element> stack;
    private MyFiles file;
    
    public Stack(MyFiles file) {
        stack = new ArrayList<>();
        this.file = file;
        initialize();
    }

    public void push(char character) {
        stack.add(new Element(character));
    }

    public char pop() {
        char character = ' ';
        if(!isEmpty()){
            character = stack.get(stack.size() - 1).getElement();
            stack.remove(stack.size() - 1);
        } else {
            System.err.println("El programa ha finalizado");
            file.closeFile();
            System.exit(0);
        }
        return character;
    }

    public char getLast() {
        return (stack.get(stack.size() - 1).getElement());
    }

    public boolean isEmpty() {
        return (getLast() == 'Z');
    }

    public void initialize() {
        stack.add(new Element('Z'));
    }

    public int size() {
        return stack.size();
    }

}
