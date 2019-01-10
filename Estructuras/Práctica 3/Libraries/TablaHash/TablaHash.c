#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>
#include "..\Strings\ForStrings.c"

//Prototipos de funciones
int Hashing(char* palabra, int mostrar);
posicion Buscar(lista* tabla_hash, char* a_buscar, int mostrar);
void Anadir_Palabra(lista* tabla_hash, elemento mi_elemento, int mostrar);

int Hashing(char* palabra, int mostrar)
{
    double Aurea = (1 + sqrt(5))/2, regresare;
    int tamano, acum = 0, i;
    tamano = strlen(palabra);
    for(i = 0; i<tamano; i++)
    {
        if(palabra[i] != 32)
            acum = (int)palabra[i];
    }
    regresare = 1000/((acum*Aurea)/tamano);
    if(mostrar == 0)
        printf("\n->La palabra %s tiene un valor %f al hacer hashing", palabra, regresare);
    return regresare;
}

/**Descripcion: La funcion
**/
posicion Buscar(lista* tabla_hash, char* a_buscar, int mostrar)
{
    int i = 0;
    int pasos = 1;
    boolean bandera = FALSE;
    posicion mi_posicion = Final(&tabla_hash[Hashing(a_buscar, 1)]);
    posicion regresare = NULL;
    if(mi_posicion != NULL)
    {
        for(i=0; i<Size(&tabla_hash[Hashing(a_buscar, 1)]); i++)
        {
            pasos++;
            if(strcmp(mi_posicion->e.p, a_buscar) == 0)
            {
                regresare = mi_posicion;
                i = Size(&tabla_hash[Hashing(a_buscar, 0)])-1;
            }
            pasos++;
            mi_posicion = mi_posicion->adelante;
        }
    }
    if(regresare && mostrar == 0)
        printf("\n\t->Di %d pasos para encontrar la palabra o verificar si existe %s", pasos, regresare->e.p);
    return regresare;
}

void Eliminar_Palabra(lista* tabla_hash, char* palabra)
{
    posicion eliminare = NULL;
    eliminare = Buscar(tabla_hash, palabra, 0);

    if(eliminare != NULL)
    {
        Remove(&tabla_hash[Hashing(palabra, 1)], eliminare);
        printf("\nSe ha eliminado la palabra %s de manera satisfactoria :D", palabra);
        //eliminare = Buscar(tabla_hash, palabra, 1);
        //printf("\nExiste el nodo? -> %s", eliminare->e.p);
    }
    else
    {
        printf("\nLa palabra %s no esta en el diccionario :C", palabra);
    }
}

void Modificar_Definicion(lista* tabla_hash, char* palabra)
{
    posicion modificare = NULL;

    modificare = Buscar(tabla_hash, palabra, 0);
    if(modificare != NULL)
    {
        fflush(stdin);
        printf("\nDefinicion de la palabra %s es: %s", modificare->e.p, modificare->e.d);
        printf("\nSe encontro la palabra %s, cual sera su nueva definicion? -> ", modificare->e.p);
        gets(modificare->e.d);
        printf("\nSe ha modificado la palabra %s correctamente :D ", modificare->e.p);
        /**modificare = Buscar(tabla_hash, palabra);
        printf("\nLa nueva definicion de la palabra %s es: %s", modificare->e.p, modificare->e.d);**/
    }
    else
    {
        printf("\nEsa palabra no se encuentra en el diccionario :'v");
    }
}

void Anadir_Palabra(lista* tabla_hash, elemento mi_elemento, int mostrar)
{
    //printf("\n\t->%s", mi_elemento.p);
    if(Buscar(tabla_hash, mi_elemento.p, mostrar) == NULL && strcmp(mi_elemento.p, "") != 0 && strcmp(mi_elemento.d, "") != 0)
        Add(&tabla_hash[Hashing(mi_elemento.p, mostrar)], mi_elemento);
    else
    {
        if(mostrar == 0)
            printf("\nLa palabra %s ya existe en el diccionario, no sera anadida", mi_elemento.p);
    }
}

void Guardar_Diccionario(char* nombre, lista* tabla_hash)
{
    int i, j;
    posicion mi_posicion = NULL;
    FILE* archivo;
    strcat(nombre, ".txt");
    archivo = fopen(nombre, "w+");
    if(archivo != NULL)
    {
        for(i=0; i<1000; i++)
        {
            if(!Empty(&tabla_hash[i]))
            {
                mi_posicion = Final(&tabla_hash[i]);
                for(j=0; j<Size(&tabla_hash[i]); j++)
                {
                    if(mi_posicion != NULL)
                        fprintf(archivo, "%s: %s", mi_posicion->e.p, mi_posicion->e.d);
                    mi_posicion = mi_posicion->adelante;
                }
            }
        }
    }
    else
        printf("\nNo se ha guardado en el archivo :'v");
    fclose(archivo);
}

void Guardar_Palabra(lista * tabla_hash, posicion mi_posicion, char* nombre)
{
    FILE* archivo;
    strcat(nombre, ".txt");
    archivo = fopen(nombre, "w+");
    //printf("\n")
    if(archivo != NULL)
    {
        fprintf(archivo, "%s: %s", mi_posicion->e.p, mi_posicion->e.d);
    }
    else
        printf("\n\tNo se ha guardado en el archivo :'v");
    fclose(archivo);
}

void Leer_Archivos(char* ruta, lista* tabla_hash)
{
    elemento mi_elemento;
    char mi_palabra[400];
    FILE* archivo;
    archivo = fopen(ruta, "r");
    if(archivo != NULL)
    {
        while(feof(archivo) == 0)
        {
            fgets(mi_palabra, 400, archivo);
            Significado(mi_palabra, tabla_hash, 1);
        }
    }
    else
        printf("\nNo se ha leido el archivo :'v");
    fclose(archivo);
}

void Buscar_Letra(char letra, lista* tabla_hash)
{
    int i = 0, j = 0, k = 1;
    int busqueda = 1;

    posicion mi_posicion = NULL;
    for(i=0; i<1000; i++)
    {
        busqueda++;
        if(!Empty(&tabla_hash[i]))
        {
            mi_posicion = Final(&tabla_hash[i]);
            for(j=0; j<Size(&tabla_hash[i]) && mi_posicion != NULL; j++)
            {
                busqueda++;
                if(mi_posicion->e.p[0] == letra && mi_posicion != NULL)
                {
                    printf("\n%d. %s: %s-> ->di %d saltos\n", k++, mi_posicion->e.p, mi_posicion->e.d, busqueda);
                }
                mi_posicion = mi_posicion->adelante;
            }
        }
    }
}

void Buscar_Sub_Cadena(lista* tabla_hash, char* subcadena)
{
    int i = 0, j = 0, k = 1, pasos = 1;
    posicion mi_posicion = NULL;
    for(i=0; i<1000; i++)
    {
        pasos++;
        if(!Empty(&tabla_hash[i]))
        {
            mi_posicion = Final(&tabla_hash[i]);
            for(j=0; j<Size(&tabla_hash[i]) && mi_posicion != NULL; j++)
            {
                pasos++;
                if(SubCadena(mi_posicion->e.p, subcadena) && mi_posicion != NULL)
                    printf("\n%d. %s: %s -> -> di %d pasos para encontrar esta palabra\n", k++, mi_posicion->e.p, mi_posicion->e.d, pasos);
                mi_posicion = mi_posicion->adelante;
            }
        }
    }
}
