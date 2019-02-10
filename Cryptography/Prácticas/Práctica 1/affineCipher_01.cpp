/*
Autor: Esquivel Valdez Alberto
Última modificación: 05.02.19
*/
#include <iostream>
#include <string>
#include <fstream>
#include <cmath>
#define letraIni 32 //Letra inicial del alfabeto (ASCII)
#define tamAlf 95   //Tamaño del alfabeto
using namespace std;
/*Se crea una estructura para almacenar el nombre y
valor de cada letra del alfabeto*/
struct letra
{
    int valor;
    char nombre;
};
/*Definición de las funciones*/
void menu();
string cifrar(string texto, int a, int b, struct letra alfabetoU[]);
string descifrar(string texto, int a, int b, struct letra alfabetoU[]);

int euclides(int divisor, int dividendo, bool inverso);
/*FUNCIÓN: main*/
int main()
{
    menu();
    return 0;
}
/*
FUNCIÓN: Menú para cifrar o descifrar
RECIBE: --
DEVUELVE: void */
void menu()
{
    string texto = "";
    int opc = 0, corrimiento, x, y;
    /*Se crea un arreglo de la estructura letra con los valores y nombres de todo el alfabeto*/
    char a = letraIni;
    string nombre = "";
    ifstream ficheroEntrada, ficheroEntrada2;

    struct letra alfabeto[tamAlf];
    for (int i = 0; i < tamAlf; i++)
    {
        alfabeto[i].valor = i;
        alfabeto[i].nombre = a;
        a++;
    }
    while (opc != 3)
    {
        cout << "\n=====Cifrado afin con archivos=====\n";
        cout << "\nIngresa el valor de la constante de decimacion (a):\n";
        cin >> x; //El usuario especifica el valor de a
        cout << "\nIngresa el valor de la constante de desplazamiento (b):\n";
        cin >> y; //El usuario especifica el valor de b
        if(euclides(x,y,false)!=1)
        {
            cout<<"El valor de a no es valido";
            return;
        }
        cout << "\n1. Cifrar\n2. Descifrar\n3. Salir\n";
        cin >> opc;
        cin.ignore();
        switch (opc)
        {
        case 1:
        /*Cifrar*/
        {
            cout << "\nIngresa el nombre del fichero a cifrar: ";
            getline(cin, nombre);
            string nombreSalida = nombre + ".afn";//Asigna el nombre del fichero de salida
            ofstream ficheroSalida(nombreSalida.c_str());
            ficheroEntrada.open(nombre.c_str(), ios::in);
            if (ficheroEntrada.is_open())
            {
                while (!ficheroEntrada.eof())
                {
                    getline(ficheroEntrada, texto);//El texto del fichero es leído y enviado a la cadena texto
                }
                ficheroEntrada.close();//Cierra el fichero de entrada
            }
            else
                cout << "\nError: Fichero inexistente o faltan permisos para abrirlo.\n";
            cout << "\nTexto cifrado.\n";
            ficheroSalida << cifrar(texto, x, y, alfabeto) << endl;//Escribe en el fichero de salida el texto cifrado
            ficheroSalida.close();//Cierra el fichero de salida
        }
        break;
        /*Descifrar*/
        case 2:
        {
            cout << "\nIngresa el nombre del fichero a descifrar: ";
            getline(cin, nombre);
            string nombreSalida = nombre + ".afn";//Asigna el nombre del fichero de salida
            ofstream ficheroSalida2(nombreSalida.c_str());
            ficheroEntrada.open(nombre.c_str(), ios::in);
            if (ficheroEntrada.is_open())
            {
                getline(ficheroEntrada, texto);//El texto del fichero es leído y enciado a la cadena texto
                ficheroEntrada.close();//Cierra el fichero de entrada
            }
            else
                cout << "\nError: Fichero inexistente o faltan permisos para abrirlo.\n";
            cout << "\nTexto descifrado.\n";
            ficheroSalida2 << descifrar(texto, x, y, alfabeto) << endl;//Escribe en el fichero de salida el texto descifrado
            ficheroSalida2.close();//Cierra el fichero de salida
        }
        break;
        case 3:
            break; //Sale del programa
        default:
            cout << "\nOpcion no especificada.\n";
        }
    }
}
/*
FUNCIÓN: Multiplica el valor de cada letra por la constante de decimación, le suma
la constante de desplazamiento y saca el módulo del tamaño del alfabeto para obtener
la letra que corresponde al cifrado.
RECIBE: string cadena_a_cifrar, int constante_de_decimacion, int desplazamiento, struct alfabeto
DEVUELVE: String texto_cifrado
*/
string cifrar(string texto, int a, int b, struct letra alfabetoU[])
{
    int i, j;
    string cifrado = "";
    for (i = 0; i < texto.length(); i++)
    {
        for (j = 0; j < tamAlf; j++)
        {
            if (texto[i] == alfabetoU[j].nombre)
            {
                cifrado = cifrado + alfabetoU[(a * j + b) % tamAlf].nombre;
            }
        }
    }
    return cifrado;
}
/*
FUNCIÓN: Multiplica el valor de cada letra por la constante de decimación, le resta
la constante de desplazamiento y a lo obtenido lo multiplica por el inverso de a,
saca el módulo del tamaño del alfabeto para obtener la letra que corresponde al cifrado.
RECIBE: string cadena_a_cifrar, int constante_de_decimacion, int desplazamiento, struct alfabeto
DEVUELVE: String texto_descifrado
*/
string descifrar(string texto, int a, int b, struct letra alfabetoU[])
{
    string descifrado = "";
    int i, j;
    for (i = 0; i < texto.length(); i++)
    {
        for (j = 0; j < tamAlf; j++)
        {
            if (texto[i] == alfabetoU[j].nombre)
            {
                if (j - 5 < 0)
                    descifrado = descifrado + (alfabetoU[((j - 5 + tamAlf) * euclides(tamAlf, a,true)) % tamAlf].nombre);
                else
                {
                    descifrado = descifrado + (alfabetoU[((j - 5) * euclides(tamAlf, a,true)) % tamAlf].nombre);
                }
            }
        }
    }

    return descifrado;
}
/*
FUNCIÓN: Algoritmo extendido de Euclides para obtener el gcd o el inverso de un número
RECIBE: int divisto, int dividendo, bool inverso 
DEVUELVE: Si bool inverso es TRUE devuelve el inverso, en caso contrario, devuelve el gcd
*/
int euclides(int divisor, int dividendo, bool inverso)
{
    int gx, gy, u1, u2, v1, v2, q, r, u, v, z, sv;

    gx = divisor;
    gy = dividendo;
    u1 = 1;
    u2 = 0;
    v1 = 0;
    v2 = 1;
    u = 0;
    v = 1;
    while (dividendo != 0)
    {
        q = floor(divisor / dividendo);
        r = divisor % dividendo;
        divisor = dividendo;
        dividendo = r;
        if (r != 0)
        {
            u = u1 - q * u2;
            v = v1 - q * v2;
            u1 = u2;
            v1 = v2;
            u2 = u;
            v2 = v;
        }
    }
    
    sv = v;
    if (sv < 0)
        sv = gx + sv;
    if(inverso)
        return sv;
    else
        return divisor;
}