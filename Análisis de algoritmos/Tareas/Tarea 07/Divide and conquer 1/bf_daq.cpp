#include <bits/stdc++.h>
#define MIN -10e10

using namespace std;

typedef long long int lli;

vector<lli> v;

lli maxSubArray(lli begin, lli end){
    cout << "begin " << begin << " end " << end << endl;
    //Llegamos al caso base, solo hay un elemento en este rango
    if(end == begin)
        return v[begin];
    //Calculamos la mitad del arreglo
    lli middle = (begin + end) / 2;
    //Obtenemos la suma máxima del lado izquierdo
    lli left_max_sum = maxSubArray(begin, middle);
    //Obtenemos la suma máxima del lado derecho
    lli right_max_sum = maxSubArray(middle + 1, end);
    
    lli left_sum = MIN; 
    lli right_sum = MIN;
    lli sum = 0;

    for(lli i = middle + 1; i < end; i++){
        sum += v[i];
        right_sum = max(right_sum, sum);
    }
    sum = 0;
    for(lli i = begin; i < middle; i++){
        sum += v[i];
        left_sum = max(left_sum, sum);
    }
    lli ans = (lli)(max(left_max_sum, right_max_sum));
    return (lli)(max(ans, (left_sum + right_sum)));

}

int main(){
    lli N = 0;  
    cin >> N;
    for(lli i = 0; i < N; i++){
        lli a;
        cin >> a;
        v.push_back(a);
    }
    cout << "ans: " << maxSubArray(0, N - 1) << endl;
}