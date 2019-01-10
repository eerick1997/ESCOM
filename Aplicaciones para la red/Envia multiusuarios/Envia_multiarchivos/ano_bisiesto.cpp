 <iostream>	
using namespace std;
/**Problema
Dado un año o a partir del año 0 al actual, decir si es o no es bisiesto

Entrada: Un entero, el año a revisar
Salida: Una línea "SI" si el año es bisiesto.
"NO" si eñl año no es bisiesto. "NOPE" si el año est+a fuera de rango

Ejemplo:
***********
*2018* NO *
***********
*2016* SI *
***********
Consideraciones:
-> Números enteros positivos
-> Del 0 - 2018
-> ¿Que es un año bisiesto?
Podemos determinarlo si el año es divisible entre 100 y si es divisible entre 400 es bisiesto
O bien su no es divisible entre 100 y es divisible entre 4 entonces es bisiesto

Casos de prueba:

**/
int main(){
	short int x;
	cin>>x;

 	if (x < 0 || x > 2018){
		cout<<"NOPE";
	} else if(x % 100 % x % 400){
		cout<<"SI";
	} else if (x % 100 != 0 && x % 4 == 0) {
		cout<<"SI";
	} else{
		cout<<"NO";
	}
	return 0;
}

/**Metodología
éxito
******************************
Sumbit
******************************
Probar en la PC
******************************
Implementación
******************************
Prueba de escritorio
******************************
Idea de solución
******************************
Casos de prueba
******************************
Consideraciones
******************************
Leer y entender el problema

**/