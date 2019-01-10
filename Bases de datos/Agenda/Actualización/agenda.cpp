#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*Constantes*/
#define file_name "diary.db"
#define MAX_SIZE 50

/*Definición de las funciones*/
void display();
void add(FILE *file);
void drop(FILE *file);
void query(FILE *file);
void modify(FILE *file);
void my_main(FILE *file);
void set_contacts(FILE *file);
void get_contacts(FILE *file);

/**Creamos un struct con los datos que tendrá nuestra tabla**/
typedef struct Diary{
	char name[50];
	char date[10];
	int age;
	char address[30];
	char phone[15];
	char email[30];
}Diary;

Diary diary[MAX_SIZE];
int availables = 0;
/**	r: solo lectura. Fichero ya debe existir
	w: escritura, se sobreescribe el fichero si ya existe
	a: añadir, se abre para escritura, se se situa el cursor al final del fichero si no existe se crea
	r+: lectura y escritura. Fichero debe existir.
	w+: lectura y escritura. Se crea un fichero o se sobreescribe
	a+: añadir, lectura y escritura, el cursor se situa al final del fichero si no existe se crea
	t: tipo texto, si no se especifica "t" ni "b" se asume por defecto que es t
	b: binario**/

//Método main
int main(){
	/**Declaración de variables**/
	//Variable tipo fichero;
	FILE *file;
	//Abrimos un fichero si no existe es creado para, añadir, lectura y/o escritura
	file = fopen(file_name, "ab+");
	if(file){
		//Cerramos el fichero
		fclose(file);
		//Ciclamos el programa indefinidamente
		while(true)
			my_main(file);
	} else 
		printf("\nOcurrio un error al abrir o crear el archivo :C");
	return 0;
}

void my_main(FILE *file){
	/**Declaración de variables**/
	int option = 0;
	get_contacts(file);
	printf("\n---------- Agenda ----------");
	printf("\n1. Anadir\n2. Bajas\n3. Consultas\n4. Modificar\n5. Mostrar mi agenda\n6. Salir\n>");
	scanf("%d", &option); //Leemos la opción que el usuario ingresará
	//Evaluamos la variable opción
	switch(option){
		//Opción añadir
		case 1:
			add(file);
		break;

		//Opción bajas
		case 2:
			drop(file);
		break;

		//Opción consultar
		case 3:
			query(file);
		break;

		//Opción modificar
		case 4:
			modify(file);
		break;

		//Mostramos toda la agenda
		case 5:
			display();
		break;
		//Opcíón salir
		case 6:
			printf("\nEl programa finalizara...");
			exit(0);
		break;
		//Si no se cumple ningún caso declarado
		default:
			printf("\nLo siento esa opcion no existe");
		break;
	}
}

/**
Nombre: add
Descripción: Esta función añade un elemento a nuestro fichero
Recibe:
Retorna: nada
**/
void add(FILE *file){
	/**Declaración de variables**/
	char addOther = 'S';
	printf("\n----- Anadir contacto -----\n");

	//En este ciclo llenamos nuestro array de structs
	while((addOther == 's' || addOther == 'S') && (availables < MAX_SIZE)){
		
		if(diary[availables].age == 0){
			printf("\n>Usuario %i de %i", availables+1, MAX_SIZE);
			fflush(stdin);
			printf("\nDigita el nombre ->");
			scanf("%[^\n]", diary[availables].name);
			fflush(stdin);
			printf("\nDigita la fecha de nacimiento -> ");
			scanf("%[^\n]", diary[availables].date);
			fflush(stdin);
			printf("\nDigita la edad -> ");
			scanf("%d", &diary[availables].age);
			fflush(stdin);
			printf("\nDigita la direccion -> ");
			scanf("%[^\n]", diary[availables].address);
			fflush(stdin);
			printf("\nDigita el telefono -> ");
			scanf("%[^\n]", diary[availables].phone);
			fflush(stdin);
			printf("\nDigita el correo electronico -> ");
			scanf("%[^\n]", diary[availables].email);
			fflush(stdin);
			printf("\n>Deseas anadir a otro contacto? S/N -> ");
			scanf("%c", &addOther);
		}
		availables++;
	}
	set_contacts(file);
}

/**
Nombre set_contacts
Descripcion: Esta función escribe los datos ingresados a nuestras estructuras en el fichero
Recibe: FILE*
Retorna: nada
**/
void set_contacts(FILE *file){
	file = fopen(file_name, "wb+");
	//Usamos la función fwrite() para escribir sobre nuestro fichero
	/*Traducción guarda de diary del tamaño de estructuras
	tipo diary 10 structs en el fichero*/
	fwrite(diary, sizeof(Diary), MAX_SIZE, file);
	fclose(file);
}

/**
Nombre: get_contacts
Descripcion: Esta función obtiene los datos escritos en binario en el fichero
Recibe: FILE*
Retorna: Nada
**/
void get_contacts(FILE* file){
	file = fopen(file_name, "rb+");
	if(file){
		fread(diary, sizeof(Diary), MAX_SIZE, file);
		fclose(file);
	} else
		printf("\nNo existe el archivo o no se pudo abrir");
}

/**
Nombre: display
Descripcion: Esta función muestra los datos que hay en los structs
Recibe: Nada
Reorna: Nada
**/
void display(){
	/**Variables**/
	int i = 0;
	printf("\n----- Mi agenda -----\n");
	for(i = 0, availables = 0; i < MAX_SIZE; i++){
		if(diary[i].age != 0){
			printf("\n\n- Usuario %i de un maximo de %i -", availables+1, MAX_SIZE);
			printf("\nNombre: %s", diary[i].name);
			printf("\nFecha de nacimiento: %s", diary[i].date);
			printf("\nEdad: %d", diary[i].age);
			printf("\nDireccion: %s", diary[i].address);
			printf("\nTelefono: %s", diary[i].phone);
			printf("\nCorreo electronico: %s", diary[i].email);
			printf("\n-------------------\n");
			availables++;
		}
	}
}

/**
Nombre: drop
Descripción: Esta función elimina un elemento a nuestro fichero
Recibe: FILE*
Retorna: nada
**/
void drop(FILE *file){
	/**Declaración de variables**/
	int i = 0;
	char name[50];
	get_contacts(file);
	printf("\n----- Bajas -----\n");
	display();
	fflush(stdin);
	printf("\n\nIngresa el nombre del usuario a eliminar -> ");
	scanf("%[^\n]", name);
	for(i = 0; i < MAX_SIZE; i++){
		if (strcmp(diary[i].name, name) == 0) {	
			strcpy(diary[i].name, "");
			strcpy(diary[i].date, "");
			diary[i].age = 0;
			strcpy(diary[i].address, "");
			strcpy(diary[i].phone, "");
			strcpy(diary[i].email, "");
		}
	}
	set_contacts(file);
}

/**
Nombre: query
Descripción: Esta función hace una consulta
Recibe: FILE*
Retorna: nada
**/
void query(FILE *file){
	int i, flag = 0;
	char find[50];
	printf("\n----- CONSULTAR -----\n");
	get_contacts(file);
	fflush(stdin);
	printf("\n\nIngrese el nombre del contacto -> ");
	scanf("%[^\n]", find);
	for(i=0; i < MAX_SIZE; i++){
		if(strcmpi(find, diary[i].name)==0){
			flag++;
			printf("\nNombre: %s", diary[i].name);
			printf("\nFecha de nacimiento: %s", diary[i].date);
			printf("\nEdad: %d", diary[i].age);
			printf("\nDireccion: %s", diary[i].address);
			printf("\nTelefono: %s", diary[i].phone);
			printf("\nCorreo electronico: %s", diary[i].email);
		}
	}
	if(flag == 0)
		printf("\nNo se encontro el contacto %s", find);
	

}

/**
Nombre: modify
Descripción: Esta función modifica un elemento a nuestro fichero
Recibe: FILE*
Retorna: nada
**/
void modify(FILE *file){
	int i, option=0;
	char search[50];
	printf("\n----- Modificar -----\n");
	fflush(stdin);
	printf("\n\nIngrese el nombre del contacto a modificar -> ");
	scanf("%[^\n]", search);
	fflush(stdin);
	for(i=0; i < MAX_SIZE; i++){
		if(strcmp(search, diary[i].name)==0){
			printf("\n\nIngrese el dato a modificar:");
			printf("\n1. Nombre\n2. Fecha de nacimiento\n3. Edad\n4. Direccion\n5. Telefono\n6. Correo electronico\n7. Salir\n>");
			scanf("%d", &option);	
			if(option == 1){
				strcpy(diary[i].name, "");
				fflush(stdin);
				printf("\nDigita el nombre ->");
				scanf("%[^\n]", diary[availables].name);
				fflush(stdin);
			}
			else if(option == 2){
				strcpy(diary[i].date, "");
				fflush(stdin);
				printf("\nDigita la fecha de nacimiento -> ");
				scanf("%[^\n]", diary[availables].date);
				fflush(stdin);
			}
			else if(option == 3){
				diary[i].age = 0;
				fflush(stdin);
				printf("\nDigita la edad -> ");
				scanf("%d", &diary[i].age);
				fflush(stdin);
			}
			else if(option == 4){
				strcpy(diary[i].address, "");
				fflush(stdin);
				printf("\nDigita la direccion -> ");
				scanf("%[^\n]", diary[availables].address);
				fflush(stdin);
			}
			else if(option == 5){
				strcpy(diary[i].phone, "");
				fflush(stdin);
				printf("\nDigita el telefono -> ");
				scanf("%[^\n]", diary[availables].phone);
				fflush(stdin);
			}
			else if(option == 6){
				strcpy(diary[i].email, "");
				fflush(stdin);
				printf("\nDigita el correo electronico -> ");
				scanf("%[^\n]", diary[availables].email);
				fflush(stdin);
			}
			else{
				i = MAX_SIZE - 1;
			}
		}
	}
	set_contacts(file);
}