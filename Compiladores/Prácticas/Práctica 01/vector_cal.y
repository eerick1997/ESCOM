%{
    #include<stdio.h>
    #include<stdlib.h>
    #include<math.h>
    #include <ctype.h>
    #include"vector_cal.c"

    int  yyerror(char *s);
    int yylex();
%}
//Definición de tipos de dato de la pila de yacc
%union{
    double val;
    Vector *vector;
}

/**Creación de símbolos terminales y no terminales**/
%token<val>       NUMBER      //Símbolo terminal

%type<vector>    exp        //S+imbolo no terminal
%type<vector>    vector    //Símbolo no terminal
%type<val>          number      //Símbolo no terminal

/**Jerarquía de operadores**/
//Suma y resta de vectores
%left '+' '-'
//Escalar por un vector
%left '*'
//Producto cruz y producto punto
%left 'x' '.'

/**Gramática**/
%%
  /**
    * inputString -> inputString list
  **/
    inputString:
      | inputString list;
      ;

  /**
    * list -> '\n'          |
    * list -> exp '\n'      |
    * list -> number '\n'   |
  **/
    list: '\n'
      | exp     '\n'  {imprimeVector($1);}
      | number  '\n'  {printf("%lf\n", $1);}
      ;

    /** 
      * exp -> vector         |
      * exp -> exp '+' exp    |
      * exp -> exp '-' exp    |
      * exp -> exp '*' NUMBER |
      * exp -> NUMBER * exp   |
      * exp -> exp 'x' exp    |
    **/
    exp: vector
    //Suma de vectores
      | exp '+' exp     {$$ = sumaVector($1, $3);}
    //Resta de vectores
      | exp '-' exp     {$$ = restaVector($1, $3);}
    //Multiplicación por un escalar caso 1
      | exp '*' NUMBER     {$$ = escalarVector($3, $1);}
    //Multiplicación por un escalar caso 2
      | NUMBER '*' exp  {$$ = escalarVector($1, $3);}
    //Producto cruz
      | exp 'x' exp     {$$ = productoCruz($1, $3);}
    ;
    /**
      * number -> NUMBER

    **/
    number: NUMBER
      | vector '.' vector {$$ = productoPunto($1, $3);}
      | '|' vector '|' {$$ = vectorMagnitud($2);}
      ;

    /**
      * vector -> NUMBER NUMBER NUMBER
    **/
    vector : '[' NUMBER NUMBER NUMBER ']' {Vector *v = creaVector(3);
                                            v -> vec[0] = $2;
                                            v -> vec[1] = $3;
                                            v -> vec[2] = $4;
                                            $$ = v;}
      ;
%%

/****************************************************************************
*                                                                              Código en C                                                                               *
****************************************************************************/

void main(){
  yyparse();
}

int yylex (){
  	int c;
  	while ((c = getchar ()) == ' ' || c == '\t')
  		;
 	if (c == EOF)
    		return 0;
  if(isdigit(c)){
      ungetc(c, stdin);
      scanf("%lf", &yylval.val);
      return NUMBER;
  }
  return c;
}

int yyerror(char *s){
  printf("%s\n", s);
  return 0;
}
