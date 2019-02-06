#include <bits/stdc++.h>

using namespace std;
typedef long long int lli;

const int alphabet[27] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
                           'i', 'j', 'k', 'l', 'm', 'n', 241, 'o', 
                           'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 
                           'x', 'y', 'z' };

string cipher(int a, int b, string str);
string decoder(int a, int b, string str);
int inv_a(int a, int m);