#include <stdio.h>
#include <windows.h>
#include <stdlib.h>
#include "TAD Cola\TAD Cola\TADCola\TADColaDin.c"
#include "Procesos.c"


#define QUANTUM 1000

#define FRENTE 0
#define ULTIMO 1
#define FINALIZADO 2

//Prototipos de las funciones
void ingresar_procesos(cola* mis_procesos, int no_procesos);
void ejecutar_procesos(cola* mis_procesos, cola* finalizados, int tiempo);
void actualizar_interfaz(cola* en_espera, cola* finalizados);
//prototipos

int main(void)
{
    int no_procesos, i, tiempo = 0;
    elemento elemento_mostrar[3];
    cola procesos_por_atender;
    cola finalizados;

    Initialize(&procesos_por_atender);
    Initialize(&finalizados);

    //Primeramente solicitamos el numero de procesos a ingresar
    do
    {
        printf("\nCuantos procesos seran encolados? (minimo uno) -> ");
        scanf("%d", &no_procesos);
    }
    while(no_procesos < 1);

    ingresar_procesos(&procesos_por_atender, no_procesos);
    system("CLS");
    cuadros();
    while(!Empty(&procesos_por_atender))
    {
        actualizar_interfaz(&procesos_por_atender, &finalizados);
        Sleep(QUANTUM);
        tiempo++;
        MoverCursor(2, 90);
        printf("%d", tiempo);
        ejecutar_procesos(&procesos_por_atender, &finalizados, tiempo);
        actualizar_interfaz(&procesos_por_atender, &finalizados);
    }
    return 0;
}

void ingresar_procesos(cola* mis_procesos, int no_procesos)
{
    int i;
    elemento mi_proceso;

    for(i=0; i<no_procesos; i++)
    {
        fflush(stdin);
        printf("\nProceso: %d", i+1);
        printf("\nIngresa el nombre del proceso -> ");
        gets(mi_proceso.nombre_del_proceso);
        printf("\nIngresa la actividad que realiza este proceso ->");
        gets(mi_proceso.actividad);
        printf("\nIngresa el ID del proceso -> ");
        gets(mi_proceso.ID);
        printf("\nTiempo de ejecucion (segundos) -> ");
        scanf("%d", &mi_proceso.tiempo);
        mi_proceso.tiempo_restante = mi_proceso.tiempo;
        Queue(mis_procesos, mi_proceso);
    }
}

/**It's working :'v**/
void ejecutar_procesos(cola* mis_procesos, cola* finalizados, int tiempo)
{
    elemento procesos;
    if(!Empty(mis_procesos))
    {
        if(Front(mis_procesos).tiempo_restante > 0)
        {
            procesos = Dequeue(mis_procesos);
            procesos.tiempo_restante--;
            Queue(mis_procesos, procesos);
        }
        else
        {
            procesos = Dequeue(mis_procesos);
            Queue(finalizados, procesos);
        }
    }
    else
    {
        printf("\nTodos los procesos se han ejecutado");
        exit(0);
    }
}

void actualizar_interfaz(cola* en_espera, cola* finalizados)
{
    elemento e;
    if(!Empty(en_espera))
    {
        e = Front(en_espera);
        Espera(e.nombre_del_proceso, e.actividad, e.ID, e.tiempo_restante);
        e = Final(en_espera);
        Espera_ult(e.nombre_del_proceso, e.actividad, e.ID, e.tiempo_restante);
    }
    else
    {
        Espera(" ", " ", " ", 0);
        Espera_ult(" ", " ", " ", 0);
    }
}

void finalizados(cola*finalizados){
    elemento e;
    para_texto = texto;
    int i;
    if(!Empty(finalizados)){
        for(i=0; i<Size(finalizados); i++){
            /**
            Aquí pasaremos los parámetros a las funciones
            **/
            Finalizado(/**Aquí pasamos los parámetros**/)
        }
    }
}
