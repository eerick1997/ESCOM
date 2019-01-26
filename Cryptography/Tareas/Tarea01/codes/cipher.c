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
            printf("\n%d -> %c ", c[i], c[i]);
            if('a' <= c[i] && c[i] <= 'z'){
                c[i] = ((c[i] + k) % 'z');
                if( !('a' <= c[i] && c[i] <= 'z') ) 
                    c[i] += 'a' - 1;
            }
            else if('A' <= c[i] && c[i] <= 'Z'){
                c[i] = (c[i] + k) % 'Z';
            }
            printf("%d -> %c", c[i], c[i]);
        }
    }
    printf("\n--------------");
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
            printf("\n%d -> %c ", m[i], m[i]);
            if('a' <= c[i] && c[i] <= 'z'){
                m[i] = abs((m[i] - k) % 'z');
                if( !('a' <= m[i] && m[i] <= 'z') ) 
                    m[i] = 'z' - ('a' - m[i]) + 1;
            } else if('A' <= c[i] && c[i] <= 'Z')
                m[i] = abs((m[i] - k) % 'Z');
            printf("%d -> %c", m[i], m[i]);
        }
    }
    printf("\n--------------\n");
    plain_text = malloc(sizeof(char)*size);
    strcpy(plain_text, m);
    return plain_text;   
}