#!/bin/bash
cd /home/erick/Documentos/ESCOM/Algoritmos/Prácticas/Práctica\ 01/Árbol\ binario\ de\ búsqueda/
g++ tree_sort.cpp tiempo.c  -o tree_sort
./tree_sort 100 < numeros10millones.txt >> out.txt
./tree_sort 1000 < numeros10millones.txt >> out.txt
./tree_sort 5000 < numeros10millones.txt >> out.txt
./tree_sort 10000 < numeros10millones.txt >> out.txt
./tree_sort 50000 < numeros10millones.txt >> out.txt
./tree_sort 100000 < numeros10millones.txt >> out.txt
./tree_sort 200000 < numeros10millones.txt >> out.txt
./tree_sort 400000 < numeros10millones.txt >> out.txt
./tree_sort 600000 < numeros10millones.txt >> out.txt
./tree_sort 800000 < numeros10millones.txt >> out.txt
./tree_sort 1000000 < numeros10millones.txt >> out.txt
./tree_sort 2000000 < numeros10millones.txt >> out.txt
./tree_sort 3000000 < numeros10millones.txt >> out.txt
./tree_sort 4000000 < numeros10millones.txt >> out.txt
./tree_sort 5000000 < numeros10millones.txt >> out.txt
./tree_sort 6000000 < numeros10millones.txt >> out.txt
./tree_sort 7000000 < numeros10millones.txt >> out.txt
./tree_sort 8000000 < numeros10millones.txt >> out.txt
./tree_sort 9000000 < numeros10millones.txt >> out.txt
./tree_sort 10000000 < numeros10millones.txt >> out.txt
