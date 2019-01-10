%include "c:\ensamblador\nasm\nasm-2_07\kernel32.inc"
%include "user32.inc"

%includelib "kernel32.lib"
%includelib "user32.lib"

segment .data

Encabezado db 'Programando ensamblador en WIN32', 0
Mensaje db 'El famoso Hola Mundo', 0

segment .text

%ifdef TIPO_MSVC
%define main _main
%endif

global main

main:

push dword Mensaje
call [Stdout]

push dword MB_OK
push dword Encabezado
push dword Mensaje
push dword 0
call [MessageBoxA]

push dword 0
call [ExitProcess]

;invoke MessageBox,0,addr mensaje,addr encabezado,0
;        invoke ExitProcess,0

ret
