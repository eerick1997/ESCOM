#include <bits/stdc++.h>

using namespace std;


string read(){
    string str = 0;
    char c;
    while((c = getchar()) != '\n')
        str += c;
    return str;
}

string cipher(string plain_text, vector<int> &K){
    string cipher_text = "";
    int size = plain_text.size();
    int size_keys = K.size();
    for(int i = 0, j = 0; i  < size; i++, j++){
        if(plain_text[i] != ' ')
            cipher_text += ( ( ( plain_text[i] - 'a' ) + K[j % size_keys] ) % 26 ) + 'a';
        else 
            cipher_text += plain_text[i];
    }
    return cipher_text;
}

string decoder(string cipher_text, vector<int> &K){
    string plain_text = "";
    int size = cipher_text.size();
    int size_keys = K.size();
    for(int i = 0, j = 0; i < size; i++, j++){
        if(cipher_text[i] != ' '){
            plain_text += ( ( ( cipher_text[i] - 'a') - K[j % size_keys]) % 26 ) + 'a';
            if(!islower(plain_text[i]))
                plain_text[i] = ('z' + 1) - abs('a' - plain_text[i]);
        }
        else 
            plain_text += cipher_text[i];
    }
    return plain_text;
}

void choose(string str, vector<int> &K){
    int option;
    cout << "\n1. Ciphe" << endl;
    cout << "2. Decode" << endl;
    cout << "3. Exit" << endl;
    cin >> option;
    switch (option)
    {
        //Cipher
        case 1:
            cout << cipher(str, K) << endl;
            break;

        //Decode
        case 2:
            cout << decoder(str, K) << endl;
            break;
        default:
            cout << "Option " << option << " doesn't exists" << endl;
            break;
    }
}


int main(){
    string str;
    int k, v;
    vector<int> K;
    getline(cin, str);
    cin >> k;
    while(k--){
        cin >> v;
        K.push_back(v);
    }

    choose(str, K);
    return 0;
}