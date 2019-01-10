/*
AUTOR: Vargas Romero Erick Efraín
VERSIÓN: 2.0

DESCRIPCIÓN: Modifica el programa del ejemplo para que el programa pueda realizar, altas, bajas
y cambios de los empleados, además de los respaldos en modo texto y binario
según el usuario lo solicite. Crear un menú para operar con el programa. El
programa deberá de ser capaz de salir y almacenar la lista de empleados para que
al iniciar nuevamente mantenga la información de ellos.


OBSERVACIONES: Se definio NUM_EMP como constante para hacer más compatible el programa
además se definieron las contantes path_txt(Ruta para el archivo de texto)
y también path_dat(Ruta para el archivo guardado en binario)

COMPILACIÓN: gcc problema_empleados.c -o problema_empleados
EJECUCIÓN: problema_empleados.exe (En Windows)
NOTA: No fué probado en LINUX
*/
//LIBRERAS
#include<stdio.h>
#include<windows.h>

//DEFINICIÓN DE ESTRUCTURAS Y CONSTANTES
//Número de empleados
#define NUM_EMP 100
//Ruta del archívo en modo texto
#define path_txt "empleados.txt"
//Ruta del rchivo en modo binario
#define path_dat "empleados.dat"
//Definición de la estructura
typedef struct empleado
{
    int no_empleado;
    char nombre[45];
    char departamento[45];
    float salario;
    char direccion[100];
} empleado;


//DECLARACIÓN DE FUNCIONES
/*Procedimiento para capturar por medio de la entrada estandar los empleados
(Recibe la referencia al arreglo de empleados)*/
void CapturaEmpleados(empleado *lista);
/*Procedimiento para mostrar en la salida estandar los empleados
(Recibe la referencia al arreglo de empleados)*/
void ImprimeEmpleados(empleado *lista);
/*Procedimiento para guardar en un archivo de texto a los empleados
(Recibe la referencia al arreglo de empleados y la ruta del archivo a escribir)*/
void GuardaEmpleadosTexto(empleado *lista, char* ruta_escribir);
/*Procedimiento para leer de un archivo de texto a los empleados
(Recibe la referencia al arreglo de empleados y la ruta del archivo a leer)*/
void LeeEmpleadosTexto(empleado *lista, char* ruta_leer);
/*Procedimiento para guardar en un archivo de binario a los empleados
(Recibe la referencia al arreglo de empleados y la ruta del archivo a escribir)*/
void GuardaEmpleadosBinario(empleado *lista, char* ruta_escribir);
/*Procedimiento para leer de un archivo binario a los empleados
(Recibe la referencia al arreglo de empleados y la ruta del archivo a leer)*/
void LeeEmpleadosBinario(empleado *lista, char* ruta_leer);

/*En esta función, se realizan evaluaciones de lo que
se ingresó en el pequeño menú creado en el main
recibe_ el arreglo de empleados y un entero para
realizar una seleccion*/
void selectOptions(empleado* lista, int option);

/*En esta función elegimos como deseamos leer el archivo
recibe el arreglo de empleados también recibe una variable
tipo int para realizar una selección*/
void OpenHow(empleado *lista, int show);

/*En esta función hacemos un respaldo de lo que se
ingresó en la estructura, recibe el arreglo de empleados*/
void CreateBackUp(empleado* lista);

/*Esta función verifica si existe o no el archivo
con anterioridad sino es así lo crea, recibe:
un apuntador archivo y la ruta que verificará*/
void VerifyIfWasCreated(FILE* file, char* route);

/*Esta función hace la búsqueda de un empleado
y lo elimina primeramente de nuestra estructura
finalmente del fichero creado, recibe:
el arreglo de empleados*/
void deleteEmployee(empleado* lista);

/*Hace un conteo de los empleados que están registrados
haciendo un recorrido por toda la estructura, recibe:
arreglo de empleados además
nos returna un valor de igual manera int*/
int EmployeesRegistered(empleado* lista);

/*Este método nos permite hacer la modificación de algún
usuario, siempre y cuando exista alguno, recibe,
arreglo de empleados*/
void modifyEmployee(empleado* lista);
//PROGRAMA PRINCIPAL
int main(void)
{
    empleado lista[NUM_EMP];

    OpenHow(lista, 0);
    system("CLS");
    int option;
    printf("\n\nHola!\nIntroduce la opcion que deseas");
    printf("\n1. Capturar empleados\n2. Mostrar empleados\n");
    printf("3. Hacer respaldo\n4. Eliminar empleado");
    printf("\n5. Modificar empleado\n6. Salir\n-> ");
    scanf("%d", &option);
    selectOptions(lista, option);

    return 0;
}

//DEFINICIÃ“N DE FUNCIONES
/*
void CapturaEmpleados(empleado *lista);
DescripciÃ³n: Procedimiento para capturar por medio de la entrada estandar los empleados
Recibe: empleado *lista (Referencia al arreglo de empleados)
Devuelve:
Observaciones: Si la esctructura empleado se modifica, tambiÃ©n se modificarÃ¡ esta funciÃ³n
*/
void CapturaEmpleados(empleado *lista)
{
    int i;
    printf("\nEste programa solo gestiona %d empleados", NUM_EMP);
    printf("\nActualmente hay %d empleados registrados", EmployeesRegistered(lista));

    if((NUM_EMP - EmployeesRegistered(lista)) > 0)
    {
        for(i=0; i<NUM_EMP; i++)
        {
            if(isEmpty(lista, i) == 0)
            {
                printf("\n\n\nEmpleado %d de la lista",i+1);
                printf("\nIntroduce el numero de empleado: ");
                scanf("%d",&lista[i].no_empleado);
                printf("\nIntroduce el nombre de empleado: ");
                scanf("%s",&lista[i].nombre);
                printf("\nIntroduce el departamento del empleado: ");
                scanf("%s",&lista[i].departamento);
                printf("\nIntroduce el salario de empleado: ");
                scanf("%f",&lista[i].salario);
                printf("\nIntroduce la direccion del empleado: ");
                scanf("%s",&lista[i].direccion);
            }
        }
        CreateBackUp(lista);
    }
    else
    {
        printf("\n\nNo es posible guardar mas empleados");
    }
}

/*
void ImprimeEmpleados(empleado *lista);
DescripciÃ³n: Procedimiento para mostrar en la salida estandar los empleados
Recibe: empleado *lista (Referencia al arreglo de empleados)
Devuelve:
Observaciones: Si la esctructura empleado se modifica, tambiÃ©n se modificarÃ¡ esta funciÃ³n
*/
void ImprimeEmpleados(empleado *lista)
{
    int i;
    for(i=0; i<NUM_EMP; i++)
    {
        if(isEmpty(lista, i) == 1)
        {
            printf("\n\n\nEmpleado #%d",lista[i].no_empleado);
            printf("\nNombre: %s",lista[i].nombre);
            printf("\nDepartamento: %s",lista[i].departamento);
            printf("\nSalario: %.2f",lista[i].salario);
            printf("\nDireccion: %s",lista[i].direccion);
        }
    }
}

/*
void GuardaEmpleadosTexto(empleado *lista, char* ruta_escribir);
DescripciÃ³n: Procedimiento para guardar en un archivo de texto a los empleados
Recibe: empleado *lista (Referencia al arreglo de empleados), char *ruta(Cadena con la ruta del archivo a escribir)
Devuelve:
Observaciones: Si la esctructura empleado se modifica, tambiÃ©n se modificarÃ¡ esta funciÃ³n, el archivo a escribir se maneja en modo texto.
*/
void GuardaEmpleadosTexto(empleado *lista, char* ruta_escribir)
{
    int i;
    FILE *archivo;
    remove(ruta_escribir);
    VerifyIfWasCreated(archivo, ruta_escribir);
    archivo=fopen(ruta_escribir,"w");
    for(i=0; i<NUM_EMP; i++)
    {
        if(isEmpty(lista, i) == 1)
        {
            fprintf(archivo,"\n\nEmpleado %d de la lista",i+1);
            fprintf(archivo,"\nNumero de empleado: %d",lista[i].no_empleado);
            fprintf(archivo,"\nNombre de empleado: %s",lista[i].nombre);
            fprintf(archivo,"\nDepartamento del empleado: %s",lista[i].departamento);
            fprintf(archivo,"\nSalario de empleado: %f",lista[i].salario);
            fprintf(archivo,"\nDireccion del empleado: %s",lista[i].direccion);
        }
    }
    fclose(archivo);
}
/*
void LeeEmpleadosTexto(empleado *lista, char* ruta_escribir);
DescripciÃ³n: Procedimiento para leer de un archivo de texto a los empleados
Recibe: empleado *lista (Referencia al arreglo de empleados), char *ruta(Cadena con la ruta del archivo a escribir)
Devuelve:
Observaciones: Si la esctructura empleado se modifica, o si se cambia la la manera de guardar a los empleados,
tambiÃ©n se modificarÃ¡ esta funciÃ³n, el archivo a escribir se maneja en modo texto.
*/
void LeeEmpleadosTexto(empleado *lista, char* ruta_escribir)
{
    int i,n;
    FILE *archivo;
    VerifyIfWasCreated(archivo, ruta_escribir);
    archivo=fopen(ruta_escribir,"r");
    for(i=0; i<NUM_EMP; i++)
    {
        fscanf(archivo,"\n\nEmpleado %d de la lista",&n);
        fscanf(archivo,"\nNumero de empleado: %d",&lista[i].no_empleado);
        fscanf(archivo,"\nNombre de empleado: %s",&lista[i].nombre);
        fscanf(archivo,"\nDepartamento del empleado: %s",&lista[i].departamento);
        fscanf(archivo,"\nSalario de empleado: %f",&lista[i].salario);
        fscanf(archivo,"\nDireccion del empleado: %s",&lista[i].direccion);

    }
    fclose(archivo);
}
/*
void GuardaEmpleadosBinario(empleado *lista, char* ruta_escribir);
DescripciÃ³n: Procedimiento para guardar en un archivo binario a los empleados
Recibe: empleado *lista (Referencia al arreglo de empleados), char *ruta(Cadena con la ruta del archivo a escribir)
Devuelve:
Observaciones:
*/
void GuardaEmpleadosBinario(empleado *lista, char* ruta_escribir)
{
    int i;
    FILE *archivo;
    remove(ruta_escribir);
    VerifyIfWasCreated(archivo, ruta_escribir);
    archivo=fopen(ruta_escribir,"wb");
    fseek(archivo,0,SEEK_SET);
    fwrite(lista,sizeof(empleado),NUM_EMP,archivo);
    fclose(archivo);
}

/*
void LeeEmpleadosBinario(empleado *lista, char* ruta_escribir);
DescripciÃ³n: Procedimiento para leer de un archivo binario a los empleados
Recibe: empleado *lista (Referencia al arreglo de empleados), char *ruta(Cadena con la ruta del archivo a escribir)
Devuelve:
Observaciones: Si la esctructura empleado se modifica, tambiÃ©n se modificarÃ¡ esta funciÃ³n, el archivo a escribir se maneja en modo binario.
*/
void LeeEmpleadosBinario(empleado *lista, char* ruta_escribir)
{
    int i,n;
    FILE *archivo;
    VerifyIfWasCreated(archivo, ruta_escribir);
    archivo=fopen(ruta_escribir,"rb");
    fread(lista,sizeof(empleado),NUM_EMP,archivo);
    fclose(archivo);
}

/*En esta función, se realizan evaluaciones de lo que
se ingresó en el pequeño menú creado en el main*/
void selectOptions(empleado* lista, int option)
{

    switch(option)
    {
    case 1:
        CapturaEmpleados(lista);
        break;
    case 2:
        OpenHow(lista, 1);
        break;
    case 3:
        CreateBackUp(lista);
        break;
    case 4:
        deleteEmployee(lista);
        break;
    case 5:
        modifyEmployee(lista);
        break;
    case 6:
        exit(0);
        break;
    default:
        printf("\nEsa opcion no existe...");
        break;
    }
    main();
}

/*En esta función elegimos como deseamos leer el archivo*/
void OpenHow(empleado *lista, int show)
{
    int option;
    cleanStruct(lista);

    printf("\n\nEn que modo deseas abrir el archivo?");
    printf("\n\n1. Modo texto\n2. Modo binario\n-> ");
    scanf("%d", &option);
    switch(option)
    {
    case 1:
        printf("\nAbriendo en modo texto...");
        Sleep(2000);
        LeeEmpleadosTexto(lista, path_txt);
        if(show == 1)
        {
            ImprimeEmpleados(lista);
        }
        break;
    case 2:
        printf("\nAbriendo en modo binario...");
        Sleep(2000);
        LeeEmpleadosBinario(lista, path_dat);
        if(show == 1)
        {
            ImprimeEmpleados(lista);
        }
        break;
    default:
        printf("\nEsa opcion no existe...");
        break;
    }
}

/*En esta función hacemos un respaldo de lo que se
ingresó en la estructura*/
void CreateBackUp(empleado* lista)
{
    int option;
    printf("\nComo deseas hacer el respaldo?");
    printf("\n1. Modo texto\n2. Modo binario\n-> ");
    scanf("%d", &option);
    switch(option)
    {
    case 1:
        printf("\nGuardando en modo texto espere...");
        Sleep(3000);
        GuardaEmpleadosTexto(lista, path_txt);
        Sleep(500);
        printf("\n\nSe han almacenado correctamente los datos en modo texto");
        printf("\n\nMostrando...\n");
        LeeEmpleadosTexto(lista, path_txt);
        ImprimeEmpleados(lista);
        break;
    case 2:
        printf("\nGuardando en modo binario espere...");
        Sleep(3000);
        GuardaEmpleadosBinario(lista, path_dat);
        Sleep(500);
        printf("\n\nSe han almacenado correctamente los datos en modo binario");
        printf("\n\nMostrando...\n");
        LeeEmpleadosBinario(lista, path_dat);
        ImprimeEmpleados(lista);
        break;
    default:
        break;
    }
}

/*Esta función verifica si existe o no el archivo
con anterioridad sino es así lo crea*/
void VerifyIfWasCreated(FILE* file, char* route)
{
    if((file = fopen(route, "r")) == NULL)
    {
        //printf("\nEl archivo no existe creando...");
        file = fopen(route, "w");
        //Sleep(2000);
        //printf("\nEl archivo se ha creado satisfctoriamente...");
        //Sleep(2000);
    }
    fclose(file);
}

/*En esta función, limpiamos la estructura
en todos sus parámetros para que no arroje
ni guarde basura*/
void cleanStruct(empleado* lista)
{
    int i, j;
    for(i = 0; i<NUM_EMP; i++)
    {
        lista[i].no_empleado = 0;
        lista[i].salario = 0;
        for(j = 0; j<45; j++)
        {
            lista[i].nombre[j] = '\0';
            lista[i].departamento[j] = '\0';
        }
        for(j = 0; j<100; j++)
        {
            lista[i].direccion[j] = '\0';
        }
    }
}

/*Verifica si lista en cierta posición, en su
parámetro nombre esta o no vacío, si está vacío
la variable flag, se iguala a 0 (falso), sino a
1 (verdadero)*/
int isEmpty(empleado* lista, int position)
{
    int flag;
    if(lista[position].no_empleado == 0 || lista[position].salario == 0 ||
            strcmp(lista[position].nombre, "") == 0 ||
            strcmp(lista[position].direccion, "") == 0 ||
            strcmp(lista[position].departamento, "") == 0)
    {
        flag = 0;
    }
    else
    {
        flag = 1;
    }
    return flag;
}

/*Esta función hace la búsqueda de un empleado
y lo elimina primeramente de nuestra estructura
finalmente del fichero creado*/
void deleteEmployee(empleado* lista)
{
    int i, j = 1, k, l = -1;
    printf("\nHay %d empleados registrados\n", EmployeesRegistered(lista));
    if(EmployeesRegistered(lista) > 0){
        for(i = 0; i<NUM_EMP; i++)
        {
            if(isEmpty(lista, i) == 1)
            {
                printf("\n%d. %s\n", j++, lista[i].nombre);
            }
        }
        printf("\nIngresa el numero del empleado a eliminar -> ");
        scanf("%d", &j);
        j--;
        empleado newList[EmployeesRegistered(lista)-1];
        for(k = 0; k<NUM_EMP; k++)
        {
            if(k != j)
            {
                l++;
                newList[l].no_empleado = lista[k].no_empleado;
                newList[l].salario = lista[k].salario;
                strcpy(newList[l].nombre, lista[k].nombre);
                strcpy(newList[l].direccion, lista[k].direccion);
                strcpy(newList[l].departamento, lista[k].departamento);
            }
        }
        CreateBackUp(newList);
    }
}

/*Hace un conteo de los empleados que están registrados
haciendo un recorrido por toda la estructura*/
int EmployeesRegistered(empleado* lista)
{
    int registeredEmp = 0, i;
    for(i = 0; i<NUM_EMP; i++)
    {
        if(isEmpty(lista, i) == 1)
        {
            registeredEmp++;
        }
    }
    return registeredEmp;
}

/*Este método nos permite hacer la modificación de algún
usuario, siempre y cuando exista alguno*/
void modifyEmployee(empleado* lista)
{
    int i, j = 1, k;

    printf("\nHay %d empleados registrados\n", EmployeesRegistered(lista));
    if(EmployeesRegistered(lista) > 0){
        for(k = 0; k<NUM_EMP; k++)
        {
            if(isEmpty(lista, k) == 1)
            {
                printf("\n%d. %s\n", j++, lista[k].nombre);
            }
        }
        printf("Ingresa el numero del empleado a modificar -> ");
        scanf("%d", &j);

        j--;

        printf("\nIntroduce el numero de empleado: ");
        scanf("%d",&lista[j].no_empleado);
        printf("\nIntroduce el nombre de empleado: ");
        scanf("%s",&lista[j].nombre);
        printf("\nIntroduce el departamento del empleado: ");
        scanf("%s",&lista[j].departamento);
        printf("\nIntroduce el salario de empleado: ");
        scanf("%f",&lista[j].salario);
        printf("\nIntroduce la direccion del empleado: ");
        scanf("%s",&lista[j].direccion);

        CreateBackUp(lista);
    }
}
