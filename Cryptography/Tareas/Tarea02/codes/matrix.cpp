#include <bits/stdc++.h>
#include "../headers/matrix.h"

using namespace std;

/**
 * This function build an eratosthenes sieve
 * @param: (lli) n, max size of our sieve
 * @return: (vector<lli>) a vector with our sieve
 * **/
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

/**
 * This function gets all the elements of Zn* 
 * @param: (int) n, max elements
 * @param: (vector<lli>) our eratosthenes sieve
 * @return: (vector<bool>) all the elements with a bool value
 * if the value is true the element is not part of Zn*
 * **/
vector<bool> get_elements(lli n, vector<lli> &eratosthenes_sieve){
    vector<bool> elements(n, false);
    int size = n;
    while(n && eratosthenes_sieve[n]){
        elements[eratosthenes_sieve[n]] = true;
        n /= eratosthenes_sieve[n];
    }
    elements[n] = true;

    cout << " Prime factors = {";
        for(int i = 1; i < size; i++)
            if(elements[i])
                cout << i << ( ( i == (size - 1 ) ) ? "" : "," );
    cout << "}\n";

    for(int i = 2; i < size; i++)
        if(elements[i])
            for(int j = i; j < size; j += i)
                elements[j] = true;

    cout << "\n Zn = {";
    for(int i = 1; i < size; i++)
        if(!elements[i])
            cout << i << ( ( i == (size - 1) ) ? "" : ",");
    cout << "}\n";
    return elements;
}

void paintZnStar(vector<bool> &elements){
    int n = elements.size();
    bool flag = false;
    for(int i = 1; i < n; i++){
        for(int j = 1; j < n; j++){
            flag = false;
            if(!elements[i] && !elements[j]){
                cout << "\t" << (i * j) % n;
                flag = true;
            }
        }
        if(flag)
            cout << endl;
    }
}