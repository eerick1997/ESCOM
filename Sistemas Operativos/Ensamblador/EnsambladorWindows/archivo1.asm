segment .data
	
	handleConsola dd 1 
	cadImprimir db 'Ensamblando en Windows',0xA
	longitudCadena dd 1
	caractEscritos dd 1
	ultimoArgumento dd 1

segment .text

global _main
extern _GetStdHandle@4
extern _WriteConsoleA@20
extern _ExitProcess@4

_main: push dword -11
	  call _GetStdHandle@4
	  mov [handleConsola],eax

	  xor eax,eax
	  mov eax,23d
	  mov [longitudCadena],eax
	  xor eax,eax
	  mov eax,0d
	  mov [ultimoArgumento],eax

	  push dword [ultimoArgumento]
	  push dword caractEscritos
	  push dword [longitudCadena]
	  push dword cadImprimir
	  push dword [handleConsola]
	  call _WriteConsoleA@20

	  xor eax,eax
	  mov eax,0d
	  mov [ultimoArgumento],eax
	  push dword [ultimoArgumento]
	  call _ExitProcess@4