//Torres de Hanoi
#include <stdlib.h>
#include <stdio.h>

//Declarar Funcion
void hanoi(int disco, char origen, char aux,  char destino);

int main()
{
int dis;
char origen='A';
char aux='B';
char destino='C';
printf("Numero de discos:\n");
scanf("%d", &dis);
printf("Movimientos a realizar:\n");
hanoi(dis,origen,aux,destino);
}

void hanoi(int disco, char origen, char aux,  char destino)
{
if (disco==1)
{
printf("Disco %d de la torre %c a %c\n",disco,origen,destino);
}
else{
hanoi(disco-1,origen,destino,aux);
printf("Disco %d de la torre %c a %c\n",disco,origen,destino);
hanoi(disco-1,aux,origen,destino);
}
}
