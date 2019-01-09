#include "vector_cal.h"
#include "y.tab.h"
#include <stdio.h>
#include <malloc.h>
#include <math.h>
#define NSTACK 256
static Datum stack[NSTACK]; /*la pila*/
static Datum *stackp;		/*siguiente lugar libre de ls pila*/
#define NPROG 2000
Inst prog[NPROG]; /* la M�quina */
Inst *progp;	  /* siguiente sitio libre para la generaci�n de c�digo */
Inst *pc;		  /* contador de programa durante la ejecuci�n */

Inst *progbase = prog; /* empieza el subprograma actual*/
int returning;		   /* 1 si ve proposici�n  return */

typedef struct Frame
{				 /*nivel en la pila si hay llamada a proc/fun*/
	Symbol *sp;  /*entrada en la tabla de s�mbolos*/
	Inst *retpc; /*donde continuar despu�s de regresar*/
	Datum *argn; /*n-�simo argumento en la pila*/
	int nargs;   /*n�mero de argumentos*/
} Frame;

#define NFRAME 100
Frame frame[NFRAME];
Frame *fp;

double magnitud(Vector *c);

Datum *creaDatumVal(void *val)
{
	Datum *nvo = (Datum *)malloc(sizeof(Datum));
	nvo->val = val;
	return nvo;
}

Datum *creaDatumSym(Symbol *sym)
{
	Datum *nvo = (Datum *)malloc(sizeof(Datum));
	nvo->sym = sym;
	return nvo;
}

void initcode()
{
	stackp = stack;
	progp = progbase;
	fp = frame;
	returning = 0;
}

push(d)
	Datum d;
{
	if (stackp >= &stack[NSTACK])
		execerror("stack overflow", (char *)0);
	*stackp++ = d;
}

Datum pop()
{
	if (stackp <= stack)
		execerror("stack underflow", (char *)0);
	return *--stackp;
}

void constpush()
{
	Datum d;
	d.val = ((Symbol *)*pc++)->u.val;
	imprimeVector(d.val);
	push(d);
}

void varpush()
{
	Datum d;
	d.sym = (Symbol *)(*pc++);
	push(d);
}

void eval()
{
	Datum d;
	d = pop();
	if (d.sym->type != VAR && d.sym->type != INDEF)
		execerror("attempt to evaluate non-variable", d.sym->name);
	d.val = d.sym->u.val;
	push(d);
}

void add()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.val = sumaVector(d1.val, d2.val);
	push(d1);
}
void sub()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.val = restaVector(d1.val, d2.val);
	push(d1);
}

void cruz()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.val = productoCruz(d1.val, d2.val);
	push(d1);
}

void mul()
{
	Datum d1, d2;
	d1 = pop();
	d1.val = vectorEscalar(d1.val, 5.00);
	push(d1);
}

void punto()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.val = multiplicaVector(d1.val, d2.val);
	push(d1);
}

void assign()
{
	Datum d1, d2;
	d1 = pop();
	d2 = pop();
	if (d1.sym->type != VAR && d1.sym->type != INDEF)
		execerror("assignment to non-variable", d1.sym->name);
	d1.sym->u.val = d2.val;
	d1.sym->type = VAR;
	push(d1);
}
void print()
{
	Datum d;
	d = pop();
	imprimeVector(d.val);
}
void bltin()
{
	Datum d;
	d = pop();
	d.val = ((void *(*)(void *))(*pc))(d.val);
	pc = pc + 1;
	push(d);
}
Inst *code(Inst f)
{ /* lnstalar una lnstrucci�n u operando */
	Inst *oprogp = progp;
	if (progp >= &prog[NPROG])
		execerror("program too big", (char *)0);
	*progp++ = f;
	return oprogp;
}
void execute(Inst *p)
{
	for (pc = p; *pc != STOP && !returning;)
		(*(*pc++))();
}

void le()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) <= magnitud(d2.val));
	push(d1);
}

void gt()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) > magnitud(d2.val));
	push(d1);
}

void lt()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) < magnitud(d2.val));
	push(d1);
}

void eq()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) == magnitud(d2.val));
	push(d1);
}

void ge()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) >= magnitud(d2.val));
	push(d1);
}

void ne()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) != magnitud(d2.val));
	push(d1);
}

void and ()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) != 0.0 && magnitud(d2.val) != 0.00);
	push(d1);
}

void not()
{
	Datum d1;
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) == 0.0);
	push(d1);
}

void or ()
{
	Datum d1, d2;
	d2 = pop();
	d1 = pop();
	d1.numero = (double)(magnitud(d1.val) != 0.0 || magnitud(d2.val) != 0.0);
	push(d1);
}

double magnitud(Vector *c)
{
	double v;
	double x = c->vec[0] * c->vec[0];
	double y = c->vec[1] * c->vec[1];
	double z = c->vec[2] * c->vec[2];
	v = sqrt(x + y + z);
	return v;
}

void whilecode()
{
	Datum d;
	Inst *savepc = pc;

	execute(savepc + 2);
	d = pop();
	while (d.numero)
	{
		execute(*((Inst **)(savepc))); /*cuerpo */
		/*if (!returning)
			break;*/
		execute(savepc + 2);
		d = pop();
	}
	if (!returning)
		pc = *((Inst **)(savepc + 1)); /*siguiente posicion*/
}

void ifcode()
{
	Datum d;
	Inst *savepc = pc; /*parte then */
	execute(savepc + 3);
	d = pop();
	if (d.numero)
		execute(*((Inst **)(savepc)));
	else if (*((Inst **)(savepc + 1))) /*parte else*/
		execute(*((Inst **)(savepc + 1)));
	if (!returning)
		pc = *((Inst **)(savepc + 2)); /*siguiente posicion*/
}

void prexpr()
{
	Datum d;
	d = pop();
	imprimeVector(d.val);
}

// CÓDIGO AÑADIDO EN LA PRÁCTICA 7
void define(Symbol *sp)
{
	sp->u.defn = (Inst)progbase; /* principio de c�digo */
	progbase = progp;			 /* el siguiente c�digo comienza aqu� */
}

void call()
{
	Symbol *sp = (Symbol *)pc[0]; /*entrada en la tabla de s�mbolos*/
	if (fp++ >= &frame[NFRAME - 1])
		execerror(sp->name, "call nested too deeply");
	fp->sp = sp;
	fp->nargs = (int)pc[1];
	fp->retpc = pc + 2;
	fp->argn = stackp - 1; /*�ltimo argumento*/
	execute(sp->u.defn);
	returning = 0;
}

void ret()
{
	int i;
	for (i = 0; i < fp->nargs; i++)
		pop(); /*saca argumentos*/
	pc = (Inst *)fp->retpc;
	--fp;
	returning = 1;
}

void funcret()
{
	Datum d;
	if (fp->sp->type == PROCEDURE)
		execerror(fp->sp->name, "(proc) returns value");
	d = pop(); /* preservar el valor de regreso a �a funcion*/
	ret();
	push(d);
}

void procret()
{
	if (fp->sp->type == FUNCTION)
		execerror(fp->sp->name, "(func) return no value");
	ret();
}

Vector **getarg()
{
	int nargs = (int)*pc++;
	if (nargs > fp->nargs)
		execerror(fp->sp->name, "not enough arguments");
	return &fp->argn[nargs - fp->nargs].val;
}

void arg()
{ /*meter el aergumento en la pila*/
	Datum d;
	d.val = *getarg();
	push(d);
}

void argassign()
{
	Datum d;
	d = pop();
	push(d);
	*getarg() = d.val;
}

void prstr()
{
	printf("%s", (char *)*pc++);
}

void varread()
{
	Datum d;
	extern FILE *fin;
	Symbol *var = (Symbol *)*pc++;
Again:
	switch (fscanf(fin, "%lf", &var->u.val))
	{
	case EOF:
		if (moreinput())
			goto Again;
		d.val = var->u.val = NULL;
		break;
	case 0:
		execerror("non-number read into", var->name);
		break;
	default:
		d.val = NULL;
		break;
	}
	var->type = VAR;
	push(d);
}
