segment .bss
cadena1 resb 50
cadena2 resb 50
cadena3 resb 50
cadena5 resb 200

segment .data
handleConsola dd 1
longitudCadena dd 1
caractEscritos dd 1
caractLeidos dd 1
ultimoArgumento dd 1
cadena4 db '*****************************',0xA

segment .text

global _main
extern _GetStdHandle@4
extern _WriteConsoleA@20
extern _ReadConsoleA@20
extern _ExitProcess@4

_main:
    push dword -10
    call _GetStdHandle@4
    mov [handleConsola],eax
    
    xor eax,eax
    mov eax,50d
    mov [longitudCadena],eax
    xor eax,eax
    mov eax,0d
    mov [ultimoArgumento],eax
    
    push dword [ultimoArgumento]
    push dword caractLeidos
    push dword [longitudCadena]
    push dword cadena1
    push dword [handleConsola]
    call _ReadConsoleA@20
    
    push dword -10
    call _GetStdHandle@4
    mov [handleConsola],eax
    
    xor eax,eax
    mov eax,50d
    mov [longitudCadena],eax
    xor eax,eax
    mov eax,0d
    mov [ultimoArgumento],eax
    
    push dword [ultimoArgumento]
    push dword caractLeidos
    push dword [longitudCadena]
    push dword cadena2
    push dword [handleConsola]
    call _ReadConsoleA@20
    
    push dword -10
    call _GetStdHandle@4
    mov [handleConsola],eax
    
    xor eax,eax
    mov eax,50d
    mov [longitudCadena],eax
    xor eax,eax
    mov eax,0d
    mov [ultimoArgumento],eax
    
    push dword [ultimoArgumento]
    push dword caractLeidos
    push dword [longitudCadena]
    push dword cadena3
    push dword [handleConsola]
    call _ReadConsoleA@20
    
    mov eax,cadena1
    mov ebx,cadena2
    mov ecx,cadena3
    
    mov edi,cadena4
    mov cl,0

ciclocad1:
    mov esi,cadena1

ciclo1:
    cmp BYTE[ESI],0xA
    je limpiar
    
    mov dl,[ESI]
    mov [EDI],dl
    inc ESI
    inc EDI
    inc EDI
    inc EDI
    inc cl
    inc cl
    inc cl
    
    jmp ciclo1
limpiar:
cmp BYTE cl,0

je ciclocad2
dec cl
dec EDI
jmp limpiar

ciclocad2:
    mov esi,cadena2
    inc EDI
    
ciclo2:
    cmp BYTE[ESI],0xA
    je limpiar2
    
    mov dl,[ESI]
    mov [EDI],dl
    
    inc ESI
    inc EDI
    inc EDI
    inc EDI
    inc cl
    inc cl
    inc cl
    
    jmp ciclo2

limpiar2:
    cmp BYTE cl,0
    je ciclocad3
    
    dec cl
    dec EDI
    jmp limpiar2
    
ciclocad3:
    mov esi,cadena3
    inc EDI

ciclo3:
    cmp BYTE[ESI],0xA
    je limpiar3
    
    mov dl,[ESI]
    mov [EDI],dl
    
    inc ESI
    inc EDI
    inc EDI
    inc EDI
    
    jmp ciclo3
    
limpiar3:
    mov edi,cadena5
    mov esi,cadena4
    
limpiar3bien:
    cmp BYTE[ESI],0x2A
    je limpiar3borrar
    
    cmp BYTE[ESI],0xA
    je Imprimir
    
    mov dl,[ESI]
    mov [EDI],dl
    
    inc ESI
    inc EDI
    
    jmp limpiar3bien

limpiar3borrar:
    inc ESI
    jmp limpiar3bien
    
Imprimir:
    push dword -11
    call _GetStdHandle@4
    mov [handleConsola],eax
    
    xor eax,eax
    mov eax,6d
    mov [longitudCadena],eax
    xor eax,eax
    mov eax,0d
    mov [ultimoArgumento],eax
    
    push dword [ultimoArgumento]
    push dword caractEscritos
    push dword [longitudCadena]
    push dword cadena4
    push dword [handleConsola]
    call _WriteConsoleA@20
    
    xor eax,eax
    mov eax,0d
    mov [ultimoArgumento],eax
    push dword [ultimoArgumento]
    call _ExitProcess@4
    
    
    
    
    
    


    
    