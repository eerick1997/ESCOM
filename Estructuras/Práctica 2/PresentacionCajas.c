/*
Autor: Edgardo Adrián Franco Martínez
Versión 1.1 (02 de Octubre de 2013)
Descripción: Cabecera de la libreria para recrear presentaciones más agradables al usuario en el modo consola bajo Windows
Observaciones: Esta implementación de la libreria solo es compatible con Windows y el compilador MinGW ya que utiliza la libreria "windows.h", la cuál no es estandar.
Compilación de la libreria: Windows (gcc -c presentacionWin.c)
*/

//LIBRERIAS
#include<stdio.h>
#include<windows.h>
#include "presentacionWin.c"
#include "presentacion.h"

//DEFINICIONES DE CONSTANTES
#define ALTO 15			//Se define un alto de 7 caracteres
#define ANCHO 18.5         //Se define un ancho de 7 caracteres
#define MULTIPLICADOR 21  //Se define un multiplicador de 8
#define MULT 2

typedef struct para_texto
{
    ///Para supermercado
    int en_espera;
    int atendiendo;
    int atendidos;
    int ultima;
    int tam_cola;
    ///Para banco
} para_texto;

void Cajas()
{
    int i;
    for (i=0; i<9; i++)
    {
        int fila,columna;
        //Borrar la pantalla
        //BorrarPantalla();

        //Dibuja en las columnas
        for (columna = 1; columna<ANCHO; columna++)
        {
            MoverCursor(2+columna+(i*MULTIPLICADOR), 5);
            printf("%c", 205);
            MoverCursor(2+columna+(i*MULTIPLICADOR), ALTO+5);
            printf("%c", 205);
            //EsperarMiliSeg(TIEMPO_BASE);
        }
        //Dibuja en las filas
        for (fila = 1; fila<ALTO; fila++)
        {
            MoverCursor(2+(i*MULTIPLICADOR), fila+5);
            printf("%c", 186);
            MoverCursor(2+ANCHO+(i*MULTIPLICADOR), fila+5);
            printf("%c", 186);
            //EsperarMiliSeg(TIEMPO_BASE);
        }

        //Dibuja en las esquinas de la caja
        MoverCursor(2+(i*MULTIPLICADOR), 5);
        printf("%c", 02);
        MoverCursor(2+ANCHO+(i*MULTIPLICADOR), 5);
        printf("%c", 02);
        MoverCursor(2+(i*MULTIPLICADOR), ALTO+5);
        printf("%c", 01);
        MoverCursor(2+ANCHO+(i*MULTIPLICADOR), ALTO+5);
        printf("%c", 01);
    }
}

//Dibuja la información dada por el programa
void Texto1(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3,9);
    printf("Atendiendo:      ");
    MoverCursor(3,9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3,11);
    printf("Siguiente:      ");
    MoverCursor(3,11);
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3,13);
    printf("Atendidos:      ");
    MoverCursor(3,13);
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3,15);
    printf("Ultimo:      ");
    MoverCursor(3,15);
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3,17);
    printf("Tamano fila:      ");
    MoverCursor(3,17);
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto2(para_texto texto)
{
    //Dibuja la información dada por el programa

    MoverCursor(3+(1*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(1*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:        ");

    MoverCursor(3+(1*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(1*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(1*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(1*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(1*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(1*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(1*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(1*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto3(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3+(2*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(2*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:      ");

    MoverCursor(3+(2*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(2*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(2*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(2*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(2*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(2*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(2*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(2*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto4(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3+(3*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(3*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:      ");

    MoverCursor(3+(3*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(3*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(3*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(3*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(3*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(3*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(3*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(3*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto5(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3+(4*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(4*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:      ");

    MoverCursor(3+(4*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(4*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(4*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(4*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(4*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(4*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(4*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(4*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto6(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3+(5*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(5*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:      ");

    MoverCursor(3+(5*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(5*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(5*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(5*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(5*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(5*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(5*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(5*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto7(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3+(6*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(6*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:      ");

    MoverCursor(3+(6*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(6*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(6*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(6*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(6*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(6*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(6*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(6*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto8(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3+(7*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(7*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:      ");

    MoverCursor(3+(7*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(7*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(7*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(7*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(7*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(7*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(7*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(7*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Texto9(para_texto texto)
{
    //Dibuja la información dada por el programa
    MoverCursor(3+(8*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(8*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente:      ");

    MoverCursor(3+(8*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos:      ");

    MoverCursor(3+(8*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo:      ");

    MoverCursor(3+(8*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila:      ");

    MoverCursor(3+(8*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.atendiendo);

    MoverCursor(3+(8*MULTIPLICADOR),9+(1*MULT));
    printf("Siguiente: %d", texto.en_espera);

    MoverCursor(3+(8*MULTIPLICADOR),9+(2*MULT));
    printf("Atendidos: %d", texto.atendidos);

    MoverCursor(3+(8*MULTIPLICADOR),9+(3*MULT));
    printf("Ultimo: %d", texto.ultima);

    MoverCursor(3+(8*MULTIPLICADOR),9+(4*MULT));
    printf("Tamano fila: %d", texto.tam_cola);
}

void Marco()
{
    int x, y;
    //BorrarPantalla();
    for (x = 0; x <= 189 ; x++)
    {
        MoverCursor(x, 0);
        printf("%c", 205);
        MoverCursor(x, 22);
        printf("%c", 205);
        for (y = 0; y <= 22; y++)
        {
            MoverCursor(0, y);
            printf("%c", 186);
            MoverCursor(189, y);
            printf("%c", 186);
        }
    }
}
void Titulo()
{
    MoverCursor(89, 3);
    printf("BANCO ESCOM B|");
}
