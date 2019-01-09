struct vector {
	char name;
	int n;
	double* vec;
};
typedef struct vector Vector;
//Creación de un vector
Vector* creaVector(int n);
//Impresión de un vector
void imprimeVector(Vector* a);
//Copiado de vectores
void copiaVector(Vector* a, Vector* copy);
//Suma de vectores
Vector* sumaVector(Vector* a, Vector* b);
//Resta de vectores
Vector* restaVector(Vector* a, Vector* b);
//Multiplica un vector por un escalar
Vector* escalarVector(double c, Vector* v);
//Producto cruz entre dos vectores
Vector* productoCruz(Vector* a, Vector* b);
//Producto punto entre vectores
double productoPunto(Vector* a, Vector* b);
//Cálculo de la magnitud de un vector
double vectorMagnitud(Vector* a);