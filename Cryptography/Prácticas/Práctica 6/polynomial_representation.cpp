/**
 * Author: Vargas Romero Erick Efraín
 * Last modification: 22 March 2019
 **/
#include<bits/stdc++.h>

using namespace std;
typedef long long int lli;

string fromBinaryToPolynomial(string &s);

int main(){
    string a;
    cin >> a;
    cout << fromBinaryToPolynomial(a) << endl;
    return 0;
}

/**
 * This function makes a conversion from a binary string to a polynomial representation
 * @param: string s, the binary string
 * @return: string, the polynomial representation of s
 **/
string fromBinaryToPolynomial(string &s){
    string ans = "";

    for(int i = 0, j = s.size() - 1; i < s.size(); i++, j--){
        string aux = std::to_string(j);
        if(s[i] == '1'){
            if( j == 0 )
                ans += " 1 ";
            else
                ans += (" x^" + aux + " +");     
        }
    }

    if(ans[ans.size() - 1] == '+')
        ans[ans.size() - 1] = ' ';
    return ans;
}