/**
 * Author: Vargas Romero Erick Efraín
 * Last modification: 22 March 2019
 **/
#include<bits/stdc++.h>

using namespace std;

const short inv[256] = 
{
    0,1,141,246,203,82,123,209,232,79,41,192,176,225,229,199,
    116,180,170,75,153,43,96,95,88,63,253,204,255,64,238,178,
    58,110,90,241,85,77,168,201,193,10,152,21,48,68,162,194,
    44,69,146,108,243,57,102,66,242,53,32,111,119,187,89,25,
    29,254,55,103,45,49,245,105,167,100,171,19,84,37,233,9,
    237,92,5,202,76,36,135,191,24,62,34,240,81,236,97,23,
    22,94,175,211,73,166,54,67,244,71,145,223,51,147,33,59,
    121,183,151,133,16,181,186,60,182,112,208,6,161,250,129,130,
    131,126,127,128,150,115,190,86,155,158,149,217,247,2,185,164,
    222,106,50,109,216,138,132,114,42,20,159,136,249,220,137,154,
    251,124,46,195,143,184,101,72,38,200,18,74,206,231,210,98,
    12,224,31,239,17,117,120,113,165,142,118,61,189,188,134,87,
    11,40,47,163,218,212,228,15,169,39,83,4,27,252,172,230,
    122,7,174,99,197,219,226,234,148,139,196,213,157,248,144,107,
    177,13,214,235,198,14,207,173,8,78,215,227,93,80,30,179,
    91,35,56,52,104,70,3,140,221,156,125,160,205,26,65,28,
};

const short rows[8] = {143, 199, 227, 241, 248, 124, 62, 31};
short add = 198;

short multiply(short a, short b);
short reverse(short a);

int main(){
    short ans;
    add >>= 1;
    for(int i = 0; i < 256; i++){
        ans = 0;
        for(short j = 0; j < 8; j++)
            ans ^= ( ( multiply( reverse(inv[i]), rows[j] ) ) << j);
        cout << "\t" << std::hex << (ans ^ add) << ( !((i + 1) % 16) ? "\n" : "" );
    }
    return 0;
}

/**
 * This function makes a multiplication between two numbers but using
 * their binary representation. This multiplication is make like a 
 * vector multiplication.
 * @param: short a, the first number to make the multiplication
 * @param: short b, the second number to make the multiplication
 * @return: short, the result of make the multiplication of a and b (bit level) and,
 *          xoring each element of the answer
**/
short multiply(short a, short b){
    short ans = 0;
    for(short i = 0; i < 8; i++, a >>= 1, b >>= 1)
        ans ^= ( (a & 1) & (b & 1));
    return ( (ans & 1));
}

/**
 * This function reverse a number (binary representation)
 * @param: short a, the number to make reverse
 * @param: short, the number reversed. 
**/
short reverse(short a){
    short ans = 0;
    for(int i = 0, j = 7; i < 8; i++, j--)
        ans ^= ( (a >> i) & 1) << j;
    return ans;
}