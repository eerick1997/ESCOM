#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "vector_cal.h"

/**
 * Esta función crea un vector de n dimensiones.
 * Pero para este caso nos conformaremos con 
 * crear vectores de a lo mucho 3 dimensiones.
 * @param: int n (dimensión del vector)
 * @return: vector* 
 * */
Vector* creaVector(int n){
   Vector* vec;
   vec=(Vector* )malloc(sizeof(Vector));
   vec->n = n;
   vec->vec = (double* )malloc(sizeof(double)*n);
   return vec;
}

/**
 * Esta función imprime los elementos que 
 * contiene el vector que es pasado como parámetro
 * @param: * vector
 * @return: nada    
 * */
void imprimeVector(Vector* v){
   int i;
   printf("[ ");
   for(i=0; i< v->n; i++)
      printf("%lf ", v->vec[i]);
   printf("]\n");
}

/**
 * Esta función copia el contenido de un vector
 * @param: *vector  
 * @return: *vector
 * */
void copiaVector(Vector* a, Vector* copy){
   int i = 0;
   copy = creaVector(a -> n);
   for(i = 0; i < a -> n; i++)
        copy -> vec[i] = a -> vec[i];
}

/**
 * Esta función suma dos vectores los cuales
 * recibe la función y retorna el nuevo
 * vector.
 * @param: *vector, *vector
 * @return: *vector
 * */
Vector* sumaVector(Vector* a, Vector* b){
    Vector* c;
    int i;
    c = creaVector(a->n);
    for(i=0; i< a->n;i++)
        c->vec[i]=a->vec[i]+b->vec[i];
    return c;
}

/**
 * Esta función resta dos vectores los cuales
 * recibe la función y retorna el nuevo
 * vector,
 * @param: *vector, *vector
 * @return: *vector
 * */
Vector* restaVector(Vector* a, Vector* b){
    Vector* c;
    int i;
    c=creaVector(a->n);
    for(i=0; i< a->n;i++)
       c->vec[i]=a->vec[i]-b->vec[i];
    return c;
}

/**
 * Esta función multiplica un escalar por
 * un vector.
 * @param: double, *vector
 * @return: vector
 * */
Vector* escalarVector(double c, Vector* v){
    printf("%lf", c);
    Vector* r_vector = creaVector(v -> n);
    int i;
    /*Iteramos mientras el índice sea menor que el tamaño
    del vector */
    for(i = 0; i < v -> n; i++){
        /*El vector resultante en su elemento i
         es igual al producto del escalar por el 
         vector recibido en el argumento en su
         posición i */
        r_vector -> vec[i] = c * v->vec[i];   
    }
  return r_vector;
}

/**
 * Esta función realiza el producto cruz de dos vectores
 * los cuales recibe la función. Además
 * retorna el nuevo vector calculado.
 * @param: *vector, *vector
 * @return: *vector
 * */
Vector* productoCruz(Vector* a, Vector* b){
  Vector* r;
  r = creaVector(a -> n);
  
  //Si el vector tiene una dimensión de dos
  if(a-> n == 2){
        r -> vec[0] = a -> vec[0] * b ->vec[1];
        r -> vec[1] -= a -> vec[1] * b -> vec[0]; 
    } 
    //Si el vector tiene una dimensión de tres
    else if(a -> n == 3){
        r -> vec[0] = a -> vec[1] * b -> vec[2] 
            - a -> vec[2] * b -> vec[1];
            
        r -> vec[1] = a -> vec[2] * b -> vec[0]
            - a -> vec[0] * b -> vec[2];
        
        r -> vec[2] = a -> vec[0] * b -> vec[1] 
            - a->vec[1] * b -> vec[0];
    }
    return r;
}

/**
 * Esta función realiza el producto punto entre dos vectores.
 * Como sabemos el producto punto entre dos vectores 
 * nos da como resultado un escalar. En este caso double
 * @param: *vector, *vector
 * @return: double
 * */
double productoPunto(Vector* a, Vector* b){
    double resultado = 0.0f;
    int i; 
    for(i = 0; i < a->n; i++){
        //Acumulamos el resultado del producto de cada componente
        resultado += ( a -> vec[i] * b->vec[i] );
    }
    return resultado;
}

/**
 * Esta función calcula la magnitud de un vector.
 * Recordemos que la magnitud de un vector es
 * igual ha el producto punto entre 
 * */
double vectorMagnitud(Vector* a){
    double resultado = 0.0f;
    int i;
    for(i = 0; i < a->n; i++){
        resultado += ( a -> vec[i] * a -> vec[i] );
    }
    return sqrt(resultado);
}