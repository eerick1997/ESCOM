import java.io.*;
import java.net.*;
public class IncomingReader implements Runnable {
private LeeRed lr;
private ObjectInputStream oisNet;
public IncomingReader(LeeRed lr, ObjectInputStream oisNet){ 
	this.lr=lr;
	this.oisNet=oisNet;
}
public void run(){
	Object obj=null;
	int j,k=0;
        System.out.println("run");
   	for(;;){
    		j=0;
    		try {
                        obj=oisNet.readObject();	
    		} catch (IOException e) {
			System.out.println("IO ex"+e);
         		j=1;
                } catch (ClassNotFoundException ex) {
                     	System.out.println("Class no found"+ex);
			j=1;
		} 
    		if (j==0) {
			lr.leeRed(obj);
                }//if
        }//for
}//run
}
