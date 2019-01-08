/**
 * AUTORES:
 *                              Macías Castillo Josué
 *                              Torres Hernández Eduardo
 *                              Vargas Romero Erick Efraín 
 *  VERSIÓN: 1.0
 *      
 * DESCRIPCIÓN:  search tree
 * Este método de ordenamiento es el "más" complicado de realizar ya que hace
 * uso de un árbol binario como el implementado en la práctica anterior
 * 
 * OBSERVACIONES: Este algoritmo como se mencionó en la descripción hace
 * uso de un árbol binario el cual también se ha implementado
 **/

//Librerías
#include <iostream>
#include "tiempo.h"
#include "binary_tree.cpp"

using namespace std;

//Programa principal
int main(int argc, char* argv[]){
    
     /********************************************************
      *                                                      VARIABLES                                                    *
      ********************************************************/
     
     //Variables para la modificación de tiempos
     double utime0, stime0, wtime0, utime1, stime1, wtime1;
     
     //Esta variable almacenará el número recibido por entrada estandar
     int n;
     //Esta variable almacenará el número de datos máximos leídos
     int N= 0, size = 0; 
     //Esta variable almacenará el número que se desea buscar
     int nsearch = 0;
     //Este elemento lo utilizaremos para guardar los números que serán ingresados
     BinaryTree binaryTree = NULL;
     
     //Si no se introducen exactamente 2 argumentos (Cadena de ejecución y cadena = n)
     if(argc != 3){
         printf("\nIndique el tamanio del algoritmo - Ejemplo [user@equipo]$%s100\n", argv[0]);
         exit(1);
    }
    
    //Tomar el segundo argumento como tamaño del algoritmo
    else {
        //Casteo de argv[1] a tipo entero
        size = N = atoi(argv[1]);
        //Casteo de argv[3] a entero (número a buscar)
        nsearch = atoi(argv[2]);
    }
    
    //******************************************************************	
	//                          Algoritmo
	//******************************************************************	
    
    //Lectura de todos los números
    while(cin>>n && N--){
        insert(binaryTree, n);
    }
    
    /*******************************************************************	
	*Iniciar el conteo del tiempo para las evaluaciones de rendimiento *
	********************************************************************/	    
	uswtime(&utime0, &stime0, &wtime0);
    
    search(binaryTree, nsearch);
    /******************************************************************	
	*                Evaluar los tiempos de ejecución                 *
	*******************************************************************/
    uswtime(&utime1, &stime1, &wtime1);
    //Cálculo del tiempo de ejecución del programa
    cout    <<  size    <<  ", "    <<  (   utime1 - utime0   )   <<    endl;
    
    return 0;
}
