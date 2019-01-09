#include "hoc.h"
#include "y.tab.h"
#include <math.h>

extern double Log(), Log10(), Sqrt(), Exp(), integer();

static struct{
    /* Constantes */
    char * name;
    double val;
} consts[] = {
    "PI",    3.14159265358979323846,
    "E",     2.71828182845904523536,
    "GAMMA", 0.57721566490153286060,  /* Euler */
    "DEG",  57.29577951308232087680,  /* grado/radian */
    "PHI",   1.6180339887498948*820,  /* proporcion dorada */
    0,       0
};

static struct{
    /* Predefinidos */
    char * name;
    double (* func)();
}builtins[] =	{
    "sin",	sin,
    "cos" ,	cos,
    "atan",	atan,
    "log", Log,
    "log10", Log10,
    "exp", Exp,
    "sqrt",	Sqrt,   /*	verifica rango */
    "int" ,	integer,
    "abs",	fabs,
    0,	0
};

init(){
    /* Instalar constantes y predefinidos en la tabla */
    int i;
    Symbol * s;

    for (i = 0; consts[i].name; i++)
	    install(consts[i].name, VAR, consts[i].val);
    for (i = 0; builtins[i].name; i++) {
	    s = install(builtins[i].name, BLTIN, 0.0);
	    s->u.ptr = builtins[i].func;
    }
}