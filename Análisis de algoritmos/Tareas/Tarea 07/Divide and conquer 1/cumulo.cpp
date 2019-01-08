#include <bits/stdc++.h>

using namespace std;

struct point{
    float x;
    float y;
};

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


float distancePoints(point p, point q){
    cout << " distancePoints " << endl;
    return sqrt((p.x - q.x)*(p.x - q.x) + (p.y - q.y)*(p.y - q.y));
}

float compareAll(int begin, int end){
    cout << "compareAll begin " << begin << " end " << end << endl;
    float min_dist = FLT_MAX;
    float distance = 0;

    for(int i = 0; i < points.size(); i++)
        cout << "p (" << points[i].x << "," << points[i].y << ")" << endl;

    for(int i = begin; i < end; i++){

        for(int j = i + 1; j < end; j++){
            cout << "(" << i << "," << j << ")" << endl;
            //cout << "p (" << points[i].x << "," << points[i].y << ")" << endl;
            //cout << "q (" << points[j].x << "," << points[j].y << ")" << endl;
            
        }
    }
    cout << min_dist << endl;
    return min_dist;
}

float stripClosest(int begin, int end, int minimum){
    cout << "stripClosest begin " << begin << " end " << end << endl;
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
    cout << "closest begin " << begin << " end " << end << endl;
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

float closestPairOfPoints(vector<point>& points, int size){
    //Ordering each star by x
    qsort(&points, size, sizeof(points), orderByX);
    return closest(0, size);
}

int main(){
    int n;
    cin >> n;

    vector<point> points;
    vector<point> strip;

    for(int i = 0; i < n; i++){
        point p;
        point sp;
        sp.x = 0, sp.y = 0;
        cin >> p.x >> p.y;
        points.push_back(p);
        strip.push_back(sp);
    }
    cout << std::fixed << std::setprecision(3) << closestPairOfPoints(points, n) << endl;
    return 0;
}