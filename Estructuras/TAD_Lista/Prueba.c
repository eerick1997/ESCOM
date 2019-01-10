#include <stdio.h>
#include "131016\TADLista.c"

int main(void){
    lista list;
    int i;
    elemento element;
    Initialize(&list);
    for(i=0; i<5; i++){
        printf("\n#%d Dame un numero -> ", i+1);
        scanf("%d", &element.numero);
        Add(&list, element);
    }
    printf("\nTamano %d ", Size(&list));
    printf("\nUltimo %d", Final(&list)->e.numero);
    printf("\nFrente %d", First(&list)->e.numero);

    printf("\nFollowing de First %d", Following(&list, First(&list))->e.numero);
    //printf("\nPrevius de First %d", Previus(&list, First(&list))->e.numero);

    /**printf("\nRemover elemento: ");

    Remove(&list, Final(&list));

    printf("\n\tFinal tiene %d",Final(&list));**/
}
