#include <bits/stdc++.h>
#define MAX 50005
using namespace std;

struct point{
    float x;
    float y;
};

vector< point > points(MAX);
vector< point > strip(MAX);

float distancePoints(point p, point q){
    return sqrt(pow(p.x - q.x, 2) + pow(p.y - q.y, 2));
}

int orderByX(const void *a, const void *b){
    point *p = (point *)a;
    point *q = (point *)b;
    return (p->x - q->x);
}

int orderByY(const void *a, const void *b){
    point *p = (point *)a;
    point *q = (point *)b;
    return (p->y - q->y);
}

float compareAll(int begin, int end){
    float min_dist = FLT_MAX;
    for(int i = begin; i < end; i++){
        for(int j = i + 1; j < end; j++){
            float distance = distancePoints(points[i], points[j]);
            min_dist = min(distance, min_dist);
        }
    }
    return min_dist;
}

float stripClosest(int begin, int end, int minimum){
    float ans = minimum;
    qsort(&strip, end, sizeof(point), orderByY);
    for(int i = begin; i < end; i++){
        for(int j = i + 1; j < end; j++){
            ans = min(distancePoints(strip[i], strip[j]), ans);
        }
    }
    return ans;
}

//Getting the closest distance between points
float closest(int begin, int end){
    if((end - begin) <= 3)
        return compareAll(begin, end);
    int middle  = (begin + end) >> 1;

    float distance_left = closest(begin, middle);
    float distance_right = closest(middle + 1, end);
    float minimum = min(distance_left, distance_right);
    int position = begin;
    for(int i = begin; i < end; i++){
        if(fabs(points[i].x - points[middle].x) < minimum)
            strip[position++] = points[i];
    }
    return min(minimum, stripClosest(begin, position, minimum));
}

float closestPairOfPoints(int size){
    //Ordering each star by x
    qsort(&points, size, sizeof(points), orderByX);
    return closest(0, size);
}

int main(){
    int n;
    cin >> n;
    for(int i = 0; i < n; i++){
        point p;
        cin >> p.x >> p.y;
        points[i] = p;
    }
    cout << std::fixed << std::setprecision(3) << closestPairOfPoints(n) << endl;
    return 0;
}