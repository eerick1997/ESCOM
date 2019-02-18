#include <bits/stdc++.h>

using namespace std;

void algorithm1(int a, int b){
    cout << "\nAlgorithm 1 answer of " << a << "," << b << endl;
    int u = a;
    int v = b;
    int x1 = 1;
    int y1 = 0;
    int x2 = 0;
    int y2 = 1;
    int d, x, y;
    int q, r;
    while(u != 0){
        q = v/u;
        cout << "q -> " << q << endl;
        r = v - q*u;
        cout << "r -> " << r << endl;
        x = x2 - q*x1;
        cout << "x -> " << x << endl;
        y = y2 - q*y1;
        cout << "y -> " << y << endl;
        v = u;
        cout << "v -> " << v << endl;
        u = r;
        cout << "u -> " << u << endl;
        x2 = x1;
        cout << "x2 -> " << x2 << endl;
        x1 = x;
        cout << "x1 -> " << x1 << endl;
        y2 = y1;
        cout << "y2 -> " << y2 << endl;
        y1 = y;
        cout << "y1 -> " << y1 << endl;
    }
    d = v;
    x = x2;
    y = y2;

    cout << d << endl;
    cout << x << endl;
    cout << y << endl;
}

void algorithm2(int a, int p){
    cout << "\nAlgorithm 2 answer of " << a << "," << p << endl;
    int u = a;
    int v = p;
    int x1 = 1;
    int x2 = 0;
    int q, r, x;
    while( u != 1 ){
        q = v / u;
        cout << "q -> " << q << endl;
        r = v - q * u;
        cout << "r -> " << r << endl;
        x = x2 - q * x1;
        cout << "x -> " << x << endl;
        v = u;  
        cout << "v -> " << v << endl;
        u = r;
        cout << "u -> " << u << endl;
        x2 = x1;
        cout << "x2 -> " << x2 << endl;
        x1 = x;
        cout << "x1 -> " << x1 << endl;
    }
    cout << (x1 % p) << endl;
}

int main(){
    int a, b;
    while(cin >> a >> b && a != 0 && b != 0){
        algorithm1(a, b);
        algorithm2(a, b);
    }

    return 0;
}