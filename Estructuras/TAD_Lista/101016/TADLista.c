/*
IMPLEMENTACIONES DE LA LIBRERIA DEL TAD LISTA (TADLista.h)
AUTOR: Edgardo Adrián Franco Martínez (C) Octubre 2016
VERSIÓN: 1.0

DESCRIPCIÓN: TAD lista o (list)
Estructura de datos en la que se cumple:
Los elementos se consultan, añaden y se remueven con base en posiciones 
dentro de un arreglo lineal el cual cuenta con un frente o cabeza 
y un final o cola.

OBSERVACIONES: Hablamos de una Estructura de datos dinámica de una lista
doblemente ligada.

Frente                                                       Final
      ******    ******    ******    ******    ******    ******
NULL<-*    * <- *    * <- *    * <- *    * <- *    * <- *    *
      * e1 *    * e2 *    * e3 *    * e4 *    * e5 *    * e6 *
      *    * -> *    * -> *    * -> *    * -> *    * -> *    * -> NULL
      ******    ******    ******    ******    ******    ******    


COMPILACIÓN PARA GENERAR EL CÓDIGO OBJETO: gcc -c TADLista.c
*/

//LIBRERAS
#include<stdio.h>
#include<stdlib.h>
#include "TADLista.h"

//DEFINICIÓN DE FUNCIONES

/***************************************************
Operaciones de construcción
***************************************************/
/*
void Initialize(lista *l)
Descripción: Inicializar pila (Iniciar una pila para su uso)
Recibe: int *s (Referencia a la pila "s" a operar)
Devuelve:
Observaciones: El usuario a creado una pila y s tiene la referencia a ella, 
si esto no ha pasado se ocasionara un error.
*/
void Initialize(lista *l)
{
	l->frente = NULL;
	l -> final = NULL;
	l->tam = 0;
	return;
}

void Destroy(lista *l)
{
	
}

/***************************************************
Operaciones de posicionamiento y busqueda
***************************************************/
posicion Final(lista *l)
{
	return l->final;
}

posicion First(lista *l)
{
	return l->frente;
}

posicion Following(lista *l, posicion p)
{
	if(ValidatePosition(l,p))
	{
		return p->atras;
	}
	else
	{
		printf("ERROR: Following(posicion no valida o  lista vacia)");		
		exit(1);
	}	
}

posicion Previus(lista *l, posicion p)
{
	
	if(ValidatePosition(l,p))
	{
		return p->adelante;
	}
	else
	{
		printf("ERROR: Previus(posicion no valida o  lista vacia)");		
		exit(1);
	}
}

posicion Search(lista *l, elemento e)
{
	posicion r=NULL,aux;
	
	if (l->tam>0)
	{
		aux=l->frente;
		while (aux!=NULL&&r!=NULL)
		{
			if(memcmp(&e,&aux->e,sizeof(elemento))==0)
			{
				r=aux;
			}
			else 
			{
				aux=aux->atras;
			}
		}
	}
	return r;
	
	
}

//***************************************************
//Operaciónes de consulta
//***************************************************
elemento Position(lista *l, posicion p)
{
	if(ValidatePosition(l,p))
	{
		return p->e;
	}
	else
	{
		printf("ERROR: Position(La poscion es invalida)");
		exit(1);
	}
}

int Size(lista *l)
{
	return l->tam;
}

boolean Empty(lista *l)
{
	return (l->tam > 0) ? FALSE : TRUE;	
}

boolean ValidatePosition(lista *l, posicion p)
{
	
}


//***************************************************
//Operaciones de modificación
//***************************************************
void Insert(lista *l, elemento e, posicion p,boolean b)
{
	
}

void Add(lista *l,elemento e)
{
}

void Remove(lista *l,posicion p)
{
}

void Replace(lista *l,posicion p, elemento e)
{
}
