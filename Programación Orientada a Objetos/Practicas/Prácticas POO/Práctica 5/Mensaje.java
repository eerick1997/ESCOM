
import java.io.Serializable;

class Mensaje implements Serializable {
	String programa;
	String nick;
	String texto;
	public Mensaje(String programa, String nick, String texto){
		this.programa=programa;
		this.nick=nick;
		this.texto=texto;	
	}
	public String getPrograma(){
               return programa;
	}
	public String getNick(){
               return nick;
	}
	public String getTexto(){
	       return texto;
	}

}
