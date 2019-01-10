#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <windows.h>
#include <time.h>
#include <stdbool.h>
#define TAM_MEM 200
void crearArchivo( char* resultado , char* archivo);
double Determinante (double m1[10][10],int n);
void matrizCofactores (double m1[10][10], int n, double determinante);
void matrizCofactores2 (double m1[10][10], int n, double determinante);

int main (void){
	srand (time(NULL));
	int h=0, i=0, j=0;
	int mat1[10][10];
	int mat2[10][10];
	int multimat[10][10];
	int matsuma[10][10];
	double determinante1;
	double determinante2;
	double inv1[10][10]; 
	double inv2[10][10];
	HANDLE hArchMapeo, hArchMapeo2;
	int *apDatos, *apDatos2, *apTrabajo, *apTrabajo2;
	char *idMemCompartida= "MemoriaCompartida";
	char *idMemCompartida2= "MemoriaCompartida2";
	STARTUPINFO si;
	PROCESS_INFORMATION pi;
	ZeroMemory(&si, sizeof(si));  	/*Estructura de información inicial para Windows*/
	si.cb= sizeof(si);				/*Estructura de información del adm. de procesos*/
	ZeroMemory(&pi, sizeof(pi));
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			for (h=0; h<10; h++){
				mat1[i][j]=rand()%10;
			}	
			for (h=0; h<10; h++){
				mat2[i][j]=rand()%10;
			}
		}
	}
	
	if ((hArchMapeo= CreateFileMapping (INVALID_HANDLE_VALUE, NULL, PAGE_READWRITE, 0, TAM_MEM, idMemCompartida))== NULL){
		printf("No se mapeo la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}
	
	if ((hArchMapeo2= CreateFileMapping (INVALID_HANDLE_VALUE, NULL, PAGE_READWRITE, 0, TAM_MEM, idMemCompartida2))== NULL){
		printf("No se mapeo la memoria compartida: (%i)\n", GetLastError());
		exit (-1);
	}
	
	if((apDatos= (int*)MapViewOfFile(hArchMapeo, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se creo la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo);
		exit (-1);
	}
	
	if((apDatos2= (int*)MapViewOfFile(hArchMapeo2, FILE_MAP_ALL_ACCESS, 0, 0, TAM_MEM))==NULL){
		printf("No se creo la memoria compartida: (%i)\n", GetLastError());
		CloseHandle(hArchMapeo2);
		exit (-1);
	}
	
	apTrabajo= apDatos;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			*apTrabajo++= mat1[i][j];
		}
	}
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			*apTrabajo++= mat2[i][j];
		}
	}
	CreateProcess(NULL, "clientematriz.exe" , NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi);
	while (*apDatos != 1){
		sleep (1);
	}
	UnmapViewOfFile (apDatos);
	CloseHandle (hArchMapeo);
	
	apTrabajo2= apDatos2;
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			multimat[i][j]= *apTrabajo2;
			apTrabajo2++;
		}
	}
	
	for (i=0; i<10; i++){
		for (j=0; j<10; j++){
			matsuma[i][j]= *apTrabajo2;
			apTrabajo2++;
		}
	}
	
	printf("\n\n\tSuma de matrices del nieto:\n\n");
	for (i=0; i<10; i++){
		printf("\t");
		for (j=0; j<10; j++){
			printf("%d ", matsuma[i][j]);
		}
		printf("\n");
	}

	printf("\n\n\tMultiplicacion de matrices del hijo:\n\n");
	for (i=0; i<10; i++){
		printf("\t");
		for (j=0; j<10; j++){
			printf("%d ", multimat[i][j]);
		}
		printf("\n");
	}
	
	for (i=0; i<10 ;i++){
       for(j=0; j<10; j++){
           inv1[i][j]= matsuma[i][j];
           inv2[i][j] = multimat[i][j];
       }   
   }
   determinante1= Determinante(inv1, 10);
    if(determinante1!= 0){
        matrizCofactores(inv1, 10, determinante1);
    }else{
        printf("\nLa matriz 1 no es invertible\n");
    }
    determinante2= Determinante(inv2, 10);
    if (determinante2!= 0){
        matrizCofactores2(inv2, 10, determinante2);
    }else{
        printf("\nLa matriz 2 no es invertible\n");
    }
	
	
	exit (0);
}

void crearArchivo(char* resultado , char* archivo)
{
    HANDLE hFile;       
    DWORD dwBytesToWrite;   
    DWORD dwBytesWritten = 0; 
    bool bErrorFlag = FALSE; 
    dwBytesToWrite = (DWORD)strlen(resultado);
    hFile = CreateFile(archivo,GENERIC_WRITE,0,NULL,CREATE_ALWAYS,FILE_ATTRIBUTE_NORMAL,NULL); 
    bErrorFlag = WriteFile(hFile,resultado,dwBytesToWrite,&dwBytesWritten,NULL);
    if(!bErrorFlag)
        printf("\tError al crear el archivo\n\n");
    CloseHandle(hFile); 
}

double Determinante (double m1[10][10],int n)
{
  double s= 1, det= 0;
  int i, j, k, m, x;
  double m2[10][10];
  if (n==1)
    return m1[0][0];
  else
  {
    for (k= 0; k < n; k++)
    {
      m= 0;
      x= 0;
      for (i= 0; i < n; i++)
        for (j= 0; j < n; j++)
        {
          m2[i][j]= 0;
          if (i!= 0 && j!= k)
          {
            m2[m][x]= m1[i][j];
            if (x < (n-2))
              x++;
            else
            {
              x= 0;
              m++;
            }
          }
        }
      det = det+s*(m1[0][k] * Determinante(m2, n-1));
      s*= -1;
  }
  return det;
    }
}

void matrizCofactores (double m1[10][10], int n, double determinante)
{
  char resultado[700];
  char buffer[8]={};
  int q, m, i, j, k, l;
  double m2[10][10], matrizFactores[10][10], aux[10][10], inversa[10][10];
  for (l= 0; l < n; l++)
  {
    for (k= 0; k < n; k++)
    {
      m= 0; q= 0;
      for (i= 0; i < n; i++)
      {
        for (j= 0; j < n; j++)
        {
          if (i!= l && j!= k)
          {
            m2[m][q] = m1[i][j];
            if (q < (n-2))
            {
              q++;
            }
            else 
            {
                q= 0; m++;
            }
          }
        }
      }
      matrizFactores[l][k] = (pow(-1, l + k)* Determinante (m2, n-1));
    }
  }
  for (i= 0; i < 10; i++)
  {
    for (j= 0; j < 10; j++)
    {
      aux[i][j] = matrizFactores[j][i];
    }
  }
  for (i= 0; i < 10; i++)
  {
    for (j= 0; j < 10; j++)
    {
      inversa[i][j] = aux[i][j] / determinante;
    }
  }
  for (i= 0; i < 10; i++)
  {
    for (j= 0; j < 10; j++)
    {
      sprintf(buffer,"%.3lf\t",inversa[i][j]);
      strcat(resultado,buffer);
      memset(buffer,0,8);
    }
    strcat(resultado,"\r\n");
  }
  crearArchivo(resultado,"Sumainver.txt");
}

void 
matrizCofactores2 (double m1[10][10], int n, double determinante)
{
  char resultado[700];
  char buffer[8]={};
  int q, m, i, j, k, l;
  double m2[10][10], matrizFactores[10][10], aux[10][10], inversa[10][10];
  for (l= 0; l < n; l++)
  {
    for (k= 0; k < n; k++)
    {
      m= 0; q= 0;
      for (i= 0; i < n; i++)
      {
        for (j= 0; j < n; j++)
        {
          if (i!= l && j!= k)
          {
            m2[m][q]= m1[i][j];
            if (q < (n-2))
            {
              q++;
            }
            else 
            {
                q= 0; m++;
            }
          }
        }
      }
      matrizFactores[l][k] = (pow(-1, l + k)* Determinante (m2, n-1));
    }
  }
  for (i= 0; i < 10; i++)
  {
    for (j= 0; j < 10; j++)
    {
      aux[i][j] = matrizFactores[j][i];
    }
  }
  for (i= 0; i < 10; i++)
  {
    for (j= 0; j < 10; j++)
    {
      inversa[i][j] = aux[i][j] / determinante;
    }
  }
  for (i= 0; i < 10; i++)
  {
    for (j= 0; j < 10; j++)
    {
      sprintf(buffer,"%.3lf\t",inversa[i][j]);
      strcat(resultado,buffer);
      memset(buffer,0,8);
    }
      strcat(resultado,"\r\n");
  }
  crearArchivo(resultado,"Multiplicacioninver.txt");
}
