//****************************************************************************
//Josue Macias Castillo, Eduardo Torres Hernandez, Erick Efrain Vargas Romero 
//Curso: Análisis de algoritmos
//(C) Septiembre 2018
//ESCOM-IPN
//Algoritmo de ordenamiento por seleccion
//Compilación: "g++ Seleccion.cpp -o select"
//Ejecución: ./select (Linux y MAC OS), select.exe (Windows)
//****************************************************************************
//****************************************************************************
//LIBRERIAS
//****************************************************************************
#include<stdio.h>
#include "tiempo.h"
#include<iostream>
using namespace std;
//****************************************************************************
//DEFINICIONES
//****************************************************************************
//#define N 10000000
//****************************************************************************
//PROGRAMA PRINCIPAL
//****************************************************************************
int main(int argc, char *argv[])
{
    //******************************************************************	
	//Variables del main
	//******************************************************************	
	double utime0, stime0, wtime0,utime1, stime1, wtime1; //Variables para medición de tiempos
	int n; 	//n determina el tamaño del algorito dado por argumento al ejecutar
	int i; //Variables para loops

	//******************************************************************	
	//Recepción y decodificación de argumentos
	//******************************************************************	

	//Si no se introducen exactamente 2 argumentos (Cadena de ejecución y cadena=n)
	if (argc!=2) 
	{
		printf("\nIndique el tamanio del algoritmo - Ejemplo: [user@equipo]$ %s 100\n",argv[0]);
		exit(1);
	} 
	//Tomar el segundo argumento como tamaño del algoritmo
	else
	{
		n=atoi(argv[1]);
	}
	
	//******************************************************************	
	//Iniciar el conteo del tiempo para las evaluaciones de rendimiento
	//******************************************************************	
	uswtime(&utime0, &stime0, &wtime0);
	//******************************************************************

    //************************************************************************
    //DECLARACION DE VARIABLES
    //************************************************************************
    int k = 0, j = 0;
    int aux,min,m;
    int *numeros = new int [n];
    //************************************************************************
    //CICLO PARA RECEPCION DE DATOS
    //************************************************************************
    while(cin >> m && n--)
    {
        numeros[k] = m;
        k++;
    }
    //************************************************************************
    //ALGORITMO DE ORDENAMIENTO
    //************************************************************************
    for(k = 0; k < 5; k++)
    {
        min = k;
        for(j = k + 1; j < 5; j++)
        {
            if(numeros[j] < numeros[min])
            {
               min = j; 
            }
        }
        aux = numeros[k];
        numeros[k] = numeros[min];
        numeros[min] = aux;
    }
    //*************************************************************************
    //IMPRESION DE NUMEROS ORDENADOS
    //*************************************************************************
   /* for(k = 0; k < 5; k++)
        cout << numeros[k] << " ";*/

    //******************************************************************	
	//Evaluar los tiempos de ejecución 
	//******************************************************************
	uswtime(&utime1, &stime1, &wtime1);
	cout<<"Para "<<n<<" numeros"<<endl;
	//Cálculo del tiempo de ejecución del programa
	printf("\n");
	printf("real (Tiempo total)  %.10f s\n",  wtime1 - wtime0);
	printf("user (Tiempo de procesamiento en CPU) %.10f s\n",  utime1 - utime0);
	printf("sys (Tiempo en acciónes de E/S)  %.10f s\n",  stime1 - stime0);
	printf("CPU/Wall   %.10f %% \n",100.0 * (utime1 - utime0 + stime1 - stime0) / (wtime1 - wtime0));
	printf("\n");
	
	//Mostrar los tiempos en formato exponecial
	printf("\n");
	printf("real (Tiempo total)  %.10e s\n",  wtime1 - wtime0);
	printf("user (Tiempo de procesamiento en CPU) %.10e s\n",  utime1 - utime0);
	printf("sys (Tiempo en acciónes de E/S)  %.10e s\n",  stime1 - stime0);
	printf("CPU/Wall   %.10f %% \n",100.0 * (utime1 - utime0 + stime1 - stime0) / (wtime1 - wtime0));
	printf("\n");
	//******************************************************************

    //Terminar programa normalmente
    return 0;
}
