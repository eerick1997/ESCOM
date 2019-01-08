#include <bits/stdc++.h>
using namespace std;

typedef long long int lli;
vector<lli> v;
lli k = 0;

lli merge(lli begin, lli middle, lli end){
    if(begin == middle){
        if(v[begin] > v[end]){
            return 1;
            k++;
        }
        
    }

    lli count = 0;
    for(int i = begin; i <= middle; i++){
        for(int j = middle + 1; j <= end; j++){
            if(v[i] > v[j])
                count++;
            k++;
        }
    }
    return count;
}

lli mergeSort(lli begin, lli end){
    lli middle = (begin + end) >> 1;
    lli count = 0;
    if(end <= begin)
        return 0;
    count += mergeSort(begin, middle);
    count += mergeSort(middle + 1, end);
    count += merge(begin, middle, end);
    return count;
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie();
    int t, n;
    cin >> t;
    while(t--){
        cin >> n;
        while(n--){
            lli a;
            cin >> a;
            v.push_back(a);
        }
        cout << mergeSort(0, v.size() - 1) << endl;
        cout << k << endl;
        v.clear();
    }
    return 0;
}