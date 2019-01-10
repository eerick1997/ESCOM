/*
LIBRERIA: Cabecera de el TAD COLA DINÁMICA
AUTOR: Edgardo Adrián Franco Martínez (C) Septiembre 2016
VERSIÓN: 1.5

DESCRIPCIÓN: TAD cola o Queue.
Estructura de datos en la que se cumple:
Los elementos se insertan en un extremo (el posterior) y
la supresiones tienen lugar en el otro extremo (frente).

OBSERVACIONES: Hablamos de una Estructura de datos dinámica
cuando se le asigna memoria a medida que es necesitada,
durante la ejecución del programa.

NOTA: No es necesario crear un struct para la cola y de igual
manera un struct para el elemento ya que están implícitos en
el TAD Lista
*/

//Renombramos el TAD Lista como cola por dar más órden
typedef lista cola;
//DECLARACIÓN DE FUNCIONES
void Initialize(cola * c);			//Inicializar cola (Initialize): Recibe una cola y la inicializa para su trabajo normal.
void Queue(cola * c, elemento e);	//Encolar (Queue): Recibe una cola y agrega un elemento al final de ella.
elemento Dequeue(cola * c);			//Desencolar (Dequeue): Recibe una cola y remueve el elemento del frente retornándolo.
boolean Empty(cola * c);			//Es vacía (Empty): Recibe la cola y devuelve verdadero si esta esta vacía.
elemento Front(cola * c);			//Frente (Front): Recibe una cola y retorna el elemento del frente.
elemento Final_Element( cola * c);	//Final (Final_Element): Recibe una cola y retorna el elemento del final.
int Size(cola *c);					//Tamaño (Size): Retorna el tamaño de la cola
void Destroy(cola * c);				//Eliminar cola (Destroy): Recibe una cola y la libera completamente.
