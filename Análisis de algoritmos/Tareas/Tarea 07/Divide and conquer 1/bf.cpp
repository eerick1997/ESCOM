#include <bits/stdc++.h>
#define MIN -10e10

using namespace std;

typedef long long int lli;
vector<lli> A;

int main() {

    lli N, ans = MIN, sum = 0;
    cin >> N;

    while(N--){
        lli A_i;
        cin >> A_i;
        A.push_back(A_i);
    }

    for(int i = 0; i < A.size(); i++){

        for(int j = i; j < A.size(); j++){

            for(int k = i; k <= j; k++){
                sum += A[k];
            }
            if(ans < sum)
                ans = sum;
            sum = 0;
        }
    }

    cout << ans << endl;

    return 0;
}