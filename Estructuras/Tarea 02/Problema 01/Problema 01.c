#include <stdio.h>

int main(){

    int suma_par = 0, suma_impares = 0, numero_pares = 0, numero_datos = 1, dato;
    float promedio_pares = 0.0;

    while(numero_datos<=10){
        scanf("%d", &dato);
        numero_datos++;

        if(dato % 2 == 0){
            suma_par += dato;
            numero_pares++;
        } else {
            suma_impares += dato;
        }
    }
    promedio_pares=(float)suma_par/(float)numero_pares;
    printf("Promedio pares: %f \nSuma impares: %d",promedio_pares,suma_impares);
    return 0;
}
