#include <bits/stdc++.h>
using namespace std;

typedef long long int lli;
typedef vector< vector<lli> > Matrix;

const unsigned short MAX_VAL = 127;
const unsigned short MIN_VAL = 32;
const unsigned short LAN_SIZ = 96;

vector<char> init_language();
string cipher(Matrix matrix, string plain_text, vector<char> language);
string decoder(Matrix inv_matrix, string cipher_text, vector<char> language);