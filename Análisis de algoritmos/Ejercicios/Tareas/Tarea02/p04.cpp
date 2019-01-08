#include <iostream>

using namespace std;

int main(){
    
    int asignacion = 0, aritmeticas = 0, condicionales = 0, saltos = 0;
    
    int n = 10;
    
    int anterior = 1;
    aritmeticas++;
    int actual = 1, aux = 0;
    aritmeticas++;
    
    while(n > 2){
            
        condicionales++;
        saltos++;
        
        aux = anterior + actual;
        asignacion++;
        aritmeticas++;
        
        anterior = actual;
        asignacion++;
        
        actual = aux;
        asignacion++;
        
        n = n - 1;
        aritmeticas++;
        asignacion++;
        
    }
    saltos++;
    condicionales++;
    
    cout<<(asignacion + aritmeticas + condicionales + saltos)<<endl;
    
    return 0;
}
