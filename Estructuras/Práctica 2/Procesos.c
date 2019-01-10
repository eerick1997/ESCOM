/*
Autores:
Núñez García Tania Itzel
Quiros Díaz Verónica Jackeline
Vargas Romero Erick Efraín

Versión 1.0 (12 Octubre 2016)
Descripción: Cabecera de la libreria para recrear presentaciones más agradables al usuario en el modo consola bajo Windows
Observaciones: Esta implementación de la libreria solo es compatible con Windows y el compilador MinGW ya que utiliza la libreria "windows.h", la cuál no es estandar.
Compilación de la libreria: Windows (gcc -c presentacionWin.c)
*/
//LIBRERIAS
#include<stdio.h>
#include<windows.h>
#include "presentacionWin.c"
#include "presentacion.h"

//CONSTANTES
#define ALTO 25
#define ANCHO 75
#define ALTO_2 45
#define ALTO_3 65
#define ALTO_4 85

//funcion que dibuja cada cuadro
void cuadros ()
{
    int fila,columna;
    //Borrar la pantalla
    //BorrarPantalla();

    //Dibuja en las columnas --finalizado
    for (columna = 5; columna<ANCHO; columna++)
    {
        MoverCursor(columna, 5); //mueve el cursor en el eje x (parte superior)
        printf("%c", 205);//imprime en el eje x
        MoverCursor(columna, ALTO); //mueve el cursor en el eje x
        printf("%c", 205);// imprimime en el eje x

    }

    //Dibuja en las filas ---finalizado
    for (fila = 5; fila<ALTO; fila++)
    {
        MoverCursor(5, fila);//mueve el cursor en el eje y (parte izquierda)
        printf("%c", 186);//imprime en el eje y (parte izquierda)
        MoverCursor(ANCHO, fila);//mueve el cursor en el eje y(parte derecha)
        printf("%c", 186);//imprime en el eje y (parte derecha )

    }
//-------------------------------------------------

    //Dibuja en las columnas --ejecucion
    for (columna = 5; columna<ANCHO; columna++)
    {
        MoverCursor(columna, 27);//mueve el cursor en el eje x (parte superior)
        printf("%c", 205);//imprime en el eje x
        MoverCursor(columna, ALTO_2);//mueve el cursor en el eje x
        printf("%c", 205);// imprimime en el eje x
    }

    //Dibuja en las filas ---ejecucion
    for (fila = 27; fila<ALTO_2; fila++)
    {
        MoverCursor(5, fila);//mueve el cursor en el eje y (parte izquierda)
        printf("%c", 186);//imprime en el eje y (parte derecha )
        MoverCursor(ANCHO, fila);//mueve el cursor en el eje y(parte derecha)
        printf("%c", 186);//imprime en el eje y (parte derecha )
    }
//--------------------------------
//Dibuja en las columnas --espera
    for (columna = 5; columna<ANCHO; columna++)
    {
        MoverCursor(columna, 47);//mueve el cursor en el eje x (parte superior)
        printf("%c", 205);//imprime en el eje x
        MoverCursor(columna, ALTO_3);//mueve el cursor en el eje x
        printf("%c", 205);// imprimime en el eje x
    }

    //Dibuja en las filas ---espera
    for (fila = 47; fila<ALTO_3; fila++)
    {
        MoverCursor(5, fila);//mueve el cursor en el eje y (parte izquierda)
        printf("%c", 186);//imprime en el eje y (parte derecha )
        MoverCursor(ANCHO, fila);//mueve el cursor en el eje y(parte derecha)
        printf("%c", 186);//imprime en el eje y (parte derecha )
    }
//-------------------------------------------
//Dibuja en las columnas --u.espera
    for (columna = 5; columna<ANCHO; columna++)
    {
        MoverCursor(columna, 67);//mueve el cursor en el eje x (parte superior)
        printf("%c", 205);//imprime en el eje x
        MoverCursor(columna, ALTO_4);//mueve el cursor en el eje x
        printf("%c", 205);// imprimime en el eje x
    }
    //Dibuja en las filas ---u.espera
    for (fila = 67; fila<ALTO_4; fila++)
    {
        MoverCursor(5, fila);//mueve el cursor en el eje y (parte izquierda)
        printf("%c", 186);//imprime en el eje y (parte derecha )
        MoverCursor(ANCHO, fila);//mueve el cursor en el eje y(parte derecha)
        printf("%c", 186);//imprime en el eje y (parte derecha )
    }
}

//funcion Texto -Cuadro2
void Ejecucion(char* nombre, char* actividad, char* ID, int tiempo)
{
    MoverCursor(7,28);//asigna en la posicion (x,y)
    printf("PROCESO EN EJECUCION");
    MoverCursor(7,31);//asigna en la posicion (x,y)
    printf("NOMBRE DEL PROCESO:");
    MoverCursor(7,32);//asigna en la posicion (x,y)
    printf("%s",nombre);
    MoverCursor(7,34);//asigna en la posicion (x,y)
    printf("ACTIVIDAD:");
    MoverCursor(7,35);//asigna en la posicion (x,y)
    printf("%s",actividad);
    MoverCursor(7,37);//asigna en la posicion (x,y)
    printf("ID:");
    MoverCursor(7,38);//asigna en la posicion (x,y)
    printf("%s",ID);
    MoverCursor(7,40);//asigna en la posicion (x,y)
    printf("TIEMPO PARA CONCLUIR :");
    MoverCursor(7,41);//asigna en la posicion (x,y)
    printf("%d",tiempo);
    return;
}

//funcion Texto-cuadro3
void Espera(char* nombre,char * actividad, char* ID, int Tiempo)
{
    MoverCursor(7,48);//asigna en la posicion (x,y)
    printf("PROCESO EN ESPERA");
    MoverCursor(7,51);//asigna en la posicion (x,y)
    printf("NOMBRE DEL PROCESO:");
    MoverCursor(7,52);//asigna en la posicion (x,y)
    printf("                                       ");
    MoverCursor(8,54);//asigna en la posicion (x,y)
    printf("ACTIVIDAD:");
    MoverCursor(7,55);//asigna en la posicion (x,y)
    printf("                                       ");
    MoverCursor(7,57);//asigna en la posicion (x,y)
    printf("ID:");
    MoverCursor(7,58);//asigna en la posicion (x,y)
    printf("                                       ");
    MoverCursor(7,60);//asigna en la posicion (x,y)
    printf("TIEMPO PARA CONCLUIR :");
    MoverCursor(7,61);//asigna en la posicion (x,y)
    printf("                                       ");

    MoverCursor(7,48);//asigna en la posicion (x,y)
    printf("PROCESO EN ESPERA");
    MoverCursor(7,51);//asigna en la posicion (x,y)
    printf("NOMBRE DEL PROCESO:");
    MoverCursor(7,52);//asigna en la posicion (x,y)
    printf("%s",nombre);
    MoverCursor(8,54);//asigna en la posicion (x,y)
    printf("ACTIVIDAD:");
    MoverCursor(7,55);//asigna en la posicion (x,y)
    printf("%s",actividad);
    MoverCursor(7,57);//asigna en la posicion (x,y)
    printf("ID:");
    MoverCursor(7,58);//asigna en la posicion (x,y)
    printf("%s",ID);
    MoverCursor(7,60);//asigna en la posicion (x,y)
    printf("TIEMPO PARA CONCLUIR :");
    MoverCursor(7,61);//asigna en la posicion (x,y)
    printf("%d",Tiempo);
    return;
}
//funcion Texto-cuadro4
void Espera_ult(char* Nombre,char* Actividad,char* ID, int Tiempo)
{
    char nomb,act;//declaracion de char
    int id,tiemp;//declaracion de int

    MoverCursor(7,68);//asigna en la posicion (x,y)
    printf("ULTIMO PROCESO EN ESPERA");
    MoverCursor(7,71);//asigna en la posicion (x,y)
    printf("NOMBRE DEL PROCESO:");
    MoverCursor(7,72);//asigna en la posicion (x,y)
    printf("                                       ");
    MoverCursor(7,74);//asigna en la posicion (x,y)
    printf("ACTIVIDAD:");
    MoverCursor(7,75);//asigna en la posicion (x,y)
    printf("                                       ");
    MoverCursor(7,77);//asigna en la posicion (x,y)
    printf("ID:");
    MoverCursor(7,78);//asigna en la posicion (x,y)
    printf("                                       ");
    MoverCursor(7,80);//asigna en la posicion (x,y)
    printf("TIEMPO PARA CONCLUIR:");
    MoverCursor(7,81);//asigna en la posicion (x,y)
    printf("                                       ");

    MoverCursor(7,68);//asigna en la posicion (x,y)
    printf("ULTIMO PROCESO EN ESPERA");
    MoverCursor(7,71);//asigna en la posicion (x,y)
    printf("NOMBRE DEL PROCESO:");
    MoverCursor(7,72);//asigna en la posicion (x,y)
    printf("%s",Nombre);
    MoverCursor(7,74);//asigna en la posicion (x,y)
    printf("ACTIVIDAD:");
    MoverCursor(7,75);//asigna en la posicion (x,y)
    printf("%s",Actividad);
    MoverCursor(7,77);//asigna en la posicion (x,y)
    printf("ID:");
    MoverCursor(7,78);//asigna en la posicion (x,y)
    printf("%s",ID);
    MoverCursor(7,80);//asigna en la posicion (x,y)
    printf("TIEMPO PARA CONCLUIR:");
    MoverCursor(7,81);//asigna en la posicion (x,y)
    printf("%d",Tiempo);
    return;
}


