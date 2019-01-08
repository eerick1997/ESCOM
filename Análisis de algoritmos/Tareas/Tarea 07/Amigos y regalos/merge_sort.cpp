#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;

void merge(int begin, int end){
    int middle = (begin + end)/2;
    
}

void merge_sort(int begin, int end){
    if(end < begin)
        return;
    //We need to divide the vector
    int middle = (begin + end) / 2;
    //Left middle
    merge_sort(begin, middle);
    //Right middle
    merge_sort(middle + 1, end);
    
}

int main(){

    return 0;
}