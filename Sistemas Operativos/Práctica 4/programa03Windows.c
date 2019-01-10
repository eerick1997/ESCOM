#include <windows.h>
#include <stdio.h>

int main(int argc, char *argv[]){
	STARTUPINFO si; //Estructura de información inicial para Windows
	PROCESS_INFORMATION pi; //Estructura de información del administrador de procesos
	int i;
	ZeroMemory(&si, sizeof(si));
	si.cb = sizeof(si);
	ZeroMemory(&pi, sizeof(pi));

	if(argc != 2){
		printf("Usar %s Nombre_Programa_hijo\n", argv[0]);
		return;
	}
	//Creación del proceso hijo
	if(!CreateProcess(NULL, argv[1], NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)){
		printf("Fallo al invocar CreateProcess (%d)\n", GetLastError());
		return;
	}

	//Proceso padre
	printf("Soy el padre\n");
	WaitForSingleObject(pi.hProcess, INFINITE);

	//Terminación controlada del proceso e hijo asociado de ejecución
	CloseHandle(pi.hProcess);
	CloseHandle(pi.hThread);
}