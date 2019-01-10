// CÓDIGO PARA EL HIJO
// El hijo hace función de cliente y servidor
/** cliente por que hace el envío de un struct matrix
	**/

#include<stdio.h>
#include<windows.h>

#define SIZE_MEM 1024
#define SIZE_MAT 10

//definición de un struct el cual contiene tres matrices 
//con dimensiones 10X10
typedef struct matrix{
	//Primer matriz
	int MATRIX1[SIZE_MAT][SIZE_MAT];
	//Segunda matriz
	int MATRIX2[SIZE_MAT][SIZE_MAT];
	//Matriz resultante
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
			scanf("%d", &MATRIX.MATRIX1[i][j]);
		}
	}	
}

/** Esta función nos permite llenar con datos la segunda matriz**/
void fillSecondMatrix(){
	int i, j;
	for(i = 0; i < SIZE_MAT; i++){
		for(j = 0; j < SIZE_MAT; j++){
			printf("Ingresa el elemento [%i][%i]\n", i, j);
			scanf("%d", &MATRIX.MATRIX2[i][j]);
		}
	}	
}