#define TRUE 1
#define FALSE 0

typedef char boolean;

typedef struct elemento
{
	char c;
	//Lo que gustes
}elemento;

typedef struct nodo
{
	elemento e;
	struct nodo* izq;
	struct nodo* der;
}nodo;

typedef nodo* arbol_binario;

typedef nodo* posicion;

void Initialize(arbol_binario *a); //*
void Destroy(arbol_binario *a); //*
posicion Root(arbol_binario *a); //*
posicion Parent(arbol_binario *a,posicion p); //*
posicion RightSon(arbol_binario *a,posicion p); //*
posicion LeftSon(arbol_binario *a,posicion p);//*
posicion Search(arbol_binario *a,elemento e);//*
boolean Empty(arbol_binario *a);//*
boolean NullNode(arbol_binario *a,posicion p);//
elemento ReadNode(arbol_binario *a,posicion p);
void NewRightSon(arbol_binario *a,posicion p,elemento e); //*
void NewLeftSon(arbol_binario *a,posicion p,elemento e); //*
void DeleteRightSon(arbol_binario *a,posicion p); //*
void DeleteLeftSon(arbol_binario *a,posicion p); //*
void DeleteNode(arbol_binario *a,posicion p); //*
void ReplaceNode(arbol_binario *a,posicion p,elemento e);//*

