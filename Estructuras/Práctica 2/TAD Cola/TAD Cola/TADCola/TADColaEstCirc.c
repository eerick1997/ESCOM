/*
IMPLEMENTACION DE LA LIBRERIA DEL TAD COLA ESTATICA (TADColaEst.h) 
*DE MANERA CIRCULAR (Modificando las implementaciónes al modelo circular)
AUTOR: Edgardo Adrián Franco Martínez (C) Septiembre 2016
VERSIÓN: 1.5

DESCRIPCIÓN: TAD cola o Queue.
Estructura de datos en la que se cumple:
Los elementos se insertan en un extremo (el posterior) y 
la supresiones tienen lugar en el otro extremo (frente).

OBSERVACIONES: Hablamos de una Estructura de datos estática cuando 
se le asigna una cantidad fija de memoria para esa estructura 
antes de la ejecución del programa.

Una cola circular es un modelo estatico que eficientiza el proceso de desencolar 
elementos en el espacio con el que cuenta para almacenar los elementos dentro del TAD
Cola. Logrando nunca mover de memoria a los elementos una vez que son desencolados y 
hasta que son desencolados.

COMPILACIÓN PARA GENERAR EL CÓDIGO OBJETO: gcc -c TADColaEstCir.c
*/

//LIBRERAS
#include "TADColaEst.h"
#include<stdio.h>
#include<stdlib.h>

//DECLARACIÓN DE FUNCIONES (AUXILIARES PROPIAS DE ESTE CÓDIGO NO SON PARA EL USUARIO DE LA COLA)
int IncrementaIndice(int n); //Contador de anillo que se resetea al llegar a MAX_ELEMENT

//DEFINICIÓN DE FUNCIONES
/*
void Initialize(cola *c);
Descripción: Inicializar cola (Iniciar una cola para su uso)
Recibe: cola *c (Referencia a la cola "c" a operar)
Devuelve:
Observaciones: El usuario a creado una cola y c tiene la referencia a ella, 
si esto no ha pasado se ocasionara un error.
*/
void Initialize(cola * c)
{
	c->frente=-1;
	c->final=-1;
	c->num_elem=0;
	return;
}

/*
void Queue(cola * c, elemento e);
Descripción: Recibe una cola y agrega un elemento al final de ella.
Recibe: cola *c (Referencia a la cola "c" a operar) elemento e (Elemento a encolar)
Devuelve:
Observaciones: El usuario a creado una cola y ha sido inicializada y c tiene la referencia a ella, 
si esto no ha pasado se ocasionara un error.
*/
void Queue(cola * c, elemento e)
{		
	//Si el número de elementos en la cola aún no rebasa el tamaño maximo
	if(c->num_elem<=(MAX_ELEMENT-1))
	{
		//Incrementa el final
		c->final=IncrementaIndice(c->final);
		//Introduce el elemento
		c->elementos[c->final]=e;
		
		//Si la cola estaba vacia se incrementa el frente también
		if(c->frente==-1)
			c->frente++;
		//Aumenta el número de elementos en la cola
		c->num_elem++;
	}	
	else //Desbordamiento de cola
	{
		printf("\nERROR: Desbordamiento de cola");
		exit(1);
	}		
	return;
}

/*
elemento Dequeue(cola * c);
Descripción: Recibe una cola y devuelve el elemento que se encuentra al 
frente de esta, quitándolo de la cola.
Recibe: cola *c (Referencia a la cola "c" a operar)
Devuelve: elemento (Elemento desencolado)
Observaciones: El usuario a creado una cola y la cola tiene elementos, si no 
se genera un error y se termina el programa.
*/
elemento Dequeue(cola * c)
{
	elemento e;//Elemento a retornar 
	int i;
	//Si el número de elementos en la cola es diferente de 0
	if(c->num_elem!=0)
	{	
		e=c->elementos[c->frente];
		c->num_elem--;
		c->frente=IncrementaIndice(c->frente);
		
		//Si se desencolo al ultimo elemento
		if(c->num_elem==0)
			Initialize(c);
	}
	else //Subdesbordamiento de cola
	{
		printf("\nERROR: Subdesbordamiento de cola");
		exit(1);
	}
	//Retornar al elemento
	return e;
}
/*
boolean Empty(cola * c);
Descripción: Recibe una cola y TRUE si la cola esta vacia y FALSE en caso contrario
Recibe: cola *c (Referencia a la cola "c" a verificar)
Devuelve: boolean TRUE O FALSE
Observaciones: El usuario a creado una cola y la cola fue correctamente inicializada
*/
boolean Empty(cola * c)
{
	return (c->num_elem==0) ? TRUE : FALSE;
}

/*
elemento Front(cola * c);
Descripción: Recibe una cola y devuelve el elemento que se encuentra al frente de esta.
Recibe: cola *c (Referencia a la cola "c")
Devuelve: elemento del frente de la cola
Observaciones: El usuario a creado una cola,la cola fue correctamente inicializada, esta 
tiene elementos de lo contrario devolvera ERROR. *No se modifica el TAD
*/
elemento Front(cola * c)
{
	return c->elementos[c->frente];
}

/*
elemento Final(cola * c);
Descripción: Recibe una cola y devuelve el elemento que se encuentra al final de esta.
Recibe: cola *c (Referencia a la cola "c")
Devuelve: elemento del final de la cola
Observaciones: El usuario a creado una cola,la cola fue correctamente inicializada, esta 
tiene elementos de lo contrario devolvera ERROR. *No se modifica el TAD
*/
elemento Final(cola * c)
{
	return c->elementos[c->final];
}

/*
int Size(cola * c);
Descripción: Recibe una cola y devuelve el número de elemento que se encuentran en esta.
Recibe: cola *c (Referencia a la cola "c")
Devuelve: int (Tamaño de la cola)
Observaciones: El usuario a creado una cola,la cola fue correctamente inicializada, esta 
*No se modifica el TAD
*/
int Size(cola * c)
{
	return c->num_elem;
}

/*
void Destroy(cola * c);
Descripción: Recibe una cola y la libera completamente.
Recibe: cola *c (Referencia a la cola "c" a operar)
Devuelve:
Observaciones: La cola se destruye y se inicializa.
*/
void Destroy(cola * c)
{
	Initialize(c);	//Inicilizar la cola (c->frente = c->final =-1 c->num_elem=0)
}

/*
int IncrementaIndice(int n);
Descripción: Función auxiliar para tratar el incremento del indice de frente o final
de cola como una cola circular (Contador de anillo que se ressetea al llegar a MAX_ELEMENT).
Recibe: int n(Indice a incrementar)
Devuelve: int (Indice incrementado haciendo un conteo en anillo)
Observaciones: MAX_ELEMENT determinar el incremento o reseteo del indice.
*/
int IncrementaIndice(int n)
{
	n++;
	if(n==MAX_ELEMENT) //Si se alcanza al número máximo de conteo regresar a 0
	{
		n=0;
	}
	return n;
}
