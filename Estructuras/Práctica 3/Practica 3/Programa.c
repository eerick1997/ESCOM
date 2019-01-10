 #include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include "..\Libraries\TablaHash\TablaHash.c"
#define lunfardo "Lunfardo.txt"

void Menu(lista* tabla_hash);
void filtrar(lista* tabla_hash);

void main(void)
{
    int i;
    lista tabla_hash[1000];
    for(i=0; i<1000; i++)
        Initialize(&tabla_hash[i]);

    Leer_Archivos(lunfardo, &tabla_hash);
    system("CLS");
    //Estadisticas(&tabla_hash);
    Menu(&tabla_hash);
}

void Menu (lista* tabla_hash)
{
    char ruta[250] = "";
    elemento mi_elemento;
    strcpy(mi_elemento.p, "");
    strcpy(mi_elemento.d, "");

    printf("\n\t\t\t\t DICCIONARIO HASH B|\n\n\n");

    int x = 0;
    printf("\t1. Cargar un archivo de definiciones \n\n");
    printf("\t2. Agregar una palabra y su definicion \n\n");
    printf("\t3. Modificar una definicion \n\n");
    printf("\t4. Eliminar una palabra \n\n");
    printf("\t5. Filtrar \n\n");
    printf("\t6. Guardar \n\n");
    printf("\t7. Estadisticas \n\n");
    printf("\t8. Salir del programa \n\n\t-> ");
    scanf("%d", &x);

    switch (x)
    {
    case 1: //printf("Lala 1 \n\n");
        fflush(stdin);
        printf("\nCargare un archivo de definiciones escribe el nombre del archivo \n->");
        gets(ruta);
        strcat(ruta, ".txt");
        Leer_Archivos(ruta, tabla_hash);
        printf("\n\n");
        system("PAUSE");
        system("CLS");
        Menu(tabla_hash);
        break;

    case 2: //printf("Lalala 2 \n\n");
        fflush(stdin);
        printf("\nIngresa la palabra \n-> ");
        gets(mi_elemento.p);
        fflush(stdin);
        printf("\nIngresa la definicion \n-> ");
        gets(mi_elemento.d);
        Anadir_Palabra(tabla_hash, mi_elemento, 0);
        printf("\n\n");
        system("PAUSE");
        system("CLS");
        Menu(tabla_hash);
        break;

    case 3: //printf("Lalala 3 \n\n");
        fflush(stdin);
        printf("\nIngresa la palabra \n-> ");
        gets(mi_elemento.p);
        Modificar_Definicion(tabla_hash, mi_elemento.p);
        printf("\n\n");
        system("PAUSE");
        system("CLS");
        Menu(tabla_hash);
        break;

    case 4: //printf("Lalala 4 \n\n");
        fflush(stdin);
        printf("\nQue palabra sera eliminada? \n -> ");
        gets(mi_elemento.p);
        Eliminar_Palabra(tabla_hash, mi_elemento.p);
        printf("\n\n");
        system("PAUSE");
        system("CLS");
        Menu(tabla_hash);
        break;
    case 5:
        printf("\n\tFiltrar diccionario");
        filtrar(tabla_hash);
        printf("\n\n");
        system("PAUSE");
        system("CLS");
        Menu(tabla_hash);
        break;
    case 6:
        fflush(stdin);
        printf("\n\tComo se llamara el archivo? \n -> ");
        gets(ruta);
        guardar(tabla_hash, ruta);

        printf("\n\n");
        system("PAUSE");
        system("CLS");
        Menu(tabla_hash);
    case 7:
        Estadisticas(tabla_hash);
        printf("\n\n");
        system("PAUSE");
        system("CLS");
        Menu(tabla_hash);
        break;
    case 8:
        exit (0);
        break;

    default:
        printf("\n\tEsta opcion no existe");
        break;
    }
}

void guardar(lista* tabla_hash, char* ruta)
{
    int x;
    posicion mi_posicion;
    char texto[100] = "";
    printf("\n\tElige una opcion");
    printf("\n\t1.Exportar todo el diccionario");
    printf("\n\t2.Exportar una palabra \n\t -> ");
    scanf("%d", &x);
    switch(x)
    {
    case 1:
        Guardar_Diccionario(ruta, tabla_hash);
        break;
    case 2:
        fflush(stdin);
        printf("\n\tQue palabra sera exportada? \n\t ->");
        gets(texto);
        mi_posicion = Buscar(tabla_hash, texto, 0);
        if(mi_posicion != NULL)
            Guardar_Palabra(tabla_hash, mi_posicion, ruta);
        break;
    default:
        printf("\n\tEsa opcion no existe");
        break;
    }
}

void filtrar(lista* tabla_hash)
{
    int option;
    char texto[100] = ""; char caracter;
    posicion mi_posicion = NULL;
    printf("\n\t1. Buscar por sub-cadena");
    printf("\n\t2. Buscar por Letra de inicio");
    printf("\n\t3. Buscar palabra \n-> ");
    scanf("%d", &option);
    switch(option)
    {
    case 1:
        fflush(stdin);
        printf("\n\tQue sub-cadena buscare? \n -> ");
        gets(texto);
        Buscar_Sub_Cadena(tabla_hash, texto);
        //Menu(tabla_hash);
        break;
    case 2:
        fflush(stdin);
        printf("\n\tQue letra_buscare? \n -> ");
        scanf("%c", &caracter);
        Buscar_Letra(caracter, tabla_hash);
        break;
    case 3:
        fflush(stdin);
        printf("\n\tQue palabra buscare? \n -> ");
        gets(texto);
        mi_posicion= Buscar(tabla_hash, texto, 0);
        if(mi_posicion != NULL)
            printf("\n\tExiste la palabra %s su definicion es: %s", mi_posicion->e.p, mi_posicion->e.d);
        else
            printf("\n\tLa palabra %s no esta en el diccionario", texto);
        break;
    default:
        printf("\n\tEsa opcion no existe");
        break;
    }
    //Menu(tabla_hash);
}

void Estadisticas(lista * tabla_hash)
{
    int i, j, tam = 0, Colisiones = 0;
    for(i=0; i<1000; i++)
    {
        if(!Empty(&tabla_hash[i]))
        {
            tam++;
            Colisiones += Size(&tabla_hash[i]);
        }
    }
    printf("\n\tEl orden maximo de busquedas es O%c", 253);
    printf("\n\tEl tamano de nuestra tabla hash es de %d actualmente", tam);
    printf("\n\tLa tabla hash tiene un promedio de %f", (float)Colisiones/(float)tam);
}
