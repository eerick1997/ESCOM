#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "..\TADLista\TADLista.c"
#include "ForStrings.h"

boolean SubCadena(char* palabra, char* sub_cad)
{
    boolean existe = FALSE;
    char aux[strlen(sub_cad)];
    strcpy(aux, "");
    int i, j;

    for(i = 0; i<strlen(palabra); i++)
    {
        if(strlen(sub_cad) > strlen(palabra))
            i = strlen(palabra)-1;
        else
        {
            for(j=0; j<strlen(sub_cad); j++){
                aux[j] = palabra[j+i];
            }
            if(strstr(aux, sub_cad) != NULL)
            {
                i = strlen(palabra)-1;
                existe = TRUE;
            }
        }
    }
    //printf("\n\tExiste %d ", existe);
    return existe;
}

void Significado(char* Palabra, lista* tabla_hash, int mostrar)
{
    //printf("\nSignificado() Starts...");
    char significado[550] = "", palabras[250]="";
    int i = 0, j = 0;
    while(Palabra[j] != ':')//Palabra[j] != 32 && Palabra[j-1] != ':')//Palabra[j] != ':' && Palabra[j+1] != 32)//&& Palabra[j] != '.')
    {
        palabras[j] = Palabra[j];
        j++;
    }
    j++;
    if(Palabra[j] == 32)
        j++;
    while(j!=strlen(Palabra))//Palabra[j] != '\0')
    {
        significado[i] = Palabra[j];
        j++;
        i++;
    }
    if(strcmp(palabras, "") != 0)
        Separando_Palabras(palabras, significado, tabla_hash, mostrar);
}


void Separando_Palabras(char* Palabra, char* Definicion, lista* tabla_hash, int mostrar)
{
    int i = 0, j = 0;
    elemento mi_elemento;
    char aux[100] = "";
    strcpy(mi_elemento.p, "");
    strcpy(mi_elemento.d, Definicion);

    if(strcmp(Palabra, "") != 0)
    {
        //printf("\nPalabra contains: %s, Definicion contains: %s", Palabra, Definicion);
        //printf("\n\tNo es nula");
        if(SubCadena(Palabra, "/"))
        {
            //printf("\n\tHay un / en la cadena");
            if(Palabra[0] == 32)
                j = 1;
            while(Palabra[j] != '/')// && Palabra[j+1] == 32)
            {

                aux[i] = Palabra[j];
                j++;
                i++;
            }
            strcpy(mi_elemento.p, aux);
            //printf("\n\t%s", mi_elemento.p);

            Anadir_Palabra(tabla_hash, mi_elemento, mostrar);
            strcpy(mi_elemento.p, "");
            strcpy(aux, "");
            j++;
            i=0;
            if(Palabra[j] == 32)
                j++;
            while(j != strlen(Palabra))
            {
                //if(Palabra[j] != 32)
                aux[i] = Palabra[j];
                j++;
                i++;
            }
            //printf("\n\t%s, \t%s", aux, Palabra);
            if(strcmp(aux, "") != 0)
                Separando_Palabras(aux, Definicion, tabla_hash, mostrar);
        }
        else
        {
            //printf("\n\t\t\t%s", Palabra);
            strcpy(mi_elemento.p, Palabra);
            Anadir_Palabra(tabla_hash, mi_elemento, mostrar);
        }
    }
}
