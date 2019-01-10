#include <stdio.h>
#include <windows.h>

/**
Programe una aplicación que cree un proceso hijo a partir de un proceso padre, el proceso
padre enviará al proceso hijo usando memoria compartida, dos matrices 10 x 10 a multiplicar
por parte del hijo, mientras tanto el proceso hijo creará un hijo de él, al cual enviará dos
matrices de 10 x 10 a sumar en el proceso hijo creado, nuevamente el envio de estos valores
será a traves de memoria compartida. Una vez calculado el resultado de la suma, el proceso hijo del
hijo, devolverá la matriz resultante a su abuelo. A su vez el proceso hijo devolverá la matriz
resultante de la multiplicación que realizó el padre. Finalmente el proceso padre obtendrá la matriz
inversa de cada una de las matrices recibidas y el resultado lo guardará en un archivo para
cada matriz inversa obtenida.

En resumen proceso padre -> envía dos matrices al hijo -> envía dos matrices al nieto
                                 suma de matrices            multiplica matrices
                                 retorna al padre			  retorna al padre
**/

/** --Padre-- **/

#define SIZE_MEM 1024 //Tamaño de la memoria en bytes
#define SIZE_MAT 10 //Dimensión de las matrices

//Struct el cual almacena tres matrices
typedef struct matrix{
	//Primer matriz
	int MATRIX1[SIZE_MAT][SIZE_MAT];
	//Segunda matriz
	int MATRIX2[SIZE_MAT][SIZE_MAT];
	//Matriz resultante al realizar alguna operación
	int MATRIXR[SIZE_MAT][SIZE_MAT];

}matrix;

matrix *MATRIX;

int main(void){
	
	HANDLE hFileMapping;
	char *IDMemFather = "MemoriaCompartidaPadre";
	char *apData, *apWork, c;


	if((hFileMapping = CreateFileMapping(IVALID_HANDLE_VALUE,//Usa memoria compartida
									 NULL,				//Seguridad por defecto
									 PAGE_READWRITE,	//Acceso lectura/Escritutra a la memoria
									 0,					//Tamaño máximo por parte alta de un DWORD
									 SIZE_MEM,			//Tamaño máximo por parte baja de un DWORD
									 IDMemFather)) = NULL){ //Asignamos el identificador y verificamos si se ha creado correctamente la memoria compartida
		printf("No se mapeo la memoria compartida (%i)\n", GetLastError());
		exit(-1);
	}

	if(apData = (matrix*)MapViewOfFile(hFileMapping, //Manejador del mapeo
									 FILE_MAP_ALL_ACCESS,//Obtenemos permisos de elctura y escritura
									 0,
									 0,
									 SIZE_MEM) == NULL){ //Asignamos el tamaño de la memoria y verificamos si se ha accedido el mapeo
		printf("No se creo la memoria compartida (%i)\n", GetLastError());
		CloseHandle();//Cerramos el manejador del mapeo
		exit(-1);
	}

	for(c = '0'; c <= '9'; c++){ //Escribimos en memoria compartida
		*apWork++ = c;
	}
	apWork = '\0';

	while(*apData != '*'); //Si el caracter leído es un asterisco, se ha terminado la lectura
		sleep(1);


	UnmapViewOfFile(apData);
	CloseHandle(hFileMapping);
	exit(0)
}

/** Esta función nos permite llenar con datos una matriz**/
void fillFirstMatrix(){
	int i, j;
	for(i = 0; i < SIZE_MAT; i++){
		for(j = 0; j < SIZE_MAT; j++){
			printf("Ingresa el elemento [%i][%i]\n", i, j);
			scanf("%d", &matrix_1.position[i][j]);
		}
	}	
}

/** Esta función nos permite llenar con datos la segunda matriz**/
void fillSecondMatrix(){
	int i, j;
	for(i = 0; i < SIZE_MAT; i++){
		for(j = 0; j < SIZE_MAT; j++){
			printf("Ingresa el elemento [%i][%i]\n", i, j);
			scanf("%d", &matrix_2.position[i][j]);
		}
	}	
}


