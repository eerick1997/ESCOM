/**
 * AUTORES:
 *                              Macías Castillo Josué
 *                              Torres Hernández Eduardo
 *                              Vargas Romero Erick Efraín 
 *  VERSIÓN: 1.0
 *      
 * DESCRIPCIÓN: Linear search
 * Este método de ordenamiento es el más simple de implementar
 * además de ser el más intuitivo para nosotros. Este algoritmo consiste
 * en realizar la busqueda elemento a elemento en un arreglo. 
 * 
 * OBSERVACIONES: Este algoritmo de búsqueda requiere ( para este
 * caso) que la entrada de los datos este en órden
 **/

//Librerías
#include <iostream>
//Esta librería incluye el elemento vector
#include <vector>
//LIbrería para medición del tiempo
#include "tiempo.c"
//Librería para el uso de Threads
#include <pthread.h>

using namespace std;

//Estructura que contiene el inicio y fin del arreglo a ordenar
struct param_busqueda {
   int inicio;
   int fin;
};


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
     int search = 0; 
     //Este elemento lo utilizaremos para guardar los números que serán ingresados
     vector<int> number_list;



//Función búsqueda_lineal
void *Linear_Search(void *estructura) {
   struct param_busqueda *inicio_fin;
   inicio_fin= (struct param_busqueda *)estructura;
    
    
    for(int i = inicio_fin->inicio; i < inicio_fin->fin; i++){
        //Verificamos si el n_i número es el que buscamos
        if(number_list[i] == search){
            cout<<"Encontre el numero "<<search<<" que buscabas"<<endl;
	    //cout << "Soy el hilo que va del: "<<inicio_fin->inicio<<" hasta el: "<<inicio_fin->fin<<endl;
        exit(0);
        }
        
    }

   pthread_exit(NULL);
}



//Programa principal
int main(int argc, char* argv[]){
    
     pthread_t thread1;
     pthread_t thread2;
     pthread_t thread3;
     pthread_t thread4;

     struct param_busqueda struct1;
     struct param_busqueda struct2;
     struct param_busqueda struct3;
     struct param_busqueda struct4;

     
     //Si no se introducen exactamente 2 argumentos (Cadena de ejecución y cadena = n)
     if(argc != 3){
         printf("\nIndique el tamanio del algoritmo - Ejemplo [user@equipo]$%s100\n", argv[0]);
         exit(1);
    }
    
    //Tomar el segundo argumento como tamaño del algoritmo
    else {
        //Casteo de argv[1] a tipo entero
        size = N = atoi(argv[1]);
	
        //Casteo de argv[2] a tipo entero (número a buscar)
        search = atoi(argv[2]);
    }
    
    //******************************************************************	
	//Algoritmo
	//******************************************************************	
    
    int tam=N;

    //Lectura de todos los números
    while(cin>>n && N--){
        number_list.push_back(n);
    }
    
    struct1.inicio=0;
    struct1.fin= tam/4;

    struct2.inicio=tam/4;
    struct2.fin= tam/2;

    struct3.inicio=tam/2;
    struct3.fin= 3*tam/4;
    
    struct4.inicio=3*tam/4;
    struct4.fin= tam;

    //Búsqueda lineal
    uswtime(&utime0, &stime0, &wtime0);
    pthread_create(&thread1, NULL, Linear_Search, (void *)&struct1);
    pthread_create(&thread2, NULL, Linear_Search, (void *)&struct2);
    pthread_create(&thread3, NULL, Linear_Search, (void *)&struct3);
    pthread_create(&thread4, NULL, Linear_Search, (void *)&struct4);
    uswtime(&utime1, &stime1, &wtime1);
    //Cálculo del tiempo de ejecución del programa
    cout << size <<", "<<(utime1-utime0)<<endl;	
    pthread_exit(NULL);
}
