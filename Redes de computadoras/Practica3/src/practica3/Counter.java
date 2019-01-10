package Practica3;

/**
 *
 * @author ANDRES
 */
public class Counter {
    int id, destinatario, emisor;
    String cadena;
    byte []mensaje;
    
    public Counter(int inicio){
        id=inicio;
    }
    public Counter(){
        cadena="";
        mensaje=new byte[1200];
    } 
    int incrementa(int i){
        id+=i;
        return i;
    }
    String concatena(String s){
        cadena+=s;
        return cadena;
    }
    
    void setByte(byte [] b){
        mensaje=b;
    }
    byte [] getByte(){
        return mensaje;
    }
    
    

    public static void main(String args[]){
        Counter msj=new Counter();
        msj.concatena("hola ");
        msj.concatena("ke ase");
        System.out.println(msj.cadena);
    }
}