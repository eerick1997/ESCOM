#include <bits/stdc++.h>

using namespace std;

typedef long long int lli;
vector<lli> v;
vector<lli> BIT;

void update(lli index, lli val){
    //Index can't be bigger than our BIT
    while(index <= BIT.size()){
        BIT[index] += val;
        index += index & (-index);
    }
}

void create(lli size){
    BIT(size + 1, 0);
    for(lli i = 1; i <= size; i++){
        update(i, v[i]);
    }
}

lli getSum(lli index){
    lli sum = 0;
    while(index > 0){
        sum += BIT[index];
        index -= index & (-index);
    }
    return sum;
}

lli getInversions(lli size){
    lli inversionCount = 0;

    for()

    return inversionCount;
}

int main(){
    lli t, n;v
    cin >> t;
    //Test cases
    while(t--){
        cin >> n;
        v(n + 1, 0);
        for(int i = 1; i <= n; i++){
            cin >> v[i];
        }
        create(n);
        cout << getInversions(n);
    }
    return 0;
}