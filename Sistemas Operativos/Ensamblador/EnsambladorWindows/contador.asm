
segment .model small  
segment .stack 100  
segment .data  
segment .code  
segment .startup
mov cx,00h ; inicializo contador en cero  

segment .text
	global _main
	extern _ExitProcess@4

_main:
	repite:  
	mov dl,cl ; muevo el valor del contador a dl para imprimir  
	inc cl ; incremento el contador en uno  
	add dl,30h ; sumo 30h a dl para convertirlo al codigo ascii y poder imprimirlo  
	mov ah,02h ; funcion para imprimir un caracter  
	int 21h ; imprimo  
	cmp cl,10 ; compara si en el contador hay un 10  
	je salir ; si la comparacion es verdadera salta a salir  
	jne repite ; sino es verdadera la ultima comparacion regresa a repite  
	salir:  
 	call _ExitProcess@4
	mov eax,0d