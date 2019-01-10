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

//LIBRERIAS
#include<stdio.h>//Incluye las funciones estandar de entrada y salida
#include<stdlib.h>
#include "TADLista.h"//Incluye funciones para la lista

//DEFINICIÓN DE FUNCIONES

/***************************************************
Operaciones de construcción
***************************************************/
/*
void Initialize(lista *l)
Descripción: Recibe una lista L y la inicializa para su trabajo
normal.
Recibe: lista *l
*/
void Initialize(lista *l)
{
    l->frente = NULL;
    l -> final = NULL;
    l->tam = 0;
    return;
}
/*
void Destroy(lista *l)
Descripción:Recibe una lista L y la libera completamente
Recibe: lista *l
*/
void Destroy(lista *l)
{
    posicion aux;
    while(!Empty(l))
    {
        aux=l->final->adelante;
        free(l->final);
        l->tam--;
    }
}

/***************************************************
Operaciones de posicionamiento y busqueda
***************************************************/
/*
posicion Final(lista *l)
Descripción: Recibe una lista L y regresa la posición del final
Recibe: lista *l
Devuelve:
*/
posicion Final(lista *l)
{
    return l->final;
}
/*
posicion First(lista *l)
Descripción:Recibe una lista L y regresa la posición del primero
Recibe: lista *l
Devuelve:return l->frente
*/
posicion First(lista *l)
{
    return l->frente;
}
/*
posicion Following(lista *l, posicion p)
Descripción: : Recibe una lista L y una posición p, regresa la
posición siguiente a p.
Recibe: lista *l, posicion p
Devuelve:return p->adelante
*/
posicion Following(lista *l, posicion p)
{
    if(ValidatePosition(l,p))//Si valida esa posicion hara lo siguiente
    {
        return p->adelante;
    }
    else//sino
    {
        printf("ERROR: Following(posicion no valida o  lista vacia)");//imprimira a pantalla
        exit(1);
    }
}
/*
posicion Previus(lista *l, posicion p)
Descripción: Recibe una lista L y una posición p, regresa la
posición anterior a p.
Recibe: lista *l, posicion p
Devuelve:p->atras
*/
posicion Previus(lista *l, posicion p)
{

    if(ValidatePosition(l,p))//si valida esa posicion se hara lo siguiente
    {
        return p->atras;
    }
    else//sino
    {
        printf("ERROR: Previus(posicion no valida o  lista vacia)");//imprimira error
        exit(1);
    }
}
/*
posicion Search(lista *l, elemento e)
Descripción: Recibe una lista L y un elemento e, regresa la posición
que coincida exactamente con el elemento e.
Recibe: lista *l, elemento e
Devuelve:r
*/
posicion Search(lista *l, elemento e)
{
    posicion r=NULL,aux;//Se declara r y se inicializa en NULL,tambien se declara un aux

    if (l->tam>0)//Si se cumple que el valor de l->tam es mayor que cero, se realizara lo siguiente
    {
        aux=l->frente;//aux guardara el valor de l->frente
        while (aux!=NULL&&r==NULL)// él ciclo se terminara hasta que ya no se cumpla esa condicion
        {
            if(memcmp(&e,&aux->e,sizeof(elemento))==0)
            {
                r=aux;//r almacenara lo que hay en aux
            }
            else //sino
            {
                aux=aux->atras;//aux almacenara ese valor
            }
        }
    }
    return r;
}

//***************************************************
//Operaciónes de consulta
//***************************************************
/*
elemento Position(lista *l, posicion p)
Descripción: Recibe una lista L y una posición p, devuelve el
elemento en dicha posición.
Recibe: lista *l, posicion p)
Devuelve:return p->e o bien, ERROR: Position(La posicion no es invalida)
*/
elemento Position(lista *l, posicion p)
{
    if(ValidatePosition(l,p))
    {
        return p->e;
    }
    else
    {
        printf("ERROR: Position(La posicion no es invalida)");
        exit(1);
    }
}
/*
int Size(lista *l)
Descripción: Recibe una lista L y devuelve el tamaño de la lista.
Recibe: lista *l
Devuelve:regresa el valor de l->tam

*/
int Size(lista *l)
{
    return l->tam;//regresa el valor de l->tam
}
/*
boolean Empty(lista *l)
Descripción: Recibe una lista L y devuelve verdadero en caso de que
la lista l este vacía.
Recibe: lista *l
Devuelve: un FALSE o TRUE
*/
boolean Empty(lista *l)
{
    return (l->tam > 0) ? FALSE : TRUE;//regresa el resultado de l->tam->0
}
/*
boolean ValidatePosition(lista *l, posicion p)
Descripción: Recibe una lista L y una posición
p, devuelve verdadero en caso de que en la lista L, p sea una posición
valida (no nula).
Recibe: lista *l, posicion p
Devuelve:r
*/
boolean ValidatePosition(lista *l, posicion p)
{
    boolean r = FALSE;//se declara un boolen r y se inicializa en FALSE
    posicion aux;//se declara un aux
    aux = l->frente;// aux guarda lo que contenga l->frente
    while (aux!=NULL && !r)//Repite las instrucciones hasta que no se cumpla la condicion
    {
        if (memcmp(&aux, &p, sizeof(posicion)) == 0)
            r = TRUE;//r sera verdad
        aux = aux->atras;// aux guardara lo que contenga aux->atras
    }
    if(memcmp(&l->final, &p, sizeof(posicion)) == 0)
        r = TRUE;// r sera verdad
    return r; //regresara r
}


//***************************************************
//Operaciones de modificación
//***************************************************
/*void Insert(lista *l, elemento e, posicion p,boolean b)
Descripción: Recibe una lista L, un elemento e, una posición p y
un valor booleano b e inserta al elemento e en la lista L enfrente de p
si b es verdadero o atrás de p en caso de que b sea falso.
Recibe: lista *l, elemento e, posicion p,boolean b
*/
void Insert(lista *l, elemento e, posicion p,boolean b)
{
    posicion aux;//se declara un aux
    aux = malloc(sizeof(nodo));//Se aparta memoria
    if (aux==NULL)//Si se cumple que aux es igual a NULL
    {
        printf("ERROR Insert: no se pudo crear un nuevo nodo");//se imprime ERROR...
        exit(1);// se cierra el programa
    }
    aux->e = e;//"aux" apunta a la referencia de "e" y "e" iguala a "e"
    if (!ValidatePosition (l,p))//si se cumple que no se ha validado la posicion se realizara lo siguiente
    {
        aux->atras = l->frente;//aux apunta a la referencia de atras y sera igual a l que apunta la referencia de  frente
        aux->adelante = NULL;//aux apunta a la referencia de adelante y sera igual a NULL
        l->frente = aux;// l apunta a la referencia de frente y sera igual a aux
        if (l->tam == 0)//Si se cumple que l apunta a la referencia de tam y es igual a cero, se cumple lo siguiente
            l->final = aux;//l apunta a la referencia de final y se iguala a aux
        else//sino se realizara lo siguiente
            l->frente->atras->adelante = l->frente;// l apunta a la referencua de frente ý asu vez a la de atras y a la de adelante y se iguala a l que apunta a la referencia del frente
    }
    else //sino se realizara lo siguiente
    {
        if (b)//si se cumple b
        {
            aux->adelante = p->adelante;//aux apunta a la referencia de adelante y se iguala a la referencia de p->adelante
            p->adelante = aux;//p apunta a la referencia de adelante y se iguala a aux
            aux->atras = p;//aux apunta a la referencia de  atras y se iguala a p
            if (p==l->frente)//si se p es igual a l->frente
                l->frente = aux;// l accede al frente, y lo que contenga sera igual a aux
            else// sino se cumple la anterior condicion, se realiza lo siguiente
                aux->adelante->atras = aux;//aux accede a adelante y a atras,lo que contega sera el valor de aux
        }
        else//sino se cumple esta condicion se realizara lo siguiente
        {
            aux->adelante = p;//aux accede a adelante y se guarda en p
            aux->atras = p->atras;//aux accede a atras y se guarda en p->atras
            p->atras = aux;//p accede a atras y se guarda en aux
            if (p==l->final)//sino se cumple la anterior condicion, se realizara lo siguiente
                l->final = aux;//l accede a final y se guarda en aux
            else//sino se cumple, se realizara lo siguiente
                aux->atras->adelante = aux;//asux accede a atras y a adelante, se guarda en aux
        }
    }
    l->tam++;//se incrementa tam
}

/**
Solo añade en el final un nuevo elemento y un nodo
**/
/*void Add(lista *l,elemento e)
Descripción: Recibe una lista L y un elemento e, se inserta al
elemento e al final de la lista L.
Recibe: lista *l,elemento e
*/
void Add(lista *l,elemento e)
{
    posicion aux = NULL, aux2;//Declaracion de elementos posicion llamado aux y se inicializa en cero y tambien aux2
    aux = malloc(sizeof(nodo));// Se aparta memoria para el nodo
    if(aux != NULL)//si aux no es igual a Null, se cumplira lo siguiente
    {
        aux->e = e;// aux apunta a la referencia de e y se iguala a e
        aux->atras = NULL;// aux apunta a la referencia de atras y se iguala a NULL
        aux->adelante = NULL;// aux apunta a la referencia de adelante y se iguala a NULL
        if(!Empty(l)) // Si se cumple esta condicion se realizara lo siguiente
        {
            if(l->final->adelante != NULL)// Si se cumple que l->final->adelante != NULL, se realizara lo siguiente
            {
                l->final->adelante->atras = l->final;// l apunta a la referencia de final y asu vez a la referencia de adelante y asu vez a la de atras, se iguala a final
            }
            aux->adelante = l->final;//aux punta a la referencia de adelante y sera igual a la referencia: l->final
            l->final = aux;// l es la referencia de final y se iguala a aux
        }
        else //sino
        {
            l->final = aux;// l apunta a la referencia de final y se iguala a aux
            l->frente = aux;// l apunta a la referencia de frente y se iguala a aux
        }
        l->tam++;// se incrementa tam
    }
    else//sino
    {
        printf("\nError no se pudo crear un nuevo nodo");//Imprimira error no se pudo crear un nuevo nodo
    }
}
/*void Remove(lista *l,posicion p)
Descripción:Recibe una lista L y una posición p, y elimina al
elemento en la posición p de la lista.
Recibe:lista *l,posicion p.
*/
void Remove(lista *l,posicion p)
{
    posicion Pos_adelante, Pos_atras;// Declaracion de posicion a utilizar
    if(!Empty(l)) //Si no esta vacia la lista, se realizara lo siguiente
    {
        if(ValidatePosition(l, p))// Si la valida esa posicion, realizara lo siguiente
        {
            //Si esto ocurre es el nodo del principio
            if(p->adelante == NULL)
                l->frente = l->frente->atras;
            //Si eso ocurre es el nodo del final
            else if(p->atras == NULL)
                l->final = l->final->adelante;
            else// sino ocurre esto
            {
                    Pos_adelante = p->adelante;//Se almacenan los datos proporcionados de la referencia de p->adelante
                    Pos_atras = p->atras;//Se almacenan los datos proporcionados de la referencia de p->atras
                    Pos_adelante->atras = Pos_atras;//Se almacenan los datos proporcionados de Pos_atras
                    Pos_atras->adelante = Pos_adelante;//Se almacenan los datos proporcionados de Pos_adelante
            }
            l->tam--;//referecia a tam
            free(p);//se libera
        }
    }
    else //sino
    {
        printf("\nEsta vacia");//Imprimira que esta vacia
    }
}
/*void Replace(lista *l,posicion p, elemento e)
Descripción: Recibe una lista L, un elemento e, una posición
p y sustituye al elemento ubicado en p por e.
Recibe: lista *l,posicion p, elemento e
*/
void Replace(lista *l,posicion p, elemento e)
{
    if(!Empty(l)) // Si la lista L no esta vacia realzara lo siguiente
    {
        if(ValidatePosition(l, p))//Si contiene a estos elementos, realizara los siguiente
        {
            p->e=e;// Referencia de "p" a "e" sera igual a "e"
        }
    }
}
