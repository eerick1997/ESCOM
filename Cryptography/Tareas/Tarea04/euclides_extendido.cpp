#include <bits/stdc++.h>

using namespace std;
typedef long long int lli;

/**
 * Para este caso se hace uso del teorema de Bezout ax + by = d es decir
 * ax + by = GCD(a, b) del GCD sabemos que recursivamente podemos calcularlo
 * con GCD(b, a % b), vease el programa que esta en la misma carpeta. Además
 * a % b = a - [a / b] b
*/
lli euclides_extendido(lli a, lli b, lli &x, lli &y, lli mod = 0){

    //Caso base
    if(!b){
        x = 1;
        y = 0;
        return a;
    }
    lli gcd = euclides_extendido(b, a % b, x, y, mod = 0);
    //Calculamos el valor de x
    x = (!mod) ? x - y * (a / b) : (mod + x - (y * (a / b)) % mod) % mod;
    //Antes de retornar el GCD de nuestra función, debemos de intercambiar el valor de x e y
    swap(x, y);
    return gcd;
}

int main(){
    lli x = 0, y = 0, a, b, GCD;
    cin >> a >> b;
    GCD = euclides_extendido(a, b, x, y);
    cout << "GCD: (" << a << "," << b << ") = " << GCD << endl;
    cout << "x: " << x << " y: " << y << endl;
    cout << GCD << " = " << a << "(" << x << ") " << "mod (" << b << ")" << endl;
    cout << "res -> " << abs(y + x) << endl;
    return 0;
}