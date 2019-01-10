/*
AUTORES:
Tania Itzel Nuñez García
Verónica Jackeline Quiros Díaz
Erick Efraín Vargas Romero
(C) Noviembre 2016
VERSIÓN: 1.0

DESCRIPCIÓN:Con la implementación del TAD lista realizar la implementación de una tabla hash abierta, capaz de soportar
el almacenamiento de palabras y sus definiciones (Diccionario de palabras).

EJECUCIÓN: Práctica 3.exe (En Windows)
*/

//LIBRERIAS
#include <stdio.h>//Incluye las funciones estandar de entrada y salida
#include <string.h>// Incluye las funciones de cadena
#include <stdlib.h>
#include "..\TADLista\TADLista.c"//Libreria donde se ubica la lista
#include "ForStrings.h"//Libreria donde se ubican las cadenas

/*boolean SubCadena(char* palabra, char* sub_cad)
Descripcion: Evalua si es Falso o Verdadero
Recibe:char* palabra, char* sub_cad
Devuelve: existe
*/
boolean SubCadena(char* palabra, char* sub_cad)
{
    boolean existe = FALSE;
    char aux[strlen(sub_cad)];
    strcpy(aux, "");
    int i, j;//Se almacenan los datos proporcionados

    for(i = 0; i<strlen(palabra); i++)//el for termina cuando i<strlen(palabra) ya no se cumpla
    {
        if(strlen(sub_cad) > strlen(palabra))//Si se cumpla la condicion de que strlen(sub_cad) es mayor que strlen(palabra), se hara lo siguiente
            i = strlen(palabra)-1;
        else//sino se realizara lo siguiente
        {
            for(j=0; j<strlen(sub_cad); j++){
                aux[j] = palabra[j+i];
            }
            if(strstr(aux, sub_cad) != NULL)//si se cumple esta condicion, se realizara lo siguiente
            {
                i = strlen(palabra)-1;
                existe = TRUE;
            }
        }
    }
    //printf("\n\tExiste %d ", existe);
    return existe;//regresara existe
}
/*void Significado(char* Palabra, lista* tabla_hash, int mostrar)
Descripcion: recorre la cadena buscando espacios
Recibe:char* Palabra, lista* tabla_hash, int mostrar
*/
void Significado(char* Palabra, lista* tabla_hash, int mostrar)
{
    //printf("\nSignificado() Starts...");
    char significado[550] = "", palabras[250]="";
    int i = 0, j = 0;//Se almacenan los datos proporcionados y se inicializan en cero
    while(Palabra[j] != ':')//Palabra[j] != 32 && Palabra[j-1] != ':')//Palabra[j] != ':' && Palabra[j+1] != 32)//&& Palabra[j] != '.')
    {
        palabras[j] = Palabra[j];
        j++;//se incrementa j
    }
    j++;
    if(Palabra[j] == 32)//si palabra es igual a 32, se incrementara j
        j++;
    while(j!=strlen(Palabra))//Repite las instrucciones hasta que ya no se cumpla la condicion
    {
        significado[i] = Palabra[j];
        j++;// se incrementa j
        i++;//se incrementa i
    }
    if(strcmp(palabras, "") != 0) //si se cumple esta condicion
        Separando_Palabras(palabras, significado, tabla_hash, mostrar);//manda a llamara a la funcion con estos argumentos
}
/*
void Separando_Palabras(char* Palabra, char* Definicion, lista* tabla_hash, int mostrar)
Descripcion: El metodo recorre las cadenas y separa las palabras
Recibe:char* Palabra, char* Definicion, lista* tabla_hash, int mostrar
*/
void Separando_Palabras(char* Palabra, char* Definicion, lista* tabla_hash, int mostrar)
{
    int i = 0, j = 0;//se declara i y j, se inicializan en cero
    elemento mi_elemento;// se crea mi_elemento
    char aux[100] = "";//un arreglo de 100
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
            while(Palabra[j] != '/')// && Palabra[j+1] == 32)// el ciclo termina hasta que ya no se cumpla esta condicion.
            {
                aux[i] = Palabra[j];// aux[i] guardara lo que tenga Palabra[j]
                j++;//se incrementa j
                i++;//se incrementa i
            }
            strcpy(mi_elemento.p, aux);
            //printf("\n\t%s", mi_elemento.p);

            Anadir_Palabra(tabla_hash, mi_elemento, mostrar);//Se llamara la funcion, con estos argumentos
            strcpy(mi_elemento.p, "");
            strcpy(aux, "");
            j++;//se incrementa j
            i=0;//se inicializa en cero
            if(Palabra[j] == 32)//si se cumple que Palabra es igual a 32, se realizara lo siguiente
                j++;//se incrementa j
            while(j != strlen(Palabra))//Repite las instrucciones hasta que ya no se cumpla la condicion
            {
                //if(Palabra[j] != 32)
                aux[i] = Palabra[j];// aux almacenara lo que contega Palabra
                j++;//se incrementa j
                i++;//se incrementa i
            }
            //printf("\n\t%s, \t%s", aux, Palabra);
            if(strcmp(aux, "") != 0)
                Separando_Palabras(aux, Definicion, tabla_hash, mostrar);//Se utiliza recursividad de esta funcion
        }
        else//sino , se hara lo siguiente
        {
            //printf("\n\t\t\t%s", Palabra);
            strcpy(mi_elemento.p, Palabra);
            Anadir_Palabra(tabla_hash, mi_elemento, mostrar);// se llama a ala funcion, con estos argumentos
        }
    }
}
