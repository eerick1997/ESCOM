#include <bits/stdc++.h>
#include "headers/matrix.h"

using namespace std;

int main(){
    vector<lli> eratosthenes_sieve;
    vector<bool> elements;
    lli n;
    cout << " Write n value: "; 
    cin >> n;
    eratosthenes_sieve = build_sieve(n);
    elements = get_elements(n, eratosthenes_sieve);
    paintZnStar(elements);
    return 0;
}