/***
 * AUTORES:
 *                              Macías Castillo Josué
 *                              Torres Hernández Eduardo
 *                              Vargas Romero Erick Efraín
 * VERSION: 1.0
 * 
 * DESCRIPCIÓN: tree sort
 * este es un algoritmo de ordenamiento que hace uso de una estructura de
 * datos. La estructuda de datos empleada es el árbol binario.
 * El algoritmo tree sort es un algoritmo que a diferencia del resto implementados
 * es increíblemente eficiente, permitiendo realizar el ordenamiento de
 * los números de la entrada en un tiempo bastante breve.
 * 
 * OBSERVACIONES: La estructura de datos que se ha empleado o bien
 * el código de esta, se encuentra en el archivo binary_tree.cpp
 * */

//LIbrerías
#include <iostream>
//En esta librería se encuentra el TAD arbol binario
#include "binary_tree.cpp"
#include "tiempo.h"

using namespace std;

int main(int argc, char* argv[]){
  
    /**       VARIABLES       **/
    //Variables para modificacuón de tiempos
    double utime0, stime0, wtime0,utime1, stime1, wtime1;
    //Esta variable contiene el árbol binario que será utilizado para
    //el uso de tree sort
    BinaryTree binaryTree = NULL;
    //Esta variable almacenará el número que será leído por entrada
    //estándar
    int n;
    //Esta variable contiene el número de números que serán leídos
    //como máximo
    int N = 0, size = 0;
    
	//Si no se introducen exactamente 2 argumentos (Cadena de ejecución y cadena=n)
	if (argc!=2) {
		printf("\nIndique el tamanio del algoritmo - Ejemplo: [user@equipo]$ %s 100\n",argv[0]);
		exit(1);
	} 
	//Tomar el segundo argumento como tamaño del algoritmo
	else{
		N=atoi(argv[1]);
	}
	
	size = N;
	//******************************************************************	
	//Iniciar el conteo del tiempo para las evaluaciones de rendimiento
	//******************************************************************	
	uswtime(&utime0, &stime0, &wtime0);
    
    //******************************************************************	
	//Algoritmo
	//******************************************************************	
        while(cin>>n && N--){
        	insert(binaryTree, n);
        }
    inorder(binaryTree);
    
    //******************************************************************

	//******************************************************************	
	//Evaluar los tiempos de ejecución 
	//******************************************************************
	uswtime(&utime1, &stime1, &wtime1);
	/**cout<<"-------------------------- Para "<<size<<" Números -----------------------------------"<<endl;
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
	printf("\n");**/
	//******************************************************************
}
