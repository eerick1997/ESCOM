#include<stdio.h>

#include"TADCola\TADCola.c"

int main(void)
{

    int i;
    cola c;
    elemento mi_elemento;

    Initialize(&c);

    if(Empty(&c))
        printf("\nEsta vacia");
    for(i=0; i<5; i++)
    {
        printf("\nIngresa un numero ->");
        scanf("%d", &mi_elemento.numero);
        Queue(&c, mi_elemento);
    }
    if(!Empty(&c))
        printf("\nHay algo en la cola");

    printf("\nTamano de la cola es %d", Size(&c));
    printf("\n Desencole un elemento %d", Dequeue(&c).numero);
    printf("\nNuevo tamano de la cola es %d", Size(&c));
    printf("\nFrente tiene %d", Front(&c).numero);
    printf("\nFinal tiene %d", Final_Element(&c).numero);
    printf("\nDestruir...");
    Destroy(&c);
    return 0;
}
