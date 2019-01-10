#include <stdio.h> //Librerias, se incluyen las funciones estandar de entrada y salida

//Programa principal
int main(void){
    //Declaración de variables, las tres únicamente para
    //almacenar el valor de tres números
    int a = 0, b = 0, c = 0;

    //Mandamos un mensaje a la pantalla
    printf("Ingresa tres números -> ");
    //Leemos los tres números, a, b y c
    scanf("%d", &a); scanf("%d", &b); scanf("%d", &c);

    //Evaluamos si a es mayor que b
    if(a>b){
        //Si la condición se cumple volvemos ha
        //hacer una evaluación si a es mayor que c
        if(a>c){
            //Si se cumple la condición, evaluamos nuevamente
            //Esta ocación evaluamos si b es mayor que c
            if(b>c){
                //Si la condición se cumple, imprimimos los
                //tres números primero a, luego b y c
                printf("%d, %d, %d", a, b, c);
            } else { //Si b es menor que C entonces
                //Solo mostramos el orden a, c, y b
                printf("%d, %d, %d", a, c, b);
            }
        } else { //Si a resulta ser menor que c
            //Mostramos el orden c, a, b
            printf("%d, %d, %d", c, a, b);
        }
    } else { //Si a es menor que b, entonces
        //evaluamos nuevamente si b es mayor que c
        if(b>c){
            //Si la condición se cumple, entonces evaluamos
            //si a es mayor que C
            if(a>c){
                //Si la condición se cumple, mostramos
                //en el orden, b primero, segundo a y final c
                printf("%d, %d, %d", b, a, c);
            } else { //Si a resulta ser menor que c entonces
                //mostramos el orden, b, c, a
                printf("%d, %d, %d", b, c, a);
            }
        } else { //Si b es menor que c
            //Solo mostramos en orden c, b, a
            printf("%d, %d, %d", c, b, a);
        }
    }
    return 0;
}
