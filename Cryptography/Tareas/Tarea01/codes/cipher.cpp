#include "../headers/cipher.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <ctype.h>

/**
 * This function creates a ciphertext
 * @param: char* m, the plain text
 * @param: int shift, our k value
 * @return: char*, ciphertext
 * **/
char *cipher(char *m, int k){
    int size = strlen(m);
    int i;
    char c[ size ];
    char *text_cipher;
    strcpy(c, m);
    for(i = 0; i < size; i++){
        if(c[i] != ' '){
            if(islower(c[i])){
                c[i] = ((c[i] + k - 'a') % (26)) + 'a';
            }
            else if(isupper(c[i])){
                c[i] = ((c[i] + k - 'A') % (26) + 'A');
            }
        }
    }
    text_cipher = malloc(sizeof(char)*size);
    strcpy(text_cipher, c);
    return text_cipher;   
}

/**
 * This function decode ciphertext
 * @param: char* m, the ciphertext
 * @param: int shift, our k value
 * @return: char*, plain text
 * **/
char *decoder(char *c, int k){
    int size = strlen(c);
    int i;
    char m[ size ];
    char *plain_text;
    strcpy(m, c);
    for(i = 0; i < size; i++){
        if(m[i] != ' '){
            if(islower(c[i])){
                m[i] = ((m[i] - k - 'a') % (26)) + 'a';
                if(!islower(m[i])) 
                    m[i] = 'z' - ('z' - m[i]);
            } else if(isupper(c[i])){
                m[i] = ((m[i] - k - 'A') % (26)) + 'A';
                if(!isupper(m[i]))
                    m[i] = 'Z' - ('Z' - m[i]);
            }
        }
    }
    plain_text = malloc(sizeof(char)*size);
    strcpy(plain_text, m);
    return plain_text;   
}