/*
AUTORES:
Nuñez García Tania Itzel
Quiro Díaz Verónica Jackeline
Vargas Romero Erick Efraín

DESCRIPCIÓN:Programar en ANSI C la implementación recursiva del término n de la serie de Fibonacci y Tribonacci.

EJECUCIÓN: seriefibonacci.c (Windows)
*/

//LIBRERIAS
#include <stdio.h>
//PROTOTIPOS
int fibonacci(int n);
//PROGRAMA PRINCIPAL
int main(){
    int numero,i;//Declaracion de numero y i

    printf("Introduzca el numero de elementos:");// Imprime a pantalla
    scanf("%d",&numero);//Almacena la informacion introducida


    for(i=1;i<=numero;i++)//El for termina hasta que numero no sea mayor o igual al introducido
    {
        printf("%d \t", fibonacci(i));// Imprime a pantalla el resultado de la funcion fibonacci

    }

    return 0;
}
/*
si fibonacci(1)= 1, entonces: fibonacci(n)=fibonacci(n-1)+fibonacci(n-2)

int fibonacci(int n)
Descripcion:Realiza la operacion del numero introducido
Recibe:un int n
Devuelve: el resultado de la operacion: fibonacci(n-1)+ fibonacci(n-2)
*/
int fibonacci(int n)
{
    if(n==0)//Si se cumple que n es igual a cero ó n es igual a 1
    {
        return n;//regresara el numero : n
    }
    if(n==1|| n==2)
    {
        return 1;
    }
    if(n>=3)
    //por el contrario
    {
        return(fibonacci(n-1)+ fibonacci(n-2)+fibonacci(n-3));// regresara el resultado de esta suma
    }

}

