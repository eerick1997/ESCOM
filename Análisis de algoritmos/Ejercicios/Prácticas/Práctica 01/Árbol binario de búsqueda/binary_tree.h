/***
 * LIBRERÍA: cabecera del árbol binario
 * AUTORES:
 *                              Macías Castillo Josué
 *                              Torres Hernández Eduardo
 *                              Vargas Romero Erick Efraín
 * VERSION: 1.0
 * 
 * DESCRIPCIÓN: Árbol binario
 * Esta estructura de datos es bastante simple de visualizar ya que se tiene un nodo y al ir
 * añadiendo elementos se crean nuevos nodos los cuales van ligados al anterior es decir
 * el nodo padre tiene nodos hijos. Para ese caso en particular por ser un árbol binario cada
 * nodo padre a lo más podrá tener dos hijos.
 * 
 * OBSERVACIONES: Esta estructura de datos es dinámica es decir utilizará
 * la memoria que sea necesaria para tener un funcionamiento adecuado.
 * */

//Estructura de nuestro elemento nódo
struct Node{      
    /**
     * Variables
     * */
    //Esta variable contiene el dato que será almacenado en el nodo
   int value;
   
   //Aquí tenemos las referencias a los nodos hijo izquierdo y derecho
   struct Node *left, *right;
};

//Renombramos los apuntadores a nodo como BinaryTree para mantener un buen órden
typedef struct Node *BinaryTree;

/**DECLARACIÓN DE FUNCIONES**/

//Crea un nuevo árbol o bien un apuntador a nodo
BinaryTree newTree(int data)
//Añade un sub árbol al árbol que ha sido pasado por referencia a la función
void insert(BinaryTree &sub_tree, int data)
//Hace un recorrido en profundidad en in-órden
void inorder(binary_tree, &sub_tree);
//Hace un recorrido en profundidad en post-órden
void postorder(binary_tree, &sub_tree);
//Hace un recorrido en profundidad en pre-órden
void preorder(binary_tree, &sub_tree);
