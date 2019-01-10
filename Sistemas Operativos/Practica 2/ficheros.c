#include <stdio.h>
#include <string.h>
#include <fcntl.h>
#include <time.h>
#include <string.h>
#include <stdlib.h>
int main(int argc, char* argv[])
{
    char nombre[100]="default"; //Establece un nombre default para el archivo
    char direccion[1000]=""; //Direccion para guardar el archivo
    char original[1000]=""; //Direccion original del archivo
    char *ap;
    char aux;
    int mayus;
    int i,j;
    srand(time(NULL));
    printf("Ingresa la direccion en la que se guardaran los archivos:\n");
    fflush(stdin);
    scanf("%[^\n]",&direccion);
    strcat(direccion,"\\"); //Se agrega una diagonal al final de la direccion
    ap=nombre;
    i=(int)rand()%15; //Numero de archivos que se van a crear
    printf("Se crearan %d archivos.\n",i);
    while(i>0)
    {
        for(j=0;j<20;j++)
        {
            mayus=(int)(32+(rand()%26));
            aux=(char)(mayus+32);
            printf("%c ",aux);
            *ap=aux;
            ap++;
        }
        putchar('\n');//Salto de línea dentro del archivo
        ap=nombre;
        strcat(direccion,"A"); //Se concatena la direccion con el nombre del archivo
        strcat(original,direccion);
        strcat(original,".txt"); //Se agrega una extension al archivo

        int archivo = open(original,O_CREAT|O_WRONLY,0644); //Permiso
        if(archivo ==-1)
        {
            printf("Error al intentar abrir el archivo.");
            exit(1);
        }

        FILE *archivo2=fopen(original,"w"); //Abre el archivo
        fprintf(archivo2,nombre,original); //Escribe en el archivo en la direccion indicada
        if(archivo==-1)
        {
            printf("Error al intentar escribir en el archivo.");
            exit(1);
        }
        else
        {
            printf("%d - %s\n",archivo,original);
            fclose(archivo2); //Se cierra el archivo
            original[0]='\0'; //Se reestablace la cadena de original
            i--;
        }
    }
    return 0;
}
