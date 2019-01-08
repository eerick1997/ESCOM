#!/bin/bash
cd /home/erick/Documentos/ESCOM/Algoritmos/Prácticas/Práctica\ 01/Insercion
g++ Insercion.cpp tiempo.c -o Insercion
./Insercion 100 < numeros10millones.txt >> out.txt
./Insercion 1000 < numeros10millones.txt >> out.txt
./Insercion 5000 < numeros10millones.txt >> out.txt
./Insercion 10000 < numeros10millones.txt >> out.txt
./Insercion 50000 < numeros10millones.txt >> out.txt
./Insercion 100000 < numeros10millones.txt >> out.txt
./Insercion 200000 < numeros10millones.txt >> out.txt
./Insercion 400000 < numeros10millones.txt >> out.txt
./Insercion 600000 < numeros10millones.txt >> out.txt
./Insercion 800000 < numeros10millones.txt >> out.txt
./Insercion 1000000 < numeros10millones.txt >> out.txt
./Insercion 2000000 < numeros10millones.txt >> out.txt
./Insercion 3000000 < numeros10millones.txt >> out.txt
./Insercion 4000000 < numeros10millones.txt >> out.txt
./Insercion 5000000 < numeros10millones.txt >> out.txt
./Insercion 6000000 < numeros10millones.txt >> out.txt
./Insercion 7000000 < numeros10millones.txt >> out.txt
./Insercion 8000000 < numeros10millones.txt >> out.txt
./Insercion 9000000 < numeros10millones.txt >> out.txt
./Insercion 10000000 < numeros10millones.txt >> out.txt
