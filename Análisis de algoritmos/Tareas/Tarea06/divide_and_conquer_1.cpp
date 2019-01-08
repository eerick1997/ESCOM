#include <bits/stdc++.h>

using namespace std;

typedef long long int lli;

vector<lli> v;

int main(){
	lli n, min = -10e10;
	cin>>n;
	while(n--){
		lli a;
		cin>>a;
		v.push_back(a);
	}

	//Hacemos el barrido acumulativo
	for(int i = 1; i < v.size(); i++){
		v[i] += v[i - 1]; 
	}

	for(int i = 0; i < v.size(); i++){
		for(int j = i; j < v.size(); j++)
			if( (v[j] - v[i]) > min )
				min = v[j] - v[i];
	}

	cout<<min<<endl;
	

	return 0;
}