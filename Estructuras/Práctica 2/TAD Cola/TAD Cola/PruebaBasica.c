/*
AUTOR: Edgardo Adrián Franco Martínez (C) Septiembre 2012
VERSIÓN: 1.3

DESCRIPCIÓN: Ejemplo basico del uso de una cola 
el cuál encola 10 numeros y los desencola.

OBSERVACIONES: Se puede emplear la libreria TADColaEst.h, TADPilaEstCir.h o TADColaDin.h implementadas
en clase. Ambas estructuras elemento, ya sea la de las implementaciónes estáticas o dinámica deberán 
tener un campo int n;

COMPILACIÓN: 	gcc -o PruebaBasica PruebaBasica.c TADCola/TADCola(Din|Est|EstCirc).o (Si se tiene el objeto de la implementación)
				gcc -o PruebaBasica PruebaBasica.c TADCola/TADCola(Din|Est|EstCirc).c (Si se tiene el fuente de la implementación)

EJECUCIÓN: PruebaBasica.exe (En Windows) - ./PruebaBasica (En Linux)
*/

//LIBRERAS
#include <stdio.h>
#include "TADCola/TADColaEst.h" 	//Si se usa la implemtentación dinámica (TADColaDin.c)
//#include "TADCola/TADColaDin.h" 	//Si se usa la implemtentación estática (TADColaEst.c|TADColaEstCirc.c)

//PROGRAMA PRINCIPAL
int main(void)
{
	int i; //Variable para ciclos
	//Declaración de una cola c
	cola c;
	//Declaración de un elemento e
	elemento e;
	
	
	//Inicialización de la cola
	Initialize(&c);
	
	//Introducir los 10 numeros a la cola
	for(i=0;i<10;i++)
	{
		printf("\nDame el %d numero entero: ",i+1);
		scanf("%d",&e.n);
		Queue(&c, e);
	}
	
	//Desencolar los 10 numeros de la cola
	for(i=0;i<10;i++)
	{
		e= Dequeue(&c);
		printf("\n%d",e.n);
	}
	
	//Destruir la cola
	Destroy(&c);
	
	return 0;
}

