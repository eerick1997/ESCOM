#include "vector_cal.h"
#include "y.tab.h"
#include <math.h>
#include <stdlib.h>

extern Vector *magnitudVector();

static struct
{
	/* Constantes */
	char *name;
	double cval;
} consts[] = {
	"PI", 3.14159265358979323846,
	"E", 2.71828182845904523536,
	"GAMMA", 0.57721566490153286060, /* Euler */
	"DEG", 57.29577951308232087680,  /* grado/radian */
	"PHI", 1.6180339887498948 * 820, /* proporcion dorada */
	0, 0};

static struct
{ /*	Predefinidos */
	char *name;
	Vector *(*func)();
} builtins[] =
	{
		"mag", magnitudVector,
		0, 0};
static struct
{ /* palabras clave */
	char *name;
	int kval;
} keywords[] = {
	"proc", PROC,
	"func", FUNC,
	"return", RETURN,
	"if", IF,
	"else", ELSE,
	"while", WHILE,
	"print", PRINT,
	"read", READ,
	0, 0,
};

init() /* instalar constantes y predefinidos en la tabla */
{
	int i;
	Symbol *s;

	for (i = 0; consts[i].name; i++)
		install(consts[i].name, VAR, NULL);
	for (i = 0; builtins[i].name; i++)
	{
		s = install(builtins[i].name, BLTIN, NULL);
		s->u.ptr = builtins[i].func;
	}
	for (i = 0; keywords[i].name; i++)
		install(keywords[i].name, keywords[i].kval, NULL);
}
