#include <bits/stdc++.h>

using namespace std;

const int MAX_VAL = 127;
const int MIN_VAL = 32;
const int LAN_SIZ = 96;

typedef long long int lli;
typedef vector<vector<lli>> Matrix;
vector<char> language; 

void init_language(){
    for(int i = 32; i < 127; i++)
        language.push_back(i);
}

short mod (lli n, lli m){
    return ( (n < 0) ? m - ( abs(n) % m ) : n % m );
}

lli euclides(lli a, lli b, lli &x, lli &y, lli mod = 0){
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

lli inverse(lli a, lli b){
    lli x = 0, y = 0, ans = 0;
    lli gcd = euclides(a, b, x, y, 0);
    if(gcd == 1){
        ans = (x < 0) ? (b + x) : x;
    }
    return ans;
}

Matrix escalarMatrix(lli escalar, Matrix matrix){
    for(int i = 0; i < matrix.size(); i++)
        for(int j = 0; j < matrix[i].size(); j++)
            matrix[i][j] = mod( (escalar * matrix[i][j]), LAN_SIZ);
    return matrix; 
}

lli determinant(int k, int l, Matrix &matrix, bool cof){
    lli det = 0;
    vector<lli> ns;
    for(int i = 0; i < matrix.size(); i++){
        for(int j = 0; j < matrix[i].size(); j++){
            if(i != k && j != l)
                ns.push_back( matrix[i][j] );
        }
    }
    det = ns[0]*ns[3] - ns[1]*ns[2];
    return ( (det) * ( ( cof ) ? matrix[k][l] : 1 ) );
}

lli determinant(Matrix &matrix){
    lli ans = 0;
    for(int i = 0; i < matrix.size(); i++)
        ans +=  ( ( !(i % 2) ? 1 : -1 ) * ( determinant(0, i, matrix, true) ) );
    return ans;
}

Matrix getMatrix(){
    Matrix matrix(3, vector<lli>(3));
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++)
            matrix[i][j] = (rand() % LAN_SIZ);
    }
    return matrix;
}


Matrix getTraMatrix(Matrix &matrix){
    lli n = matrix.size();
    Matrix transpose(n, vector<lli>(n, 0));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            transpose[i][j] = matrix[j][i];
        }
    }
    return transpose;
}


Matrix getAdjMatrix(Matrix &matrix){
    int n = matrix.size();
    Matrix adj(n, vector<lli>(n, 0));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            lli det = determinant(i, j, matrix, false);
            short sign = ( !((i + j) % 2)) ? 1 : -1 ;
            adj[i][j] = mod( (sign * det) , LAN_SIZ); 
        }
    }
    adj = getTraMatrix(adj);
    return adj;
}


string cipher(Matrix matrix, string plain_text){
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

string decoder(Matrix inv_matrix, string cipher_text){
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

void imprimir(Matrix &matrix){
    for(int i = 0; i < matrix.size(); i++){
        cout << endl;
        for(int j = 0; j < matrix[i].size(); j++){
            cout << /*"[" << i << "][" << j << "]" << " ";*/ matrix[i][j] << " ";
        }   
    }
    cout << endl;
}

void helper(string &str){
    while( (str.size() % 3) != 0)
        str += " ";
    
    for(int i = 0; i < str.size(); i++)
        str[i] -= MIN_VAL;
}

int main(){
    init_language();
    string str = "hello";
    helper(str);

    Matrix matrix = getMatrix();
    imprimir(matrix);

    lli det = mod(determinant(matrix), LAN_SIZ);
    cout << "\ndeterminant \t" << det << endl; 

    lli inv = inverse(det, LAN_SIZ);
    cout << "modular inverse \t" << inv << endl;

    Matrix adjMatrix = getAdjMatrix(matrix);
    imprimir(adjMatrix);

    Matrix toDecode = escalarMatrix(inv, adjMatrix);
    imprimir(toDecode);

    string cipher_text = cipher(matrix, str);
    cout << str << endl;
    cout << "cipher text \t" << cipher_text << endl;
    helper(cipher_text);
    string plain_text = decoder(toDecode, cipher_text);
    cout << "plain text \t" << plain_text << endl;
    return 0;
}