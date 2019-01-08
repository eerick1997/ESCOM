#include <iostream>
#include "tiempo.h"

using namespace std;

//#define N 11//Constante que determina la longitud del arreglo//

int main (int argc, char *argv[]){
	
    //-------------------------------------------------------Variables-----------------------------------------------------------//
   
    int N= atoi(argv[1]);
	int k; //Dato detectado por la entrada estandar
	int i=0, j=0; //Contadores
	int div= N; //Este numero funciona para realizar las divisiones;
	int aux; //Esta variable nos ayudara a guardar temporalmente
	bool flag; //Esta bandera nos dira si hubo mas cambios
	int *vector = new int [N]; //Vector contenedor de los numeros a ordenar
	double utime0, stime0, wtime0,utime1, stime1, wtime1; //Variables para medición de tiempos
	
	//---------------------------------------------------------------------------------------------------------------------------//
	
	//------------------------------------ Se ingresan los valores al arreglo desde el archivo de texto------------------------------//
	
	while(cin>>k && i<N){ //Se leera un numero hasta que se encuentre el fin del archivo
		vector[i]= k;
		i++;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------//

	//-----------------------------------------------------Algoritmo principal---------------------------------------------------//
	
	uswtime(&utime0, &stime0, &wtime0); // Se inicia el conteo para contar el algoritmo 

	while(div>1){	//Mientras la division sea mayor a 1 se cumplira
		div= div/2;	//Cada iteracion dividira entre 2
		flag= true; //La bandera indica que si ha habido una division entre 2
		while(flag==true){	//La bandera indica que hay ordenamientos por realizar
			flag= false;	//Inmediatamente se desactiva la bandera para posteriormente en caso de que hayan reemplazos volver activarla
			i=0;		
			while(i+div <N){	//Indicamos que no puede salirse del tamanio del arreglo
				if(vector[i]>vector[i+div]){	//Se realiza la comparacion entre los elementos del arreglo
					aux= vector[i];	// Se realiza el almacen del dato que vamos a reemplazar en los siguientes dos pasos 
					vector[i]=vector[i+div];
					vector[i+div]= aux;
					flag= true;	//Se indica a la bandera que se ha encontrado una comparacion y se ha reemplazado algun valor
				}
				i++;  	//Se incrementa el subindice del arreglo
			}				
		}
	}
	
	uswtime(&utime1, &stime1, &wtime1); // Termina de contarse el tiempo de procesamiento, de E/S y el uso de CPU
    
	//----------------------------------------------------------------------------------------------------------------------------//
	
	
	//--------------------------------------Imprimiendo el resultado dentro del archivo de texto-----------------------------------//
	
	/*for(j=0;  j<N;  j++){
		cout << vector[j] <<endl;
	}*/
    
    //----------------------------------------------------------------------------------------------------------------------------//
	
	//--------------------------------------------Cálculo del tiempo de ejecución del programa------------------------------------//
    
    cout<<N <<", "<< (utime1 - utime0) <<endl;
    
    /*
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
	printf("\n");*/
	//----------------------------------------------------------------------------------------------------------------------------//
	
	return 0;
}
