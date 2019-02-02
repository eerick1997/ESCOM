#include <bits/stdc++.h>
#include "../headers/cipher.h"

using namespace std;

string cipher(int a, int b, string c){
    for(int i = 0; i < c.size(); i++){
      if(c[i] != ' '){
            if('a' <= c[i] && c[i] <= 'z'){
                c[i] = ((a*c[i] + b) % ('z' + 1));
                if( !('a' <= c[i] && c[i] <= 'z') ) 
                    c[i] = 'a' + c[i];
            }
            else if('A' <= c[i] && c[i] <= 'Z'){
                c[i] = ((a*c[i] + b) % ('Z' + 1));
                if( !('A' <= c[i] && c[i] <= 'Z') ) 
                    c[i] = 'A' + c[i];
            }
        }
    }   
    return c;
}

string decoder(int a, int b, string c){
    vector<int> sieve = build_sieve(26);
    vector<bool> elements = get_elements(26, sieve);
    int inverse = get_inverse(26, a, elements);
    cout << "\na value " << a << " inverse value: " << inverse << endl;
    for(int i = 0; i < c.size(); i++){
        if(c[i] != ' '){
            if('a' <= c[i] && c[i] <= 'z'){
                c[i] = ((inverse*c[i] - b) % ('z' + 1));
                if( !('a' <= c[i] && c[i] <= 'z') ) 
                    c[i] = 'a' + c[i];
            }
            else if('A' <= c[i] && c[i] <= 'Z'){
                c[i] = ((a*c[i] - b) % ('Z' + 1));
                if( !('A' <= c[i] && c[i] <= 'Z') ) 
                    c[i] = 'A' + c[i];
            }
        }
    }
    return c;
}

vector<int> build_sieve(int n){
    vector<int> sieve(n + 1);
    int root = sqrt(n);
    for(int i = 4; i <= n; i+=2)
        sieve[i] = 2;
    for(int i = 3; i <= root; i+=2)
        if(!sieve[i])
            for(int j = i*i; j <= n; j+=i)
                if(!sieve[j])
                    sieve[j] = i;
    return sieve;
}

vector<bool> get_elements(int n, vector<int> &sieve){
    int size = n;
    vector<bool> elements(n, false);
    while(!sieve[n]){
        elements[sieve[n]] = true;
        n /= sieve[n];
    }
    elements[n] = true;
    return elements;
}

int get_inverse(int n, int a, vector<bool> &elements){
    int b = 0;
    if(elements[a])
        return 0;
    for(int i = 1; i < n; i++){
        if(((a*i) % n) == 1)
            return i; 
    }
    return 0;
}
