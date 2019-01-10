#include <stdio.h> //Librerias, se incluyen las funciones estandar de entrada y salida
#include <windows.h>//Libreria, de la cual usaremos la función Sleep

//Programa principal
int main(void){
//Declaración de variables, n es el número de veces que repetiremos
//el ciclo, primero y segundo guardan números, que serán sumados
//elemento es el número de veces que hemos repetido el ciclo, un contador
//siguiente variable donde almacenaremos la suma de primero más segundo
    int n, primero, segundo, elemento, siguiente;
    //Inicio del ciclo de repetición
    do{
        //Mandamos un mensaje al usuario
        printf("Ingresa un numero -> ");
        //Lectura y almacenamiento de datos en la variable n
        scanf("%d", &n);
        //Mientras n no sea mayor a 2 se seguirá repitiendo el ciclo
    }while(!(n>2));
    //Igualamos la variable primero a 0
    primero = 0;
    //Mostramos el valor que tiene l variable primero
    printf("%d ", primero);
    //Esperamos 0.5 segundos
    Sleep(500);
    //Segundo lo igualamos a 1
    segundo = 1;
    //Mostramos el valor de segundo
    printf("%d ", segundo);
    //Esperamos 0.5 segundos
    Sleep(500);
    //Variable elemento la igualamos a 3
    elemento = 3;
    //Inicio del ciclo de repetición
    do{
        //Variable siguiente almacenamos la sumatoria
        //entre variables primero y segundo
        siguiente = primero + segundo;
        //Mostramos el valor que tiene la variable siguiente
        printf("%d ", siguiente);
        //Esperamos 0.5 segundos
        Sleep(500);
        //La variable primero la igulamos con segundo
        primero = segundo;
        //La variable segundo la igualamos con siguiente
        segundo = siguiente;
        //Hacemos un conteo usando la variable elemento
        //sería lo mismo si tenemos elemento++
        elemento = elemento + 1;
        //Este ciclo se repite mientras elemento no sea mayor a la varible n
    }while(!(elemento>n));
    return 0;
}
