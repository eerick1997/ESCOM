#include <iostream>
#include "tiempo.h"

using namespace std;

//#define N 10000000 //Constante que determina la longitud del arreglo

int main (int argc, char *argv[]){

    //----------------------------------------------Variables-------------------------------------------------//
   
    int N= atoi(argv[1]), size = 0;
    size = N;
	int *array= new int [N];
	int k=0; //k es el dato entrante que viene del archivo de texto
	int i=0, j=0; // Contadores
	bool flag= true; //Esta bandera indicara si el arreglo aun se encuentra deordenado
	int aux=0; //Variable auxiliar que nos servira para guardar temporalmente los valores del arreglo
	double utime0, stime0, wtime0,utime1, stime1, wtime1; //Variables para medición de tiempos
	
	//--------------------------------------------------------------------------------------------------------//
	
	
	//----------------------- Se ingresan los valores al arreglo desde el archivo de texto------------------------//
	
	while(cin>>k && N--){ //Mientras cin encuentre valores en el archivo de texto
		array[i]= k;
		i++;
	}
	
    //--------------------------------------------------------------------------------------------------------//

    //--------------------------------------------Algoritmo principal-----------------------------------------//
    
	i=0;
    
    uswtime(&utime0, &stime0, &wtime0); // Se inicia el conteo para contar el algoritmo 
    
	while(i<size && flag==true){
		flag= false;
		for (j=0;  j<size-1;  j++){
			if(array[j] > array[j+1]){
				aux= array[j];
				array[j]= array[j+1];
				array[j+1]= aux;
				flag= true;
			}
		}
		i++;
	}
	
	uswtime(&utime1, &stime1, &wtime1); // Termina de contarse el tiempo de procesamiento, de E/S y el uso de CPU

	/* NOTA: Se emplea el mismo algoritmo que Bubble Sort  a diferencia de la bandera, esta bandera nos ayuda
      para evitar que siga realizando comparaciones cuando el arreglo ya se encuentre totalmente ordenado,
      a diferencia de Bubble Sort que sigue realizando  n veces comparaciones aunque el arreglo  ya se encuentre
     totalmente ordenado. Bubble Sort optimizado nos ahorrara muchas operaciones y asi ahorrar una cantidad 
     significativa de tiempo y recursos */
	
	//--------------------------------------------------------------------------------------------------------//
	
	
	//----------------------------Imprimiendo el resultado dentro del archivo de texto-------------------------//
	/**
	for(i=0; i<size; i++){
		cout << array[i] << endl;
	}**/
	
    //--------------------------------------------------------------------------------------------------------//
    
    
     //-------------------------------Cálculo del tiempo de ejecución del programa----------------------------//

     cout<<"-------------------------------------- Para "<<size<<" numeros --------------------------------------"<<endl;
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
    
	//-------------------------------------------------------------------------------------------------------//
    
	return 0;
}
