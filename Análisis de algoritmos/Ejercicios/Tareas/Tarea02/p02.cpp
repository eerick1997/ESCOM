#include <iostream>

using namespace std;

int main(){
    
    int asignacion = 0, aritmeticas = 0, condicionales = 0, saltos = 0;
    int polinomio = 0, z = 0;
    
    int n = 10;
    
    asignacion++;
    asignacion++;
    
    for(int i = 0; i <= n; i++, aritmeticas++){
        
        int A[n];
        
        condicionales++;
        saltos++;
        
        polinomio = polinomio * z + A[n-1];
        aritmeticas++;
        aritmeticas++;
        aritmeticas++;
        asignacion++;
        
    }
    saltos++;
    condicionales++;
    
    cout<<(asignacion + aritmeticas + condicionales + saltos)<<endl;
}
