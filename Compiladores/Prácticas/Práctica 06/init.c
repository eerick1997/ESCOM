#include "hoc.h"
#include "y.tab.h"
#include <math.h>

static struct { 
    char   *name;	/* Palabras clave */
    int    kval;
} keywords[] = {
    "if",		IF,
    "else" ,	ELSE,
    "while",	WHILE,
    "print",	PRINT,
    //Añadida en la práctica 6
    "for",      FOR,
    0,      0,
};

int init(){ /* Se instalan las constantes y predefinidos en la tabla */
    int i;
    Symbol * s;
    for (i = 0; keywords[i].name; i++)
	    install(keywords[i].name, keywords[i].kval, NULL);
}