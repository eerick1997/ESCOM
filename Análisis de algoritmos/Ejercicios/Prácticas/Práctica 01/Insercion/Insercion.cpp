//****************************************************************************
//Josue Macias Castillo, Eduardo Torres Hernandez, Erick Efrain Vargas Romero 
//Curso: Análisis de algoritmos
//(C) Septiembre 2018
//ESCOM-IPN
//Algoritmo de ordenamiento por insercion 
//Compilación: "g++ Insercion.cpp -o insert"
//Ejecución: ./insert (Linux y MAC OS), insert.exe (Windows)
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
int main(int argc, char* argv[])
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
    int k = 0;
    int pos, temp,m;
    int j = 0;
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
    for(k = 0; k < n; k++)
    {
        pos = k;
        temp = numeros[k];
        while(pos > 0 && temp < numeros[pos - 1] )
        {
            numeros[pos] = numeros[pos - 1];
            pos--;
        }
        numeros[pos] = temp;
    }
    //*************************************************************************
    //IMPRESION DE NUMEROS ORDENADOS
    //*************************************************************************
    /*for(j = 0; j < N; j++)
        cout << numeros[j] << " ";*/

    //******************************************************************	
	//Evaluar los tiempos de ejecución 
	//******************************************************************
	uswtime(&utime1, &stime1, &wtime1);
	
    cout<<"Para "<<n<<" números"<<endl;
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
