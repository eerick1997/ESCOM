segment .data

	handleConsola	dd 1
	longitudCadena	dd 1
	caractLeidos	dd 1
	ultimoArgumento	dd 1


segment .bss
	aImprimir		resb 1

segment .text
	global _main
	extern _GetStdHandle@4
	extern _WriteConsoleA@20
	extern _ExitProcess@4

_main:
	
	mov ecx, 47						;47 = / en ascii

count:

	push	dword -11 				;Argumento pasado por la pila y usado en _GetStdHandle() para salida estandar
	call 	_GetStdHandle@4			;Invocación de _GetStdHandle()
	mov		[handleConsola],eax		;Devolucion del manejador de consola para escritura en el registro eax


	mov 	eax,1d					;eax = 1 caracteres de longitud de la cadena a imprimir
	mov 	[longitudCadena],eax	;Se guarda la longitud en memoria

	mov		eax,0d					;Valor del último argumento de _WriteConsoleA()
	mov		[ultimoArgumento],eax	;Se guarda el valor de último argumento en memoriax

	inc ecx							;Autoincrementamos la variable ecx

	mov eax, ecx					;movemos el contenido del registro ecx a el registro eax

	mov [aImprimir], eax			;Movemos a aImprimir

	push	dword 0					
	push	dword caractLeidos		
	push 	dword [longitudCadena]
	push	dword aImprimir
	push	dword [handleConsola]
	call	_WriteConsoleA@20		;Llamada a la función _WriteConsole()

    mov ecx, [aImprimir]			;Movemos el contenido de aImprimir a la variable ecx
	cmp ecx, 57						;Comparamos si el valor de acx es igual a 57 em ascii
		jne count					;Si no es 57 en ascii entonces llamamos a count

	xor		eax, eax				;Limpiamos buffer
	mov		eax, 0d					;eax = 0 valor del argumento de _ExitProcess()
	mov		[ultimoArgumento],eax	;Se guarda el valor del último argumento en memoria
	push	dword [ultimoArgumento]	;Argumento de _ExitProcess() pasado por pila
call _ExitProcess@4



