Gram=y.tab.c y.tab.h

all: $(Gram) vector_cal.c hoc.c
	@gcc -o vect y.tab.c vector_cal.c hoc.c code.c init.c -lm
	@echo Compiled

vector_cal.c:
	@echo "Si esta"

$(Gram): vector_cal.y
	@yacc -d vector_cal.y

lex.yy.c: vector_cal.l
	@flex vector_cal.l

clean:
	@rm -f *.out lex.yy.c *.tab.* vect
	@echo Clean
