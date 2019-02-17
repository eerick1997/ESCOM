#include<bits/stdc++.h>
#include "../Headers/cipher.h"

using namespace std;
typedef long long int lli;
typedef vector< vector<lli> > Matrix;

Matrix getMatrix();
short mod (lli n, lli m);
void print(Matrix &matrix);
lli determinant(Matrix &matrix);
Matrix getTraMatrix(Matrix &matrix);
Matrix getAdjMatrix(Matrix &matrix);
bool validKey(lli determinant, lli inverse);
Matrix escalarMatrix(lli escalar, Matrix matrix);
Matrix validMatrixBySize(Matrix &matrix, int size);
lli determinant(int k, int l, Matrix &matrix, bool cof);