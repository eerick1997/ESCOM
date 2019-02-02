#include <bits/stdc++.h>

using namespace std;
typedef long long int lli;

vector<int> build_sieve(int n);
vector<bool> get_elements(int n, vector<int> &sieve);
int get_inverse(int n, int a, vector<bool> &elements);
string cipher(int a, int b, string str);
string decoder(int a, int b, string str);
int inverse(int a);