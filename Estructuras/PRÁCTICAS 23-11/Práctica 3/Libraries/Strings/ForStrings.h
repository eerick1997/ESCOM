/*
AUTORES:
Tania Itzel Nuñez García
Verónica Jackeline Quiros Díaz
Erick Efraín Vargas Romero
(C) Noviembre 2016
VERSIÓN: 1.0

DESCRIPCIÓN:Con la implementación del TAD lista realizar la implementación de una tabla hash abierta, capaz de soportar
el almacenamiento de palabras y sus definiciones (Diccionario de palabras).

EJECUCIÓN: Práctica 3.exe (En Windows)
*/

//Prototipos de funciones
boolean SubCadena(char* palabra, char* sub_cad);
void Significado(char* Palabra, lista* tabla_hash, int mostrar);
void Separando_Palabras(char* Palabra, char* Definicion, lista* tabla_hash, int mostrar);
