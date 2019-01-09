Gram=y.tab.c y.tab.h

all: $(Gram) 
	@gcc -o vect y.tab.c symbol.c init.c math.c vector_cal.c code.c -lm
	@echo Compiled

$(Gram): hoc4.y
	@yacc -d hoc4.y

clean:
	@rm -f  *.tab.* *.yy.* calc
	@echo Clean
