/*
LIBRERIA: Cabecera del TAD PILA Implementación con TAD Lista
AUTOR: Vargas Romero Erick Efraín (C) Noviembre 2016
VERSIÓN: 1.0

DESCRIPCIÓN: TAD pila o stack.
Estructura de datos en la que se cumple:
Los elementos se añaden y se remueven por un solo extremo.
Este extremo es llamado “tope” de la pila.

OBSERVACIONES: Hablamos de una Estructura de datos dinámica
cuando se le asigna memoria a medida que es necesitada,
durante la ejecución del programa. En este caso la memoria
no queda fija durante la compilación y se logrará este dinamismo
a travez del modelo "nodo" el cuál se reservará dinamicamente logrando
modelar una pila.

NOTA: Al esta haciendo uso del TAD Lista no es necesario modelar una estructura
para la Pila ni es necesario crear una estructura para los elementos ya que
estan implícitos en el TAD Lista
*/

//Renombramos la lista con el nombre de Pila solamente por orden

typedef lista pila;
//DECLARACIÓN DE FUNCIONES
void Initialize(pila *s);			//Inicializar pila (Iniciar una pila para su uso)
void Push(pila *s, elemento e);		//Empilar (Introducir un elemento a la pila)
elemento Pop (pila *s);				//Desempilar (Extraer un elemento de la pila)
boolean Empty(pila *s);				//Vacia (Preguntar si la pila esta vacia)
elemento Top(pila *s);				//Tope (Obtener el "elemento" del tope de la pila si extraerlo de la pila)
int Value_Top(pila *s);				//Tamaño de la pila (Obtener el número de elementos en la pila)
void Destroy(pila *s);				//Elimina pila (Borra a todos los elementos y a la pila de memoria)
