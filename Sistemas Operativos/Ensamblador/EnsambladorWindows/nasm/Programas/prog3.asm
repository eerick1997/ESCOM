segment .data

        argsTerminateProcess    db 0x00,0x00                            ;Argumentos para la llamada al sistema nativa NtTerminateProcess()
        handleConsola           dd 1                                    ;Primer argumento para la llamada al sistema _WriteConsoleA()
        cadImprimir             db 'Hola',0xA         ;Segundo argumento para la llamada al sistema _WriteConsoleA()
        longitudCadena          dd 1                                    ;Tercero argumento para la llamada al sistema _WriteConsoleA()
        caractEscritos          dd 1                                    ;Cuarto argumento para la llamada al sistema _WriteConsoleA()
        ultimoArgumento         dd 1                                    ;Quinto argumento para la llamada al sistema _WriteConsoleA()
        cadena                  db 5
   
segment .text
       
global  _main
extern  _GetStdHandle@4                                                 ;Acceso externo a la llamada al sistema _GetStdHandle()
extern  _WriteConsoleA@20                                               ;Acceso externo a la llamada al sistema _WriteConsoleA()
                                
_main:  push    dword -11               ;Argumento pasado por la pila y usado en _GetStdHandle() para la salida estandar
        call    _GetStdHandle@4         ;Invocacion de _GetStdHandle()
        mov     [handleConsola],eax     ;Devolucion del manejador de consola para escritura en el registro eax

        xor     eax,eax                 ;Limpieza del registro eax (eax=0)
        mov     eax,5d                 ;eax=23 caracteres de longitud de la cadena a imprimir
        mov     [longitudCadena],eax    ;Se guarda la longitud en memoria
        xor     eax,eax                 ;Limpieza del registro eax (eax=0)
        mov     eax,0d                  ;eax=0 valor del ultimo argumento de _WriteConsoleA()
        mov     [ultimoArgumento],eax   ;Se guarda el valor del ultimo argumento en memoria

        push    dword [ultimoArgumento] ;Quinto argumento de _WriteConsoleA() pasado por la pila
        push    dword caractEscritos    ;Cuarto argumento de _WriteConsoleA() pasado por la pila
        push    dword [longitudCadena]  ;Tercer argumento de _WriteConsoleA() pasado por la pila
        push    dword cadImprimir       ;Segundo argumento de _WriteConsoleA() pasado por la pila
        push    dword [handleConsola]   ;Primer argumento de _WriteConsoleA() pasado por la pila
        call    _WriteConsoleA@20       ;Invocacion de _WriteConsoleA()

        mov edi,cadena
        mov esi,cadImprimir
ciclo:  cmp byte [esi],0xA
        je salir
        mov dl,[esi]
        mov [edi],dl
        inc edi
        inc esi
        jmp ciclo
salir:  mov byte [edi],0xA

        xor     eax,eax            ;Limpieza del registro eax (eax=0)
        xor     edx,edx
        mov     eax,5d                 ;eax=23 caracteres de longitud de la cadena a imprimir
        mov     [longitudCadena],eax    ;Se guarda la longitud en memoria
        xor     eax,eax                 ;Limpieza del registro eax (eax=0)
        mov     eax,0d                  ;eax=0 valor del ultimo argumento de _WriteConsoleA()
        mov     [ultimoArgumento],eax   ;Se guarda el valor del ultimo argumento en memoria

        push    dword [ultimoArgumento] ;Quinto argumento de _WriteConsoleA() pasado por la pila
        push    dword caractEscritos    ;Cuarto argumento de _WriteConsoleA() pasado por la pila
        push    dword [longitudCadena]  ;Tercer argumento de _WriteConsoleA() pasado por la pila
        push    dword cadena       ;Segundo argumento de _WriteConsoleA() pasado por la pila
        push    dword [handleConsola]   ;Primer argumento de _WriteConsoleA() pasado por la pila
        call    _WriteConsoleA@20       ;Invocacion de _WriteConsoleA()
        



        xor    edx,edx                  ;Limpieza del registro edx (edx=0)
        mov    edx,argsTerminateProcess ;edx=Direccion en memoria donde se ubican los argumentos de NtTerminateProcess()
        push   edx                      ;Argumentos de NtTerminateProcess() pasados por la pila
        lea    edx,[esp+4]              ;edx=a la direccion de pila
        mov    eax,0x014E               ;Numero de la llamada al sistema nativa NtTerminateProcess()    
        sysenter                        ;Llamada al sistema NtTerminateProcess()

