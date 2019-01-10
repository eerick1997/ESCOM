#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_MEM 200
int main (void){
	int i=0, j=0, aux=0;
	HANDLE hArchMapeo3, hArchMapeo4;
	int *apDatos3, *apTrabajo3, *apDatos4, *apTrabajo4;
	char *idMemCompartida3= "MemoriaCompartida3";
	char *idMemCompartida4= "MemoriaCompartida4";
	int mat1[10][10];
	int mat2[10][10];
	int matsuma[10][10];
	if ((hArchMapeo3= OpenFileMapping (FILE_MAP_ALL_ACCESS, FALSE, idMemCompartida3))== NULL){
		printf("No se abrio archivo de mapeo de la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}
	
	if ((hArchMapeo4= OpenFileMapping (FILE_MAP_ALL_ACCESS, FALSE, idMemCompartida4))== NULL){
		printf("No se abrio archivo de mapeo de la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}
	
	if((apDatos3= (int*)MapViewOfFile(hArchMapeo3, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se creo la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo3);
		exit (-1);
	}
	
	if((apDatos4= (int*)MapViewOfFile(hArchMapeo4, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se creo la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo4);
		exit (-1);
	}
	
	
	apTrabajo3= apDatos3;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			mat1[i][j]= *apTrabajo3;
			apTrabajo3++;
		}
	}
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			mat2[i][j]= *apTrabajo3;
			apTrabajo3++;
		}
	}
	
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			matsuma[i][j]= mat1[i][j]+mat2[i][j];
		}
	}
	
	system("cls");
	printf("\tMatrices del nieto\n");
	printf("\tMatriz numero 1:\n\n");
	for (i=0; i<10; i++){
		printf("\t");
		for (j=0; j<10; j++){
			printf("%d ", mat1[i][j]);
		}
		printf("\n");
	}
	printf("\n\n\tMatriz numero 2:\n");
	for (i=0; i<10; i++){
		printf("\t");
		for (j=0; j<10; j++){
			printf("%d ", mat2[i][j]);
		}
		printf("\n");
	}
	printf("\n\tMatrices del hijo\n");
	
	apTrabajo4= apDatos4;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			*apTrabajo4++= matsuma[i][j];
		}
	}
	
	*apDatos3= 1;
	UnmapViewOfFile(apDatos3);
	CloseHandle(hArchMapeo3);
	exit (0);
}