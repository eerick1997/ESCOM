#include <stdio.h>
#include "C:\Users\Erick\Documents\ESCOM\Sistemas Operativos\Práctica 1\Libraries\TADPilaDin\TADPilaDin.c"
#include "C:\Users\Erick\Documents\ESCOM\Sistemas Operativos\Práctica 1\Libraries\TADArbolBin\TADArbolBin.c"
arbol_binario subTree(char* string, int i);

void main(){
    pila heap;
    arbol_binario tree, subTree, aux;
    Initialize_P(&heap);
    Initialize(&tree);
    //Initialize(&subTree);
    //Initialize(&aux);
    myMain(&heap, &subTree, &tree);
}

void myMain(pila* heap, arbol_binario subTree, arbol_binario tree){
    char expression[100];
    printf("\nIngrese la expresion -> ");
    scanf("%s", &expression);
    manipulateString(expression, heap, subTree, tree);
    //printf("\n Arbol tiene: %c %c %c\n", tree->der->e.c, tree->e.c, tree->izq->e.c);
}

boolean isOperator(char character){
    boolean characterIsOperator = FALSE;
    if(character == '+' || character == '-'
       || character == '*' || character == '/')
        characterIsOperator = TRUE;
    return characterIsOperator;
}

void manipulateString(char* string, pila heap, arbol_binario subTreee, arbol_binario tree){
    int i = 0, j = 0;
    elemento element;
    p_elemento h_element;
    while(string[i] !='\0'){
        h_element.c = string[i];
        if(h_element.c == '('){
            Push(&heap, h_element);
        }
        if(h_element.c == ')'){
            Pop(&heap);
        }
        if(isOperator(h_element.c)){
            element.c = h_element.c;
            subTreee = subTree(string, i);


            //printf("\n Arbol tiene: %c %c %c\n", subTree->der->e.c, subTree->e.c, subTree->izq->e.c);
        }
        i++;
    }
}

arbol_binario subTree(char* string, int i){
    elemento element;
    arbol_binario tree;
    Initialize(&tree);

    if(string[i] != '\0'){
        element.c = string[i];
        tree->e = element;

        if(string[i-1] != ')'){ //Seguro es número
            element.c = string[i-1];
            NewRightSon(&tree, element);
        } if(string[i+1] != '('){
            element.c = string[i-1];
            NewLeftSon(&tree, element);
        }
    }
    return tree;
}

/*arbol_binario createTree(char* string, arbol_binario tree, int i){
    elemento element;

    arbol_binario sub_tree;
    Initialize(sub_tree);
    element.c = string[i];
    //while(element.c != '\0'){

        /**Maybe here we can do push and pop in our heap
        **/

        /*if(isOperator(element.c)){
            sub_tree->e = element;
            i++;
            if(string[i-1] != ')'){
                NewRightSon(sub_tree, element);
            } else {
                sub_tree->der = createTree(string, sub_tree, i);
            }

            if(string[i+1] != '('){
                NewLeftSon(sub_tree, element);
            } else {
                sub_tree->izq = createTree(string, sub_tree, i);
            }
        //}
        //element.c = string[i++];
    }
    return sub_tree;
}


void createSubTree(char* string, int index, arbol_binario tree, arbol_binario subTree, arbol_binario aux){
    elemento tree_element;

    aux->e.c = string[index];
    if(string[index-1] != ')'){ //Right is a number
        tree_element.c = string[index-1];
        printf("%c\n", tree_element.c);
        NewRightSon(aux, tree_element);
    } else { //Right not is a number
        subTree->der = aux;
        //tree->der = subTree;
    }

    if(string[index+1] != '('){//Left is a number
        tree_element.c = string[index+1];
        printf("%c\n", tree_element.c);
        NewLeftSon(aux, tree_element);
    } else { //Left not is a number
        subTree->izq = aux;
    }
    printf("subTree have: %c %c %c", aux->der->e.c, aux->e.c, aux->izq->e.c);
    //subTree = aux;
}*/
