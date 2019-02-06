#include <bits/stdc++.h>
#include <locale.h>
//#include <windows.h>
#include "headers/cipher.h"

using namespace std;

typedef long long int lli;

string read();
string helper(string str);
void choose(int option);

int main(){
    int option;
    setlocale(LC_ALL, "spanish");
    while(1){
        cout << "\n - Please select an option - \n";
        cout << "1. Ciphe plain text\n";
        cout << "2. Decode ciphe text\n";
        cout << "3. Exit\n";
        cout << " -> ";
        cin >> option;
        choose(option);
    }
}

void choose(int option){
    string str;
    int a, b;
    cout << endl;
    switch (option){
        case 1:
            cout << "Write a value b value and the str to ciphe -> ";
            cin >> a >> b;
            str = read();
            str = helper(str);
            str = cipher(a, b, str);
            cout << "\nCipher text: " << str << endl; 
            break;
    
        case 2:
            cout << "Write a value b value and the str to ciphe -> ";
            cin >> a >> b;
            str = read();
            str = helper(str);
            str = decoder(a, b, str);
            cout << "\nPlain text: " << str << endl;
            break;

        case 3: 
            exit(0);
            break;
        default:
            cout << "Option " << option << " doesn't exists" << endl;
            break;
    }
}
/**
 * This function allow us read a string white spaces
 * @param: none
 * @return: (string) the read string
 * **/
string read(){
    string str = "";
    char c;
    while((c = getchar()) != '\n'){
        str += c;
    }
    return str;
}

/**
 * This function gives an ID to identify each character
 * @param: (string) str, our read string
 * @return: (string) an string with our new IDs
 * **/
string helper(string str){
    for(int i = 0; i < str.size(); i++){
        if(str[i] != ' ')
            str[i] = (str[i] >= 'o') ? str[i] + 1 : str[i];
    }
    return str;
}   