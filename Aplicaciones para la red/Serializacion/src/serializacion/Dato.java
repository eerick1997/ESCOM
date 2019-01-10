package serializacion;

import java.io.Serializable;

/**ára el envio de objetos a través de una conexión es necesario utilizar flujos orientados a byte "ObjectOutputStream"
 y "ObjectInputStream", además de implementar la interfaz java.io.Serializable en la definición de clase del objeto a ser
 transmitido**/
public class Dato implements Serializable{
    
    String nombre;
    int edad;
    String telefono;
    float sueldo;
    
    public Dato(String n, int e,String t, float s){
        this.nombre = n;
        this.edad = e;
        this.telefono = t;
        this.sueldo = s;    
    }
    
    String getNombre(){
        return this.nombre;
    }
    
    int getEdad(){
        return this.edad;
    }
    
    String getTelefono(){
        return this.telefono;
    }
    
    float getSueldo(){
        return this.sueldo;
    }
    
}
