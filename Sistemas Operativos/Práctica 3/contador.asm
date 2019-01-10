.model small  
.stack 100  
.data  
.code  
.startup  
mov cx,00h ; inicializo contador en cero  
  
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
.exit  
end  
