/*
AUTORES:
Nuñez García Tania Itzel
Quiro Díaz Verónica Jackeline
Vargas Romero Erick Efraín

DESCRIPCIÓN:Programar en ANSI C la implementación recursiva del término n de la serie de Fibonacci y Tribonacci,
así como la implementación recursiva de las Torres de Hanoi para n discos.

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
int fibonacci(int n){
    if(n<=1)//si n es menor o igual a 1 regresara 0
    {
        return 0;
    }
    if(n==2||n==3)//si n es igual a 2 o 3, regresara 1
    {
        return 1;
    }
    if(n>=4)//si n es mayor o igual a 4, se realizara la siguiente suma
    {
        return(fibonacci(n-1)+fibonacci(n-2));
    }

}
