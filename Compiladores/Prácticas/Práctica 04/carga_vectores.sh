#!/bin/bash
yacc -d vector_cal.y
gcc y.tab.c -lm
./a.out < valores_de_entrada.txt
