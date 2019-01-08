#include <iostream>

using namespace std;

int main(){
        
    int asignacion = 0, aritmeticas = 0, condicionales = 0, saltos = 0;
    
    int temp = 0;
    int n = 10;
    
    asignacion++;
    for(int i = 0; i < n; i++, aritmeticas++){
        
        condicionales++;
        saltos++;
        
        asignacion++;
        for(int j = 0; j < n - 1; j++, aritmeticas++){
            
            condicionales++;
            saltos++;
                
            int A[j+1];
            
            temp = A[j];
            asignacion++;
            
            A[j] = A[j+1];
            aritmeticas++;
            asignacion++;
            
            A[j+1] = temp;
            aritmeticas++;
            asignacion++;
        }
        saltos++;
        condicionales++;
        
    }
    condicionales++;
    saltos++;
    
    cout<<(asignacion + aritmeticas + condicionales + saltos)<<endl;
    
}
