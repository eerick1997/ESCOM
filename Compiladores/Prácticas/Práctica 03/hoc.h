#include "vector_cal.h"
typedef struct Symbol { /* entrada de la tabla de s�mbolos */
	char   *name;
	short   type;   /* VAR, BLTIN, UNDEF */
	union {
		double comp;	       /* si es VAR */
		double  (*ptr)();      /* s� es BLTIN */
		Vector* vec;
	} u;
	struct Symbol   *next;  /* para ligarse a otro */ 
} Symbol;

Symbol *install(char *s,int t, Vector *vec), *lookup(char *s);