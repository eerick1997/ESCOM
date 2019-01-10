#include <stdio.h>
#include "TADPila\TADPila.c"

int main(void){

    int i;
    pila mi_pila;
    elemento mi_elemento;
    Initialize(& mi_pila);
    if(Empty(&mi_pila))
        printf("\nPila vacia");
    for(i=0; i<5; i++){
        printf("\nIngresa un numero");
        scanf("%d", &mi_elemento.numero);
        Push(&mi_pila, mi_elemento);
    }

    if(!Empty(&mi_pila))
        printf("\nPila con elementos");

    printf("\nTamano de la pila es %d", Value_Top(&mi_pila));
    printf("\nElemento tope es: %d", Top(&mi_pila).numero);
    printf("\nSacando el elemento tope %d", Pop(&mi_pila).numero);
    printf("\nTamano nuevo %d", Value_Top(&mi_pila));
    printf("\nElemento tope es: %d", Top(&mi_pila).numero);

    Destroy(&mi_pila);

    return 0;
}
