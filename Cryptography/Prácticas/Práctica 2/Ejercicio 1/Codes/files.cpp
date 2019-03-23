/**
 * Author: Vargas Romero Erick Efraín
 * Last modification: 17 Febraury 2019
 **/
#include <bits/stdc++.h>
#include "../Headers/files.h"

using namespace std;
/**
 * This function gets the content of a text file
 * @param: none
 * @return: (string) the content of our file in a string
 * **/
string read_file(string &name_file){
    string file_name, str = "", line = "";
    ifstream input_file;
    cin.ignore();
    cout << "Write the file path -> ";
    getline(cin, file_name);
    name_file = file_name;
    input_file.open(file_name.c_str(), ios::in);
    if(input_file.is_open()){
        while(!input_file.eof()){
            getline(input_file, line);
            str += line;
        }
        input_file.close();
    } else
        cout << "\nFile doesn't exist or you're not allowed to open it" << endl;
    
    return str;
}

/**
 * This function gets the content of a text file, this content
 * will be a matrix which we go to use as a key to ciphe or 
 * decrypt a cipher text or plain text
 * @param: none
 * @return: (Matrix) Our key
 * **/
Matrix get_matrix_file(){
    Matrix matrix;
    vector<string> content;
    vector<lli> row;
    string file_name, line = "", number = "";
    ifstream input_file;
    cin.ignore();
    cout << "Write the file path where the matrix is -> ";
    getline(cin, file_name);
    input_file.open(file_name.c_str(), ios::in);
    if(input_file.is_open()){
        while(!input_file.eof()){
            getline(input_file, line);
            content.push_back(line);
        }
        input_file.close();
    } else
        cout << "\nFile doesn't exist or you're not allowed to open it" << endl;
    
    
    for(int i = 0, j; i < content.size(); i++){
        for(j = 0; j < content[i].size(); j++){
            if(isdigit(content[i][j]))
                number += content[i][j];
            else {
                row.push_back((lli)(stoi(number)));
                number = "";
            }
        }
        if(number != ""){
            row.push_back((lli)(stoi(number)));
            number = "";
        }
        matrix.push_back(row);
        row.clear();
    }
    return matrix;
}

/**
 * This function creates a file
 * @param: (string) content file
 * @param: (string) file name
 * @return: nothing
 * **/
void out_file(string str, string file_name){
    ofstream output_file(file_name);
    output_file << str << endl;
    output_file.close();
}

/**
 * This function creates a file which contains a
 * matrix, this matrix is our key
 * @param: (Matrix) The matrix to store
 * @param: (string) file name
 * @return: nothing
 * **/
void out_file_matrix(Matrix matrix, string file_name){
    ofstream output_file(file_name);
    for(int i = 0; i < matrix.size(); i++){
        for(int j = 0; j < matrix[i].size(); j++)
            output_file << matrix[i][j] << " ";
        output_file << endl;
    }
    output_file.close();
}