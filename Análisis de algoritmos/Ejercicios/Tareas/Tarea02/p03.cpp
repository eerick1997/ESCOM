#include <iostream>

using namespace std;

int main(){
    
    int asignacion = 0, aritmeticas = 0, condicionales = 0, saltos = 0;
    int n = 10;
    
    asignacion++;
    for(int i = 1; i < n; i++, aritmeticas++){
        saltos++;
        condicionales++;
        
        asignacion++;
        for(int  j = 1; j < n; j++, aritmeticas++){
            saltos++;
            condicionales++;
    
            //c[i,j] = 0;
            asignacion++;
            
            asignacion++;
            for(int k = 1; k < n; k++){
                saltos++;
                condicionales++;
                //int A[i,k], B[k,j];
                //c[i,j] = c[i,j] + A[i,k]*B[k,j];
                asignacion++;
                aritmeticas++;
                aritmeticas++;
            }
            saltos++;
            condicionales++;
        }
        saltos++;
        condicionales++;
    }
    saltos++;
    condicionales++;
    
    cout<<(asignacion + aritmeticas + condicionales + saltos)<<endl;
    return 0;
}
