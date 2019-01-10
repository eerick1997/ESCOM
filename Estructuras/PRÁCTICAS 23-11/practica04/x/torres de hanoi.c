/*
AUTORES:
Nuñez García Tania Itzel
Quiro Díaz Verónica Jackeline
Vargas Romero Erick Efraín

DESCRIPCIÓN:Programar en ANSI C la implementación recursiva de las Torres de Hanoi para n discos.

EJECUCIÓN: torres de hanoi.c (Windows)
*/
//LIBRERIAS
//Torres de Hanoi
#include <stdlib.h>
#include <stdio.h>

//PROTOTIPOS
void hanoi(long int disco, char origen, char aux,  char destino);
//PROGRAMA PRINCIPAL
int main()
{
printf("\n \t\t\t TORRES DE HANOI \t\n\n");
int dis;//Declaracion de un int
char origen='A';//declaracion de char para A
char aux='B';//Declaracion de un char para B
char destino='C';//Declaracion de un char para C
printf("\t Numero de discos:");//Imprime a pantalla
scanf("%d", &dis);//Almacena la informacion obtenida en dis
printf("\n");
printf("\t Movimientos a realizar:\n");//Imprime a pantalla
printf("\n");
hanoi(dis,origen,aux,destino);//Llama a la funcion hanoi
}
/*
void hanoi(int disco, char origen, char aux,  char destino)
Descripcion:
Recibe:int disco, char origen, char aux,  char destino
*/
void hanoi(long int disco, char origen, char aux,  char destino)
{
    if (disco==1)//Si el disco es 1, se imprimira a pantalla lo siguiente
    {
        printf("\t\tDisco %d de la torre %c a %c\n",disco,origen,destino);
    }
    else//De lo contrario
    {
        hanoi(disco-1,origen,destino,aux);// Se llama a la misma funcion, se aplica la recursividad
        printf("\t\tDisco %d de la torre %c a %c\n",disco,origen,destino);// Imprime a pantalla
        hanoi(disco-1,aux,origen,destino);// Se llama a la misma funcion, se aplica la recursividad
    }
}
