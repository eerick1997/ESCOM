/*
IMPLEMENTACION DE LA LIBRERIA DEL TAD COLA ESTATICA (TADColaEst.h)
AUTOR: Edgardo Adrián Franco Martínez (C) Septiembre 2013
VERSIÓN: 1.4

DESCRIPCIÓN: TAD cola o Queue.
Estructura de datos en la que se cumple:
Los elementos se insertan en un extremo (el posterior) y 
la supresiones tienen lugar en el otro extremo (frente).

OBSERVACIONES: Hablamos de una Estructura de datos dinámica 
cuando se le asigna memoria a medida que es necesitada, 
durante la ejecución del programa. 

COMPILACIÓN PARA GENERAR EL CÓDIGO OBJETO: gcc -c TADColaDin.c
*/

//LIBRERAS
#include "TADColaDin.h"
#include <stdio.h>
#include <stdlib.h>

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
	c->frente = NULL;
	c->final = NULL;
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
	//Apuntador a elemento 
	nodo * aux; 
	
	//Crear un bloque de memoria para un elemento y mantener su referencia en aux	
	aux=malloc(sizeof(nodo));
	
	//Si malloc no pudo devolver un bloque de memoria indicar el error
	if(aux==NULL)
	{
		printf("\nERROR: Desbordamiento de cola");
		exit(1);		
	}
	
	//Introducir el elemento al bloque referenciado por aux
	aux->e = e;
	
	//Colocar el NULL a el apuntador siguiente del nuevo elemento
	aux->siguiente = NULL;
	
	//Si la cola esta vacia, los apuntadores de la cola apuntarán al nuevo elemento
	if (c->num_elem==0)
	{
		c->frente = aux;
		c->final = aux;
	}
	//Si la cola ya tiene elementos
	else
	{
		//El elemento del final apuntará al nuevo elemento 		
		c->final->siguiente = aux;
		//El final de la cola apuntará al nuevo elemento
		c->final = aux;
	}
	//Incrementar el número de elementos en la cola 
	c->num_elem++;
	
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
	elemento e;	//Elemento a retornar
	nodo *aux; //Apuntador auxiliar 
	
	//Si la cola esta vacia (Subdesbordamiento de cola)
	if(c->num_elem==0)
	{
		printf("\nERROR: Subdesbordamiento de cola");
		exit(1);
	}
	//Si la cola tiene elementos
	else
	{
		//Almacenar el elemento a retornar
		e = c->frente->e;
		
		//Guardar la dirección del siguiente nodo
		aux=c->frente->siguiente;
		
		//Destruir el bloque de memoria del elemento al frente
		free(c->frente);	
		
		//Decrementar el número de eleme en la cola
		c->num_elem--;

		//El nuevo frente de la cola es aux (Siguiente del frente)
		c->frente = aux;
		
		//Si la cola ha quedado vacia se inicializa (c->frente=NULL, c->final=NULL)
		if(c->num_elem==0) 
		{
			Initialize(c);
		}
	}
	
	//Retornar al elemento desencolado
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
	return c->frente->e;
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
	return c->final->e;
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
	nodo * aux;	//Apuntador auxiliar a elemento	
	
	//Mientras el apuntador del frente de la cola no sea NULL
	while(c->frente != NULL)
	{
		//Guardar la referencia al frente
		aux = c->frente;
		
		//El nuevo frente es el siguiente
		c->frente = c->frente->siguiente;
		
		//Liberar el antiguo frente de memoria
		free(aux);
	}
	
	//El número de elementos en la cola es 0
	c->num_elem=0;
	
	//Colocar el frente (ya quedo en NULL según como se fue destruyendo) y final inicializado
	c->final = NULL;
}
