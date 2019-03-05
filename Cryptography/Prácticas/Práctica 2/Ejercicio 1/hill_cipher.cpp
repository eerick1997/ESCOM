/**
 * Author: Vargas Romero Erick Efraín
 * Last modification: 17 Febraury 2018
 * Note: to compile this program you need to add external files
 * g++ hill_cipher.cpp Codes/cipher.cpp Codes/files.cpp Codes/matrix.cpp
 **/

#include <bits/stdc++.h>
#include "Headers/matrix.h"
#include "Headers/files.h"

using namespace std;

vector<char> language; 

//Functions tructures
void Main();
void helper(string &str);
lli inverse(lli a, lli b);
lli euclides(lli a, lli b, lli &x, lli &y, lli mod);

int main(){
    language = init_language();
    bool valid = false;
    lli det, inv;
    while(true){
        Main();
    }
    return 0;
}

/**
 * This function contains our main
 * @param: none
 * @return: nothing
 * */
void Main(){
    unsigned short option;
    string cipher_text = "", plain_text = "";
    cout << endl;
    cout << "\nWhat do you want to do?";
    cout << "\n1. Ciphe text";
    cout << "\n2. Decode text";
    cout << "\n3. Generate a random Matrix";
    cout << "\n4. Exit\n->";
    cin >> option;
    cout << endl;
    switch (option)
    {
        case 1:
        {
            string name_file = "";
            plain_text = read_file(name_file);
            Matrix matrix = get_matrix_file();
            matrix = validMatrixBySize(matrix, 3);
            lli det = mod(determinant(matrix), LAN_SIZ);
            lli inv = inverse(det, LAN_SIZ);
            if(validKey(det, inv)){
                out_file_matrix(matrix, "matrix.mt");
                helper(plain_text);
                cipher_text = cipher(matrix, plain_text, language);
                cout << "\nCipher text: " << cipher_text << endl;
                out_file(cipher_text, (name_file + ".hill"));
            } else 
                cout << "\nThis matrix is not a valid key" << endl;
        }
        break;

        case 2:
        {
            string name_file = "";
            cipher_text = read_file(name_file);
            Matrix matrix = get_matrix_file();
            print(matrix);
            matrix = validMatrixBySize(matrix, 3);
            helper(cipher_text);
            lli det = mod(determinant(matrix), LAN_SIZ);
            lli inv = inverse(det, LAN_SIZ);
            if(validKey(det, inv)){
                Matrix adjMatrix = getAdjMatrix(matrix);
                Matrix toDecodeM = escalarMatrix(inv, adjMatrix);
                out_file_matrix(toDecodeM, "inverse_matrix.mt");
                plain_text = decoder(toDecodeM, cipher_text, language);
                cout << "\nPlain text: " << plain_text << endl;
                out_file(plain_text, (name_file + ".txt"));
            } else  
                cout << "\nThis matrix is not a valid key" << endl;
        }
        break;
        case 3:
        {
            lli det = 0, inv = 0;
            Matrix matrix;
            do{
                matrix = getMatrix();
                det = mod(determinant(matrix), LAN_SIZ);
                inv = inverse(det, LAN_SIZ);
            } while(!validKey(det, inv));
            out_file_matrix(matrix, "random_matrix.mt");
            print(matrix);
        }
        break;

        case 4:
        {
            exit(0);
        }
        break;

        default:
        {
            cout << "\nOption " << option << " doesn't exists." << endl;
        }
        break;
    }

}

/**
 * We use the Bezout theorem to solve equations like
 * ax + by = c where C is equalls to GCD(a, b).
 * If GCD(a, b) is equall to 1, then we can get the modular
 * inverse of a, b. 
 * @param: (lli) a coeficient of our equation
 * @param: (lli) b coeficient of our equation
 * @param: (lli) x our first unknow value
 * @param: (lli) y our second unknow value
 * @param: (lli) mod, if we need to make mod our equation
 *              we need this param
 * @return: (lli) gcd value
*/
lli euclides(lli a, lli b, lli &x, lli &y, lli mod){
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

/**
 * This function gets the modular inverse of a, b
 * this is possible using the extended euclidean algorithm
 * @param: (lli) a, number which we want to calculate the modular inverse
 * @param: (lli) b, modulus value
 * @return: (lli) the modular inverse of a
 * 
 **/
lli inverse(lli a, lli b){
    lli x = 0, y = 0, ans = 0;
    lli gcd = euclides(a, b, x, y, 0);
    if(gcd == 1){
        ans = (x < 0) ? (b + x) : x;
    } else {
        return 0;
    }
    return ans;
}

/**
 * This function adds white spaces in our string if and just if
 * our string is not a multiple of 3
 * @param: (string) str
 * @return: nothing
 * 
*/
void helper(string &str){
    while( (str.size() % 3) != 0)
        str += " ";
    
    for(int i = 0; i < str.size(); i++){
        str[i] -= MIN_VAL;
        if(str[i] < 0){
            str[i] = MAX_VAL + str[i];
        }
    }
}