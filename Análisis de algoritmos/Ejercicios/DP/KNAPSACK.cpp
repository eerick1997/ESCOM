#include <bits/stdc++.h>

using namespace std;

struct Item{
    int S;
    int V;
};

vector< Item > items;

int KNAPSACK(int S){
    int size = items.size();
    int DP[size + 1][S + 1];
    //From the 0 to n item iterate
    for(int i = 0; i <= size; i++){
        //From the 0 size to S size iterate
        for(int curr_s = 0; curr_s <= S; curr_s++){
            if(i == 0 || curr_s == 0)
                DP[i][curr_s] = 0;
            //I can put an item in the backpack
            else if(items[i - 1].S <= curr_s){
                DP[i][curr_s] = max( (items[i - 1].V + DP[i-1][curr_s-items[i-1].S]), DP[i-1][curr_s] );
            } else {
                DP[i][curr_s] = DP[i-1][curr_s];
            }
        }
    }
    return DP[size][S];
}

int main(){
    int S, N;
    cin >> S >> N;
    while(N--){
        Item item;
        cin >> item.S >> item.V;
        items.push_back(item);
    }
    cout << KNAPSACK(S) << endl;
    return 0;
}