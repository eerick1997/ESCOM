/*
Última modificación: 16.02.19
Autor: Esquivel Valdez Alberto
*/
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

/*Estructura para la llave*/
struct key
{
    int orig;
    int perm;
};

/*Declaración de las funciones*/
string cifrar(string plainText, int keySize, struct key generatedKey[]);
string descifrar(string plainText, int keySize, struct key decryptKey[]);
void menu();
/*FUNCIÓN: main*/
int main(void)
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
    int keySize;
    int opc = 0;

    string nombre = "";
    string texto = "";
    string plainText = "";
    ifstream ficheroEntrada, ficheroEntrada2;

    while (opc != 3)
    {
        cout << "\n=====Permutation cipher=====\n";
        cout << "\n1. Cifrar\n2. Descifrar\n3. Salir\n";
        cin >> opc;
        cin.ignore();
        switch (opc)
        {
        case 1:
            /*Cifrar*/
            {
                cout << "Enter the size of the key: ";
                cin >> keySize;
                struct key generatedKey[keySize];//Estructura para la llave

                for (int i = 0; i < keySize; i++)
                {
                    generatedKey[i].orig = i;//Asigna un número al cual se asocia la permutación
                    cin >> generatedKey[i].perm;//Asigna el número de la permutación
                    cin.ignore();
                }

                cout << "\nIngresa el nombre del fichero a cifrar: ";
                getline(cin, nombre);//El usuario especifica el nombre del fichero de entrada
                string nombreSalida = nombre + ".per"; //Asigna el nombre del fichero de salida
                ofstream outfile(nombreSalida.c_str());//Abre el fichero de salida
                ficheroEntrada.open(nombre.c_str(), ios::in);//Abre el fichero de entrada
                if (ficheroEntrada.is_open())
                {
                    while (!ficheroEntrada.eof())/*Lee todo el texto del fichero de entrada*/
                    {
                        getline(ficheroEntrada, texto); //El texto del fichero es leído y enviado a la cadena texto
                        plainText += texto;
                    }
                    ficheroEntrada.close(); //Cierra el fichero de entrada
                }
                else
                    cout << "\nError: Fichero inexistente o faltan permisos para abrirlo.\n";
                cout << "\nTexto cifrado.\n";
                outfile << cifrar(plainText, keySize, generatedKey) << endl; //Escribe en el fichero de salida el texto cifrado
                outfile.close();                                             //Cierra el fichero de salida
                plainText = "";//Reinicia el valor de la cadena
                texto = "";//Reinicia el valor de la cadena
            }

            break;
        case 2:
        {
            cout << "Enter the size of the key: ";
            cin >> keySize;//El usuario especifica el tamaño de la llave
            struct key generatedKey[keySize]; /*Estructura para la llave*/
            for (int i = 0; i < keySize; i++)
            {
                generatedKey[i].orig = i; //Asigna un número al cual se asocia la permutación
                cin >> generatedKey[i].perm;//Asigna el número de la permutación
                cin.ignore();
            }
            cout << "\nIngresa el nombre del fichero a descifrar: ";
            getline(cin, nombre);//El suario especifica el nombre del fichero de entrada
            string nomSalida = nombre + ".per"; //Asigna el nombre del fichero de salida
            ofstream outfile2(nomSalida.c_str());//Abre el fichero de salida
            ficheroEntrada2.open(nombre.c_str(), ios::in);//Abre el fichero de entrada
            if (ficheroEntrada2.is_open())
            {
                while (!ficheroEntrada2.eof())/*Lee todo el texto del fichero de entrada*/
                {
                    getline(ficheroEntrada2, texto);
                    plainText += texto;
                }
                ficheroEntrada2.close();//Cierra el fichero de entrada
            }
            else
                cout << "\nError: Fichero inexistente o faltan permisos para abrirlo\n";
            cout << "\nTexto descifrado.\n";
            outfile2 << descifrar(plainText, keySize, generatedKey) << endl;//Escribe en el fichero el texto descifrado
            outfile2.close();//Cierra el fichero de salida
            plainText = "";//Reinicia el valor de la cadena
            texto = "";//Reinicia el valor de la cadena
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
FUNCIÓN: Cifra el mensaje a partir de la permutación. Recorre la cadena y la divide en bloques
para hacer la permutación por bloques, los cuales son del tamaño de la llave.
RECIBE: string plainText, int keySize, struct key llave[]
DEVUELVE: string cifrado */
string cifrar(string plainText, int keySize, struct key generatedKey[])
{
    string cifrado = "";
    char aux[keySize];
    for (int i = 0; i < plainText.size(); i += keySize)
    {
        for (int j = i; j < i + keySize; j++)
        {
            aux[generatedKey[j % keySize].perm] = plainText[j];
        }
        cifrado += string(aux);
    }
    return cifrado;
}
/*
FUNCIÓN: Descifra el mensaje a partir de la permutación. Recorre la cadena y la divide en bloques
para hacer la permutación por bloques, los cuales son del tamaño de la llave.
En la posición original ahora se escribe el caracter correspondiente a la permutación.
RECIBE: string plainText, int keySize, struct key llave[]
DEVUELVE: string cifrado */
string descifrar(string plainText, int keySize, struct key decryptKey[])
{
    string descifrado = "";
    string des = plainText;
    char aux[keySize];
    for (int i = 0; i < plainText.size(); i += keySize)
    {
        for (int j = i; j < i + keySize; j++)
        {
            aux[decryptKey[j % keySize].orig] = plainText[decryptKey[j % keySize].perm + i];
        }
        descifrado += string(aux);
    }
    return descifrado;
}