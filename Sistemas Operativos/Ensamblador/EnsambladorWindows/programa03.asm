segment .bss
num resb 1

segment .text
   global _main        ;must be declared for using gcc
   extern _ExitProcess@4

_main:                 ;tell linker entry point
   mov ecx,9
   mov eax, '0'

l1:
   mov [num], eax
   mov eax, 4
   mov ebx, 1
   push ecx

   mov ecx, num        
   mov edx, 1        
   int 0x80

   mov eax, [num]
   sub eax, '0'
   inc eax
   add eax, '0'
   pop ecx
   loop l1

   ;mov eax,1             ;system call number (sys_exit)
   ;mov eax,0d              ;call kernel
   call _ExitProcess@4
