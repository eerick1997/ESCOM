/*
Autor: Edgardo Adrián Franco Martínez
Versión 1.1 (02 de Octubre de 2013)
Descripción: Cabecera de la libreria para recrear presentaciones más agradables al usuario en el modo consola bajo Windows
Observaciones: Esta implementación de la libreria solo es compatible con Windows y el compilador MinGW ya que utiliza la libreria "windows.h", la cuál no es estandar.
Compilación de la libreria: Windows (gcc -c presentacionWin.c)
*/

//LIBRERIAS
#include<stdio.h>
#include<string.h>
#include<windows.h>
#include "presentacionWin.c"
#include "presentacion.h"

//DEFINICIONES DE CONSTANTES
#define ALTO 15			//Se define un alto de 7 caracteres
#define ANCHO 18.5         //Se define un ancho de 7 caracteres
#define MULTIPLICADOR 21  //Se define un multiplicador de 8
#define MULT 2
#define ALTO_COLAS 20
#define MULT_COLAS 30

#define cliente_pobre 0
#define cliente_banco 1
#define cliente_preferente 2

typedef struct para_texto
{
    ///Para cajas
    int ID;
    int atendiendo;

    ///Para las colas
    int en_espera;
    int siguiente;
    int ultimo;

} para_texto;

void atiende(int no_cliente);

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
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3,9);
    printf("Atendiendo:      ");
    MoverCursor(3,9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3,10);
    atiende(texto.atendiendo);
}

void Texto2(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3+(1*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(1*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(1*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
}

void Texto3(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3+(2*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(2*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(2*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
}

void Texto4(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3+(3*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(3*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(3*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
}

void Texto5(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3+(4*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(4*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(4*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
}

void Texto6(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa

    MoverCursor(3+(5*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(5*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(5*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
}

void Texto7(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3+(6*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(6*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(6*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
}

void Texto8(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3+(7*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(7*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(7*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
}

void Texto9(para_texto texto)
{
    char clientes_texto[3][10]= {"usuario","cliente","preferente"};
    //Dibuja la información dada por el programa
    MoverCursor(3+(8*MULTIPLICADOR),9);
    printf("Atendiendo:      ");

    MoverCursor(3+(8*MULTIPLICADOR),9);
    printf("Atendiendo: %d", texto.ID);
    MoverCursor(3+(8*MULTIPLICADOR),10);
    atiende(texto.atendiendo);
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

void DibujaColas()
{
    MoverCursor(56, 23);
    printf("Preferentes");
    MoverCursor(57+(1*MULT_COLAS), 23);
    printf("Clientes");
    MoverCursor(57+(2*MULT_COLAS), 23);
    printf("Usuarios");
    int j;
    for (j=1; j<=3; j++)
    {
        int fila;
        for (fila = 1; fila<ALTO_COLAS; fila++)
        {
            MoverCursor(30+(j*MULT_COLAS), fila+24);
            printf("%c", 254);
            MoverCursor(31+(j*MULT_COLAS), fila+24);
            printf("%c", 254);
            //EsperarMiliSeg(TIEMPO_BASE);
        }
    }
}

//Cola pobres
void TextoCola1(para_texto texto)
{
    MoverCursor(65, 27);
    printf("En espera: %d     ", texto.en_espera);
    MoverCursor(65, 28);
    printf("Primero: %d      ", texto.siguiente);
    MoverCursor(65, 29);
    printf("Ultimo: %d      ", texto.ultimo);
}

//Cola clientes
void TextoCola2(para_texto texto)
{
    MoverCursor(65+(1*MULT_COLAS), 27);
    printf("En espera: %d     ", texto.en_espera);
    MoverCursor(65+(1*MULT_COLAS), 28);
    printf("Primero: %d      ", texto.siguiente);
    MoverCursor(65+(1*MULT_COLAS), 29);
    printf("Ultimo: %d      ", texto.ultimo);
}

//Cola preferentes
void TextoCola3(para_texto texto)
{
    MoverCursor(65+(2*MULT_COLAS), 27);
    printf("En espera: %d     ", texto.en_espera);
    MoverCursor(65+(2*MULT_COLAS), 28);
    printf("Primero: %d      ", texto.siguiente);
    MoverCursor(65+(2*MULT_COLAS), 29);
    printf("Ultimo: %d      ", texto.ultimo);
}

void atiende(int no_cliente){
    if(no_cliente == cliente_preferente){
        printf("Preferente     ");
    }
    else if(no_cliente == cliente_banco){
        printf("Cliente        ");
    }
    else if(no_cliente == cliente_pobre){
        printf("Usuario        ");
    }
    else if(no_cliente != cliente_preferente && no_cliente != cliente_banco && no_cliente != cliente_pobre){
        printf("Desocupada");
    }
}
