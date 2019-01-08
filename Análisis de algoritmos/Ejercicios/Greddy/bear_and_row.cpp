#include <bits/stdc++.h>

using namespace std;

typedef long long int lli;
string s;

lli bear_and_row(){
    
    lli ans = 0, count = 0;
    lli size = s.length();
    lli i = 0, j = 0;
    while(i < size){
        //Moving 'til find a one
        while(s[i] == '0' && i < size){
            i++;
            if(i == size)
                break;
        }

        //We found a one
        if(s[i] == '1' && i < size)
            ans += count + count *(i - j - 1);
        
        //We move 'til find a zero
        while(s[i] == '1' && i < size){
            //Counting ones
            count++;
            //Moving the index
            i++;
            if(i == size)
                break;
        }
        //We have more elements in the array
        if(i < size)
            j = i - 1;
    }
    if(s[size - 1] == '0')
        ans += count + count * (i - j - 1);
    return ans;
}

int main(){
    lli T;
    cin >> T;
    while(T--){
        cin >> s;
        cout << bear_and_row() << endl;
    }
    return 0;
}