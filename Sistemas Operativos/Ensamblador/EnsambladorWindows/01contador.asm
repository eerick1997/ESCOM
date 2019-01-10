segment .data
	handleConsola	dd 1
	longitudCadena	dd 1
	caractEscritos	dd 1
	ultimoArgumento	dd 1
	
segment .bss
	cadLeer			resb 30

global _main
	extern _GetStdHandle@4
	extern _ExitProcess@4
	extern _WriteConsoleA@20
	extern _ReadConsoleA@20
	mov ecx, 0

segment .text
_main:
	mov ecx, 0

nextNumber:

	push dword -11
	call _GetStdHandle@4

	inc ecx

	mov eax, ecx
	add eax, 48
	push eax
	mov eax, esp
	call _WriteConsoleA@20 ;Llamadas al sistema para salida estandar

	pop eax
	cmp ecx, 10
	jne nextNumber
ret