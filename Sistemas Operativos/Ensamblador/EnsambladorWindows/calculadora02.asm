segment .data
  menu db 'Ingresa una opcion:', 0x0A, '1. Multiplicacion', 0x0A, '2. Division', 0x0A, '3. Suma', 0x0A, '4. Resta', 0x0A ;
  longitudMenu       equ $-menu
	msgOpcion          db "Digite la opcion: " ,0xA,0xD
	longitud1          equ $-msgOpcion
	msgNumero1         db "Digita el numero 1: ",0xA
	longitud2          equ $-msgNumero1
	msgNumero2         db "Digita el numero 2: ",0xA
	longitud3          equ $-msgNumero2
	msgOpcionInvalida  db "Error de opcion",0xA
	longitud4          equ $-msgOpcionInvalida
	msgResultado       db 0xD,"El resultado es: ",0xA
	longitud5          equ $-msgResultado
  msgDivError        db 0xD,"No esposible dividir entre 0",0xA
	longitud6         equ $-msgDivError
  handleEntrada      dd 0              ;1er argumento para la llamada al sistema _ReadConsoleA()
  handleSalida       dd 0              ;1er argumento para la llamada al sistema _WriteConsoleA()
  longitudCadena     dd 0              ;3er argumento para la llamada al sistema _WriteConsoleA()
  caracEscritos      dd 0              ;4to argumento para la llamada al sistema _WriteConsoleA()
  caracLeidosop      dd 0              ;4to argumento para la llamada al sistema _WriteConsoleA()
  caracLeidosnum1    dd 0              ;4to argumento para la llamada al sistema _WriteConsoleA()
  caracLeidosnum2    dd 0              ;4to argumento para la llamada al sistema _WriteConsoleA()
  ultimoArgumento    dd 0              ;5to argumento para la llamada al sistema _WriteConsoleA()

segment .bss
  opc                  resb 10 				 ;Reserva 1 byte de memoria para variable resb
  num1                 resb 10 				 ;Reserva 1 byte de memoria para variable num1
  num2                 resb 10 				 ;Reserva 1 byte de memoria para variable num2
  resultadoStr         resb 10 			   ;Reserva 1 byte de memoria para variable resultado
  opcion               resd 1
  n1                   resd 1
  n2                   resd 1
  resultado            resd 1
  longitudResultadoStr resd 1

segment .text

  global _main
  extern _GetStdHandle@4        ;Acceso externo a la llamada al sistema _GetStdHandle()
  extern _WriteConsoleA@20          ;Acceso externo a la llamada al sistema _WriteConsoleA()
  extern _ExitProcess@4         ;Acceso externo a la llamada al sistema _ExitProcess()
  extern _ReadConsoleA@20           ;Acceso externo a la llamada al sistema _ReadConsole()

_main:
      push dword -10                 ;Argumento pasado por la pila y usado en _GetStdHandle() para la entrada estándar
      call _GetStdHandle@4           ;Invocación de _GetStdHandle()
      mov [handleEntrada],eax        ;Devolución del manejador de consola para lectura en el registro eax

      push dword -11                 ;Argumento pasado por la pila y usado en _GetStdHandle() para la salida estándar
      call _GetStdHandle@4           ;Invocación de _GetStdHandle()
      mov [handleSalida],eax         ;Devolución del manejador de consola para escritura en el registro eax

      ;Imprimir menu
      push 0                         ;5to argumento de _WriteConsoleA() pasado por pila
      push dword caracEscritos       ;4to argumento de _WriteConsoleA() pasado por pila
      push dword longitudMenu        ;3er argumento de _WriteConsoleA() pasado por pila
      push dword menu                ;2do argumento de _WriteConsoleA() pasado por pila
      push dword [handleSalida]      ;1er argumento de _WriteConsoleA() pasado por pila
      call _WriteConsoleA@20         ;Invocación de _WriteConsoleA()

      ;Imprimir mensaje msgOpcion
      push 0                         ;5to argumento de _WriteConsoleA() pasado por pila
      push dword caracEscritos       ;4to argumento de _WriteConsoleA() pasado por pila
      push dword longitud1           ;3er argumento de _WriteConsoleA() pasado por pila
      push dword msgOpcion           ;2do argumento de _WriteConsoleA() pasado por pila
      push dword [handleSalida]      ;1er argumento de _WriteConsoleA() pasado por pila
      call _WriteConsoleA@20         ;Invocación de _WriteConsoleA()

    ;leerOpcion:
      ;Leer opción
      ;Comenzar captura
      push 0                              ;5to argumento de _ReadConsoleA() pasado por pila
      push dword caracLeidosop            ;4to argumento de _ReadConsoleA() pasado por pila
      push dword 10                       ;3er argumento de _ReadConsoleA() pasado por pila
      push dword opc                      ;2do argumento de _ReadConsoleA() pasado por pila
      push dword [handleEntrada]          ;1er argumento de _ReadConsoleA() pasado por pila
      call _ReadConsoleA@20               ;Invocación de _ReadConsoleA()

    ;capturarNumeros:
      ;Imprimir mensaje msgNumero1
      push 0                        ;5to argumento de _WriteConsoleA() pasado por pila
      push dword caracEscritos      ;4to argumento de _WriteConsoleA() pasado por pila
      push dword longitud2          ;3er argumento de _WriteConsoleA() pasado por pila
      push dword msgNumero1         ;2do argumento de _WriteConsoleA() pasado por pila
      push dword [handleSalida]     ;1er argumento de _WriteConsoleA() pasado por pila
      call _WriteConsoleA@20        ;Invocación de _WriteConsoleA()

      ;Leer num1
      push 0                        ;5to argumento de _ReadConsoleA() pasado por pila
      push dword caracLeidosnum1    ;4to argumento de _ReadConsoleA() pasado por pila
      push dword 10                 ;3er argumento de _ReadConsoleA() pasado por pila
      push dword num1               ;2do argumento de _ReadConsoleA() pasado por pila
      push dword [handleEntrada]    ;1er argumento de _ReadConsoleA() pasado por pila
      call _ReadConsoleA@20

      ;Impresion de msgNumero2
      push 0                        ;5to argumento de _WriteConsoleA() pasado por pila
      push dword caracEscritos      ;4to argumento de _WriteConsoleA() pasado por pila
      push dword longitud3          ;3er argumento de _WriteConsoleA() pasado por pila
      push dword msgNumero2         ;2do argumento de _WriteConsoleA() pasado por pila
      push dword [handleSalida]     ;1er argumento de _WriteConsoleA() pasado por pila
      call _WriteConsoleA@20        ;Invocación de _WriteConsoleA()

      ;Leer num2
      push 0                        ;5to argumento de _ReadConsoleA() pasado por pila
      push dword caracLeidosnum2    ;4to argumento de _ReadConsoleA() pasado por pila
      push dword 10                 ;3er argumento de _ReadConsoleA() pasado por pila
      push dword num2               ;2do argumento de _ReadConsoleA() pasado por pila
      push dword [handleEntrada]    ;1er argumento de _ReadConsoleA() pasado por pila
      call _ReadConsoleA@20

      mov esi, opc
      call cadAint
      mov [opcion], eax

      mov esi, num1
      call cadAint
      mov [n1], eax

      mov esi, num2
      call cadAint
      mov [n2], eax

    ;switch:
      ;Convierte la opción a valor ASCII
      mov eax,[opcion]							     ;Se mueve opc al registro ah
    	;Evaluar opción
    	cmp al,1
    	je  multiplicar
    	cmp al,2
    	je dividir
    	cmp al,3
    	je suma
    	cmp al,4
    	je resta
      cmp al,5
    	je salida
      ;En caso de error se sale del programa
      ;Imprimir mensaje msgOpcionInvalida
      push 0                        ;5to argumento de _WriteConsoleA() pasado por pila
      push dword caracEscritos      ;4to argumento de _WriteConsoleA() pasado por pila
      push dword longitud4          ;3er argumento de _WriteConsoleA() pasado por pila
      push dword msgOpcionInvalida  ;2do argumento de _WriteConsoleA() pasado por pila
      push dword [handleSalida]     ;1er argumento de _WriteConsoleA() pasado por pila
      call _WriteConsoleA@20        ;Invocación de _WriteConsoleA()
      jmp salida


    multiplicar:
      xor eax, eax
      xor edx, edx
      mov eax,[n1]
      mul dword [n2]
      mov [resultado],eax
      ;Se imprime el resultado
      jmp impResultado

    dividir:
      xor eax, eax
      xor edx, edx
      mov eax,[n1]
      ;Division al=ax/bl
      div dword [n2]
      ;Se mueve el resultado a eax
      mov [resultado],eax
      ;Se imprime el resultado
      jmp impResultado

    suma:
      xor eax, eax
      ;Se mueven los datos de los numeros a los registros
    	mov eax, [n1]
    	;Se suman los valores
    	add eax,[n2]
    	;Se mueve el resultado a eax
    	mov [resultado],eax
      ;Se imprime el resultado
      jmp impResultado

    resta:
      xor eax, eax
      ;Se mueven los datos de los numeros a los registros
      mov eax, [n1]
      ;Se restan los valores
      sub eax,[n2]
      ;Se mueve el resultado a eax
      mov [resultado],eax
      ;Se imprime el resultado
      jmp impResultado

    impResultado:
      ;convertimos el resultado a string
      mov eax, [resultado]
      mov edi, resultadoStr
      call intAcad
      mov [longitudResultadoStr], eax
      ;Impresion de msgResultado
      push 0                        ;5to argumento de _WriteConsoleA() pasado por pila
      push dword caracEscritos      ;4to argumento de _WriteConsoleA() pasado por pila
      push dword longitud5          ;3er argumento de _WriteConsoleA() pasado por pila
      push dword msgResultado       ;2do argumento de _WriteConsoleA() pasado por pila
      push dword [handleSalida]     ;1er argumento de _WriteConsoleA() pasado por pila
      call _WriteConsoleA@20        ;Invocación de _WriteConsoleA()
      push 0                        ;5to argumento de _WriteConsoleA() pasado por pila
      push dword caracEscritos      ;4to argumento de _WriteConsoleA() pasado por pila
      push dword [longitudResultadoStr];3er argumento de _WriteConsoleA() pasado por pila
      push dword resultadoStr        ;2do argumento de _WriteConsoleA() pasado por pila
      push dword [handleSalida]     ;1er argumento de _WriteConsoleA() pasado por pila
      call _WriteConsoleA@20        ;Invocación de _WriteConsoleA()
      jmp salida

    cadAint:
      xor eax, eax        ;Limpieza del resigtro eax
      xor edx, edx        ;Limpieza del resigtro edx

      .loop:
        mov dl, byte [esi]  ;Obtener un caracter
        cmp dl, 10          ;Es valido?
        je .fin
        cmp dl, 13
        je .fin
        cmp dl, 0
        je .fin
        lea eax, [eax*5]
        add eax, eax
        add esi, 1
        and dl, 0x0F
        add eax, edx        ;Agregar en el digito actual
        jmp .loop

      .fin:
        ret                 ;retornar entero

    intAcad:
      xor ecx, ecx
      xor ebx, ebx
      mov ebx, 10
      .apilar:
        xor edx, edx
        div ebx
        push dx
        inc cl
        test eax, eax
        jnz .apilar

      mov ebx, ecx

      .desapilar:
        pop ax
        or al, 0x30
        mov byte[edi], al
        inc edi
        sub cl, 1
        jnz .desapilar

      mov byte[edi], 0
      mov eax, ebx
      ret

    salida:
      ;Salida
      xor eax,eax                     ;Limpieza del registro eax (eax=0)
      push 0                          ;Argumento de _ExitProcess() pasado por pila
      call _ExitProcess@4             ;Invocación de _ExitProcess