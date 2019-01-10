/*
IMPLEMENTACIONES DE LA LIBRERIA DEL TAD PILA DINÁMICA con el TAD LISTA
AUTOR: Vargas Romero Erick Efraín (C) Noviembre 2016
VERSIÓN: 1.0

DESCRIPCIÓN: TAD pila o stack.
Estructura de datos en la que se cumple:
Los elementos se añaden y se remueven por un solo extremo.
Este extremo es llamado “tope” de la pila.

OBSERVACIONES: Hablamos de una Estructura de datos dinámica
cuando se le asigna memoria a medida que es necesitada,
durante la ejecución del programa. En este caso la memoria
no queda fija durante la compilación.
*/

//LIBRERAS
#include <stdlib.h>
#include "..\TADLista\TADLista.c"
#include "TADPila.h"

//DEFINICIÓN DE FUNCIONES


/*
void Initialize(pila *s);
Descripción: Inicializar pila (Iniciar una pila para su uso)
Recibe: pila *s (Referencia a la pila "s" a operar)
Devuelve:
Observaciones: El usuario a creado una pila y s tiene la referencia a ella,
si esto no ha pasado se ocasionara un error.

NOTA: No es necesario volver a crear esta función ya que por defecto
la Lista tienene la misma funcion y ambas son idénticas, solamente
en el encabezado se ha cambiado el nombre de un parámetro que recibira la función
*/
/**void Initialize(pila *s){
}**/

/*
void Push(pila *s, elemento e);
Descripción: Empilar (Introducir un elemento a la pila)
Recibe: pila *s (Referencia a la pila "s" a operar), elemento e (Elemento a introducir en la pila)
Devuelve:
Observaciones: El usuario a creado una pila y s tiene la referencia a ella, s ya ha sido inicializada.
Ademas no se valida si el malloc() pudo o no apartar memoria, se idealiza que siempre funciona bien
y no se acaba la memoria

NOTA: Como estamos haciendo uso del TAD Lista para el funcinamiento de este programa
simplemente utilizamos la función Add de la lista, la cual añade un elemento al final de la lista
esto utilizando la pila que recibe la función que realmente es una lista que hemos renombrado
*/
void Push(pila *s, elemento e)
{
    //Llamado de la función add
    Add(s, e);
}


/*
void Pop(pila *s);
Descripción: Desempilar (Extraer un elemento de la pila)
Recibe: pila *s (Referencia a la pila "s" a operar)
Devuelve: elemento (Elemento e extraido de la pila)
Observaciones: El usuario a creado una pila y s tiene la referencia a ella, s ya ha sido inicializada.
Ademas no se valida si la pila esta vacia antes de desempilar (causa error desempilar si esta esta vacía),
tampoco se valida si free() pudo o no liberar la memoria, se idealiza que siempre funciona bien

NOTA: Al hacer uso del TAD Lista debemos utilizar la función Remove y Final ya que
esta función como se ha hecho descripción debe de devolver un elemento concretamente
el elemento que va a salir de la pila, para lo cual hacemos un final, que nos devuelve
la ultima posicion del elemento que fue enlistado, y accedemos al elemento que esta en esa posicion
hacemos un remove de lo que este al final de la lista, que es un elemento que ya respaldamos y finalmente
retornamos el elemento que almacenamos anteriormente
*/
elemento Pop (pila *s)
{
    elemento e;
    e = Final(s)->e;
    Remove(s, s->final);
    return e;
}

/*
boolean Empty(pila *s);
Descripción: //Vacia (Preguntar si la pila esta vacia)
Recibe: int *s (Referencia a la pila "s" a operar)
Devuelve: boolean (TRUE o FALSE según sea el caso)
Observaciones: El usuario a creado una pila y s tiene la referencia a ella, s ya ha sido inicializada.

NOTA: No es necesario recrear esta función ya que el TAD Lista tiene esta función de manera implícita
ambas funcionan de la misma manera así que solo se modifica el nombre del parámetro que recibira la función
en el header
*/
/**boolean Empty(pila *s)
{
}**/

/*
elemento Top(pila *s);
Descripción: Tope (Obtener el "elemento" del tope de la pila sin extraerlo de la pila)
Recibe: int *s (Referencia a la pila "s" a operar)
Devuelve: elemento (Elemento del tope de la pila)
Observaciones: El usuario a creado una pila y s tiene la referencia a ella, s ya ha sido inicializada.
Ademas no se valida si la pila esta vacia antes de consultar al elemnto del tope (causa error si esta esta vacía).

NOTA: El Top es sencillo, solo mostraremos el ultimo elemento empilado cosa que se logra al invocar a la función
final de la lista accediendo a el elemento que tiene la posicion que retorna
*/
elemento Top(pila *s)
{
	return Final(s)->e;
}

/*
int ValueTop(pila *s);
Descripción: Tamaño de la pila (Obtener el número de elementos en la pila)
Recibe: int *s (Referencia a la pila "s" a operar)
Devuelve: int (Tamaño de la pila -1->Vacia, 1->1 elemento, 2->2 elementos, ...)
Observaciones: El usuario a creado una pila y s tiene la referencia a ella, s ya ha sido inicializada.

NOTA: El value top nos devuelve el tamaño de la Pila lo cual es posible utilizando la función Size que ya
existe en la lista
*/
int Value_Top(pila *s)
{
	return Size(s);
}

/*
void Destroy(pila *s);
Descripción: Elimina pila (Borra a todos los elementos en a la pila de memoria)
Recibe: int *s (Referencia a la pila "s" a operar)
Devuelve:
Observaciones: El usuario a creado una pila y s tiene la referencia a ella, s ya ha sido inicializada.

NOTA: El Destroy ya existe en el TAD Lista no es necesario recrearla, simplemente hay que renombrarla en el header
*/
/**void Destroy(pila *s)
{
}**/
