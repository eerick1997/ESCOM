#include <stdio.h>

#define SIZE_MAT 3

typedef struct matrix{
	int position[SIZE_MAT][SIZE_MAT];
}matrix;

matrix matrix_1;

void fillFirstMatrix();
void printFirstMatrix();

int main(void){
	fillFirstMatrix();
	printFirstMatrix();
}

void fillFirstMatrix(){
	int i,j;
	for(i = 0; i < SIZE_MAT; i++){
		for(j = 0; j < SIZE_MAT; j++){
			printf("Ingresa el elemento [%d][%d]\n", i, j);
			scanf("%d", &matrix_1.position[i][j]);
		}
	}
}

void printFirstMatrix(){
	int i,j;
	for(i = 0; i < SIZE_MAT; i++){
		for(j = 0; j < SIZE_MAT; j++){
			printf("%d\t", matrix_1.position[i][j]);
		}
		printf("\n");
	}
}