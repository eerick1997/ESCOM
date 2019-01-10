segment .data
	handleConsola	dd 	1
	longitudCadena	dd	1
	caractLeidos	dd	1
	ultimoArgumento	dd	1

	cadMsj: db 10,10, 'Ingresa la cadena a leer', 0xA
	cadLen equ $ -cadMsj

segment .bss
	cadLeer			resb 30

segment .text

global _main
extern _GetStdHandle@4
extern _WriteConsoleA@20
extern _ReadConsoleA@20	
extern _ExitProcess@4

_main:
	; ---> Para leer cadenas <---
	call mostrarEntrada				;Llamamos a la subrutina mostrarEntrada
	xor eax, eax					;Limpiamos buffer

	push dword -10					;Argumento pasado por la pila usado en _GetStdHandle() para entrada standar
	call _GetStdHandle@4			;Invocación del método _GetStdHandle()
	mov [handleConsola],eax			;Devolución del manejador de consola para lectura en el registro eax

	xor	eax, eax					;Limpiamos el registro eax
	mov eax,30d						;eax = 30 caracteres, máximo de una cadena a cadena a leer
	mov [longitudCadena], eax		;Guardamos la longitud en memoria
	xor eax, eax					;Limpiamos el registro eax
	mov eax, 0d						;eax = 0 valor del último argumento de _ReadConsoleA()
	mov [ultimoArgumento], eax		;Se guarda el valor del ultimo argumento en memoria

	push dword [ultimoArgumento]	;Quinto argumento de _ReadConsoleA() a la pila
	push dword caractLeidos 		;Cuarto argumento de _ReadConsoleA() a la pila
	push dword [longitudCadena]		;Tercer	argumento de _ReadConsoleA() a la pila
	push dword cadLeer 				;Segundo argumento de _ReadConsoleA() a la pila
	push dword [handleConsola] 		;Primer argumento de _ReadConsoleA() a la pila
	call _ReadConsoleA@20			;Lalamada de _ReadConsoleA() a la pila

	; ---> Para imprimir <---
	xor eax, eax					;Limpiamos el registro eax
	push dword -11					;Argumento pasado por la pila y usado en _GetStdHandle() para salida estandar
	call _GetStdHandle@4			;Invocación de _GetStdHandle()
	mov	[handleConsola], eax		;Devolución del manejador de consola en el registro eax

	xor eax, eax					;Limpiamos el registro eax	
	mov eax, 30d					;Se imprimirá una cadena de hasta 30 caracteres
	mov [longitudCadena],eax		;Se guarda el valor de la longitud en memoria
	xor eax, eax					;Limpiamos buffer
	mov eax, 0d						;Valor del quinto argumento
	mov [ultimoArgumento], eax 		;Almecenamos el valor de eax en ultimoArgumento

	push dword [ultimoArgumento]	;Quinto argumento de _WriteConsoleA@20
	push dword caractLeidos			;Cuarto argumento de _WriteConsoleA@20
	push dword [longitudCadena]		;Tercer argumento de _WriteConsoleA@20	
	push dword cadLeer				;Segundo argumento de _WriteConsoleA@20
	push dword [handleConsola]		;Primer argumento de _WriteConsoleA@20
	call _WriteConsoleA@20			;Llamada de _WriteConsoleA@20

	; ---> Salida del programa <---
	xor eax, eax					;Limpiamos la variable eax
	mov eax, 0d						;eax = 0 valor del argumento _ExitProcess()
	push dword [ultimoArgumento]	;Argumento de _ExitProcess()
	call _ExitProcess@4				;Invocación de _ExitProcess()

	mostrarEntrada:
		push dword -11
		call _GetStdHandle@4
		mov [handleConsola], eax
		mov eax, 30d
		mov [longitudCadena], eax

		push dword [ultimoArgumento]
		push dword caractLeidos
		push dword [longitudCadena]
		push dword cadMsj
		push dword [handleConsola]
	ret