#include <bits/stdc++.h>
#include "headers/cipher.h"

using namespace std;

typedef long long int lli;

int main(){
    lli a, b;
    string str;
    cin >> a >> b;
    getline(cin, str);
    cout << "\n I've read: " << str;
    str = cipher(a, b, str);
    cout << "\ncipher text: " << str;
    str = decoder(a, b, str);
    cout << "\nplain text: " << str;
}