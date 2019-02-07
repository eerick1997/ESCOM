/*
Autor: Esquivel Valdez Alberto
Última modificación: 05.02.19
*/
#include <iostream>
#include <string>
#include <fstream>
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
string cifrar(string texto, int corrimiento, struct letra alfabeto[]);
string descifrar(string texto, int corrimiento, struct letra alfabeto[]);
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
    int opc = 0, corrimiento;
    /*Se crea un arreglo de la estructura letra con los valores y nombres de todo el alfabeto*/
    char a = letraIni;
    string nombre = "";
    ifstream ficheroEntrada,ficheroEntrada2;
    ofstream ficheroSalida("c.txt");
    ofstream ficheroSalida2("d.txt");
    
    struct letra alfabeto[tamAlf];
    for (int i = 0; i < tamAlf; i++)
    {
        alfabeto[i].valor = i;
        alfabeto[i].nombre = a;
        a++;
    }
    while (opc != 3)
    {
        cout << "\n=====Cifrado por corrimientos=====\n";

        cout << "\nIngresa el numero de corrimiento:\n";
        cin >> corrimiento; //El usuario especifica el número del corrimiento
        cout << "\n1. Cifrar\n2. Descifrar\n3. Salir\n";
        cin >> opc;
        cin.ignore();
        switch (opc)
        {
        case 1:
            cout << "\nDime el nombre del fichero: ";
            getline(cin, nombre);
            ficheroEntrada.open(nombre.c_str(), ios::in);
            if (ficheroEntrada.is_open())
            {

                while (!ficheroEntrada.eof())
                {
                    getline(ficheroEntrada, texto);
                }

                ficheroEntrada.close();
            }
            else
                cout << "Fichero inexistente o faltan permisos para abrirlo" << endl;
            /*ficheroEntrada.open(nombre);
            getline(ficheroEntrada,texto);
            ficheroEntrada.close();*/
            cout << "\nTexto cifrado.\n"; /*<< cifrar(texto, corrimiento, alfabeto); //Muestra el texto cifrado*/
            ficheroSalida << cifrar(texto, corrimiento, alfabeto) << endl;
            ficheroSalida.close();
            
            break;
        case 2:
            
            cout << "\nDime el nombre del fichero: ";
            getline(cin, nombre);
            //cout<<nombre;
            ficheroEntrada.open(nombre.c_str(), ios::in);
            if (ficheroEntrada.is_open())
            {
                    getline(ficheroEntrada, texto);
                ficheroEntrada.close();
            }
            else
                cout << "Fichero inexistente o faltan permisos para abrirlo" << endl;
            cout << "\nTexto descifrado.\n"; /*<< cifrar(texto, corrimiento, alfabeto); //Muestra el texto cifrado*/
            //cout<<descifrar(texto,corrimiento,alfabeto);
            ficheroSalida2 << descifrar(texto, corrimiento, alfabeto) << endl;
            
            ficheroSalida2.close();
            break;
        case 3:
            break; //Sale del programa
        default:
            cout << "\nOpción no especificada.\n";
        }
    }
}
/*
FUNCIÓN: Suma el valor de la letra con el numero del corrimiento y se le resta el valor de la letra inicial
para garantizar que comience desde la A
RECIBE: string texto, int corrimiento, struct letra alfabeto[]
DEVUELVE: string textocifrado
*/
string cifrar(string texto, int corrimiento, struct letra alfabeto[])
{
    string textocifrado = "";
    for (int i = 0; i < texto.length(); i++)
    {
        textocifrado = textocifrado + (alfabeto[((int)texto[i] - letraIni + corrimiento) % tamAlf].nombre);
    }
    return textocifrado;
}
/*
FUNCIÓN: Resta el valor de la letra con el numero del corrimiento y se le resta el valor de la letra inicial
para garantizar que comience desde la A
RECIBE: string texto, int corrimiento, struct letra alfabeto[]
DEVUELVE: string textodescifrado
*/
string descifrar(string texto, int corrimiento, struct letra alfabeto[])
{
    string textodescifrado = "";
    int resta = 0;
    for (int i = 0; i < texto.length(); i++)
    {
        resta = (int)texto[i] - letraIni - corrimiento;
        if (resta < 0) //Si el resultado de la resta es un numero negativo, se suma el tamaño del alfabeto
            textodescifrado = textodescifrado + (alfabeto[(resta + tamAlf) % tamAlf].nombre);
        else
            textodescifrado = textodescifrado + (alfabeto[(resta) % tamAlf].nombre);
    }
    return textodescifrado;
}