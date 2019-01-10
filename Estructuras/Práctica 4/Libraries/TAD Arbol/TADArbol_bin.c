#include "TADArbol_bin.h"
#include<stdlib.h>

void Initialize(arbol_binario *a)
{
	*a=NULL;
	return;
}

void Destroy(arbol_binario *a)
{
	if((*a)->der!=NULL)
		Destroy(&((*a)->der));
	if((*a)->izq!=NULL)
		Destroy(&((*a)->izq));		
	free(*a);
	return;
}

void NewRightSon(arbol_binario *a,posicion p,elemento e)
{
	if(Empty(a))
	{	
		*a=malloc(sizeof(nodo));
		(*a)->e=e;
		(*a)->der=NULL;
		(*a)->izq=NULL;		
	}
	else
	{
		p->der=malloc(sizeof (nodo));
		p->der->e=e;
		p->der->der=NULL;
		p->der->izq=NULL;
	}
	return;
}

void NewLeftSon(arbol_binario *a,posicion p,elemento e)
{
	if(Empty(a))
	{	
		*a=malloc(sizeof(nodo));
		(*a)->e=e;
		(*a)->der=NULL;
		(*a)->izq=NULL;		
	}
	else
	{
		p->izq=malloc(sizeof (nodo));
		p->izq->e=e;
		p->izq->der=NULL;
		p->izq->izq=NULL;
	}
	return;
}

void DeleteRightSon(arbol_binario *a,posicion p)
{
	Destroy(&(p->der));
	p->der = NULL;
	return;
}

void DeleteLeftSon(arbol_binario *a,posicion p)
{
	Destroy(&(p->izq));
	p->izq = NULL;
	return;
}

void DeleteNode(arbol_binario *a,posicion p)
{
	posicion padre=Parent(a,p);
	
	if (padre->der==p)
		padre->der=NULL;
	else 
		if (padre->izq==p)
			padre->izq=NULL;
	Destroy(&p);	
	return;
}

void ReplaceNode(arbol_binario *a,posicion p,elemento e)
{
    p->e=e;
	return;
}

posicion Root(arbol_binario *a)
{
	return *a;
}

posicion Parent(arbol_binario *a,posicion p)
{
	posicion padre=NULL;
	if((*a)->der==p || (*a)->izq==p)
		return *a;
	if((*a)->der!=NULL)
		padre=Parent(&((*a)->der),p);
	if((*a)->izq!=NULL && padre==NULL)
		padre=Parent(&((*a)->izq),p);
	return padre;	
}

posicion RightSon(arbol_binario *a,posicion p)
{
	return p->der;
	
}
posicion LeftSon(arbol_binario *a,posicion p)
{
	return p->izq;
}

posicion Search(arbol_binario *a,elemento e)
{
	posicion p=NULL;
	if (memcmp(&((*a)->e),&e, sizeof(elemento))==0)
		return *a;
	if((*a)->der!=NULL)
		p=Search(&((*a)->der),e);
	if((*a)->izq!=NULL && p==NULL)
		p=Search(&((*a)->izq),e);
	return p;
}

boolean Empty(arbol_binario *a)
{
	if(*a!=NULL)
		return FALSE;
	else
		return TRUE;	
}

boolean NullNode(arbol_binario *a,posicion p)
{
	boolean b = TRUE; 
	if (*a==p)
		return FALSE;
	if((*a)->der!=NULL)
		b=NullNode(&((*a)->der),p);
	if((*a)->izq!=NULL && b==TRUE)
		b=NullNode(&((*a)->izq),p);
	return b;
}
elemento ReadNode(arbol_binario *a,posicion p)
{
  return p->e;
}
