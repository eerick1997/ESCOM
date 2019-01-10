import java.awt.*;
import javax.swing.*;
import java.io.Serializable;

public class Icono implements Serializable {
	String programa;
	int turno;
	public Icono(String programa, int turno)
	{
		this.programa=programa;
		this.turno=turno;	
	}
        public String getPrograma(){
               return programa;
	}
	public int getTurno(){
        	return turno;
	}
}


