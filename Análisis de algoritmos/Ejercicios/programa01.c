#include <stdio.h>

int main(){
    
    int n = 3, n_h = 1, i = 0;
    for(i = 0; i > 1; i--)
        for(i = 0; i < n; i++)
            printf("Hola", n_h++);
        printf("%d", n_h);

    return 0;
}
