import java.awt.*;
import java.util.*;
import java.lang.reflect.*;

class  Maquina {
    Tabla tabla;
    Stack pila;
    Vector prog;
    
    static int pc=0;
    int progbase=0;
    boolean returning=false;
    
    Method metodo;
    Method metodos[];
    Class c;
    Graphics g;
    double angulo;
    int x=0, y=0;
    Class parames[];
    
    Maquina(){
    }
    
    public void setTabla(Tabla t){ 
        tabla = t; 
    }
    
    public void setGraphics(Graphics g){ 
        this.g=g; 
    }
    
    Maquina(Graphics g){ 
        this.g=g; 
    }
    
    public Vector getProg(){ 
        return prog; 
    }
    
    void initcode(){
        pila=new Stack();
        prog=new Vector();
    }
    
    Object pop(){ 
        return pila.pop(); 
    }
    
    int code(Object f){
        System.out.println("Gen ("+f+") size="+prog.size());
        prog.addElement(f);
        return prog.size()-1;
    }
    
    void execute(int p){
        String inst;
        System.out.println("progsize="+prog.size());
        for(pc=0;pc < prog.size(); pc=pc+1){
            System.out.println("pc="+pc+" inst "+prog.elementAt(pc));
        }
        for(pc=p; !(inst=(String)prog.elementAt(pc)).equals("STOP") && !returning;){
            //for(pc=p;pc < prog.size();){
            try {
                //System.out.println("111 pc= "+pc);
                inst=(String)prog.elementAt(pc);
                pc=pc+1;
                System.out.println("222 pc= "+pc+" instr "+inst);
                c=this.getClass();
                //System.out.println("clase "+c.getName());
                metodo=c.getDeclaredMethod(inst, null);
                metodo.invoke(this, null);
            }
            catch(NoSuchMethodException e){
                System.out.println("No metodo "+e);
            }
            catch(InvocationTargetException e){
                System.out.println(e);
            }
            catch(IllegalAccessException e){
                System.out.println(e);
            }
        }
    }
    
    void constpush(){
        Simbolo s;
        Double d;
        s=(Simbolo)prog.elementAt(pc);
        pc=pc+1;
        pila.push(new Double(s.val));
    }
    
    void color(){
        Color colors[]={Color.red,Color.green,Color.blue};
        double d1;
        d1=((Double)pila.pop()).doubleValue();
        if(g!=null){
            g.setColor(colors[(int)d1]);
        }
    }
    
    /**
        * Para nuestro caso una línea está compuesta por:
        * X1, Y1, X2, Y2
     **/
    void line(){
        double X1, Y1, X2, Y2;
        //Obtenemos el primer valor, haciendo pop de la pila
        X1 = ((Double)pila.pop()).doubleValue();
        //Obtenemos el segundo valor, haciendo pop de la pila
        Y1 = ((Double)pila.pop()).doubleValue();
        //Obtenemos el tercer valor, haciendo pop de la pila
        X2 = ((Double)pila.pop()).doubleValue();
        //Obtenemos el cuarto valor, haciendo pop de la pila
        Y2 = ((Double)pila.pop()).doubleValue();
        
        //Los gráficos no deben ser nulos para poder dibujar
        if(g!=null){
            //Creamos un objeto Linea con los datos obtenidos de la pila
            (   new Linea((int)X1, (int)Y1, (int)X2, (int)Y2)   ).dibuja(g);
        }
    }
    
    /**
        * Para nuestro caso un circulo  está compuesto por:
        * radio, X, Y
     **/
    void circulo(){
        double radio, X, Y;
        //Obtenemos el valor del radio haciendo pop de la pila
        radio = ((Double)pila.pop()).doubleValue();
        //Obtenemos el valor de la posición  X haciendo pop de la pila
        X = ((Double)pila.pop()).doubleValue();
        //Obtenemos el valor de la posición Y haciendo pop de la pila
        Y = ((Double)pila.pop()).doubleValue();
        //Para poder dibujar la variable g no debe ser nula
        if(g!=null){
            //Creamos un nuevo objeto circulo
            (   new Circulo((int)radio, (int)X, (int)Y)    ).dibuja(g);
        }
    }
    
    /**
        * Para nuestro caso un rectangulo está compuesto por:
        * X, Y, ancho, alto
     **/
    void rectangulo(){
        double X, Y, ancho, alto;
        //Obtenemos el valor de la posición en X haciendo pop de la pila
        X = ((Double)pila.pop()).doubleValue();
        //Obtenemos el valor de la posición en Y haciendo pop de la pila
        Y = ((Double)pila.pop()).doubleValue();
        //Obtenemos el valor de la anchura del rectangulo haciendo pop de la pila
        ancho = ((Double)pila.pop()).doubleValue();
        //Obtenemos el valor de la altura dle rectangulo haciendo pop de la pila
        alto = ((Double)pila.pop()).doubleValue();
        if(g!=null){
            (   new Rectangulo((int)X, (int)Y, (int)ancho, (int)alto )  ).dibuja(g);
        }
    }
    
    void print(){
        Double d;
        d=(Double)pila.pop();
        System.out.println(""+d.doubleValue());
    }
    
    void prexpr(){
        Double d;
        d=(Double)pila.pop();
        System.out.print("["+d.doubleValue()+"]");
    }
    
}
