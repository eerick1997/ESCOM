#include <math.h>
#include <errno.h>
#include "vector_cal.h"

extern int errno;
double errcheck();

Vector *magnitudVector(Vector *c)
{
	Vector *v;
	v = creaVector(1);
	double x = c->vec[0] * c->vec[0];
	double y = c->vec[1] * c->vec[1];
	double z = c->vec[2] * c->vec[2];
	v->vec[0] = sqrt(x + y + z);

	return v;
}

double errcheck(double d, char *s) /* revisar el resultado de la llamada
                                        a la biblioteca */
{
	if (errno == EDOM)
	{
		errno = 0;
		execerror(s, "argument out of donain");
	}
	else if (errno == ERANGE)
	{
		errno = 0;
		execerror(s, "result out of range");
	}
	return d;
}
