
import java.io.Serializable;

public class My_object implements Serializable{
    int n;
    int total;
    byte[] msj;
    
    public My_object(int n, int total, byte[] msj){
        this.n = n;
        this.total = total;
        this.msj = msj;
    }
    
    public int getN(){
        return n;
    }
    
    public int getTotal(){
        return total;
    }
    
    public byte[] getMsj(){
        return msj;
    }
}
