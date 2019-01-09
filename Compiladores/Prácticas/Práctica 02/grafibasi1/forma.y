%{
    import java.lang.Math;
    import java.io.*;
    import java.util.StringTokenizer;
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
    %}
    %token NUMBER LINE CIRCULO RECTANGULO COLOR PRINT
    %start list
    
    %%
    /****************************************************************
     *                          GRAMÁTICA                           *
     ****************************************************************/
    
    /**
     *   list ->                
     *   |    list ';'
     *   |   list inst ';'
     **/
    list :    
                | list ';'
                | list inst ';'   { 
                    maq.code("print"); 
                    maq.code("STOP"); 
                    return 1 ; 
                }   
    ;
    
    /**
     *  inst -> NUMBER
     *  |   RECTANGULO NUMBER NUMBER NUMBER NUMBER    (x, y, ancho, alto)
     *  |   LINE NUMBER NUMBER NUMBER NUMBER          (x1, y1, x2, y2)
     *  |   CIRCULO NUMBER NUMBER NUMBER              (radio, x, y)
     *  |   COLOR NUMBER
     **/
    inst:  NUMBER  { 
        ((Algo)$$.obj).inst = maq.code("constpush");
        maq.code(((Algo)$1.obj).simb); 
    }
    | RECTANGULO NUMBER NUMBER NUMBER NUMBER { 
        //Push del primer símbolo gramatical        (  X   )
        maq.code("constpush");
        maq.code(((Algo)$2.obj).simb); 
        //Push del segundo símbolo gramatical   (   Y   )
        maq.code("constpush");
        maq.code(((Algo)$3.obj).simb); 
        //Push del tercer símbolo gramatical        ( ancho )
        maq.code("constpush");
        maq.code(((Algo)$4.obj).simb); 
        //Push del cuarto símbolo gramatical        ( alto )
        maq.code("constpush");
        maq.code(((Algo)$5.obj).simb); 
        maq.code("rectangulo");
    }
    | LINE NUMBER NUMBER NUMBER NUMBER { 
        //Push del primer símbolo gramatical        (  X1   )
        maq.code("constpush");
        maq.code(((Algo)$2.obj).simb); 
        //Push del segundo símbolo gramatical   (   Y1   )
        maq.code("constpush");
        maq.code(((Algo)$3.obj).simb); 
        //Push del tercer símbolo gramatical        (   X2   )
        maq.code("constpush");
        maq.code(((Algo)$4.obj).simb); 
        //Push del cuarto símbolo gramatical       (    Y2     )
        maq.code("constpush");
        maq.code(((Algo)$5.obj).simb); 
        maq.code("line");
    }
    | CIRCULO NUMBER NUMBER NUMBER { 
        //Push del primer símbolo gramatical        (  radio  )
        maq.code("constpush");
        maq.code(((Algo)$2.obj).simb); 
        //Push del segundo símbolo gramatical   (   X   )
        maq.code("constpush");
        maq.code(((Algo)$3.obj).simb); 
        //Push del tercer símbolo gramatical        (   Y   )
        maq.code("constpush");
        maq.code(((Algo)$4.obj).simb); 
        maq.code("circulo");
    }
    | COLOR NUMBER { 
        maq.code("constpush");
        maq.code(((Algo)$2.obj).simb); 
        maq.code("color");
    }
    ;
    %%
                
                /****************************************************************
                 *                  CÓDIGO EN JAVA                              *
                 ****************************************************************/
                class Algo {
                    Simbolo simb;
                    int inst;
                    
                    //Constructor
                    public Algo(int i){ 
                        inst=i; 
                    }
                    
                    //Constructor
                    public Algo(Simbolo s, int i){
                        simb=s; inst=i;
                    }
                    
                }
                
                public void setTokenizer(StringTokenizer st){
                    this.st= st;
                }
                
                public void setNewline(boolean newline){
                    this.newline= newline;
                }
                
                Tabla tabla;
                Maquina maq;
                
                StringTokenizer st;
                boolean newline;
                int yylex(){
                    String s;
                    int tok;
                    Double d;
                    Simbolo simbo;
                    if (!st.hasMoreTokens())
                        if (!newline) {
                            newline=true; 
                            return ';';  
                        }
                        else
                            return 0;
                        s = st.nextToken();
                    try {
                        d = Double.valueOf(s);
                        yylval = new ParserVal(
                            new Algo(tabla.install("", NUMBER, d.doubleValue()),0) );
                        tok = NUMBER;
                    } catch (Exception e){
                        if(Character.isLetter(s.charAt(0))){
                            if((simbo=tabla.lookup(s))==null)
                                yylval = new ParserVal(new Algo(simbo, 0));
                            tok= simbo.tipo;	
                        } else {
                            tok = s.charAt(0);
                        }
                    }
                    return tok;
                }
                
                void yyerror(String s){
                    System.out.println("parser error: "+s);
                }
                
                static Parser par = new Parser(0);
                static JFrame jf;
                static JLabel lmuestra=new JLabel("                                 ");
                static Canvas canv;
                static Graphics g;
                
                Parser(int foo){
                    maq=new Maquina();
                    tabla=new Tabla();
                    tabla.install("line", LINE, 0.0);
                    tabla.install("circulo", CIRCULO, 0.0);
                    tabla.install("rectangulo", RECTANGULO, 0.0);
                    tabla.install("color", COLOR, 0.0);
                    tabla.install("print", PRINT, 0.0);
                    maq.setTabla(tabla);
                    jf=new JFrame("Calcula");
                    canv=new Canvas();
                    canv.setSize(600,600);
                    jf.add("North", new PanelEjecuta(maq, this));
                    jf.add("Center", canv);
                    jf.setSize( 600, 700);
                    jf.setVisible(true);
                    g=canv.getGraphics();
                    maq.setGraphics(g);
                    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
                }
                
                public static void main(String args[]){
                    new Parser(); 
                }
                
