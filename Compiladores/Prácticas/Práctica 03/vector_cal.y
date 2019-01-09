%{
    #include "hoc.h"
    //#include "vector_cal.h"
    #include <math.h>
    #include <stdio.h>

    void yyerror(char* s);
    int yylex();
    //Funciones añadidas para la práctica 3
    void warning(char* s, char* t);
%}  
//Definición de tipos de dato de la pila de yacc
%union{
    double comp;
    Vector* vec;
    //Añadida en la práctica 3
    Symbol* sym;
} 

/**Creación de símbolos terminales y no terminales**/
%token<comp>    NUMBER     //Símbolo terminal
%type<vec>      exp        //Símbolo no terminal
%type<vec>      vect       //Símbolo no terminal
%type<comp>     number     //Símbolo no terminal
//NUEVOS SÍMBOLOS GRAMATICALES PARA LA PRÁCTICA 3
%token<sym>     VAR BLTIN  //Símbolo terminal
%token<sym>     UNDEF      //Símbolo terminal
%type<vec>      asgn       //Símbolo no terminal

/**Jerarquía de operadores**/

//Para práctica 1
%right '='
//Suma y resta de vectores
%left '+' '-'
//Escalar por un vector
%left '*'
//Para valores negativos
%left UNARYMINUS
//Producto cruz y producto punto
%left '#' '.'
/**Gramática**/
%%
  /**
    * list -> list '\n'          |
    * list -> list asgn '\n'     |  //Práctica 3
    * list -> list exp '\n'      |  
    * list -> list number '\n'   |
  **/
    list: 
      | list '\n'
      | list asgn '\n'
      | list exp '\n'     {imprimeVector($2);}
      | list number '\n'  {printf("\t%lf\n", $2);}
      | list error '\n'   {yyerror;}
      ;
    
  /**
    * asgn -> VAR '=' exp //Práctica 3
  **/
    asgn: VAR '=' exp     {$$ = $1 -> u.vec = $3;
                            $1 -> type = VAR;}
    ;

    /** 
      * exp -> vect           |
      * exp -> VAR            | //Práctica 3
      * exp -> asgn           | //Práctica 3
      * exp -> exp '+' exp    |
      * exp -> exp '-' exp    |
      * exp -> exp '*' NUMBER |
      * exp -> NUMBER * exp   |
      * exp -> exp '#' exp    |
    **/
    exp: vect           {$$ = $1;}
    //La expresión es una variable
      | VAR             {printf("\n%s = ", $1 -> name);
                        if($1 -> type == UNDEF) //Verificamos si existe la variable
                          printf("Variable no definida %s\n", $1 -> name);
                        $$ = $1 -> u.vec;}
    //La expresión es una asignación
      | asgn
    //Suma de vectores
      | exp '+' exp     {$$ = sumaVector($1, $3);}
    //Resta de vectores
      | exp '-' exp     {$$ = restaVector($1, $3);}
    //Multiplicación por un escalar primer caso
      | NUMBER '*' exp  {$$ = escalarVector($1, $3);}
    //Multiplicación por un escalar segundo caso
      | exp '*' NUMBER  {$$ = escalarVector($3, $1);}
    //Producto cruz
      | exp '#' exp     {$$ = productoCruz($1, $3);}
    ;
    /**
      * number -> NUMBER       |
      * number -> exp '.' exp  |
      * number -> '|' exp '|'  |
    **/
    number: NUMBER
      | exp '.' exp {$$ = productoPunto($1, $3);}
      | '|' exp '|' {$$ = vectorMagnitud($2);}
      ;

    /**
      * vect -> '['NUMBER NUMBER NUMBER']'
    **/
    vect: '[' NUMBER NUMBER NUMBER ']'   {  Vector* v = creaVector(3);
                                            v -> vec[0] = $2;
                                            v -> vec[1] = $3;
                                            v -> vec[2] = $4;
                                            $$ = v;}
      ;
%%

/****************************************************************************
*                            Código en C                                    *
****************************************************************************/
#include <stdio.h>
#include <ctype.h>

char* progname;
int lineno = 1;

void main(int argc, char* argv[]){
  progname = argv[0];
  yyparse();
}

int yylex(){
  int c;
  while((c = getchar()) == ' '|| c == '\t')
  /**Salta blancos**/;
  if(c == EOF)
    return 0;
  if(isdigit(c)){
    ungetc(c, stdin);
    scanf("%lf", &yylval.comp);
    return NUMBER;
  }

  if(isalpha(c)){
    Symbol* s;
    char sbuf[200];
    char* p = sbuf;
    do{
      *p++ = c;
    } while((c = getchar()) != EOF && isalnum(c));

    ungetc(c, stdin);
    *p = '\0';
    if((s = lookup(sbuf)) == (Symbol* )NULL)
      s = install(sbuf, UNDEF, NULL);
    yylval.sym = s;

    if(s -> type == UNDEF)
      return VAR;
    else 
      return s -> type;
  }
  if(c == '\n')
    lineno++;
  return c; 
}

void yyerror(char* s){
  warning(s, (char* )0);
}

void warning(char* s, char* t){
  fprintf(stderr, "%s: %s", progname, s);
  if(t)
    fprintf(stderr, "%s", t);
  fprintf(stderr, "\tCerca de la linea %d\n", lineno);
}
