#include <stdio.h>
#include <windows.h>
#include <stdlib.h>

/**
Programe una aplicación que cree un proceso hijo a partir
de un proceso padre, el hijo a su vez creará 5 procesos hijos
más. A su vez cada uno de los cinco procesos creará 3
procesos más. Cada uno de los procesos creados imprimirá
en pantalla su identificador.
CONSEJO: INVESTIGUE LA FUNCIÓN GetCurrentProcessId()
DEL API WIN32

La función GetCurrentProcessId()
No recive parámetros
El valor de retorno es el valor del identificador de un proceso
**/


int main(int argc, char *argv[]){
	STARTUPINFO si; //Estructura de información inicial para windows
	PROCESS_INFORMATION pi; //Estructura de información del administrador de procesos
	int i, j;
	ZeroMemory(&si, sizeof(si));//El bloque de memoria es rellenado con ceros
	si.cb = sizeof(si); //El miembro cb guarda el tamaño en bytes de si
	ZeroMemory(&pi, sizeof(pi));

	if(argc != 2){
		perror("Faltan argumentos\n");
		return 0;
	}

	if(CreateProcess(NULL, argv[1], NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)){ //Proceso hijo del padre
		printf("I'm the father with the ID: %lu \n", GetCurrentProcessId());
		printf("\n");
		WaitForSingleObject(pi.hProcess, INFINITE);

		for(i = 0; i < 5; i++) {

			if(CreateProcess(NULL, argv[1], NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)){ //Cinco procesos hijos
				printf("Child process  #%d ", i+1);
				WaitForSingleObject(pi.hProcess, INFINITE);
				for(j = 0; j < 3; j++){
					if(CreateProcess(NULL, argv[1], NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)){//Tres procesos hijos
						printf("\t\tChild process #%d ", j+1);
						WaitForSingleObject(pi.hProcess, INFINITE);
					} else {
						break;
					}
				}
			}
			printf("\n");
		}
	}
	CloseHandle(pi.hProcess);
	CloseHandle(pi.hThread);
}