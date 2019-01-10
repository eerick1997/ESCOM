#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

#define MAX 100
#define TRUE 1
#define FALSE 0

typedef unsigned char boolean;

/*Se define como un elemento. 
Las variables pueden ser modificadas*/
typedef struct elemento
{
	char c;
	float n;
	int val;

	struct elemento *abajo;
}elemento;

/*Definición de pila*/
typedef struct pila
{
	elemento *tope;
}pila;

/*DECLARACIÓN DE FUNCIONES*/
void Initialize(pila *s);
void Push(pila *s,elemento e);
elemento Pop(pila *s);
boolean Empty(pila *s);

int main(void)
{
	int tamanioExpresion;
	char expresion[MAX];
	pila stack;
	elemento e;

	while(1)
	{
		Initialize(&stack);
		printf("Cadena: ");
		scanf("%s",expresion);

		tamanioExpresion = strlen(expresion);

		for (int i = 0; i < tamanioExpresion; i++)
		{
			if (expresion[i]=='(' || expresion[i]=='{' || expresion[i]=='[')
			{
				if(expresion[i]=='(')
					e.c = '(';
				if(expresion[i]=='{')
					e.c = '{';
				if(expresion[i]=='[')
					e.c = '[';
				
				Push(&stack,e);
			}
			else if (expresion[i]==')' || expresion[i]=='}' || expresion[i]==']')
			{
				if (Empty(&stack))
				{
					printf("Existen más parentesis que cierran de los que abren\n");
					exit(1);
				}
				e = Pop(&stack);
			}
		}

		if (!Empty(&stack))
		{
			printf("Existen más parentesis que cierran de los que abren\n");
			exit(1);		
		}

		printf("La expresion es correcta\n");
	}
}


/*METODOS*/

void Initialize(pila *s)
{
	s->tope=NULL;
	return;
}

void Push(pila *s, elemento e)
{
	elemento *ap;
	ap=(elemento*)malloc(sizeof(elemento));
	*ap=e;
	ap->abajo=s->tope;
	s->tope=ap;
}

elemento Pop (pila *s)
{
	elemento e, *ap;
	e=*(s->tope);
	ap=s->tope;
	//s->tope=s->tope->abajo;
	s->tope=(*s->tope).abajo;
	free(ap);
	return e;	
}

boolean Empty(pila *s)
{
	if(s->tope==NULL)
		return TRUE;
	return FALSE;	
}

