global _main
	extern _GetStdHandle@4
	extern _ExitProcess@4
	extern _WriteConsoleA@20
	extern _ReadConsoleA@20

segment .data
cadenaMsj: db 10,10, '-Calculadora-',10,10,'1.- Sumar',10,'2.- Restar',10,'3.- Multiplicar',10,'4.- Dividir',10,10,'Opcion: ',0xA
cadLen equ $ - cadenaMsj
Msj1: db 10,10,'Ingresa los numeros a operar',0xA
cadLen1 equ $ - Msj1
Msj2: db 'Numero 1: ',0 
cadLen2 equ $ - Msj2
Msj3: db 'Numero 2: ',0
cadLen3 equ $ - Msj3
rsuma: db 'La suma es: ',0
lrsuma equ $ - rsuma
rresta: db 'La resta es: ',0
lrresta equ $ - rresta
rmulti: db 'La multiplicacion es: ',0
lrmulti equ $ - rmulti
rdiv: db 'La division es: ',0
lrdiv equ $ - rdiv
handle: db 0
cadenaEscrita: db 0
StringNum1Leida: db 0

segment .bss
StringNum1 resb 30
StringNum2 resb 30
longNum1 resb 30
longNum2 resb 30
Num1 resb 30
Num2 resb 30
resu resb 30
resuDiv resb 30
auxAcu resb 30
aux resb 30
auxCon resb 30
op resb 30

segment .text
_main:
	call mostrarMenu

	push dword -10
	call _GetStdHandle@4
	mov [handle],eax
	push dword 0d
	push StringNum1Leida
	push 5d
	push op
	push dword [handle]
	call _ReadConsoleA@20

	call imprimirMsj1
	call imprimirMsj2
	push dword -10
	call _GetStdHandle@4
	mov [handle],eax
	push dword 0d
	push StringNum1Leida
	push 5d
	push StringNum1
	push dword [handle]
	call _ReadConsoleA@20

	call imprimirMsj3

	push dword -10
	call _GetStdHandle@4
	mov [handle],eax
	push dword 0d
	push StringNum1Leida
	push 5d
	push StringNum2
	push dword[handle]
	call _ReadConsoleA@20

	call longitudN1
	call longitudN2
	call convANum1
	call convANum2

	sub byte[op],'0'

	cmp byte[op],1d
	je sumar

	cmp byte[op],2d
	je restar

	cmp byte[op],3d
	je multiplicar

	cmp byte[op],4d
	je dividir

	push 0
	call _ExitProcess@4

	sumar:
	mov eax,[Num1]
	add eax,[Num2]
	mov [resu], eax
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push lrsuma
		push rsuma
		push dword [handle]
		call _WriteConsoleA@20
		call convAText
		push 0
		call _ExitProcess@4
	ret

	restar:
	mov eax,[Num1]
	sub eax,[Num2]
	mov [resu], eax
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push lrresta
		push rresta
		push dword [handle]
		call _WriteConsoleA@20
		call convAText
		push 0
		call _ExitProcess@4
	ret

	multiplicar:
	mov eax,[Num1]
	mov ebx,[Num2]
	mul ebx
	mov [resu],eax
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push lrmulti
		push rmulti
		push dword [handle]
		call _WriteConsoleA@20
		call convAText
		push 0
		call _ExitProcess@4
	ret

	dividir: 
	xor edx,edx
	mov eax,[Num1]
	mov ebx,[Num2]
	div ebx
	mov [resu],eax
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push lrdiv
		push rdiv
		push dword [handle]
		call _WriteConsoleA@20
		call convAText
		push 0
		call _ExitProcess@4
	ret

	longitudN1:
		mov esi, StringNum1
		mov byte[longNum1],0d
		lpLN1:
			mov al,byte[esi]
			cmp al,0xA
			jz finLongN1
			add byte[longNum1],1d
			inc esi
		loop lpLN1

		finLongN1:
		dec byte[longNum1]
	ret

	longitudN2:
		mov esi, StringNum2
		mov byte[longNum2],0d
		lpLN2:
			mov al,byte[esi]
			cmp al,0xA
			jz finLongN2
			add byte[longNum2],1d
			inc esi
		loop lpLN2
		finLongN2:
		dec byte[longNum2]
	ret

	convANum1:
		mov esi,StringNum1
		mov ebx,[longNum1]
		dec ebx
		add esi, ebx
		mov al, [esi]
		sub al, '0'
		mov [auxAcu],al
		mov ecx,10d
		mov ebx,[longNum1]
		mov [auxCon],ebx
		dec byte[auxCon]
		a1:
			cmp byte[auxCon],0d
			je fin1
			dec esi
			mov al,[esi]
			sub al,'0'
			mov [aux],al
			mov eax,[aux]
			mul ecx
			add [auxAcu],eax
		mov eax,ecx
		mov ecx,10d
		mul ecx
		mov ecx,eax
		dec byte[auxCon]
		loop a1
		fin1:
		cmp byte[longNum1],3
		jb termino1
		add byte[auxAcu],1d
		termino1:
		mov eax,[auxAcu]
		mov [Num1],eax
	ret

	convANum2:
		mov esi, StringNum2
		mov ebx,[longNum2]
		dec ebx
		add esi,ebx
		mov al,[esi]
		sub al,'0'
		mov [auxAcu],al
		mov ecx,10d
		mov ebx,[longNum2]
		mov [auxCon],ebx
		dec byte[auxCon]
		a2:
			cmp byte[auxCon],0d
			je fin2
			dec esi
			mov al, [esi]
			sub al, '0'
			mov [aux],al
			mov eax,[aux]
			mul ecx
			add [auxAcu],eax
		mov eax,ecx
		mov ecx,10d
		mul ecx
		mov ecx,eax
		dec byte[auxCon]
		loop a2
		fin2:
		cmp byte[longNum2],3
		jb termino2
		add byte[auxAcu],1d
		termino2:
		mov eax,[auxAcu]
		mov [Num2],eax
	ret

	convAText:
		mov eax,[resu]
		mov ecx,10d
		mov ebx,0d
		aCAT:
			xor edx,edx
			div ecx
			push edx
			inc ebx
			cmp byte[aux],2d
			jbe finCAT
		loop aCAT
		finCAT:
		cmp al,1d
		jb sacar
		push eax
		inc ebx

	sacar:
		cmp ebx,0d
		je salir
		pop ecx
		mov [aux],ecx
		add byte[aux],'0'
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push StringNum1Leida
		push 1
		push aux
		push dword [handle]
		call _WriteConsoleA@20
		dec ebx
		loop sacar
		salir:
	ret

	mostrarMenu:
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push cadLen
		push cadenaMsj
		push dword [handle]
		call _WriteConsoleA@20
	ret

	imprimirMsj1:
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push cadLen1
		push Msj1
		push dword [handle]
		call _WriteConsoleA@20
	ret

	imprimirMsj3:
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push cadLen3
		push Msj3
		push dword [handle]
		call _WriteConsoleA@20
	ret

	imprimirMsj2:
		push dword -11
		call _GetStdHandle@4
		mov [handle],eax
		push dword 0
		push cadenaEscrita
		push cadLen2
		push Msj2
		push dword [handle]
		call _WriteConsoleA@20
	ret