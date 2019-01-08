/**
 * AUTORES:
 *                              Macías Castillo Josué
 *                              Torres Hernández Eduardo
 *                              Vargas Romero Erick Efraín 
 *  VERSIÓN: 1.0
 *      
 * DESCRIPCIÓN: binary  search
 * Este método de ordenamiento es un poco más complicado de implementar
 * pero es mucho más eficiente, consiste en dividir la "búsqueda". Esto se realiza
 * "parándose" en el centro del arreglo y elegir si recorremos el lado izquiedo
 * o el lado derecho del arreglo. Esto se realiza hasta encontrar lo que necesitamos
 * 
 * OBSERVACIONES: Este algoritmo de búsqueda requiere que el arreglo ha utilizar
 * esté ordenado. O bien este método se aplica siempre y cuando se tenga una función
 * monótona creciente o decreciente.
 **/

//Librerías
#include <iostream>
//Esta librería incluye el elemento vector
#include <vector>
//LIbrería para medición del tiempo
#include "tiempo.c"

using namespace std;

//Estructura que contiene el inicio y fin del arreglo a ordenar
struct param_busqueda {
   int inicio;
   int fin;
};


     ///Variables para la modificación de tiempos
     double utime0, stime0, wtime0, utime1, stime1, wtime1;   
     //Esta variable almacenará el número recibido por entrada estandar
     int n;
     //Esta variable almacenará el número de datos máximos leídos
     int N= 0, size = 0; 
     //Esta variable almacenará el número que se desea buscar
     int search = 0; 
     //Este elemento lo utilizaremos para guardar los números que serán ingresados
     vector<int> number_list;


void *Binary_Search(void *estructura){
     struct param_busqueda *inicio_fin;
     inicio_fin= (struct param_busqueda *)estructura;

     //Esta variable contiene la posición  inicial del arreglo
     int begin = inicio_fin->inicio;;
     //Esta variable contiene la última posición del arreglo;
     int end = inicio_fin->fin-1;
     //Esta variable contiene la posición del centro del arreglo
     int middle = 0;
     //Esta variable contiene la posible posición del elemento que necesitamos
     int res = 0;
         
     uswtime(&utime0, &stime0, &wtime0); //Inicia el conteo de tiempo
     while(begin <= end){
         //Calculamos el índice que está a la mitad de la lista
         middle = ( begin + end) / 2;
         //Si el valor encontrado a la mitad de la lista es menor que el que buscamos
         //Debemos descartar la mitad derecha
         if( number_list[middle] < search){
             //Descartamos la mitad izquierda moviendo la variable begin de posición
             begin = middle + 1;
        } 
        //El número se encuentra en la mitad izquierda
        else {
            //Debemos ignorar la mitad derecha de la lista moviendo la variable end de posición
            end = middle - 1;
            res = middle;
        }
        
    }

    uswtime(&utime1, &stime1, &wtime1);
    //Cálculo del tiempo de ejecución del programa
    cout    <<  size    <<  ", "    <<  (   utime1 - utime0   )   <<    endl;
    
    if(number_list[res] == search){
        cout<<"Encontre el numero "<<search<<" que buscabas"<<endl;
    } else {
        cout<<"No se encontro el numero "<< search <<endl;
    }
    pthread_exit(NULL);
}




int main(int argc, char* argv[]){

     pthread_t thread1;
     pthread_t thread2;

     struct param_busqueda struct1;
     struct param_busqueda struct2;

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
    
    int tam=N;

    //Lectura de todos los números
    while(cin>>n && N--){
        number_list.push_back(n);
    }
    
    struct1.inicio=0;
    struct1.fin= tam/2;

    struct2.inicio=tam/2;
    struct2.fin= tam;

   //cout << "Le estoy enviando a la estructura 1 de: "<<struct1.inicio<< " a "<< struct1.fin<<endl;
   //cout << "Le estoy enviando a la estructura 2 de: "<<struct2.inicio<< " a "<< struct2.fin<<endl;


    pthread_create(&thread1, NULL, Binary_Search, (void *)&struct1);
    pthread_create(&thread2, NULL, Binary_Search, (void *)&struct2);	

    pthread_exit(NULL);
    
    return 0;
}