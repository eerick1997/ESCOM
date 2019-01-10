segment .data

        argsTerminateProcess    db 0x00,0x00                            ;Argumentos para la llamada al sistema nativa NtTerminateProcess()
        handleConsola           dd 1                                    ;Primer argumento para la llamada al sistema _ReadConsoleA()
        cadLeer                 resb 30                                 ;Segundo argumento para la llamada al sistema _ReadConsoleA()
        longitudCadena          dd 1                                    ;Tercero argumento para la llamada al sistema _ReadConsoleA()
        caractLeidos            dd 1                                    ;Cuarto argumento para la llamada al sistema _ReadConsoleA()
        ultimoArgumento         dd 1                                    ;Quinto argumento para la llamada al sistema _ReadConsoleA()
   
segment .text
       
global  _main
extern  _GetStdHandle@4                                                 ;Acceso externo a la llamada al sistema _GetStdHandle()
extern  _WriteConsoleA@20                                               ;Acceso externo a la llamada al sistema _WriteConsoleA()
extern  _ReadConsoleA@20                                                ;Acceso externo a la llamada al sistema _ReadConsoleA()
                                
_main:  push    dword -10               ;Argumento pasado por la pila y usado en _GetStdHandle() para la entrada estandar
        call    _GetStdHandle@4         ;Invocacion de _GetStdHandle()
        mov     [handleConsola],eax     ;Devolucion del manejador de consola para lectura en el registro eax

        xor     eax,eax                 ;Limpieza del registro eax (eax=0)
        mov     eax,30d                 ;eax=30 caracteres de longitud de la cadena a leer
        mov     [longitudCadena],eax    ;Se guarda la longitud en memoria
        xor     eax,eax                 ;Limpieza del registro eax (eax=0)
        mov     eax,0d                  ;eax=0 valor del ultimo argumento de _ReadConsoleA()
        mov     [ultimoArgumento],eax   ;Se guarda el valor del ultimo argumento en memoria

        push    dword [ultimoArgumento] ;Quinto argumento de _ReadConsoleA() pasado por la pila
        push    dword caractLeidos      ;Cuarto argumento de _ReadConsoleA() pasado por la pila
        push    dword [longitudCadena]  ;Tercer argumento de _ReadConsoleA() pasado por la pila
        push    dword cadLeer           ;Segundo argumento de _ReadConsoleA() pasado por la pila
        push    dword [handleConsola]   ;Primer argumento de _ReadConsoleA() pasado por la pila
        call    _ReadConsoleA@20        ;Invocacion de _ReadConsoleA()

        xor     eax,eax
        push    dword -11               ;Argumento pasado por la pila y usado en _GetStdHandle() para la salida estandar
        call    _GetStdHandle@4         ;Invocacion de _GetStdHandle()
        mov     [handleConsola],eax     ;Devolucion del manejador de consola para escritura en el registro eax

        xor     eax,eax                 ;Limpieza del registro eax (eax=0)
        mov     eax,30d                 ;eax=30 caracteres de longitud de la cadena a imprimir
        mov     [longitudCadena],eax    ;Se guarda la longitud en memoria
        xor     eax,eax                 ;Limpieza del registro eax (eax=0)
        mov     eax,0d                  ;eax=0 valor del ultimo argumento de _WriteConsoleA()
        mov     [ultimoArgumento],eax   ;Se guarda el valor del ultimo argumento en memoria


		mov		ax,60d
		mov		bl,25d
		div		bl
		add		al,30h
		mov		[cadLeer],al
		mov     eax,1d
		mov		[longitudCadena],eax
		


        push    dword [ultimoArgumento] ;Quinto argumento de _WriteConsoleA() pasado por la pila
        push    dword caractLeidos      ;Cuarto argumento de _WriteConsoleA() pasado por la pila
        push    dword [longitudCadena]  ;Tercer argumento de _WriteConsoleA() pasado por la pila
        push    dword cadLeer           ;Segundo argumento de _WriteConsoleA() pasado por la pila
        push    dword [handleConsola]   ;Primer argumento de _WriteConsoleA() pasado por la pila
        call    _WriteConsoleA@20       ;Invocacion de _WriteConsoleA()

        xor    edx,edx                  ;Limpieza del registro edx (edx=0)
        mov    edx,argsTerminateProcess ;edx=Direccion en memoria donde se ubican los argumentos de NtTerminateProcess()
        push   edx                      ;Argumentos de NtTerminateProcess() pasados por la pila
        lea    edx,[esp+4]              ;edx=a la direccion de pila
        mov    eax,0x014E               ;Numero de la llamada al sistema nativa NtTerminateProcess()    
        sysenter                        ;Llamada al sistema NtTerminateProcess()

