/**
 * Author: Vargas Romero Erick Efraín
 * Last modification: 22 March 2019
 **/

#include<bits/stdc++.h>

using namespace std;

int limit(int a);
int multiply(int a, int b, int m);

int main(){
    int a, b, m;
    cin >> a >> b >> m;
    cout << multiply(a, b, m);
}

/**
 *  This function erase extra information of a. For example if we
 *  have the next binary string 0001 1010 but we need information
 *  until 4th bit we need to make 0 the 5th bit.
 *  @param: int our number with extra information
 *  @return: int the number without extra information
**/
int limit(int a){
    int ans = 0;
    for(int i = 0, j = a - 1; i < a; i++, j--){
        ans ^= ( (a >> j) & 1) << i;
    }
    return ans;
}

/**
 *  This function makes a multiplication of two polynomials, then
 *  make modulus another polynomial.
 *  @param: int a, our first polynomial
 *  @param: int b, our second polynomial
 *  @param: int m, our modulus polynomial
 *  @return: int the result of make the operation explained before.
**/
int multiply(int a, int b, int m){
    int MSB = 1, i = 1, j = 0;
    int ma = m;
    int aa = a;
    int ans = 0;
    //Searching the MSB
    while(ma >>= 1 != 0){
        MSB++;
    }

    while( (aa >>= 1) != 0){
        if( ( aa & 1 ) == 1 )
            ans ^= (b << i);
        i++;
    }

    cout << (1 << MSB) << endl;
    if(ans >= (1 << (MSB))){
        ans ^= m;
        ans &= (int)(pow(2, MSB) - 1);
    }
    
    return ans;
}