#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "headers/cipher.h"

void choose(int option);

int main(){
    int option;
    while(1){
        printf("\n - Please select an option - \n");
        printf("1. Ciphe plain text\n");
        printf("2. Decode ciphe text\n");
        printf("3. Brute force in ciphe text\n");
        printf("4. Exit\n");
        printf(" -> ");
        scanf("%d", &option);
        choose(option);
    }
    return 0;
}

void choose(int option){
    int k, i;
    char input[MAX_LENGTH];
    char *text_cipher, *plain_text;
    printf("\n");
    fflush(stdin);
    switch (option)
    {
        case 1:
            printf("Write the string to ciphe -> ");
            scanf("%[^\n]s", input);
            printf("Shift value -> ");
            scanf("%d", &k);
            text_cipher = cipher(input, k);
            printf("cipher text: %s \n", text_cipher);
            free(text_cipher);
        break;

        case 2:
            printf("Write the string to decode -> ");
            scanf("%[^\n]s", input);
            printf("Shift value -> ");
            scanf("%d", &k);
            plain_text = decoder(input, k);
            printf("plain text -> %s \n", plain_text);
            free(plain_text);
        break;

        case 3:
            printf("Write the string to decode -> ");
            scanf("%[^\n]s", input);
            for(i = 1; i < 26; i++){
                plain_text = decoder(input, i);
                printf("\n%d. plain text -> %s", i, plain_text);
                free(plain_text);
            }
            printf("\n");
        break;

        case 4:
            exit(0);
        break;

        default:
            printf("Option %d doesn't exist", option);
        break;
        printf("\n");
    }
}