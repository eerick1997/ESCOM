#include <bits/stdc++.h>

std::vector<int> buildSieve(int size){
    int root = sqrt(size);
    std::vector<int> sieve(size + 1);
    for(int i = 4; i <= size; i+=2)
        sieve[i] = 2;
    
    for(int i = 3; i <= root; i+=2){
        if(!sieve[i])
            for(int j = i*i; j <= size; j += i)
                if(!sieve[i])
                    sieve[j] = i;
    }

    return sieve;
}

int** createZnStar(std::vector<int> &factors){
    int n = factors.size();
    int** matrix = new int*[n];

    for(int i = 0; i < n; i++)
        matrix[i] = new int[n];

    for(int i = 0; i < n; i++)
        for(int j = 0; j < n; j++)
            matrix[i][j] = factors[i]*factors[j];

    return matrix;
}