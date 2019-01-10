/*
AUTORES:
Tania Itzel Nuñez García
Verónica Jackeline Quiros Díaz
Erick Efraín Vargas Romero
(C) Noviembre 2016
VERSIÓN: 1.0

DESCRIPCIÓN: Con la implementación del TAD lista realizar la implementación de una tabla hash abierta, capaz de soportar
el almacenamiento de palabras y sus definiciones (Diccionario de palabras).

EJECUCIÓN: Práctica 3.exe (En Windows)
*/
//LIBRERIAS
#include <stdio.h>//Incluye las funciones estandar de entrada y salida
#include <math.h>//Incluye la funciones de operaciones matematicas
#include <string.h>//Incluye las funciones de cadena
#include <stdlib.h>
#include "..\Strings\ForStrings.c"

//Prototipos de funciones
int Hashing(char* palabra, int mostrar);
int Hashing2(char* palabra, int mostrar);
posicion Buscar(lista* tabla_hash, char* a_buscar, int mostrar);
void Anadir_Palabra(lista* tabla_hash, elemento mi_elemento, int mostrar);
void Eliminar_Palabra(lista* tabla_hash, char* palabra);
void Modificar_Definicion(lista* tabla_hash, char* palabra);
void Guardar_Diccionario(char* nombre, lista* tabla_hash);
void Guardar_Palabra(lista * tabla_hash, posicion mi_posicion, char* nombre);
void Leer_Archivos(char* ruta, lista* tabla_hash);
void Buscar_Letra(char letra, lista* tabla_hash);
void Buscar_Sub_Cadena(lista* tabla_hash, char* subcadena);

/*
int Hashing(char* palabra)
Descripcion: Permite mapear la letra en un numero, para una busqueda de codigo mas facil
Recibe:char* palabra
Devuelve: regresare
*/
int Hashing(char* palabra, int mostrar)
{
    double Aurea = (1 + sqrt(5))/2, regresare;
    int tamano, acum = 0, i;//Se almacenan los datos proporcionados Y se inicializa acum en cero.
    tamano = strlen(palabra);
    for(i = 0; i<tamano; i++)//un ciclo hasta que i<tamano no se cumpla
    {
        if(palabra[i] != 32)//si se cumple est condicion
            acum = (int)palabra[i];// acum almacenara la informacion que contenga (int)palabra[i]
    }
    regresare = 1000/((acum*Aurea)/tamano);
    if(mostrar == 0)//si se cumple que es igual a cero
        printf("\n->La palabra %s tiene un valor %f al hacer hashing", palabra, regresare);//imprimira esto a pantalla
    return regresare;
}
int Hashing2(char* palabra, int mostrar)
{
    double Aurea = (1 + sqrt(8))/2, regresare;
    int tamano, acum = 0, i;//Se almacenan los datos proporcionados Y se inicializa acum en cero.
    tamano = strlen(palabra);
    for(i = 0; i<tamano; i++)//un ciclo hasta que i<tamano no se cumpla
    {
        if(palabra[i] != 32)//si se cumple est condicion
            acum = (int)palabra[i];// acum almacenara la informacion que contenga (int)palabra[i]
    }
    regresare = 1000/((acum*Aurea)/tamano*tamano);
    if(mostrar == 0)//si se cumple que es igual a cero
        printf("\n->La palabra %s tiene un valor %f al hacer hashing", palabra, regresare);//imprimira esto a pantalla
    return regresare;
}

/*
posicion Buscar(lista* tabla_hash, char* a_buscar, int mostrar)
Descripcion:busca la clave obtenida del hasheo
Recibe:lista* tabla_hash, char* a_buscar, int mostrar
Devuelve: regresare
*/
posicion Buscar(lista* tabla_hash, char* a_buscar, int mostrar)
{
    int i = 0;//se declara i y se inicializa en cero
    int pasos = 1;//se declara pasos y se iniciliza en 1
    boolean bandera = FALSE;
    posicion mi_posicion = Final(&tabla_hash[Hashing(a_buscar, 1)]);
    posicion regresare = NULL;
    if(mi_posicion != NULL)//si se cumple esta condicion se hara lo siguiente
    {
        for(i=0; i<Size(&tabla_hash[Hashing(a_buscar, 1)]); i++)//el for se termina hasta que no se cumpla eta condicion
                {
            pasos++;//se incrementa pasos
            if(strcmp(mi_posicion->e.p, a_buscar) == 0)// si se cumple esta condicion se relizara lo siguiente
            {
                regresare = mi_posicion;//se almacena la informacion
                i = Size(&tabla_hash[Hashing(a_buscar, 0)])-1;
            }
            pasos++;//se incrmenta pasos
            mi_posicion = mi_posicion->adelante;//se almacena la informacion
        }
    }
    if(regresare && mostrar == 0)//si se cumpl esta condicion se hara lo siguiente
        printf("\n\t->Di %d pasos para encontrar la palabra o verificar si existe %s", pasos, regresare->e.p);//se imprimira a pantalla
    return regresare;//retorna regresare
}
/*
void Eliminar_Palabra(lista* tabla_hash, char* palabra)
Descripcion: el metodo elimina una palabra del diccionario
Recibe:lista* tabla_hash, char* palabra
*/
void Eliminar_Palabra(lista* tabla_hash, char* palabra)
{
    posicion eliminare = NULL;//se inicializa en NULL
    eliminare = Buscar(tabla_hash, palabra, 0);//se iguala al valor que contega la funcion buscar

    if(eliminare != NULL)//si e cumple esto, se realizara lo siguiente
    {
        Remove(&tabla_hash[Hashing(palabra, 1)], eliminare);//se llama a ala funcion para remover
        printf("\nSe ha eliminado la palabra %s de manera satisfactoria :D", palabra);// se imprime a pantalla
        //eliminare = Buscar(tabla_hash, palabra, 1);
        //printf("\nExiste el nodo? -> %s", eliminare->e.p);
    }
    else//sino se hara lo siguiente
    {
        printf("\nLa palabra %s no esta en el diccionario :C", palabra);//se imprime a pantalla
    }
}
/*
void Modificar_Definicion(lista* tabla_hash, char* palabra)
Descripcion: El metodo permite modificar una definicion
Recibe:lista* tabla_hash, char* palabra
*/
void Modificar_Definicion(lista* tabla_hash, char* palabra)
{
    posicion modificare = NULL;
    modificare = Buscar(tabla_hash, palabra, 0);
    if(modificare != NULL)
    {
        fflush(stdin);//elimina la basura, libera
        printf("\nDefinicion de la palabra %s es: %s", modificare->e.p, modificare->e.d);//imprime a pantalla
        printf("\nSe encontro la palabra %s, cual sera su nueva definicion? -> ", modificare->e.p);//inprime a pantalla
        gets(modificare->e.d);// almacena
        printf("\nSe ha modificado la palabra %s correctamente :D ", modificare->e.p);//imprime a pantalla
        /**modificare = Buscar(tabla_hash, palabra);
        printf("\nLa nueva definicion de la palabra %s es: %s", modificare->e.p, modificare->e.d);**/
    }
    else//sino realizara lo siguiente
    {
        printf("\nEsa palabra no se encuentra en el diccionario :'v");//imprime a pantalla
    }
}
/*void Anadir_Palabra(lista* tabla_hash, elemento mi_elemento, int mostrar)
Descripcion: permite añadir una palabra al diccionario
Recibe:lista* tabla_hash, elemento mi_elemento, int mostrar
*/
void Anadir_Palabra(lista* tabla_hash, elemento mi_elemento, int mostrar)
{
    //printf("\n\t->%s", mi_elemento.p);
    if(Buscar(tabla_hash, mi_elemento.p, mostrar) == NULL && strcmp(mi_elemento.p, "") != 0 && strcmp(mi_elemento.d, "") != 0)//si se cumple esto, se realizara lo siguiente
        Add(&tabla_hash[Hashing(mi_elemento.p, mostrar)], mi_elemento);//llama a la funcion con estos argumentos
    else// sino se cumple, se hara lo siguiente
    {
        if(mostrar == 0)// si se cumple que es igual a cero se hara lo siguiente
            printf("\nLa palabra %s ya existe en el diccionario, no sera anadida", mi_elemento.p);//imprimira a pantalla
    }
}
/*
void Guardar_Diccionario(char* nombre, lista* tabla_hash)
Descripcion: Permite guardar en el diccionario
Recibe:char* nombre, lista* tabla_hash
*/
void Guardar_Diccionario(char* nombre, lista* tabla_hash)
{
    int i, j;//se declara i y j
    posicion mi_posicion = NULL;
    FILE* archivo;// un puntero a FILE
    strcat(nombre, ".txt");
    archivo = fopen(nombre, "w+");// abre en el archivo donde se guardara
    if(archivo != NULL)//si se cumple que es diferente que NULL, se hara lo siguiente
    {
        for(i=0; i<1000; i++)//el for terminra cuando ya no se ucmpla esta condicion
        {
            if(!Empty(&tabla_hash[i]))// Si no es vacio se hara lo siguiente
            {
                mi_posicion = Final(&tabla_hash[i]);
                for(j=0; j<Size(&tabla_hash[i]); j++)//el for se termina cuando ya no se cumple esta condicion
                {
                    if(mi_posicion != NULL)//si se cumple esta condicion se realizara lo siguiente
                        fprintf(archivo, "%s: %s", mi_posicion->e.p, mi_posicion->e.d);
                    mi_posicion = mi_posicion->adelante;
                }
            }
        }
    }
    else//sino se hara lo siguiente
        printf("\nNo se ha guardado en el archivo :'v");//se imprimira a pantalla
    fclose(archivo);//se cierra el archivo donde se guardo
}
/*
void Guardar_Palabra(lista * tabla_hash, posicion mi_posicion, char* nombre)
Descripcion:  permite guardar una palabra
Recibe:Guardar_Palabra(lista * tabla_hash, posicion mi_posicion, char* nombre
*/
void Guardar_Palabra(lista * tabla_hash, posicion mi_posicion, char* nombre)
{
    FILE* archivo;//puntador a FILE
    strcat(nombre, ".txt");
    archivo = fopen(nombre, "w+");
    //printf("\n")
    if(archivo != NULL)//si se cumple que no es vacio, se hace lo siguiente
    {
        fprintf(archivo, "%s: %s", mi_posicion->e.p, mi_posicion->e.d);
    }
    else
        printf("\n\tNo se ha guardado en el archivo :'v");//se imprimira a pantalla
    fclose(archivo);// se cierra el archivo
}
/*
void Leer_Archivos(char* ruta, lista* tabla_hash)
Descripcion: permite leer los archivos que se incluyan
Recibe:char* ruta, lista* tabla_hash
*/
void Leer_Archivos(char* ruta, lista* tabla_hash)
{
    elemento mi_elemento;
    char mi_palabra[400];//se crea un arreglo de 400
    FILE* archivo;//puntador a FILE
    archivo = fopen(ruta, "r");// almacena la informacion
    if(archivo != NULL)//si se cumple esta condicion se cumplira lo siguiente
    {
        while(feof(archivo) == 0)// l ciclo terminara cuando ya no se cumpla la condicion
        {
            fgets(mi_palabra, 400, archivo);// imrpimira a pantalla
            Significado(mi_palabra, tabla_hash, 1);// llama a la funcion
        }
    }
    else
        printf("\nNo se ha leido el archivo :'v");// imprimira  a pantalla
    fclose(archivo);
}
/*
void Buscar_Letra(char letra, lista* tabla_hash)
Descripcion: Permite hacer una busqueda de la palabra que se introduzca
Recibe:char letra, lista* tabla_hash
*/
void Buscar_Letra(char letra, lista* tabla_hash)
{
    int i = 0, j = 0, k = 1;//se declara i,j  y k se inicializan en cero
    int busqueda = 1;//se iniciliaza en 1

    posicion mi_posicion = NULL;
    for(i=0; i<1000; i++)// se termina el for cuando ya no se cumpla la condicion
    {
        busqueda++;
        if(!Empty(&tabla_hash[i]))//si se cumple la condicion se hara lo siguiente
        {
            mi_posicion = Final(&tabla_hash[i]);
            for(j=0; j<Size(&tabla_hash[i]) && mi_posicion != NULL; j++)// se termina el for cuando ya no se cumpla la condicion
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
/*
void Buscar_Sub_Cadena(lista* tabla_hash, char* subcadena)
Descripcion: busca una subcadena
Recibe:lista* tabla_hash, char* subcadena
*/
void Buscar_Sub_Cadena(lista* tabla_hash, char* subcadena)
{
    int i = 0, j = 0, k = 1, pasos = 1;//se declara i, j y k en cero y uno
    posicion mi_posicion = NULL;
    for(i=0; i<1000; i++)//el for termina cuando ya no e cumpla la condicion
    {
        pasos++;//se incrementa pasos
        if(!Empty(&tabla_hash[i]))// si se cumple la condicion se hara lo siguiente
        {
            mi_posicion = Final(&tabla_hash[i]);
            for(j=0; j<Size(&tabla_hash[i]) && mi_posicion != NULL; j++)// el for termina cuando ya no se cumpla esta condicion
            {
                pasos++;//se incrementa pasos
                if(SubCadena(mi_posicion->e.p, subcadena) && mi_posicion != NULL)//si se cumple esta condicion se haara lo siguiente
                    printf("\n%d. %s: %s -> -> di %d pasos para encontrar esta palabra\n", k++, mi_posicion->e.p, mi_posicion->e.d, pasos);
                mi_posicion = mi_posicion->adelante;
            }
        }
    }
}
