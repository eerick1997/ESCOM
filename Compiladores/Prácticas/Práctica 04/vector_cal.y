%{
    #include "hoc.h"
    #include <math.h>
    #include <stdio.h>
    #define MSDOS
    //Macros
    #define code2(c1, c2) code(c1); code(c2);
    #define code3(c1, c2, c3) code(c1); code(c2); code(c3);

    void yyerror(char* s);
    int yylex();
    //Funciones añadidas para la práctica 3
    void warning(char* s, char* t);
    //Funciones añadidas para la práctica 4
    void fpecatch();
    void execerror(char*s, char* t);
    extern void init();
%}  
//Definición de tipos de dato de la pila de yacc
%union{
    double comp;
    Vector* vec;
    //Añadida en la práctica 3
    Symbol* sym;
    //Añadida en la práctica 4
    Inst* inst;
} 

/**Creación de símbolos terminales y no terminales**/
%token<comp>    NUMBER     //Símbolo terminal
%type<vec>      exp        //Símbolo no terminal
%type<sym>      vect       //Símbolo no terminal
%type<sym>     number     //Símbolo no terminal
//NUEVOS SÍMBOLOS GRAMATICALES PARA LA PRÁCTICA 3
%token<sym>     VAR        //Símbolo terminal
%token<sym>     INDEF      //Símbolo terminal
%type<vec>      asgn       //Símbolo no terminal
//NUEVOS SÍMBOLOS GRAMATICALES PARA LA PRÁCTICA 4
%type<comp>     escalar
%token<sym>     VECT
%token<sym>     NUMB

/**Jerarquía de operadores**/

//Para práctica 1
%right '='
//Suma y resta de vectores
%left '+' '-'
//Escalar por un vector
%left '*'
//Producto cruz y producto punto
%left '#' '.' '|'
/**Gramática**/
%%

    list: 
      | list '\n'
      | list asgn '\n'    {code2(pop, STOP); return 1;}
      | list exp '\n'     {code2(print, STOP); return 1;}
      | list escalar '\n'  {code2(printd, STOP); return 1;}
      | list error '\n'   {yyerror;}
      ;
    
    asgn: VAR '=' exp     {code3(varpush, (Inst)$1, assign);}
    ;

    exp: vect           {code2(constpush, (Inst)$1);}
      | VAR             {code3(varpush, (Inst)$1, eval);}
      | asgn
      | exp '+' exp     {code(add);}
      | exp '-' exp     {code(sub);}
      | escalar '*' exp  {code(escalar);}
      | exp '*' escalar  {code(escalar);}
      | exp '#' exp     {code(producto_cruz);}
    ;

    escalar: number  {code2(constpushd, (Inst)$1);}
      | exp '.' exp {code(producto_punto);}
      | '|' exp '|' {code(magnitud);}
      ;

    vect: '[' NUMBER NUMBER NUMBER ']'   {  Vector* v = creaVector(3);
                                            v -> vec[0] = $2;
                                            v -> vec[1] = $3;
                                            v -> vec[2] = $4;
                                            $$ = install("", VECT, v);}
      ;

    number: NUMBER {$$ = installd("", NUMB, $1);}
    ;
%%

/****************************************************************************
*                            Código en C                                    *
****************************************************************************/
#include <stdio.h>
#include <ctype.h>
#include <signal.h>
#include <setjmp.h>

jmp_buf begin;
char * progname;
int lineno = 1;

void main(int argc, char * argv[]) {
    progname = argv[0];
    setjmp(begin);
    signal(SIGFPE, fpecatch);
    for(initcode(); yyparse (); initcode())
		execute(prog);
}

void execerror(char * s, char * t){
    warning(s, t);
    longjmp(begin, 0);
}

void fpecatch(){
    execerror("Excepcion de punto flotante", (char *)0);
}

int yylex(){
    int c;
    while ((c = getchar()) == ' ' || c == '\t')
        /**SALTA BLANCOS**/;

    if (c == EOF)
      return 0;

    if (isdigit(c) ) {
        ungetc(c, stdin);
        scanf("%lf\n", &yylval.comp);
        return NUMBER;
    }

    if (isalpha(c)) {
        Symbol * s;
        char sbuf[200];
        char * p = sbuf;
        do {
          *p++=c;
        } while((c = getchar()) != EOF && isalnum(c));

        ungetc(c, stdin);
        *p = '\0';
        if ((s = lookup(sbuf)) == (Symbol *)NULL)
          s = install(sbuf, INDEF, NULL);
        yylval.sym = s;

        if (s->type == INDEF)
          return VAR;
        else
          return s->type;
    }

    if( c == '\n')  
      lineno++;
    return c;
}

void yyerror(char * s){     /* Llamada por yyparse ante un error */
  warning(s, (char *)0);
}

void warning(char * s, char * t) {
    fprintf(stderr, "%s: %s",progname,s);
    if (t)
        fprintf(stderr, "%s",t);
    fprintf(stderr, "Cerca de la linea %d\n",lineno);
}