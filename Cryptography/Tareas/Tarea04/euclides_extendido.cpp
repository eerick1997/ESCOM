#include <bits/stdc++.h>

using namespace std;
typedef long long int lli;

lli euclides_extendido(lli a, lli b, lli &x, lli &y, lli mod = 0){

    //Verificamos que el valor del GCD anterior no sea cero
    if(!b){
        x = 1;
        y = 0;
        return a;
    }
    lli gcd = euclides(b, a % b, x, y, mod);
    x = (!mod) ? x - y * (a / b) : (mod + x - (y * (a / b)) % mod) % mod;
    swap(x, y);
    return gcd;
}

lli euclides(){

}

int main(){

    return 0;
}