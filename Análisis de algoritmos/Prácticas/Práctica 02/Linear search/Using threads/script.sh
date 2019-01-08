#!/bin/bash
g++ linear_search.cpp tiempo.h -o linear_search -lm -pthread
./linear_search 10000 261216 < 10millones.txt > out.txt
