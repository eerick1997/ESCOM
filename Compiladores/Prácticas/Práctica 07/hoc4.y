%{
#include <stdio.h>
#include <math.h>
#include "vector_cal.h"
#define code2(c1,c2) 		code(c1); code(c2)
#define code3(c1,c2,c3)		code(c1); code(c2); code(c3)

void warning(char *s, char *t);
int yyerror (char *s);
void execerror(char *s, char *t);
void run();
int indef;

%}


%union{
	Symbol *sym; /*apuntador de la tabla de símbolos*/
	Inst *inst; /* instrucción de máquina*/
	double val;
	Vector *vec;
	int narg;/*Nùmero de argumentos*/
}


%token <sym> VAR BLTIN INDEF VEC NUMERO WHILE IF ELSE PRINT STRING
%token <sym> FUNCTION PROCEDURE RETURN FUNC PROC READ
%token <narg> ARG
%token <val> NUMBER 
//Agregue la siguiente linea
%type <inst> stmt asgn exp stmtlist cond while if end prlist begin
%type <sym> vector
%type <sym> procname
%type <narg> arglist
//%type <vec> exp asgn
%left '+' '-'
%left '*' 
%left '#' '.'
//Agregue la siguiente linea
%left OR
%left AND
%left GT GE LT LE EQ NE
%left NOT
//Sección de reglas de yacc
%% 
	list: 
		| list '\n'
		| list defn  '\n'
		| list asgn '\n'{code2(pop,STOP); return 1;} 
		| list stmt '\n' {code(STOP); return 1;}
		| list exp '\n'{code2(print,STOP); return 1;}
		| list error '\n' {yyerror;}
		;

	asgn: VAR '=' exp {$$ = $3; code3(varpush,(Inst)$1,assign);} 
		| ARG '=' exp {defonly("$");code2(argassign,(Inst)$1); $$ = $3;}
		;
		
	stmt: exp	  							{code(pop);}
		| RETURN 							{defonly("return");code(procret);} 
		| RETURN exp 						{defonly("return");$$=$2;code(funcret);}
		
		| PRINT prlist						{ $$  = $2;}
		| while cond stmt end 				{
											($1)[1] = (Inst)$3;  /* cuerpo de la iteración*/
											($1)[2] = (Inst)$4;  /* terminar si la condición no se cumple*/}  

		| if cond stmt end 					{ /* proposición if que no emplea else*/
				
											($1)[1] = (Inst)$3; /* parte then */
											($1)[3] = (Inst)$4; } /* terminar si la condición no se cumple */

		| if cond stmt end ELSE stmt end	{ /* proposición if ocn parte else*/
											($1)[1] = (Inst)$3; /*parte then*/
											($1)[2] = (Inst)$6; /*paret else*/
											($1)[3] = (Inst)$7; } /*terminar si la condición no se cumple*/
		| '{' stmtlist '}'  				{ $$ = $2;} 					

	;

	cond: '(' exp ')' 						{code(STOP); $$ = $2;}
	;

	while: WHILE 							{ $$ = code3(whilecode,STOP,STOP);}
	;

	if: IF 									{ $$ = code(ifcode); code3(STOP,STOP,STOP);}
	;

	end: /* nada */  						{code(STOP); $$ = progp; }
	;

	stmtlist: /* nada */					{$$ = progp;}
			| stmtlist '\n'
			| stmtlist stmt
	;

	exp: vector 							{$$ = code2(constpush, (Inst)$1);}
		|VAR 								{$$ = code3(varpush,(Inst)$1,eval);}
		|ARG 								{defonly("$"); $$ = code2(arg,(Inst)$1);}
		|asgn
		|FUNCTION begin '(' arglist ')'		{ $$ = $2; code3(call,(Inst)$1,(Inst)$4);}
		|READ '(' VAR ')' 					{$$= code2(varread,(Inst)$3);}
		|BLTIN '(' exp ')' 					{code2(bltin,(Inst)$1->u.ptr);}
		|exp '+' exp 						{code(add);}
		|exp '-' exp 						{code(sub);}
		|exp '.' exp 						{code(punto);}
		|exp '*' NUMBER 					{code(mul);}
		|NUMBER '*' exp 					{code(mul);}
		|exp '#' exp 						{code(cruz);}
		|exp GT exp 						{code(gt);}
		|exp GE exp 						{code(ge);}
		|exp LT exp 						{code(lt);}
		|exp LE exp 						{code(le);}
		|exp EQ exp 						{code(eq);}
		|exp NE exp 						{code(ne);}
		|exp AND exp 						{code(and);}
		|exp OR exp 						{code(or);}
		|NOT exp 							{$$ = $2; code(not);}
		|PROCEDURE begin '(' arglist ')'	{ $$ = $2; code3(call,(Inst)$1,(Inst)$4);}
	;

	begin:/*nada */ 						{$$ = progp;}
	;

	prlist: exp								{code(prexpr);}
		| STRING 							{$$  = code2(prstr,(Inst)$1);}
		| prlist ',' exp					{code(prexpr);}
		| prlist ',' STRING 				{code2(prstr,(Inst)$3);}
	;

	defn:  FUNC procname 					{$2->type=FUNCTION; indef =1;}
											'(' ')' stmt {code(procret);define($2);indef=0;}
		|PROC procname 					{$2->type = PROCEDURE; indef = 1;}
											'(' ')' stmt {code(procret);define($2); indef=0;}

	;

	procname: VAR
		| FUNCTION
		| PROCEDURE		
	;

	arglist: /*nada*/						{$$=0;}
		| exp 								{$$ = 1;}
		| arglist ',' exp					{$$ = $1 + 1;}
	;

	vector:'['NUMBER NUMBER NUMBER']'		{Vector *v = creaVector(3);
											v->vec[0] = $2;
											v->vec[1] = $3;
											v->vec[2] = $4;
											$$ = install("",VEC,v);}
	;

%%
#include <stdio.h>
#include <ctype.h>
#include <signal.h>
#include <setjmp.h>
#include <string.h>

char	*progname;
int 	lineno = 1;
jmp_buf  begin;
int 	indef;
char 	*infile;
FILE	*fin;
char	**gargv;
int 	gargc;
int 	c;/*global for use by warning()*/


int yylex (){
  	int c;
  	while ((c = getchar ()) == ' ' || c == '\t')  
  		/*SALTA BLANCOS*/;
 	if (c == EOF)                            
    	return 0;
  	if (isdigit (c)){
		double d;
      	ungetc (c, stdin);
      	scanf ("%lf", &yylval.val);
	    return NUMBER;
    }
	if(isalpha(c)){
		Symbol *s;
		char sbuf[200], *p=sbuf;
		do {
			*p++=c;
		} while ((c=getchar())!=EOF && isalnum(c));
		ungetc(c, stdin);
		*p='\0';
		if((s=lookup(sbuf))==(Symbol *)NULL)
			s=install(sbuf, INDEF,NULL);
		yylval.sym=s;   
        if(s->type == INDEF)
			return VAR;
        else 
            return s->type; 
	}
  	if(c == '\n')
		lineno++;
	if( c == '$'){ /*¿Argumento?*/
		int n = 0;
		while(isdigit(c=getc(fin)))
			n =  10 * n + c - '0';
		ungetc(c,fin);
		if(n == 0)
			execerror("strange $...", (char *)0);
		yylval.narg = n;
		return ARG;
	}
	if( c == '"'){/*cadena entrecomillada*/
		char sbuf[100], *p,*emalloc();
		for(p=sbuf;(c=getc(fin))!= '"';p++){
			if(c == '\n' || c == EOF)
				execerror("missing quote","");
			if(p >= sbuf + sizeof(sbuf) - 1){
				*p = '\0';
				execerror("string too long",sbuf);			
			}
			*p = backslash(c);
		}
		*p = 0;
		yylval.sym = (Symbol *)emalloc(strlen(sbuf)+1);
		strcpy(yylval.sym, sbuf);
		return STRING;
	}
	switch (c){
	case '>':	return follow('=',GE,GT);
	case '<':	return follow('=',LE,LT);
	case '=':	return follow('=',EQ,'=');
	case '!':	return follow('=',NE,NOT);
	case '|':	return follow('|',OR,'|');
	case '&':	return follow('&',AND,'&');
	case '\n':	lineno++; return '\n';
	default:	return c;
	}
  	return c;                                
}
follow (expect,ifyes,ifno)
{
	int c = getchar();

	if(c == expect)
		return ifyes;
	ungetc(c, stdin);
	return ifno;
}

void defonly(char *s)	/*advertencia en caso de definición ilegal*/
{
	if(!indef)
		execerror(s,"used outside definition");
}

void execerror(char *s, char *t){
	warning(s, t);
	longjmp(begin, 0);
}

void fpecatch(){
	execerror("excepcion de punto flotante", (char *)0);
}

int main (int argc, char *argv[]){	
   int i;
   void fpecatch();
   progname = argv[0];
   if(argc == 1){	/*fake an argument list*/
	static char *stdinonly[] = { "-"};
	gargv = stdinonly;
	gargc = 1;
   }else{
	gargv = argv +1;
	gargc = argc -1;
   }
   init();
   while(moreinput())
	run();
   return 0;
}

void moreinput()
{
	if(gargc--<=0)
		return 0;
	if(fin && fin !=stdin)
		fclose(fin);
	infile = *gargv++;
	lineno = 1;
	if(strcmp(infile,"-") == 0){
		fin = stdin;
		infile = 0;
	}else if((fin =fopen(infile,"r")) ==NULL){
		fprintf(stderr,"%s: cannot open %s\n",progname,infile);
		return moreinput();
	}
	return 1;
}

void run()/* ejecutar hasta al fin de archivo (EOF)*/
{
	setjmp(begin);
	signal(SIGFPE,fpecatch);
	for(initcode();yyparse();initcode())
		execute(progbase);
}

int yyerror (char *s) {
   printf("%s",s);
   return 0;
}

void backslash(c) /*obtener el siguiente caràcter con las \ interpretadas */
int c;
{
	char *index(); /* 'strchr()' en algunos sistemas */
	static char transtab[] ="b\bf\fn\nr\rt\t";
	if( c != '\\')
		return c;
	c = getc(fin);
	if( islower(c) && index(transtab,c))
		return index(transtab,c)[1];
	return c;
}


void warning(char *s, char *t)
{
	//fprintf (stderr, "%s: %s", progname, s);
	//if(t)
		//fprintf (stderr, " %s", t);
	//fprintf (stderr, "cerca de la linea %d\n", lineno);
}
