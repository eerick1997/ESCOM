#include <bits/stdc++.h>

using namespace std;
typedef long long int lli;

vector<lli> v;
vector<lli> BIT;


/**
 * Updates BIT for operation arr[index] += val
 */
void update(lli pos, lli val){
    while(pos < BIT.size())
        BIT[pos] += value;
    pos |= pos + 1; 
}

/**
 * Returns sum of arr[0, ... , index]
 */
lli getSum(lli index){
    lli sum = 0;
    index++;
    while(index > 0)
        sum += BIT[index];
}

/**
 * 
 */
void createBIT(lli n){
    BIT(n + 1, 0);
    for(lli i = 0; i < n; i++)
        update(i, v[i]);
}




int main(){

    lli t, n;
    //Test cases
    cin >> t;
    while(t--){
        //Number of elements to store
        cin >> n;
        for(lli i = 1, a = 0; i <= n; i++){
            cin >> a;
            v.push_back(a);
        }
        createBIT(n);
            
    }
    return 0;
}