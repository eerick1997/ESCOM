#include <stdio.h>

int main(){
    
    int c = 0;
    
    int i = 0, j =0;
    int temp = 0;
    
    int a[] = {10, 7, 2, 0, 3, 1, 8, 20, 4, 100};
    
    int n = 10;
    
    for(i = 0; i < n-1; i++){
        
        for(j = i + 1; j < n; j++){
             
            c++;
            if(a[j] < a[i]){
                temp = a[i];
                c++;
                a[i] = a[j];
                c++;
                a[j] = temp;
                c++;
            }
            
        }
        
    }
    printf("%d",c);
    return 0;
}
