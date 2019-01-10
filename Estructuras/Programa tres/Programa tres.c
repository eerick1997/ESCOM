#include<stdio.h>
#include<time.h>
#include<windows.h>
#include "TAD Cola\TAD Cola\TADCola\TADColaDin.c"

#define TIEMPO_BASE 200
#define no_colas_usuarios 3

#define cliente_pobre 0
#define cliente_banco 1
#define cliente_preferente 2

typedef struct datos_cajeras
{

    int tiempo;
    int atendiendo;
    int ultimo_atendido;

    int contador;

} datos_cajeras;

//Prototipos de las funciones
datos_cajeras* inicializar_struct(datos_cajeras* struct_mis_cajeras, int no_cajeras);
void atender(cola* filas_usuarios, datos_cajeras* struct_cajeras, int no_cajas, int tiempo);
int conversion_ms(int tiempo);
int anadirusuarios(cola* filas_usuarios, int ID, int tiempo, int tiempo_usuarios, int tiempo_clientes, int tiempo_preferentes);

//Función principal
int main(void)
{
    //no = cajas almacenamos las cajas que estarán disponibles
    // i = contador, tiempos[3] = tiempo de cada cliente
    //tiempo contador ID otro contador
    int no_cajas, i, tiempos[3], tiempo = 0, ID=0, aux;
    //Declaración de 3 colas
    cola filas_usuarios[no_colas_usuarios];

    //Ciclo de repetición hasta no_cajas > 9
    do
    {
        //Escaneamos el numeor de cajas disponibles
        printf("Cuantas cajas estaran abiertas (almenos una debe estar abierta) -> ");
        scanf("%d", &no_cajas);
    }
    while(no_cajas>9 || no_cajas < 1);

    //Creamos un vector con un tamaño no_cajas
    datos_cajeras struct_cajeras[no_cajas];

    //Ciclo de repetición hasta que i sea menor a no_colas_usuarios(3)
    for(i=0; i<no_colas_usuarios; i++)
    {
        //Inicializamos las coloas
        Initialize(&filas_usuarios[i]);
    }

    //Ciclo de repeticion hasta que i < no_cajas
    for(i=0; i<no_cajas; i++)
    {
        //struct[i] en parámetro atendiendo = 0 lo mismo para ultimo atendido y contador
        do
        {
            struct_cajeras[i].atendiendo = 0;
            struct_cajeras[i].ultimo_atendido = 0;
            struct_cajeras[i].contador = 0;

            //Ingresamos el tiempo que tendrá cada Struct
            printf("Tiempo de atencion en la caja %d el tiempo minimo es 100ms maximo 2000-> ", i+1);
            scanf("%d", &aux);
            struct_cajeras[i].tiempo = conversion_ms(aux);
        }
        while(aux < 100 || aux > 2000);
    }


    printf("\n\t struct_cajeras tiempo %d, atendiendo %d \n", struct_cajeras[0].tiempo, struct_cajeras[0].atendiendo);
    //[0] = usuarios, [1] = usuarios, [2] = preferentes
    //Creamos una matriz de 3 filas por 10 columnas que servirá para poner cadenas
    char clientes_texto[3][10]= {" usuarios"," clientes"," preferentes"};
    //Ciclo de repetición hasta que i sea menor a no_colas_usuarios
    for(i=0; i<no_colas_usuarios; i++)
    {
        do
        {
            tiempos[i] = 0;
            //Ingresamos el tiempo de los usuarios
            printf("Ingresa el tiempo de los clientes %s en ms (el minimo 100, maximo 2000) -> ", clientes_texto[i]);
            scanf("%d", &aux);
            tiempos[i] = conversion_ms(aux);
        }
        while(aux < 100 || aux > 2000);
    }

    //Entrada a ciclo infinito
    while(1)
    {
        //Esperar tiempo base
        Sleep(TIEMPO_BASE);
        //Contador tiempo se autoincrementa
        tiempo++;
        printf("\n%dms", tiempo);
        //anadimos usuarios a las colas
        ID = anadirusuarios(&filas_usuarios, ID, tiempo, tiempos[0], tiempos[1], tiempos[2]);

        printf("\n\t struct_cajeras tiempo %d, atendiendo %d \n", struct_cajeras[0].tiempo, struct_cajeras[0].atendiendo);
        atender(&filas_usuarios, &struct_cajeras, no_cajas, tiempo);
    }
}

int anadirusuarios(cola* filas_usuarios, int ID, int tiempo, int tiempo_usuarios, int tiempo_clientes, int tiempo_preferentes)
{
    int i; //Declaracion contador
    elemento mi_elemento; //Declaramos un elemento

    //Si el tiempo es módulo del tiempo de los usuarios
    if(tiempo % tiempo_usuarios == 0)
    {
        ID++;//Autoincrementamos ID
        printf("\nAnadi al usuario con identificador %d", ID);
        //Mi elemento en su parametro n se iguala al ID
        mi_elemento.n = ID;
        //Encolamos al usuario a su respectiva cola
        Queue(&filas_usuarios[cliente_pobre], mi_elemento);
        printf("\nAnadido a la cola[2], %d hay %d en cola\n", filas_usuarios[cliente_pobre].frente->e.n, filas_usuarios[cliente_pobre].num_elem);
        system("PAUSE");
    }
    if(tiempo % tiempo_clientes == 0)
    {
        ID++;
        printf("\nAnadi a un cliente con identificador %d", ID);
        mi_elemento.n = ID;
        Queue(&filas_usuarios[cliente_banco], mi_elemento);
        printf("\nAnadido a la cola[1], %d hay %d en cola\n", filas_usuarios[cliente_banco].frente->e.n, filas_usuarios[cliente_banco].num_elem);
        system("PAUSE");
    }
    if(tiempo % tiempo_preferentes == 0)
    {
        ID++;
        printf("\nAnadi a un preferente con identificador %d", ID);
        mi_elemento.n = ID;
        Queue(&filas_usuarios[cliente_preferente], mi_elemento);
        printf("\nAnadido a la cola[0], %d hay %d en cola\n", filas_usuarios[cliente_preferente].frente->e.n, filas_usuarios[cliente_preferente].num_elem);
        system("PAUSE");
    }
    return ID;
}

/**
Descripción: Esta función, realiza evaluaciones para atender algún usuario que esté formado, esto
es hecho en base a las políticas que tiene el banco.
Recibe: Un apuntador a cola, aquí tenemos nuestras 3 filas de usuarios,
un apuntador a datos_cajeras que es un simple struct el cual almacena datos de cada caja,
y un valor de tipo entero que contiene el numero de cajas que han sido abiertas
Devuelve:
**/
void atender(cola* filas_usuarios, datos_cajeras* struct_cajeras, int no_cajas, int tiempo)
{
    boolean bandera = FALSE;

    printf("\nfuncion atender\n");
    elemento mi_elemento;//Declaración de un elemento
    int i;//Declaración de un contador

    //Hacemos un recorrido de cada caja que está disponible
    for(i=0; i<no_cajas; i++)
    {
        printf("\nCiclo de repetición iniciado");
        bandera = FALSE;
        //Si todas las colas estan vacías
        if(tiempo % struct_cajeras[i].tiempo == 0)
        {
            printf("\nPuedo desencolar");
            if(filas_usuarios[cliente_pobre].num_elem == 0 && filas_usuarios[cliente_banco].num_elem == 0 && filas_usuarios[cliente_preferente].num_elem == 0)
            {
                printf("\nNo hay nadie para atender");
            }
            else
            {
                printf("\n\tDos colas vacias\n");
                //Solo podemos desencolar a un Preferente
                if(filas_usuarios[cliente_banco].num_elem == 0 && filas_usuarios[cliente_pobre].num_elem == 0 && !bandera && filas_usuarios[cliente_preferente].num_elem != 0)
                {
                    printf("\nDesencolar a un preferente hay dos cajas vacias");
                    struct_cajeras[i].ultimo_atendido = cliente_preferente;
                    Dequeue(&filas_usuarios[cliente_preferente]).n;
                    struct_cajeras[i].contador++;
                    bandera = TRUE;
                }
                //Solo podemos desencolar a un cliente_banco
                else if(filas_usuarios[cliente_pobre].num_elem == 0 && filas_usuarios[cliente_preferente].num_elem == 0 && !bandera && filas_usuarios[cliente_banco].num_elem != 0)
                {
                    printf("\nDesencolar a un cliente del banco hay dos cajas vacias");
                    struct_cajeras[i].ultimo_atendido = cliente_banco;
                    Dequeue(&filas_usuarios[cliente_banco]).n;
                    struct_cajeras[i].contador++;
                    bandera = TRUE;
                }
                //Si la cola preferente y cola banco estan vacías desencolamos a un pobre
                else if(filas_usuarios[cliente_preferente].num_elem == 0 && filas_usuarios[cliente_banco].num_elem == 0 && !bandera && filas_usuarios[cliente_pobre].num_elem != 0)
                {
                    printf("\nDesencolar a un pobre hay dos cajas vacias");
                    struct_cajeras[i].ultimo_atendido = cliente_pobre;
                    Dequeue(&filas_usuarios[cliente_pobre]).n;
                    struct_cajeras[i].contador = 0;
                    bandera = TRUE;
                }
                else
                {
                    printf("\n\tUna cola vacia\t");
                    //Podemos desencolar a un preferente o un cliente
                    if(filas_usuarios[cliente_pobre].num_elem == 0)
                    {
                        //Desencolar a un preferente
                        if(struct_cajeras[i].ultimo_atendido == cliente_banco || struct_cajeras[i].ultimo_atendido == cliente_pobre && !bandera && filas_usuarios[cliente_preferente].num_elem != 0)
                        {
                            printf("\nDesencolas a un preferente fila pobre vacía");
                            struct_cajeras[i].ultimo_atendido = cliente_preferente;
                            Dequeue(&filas_usuarios[cliente_preferente]).n;
                            struct_cajeras[i].contador++;
                            bandera = TRUE;
                        }
                        //Desencolamos a un cliente
                        if(struct_cajeras[i].ultimo_atendido == cliente_preferente || struct_cajeras[i].ultimo_atendido == cliente_pobre  &&!bandera && filas_usuarios[cliente_banco].num_elem != 0)
                        {
                            printf("\nDesencolar a un cliente fila pobre vacía");
                            struct_cajeras[i].ultimo_atendido = cliente_banco;
                            Dequeue(&filas_usuarios[cliente_banco]).n;
                            struct_cajeras[i].contador++;
                            bandera = TRUE;
                        }
                    }
                    //Podemos desencolar a un preferente o a un pobre
                    else if(filas_usuarios[cliente_banco].num_elem == 0)
                    {
                        //Desencolar a un preferente
                        if((struct_cajeras[i].ultimo_atendido == cliente_pobre || struct_cajeras[i].ultimo_atendido == cliente_banco) && struct_cajeras[i].contador < 5 && !bandera && filas_usuarios[cliente_preferente].num_elem != 0)
                        {
                            printf("\nDesencolar a un preferente cola cliente vacia");
                            struct_cajeras[i].ultimo_atendido = cliente_preferente;
                            Dequeue(&filas_usuarios[cliente_preferente]).n;
                            struct_cajeras[i].contador++;
                            bandera = TRUE;
                        }
                        //Desencolar a un pobre
                        else if(struct_cajeras[i].ultimo_atendido == cliente_preferente || struct_cajeras[i].ultimo_atendido == cliente_banco && !bandera && filas_usuarios[cliente_pobre].num_elem != 0)
                        {
                            printf("\nDesencolar a un pobre cola cliente vacia");
                            struct_cajeras[i].ultimo_atendido = cliente_pobre;
                            Dequeue(&filas_usuarios[cliente_pobre]).n;
                            struct_cajeras[i].contador = 0;
                            bandera = TRUE;
                        }
                    }
                    //Podemos desencolar a un pobre o un cliente
                    else if(filas_usuarios[cliente_preferente].num_elem == 0)
                    {
                        //Podemos desencolar a un cliente
                        if((struct_cajeras[i].ultimo_atendido == cliente_preferente || struct_cajeras[i].ultimo_atendido == cliente_pobre) && struct_cajeras[i].contador < 5 && !bandera && filas_usuarios[cliente_banco].num_elem != 0)
                        {
                            printf("\nDesencolar cliente cola preferente vacía");
                            struct_cajeras[i].ultimo_atendido = cliente_banco;
                            Dequeue(&filas_usuarios[cliente_banco]).n;
                            struct_cajeras[i].contador++;
                            bandera = TRUE;
                        }
                        //Podemos desencolar a un pobre
                        else if(struct_cajeras[i].ultimo_atendido == cliente_preferente || struct_cajeras[i].ultimo_atendido == cliente_banco && !bandera && filas_usuarios[cliente_pobre].num_elem != 0)
                        {
                            printf("\nDesencolar cliente pobre, cola preferente vacia");
                            struct_cajeras[i].ultimo_atendido = cliente_pobre;
                            Dequeue(&filas_usuarios[cliente_pobre]).n;
                            struct_cajeras[i].contador = 0;
                            bandera = TRUE;
                        }
                    }
                    //Existen usuarios en todas las colas
                    else
                    {
                        printf("\n\t No hay colas vacias\n");
                        //Desencolar cliente preferente
                        if((struct_cajeras[i].ultimo_atendido == cliente_banco || struct_cajeras[i].ultimo_atendido == cliente_pobre) && struct_cajeras[i].contador < 5 && !bandera && filas_usuarios[cliente_preferente].num_elem != 0)
                        {
                            printf("\nDesencolar a un preferente todas estan llenas");
                            struct_cajeras[i].ultimo_atendido = cliente_preferente;
                            Dequeue(&filas_usuarios[cliente_preferente]).n;
                            struct_cajeras[i].contador++;
                            bandera = TRUE;
                        }
                        //Desencolar a un cliente banco
                        else if(struct_cajeras[i].ultimo_atendido == cliente_preferente || struct_cajeras[i].ultimo_atendido == cliente_pobre && struct_cajeras[i].contador < 5 && !bandera && filas_usuarios[cliente_banco].num_elem != 0)
                        {
                            printf("\nDesencolar a un cliente todas estan llenas");
                            struct_cajeras[i].ultimo_atendido = cliente_banco;
                            Dequeue(&filas_usuarios[cliente_banco]).n;
                            struct_cajeras[i].contador++;
                            bandera = TRUE;
                        }
                        //Desencolar a un pobre
                        else if(struct_cajeras[i].ultimo_atendido == cliente_preferente || struct_cajeras[i].ultimo_atendido == cliente_banco && !bandera && filas_usuarios[cliente_banco].num_elem != 0)
                        {
                            printf("\nDesencolar a un pobre todas estan llenas");
                            struct_cajeras[i].ultimo_atendido = cliente_pobre;
                            Dequeue(&filas_usuarios[cliente_pobre]).n;
                            struct_cajeras[i].contador = 0;
                            bandera = TRUE;
                        }
                    }
                }
            }
        }
    }
}

int conversion_ms(int tiempo)
{
    return tiempo/100;
}
