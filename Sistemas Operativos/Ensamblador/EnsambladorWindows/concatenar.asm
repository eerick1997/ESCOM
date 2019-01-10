segment .model small  
segment .stack 100h  
segment .data  
  
msg1 db "Enter the first string: $"  
msg2 db 0ah, 0dh, "Enter the second string: $"  
msg3 db 0ah, 0dh, "Enter the third string: $"  
msg4 db 0ah, 0dh, "Enter the fourht string: $"  
msg5 db 0ah, 0dh, "Enter the fifth string: $"  
msg6 db 0ah, 0dh, "Enter the sixth string: $"  
msg7 db 0ah, 0dh, "Enter the seventh string: $"  
msg8 db 0ah, 0dh, "Enter the eighth string: $"  
msg9 db 0ah, 0dh, "Enter the ninth string: $"  
msg10 db 0ah, 0dh, "Enter the tenth string: $"  
msg11 db 0ah, 0dh, "New string is: $"  
  
; For each buffered input, we have to reserve space such that  
tsize1 db 10        ; First byte contains a value that indicates the number of characters to be received at maximum  
asize1 db ?         ; Second byte is reserved for interrup  t's use  
array1 db 10 dup(?) ; The third byte and on for saving the input. The minimum amount of space required  
                    ; here is equal to the value of first byte  
  
; Segunda entrada  
tsize2 db 10  
asize2 db ?  
array2 db 10 dup(?)  
  
; Tercera entrada  
tsize3 db 10  
asize3 db ?  
array3 db 10 dup(?)  
  
;Cuarta entrada  
tsize4 db 10  
asize4 db ?  
array4 db 10 dup(?)  
  
;Quinta entrada  
tsize5 db 10  
asize5 db ?  
array5 db 10 dup(?)  
  
;Sexta entrada  
tsize6 db 10  
asize6 db ?  
array6 db 10 dup(?)  
  
;Septima entrada  
tsize7 db 10  
asize7 db ?  
array7 db 10 dup(?)  
  
;Octaba entrada  
tsize8 db 10  
asize8 db ?  
array8 db 10 dup(?)  
  
;Novena entrada  
tsize9 db 10  
asize9 db ?  
array9 db 10 dup(?)  
  
;Decima entrada  
tsize10 db 10  
asize10 db ?  
array10 db 10 dup(?)  
  
; Aqui las cadenas van a ser concatenadas, asi que tiene que ser la suma de sus tamanos  
array11 db 100 dup('$')  
.code  
main:  
; Asignamos el valor de ds  
mov ax, @data  
mov ds, ax  
  
; Nos muestra el primer mensaje  
mov ah, 09h  
mov dx, offset msg1  
int 21h  
  
; Primera entrada  
mov ah, 0ah  
mov dx, offset tsize1  
int 21h  
  
; Muestra el segundo mensaje  
mov ah, 09h  
mov dx, offset msg2  
int 21h  
  
; Segunda entrada  
mov ah, 0ah  
mov dx, offset tsize2  
int 21h  
  
; Muestra tercer mensaje  
mov ah, 09h  
mov dx, offset msg3  
int 21h  
  
; Tercera entrada  
mov ah, 0ah  
mov dx, offset tsize3  
int 21h  
  
; Muestra cuarto mensaje  
mov ah, 09h  
mov dx, offset msg4  
int 21h  
  
; Cuarta entrada  
mov ah, 0ah  
mov dx, offset tsize4  
int 21h  
  
; Muestra quinto mensaje  
mov ah, 09h  
mov dx, offset msg5  
int 21h  
  
; Quinta entrada  
mov ah, 0ah  
mov dx, offset tsize5  
int 21h  
  
; Muestra sexto mensaje  
mov ah, 09h  
mov dx, offset msg6  
int 21h  
  
; Sexta entrada  
mov ah, 0ah  
mov dx, offset tsize6  
int 21h  
  
; Muestra septimo mensaje  
mov ah, 09h  
mov dx, offset msg7  
int 21h  
  
; Septima entrada  
mov ah, 0ah  
mov dx, offset tsize7  
int 21h  
  
; Muestra octavo mensaje  
mov ah, 09h  
mov dx, offset msg8  
int 21h  
  
; Octava entrada  
mov ah, 0ah  
mov dx, offset tsize8  
int 21h  
  
; Muestra noveno mensaje  
mov ah, 09h  
mov dx, offset msg9  
int 21h  
  
; Novena entrada  
mov ah, 0ah  
mov dx, offset tsize9  
int 21h  
  
; Muestra decimo mensaje  
mov ah, 09h  
mov dx, offset msg10  
int 21h  
  
; Decima entrada  
mov ah, 0ah  
mov dx, offset tsize10  
int 21h  
  
; Copia la primer cadena  
  
; Loop usa registro cx  
mov cx, 0 ; Lo limpiamos primero  
mov cl, asize1 ; Ponemos el tamano actual en cl  
;   cx  
;   0   7  
;   ch  cl  
; Ahora el valor de cx es el mismo que de cl  
  
mov si, offset array1   
mov di, offset array11    ; Aqui enpieza el loop  
  
start1:  
mov al, [si]    ; Copia el valor de la direccion de si en al (un byte)  
mov [di], al    ; Copia el valor de la direccion en di desde al  
  
inc si          ; Mueve al siguiente byte origen  
inc di          ; Mueve al siguiente byte destino  
loop start1  
  
; loop subtracts 1 from cx and checks if its zero. Zero means break the loop  
; So, the loop appears to run cx times which has number of characters in first input  
  
; Primera cadena copiada, empieza la segunda  
  
mov cx, 0  
mov cl, asize2  
  
mov si, offset array2  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start2:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start2  
  
; Segunda cadena copiada, empieza la tercera  
  
mov cx, 0  
mov cl, asize3  
  
mov si, offset array3  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start3:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start3  
  
; Tercera cadena copiada, empieza la cuarta  
  
mov cx, 0  
mov cl, asize4  
  
mov si, offset array4  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start4:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start4  
  
; Cuarta cadena copiada, empieza la quinta  
  
mov cx, 0  
mov cl, asize5  
  
mov si, offset array5  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start5:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start5  
  
; Quinta cadena copiada, empieza la sexta  
  
mov cx, 0  
mov cl, asize6  
  
mov si, offset array6  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start6:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start6  
  
; Sexta cadena copiada, empieza la septima  
  
mov cx, 0  
mov cl, asize7  
  
mov si, offset array7  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start7:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start7  
  
; Septima cadena copiada, empieza la octava  
  
mov cx, 0  
mov cl, asize8  
  
mov si, offset array8  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start8:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start8  
  
; Octava cadena copiada, empieza la novena  
  
mov cx, 0  
mov cl, asize9  
  
mov si, offset array9  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start9:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start9  
  
; Novena cadena copiada, empieza la decima  
  
mov cx, 0  
mov cl, asize10  
  
mov si, offset array10  ; Empieza copiando el primer Byte de la segunda cadena  
                       ; Pero el objetivo permanece igual  
  
start10:  
mov al, [si]  
mov [di], al  
inc si  
inc di  
loop start10  
  
  
; Muestra mensaje  
mov ah, 09h  
mov dx, offset msg11  
int 21h  
  
; Muestra la cadena  
mov dx, offset array11  
int 21h  
  
; Exit   
mov ah, 4ch  
int 21h  
end main  
