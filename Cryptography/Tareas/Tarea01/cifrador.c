#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "headers/cipher.h"

int main(){
    char input[MAX_LENGTH];
    char *text_cipher, *plain_text;
    int k;
    printf("Write the string to ciphe: ");
    scanf("%[^\n]s", input);
    printf("Shift value: ");
    scanf("%d", &k);
    text_cipher = cipher(input, k);
    plain_text = decoder(text_cipher, k);
    printf("cipher text: %s\n", text_cipher);
    printf("plain text: %s\n", plain_text);
    return 0;
}