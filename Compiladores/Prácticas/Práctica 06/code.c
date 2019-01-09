#include "hoc.h" 
#include "y.tab.h"
#include <stdio.h>
#define NSTACK 256 
static Datum stack[NSTACK];     /* Pila */
static Datum* stackp;           /* Tope de la Pila*/
#define NPROG 2000
Inst prog[NPROG];   /* La máquina virtual - RAM: Se guardan las instrucciones */
Inst* progp;        /* Siguiente lugar libre para la generación de código:
                       Dice en donde se guarda nuestra proxima instruccion */
Inst* pc;           /* Contador del programa durante la ejecución */

void initcode(){
    stackp = stack;     /* Apunta al inicio del arreglo */
    progp = prog;       /* Se guarda la dirección del primer 
                           elemento del arreglo. */
}

void push(d)
    Datum d;
{     /* Se mete d en la pila*/
    if( stackp >= &stack[NSTACK] )
        execerror("stack overflow", (char *) 0);
    *stackp++ = d;
}

Datum pop(){            /* Sacar y retornar de la pila el elemento */
    if( stackp <= stack )
        execerror("stack underflow", (char *) 0);
    return *--stackp;
}

void constpush(){       /* Meter una constante en la pila*/
    Datum d;
    d.val = ((Symbol *)*pc++)->u.vec;   /* Apunta a la entarda de 
                                           la tabla de simbolos */
    push(d);
}

void constpushd(){       /* Meter una constante en la pila*/
    Datum d;
    d.num = ((Symbol  *)*pc++)->u.comp;   /* Apunta a la entarda de 
                                           la tabla de simbolos */
    push(d);
}

void varpush(){     /* Meter una variable a la pila */
    Datum d;        /* Los elementos de la maquina virtual 
                       de la pila son de tipo Datum */
    d.sym = (Symbol  *)(*pc++);  /* Convertirmos a Symbol, lo guardamos
                                   en .sym y lo metemos en la pila */
    push(d);
}

void eval( ){
    Datum d;
    d = pop();
    if( d.sym->type == INDEF )
        execerror("undefined variable",d.sym->name); 
    d.val = d.sym->u.vec;    
    push(d);
}

/**** FUNCIONES PARA NUESTROS VECTORES ****/
//En esta sección hacemos uso de la máquina
//virtual de pila
/****                                  ****/
void add(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.val = sumaVector(d1.val, d2.val); 
    push(d1);
}

void sub(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.val = restaVector(d1.val, d2.val);
    push(d1);
}

void escalar(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.val = escalarVector(d1.num, d2.val);
    push(d1);
}

void producto_punto(){
    Datum d1, d2;
    double d3;
    d2 = pop();
    d1 = pop();
    d3 = productoPunto(d1.val, d2.val);
    push((Datum)d3);
}

void producto_cruz(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.val = productoCruz(d1.val, d2.val);
    push(d1);
}

void magnitud(){
    Datum d1;
    d1 = pop();
    d1.num = vectorMagnitud(d1.val);
    push(d1);
}

void assign( ){      /* Asigna el valor superior al siguiente valor */
    Datum d1, d2;
    d1 = pop();
    d2 = pop();
    if(d1.sym->type != VAR && d1.sym->type != INDEF)
        execerror("assignment to non-variable", d1.sym->name);
    d1.sym->u.vec = d2.val;
    d1.sym->type = VAR;
    push(d2);
}

void print(){       /* Se saca el valor del tope de la pila y se imprime */
    Datum d;
    d = pop();

    imprimeVector(d.val);
}

void printd(){       /* Se saca el valor del tope de la pila y se imprime */
    Datum d;
    d = pop();
    printf("%lf\n",d.num);
}

Inst *code(Inst f){    /* Recibe una instruccion u operando y la guarda en la RAM */
    Inst *oprogp = progp;    //EL valor actual se guarda en oprogp
    if (progp >= &prog [ NPROG ])    //Verifica si hay espacio en la RAM
		execerror("program too big", (char *) 0);
    *progp++ = f;           /* La instruccion f se guarda en la RAM 
                               y avanzamos progp*/
    return oprogp;
}

void execute( Inst* p){      /*Ejecuta instrucciones de la máquina/RAM */
    for( pc = p; *pc != STOP; ) /*Especificamos donde inicia la ejecución y se
                                 detiene en donde haya un STOP */
        (*(*pc++))();              /*Ejecutamos una función */
    
}

/********* Condicionales *********/
void mayor(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) > vectorMagnitud(d2.val) );
    push(d1);
}

void menor(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) < vectorMagnitud(d2.val) );
    push(d1);
}

void mayorIgual(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) >= vectorMagnitud(d2.val) );
    push(d1);
}

void menorIgual(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) <= vectorMagnitud(d2.val) );
    push(d1);
}

void igual(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) == vectorMagnitud(d2.val) );
    push(d1);
}

void diferente(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) != vectorMagnitud(d2.val) );
    push(d1);
}

void and(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) && vectorMagnitud(d2.val) );
    push(d1);
}

void or(){
    Datum d1, d2;
    d2 = pop();
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) || vectorMagnitud(d2.val) );
    push(d1);
}

void not(){
    Datum d1;
    d1 = pop();
    d1.num = (int)( vectorMagnitud(d1.val) == (double)0.0);
    push(d1);
}
/********* Ciclos *********/
void whilecode(){
    Datum d;
    Inst* savepc = pc;     /* Cuerpo de la iteración */
    execute(savepc + 2);    /* Condición */
    d = pop();
    while(d.val){
        execute(* ( (Inst **)(savepc) ));   /* Cuerpo del ciclo*/
        execute(savepc + 2);
        d = pop();
    }
    pc = *((Inst **)(savepc + 1)); /*Vamos a la siguiente posicion*/
}

void ifcode(){
    Datum d;
    Inst* savepc = pc;     /* Parte then */
    execute(savepc + 3);    /*condicion*/
    d = pop();
    if(d.val)
        execute(*((Inst **)(savepc)));
    else if(*((Inst **)(savepc + 1)))       /*Parte del else*/
        execute(*((Inst **)(savepc + 1)));
    pc = *((Inst **)(savepc + 2)); /*Vamos a la siguiente posicion de la pila*/
}

void bltin(){   /*Evaluar un predefinido en el tope de la pila */
    Datum d;
    d = pop();
    d.val = (*(Vector * (*)() )(*pc++))(d.val);
    push(d);    
}

/********* PRÁCTICA 6 *********/
void forcode(){
    Datum d;
    Inst* savepc = pc;
    execute(savepc + 4);
    execute(*((Inst **)(savepc)));
    //Se saca la instrucción
    d = pop();
    while(d.val){
        execute(* ( (Inst **)(savepc + 2)));   /* Cuerpo del ciclo*/
        execute(* ( (Inst **)(savepc + 1)));   // Último campo
        pop();
        execute(*((Inst **)(savepc)));          /* CONDICION */
        d = pop();
    }
    pc = *((Inst **)(savepc + 3)); /*Vamos a la siguiente posicion*/
}