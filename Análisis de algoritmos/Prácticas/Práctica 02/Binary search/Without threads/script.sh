#!/bin/bash
g++ binary_search.cpp tiempo.h -o binary_search
./binary_search 10000 261216 < 10millones.txt > out.txt
