#include <iostream>

using namespace std;

int main(){

     int asignacion = 0, aritmeticas = 0, condicionales = 0, saltos = 0;
     int n = 2;
     
     int s2[n], s[n];
     
     asignacion++;
     asignacion++;
     
    for(int i = n - 1,  j = 0; i >= 0; i--, j++, aritmeticas++, aritmeticas++){
        condicionales++;
        saltos++;
        s2[j] = s[i];
        asignacion++;
    }
    condicionales++;
    saltos++;
    
    asignacion++;
    for(int i = 0; i < n; i++, aritmeticas++){
        condicionales++;
        saltos++;
        s[i] = s2[i];
        asignacion++;
    }
    saltos++;
    condicionales++;
    
     cout<<(asignacion + aritmeticas + condicionales + saltos)<<endl;
    return 0;
}
