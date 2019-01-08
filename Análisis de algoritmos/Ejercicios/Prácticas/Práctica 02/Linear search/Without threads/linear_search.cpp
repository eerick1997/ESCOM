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
     int search = 0; 
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
        //Casteo de argv[2] a tipo entero (número a buscar)
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
    
    //Búsqueda lineal
    for(int i = 0; i < number_list.size(); i++){
        //Verificamos si el n_i número es el que buscamos
        if(number_list[i] == search){
            cout<<"Encontre el numero "<<search<<" que buscabas"<<endl;
        }
        
    }
    
    /*******************************************************************	
	*                                         Evaluar los tiempos de ejecución                                             *
	*******************************************************************/
    uswtime(&utime1, &stime1, &wtime1);
    //Cálculo del tiempo de ejecución del programa
    cout    <<  size    <<  ", "    <<  (   utime1 - utime0   )   <<    endl;
    
    return 0;
}
