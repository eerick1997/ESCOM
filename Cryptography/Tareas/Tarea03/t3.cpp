#include <bits/stdc++.h>
#include <locale.h>
#include <windows.h>
#include "headers/cipher.h"

using namespace std;

typedef long long int lli;

string read();
string helper(string str);

int main(){
    setlocale(LC_ALL, "spanish");
    SetConsoleCP(1252);
    SetConsoleOutputCP(1252);
    lli a, b;
    string str;
    cin >> a >> b;
    str = read();
    str = helper(str);
    str = cipher(a, b, str);
    cout << "\ncipher text: " << str;
    str = helper(str);
    str = decoder(a, b, str);
    cout << "\nplain text: " << str;
}

string read(){
    string str = "";
    char c;
    while((c = getchar()) != '\n'){
        str += c;
    }
    return str;
}

string helper(string str){
    for(int i = 0; i < str.size(); i++){
        if(str[i] != ' ')
            str[i] = (str[i] >= 'o') ? str[i] + 1 : str[i];
    }
    return str;
}   