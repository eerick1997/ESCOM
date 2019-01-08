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

//Prototipo de nuestra función binarySearch
void  binarySearch(int n, vector<int> &list);

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
     int N= 0, size = 0, search = 0; 
     //Este elemento lo utilizaremos para guardar los números que serán ingresados
     vector<int> number_list;
     
     //Si no se introducen exactamente 2 argumentos (Cadena de ejecución y cadena = n)
     if(argc != 3){
         printf("\nIndique el tamanio del algoritmo - Ejemplo [user@equipo]$%s100\n", argv[0]);
         exit(1);
    }
    
    //Tomar el segundo argumento como tamaño del algoritmo
    else {
        //Casteo de argv[1] a tipo entero
        size = N = atoi(argv[1]);
        //Casteo de argv[2] a tipo enter (número a buscar)
        search = atoi(argv[2]);
    }

    //******************************************************************	
	//Algoritmo
	//******************************************************************	
    
    //Lectura de todos los números
    while(cin>>n && N--){
        number_list.push_back(n);
    }
    
    /*******************************************************************	
	*      Iniciar el conteo del tiempo para las evaluaciones de rendimiento    *
	*******************************************************************/	
	uswtime(&utime0, &stime0, &wtime0);
    
    //Llamada a la función binarySearch
    binarySearch(search, number_list);
    
    /*******************************************************************	
	*                                         Evaluar los tiempos de ejecución                                             *
	*******************************************************************/
    uswtime(&utime1, &stime1, &wtime1);
    //Cálculo del tiempo de ejecución del programa
    cout    <<  size    <<  ", "    <<  (   utime1 - utime0   )   <<    endl;
    
    return 0;
}

/**
 * binarySearch
 * DESCRIPCIÓN: Esta función tiene como objetivo realizar una búsqueda
 * binaria en un vector el cual debe estar previamente ordenado.
 * Recibe: int (número a buscar)
 *                  vector<int> el número a buscar
 * */
void  binarySearch(int n, vector<int> &list){
    cout<<"binarySearch() starts"<<endl;
     /********************************************************
      *                                                      VARIABLES                                                    *
      ********************************************************/
     //Esta variable contiene la posición  inicial del arreglo
     int begin = 0;
     //Esta variable contiene la última posición del arreglo;
     int end = list.size() - 1;
     //Esta variable contiene la posición del centro del arreglo
     int middle = 0;
     //Esta variable contiene la posible posición del elemento que necesitamos
     int res = 0;
     
     while(begin <= end){
         //Calculamos el índice que está a la mitad de la lista
         middle = ( begin + end) / 2;
         //Si el valor encontrado a la mitad de la lista es menor que el que buscamos
         //Debemos descartar la mitad derecha
         if( list[middle] < n){
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
    
    //Finalmente si el elemento en la posición middle es el mismo que n entonces
    //el elemento si se encontró en la lista
    if(list[res] == n){
        cout<<"Encontre el numero "<<n<<" que buscabas"<<endl;
    } else {
        cout<<"No se encontro el numero "<< n <<endl;
    }
}
