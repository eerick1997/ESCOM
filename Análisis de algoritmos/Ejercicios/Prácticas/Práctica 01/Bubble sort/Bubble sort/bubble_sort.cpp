#include <iostream>
#include "tiempo.h"

using namespace std;

int main (int argc, char *argv[]){
    
	//-------------------------------------------------Variables-----------------------------------------------------//
    
     int N= atoi(argv[1]);
	int k=0; //Dato detectado por la entrada estandar
	int i=0, j=0; //Contadores
	int aux; //Auxiliar para almacenar el numero
	int *vector = new int [N]; //Vector contenedor de los numeros a ordenar
    double utime0, stime0, wtime0,utime1, stime1, wtime1; //Variables para medición de tiempos
    
	//---------------------------------------------------------------------------------------------------------------//
	
	
    //--------------------------- Se ingresan los valores al arreglo desde el archivo de texto---------------------------//

	while(cin>>k && i<N){ //Se leera un numero hasta que se encuentre el fin del archivo
		vector[i]= k;
		i++;
	}
	
	//---------------------------------------------------------------------------------------------------------------//

    //-----------------------------------------------Algoritmo principal---------------------------------------------//
	
	uswtime(&utime0, &stime0, &wtime0); // Se inicia el conteo para contar el algoritmo 
	
	for (i=0; i<N; i++){
		for(j=0; j<N-1; j++){
			if(vector[j]>vector[j+1]){
				aux= vector[j];
				vector[j]= vector[j+1];
				vector[j+1]=aux;
			}
		}
	}
	
	uswtime(&utime1, &stime1, &wtime1); // Termina de contarse el tiempo de procesamiento, de E/S y el uso de CPU

	/* NOTA: El problema con este algoritmo de ordenacion es que aunque el arreglo no se encuentre tan desordenado
    el for menos anidado se ejecutara n veces lo que hace perder eficiencia, para verificar si el arreglo sigue
    desordenado se utiliza una bandera y asi optimizar el algoritmo, por esta razon se utiliza Bubble Sort Optimizado */
	
	//---------------------------------------------------------------------------------------------------------------//
	
	//-------------------------------Imprimiendo el resultado dentro del archivo de texto-----------------------------//
	
	/*for (i=0; i<N; i++){
		cout << vector[i] << endl;
	}*/
    
	//---------------------------------------------------------------------------------------------------------------//
    
    
    //-----------------------------------Cálculo del tiempo de ejecución del programa--------------------------------//
    
    cout<<N <<", "<< (wtime1 - wtime0) <<endl;
    
	/*printf("\n");
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
	printf("\n");*/
    
	//--------------------------------------------------------------------------------------------------------------//
	
    return 0;
}
