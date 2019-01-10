/*
Autores:
Núñez García Tania Itzel
Quiros Díaz Verónica Jackeline
Vargas Romero Erick Efraín

Versión 1.0 (12 Octubre 2016)
Descripción: Cabecera de la libreria para recrear presentaciones más agradables al usuario en el modo consola
*/

//DEFINICIONES DE CONSTANTES
#define ALTO 15			//Se define un alto de 7 caracteres
#define ANCHO 18.5         //Se define un ancho de 7 caracteres
#define TIEMPO_BASE	30	//Tiempo base en milisegundos
#define MULTIPLICADOR 21  //Se define un multiplicador de 8
#define MULT 2

/*
typedef struct para_texto
{
	int en_espera;
	int atendiendo;
	int por_atender;
	int ultima;
	int tam_cola;
}para_texto;
*/

void Cajas();
void Marco();
void Titulo();
void Texto1(para_texto texto);
void Texto2(para_texto texto);
void Texto3(para_texto texto);
void Texto4(para_texto texto);
void Texto5(para_texto texto);
void Texto6(para_texto texto);
void Texto7(para_texto texto);
void Texto8(para_texto texto);
void Texto9(para_texto texto);
void DibujaColas();
void TextoCola1(para_texto texto);
void TextoCola2(para_texto texto);
void TextoCola3(para_texto texto);
