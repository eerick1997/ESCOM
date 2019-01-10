/*
Autor: Edgardo Adrián Franco Martínez
Versión 1.0 (25 de Septiembre 2012)
Descripción: Cabecera de la libreria para recrear presentaciones más agradables al usuario en el modo consola

Observaciones: La implementación de esta libreria es distinta si se trata de Windows o Linux, ya que requerirá de funciones no ANSI C
*/
//DECLARACIÓN DE FUNCIONES
void MoverCursor( int x, int y ); 	//Función para mover el cursor de escritura de pantalla, simulación de la función gotoxy() que se tenia en borland 3.0 en la libreria conio.h

void EsperarMiliSeg(int t);			//Función para esperar un tiempo en milisegundos, simulación de la función delay() que se tenia en borland 3.0 en la libreria conio.h

void BorrarPantalla(void);			//Función para borrar la pantalla de la consola, simulación de la función clrscr() que se tenia en borland 3.0 en la libreria conio.h
