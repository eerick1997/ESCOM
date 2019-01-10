segment .data

        cadena db 'Hola mundo',13,10,'$'

segment .text

%ifdef TIPO_MSVC
%define main _main
%endif

%macro llamada 2

   push   %1
   pop    eax               ; EAX = numLlamada
   push   eax
   call   b
b: mov    ebx,r
   mov    ecx,b
   sub    ecx,ebx
   add    [esp],ecx
   mov    edx, esp          ; EDX = stack
   sysenter    ;db     0fh, 34h          ; SYSENTER instruction
r: add    esp, [(%2)*4]
%endmacro


global main

main:

llamada 0x014f,0x00000
;mov ebx,[cadena]
;llamada 0x0080,ebx

ret
