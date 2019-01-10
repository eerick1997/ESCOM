
include main.mac
extrn _strcpy:near
extrn _strlen:near
_modelo exe

_code
rutina _strcat  dest,fuent1,fuent2
        push bx                                           ;Salva registro usado en el programa
        mov ax,[bp].fuent1                       ;toma los parámetros pasados por pila
        push ax                                           ;lo guarda como fuente para la 1ª  llamada a strcpy
        mov ax,[bp].dest                            ;toma los parámetros pasados por pila
        push ax                                           ;lo guarda como destino para la 1ª  llamada a strcpy
        call _strcpy                                     ; llama a copia de string
        pop ax                                             ;recupera la dirección destino de pila
        pop bx                                             ;elimina el otro dato de pila
        mov bx,ax                                       ;guarda la dirección del destino para luego en bx
        push ax                                           ; lo almacena en piula para strlen
        call _strlen                                        ;calcula la longitud
        add sp,2                                             ;elimina los datos de pila
        add bx,ax                                         ;suma al offset de destino, la longitud de destino
        mov ax,[bp].fuent2                         ;Toma la dirección del segundo string 
        push ax                                              ;lo almacena en pila para llamada a strcpy
        push bx                                            ; almacena el offset de destino, que ahora es nuevo
        call _strcpy                                         ;llama a copia de string
        add sp,4                                            ;recupera la pila
        pop bx                                               ;recupera el registro bx
rutina_end    
_data
_end