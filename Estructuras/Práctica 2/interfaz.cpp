/*
Autor: Edgardo Adrián Franco Martínez
Versión 1.0 (11 de Septiembre 2012)
Descripción: Programa que dibuja un bloque de "*" cuadrado de ANCHO * ALTO en la consola

El programa imprime ALTO filas de *'s columna por columna hasta la columna ANCHO.

Observaciones: El programa requerira de la libreria "presentacion.h", la cuál tiene las implementaciones 
para mover el cursor de la pantalla, esperar un tiempo y borrar pantalla, la compilación debera incluir
las definiciones de las funciones según la plataforma que se este utilizando (Windows o Linux)

Compilación: 	gcc -o marco marco.c presentacion(Win|Lin).o) (Win si se correra en Windows | Lin si se ejecutará en Linux)  "Si se tiene el código objeto"
				gcc -o marco marco.c presentacion(Win|Lin).c) (Win si se correra en Windows | Lin si se ejecutará en Linux)  "Si se tiene el código fuente"
Ejecución: Windows marco.exe  &  Linux ./marco
*/
//LIBRERIAS
#include<stdio.h>
#include<windows.h>
#include "presentacionWin.c"
#include "presentacion.h"

//CONSTANTES
#define ALTO 15			//Se define un alto de 7 caracteres
#define ANCHO 15         //Se define un ancho de 7 caracteres
#define TIEMPO_BASE	30	//Tiempo base en milisegundos
#define MULTIPLICADOR 17  //Se define un multiplicador de 8

typedef struct para_texto{
	int en_espera;
	int atendiendo;
	int ID;
	
}para_texto;

void Cajas();
void Marco();
void Texto(para_texto * texto);
//PROGRAMA PRINCIPAL
int main(void)
{
	para_texto texto[2];
	texto[0].atendiendo = 1;
	texto[0].ID = 10;
	
	Marco();
	Cajas();
	Texto(texto);
	printf("\n\n\n\n\n\n\n\n\n\n");
}

void Cajas()
{
	for (int i=0; i<9; i++)
	{
		int fila,columna;
		//Borrar la pantalla
		//BorrarPantalla();
	
		//Dibuja en las columnas
		for (columna = 1; columna<ANCHO; columna++)
		{
			MoverCursor(2+columna+(i*MULTIPLICADOR), 5);
			printf("%c", 205);
			MoverCursor(2+columna+(i*MULTIPLICADOR), ALTO+5);
			printf("%c", 205);
			EsperarMiliSeg(TIEMPO_BASE);
		}	 
		//Dibuja en las filas
		for (fila = 1; fila<ALTO; fila++)
		{
			MoverCursor(2+(i*MULTIPLICADOR), fila+5);
			printf("%c", 186);
			MoverCursor(2+ANCHO+(i*MULTIPLICADOR), fila+5);
			printf("%c", 186);
			EsperarMiliSeg(TIEMPO_BASE);
		}
		
		//Dibuja en las esquinas de la caja
		MoverCursor(2+(i*MULTIPLICADOR), 5);
		printf("%c", 02);
		MoverCursor(2+ANCHO+(i*MULTIPLICADOR), 5);
		printf("%c", 02);
		MoverCursor(2+(i*MULTIPLICADOR), ALTO+5);
		printf("%c", 01);
		MoverCursor(2+ANCHO+(i*MULTIPLICADOR), ALTO+5);
		printf("%c", 01);
	}
}

//Dibuja la información dada por el programa
void Texto(para_texto* texto)
{
	//Dibuja la información dada por el programa
	for (int i=0; i<9; i++)
	{	
		MoverCursor(4+(i*MULTIPLICADOR),9);
		printf("En espera: \n %d", texto[i].atendiendo);
		EsperarMiliSeg(TIEMPO_BASE);
		
		MoverCursor(4+(i*MULTIPLICADOR),12);
		printf("Atendiendo: \n %d", texto[i].ID);
		EsperarMiliSeg(TIEMPO_BASE);
		
		MoverCursor(4+(i*MULTIPLICADOR),15);
		printf("ID: \n %c", texto[i].ID);
		EsperarMiliSeg(TIEMPO_BASE);
	}
}

void Marco()
{
	MoverCursor(70, 3);
	printf("BANCO ESCOM B|");
	int x, y;
	//BorrarPantalla();

	for (x = 0; x <= 156 ; x++)
	{
		MoverCursor(x, 0);
		printf("%c", 205);
		MoverCursor(x, 22);
		printf("%c", 205);
		for (y = 0; y <= 22; y++)
		{
			MoverCursor(0, y);
			printf("%c", 186);
			MoverCursor(156, y);
			printf("%c", 186);
		}
	}
}	
