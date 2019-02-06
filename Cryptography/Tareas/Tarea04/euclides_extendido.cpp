#include <bits/stdc++.h>

using namespace std;
typedef long long int lli;

/**
 * GCD = X*a + Y*b
*/
lli euclides_extendido(lli a, lli b, lli &x, lli &y, lli mod = 0){

    //Caso base
    if(!b){
        x = 1;
        y = 0;
        return a;
    }
    lli gcd = euclides_extendido(b, a % b, x, y, mod = 0);
    x = (!mod) ? x - y * (a / b) : (mod + x - (y * (a / b)) % mod) % mod;
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
    return 0;
}