segment .data
	handleConsola dd 1
	longitudCadena dd 1
	caractLeidos dd 1
	ultimoArgumento dd 1
segment .bss
	cadLeer resb 30
segment .text
global _main
extern _GetStdHandle@4
extern _WriteConsoleA@20
extern _ReadConsoleA@20
extern _ExitProcess@4

_main:	push dword -10
		call _GetStdHandle@4
		mov [handleConsola],eax

		xor eax,eax
		mov eax,30d
		mov [longitudCadena],eax
		xor eax,eax
		mov eax,0d
		mov [ultimoArgumento],eax

		push dword [ultimoArgumento]
		push dword caractLeidos
		push dword [longitudCadena]
		push dword cadLeer
		push dword [handleConsola]
		call _ReadConsoleA@20

		xor eax,eax
		push dword -11
		call _GetStdHandle@4
		mov [handleConsola],eax

		xor eax,eax
		mov eax,30d
		mov [longitudCadena],eax
		xor eax,eax
		mov eax,0d
		mov [ultimoArgumento],eax
		
		push dword [ultimoArgumento]
		push dword caractLeidos
		push dword [longitudCadena]
		push dword cadLeer
		push dword [handleConsola]
		call _WriteConsoleA@20

		xor eax,eax
		mov eax,0d
		mov [ultimoArgumento],eax
		push dword [ultimoArgumento]
		call _ExitProcess@4
