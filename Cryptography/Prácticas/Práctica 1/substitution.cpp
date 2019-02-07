#include <bits/stdc++.h>

using namespace std;

string cipher(string c, vector<int> &K);
string decoder(string m, vector<int> &K);
void choose(string str, vector<int> &K);
string read_file();

int main(){
    string str;
    int k, v;
    vector<int> K;
    str = read_file();
    cout << "How many keys we gonna use? -> ";
    cin >> k;
    while(k--){
        cout << "Write the key " << (k + 1) << " -> ";
        cin >> v;
        K.push_back(v);
    }
    choose(str, K);
    return 0;
}

string cipher(string c, vector<int> &K){
    string cipher_text = "";
    int size = c.size();
    int size_keys = K.size();
    for(int i = 0, j = 0; i  < size; i++, j++){
        if(c[i] != ' '){
            if(islower(c[i])){
                c[i] = ((c[i] + K[j % size_keys]) % ('z' + 1));
                if( !islower(c[i]) ) 
                    c[i] = 'a' + c[i];
            }
            else if(isupper(c[i])){
                c[i] = ((c[i] + K[j % size_keys]) % ('Z' + 1));
                if( !isupper(c[i])) 
                    c[i] = 'A' + c[i];
            }
        }
    }
    return c;
}   

string decoder(string m, vector<int> &K){
    string plain_text = "";
    int size = m.size();
    int size_keys = K.size();
    for(int i = 0, j = 0; i < size; i++, j++){
        if(m[i] != ' '){
           if(islower(m[i])){
                m[i] = abs((m[i] - K[j % size_keys]) % ('z' + 1));
                if( !islower(m[i]) ) 
                    m[i] = ('z' + 1) - abs('a' - m[i]);
            } else if(isupper(m[i])){
                m[i] = abs((m[i] - K[j % size_keys]) % ('Z' + 1));
                if( !isupper(m[i]) ) 
                    m[i] = ('Z' + 1) - abs('A' - m[i]);
            }
        }
    }
    return m;
}   

string read_file(){
    string file_name, str = "", line = "";
    ifstream input_file;
    cout << "Write the file path -> ";
    getline(cin, file_name);
    input_file.open(file_name.c_str(), ios::in);
    if(input_file.is_open()){
        while(!input_file.eof()){
            getline(input_file, line);
            str += line;
        }
        input_file.close();
    } else
        cout << "\nFile doesn't exist or you're not allowed to open it" << endl;
    
    return str;
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
            //cout << "str -> " << str << endl;
            cout << cipher(str, K) << endl;
            break;
        //Decode
        case 2:
            //cout << "str -> " << str << endl;
            cout << decoder(str, K) << endl;
            break;
        default:
            cout << "Option " << option << " doesn't exists" << endl;
            break;
    }
}