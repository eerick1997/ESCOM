#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>
#include <iostream>

// Returns an empty string if dialog is canceled
char *openfilename(char* filter = "All Files (*.*)\0*.*\0", HWND owner = NULL) {
	OPENFILENAME ofn;
	char fileName[MAX_PATH] = "";
	ZeroMemory(&ofn, sizeof(ofn));
	ofn.lStructSize = sizeof(OPENFILENAME);
	ofn.hwndOwner = owner;
	ofn.lpstrFilter = filter;
	ofn.lpstrFile = fileName;
	ofn.nMaxFile = MAX_PATH;
	ofn.Flags = OFN_EXPLORER | OFN_FILEMUSTEXIST | OFN_HIDEREADONLY;
	ofn.lpstrDefExt = "";
	char *fileNameStr;
	if ( GetOpenFileName(&ofn) )
		fileNameStr = fileName;
	return fileNameStr;
}

int main()
{
    FILE *nombre,*f2;
    int c,r,ast;
    char* cad= openfilename();
    nombre = fopen(cad, "r");
    printf("%s",cad);
    cin.ignore();
    //nombre = fopen("sensores.jed", "r");
    f2 = fopen("sensores2.jed", "w");   /* Abrir archivo para escritura */

    if (nombre == NULL)
    {
        printf("El archivo no existe \n");
        exit (EXIT_FAILURE);
    }
    else
    {
			c = getc(nombre); /* Obtiene un caracter del archivo */
      	fprintf(f2, "%c",c);
        do
        {
        		r=0;
            if(c!='L'){
            	while(c != EOF){
               	c = getc(nombre); /* Obtiene un caracter del archivo */
                  fprintf(f2, "%c",c);
                  if(c=='\n'){
                  	c = getc(nombre); /* Obtiene un caracter del archivo */
      					fprintf(f2, "%c",c);
                  	break;
                  }
               }

            }
            else{
            	ast=0;
            	do{
               	c = getc(nombre); /* Obtiene un caracter del archivo */
                  if(c!='\n'&&c!='*'){
                  	fprintf(f2, "%c",c);
                  }
                  else if(c=='\n'){
                  	if(!r){ fprintf(f2, " "); r=1; }
                  }
                  else if(c=='*'){
                  	if(ast){
                     	fprintf(f2, "%c",c);
                  		fprintf(f2, "\n");
                        c = getc(nombre);
                        if(c!='\n')fprintf(f2, "%c",c);
                        break;
                     }
                     else{
                      	ast++;
                        fprintf(f2, "%c",c);
                     }
                  }
               }while(c != EOF);
            }
        }
        while (c != EOF); /* hasta encontrar EOF (el final del archivo)*/
    }
    fclose(nombre);
    fclose(f2);

    return EXIT_SUCCESS;
}
