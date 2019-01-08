#include <bits/stdc++.h>
//Inversion count
using namespace std;

typedef long long int lli;

lli ans;
vector<lli> v;

void inversionCount(int begin, int end){
    lli range = (end - begin);
    //We have just an elemento or two
    if(range <= 2){

    } else {
        lli midle = (begin + end) / 2;
        inversionCount(begin, midle);
        inversionCount(midle + 1, begin);
    }
}

int main(){
    lli t;
    cin>>t;
    while(t--){
        lli n;
        cin>>n;
        while(n--){
            lli a;
            cin>>a;
            v.push_back(a);
        }
        v.clear();
    }    
}