#include <iostream>
#include <vector>

using namespace std;

typedef long long int lli;
vector<lli> v(10000000 + 2, 0);
vector<lli> v_s(10000000 + 2, 0);

lli merge(lli begin, lli middle, lli end){
    lli count = 0;
    //We need to move inside the array so, we need to copy the information given
    lli left = begin;
    lli center = middle;
    lli index = begin;
    //We need to sort the array
    while( (left <= middle - 1) && (center <= end) ){
        //It's just a swap  
        if(v[left] <= v[center])
            v_s[index++] = v[left++];
        else {
            v_s[index++] = v[center++];
            count += (middle - left);
        }
    }

    while(left <= middle - 1)
        v_s[index++] = v[left++];

    while(center <= end)
        v_s[index++] = v[center++];  
        
    for(lli i = begin; i <= end; i++)
        v[i] = v_s[i];

    return count;
}

lli mergeSort(lli begin, lli end){
    lli middle = (begin + end) / 2;
    lli count = 0;
    if(begin < end){
        count += mergeSort(begin, middle);
        count += mergeSort(middle + 1, end);
        count += merge(begin, middle + 1, end);
    }
    return count;
}

int main(){
    lli t, n;
    cin >> t;
    while(t--){
        cin >> n;
        for(lli i = 0, a = 0; i < n; i++)
            cin >> v[i];
        cout << mergeSort(0, n - 1) << endl;
    }
    return 0;
}