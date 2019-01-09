#include <stdio.h>
#include "vector_cal.h"
#include <ctype.h>
#include <stdlib.h>
#include <math.h>

Vector *creaVector(int n)
{
    Vector *vec;
    int i;
    vec = (Vector *)malloc(sizeof(Vector));
    vec->n = n;
    vec->vec = (double *)malloc(sizeof(double) * n);
    //printf("Vector creado");
    return vec;
}

void imprimeVector(Vector *v)
{
    int i;
    printf("[");
    for (i = 0; i < v->n; i++)
        printf("%f ", v->vec[i]);
    printf("]\n");
}

Vector *copiaVector(Vector *v)
{
    int i;
    Vector *copy = creaVector(v->n);
    for (i = 0; i < v->n; i++)
        copy->vec[i] = v->vec[i];
    return copy;
}

Vector *sumaVector(Vector *a, Vector *b)
{
    Vector *c;
    int i;
    c = creaVector(a->n);
    for (i = 0; i < a->n; i++)
        c->vec[i] = a->vec[i] + b->vec[i];

    // printf("Suma realizada");
    return c;
}

Vector *restaVector(Vector *a, Vector *b)
{
    Vector *c;
    int i;
    c = creaVector(a->n);
    for (i = 0; i < a->n; i++)
        c->vec[i] = a->vec[i] - b->vec[i];
    return c;
}

Vector *multiplicaVector(Vector *a, Vector *b)
{
    Vector *c;
    int i;
    c = creaVector(1);
    c->vec[0] = a->vec[0] * b->vec[0] + a->vec[1] * b->vec[1] + a->vec[2] * b->vec[2];
    return c;
}

Vector *vectorEscalar(Vector *a, double escalar)
{
    Vector *c;
    int i = 0;
    c = creaVector(a->n);
    for (; i < a->n; i++)
        c->vec[i] = escalar * a->vec[i];

    return c;
}

Vector *productoCruz(Vector *a, Vector *b)
{
    Vector *c;
    c = creaVector(a->n);

    if (a->n == 2)
    {
        c->vec[0] = a->vec[0] * b->vec[1];
        c->vec[1] = -(a->vec[1] * b->vec[0]);
    }
    else if (a->n == 3)
    {
        c->vec[0] = a->vec[1] * b->vec[2] - a->vec[2] * b->vec[1];
        c->vec[1] = a->vec[2] * b->vec[0] - a->vec[0] * b->vec[2];
        c->vec[2] = a->vec[0] * b->vec[1] - a->vec[1] * b->vec[0];
    }

    return c;
}

/*
Vector *multiVector(Vector *a, Vector *b){
Vector *c;
int i,j, k; 
double acu;
        c=creaVector(a->n);
	for(i=0; i< a->n;i++)
		for(j=0; j < a->n;j++){
			acu=0;
			for(k=0; k < a->n;k++){
                         
				acu=acu+a->mat[i][k]*b->mat[k][j];
				//printf("<%f,%f,%f> ",a->mat[i][k],b->mat[k][j],acu);
                        }             
                        //printf("\n");
			c->mat[i][j]=acu;
		}
	return c;
}*/
