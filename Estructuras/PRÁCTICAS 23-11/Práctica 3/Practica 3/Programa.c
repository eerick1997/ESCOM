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
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
//LIbreria donde se encuantran almacenadas las funciones del HASH
#include "..\Libraries\TablaHash\TablaHash.c"
//DECLARACION DE CONSTANTES
#define lunfardo "Lunfardo.txt"

//prototipos
void Menu(lista* tabla_hash);
void guardar(lista* tabla_hash, char* ruta);
void filtrar(lista* tabla_hash);
void Estadisticas(lista * tabla_hash);

// PROGRAMA PRINCIPAL
void main(void)
{
    int i;// se declara i
    lista tabla_hash[1000];//se crea una tabla de 1000
    for(i=0; i<1000; i++)// el for termina cuando ya no se cumple la condicion
        Initialize(&tabla_hash[i]);//se  inicializa la tabla cerada

    Leer_Archivos(lunfardo, &tabla_hash);// llama a la funcion
    system("CLS");//limpia pantalla
    //Estadisticas(&tabla_hash);
    Menu(&tabla_hash);// //llama a la funcion
}
/*
void Menu(lista* tabla_hash)
Descripcion:Da opciones al usuario de lo que desea hacer
Recibe: lista* tabla_hash

*/
void Menu(lista* tabla_hash)
{
    char ruta[250] = "";
    elemento mi_elemento;//se declara mi_elemento
    strcpy(mi_elemento.p, "");//Copia cada uno de los caracteres que tiene mi_elemento.p
    strcpy(mi_elemento.d, "");//Copia cada uno de los caracteres que tiene mi_elemento.p

    printf("\n\t\t\t\t DICCIONARIO HASH B|\n\n\n");//se imprime a pantalla

    int x = 0;//Se declara x y se inicializa en 0
    printf("\t1. Cargar un archivo de definiciones \n\n");//se imprime a pantalla
    printf("\t2. Agregar una palabra y su definicion \n\n");//se imprime a pantalla
    printf("\t3. Modificar una definicion \n\n");//se imprime a pantalla
    printf("\t4. Eliminar una palabra \n\n");//se imprime a pantalla
    printf("\t5. Filtrar \n\n");//se imprime a pantalla
    printf("\t6. Guardar \n\n");//se imprime a pantalla
    printf("\t7. Estadisticas \n\n");//se imprime a pantalla
    printf("\t8. Salir del programa \n\n\t-> ");//se imprime a pantalla
    scanf("%d", &x);

    switch (x)// Proporciona un menu de los posibles casos a dar
    {
    case 1: //printf("Lala 1 \n\n");
        fflush(stdin);//elimina la basura
        printf("\nCargare un archivo de definiciones escribe el nombre del archivo \n->");//se imprime a pantalla
        gets(ruta);//almacena
        strcat(ruta, ".txt");
        Leer_Archivos(ruta, tabla_hash);
        printf("\n\n");//se imprime a pantalla
        system("PAUSE");//termina el proceso
        system("CLS");//limpia pantalla
        Menu(tabla_hash);//llama la funcion
        break;

    case 2: //printf("Lalala 2 \n\n");
        fflush(stdin);
        printf("\nIngresa la palabra \n-> ");//se imprime a pantalla
        gets(mi_elemento.p);// almacena informacion
        fflush(stdin);//elimina la basura
        printf("\nIngresa la definicion \n-> ");//se imprime a pantalla
        gets(mi_elemento.d);//almacena
        Anadir_Palabra(tabla_hash, mi_elemento, 0);
        printf("\n\n");//se imprime a pantalla
        system("PAUSE");//termina el proceso
        system("CLS");//limpia pantalla
        Menu(tabla_hash);//manda a llamara la funcion
        break;

    case 3: //printf("Lalala 3 \n\n");
        fflush(stdin);//elimina basura
        printf("\nIngresa la palabra \n-> ");//se imprime a pantalla
        gets(mi_elemento.p);//almacena informacion
        Modificar_Definicion(tabla_hash, mi_elemento.p);
        printf("\n\n");//se imprime a pantalla
        system("PAUSE");// termina el proceso
        system("CLS");//limpia a pantalla
        Menu(tabla_hash);//llama la funcion
        break;

    case 4: //printf("Lalala 4 \n\n");
        fflush(stdin);
        printf("\nQue palabra sera eliminada? \n -> ");//se imprime a pantalla
        gets(mi_elemento.p);
        Eliminar_Palabra(tabla_hash, mi_elemento.p);
        printf("\n\n");//se imprime a pantalla
        system("PAUSE");
        system("CLS");//limpia la pantalla
        Menu(tabla_hash);//llama la funcion
        break;
    case 5:
        printf("\n\tFiltrar diccionario");//se imprime a pantalla
        filtrar(tabla_hash);//elimina la basura
        printf("\n\n");//se imprime a pantalla
        system("PAUSE");
        system("CLS");// limpia la pantalla
        Menu(tabla_hash);//llama la funcion
        break;
    case 6:
        fflush(stdin);//elimina la basura
        printf("\n\tComo se llamara el archivo? \n -> ");//se imprime a pantalla
        gets(ruta);// almacena informacion
        guardar(tabla_hash, ruta);// llama la funcion

        printf("\n\n");//se imprime a pantalla
        system("PAUSE");
        system("CLS");//limpia la basura
        Menu(tabla_hash);// manda a llamara la funcion
    case 7:
        Estadisticas(tabla_hash);
        printf("\n\n");//se imprime a pantalla
        system("PAUSE");
        system("CLS");//limpia la pantalla
        Menu(tabla_hash);//llama la funcion
        break;
    case 8:
        exit (0);//termina el proceso
        break;

    default:
        printf("\n\tEsta opcion no existe");//se imprime a pantalla
        break;
    }
}
/*void guardar(lista* tabla_hash, char* ruta)
Descripcion: Guarda la informacion proporcionadapor el usuario
Recibe: lista* tabla_hash, char* ruta
*/

void guardar(lista* tabla_hash, char* ruta)
{
    int x;//se declara x
    posicion mi_posicion;//se declara mi_posicion
    char texto[100] = "";// se crea el arreglo de 100
    printf("\n\tElige una opcion");//se imprime a pantalla
    printf("\n\t1.Exportar todo el diccionario");//se imprime a pantalla
    printf("\n\t2.Exportar una palabra \n\t -> ");//se imprime a pantalla
    scanf("%d", &x);//almacena informacion
    switch(x)
    {
    case 1:
        Guardar_Diccionario(ruta, tabla_hash);//llama la funcion
        break;
    case 2:
        fflush(stdin);//Quita la basura
        printf("\n\tQue palabra sera exportada? \n\t ->");//se imprime a pantalla
        gets(texto);//almacena la informacion proporcionada
        mi_posicion = Buscar(tabla_hash, texto, 0);
        if(mi_posicion != NULL)//si mi_posicion no es NULL se realizara lo siguiente
            Guardar_Palabra(tabla_hash, mi_posicion, ruta);
        break;
    default:
        printf("\n\tEsa opcion no existe");//se imprime a pantalla
        break;
    }
}
/*
void filtrar(lista* tabla_hash)
Descripcion: Se pide informacion para la busqueda y da opciones de lo que se desea hacer
Recibe: lista* tabla_hash
*/
void filtrar(lista* tabla_hash)
{
    int option;//se declara option
    char texto[100] = ""; char caracter;
    posicion mi_posicion = NULL;// se declara mi_posicion
    printf("\n\t1. Buscar por sub-cadena");//se imprime a pantalla
    printf("\n\t2. Buscar por Letra de inicio");//se imprime a pantalla
    printf("\n\t3. Buscar palabra \n-> ");//Imprime a pantalla
    scanf("%d", &option);//almacena la informacion
    switch(option)//Proporciona un menu de posibles casos
    {
    case 1:
        fflush(stdin);// elimna la basura
        printf("\n\tQue sub-cadena buscare? \n -> ");//se imprime a pantalla
        gets(texto);//se almacena la informacion
        Buscar_Sub_Cadena(tabla_hash, texto);//se llama a la funcion
        //Menu(tabla_hash);
        break;
    case 2:
        fflush(stdin);// se elimina la basura
        printf("\n\tQue letra_buscare? \n -> ");//se imprime a pantalla
        scanf("%c", &caracter);//se almacena la informacion
        Buscar_Letra(caracter, tabla_hash);//se llama a la funcion
        break;
    case 3:
        fflush(stdin);//se elimina la basura
        printf("\n\tQue palabra buscare? \n -> ");//se imprime a pantalla
        gets(texto);//se almacena la informacion
        mi_posicion= Buscar(tabla_hash, texto, 0);
        if(mi_posicion != NULL)// si se cumple que no es NULL , se imprimira lo siguiente
            printf("\n\tExiste la palabra %s su definicion es: %s", mi_posicion->e.p, mi_posicion->e.d);//se imprime a pantalla
        else//de lo contrario
            printf("\n\tLa palabra %s no esta en el diccionario", texto);//se imprime a pantalla
        break;
    default:
        printf("\n\tEsa opcion no existe");// imprime a pantalla
        break;
    }
    //Menu(tabla_hash);
}

/*
void Estadisticas(lista * tabla_hash)
Descripcion:este metodo permite mostrar las estadisticas del recorrido que se hizo para llegar a la palbra, definicion,
 etc que el usuario deseaba.
Recibe: lista * tabla_hash
*/
void Estadisticas(lista * tabla_hash)
{
    int i, j, tam = 0, Colisiones = 0;//se declaran i,j, tam que se inicializa en cero y colisiones que tambien se inicializa en cero
    for(i=0; i<1000; i++)// se termina el for, cuando se ya no se cumpla que i es menor que 1000
    {
        if(!Empty(&tabla_hash[i]))// si se cumple que no esta vacia, se realizara lo siguiente
        {
            tam++;//se incrementara tam
            Colisiones += Size(&tabla_hash[i]);
        }
    }
    printf("\n\tEl orden maximo de busquedas es O%c", 253);//se imprime a pantalla
    printf("\n\tEl tamano de nuestra tabla hash es de %d actualmente", tam);//se imprime a pantalla
    printf("\n\tLa tabla hash tiene un promedio de %f", (float)Colisiones/(float)tam);//se imprime a pantalla
}
