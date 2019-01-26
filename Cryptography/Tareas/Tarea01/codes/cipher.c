#include "../headers/cipher.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

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
            //printf("\n%d -> %c ", c[i], c[i]);
            if('a' <= c[i] && c[i] <= 'z'){
                c[i] = ((c[i] + k) % ('z' + 1));
                if( !('a' <= c[i] && c[i] <= 'z') ) 
                    c[i] = 'a' + c[i];
            }
            else if('A' <= c[i] && c[i] <= 'Z'){
                c[i] = ((c[i] + k) % ('Z' + 1));
                if( !('A' <= c[i] && c[i] <= 'Z') ) 
                    c[i] = 'A' + c[i];
            }
            //printf("%d -> %c", c[i], c[i]);
            
        }
    }
    //printf("\n--------------");
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
            //printf("\n%d -> %c ", m[i], m[i]);
            if('a' <= c[i] && c[i] <= 'z'){
                m[i] = abs((m[i] - k) % ('z' + 1));
                if( !('a' <= m[i] && m[i] <= 'z') ) 
                    m[i] = ('z' + 1) - abs('a' - m[i]);
            } else if('A' <= c[i] && c[i] <= 'Z'){
                m[i] = abs((m[i] - k) % ('Z' + 1));
                if( !('A' <= m[i] && m[i] <= 'Z') ) 
                    m[i] = ('Z' + 1) - abs('A' - m[i]);
            }
            //printf("%d -> %c", m[i], m[i]);
        }
    }
    //printf("\n--------------\n");
    plain_text = malloc(sizeof(char)*size);
    strcpy(plain_text, m);
    //printf("\n%s\n", m);
    return plain_text;   
}