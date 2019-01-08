#include <bits/stdc++.h>

using namespace std;

vector<int> numbers;

int ELIS(){

    int size = numbers.size();
    int ans = -1;
    vector< int > DP(size, 1);

    for(int i = 1; i < size; i++){
        for(int j = 0; j < i; j++){
            if(numbers[i] > numbers[j])
                DP[i] = max(DP[i], DP[j] + 1);
        }
    }    
    for(int i = 0; i < size; i++)
        ans = max(ans, DP[i]);

    return ans; 
}

int main(){
    int n;
    cin >> n;
    while(n--){
        int a;
        cin >> a;
        numbers.push_back(a);
    }
    cout << ELIS()<< endl;
    return 0;
}