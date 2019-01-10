#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_MEM 200
int main (void){
	srand (time(NULL));
	int h=0, i=0, j=0, aux=0;
	int mat1[10][10];
	int mat2[10][10];
	int multimat[10][10];
	int matsuma1[10][10];
	int matsuma2[10][10];
	int matsuma[10][10];
	HANDLE hArchMapeo, hArchMapeo2, hArchMapeo3, hArchMapeo4;
	int *apDatos, *apTrabajo, *apDatos2, *apTrabajo2, *apDatos3, *apTrabajo3, *apDatos4, *apTrabajo4;
	char *idMemCompartida= "MemoriaCompartida";
	char *idMemCompartida2= "MemoriaCompartida2";
	char *idMemCompartida3= "MemoriaCompartida3";
	char *idMemCompartida4= "MemoriaCompartida4";
	STARTUPINFO si;
	PROCESS_INFORMATION pi;
	ZeroMemory(&si, sizeof(si));  	/*Estructura de información inicial para Windows*/
	si.cb= sizeof(si);				/*Estructura de información del adm. de procesos*/
	ZeroMemory(&pi, sizeof(pi));
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			matsuma1[i][j]=rand()%10;
			matsuma2[i][j]=rand()%10;
		}
	}
	if ((hArchMapeo= OpenFileMapping (FILE_MAP_ALL_ACCESS, FALSE, idMemCompartida))== NULL){
		printf("No se abrio archivo de mapeo de la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}
	if ((hArchMapeo2= OpenFileMapping (FILE_MAP_ALL_ACCESS, FALSE, idMemCompartida2))== NULL){
		printf("No se abrio archivo de mapeo de la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}

	if ((hArchMapeo3= CreateFileMapping (INVALID_HANDLE_VALUE, NULL, PAGE_READWRITE, 0, TAM_MEM, idMemCompartida3))== NULL){
		printf("No se mapeo la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}
	
	if ((hArchMapeo4= CreateFileMapping (INVALID_HANDLE_VALUE, NULL, PAGE_READWRITE, 0, TAM_MEM, idMemCompartida4))== NULL){
		printf("No se mapeo la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}
	
	if((apDatos= (int*)MapViewOfFile(hArchMapeo, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se accedio a la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo);
		exit (-1);
	}
	if((apDatos2= (int*)MapViewOfFile(hArchMapeo2, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se creo la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo2);
		exit (-1);
	}
	
	if((apDatos3= (int*)MapViewOfFile(hArchMapeo3, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se creo la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo);
		exit (-1);
	}
	
	if((apDatos4= (int*)MapViewOfFile(hArchMapeo4, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se creo la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo4);
		exit (-1);
	}
	////////////////////////////////////////////////
	apTrabajo3= apDatos3;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			*apTrabajo3++= matsuma1[i][j];
		}
	}
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			*apTrabajo3++= matsuma2[i][j];
		}
	}
	CreateProcess(NULL, "clientematriz2.exe" , NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi);
	while (*apDatos3 != 1){
		sleep (1);
	}
	UnmapViewOfFile (apDatos3);
	CloseHandle (hArchMapeo3);
	
	apTrabajo4= apDatos4;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			matsuma[i][j]= *apTrabajo4;
			apTrabajo4++;
		}
	}
	
	////////////////////////////////////////////////////////
	
	apTrabajo= apDatos;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			mat1[i][j]= *apTrabajo;
			apTrabajo++;
		}
	}
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			mat2[i][j]= *apTrabajo;
			apTrabajo++;
		}
	}
	
	printf("\tMatriz numero 1:\n\n");
	for (i=0; i<10; i++){
		printf("\t");
		for (j=0; j<10; j++){
			printf("%d ", mat1[i][j]);
		}
		printf("\n");
	}
	printf("\n\n\tMatriz numero 2:\n\n");
	for (i=0; i<10; i++){
		printf("\t");
		for (j=0; j<10; j++){
			printf("%d ", mat2[i][j]);
		}
		printf("\n");
	}
	
	for (h=0; h<10; h++){
		for (i=0; i<10; i++){
			for (j=0; j<10; j++){
				aux= aux+((mat1[h][j])*(mat2[j][i]));
				multimat[h][i]= aux;
			}
			aux=0;
		}
	}
	
	apTrabajo2= apDatos2;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			*apTrabajo2++= multimat[i][j];
		}
	}
	
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			*apTrabajo2++= matsuma[i][j];
		}
	}
	
	*apDatos= 1;
	UnmapViewOfFile(apDatos);
	CloseHandle(hArchMapeo);
	exit (0);
}