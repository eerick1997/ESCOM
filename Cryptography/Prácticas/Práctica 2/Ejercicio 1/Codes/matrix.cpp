/**
 * Author: Vargas Romero Erick Efraín
 * Last modification: 17 Febraury 2018
 **/
#include <bits/stdc++.h>
#include "../Headers/matrix.h"

using namespace std;

/**
 * This function build a random matrix of 3 per 3 elements
 * @param: none
 * @return: (Matrix) our possible key 
 **/
Matrix getMatrix(){
    Matrix matrix(3, vector<lli>(3));
    srand(time(NULL));
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++)
            matrix[i][j] = (rand() % LAN_SIZ);
    }
    return matrix;
}

/**
 * This function calculate the determinant of any n per n matrix (I hope)
 * @param: (Matrix) matrix, the matrix which we go to calculate it's determinant
 * @return: (lli) the determinant value 
 **/
lli determinant(Matrix &matrix){
    lli ans = 0;
    for(int i = 0; i < matrix.size(); i++)
        ans +=  ( ( !(i % 2) ? 1 : -1 ) * ( determinant(0, i, matrix, true) ) );
    return ans;
}

/**
 * This function calculates the determinant of a 2 per 2 matrix (base case)
 * @param: (int) k, column which we go to ignore
 * @param: (int) l, row which we go to ignore
 * @param: (Matrix) matrix, matrix which we go to calculate it's determinant
 * @param: (bool) cof, if we need multiply each matrix with a coeficient we 
 *                can do it making this value true
 * @return: (lli) the determinant value
 **/
lli determinant(int k, int l, Matrix &matrix, bool cof){
    lli det = 0;
    vector<lli> ns;
    for(int i = 0; i < matrix.size(); i++){
        for(int j = 0; j < matrix[i].size(); j++){
            if(i != k && j != l)
                ns.push_back( matrix[i][j] );
        }
    }
    det = ns[0]*ns[3] - ns[1]*ns[2];
    return ( (det) * ( ( cof ) ? matrix[k][l] : 1 ) );
}

/**
 * This function multiply an escalar and a matrix
 * @param: (lli) escalar
 * @param: (Matrix) matrix
 * @return: (Matrix)
 **/
Matrix escalarMatrix(lli escalar, Matrix matrix){
    for(int i = 0; i < matrix.size(); i++)
        for(int j = 0; j < matrix[i].size(); j++)
            matrix[i][j] = mod( (escalar * matrix[i][j]), LAN_SIZ);
    return matrix; 
}

/**
 * This function gets an adjoint matrix
 * @param: (Matrix) matrix, matrix which we go to get the adjoint
 * @return: (Matrix) the adjoint matrix 
 **/
Matrix getAdjMatrix(Matrix &matrix){
    int n = matrix.size();
    Matrix adj(n, vector<lli>(n, 0));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            lli det = determinant(i, j, matrix, false);
            short sign = ( !((i + j) % 2)) ? 1 : -1 ;
            adj[i][j] = mod( (sign * det) , LAN_SIZ); 
        }
    }
    adj = getTraMatrix(adj);
    return adj;
}

/**
 * This function gets the transpose of any matrix
 * @param: (Matrix) matrix, which we go to get the transpose
 * @return: (Matrix) Transpose matrix
 **/
Matrix getTraMatrix(Matrix &matrix){
    lli size = matrix.size();
    Matrix traMatrix (size, vector<lli>(size, 0));
    for(int i = 0; i < size; i++)
        for(int j = 0; j < size; j++)
            traMatrix[i][j] = matrix[j][i];

    return traMatrix;
}

/**
 * This function help us to know if the matrix that we read by a file
 * has the size that we need
 * @param: (Matrix) matrix
 * @param: (int) size
 * @return: (Matrix) 
 **/
Matrix validMatrixBySize(Matrix &matrix, int size){
    Matrix n_matrix (size, vector<lli>(size, 0));
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++)
            n_matrix[i][j] = matrix[i][j];
    }
    return n_matrix;
}

/**
 * This function verify if the matrix is valid to 
 * use it as a key
 * @param: (lli) determinant
 * @param: (lli) gcd
 * @return: (bool) if has inverse return true
*/
bool validKey(lli determinant, lli gcd){
    return (determinant > 0 && gcd == 1);
}

void print(Matrix &matrix){
    for(int i = 0; i < matrix.size(); i++){
        cout << endl;
        for(int j = 0; j < matrix[i].size(); j++){
            cout << /*"[" << i << "][" << j << "]" << " ";*/ matrix[i][j] << " - ";
        }   
    }
    cout << endl;
}