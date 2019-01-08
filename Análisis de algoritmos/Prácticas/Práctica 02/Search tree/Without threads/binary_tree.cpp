/***
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

//Librerías
#include <iostream>
using namespace std;

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

/**
 * newTree: Esta función tiene como finalidad crear un nuevo
 * sub árbol los cuales bien sabemos que son en realidad
 * apuntadores a Nodo.
 * Recibe: int
 * Retorna: BinaryTree (*Nodo)
 * */
BinaryTree newTree(int data){
    //Creamos un nuevo nodo 
    BinaryTree newBinaryTree = new Node();
    //Asignamos el valor al nodo
    newBinaryTree -> value = data;
    //Retornamos el nodo
    return newBinaryTree;
}

/**
 * insert: Esta función tiene como finalidad añadir un 
 * sub árbol a el árbol que es pasado por referencia a la función
 * Recibe: BinaryTree e int
 * Devuelve: Nada
 * */
void insert(BinaryTree &sub_tree, int data){
    
    //Comparamos si sub árbol es nulo
    if(!sub_tree){
        //Si es un sub árbol nulo es creado
        sub_tree = newTree(data);
    } 
    //Comparamos el valor de la raíz con el nuevo valor recibido
    else if(data >= sub_tree -> value){
        //SI el valor es mayor o igual se añade un nodo  a la derecha de la raíz
        insert(sub_tree->right, data);
    } else {
        //Si es menor el nodo se añade a la izquierda de la raiz
        insert(sub_tree -> left, data);
    }
}

/**
 * search: Esta función tiene como finalidad hacer un recorrido en 
 * profundidad del árbol, en este caso el recorrido se realiza en in-orden
 * Es decir:
 * Primero se recorre el sub árbol izquierdo
 * Después se recorre la raíz
 * Finalmente se recorre el sub árbol derecho
 * Cuando se recorre la raiz se evalua si es igual al número que se desea buscar
 * */
void search(BinaryTree &sub_tree, int n){
    if(sub_tree){
        search(sub_tree -> left, n);
        //Verificamos si el valor se ha encontrado
        if(sub_tree -> value == n)
            cout<<"Se ha encontrado el numero "<<n<<endl;
        search(sub_tree -> right, n);
    }
}

/**
 * inorder: Esta función tiene como finalidad hacer un recorrido en 
 * profundidad del árbol, en este caso el recorrido se realiza en in-orden
 * Es decir:
 * Primero se recorre el sub árbol izquierdo
 * Después se recorre la raíz
 * Finalmente se recorre el sub árbol derecho
 * */
void inorder(BinaryTree &sub_tree){
    if(sub_tree){
        inorder(sub_tree -> left);
        sub_tree -> value;
        inorder(sub_tree->right);
    }
}

/**
 * postorder: Esta función tiene como finalidad hacer un recorrido en 
 * profundidad del árbol, en este caso el recorrido se realiza en post-orden
 * Es decir:
 * Primero se recorre el sub árbol izquierdo
 * Después se recorre el sub árbol derecho
 * Finalmente  se recorre la raíz
 * */
void postorder(BinaryTree &sub_tree){
    if(sub_tree){
        inorder(sub_tree -> left);
        inorder(sub_tree->right);
        cout<<sub_tree->value<<endl;
    }
}

/**
 * preorder: Esta función tiene como finalidad hacer un recorrido en 
 * profundidad del árbol, en este caso el recorrido se realiza en pre-orden
 * Es decir:
 * Primero se recorre la raíz
 * Después se recorre el sub árbol izquierdo
 * Finalmente se recorre el sub árbol derecho
 * */
void preorder(BinaryTree &sub_tree){
    if(sub_tree){
        cout<<sub_tree->value<<endl;
        inorder(sub_tree -> left);
        inorder(sub_tree->right);
    }
}
