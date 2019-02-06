#include <bits/stdc++.h>
#include <locale.h>
#include "../headers/cipher.h"

using namespace std;

/**
 * This function ciphes plain text using 
 * (a*m[i] + b) mod 27
 * @param: (int)a
 * @param: (int)b
 * @param: (string) plain text
 * @return: (string)cipher text
 * **/
string cipher(int a, int b, string c){
    
    for(int i = 0; i < c.size(); i++){
        if(c[i] != ' '){
            c[i] = (c[i] != -15) ? c[i] - 'a' : 14;
            int s = ((a*(c[i]) + b) % 27);  
            c[i] = alphabet[ s ];
        }
    }
    return c;
}

/**
 * This function decodes a cipher text using
 * (a^(-1)*(m[i] - b)) mod 27
 * @param: (int)a
 * @param: (int)b
 * @param: (string) cipher text
 * @return: (string) plain text
 * **/
string decoder(int a, int b, string m){
    int s = 0, x = inv_a(a, 27);
    for(int i = 0; i < m.size(); i++){
        if(m[i] != ' '){
            m[i] = (m[i] != -15) ? m[i] - 'a': 14;
            s = ((x*(m[i] - b)) % 27);
            if(s < 0)
                s = 27 + s;
            m[i] = alphabet[ s ];
        }
    }
    return m;
}

/**
 * This function gets the inverse of a mod m
 * @param: (int) a
 * @param: (int) m
 * @return: (int) inverse of a mod m
 * **/
int inv_a(int a, int m){
    int b, x;
    for(b = 0; b < m; b++){
        x = (a * b) % m;
        if(x == 1)
            return b;    
    } 
    return 0;
}