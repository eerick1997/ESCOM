#include <bits/stdc++.h>

using namespace std;

typedef long long int lli;

vector<lli> build_sieve(lli n);
void palliZnStar(vector<lli> &factors);

vector<lli> eratosthenes_sieve;

int main(){
    vector<lli> factors;
    lli n, f, a;
    cin >> n;
    cin >> f;
    while(f--){
        cin >> a;
        factors.push_back(a);
    }
    palliZnStar(factors);

    return 0;
}

vector<lli> build_sieve(lli n){
    int root = sqrt(n);
    vector<lli> sieve(n + 1);
    for(lli i = 4; i <= n; i += 2)
        sieve[i] = 2;

    for(lli i = 4; i <= root; i += 2)
        if(!sieve[i])
            for(lli j = i*i; j <= n; j+=i)
                if(!sieve[j])
                    sieve[j] = i;
    
    return sieve;
}

void palliZnStar(vector<lli> &factors){
    int n = factors.size();
    for(lli i = 0; i < n; i++){
        for(lli j = 0; j < n; j++)
            cout << " " + factors[i] * factors[j];
        cout << endl;
    }
}