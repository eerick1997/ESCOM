segment .data
    msg               db "Ingresa una cadena para obtener su longitud:", 10
    longitud1         equ $-msg
    msg2              db "La longitud de la cadena ingresada es: "
    longitud2         equ $-msg2
    handleSalida      dd 0
    caracEscritos     dd 0
    handleEntrada     dd 0
    caracLeidos       dd 0
    longCad           dd 0
    longCadFinal      dd 0

segment .bss
    cadena resb 100

segment .text
global _main
extern _GetStdHandle@4
extern _WriteConsoleA@20
extern _ReadConsoleA@20
extern _ExitProcess@4

_main:
    push -11                                                ;Argumento pasado por la pila y usado en _GetStdHandle() para la salida estándar
    call _GetStdHandle@4                                    ;Invocación de _GetStdHandle()
    mov [handleSalida], eax                                 ;Devolución del manejador de consola para escritura en el registro eax

    ;Imprimir msg
    push 0                                                  ;5to argumento de _WriteConsoleA() pasado por pila
    push dword caracEscritos                                ;4to argumento de _WriteConsoleA() pasado por pila
    push longitud1                                          ;3er argumento de _WriteConsoleA() pasado por pila
    push dword msg                                          ;2do argumento de _WriteConsoleA() pasado por pila
    push dword [handleSalida]                               ;1er argumento de _WriteConsoleA() pasado por pila
    call _WriteConsoleA@20                                  ;Invocación de _WriteConsoleA()

    ;Cambiar a modo lectura
    xor eax,eax                                             ;Limpieza del registro eax (eax=0)
    push dword -10                                          ;Argumento pasado por la pila y usado en _GetStdHandle() para la entrada estándar
    call _GetStdHandle@4                                    ;Invocación de _GetStdHandle()
    mov [handleEntrada],eax                                 ;Devolución del manejador de consola para lectura en el registro eax

    ;leer cadena
    push 0                                                  ;5to argumento de _ReadConsoleA() pasado por pila
    push dword caracLeidos                                  ;4to argumento de _ReadConsoleA() pasado por pila
    push 100                                                ;3er argumento de _ReadConsoleA() pasado por pila
    push dword cadena                                       ;2do argumento de _ReadConsoleA() pasado por pila
    push dword [handleEntrada]                              ;1er argumento de _ReadConsoleA() pasado por pila
    call dword _ReadConsoleA@20                             ;Invocación de _ReadConsole

    xor esi, esi                                           ;Apuntador a origen para operaciones con cadenas de caracteres

    ;Ciclo para conteo de caracteres de la cadena
    loop1:
        mov al, [cadena+esi]
        cmp al, 0
        je continuar
        cmp al, 10
        je continuar
        cmp al, 13
        je continuar

        inc dword [longCad]
        inc esi
        jmp loop1

    continuar:
      xor eax,eax
      mov eax, [longCad]

    loop2:
        xor edx,edx
        mov edx,0
        mov ecx, 10
        div ecx
        add edx,48
        push edx                                           ;Actualiza y se coloca el nuevo valor en el tope de la pila
        cmp eax,0                                          ;Se mantiene en el loop si es distinto de 0
        jne loop2

    ;Imprimir msg2
    push 0
    push dword caracEscritos
    push dword longitud2
    push dword msg2
    push dword [handleSalida]
    call _WriteConsoleA@20

    ;Imprimir longitud de cadena
    imprimir:
        pop edx                                             ;lee el valor del tope de la pila
        cmp edx, 48                                         ;Salta si es menor a 48
        jl terminar
        cmp edx, 57                                         ;salta si es mayor a 57
        jg terminar
        mov [longCadFinal], edx

        ;imprimir la longitud de cadena
        push 0                                              ;5to argumento de _WriteConsoleA() pasado por pila
        push dword caracEscritos                            ;4to argumento de _WriteConsoleA() pasado por pila
        push dword 1                                        ;3er argumento de _WriteConsoleA() pasado por pila
        push dword longCadFinal                             ;2do argumento de _WriteConsoleA() pasado por pila
        push dword [handleSalida]                           ;1er argumento de _WriteConsoleA() pasado por pila
        call _WriteConsoleA@20                              ;Invocación de _WriteConsoleA()

        jmp imprimir

    terminar:
    push 0                                                   ;Argumento de _ExitProcess() pasado por pila
    call _ExitProcess@4                                      ;Invocación de _ExitProcess()