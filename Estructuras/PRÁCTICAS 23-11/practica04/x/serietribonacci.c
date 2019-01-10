/*
AUTORES:
Nuñez García Tania Itzel
Quiro Díaz Verónica Jackeline
Vargas Romero Erick Efraín

DESCRIPCIÓN:Programar en ANSI C la implementación recursiva del término n de la serie de Fibonacci y Tribonacci.

EJECUCIÓN: serietribonacci.c (Windows)
*/

//LIBRERIAS
#include <stdio.h>
//PROTOTIPOS
long int triboonacci(long int n);
//PROGRAMA PRINCIPAL
int main(){
    long int numero,i;//Declaracion de numero y i
    printf("\n \t\t SERIE TRIBONACCI \n\n");
    printf("\t Introduzca el numero de elementos:");// Imprime a pantalla
    scanf("%d",&numero);//Almacena la informacion introducida
    printf("\n");

    for(i=0;i<=numero;i++)//El for termina hasta que numero no sea mayor o igual al introducido
    {
        printf("%d \n\t", triboonacci(i));// Imprime a pantalla el resultado de la funcion fibonacci

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
long int triboonacci(long int n)
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
        return(triboonacci(n-1)+ triboonacci(n-2)+triboonacci(n-3));// regresara el resultado de esta suma
    }

}

