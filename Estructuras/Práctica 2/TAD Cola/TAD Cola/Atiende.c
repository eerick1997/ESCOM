/*
AUTOR: Edgardo Adrián Franco Martínez (C) Septiembre 2016
VERSIÓN: 1.4

DESCRIPCIÓN: Ejemplo de atención de una cola de clientes, la simulación
de tiempo se reliza con la función Sleep(Solo funciona en Windows), cada X
tiempo llega un cliente y el tiempo de atención es Y.

OBSERVACIONES: Se puede emplear la libreria TADColaEst.h, TADPilaEstCir.h o TADColaDin.h implementadas
en clase. Ambas estructuras elemento, ya sea la de las implementaciónes estáticas o dinámica deberán
tener un campo int n;

COMPILACIÓN: 	gcc -o Atiende Atiende.c TADCola/TADCola(Din|Est|EstCirc).o (Si se tiene el objeto de la implementación)
				gcc -o Atiende Atiende.c TADCola/TADCola(Din|Est|EstCirc).c (Si se tiene el fuente de la implementación)

EJECUCIÓN: Atiende.exe (En Windows)
*/

//LIBRERAS
#include <stdio.h>
#include <windows.h>				//Funciona unicamente en Windows para usar la función Sleep()
//#include "TADCola/TADColaEst.h" 	//Si se usa la implemtentación dinámica (TADColaDin.c)
#include "TADCola/TADColaDin.h" 	//Si se usa la implemtentación estática (TADColaEst.c|TADColaEstCirc.c)

//DEFINICION DE CONSTANTES
#define TIEMPO_BASE	200			//Tiempo base en ms
#define TIEMPO_CLIENTE	2		//Tiempo base en ms * 2 =400ms
#define TIEMPO_ATENCION	4		//Tiempo base en ms * 1 =800ms

//PROGRAMA PRINCIPAL
int main(void)
{
	unsigned int tiempo = 0;
	unsigned int cliente = 0;
	elemento e;
	cola mi_cola;
	Initialize(&mi_cola);

	//Ciclo infinito
	while (1)
	{
		Sleep(TIEMPO_BASE);	//Esperar el tiempo base
		tiempo++;			//Incrementar el contador de tiempo

		//Si el tiempo es multiplo del de atención, atender al primero de la cola
		if (tiempo % TIEMPO_ATENCION == 0)
		{
			//Si hay alguien por atender
			if (!Empty(&mi_cola))
			{
				e = Dequeue(&mi_cola);
				printf("\nAtendi a: %d", e.n);
			}
			//Si la cola es vacia
			else
			{
				printf("\nNo hay alguien por atender");
			}
		}

		//Si el tiempo es multiplo del tiempo de llegada de los clientes,
		//formar un cliente nuevo
		if (tiempo % TIEMPO_CLIENTE == 0)
		{
			cliente++;			//Incrementar el numero de clientes que se ha formado
			e.n = cliente;		//Introducir el numero del cliente en un elemento
			Queue(&mi_cola, e);	//Encolar al nuevo cliente
			printf("\nLlego el cliente: %d", e.n);
		}

		//Mostrar el número de clientes en la cola
		printf("\n%d clientes en cola",Size(&mi_cola));
	}
	return 0;
}
