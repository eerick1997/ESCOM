/**
 * Author: Vargas Romero Erick Efraín
 * Last modification: 17 Febraury 2018
 **/
#include <bits/stdc++.h>
#include "../Headers/cipher.h"

using namespace std;

/**
 * This function calculates modulus of any number, also if
 * the number it's negative
 * @param: (lli) n, number which we want to apply modulus
 * @param: (lli) m, modulus value
 * @return: (short) the result of n mod m 
 **/
short mod (lli n, lli m){
    return ( (n < 0) ? m - ( abs(n) % m ) : n % m );
}

/**
 * This function fill an array which will be used to
 * get jut the printable ASCII characters
 * @param: none
 * @return: (vector<char>), our valid ASCII characters 
 **/
vector<char> init_language(){
    vector<char> language;
    for(int i = MIN_VAL; i <= MAX_VAL; i++)
        language.push_back(i);
    return language;
}

/**
 * This function ciphe plain text using Hill Cipher algorithm.
 * @param: (Matrix) matrix, this matrix is our key
 * @param: (string) plain_text, the text which we go to ciphe
 * @param: (vector<char>) language, all the valid elements of our language
 * @return: (string) the cipher text
 **/ 
string cipher(Matrix matrix, string plain_text, vector<char> language){
    lli size = plain_text.size();
    lli n = matrix.size();
    string cipher_text = "";
    for(int i = 0; i < size; i += n){
        for(int j = 0, val = 0; j < n; j++, val = 0){
            for(int k = 0; k < n; k++){
                val += ( matrix[j][k] * plain_text[i + k] );
            }
            cipher_text += language[ mod(val, LAN_SIZ) ];
        }
    }
    return cipher_text;
}

/**
 * This function decodes cipher text using Hill Cipher algorithm.
 * @param: (Matrix) matrix, this matrix is our key
 * @param: (string) cipher_text, the text which we go to decode
 * @param: (vector<char>) language, all the valid elements of our language
 * @return: (string) the plain text
 **/ 
string decoder(Matrix inv_matrix, string cipher_text, vector<char> language){
    lli size = cipher_text.size();
    lli n = inv_matrix.size();
    string plain_text = "";
    for(int i = 0; i < size; i += n){
        for(int j = 0, val = 0; j < n; j++, val = 0){
            for(int k = 0; k < n; k++){
                val += ( inv_matrix[j][k] * cipher_text[i + k] );
            }
            plain_text += language[ mod(val, LAN_SIZ) ];
        }
    }
    return plain_text;
}