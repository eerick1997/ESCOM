#include <bits/stdc++.h>

using namespace std;
string s;

int buildKMPTBL(){
    vector<int> v(s.size());
    int j = 0, i = 1;
    while( i < s.size()){
        if(s[i] == s[j]){
            v[i++] = ++j;
        } else {
            if(j == 0)
                v[i++] = 0;
            else
                j = v[j - 1];
        }
    }
    return v.back();
}

int main(){

    while(cin >> s && s != "."){
        int l = buildKMPTBL();
        int n = s.size();
        if(n % (n - l) == 0)
            cout << n / (n - l) << endl;
        else
            cout << 1 << endl;
    }
    return 0;
}