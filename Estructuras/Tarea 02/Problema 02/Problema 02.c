#include <stdio.h> //Librerias, se incluyen las funciones estandar de entrada y salida

//Programa principal
int main(void){
    /*Declaración de dos variables una donde se almacena el sueldo neto y otra el sueldo base
    el suedo neto es el sueldo menos el ISR*/
    float sueldo_base, sueldo_neto;

    //Inicio del ciclo de repetición
    do{
        //Enviamos un mensaje al usuario
        printf("Ingresa el sueldo base -> ");
        /*Lectura del dato que ingresará el usuario, y es almacenado
         en la variable sueldo base*/
        scanf("%f", &sueldo_base);
    //Fin del ciclo de repetición mientras el sueldo base no sea mayor-igual a cero
    }while(!(sueldo_base>=0));

    //Evaluamos si el valor del sueldo_base esta entre 0 y 1000
    if( 0 <= sueldo_base <= 1000){
        // Si se cumple la condición entonces
        //Usamos la variable sueldo_neto y la igualamos al
        //sueldo_base menos el producto del sueldo_base por 0.05
        //que es el equivalente al 5%
        sueldo_neto = sueldo_base-(sueldo_base*0.05);
    } else {
        if( 1001 <= sueldo_base <= 5000){
        //Si la condición se cumple entonces
        //Usamos la variable sueldo_neto y la igualamos al
        //sueldo_base menos el producto del sueldo_base por 0.15
        //que es el equivalente al 15%
        sueldo_neto = sueldo_base-(sueldo_base*0.15);
    //En el caso que nungúna condición se cumpla
    } else {
        //Usamos la variable sueldo_neto y la igualamos al
        //sueldo_base menos el producto del sueldo_base por 0.30
        //que es el equivalente al 30%
        sueldo_neto = sueldo_base-(sueldo_base*0.30);
    }
    }
    //Si la condición anterior no se ha cumplido entonces evaluamos
    //la variable sueldo_base si está entre 1001 y 5000
    /*if( 1001 <= sueldo_base <= 5000){
        //Si la condición se cumple entonces
        //Usamos la variable sueldo_neto y la igualamos al
        //sueldo_base menos el producto del sueldo_base por 0.15
        //que es el equivalente al 15%
        sueldo_neto = sueldo_base-(sueldo_base*0.15);
    //En el caso que nungúna condición se cumpla
    } else {
        //Usamos la variable sueldo_neto y la igualamos al
        //sueldo_base menos el producto del sueldo_base por 0.30
        //que es el equivalente al 30%
        sueldo_neto = sueldo_base-(sueldo_base*0.30);
    }*/
    //Mandamos un mensaje a la pantalla con el valor del sueldo neto
    printf("El sueldo neto es -> %f", sueldo_neto);
    return 0;
}
