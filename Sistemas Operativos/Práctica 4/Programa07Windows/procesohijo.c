#include <windows.h>
#include <stdio.h>
#include <stdlib.h>

int main(void){
	printf("I'm a child with  ID: %lu\n", GetCurrentProcessId());
	exit(0);
}