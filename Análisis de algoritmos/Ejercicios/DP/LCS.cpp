#include <bits/stdc++.h>

using namespace std;

string a, b;

int LCS(){
    int a_size = a.size();
    int b_size = b.size();
    int DP[a_size + 1][b_size + 1];

    for(int i = 0; i <= a_size; i++){
        for(int j = 0; j <= b_size; j++){
            if(i == 0 || j == 0)
                DP[i][j] = 0;
            else if(a[i-1] == b[j-1])
                DP[i][j] = DP[i-1][j-1] + 1;
            else
                DP[i][j] = max(DP[i-1][j], DP[i][j-1]);
        }
    }
    return DP[a_size][b_size];
}

int main(){
    cin >> a >> b;
    cout << LCS() << endl;
    return 0;
}