#include "vector_cal.h"
#include <string.h>
typedef struct Symbol { /* entrada de la tabla de s�mbolos */
	char* name;
	short type;   /* VAR, BLTIN, UNDEF */
	union {
		double comp;	       /* si es VAR */
		Vector* (*ptr)();      /* s� es BLTIN */
		Vector* vec;
	} u;
	struct Symbol* next;  /* para ligarse a otro */ 
} Symbol;

Symbol* install(char* s, int t, Vector* vec);
Symbol* lookup(char* s);

typedef union Datum{
  Vector* val;
  double num;
  Symbol* sym;   /*Apunta a una entrada en la tabla de simbolos */
  int eval;
}Datum;

extern Datum pop();
typedef int (*Inst)(); /* Instruccion de maquina:
                          Es un apuntador a funcion*/

#define STOP (Inst) 0
extern Inst prog[];
extern Inst* progp;
extern Inst* code();

extern void assign();
extern void varpush();
extern void constpush();
extern void print();
extern void printd();
extern void constpushd();
extern void bltin();

extern void eval();
extern void add();
extern void sub();
extern void producto_cruz();
extern void producto_punto(); 
extern void magnitud();
extern void escalar();


//Condiciones
extern void mayor();
extern void menor();
extern void mayorIgual();
extern void menorIgual();
extern void igual();
extern void diferente();
extern void and();
extern void or();
extern void not();

//Ciclos
extern void whilecode();
extern void ifcode();
extern void prexpr();

//PRÁCTICA 6
extern void forcode();