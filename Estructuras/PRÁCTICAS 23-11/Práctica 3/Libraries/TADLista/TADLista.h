/*
IMPLEMENTACIONES DEL TAD LISTA (TADLista.h)
AUTOR: Edgardo Adrián Franco Martínez (C) Abril 2011
VERSIÓN: 1.0

DESCRIPCIÓN: TAD lista o (list)
Estructura de datos en la que se cumple:
Los elementos se consultan, añaden y se remueven con base en posiciones
dentro de un arreglo lineal el cual cuenta con un frente o cabeza
y un final o cola.

OBSERVACIONES: Este archivo solo incluye las estructuras, tipos de datos y
declaración de las operaciones del TAD  Lista.

EL CODIGO QUE IMPLEMENTA LAS FUNCIONES ES EL ARCHIVO: TADLista.c
*/
//DECLARACIONES
#define TRUE	1
#define FALSE	0

#define ADELANTE	1
#define ATRAS		0



//Estructura elemento (Modificable por el usuario)
typedef struct elemento
{
	char p[100];
	char d[500];
}elemento;

//Tipo de dato boolean (Modelado con un char)
typedef char boolean;

//Estructura de un NODO DOBLEMENTE LIGADO(No modificar)
typedef struct nodo
{
	elemento e;
	struct nodo *adelante;
	struct nodo *atras;

}nodo;

/*
IMPLEMENTACIONES DE LA LIBRERIA DEL TAD LISTA (TADLista.h)
AUTOR: Edgardo Adrián Franco Martínez (C) Octubre 2016
VERSIÓN: 1.0

DESCRIPCIÓN: TAD lista o (list)
Estructura de datos en la que se cumple:
Los elementos se consultan, añaden y se remueven con base en posiciones
dentro de un arreglo lineal el cual cuenta con un frente o cabeza
y un final o cola.

OBSERVACIONES: Hablamos de una Estructura de datos dinámica de una lista
doblemente ligada.

Frente                                                       Final
      ******    ******    ******    ******    ******    ******
NULL<-*    * <- *    * <- *    * <- *    * <- *    * <- *    *
      * e1 *    * e2 *    * e3 *    * e4 *    * e5 *    * e6 *
      *    * -> *                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      * -> *    * -> *    * -> *    * -> *    * -> NULL
      ******    ******    ******    ******    ******    ******


COMPILACIÓN PARA GENERAR EL CÓDIGO OBJETO: gcc -c TADLista.c
*/
//Declaracion de un struct lista
typedef struct lista
{
    //Contiene un nodo para el frente y otro para el final, adema de un int
	nodo *frente;
	nodo *final;
	int tam;
}lista;
//Declaracion de un nodo posicion
typedef nodo* posicion;

//Operaciones de construcción
void Initialize(lista *l);
void Destroy(lista *l);
//Operaciones de posicionamiento y busqueda
posicion Final(lista *l);
posicion First(lista *l);
posicion Following(lista *l, posicion p);
posicion Previus(lista *l, posicion p);
posicion Search(lista *l, elemento e);
//Operación de consulta
elemento Position(lista *l, posicion p);
int Size(lista *l);
boolean Empty(lista *l);
boolean ValidatePosition(lista *l, posicion p);
//Operaciones de modificación
void Insert(lista *l, elemento e, posicion p,boolean b);
void Add(lista *l,elemento e);
void Remove(lista *l,posicion p);
void Replace(lista *l,posicion p, elemento e);
