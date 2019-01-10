#include <stdio.h> //Librerias, se incluyen las funciones estandar de entrada y salida

//Programa principal
int main(void){
    //Declaración de variables, la primera
    //para almacenar el número que ingresará el usuario
    //la segunda almacena el valor de la primer variable
    //pero multiplicada por si misma 3 veces
    float numero = 0, cubo;

    //Inicio del ciclo de repetición
    do{
        //Mostramos un mensaje5

        printf("\nIngresa un numero -> ");
        //Hacemos la lectura y almacenamiento del
        //numero del usuario en la variable numero
        scanf("%f", &numero);
        //Almacenamos en la variable cubo el valor
        //que tiene la variable número, y
        //la multiplicamos por si misma tres veces
        cubo = numero*numero*numero;
        //Mostramos el valor de la variable cubo
        printf("\n%f", cubo);
        //Evaluamos el ciclo mientras el número ingresado
        //no sea mayor a cero
    }while(!(numero<0));
    return 0;
}
