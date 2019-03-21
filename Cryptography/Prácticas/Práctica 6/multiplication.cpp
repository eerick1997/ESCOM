#include<bits/stdc++.h>

using namespace std;

int mulltiply(int a, int b, int m){
    int MSB = 1, i = 1, j = 0;
    int ma = m;
    int aa = a;
    int ans = 0;
    //Searching the MSB
    while(ma >>= 1 != 0){
        MSB++;
    }

    while( (aa >>= 1) != 0){
        if( ( aa & 1 ) == 1 )
            ans ^= (b << i);
        i++;
    }

    if(ans >= (pow(2, MSB + 1))){
        ans ^= m;
    }

    return ans;
}

int main(){

    int a, b, m;
    cin >> a >> b >> m;
    cout << mulltiply(a, b, m);
}