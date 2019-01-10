#include <stdio.h>
#include <windows.h>

int matrix1[10][10], matrix2[10][10], matrixR[10][10];

void add();
void substract();
void multiply();
void transposed();
void printMatrix1();
void printMatrix2();
void printMatrixR();
void 

int main(int argc, char *argv[]){
	STARTUPINFO si;	//Estructura de información para windows
	PROCESS_INFORMATION pi;	//Estructura de información del administrador de procesos
	int i;
	ZeroMemory(&si, sizeof(si));//Llenamos el bloque de memoria con ceros
	si.cb = sizeof(si);	//El miembro cb de esta estructura guarda el tamaño en bytes de si
	ZeroMemory(&pi, sizeof(pi));
}

void add(){
	int i, j;
	printf("Suma de matrices\n");
	for(i = 0; i < 10; i++) {
		for(j = 0; j < 10; j++) 
			matrixR[i][j] = matrix1[i][j] + matrix2[i][j];
	}
	printMatrixR();
}

void substract(){
	int i, j;
	for(i = 0; i < 10; i++){
		for(j = 0; j < 10; j++)
			matrixR[i][j] = matrix1[i][j] - matrix2[i][j];
	}
	printMatrixR();
}

void multiply(){
	int i, j, k = 0;
	for(i = 0; i < 10; i++){
		for(j = 0; j < 10; j++)
			matrixR[i][k] += matrix1[i][j] * matrix2[i][j];
		k++;
	}
	printMatrixR();
}

void transposed(){
	int i, j;
	for(i = 0; i < 10; i++){
		for(j = 0; j < 10; j++)
			matrixR[j][i] = matrix1[i][j]
	}
	printMatrixR();
}

void fillMatrix1(){
	int i, j;
	printf("Primer matriz\n");
	for(i = 0; i < 10; i++){
		for(j = 0; j < 10; j++){
			printf("Digita el valor que sera guardado en la posicion [%d][%d]\n", i, j);
			scanf("%d", &matrix1[i][j]);
		}
	}
}

void fillMatrix2(){
	int i, j;
	printf("Segunda matriz\n");
	for(i = 0; i < 10; i++){
		for(j = 0; j < 10; j++) {
			printf("Digita el valor que sera guardado en la posicion [%d][%d]\n", i, j);
			scanf("%d", &matrix2[i][j]);
		}
	}
}

void printMatrixR(){
	int i, j;
	printf("Contenido de la matriz resultante \n");
	for(i = 0; i < 10; i++){
		printf("\n");
		for(j = 0; j < 10; j++){
			printf(" %d ", matrixR[i][j]);
		}
	}
}

void printMatrix1(){
	int i, j;
	printf("Contenido de matriz 1 \n");
	for(i = 0; i < 10; i++){
		printf("\n");
		for(j = 0; j < 10; j++){
			printf(" %d ", matrix1[i][j]);
		}
	}
}

void printMatrix2(){
	int i, j;
	printf("Contenido de matriz 2 \n");
	for(i = 0; i < 10; i++){
		printf("\n");
		for(j = 0; j < 10; j++){
			printf(" %d ", matrix2[i][j]);
		}
	}
}



/**
typedef struct STARTUPINFO {
  DWORD  cb;	//Tamaño de la estructura en bytes
  LPTSTR lpReserved; //Reservado, debe ser nulo
  LPTSTR lpDesktop; 
  LPTSTR lpTitle;
  DWORD  dwX;
  DWORD  dwY;
  DWORD  dwXSize;
  DWORD  dwYSize;
  DWORD  dwXCountChars;
  DWORD  dwYCountChars;
  DWORD  dwFillAttribute;
  DWORD  dwFlags;
  WORD   wShowWindow;
  WORD   cbReserved2;
  LPBYTE lpReserved2;
  HANDLE hStdInput;
  HANDLE hStdOutput;
  HANDLE hStdError;
} STARTUPINFO, *LPSTARTUPINFO;

**/