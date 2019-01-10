#include"TADArbol_bin.c"

int main (void)
{
	arbol_binario a1;
	posicion p1;
	elemento e1;

	Initialize(&a1);
	p1=Root(&a1);

	e1.c='A';
	NewLeftSon(&a1,p1,e1);



	p1=Root(&a1);
	e1.c='C';
	NewRightSon(&a1,p1,e1);
	e1.c='B';
	NewLeftSon(&a1,p1,e1);

	p1=RightSon(&a1,p1);
	e1.c='D';
	NewRightSon(&a1,p1,e1);

	p1=Root(&a1);
	e1=ReadNode(&a1,p1);
	printf("\n%c",e1.c);
	p1=RightSon(&a1,p1);
	e1=ReadNode(&a1,p1);
	printf("\n%c",e1.c);

	return 0;
}

