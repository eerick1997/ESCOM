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
//Para manejo de hilos
#include <pthread.h>
#include "tiempo.h"
#include "binary_tree.cpp"

using namespace std;

//Programa principal
int main(int argc, char* argv[]){
    
     /********************************************************
      *                     VARIABLES                        *
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
    //Instancias de nuestros hilos
    pthread_t thread01;
    pthread_t thread02;
    //Instancias de los structs que usaremos en los hilos
    struct params_search params01;
    struct params_search params02;

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
	//                           Algoritmo
	//******************************************************************	
    
    //Lectura de todos los números
    while(cin>>n && N--){
        insert(binaryTree, n);
        count++;
    }
    
    /*******************************************************************	
	*Iniciar el conteo del tiempo para las evaluaciones de rendimiento *
	********************************************************************/	
	uswtime(&utime0, &stime0, &wtime0);

    BinaryTree aux = binaryTree;
    //Cargado a la izquierda
    if( (binaryTree->left && !binaryTree->right) ){

        
        for(int i = 0; i < count/2 && aux; i++){
            aux = aux -> left;
        }
        params01.sub_tree = binaryTree;
        params01.n_search = nsearch;
        params01.end = count/2;

        params02.sub_tree = aux;
        params02.n_search = nsearch;
        params02.end = count;

        pthread_create(&thread01, NULL, beginSearch, (void *)&params01);
        pthread_create(&thread02, NULL, beginSearch, (void *)&params02);
    }
    //Cargado a la derecha
    else if( (binaryTree->right && !binaryTree->left) ){
        for(int i = 0; i < count/2 && aux; i++){
            aux = aux -> right;
        }
        params01.sub_tree = binaryTree;
        params01.n_search = nsearch;
        params01.end = count/2;

        params02.sub_tree = aux;
        params02.n_search = nsearch;
        params02.end = count;

        pthread_create(&thread01, NULL, beginSearch, (void *)&params01);
        pthread_create(&thread02, NULL, beginSearch, (void *)&params02);
    } else {
        search(binaryTree, nsearch);
    }

    /*******************************************************************	
	*                Evaluar los tiempos de ejecución                  *
	********************************************************************/
    uswtime(&utime1, &stime1, &wtime1);
    //Cálculo del tiempo de ejecución del programa
    cout    <<  size    <<  ", "    <<  (   utime1 - utime0   )   <<    endl;
    pthread_exit(NULL);
    return 0;
}
