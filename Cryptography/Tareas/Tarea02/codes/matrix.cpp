#include <bits/stdc++.h>
#include "../headers/matrix.h"

using namespace std;

vector<lli> build_sieve(lli n){
    int root = sqrt(n);
    vector<lli> sieve(n + 1);
    for(lli i = 4; i <= n; i += 2)
        sieve[i] = 2;

    for(lli i = 3; i <= root; i += 2)
        if(!sieve[i])
            for(lli j = i*i; j <= n; j+=i)
                if(!sieve[j])
                    sieve[j] = i;
    
    return sieve;
}

vector<bool> get_elements(lli n, vector<lli> &eratosthenes_sieve){
    vector<bool> elements(n, false);
    int size = n;
    while(n && eratosthenes_sieve[n]){
        elements[eratosthenes_sieve[n]] = true;
        n /= eratosthenes_sieve[n];
    }
    elements[n] = true;

    for(int i = 2; i < size; i++)
        if(elements[i])
            for(int j = i*i; j < size; j += i)
                elements[j] = true;
        
    return elements;
}

void palliZnStar(vector<bool> &elements){
    int n = elements.size();
    bool flag = false;
    for(int i = 1; i < n; i++){
        for(int j = 1; j < n; j++){
            flag = false;
            if(!elements[i] && !elements[j]){
                cout << " " << (i * j) % n;
                flag = true;
            }
        }
        if(flag)
            cout << endl;
    }
}