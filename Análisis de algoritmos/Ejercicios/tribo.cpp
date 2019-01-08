#include <iostream>

using namespace std;

int tribo(int n){
    return ( n < 3)? n : (tribo(n-1) + tribo(n-2) + tribo(n-3));
}

int main(){
    int a;
    cin>>a;
    cout<<tribo(a)<<endl;
    return 0;
}