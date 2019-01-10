#include <stdio.h>
#include <time.h>
#include <windows.h>
#include "TAD Cola\TAD Cola\TADCola\TADColaDin.c"
#include "PresentacionCajas.c"
#define TIEMPO_BASE 200

typedef struct cajera
{
    int atendiendo;
    int siguiente;
    int ultimo;
    int tiempo_atencion;
    int tam_fila;
    int he_atendido;
    boolean disponible;
} cajera;

int encolar_usuario(int caja, int no_cajas, int tiempo, int tiempo_usuarios, int ID, cola* mis_cajas, cajera struct_cajera);
cajera posible_atender(cajera struct_cajeras, cola* mis_cajas);
cajera atendiendo_usuario(int tiempo, cajera struct_cajeras);
void texto_caja(int opcion, para_texto texto);
int cajas_abiertas();
boolean podemos_cerrar(int no_cajas, cola * mis_cajeras, int atendidos);

int main(void)
{
    int i, tiempo = 0, tiempo_llegada = 0, no_cajas = 0, ID, quecaja, atendidos = 0;
    ID = 0;
    no_cajas = cajas_abiertas();
    cajera struct_cajera[no_cajas];
    tiempo_llegada = tiempo_clientes();
    cola mis_cajas[no_cajas];

    for(i = 0; i<no_cajas; i++)
    {
        Initialize(&mis_cajas[i]);
        do
        {
            struct_cajera[i].atendiendo = 0;
            struct_cajera[i].disponible = TRUE;
            struct_cajera[i].he_atendido = 0;
            printf("\nCuanto tiempo de atencion tendra la cajera %d? -> ", i+1);
            scanf("%d", &struct_cajera[i].tiempo_atencion);
        }
        while(struct_cajera[i].tiempo_atencion <100 || struct_cajera[i].tiempo_atencion > 1000);
    }

    system("CLS");
    Cajas();
    while(!podemos_cerrar(no_cajas, &mis_cajas, atendidos))
    {
        quecaja = seleccionar_caja(no_cajas);
        //colocar_texo(struct_cajera[quecaja], quecaja);
        ID = encolar_usuario(quecaja, no_cajas, tiempo, tiempo_llegada, ID, &mis_cajas[quecaja], struct_cajera[quecaja]);

        tiempo++;
        atendidos=0;
        Sleep(TIEMPO_BASE/2);
        for(i=0; i<no_cajas; i++)
        {
            atendidos += struct_cajera[i].he_atendido;
        }
        MoverCursor(1,1);
        printf("%d", atendidos);

        for(i=0; i<no_cajas; i++)
        {
            struct_cajera[i] = posible_atender(struct_cajera[i], &mis_cajas[i]);
            struct_cajera[i] = atendiendo_usuario(tiempo, struct_cajera[i]);
        }

        Sleep(TIEMPO_BASE/2);
        texto_todas_las_cajas(&struct_cajera, no_cajas);

        if(!Empty(&mis_cajas[quecaja]))
        {
            struct_cajera[quecaja].siguiente = Front(&mis_cajas[quecaja]).cliente;
            struct_cajera[quecaja].tam_fila = Size(&mis_cajas[quecaja]);
            struct_cajera[quecaja].ultimo = Final(&mis_cajas[quecaja]).cliente;
        }
        else
        {
            struct_cajera[quecaja].siguiente = 0;
            struct_cajera[quecaja].tam_fila = 0;
            struct_cajera[quecaja].ultimo = 0;
        }
    }

    return 0;
}

void texto_todas_las_cajas(cajera* struct_cajeras, int no_cajas)
{
    int i;
    for(i=0; i<no_cajas; i++)
    {
        colocar_texo(struct_cajeras[i], i);
    }
}

cajera atendiendo_usuario(int tiempo, cajera struct_cajeras)
{
    //printf("\n\natendiendousuario()");
    if(tiempo % struct_cajeras.tiempo_atencion == 0)
    {
        //printf("\n\tPuedo atender a un usuario");
        struct_cajeras.atendiendo = 0;
        struct_cajeras.disponible = TRUE;
        struct_cajeras.he_atendido++;
    }
    return struct_cajeras;
}


/**It's working! :'v**/
cajera posible_atender(cajera struct_cajeras, cola* mis_cajas)
{
    //printf("\nposible_atender() Starts!... cajera disponible? %d", struct_cajeras.disponible);
    if(struct_cajeras.disponible && !Empty(mis_cajas))
    {
        //printf("\n\tAtendere al usuario %d", Front(mis_cajas).cliente);
        struct_cajeras.atendiendo = Dequeue(mis_cajas).cliente;
        struct_cajeras.disponible = FALSE;
    }

    if(!Empty(mis_cajas))
    {
        struct_cajeras.siguiente = Front(mis_cajas).cliente;
        struct_cajeras.tam_fila = Size(mis_cajas);
        struct_cajeras.ultimo = Final(mis_cajas).cliente;
    }
    else
    {
        struct_cajeras.siguiente = 0;
        struct_cajeras.tam_fila = 0;
        struct_cajeras.ultimo = 0;
    }
    return struct_cajeras;
}

/**It's working! :'v**/
int encolar_usuario(int que_caja, int no_cajas, int tiempo, int tiempo_usuarios, int ID, cola* mis_cajas, cajera struct_cajera)
{
    para_texto mi_texto;
    //printf("\nencolar_usuario() Starts...");
    elemento mi_elemento;
    if(tiempo % tiempo_usuarios == 0)
    {
        //printf("\n\tPuedo encolar");
        ID++;
        //printf("\nencolare al usuario %d en una caja\n\n", ID);
        mi_elemento.cliente = ID;
        Queue(mis_cajas, mi_elemento);
        struct_cajera.ultimo = ID;
        struct_cajera.tam_fila++;
        colocar_texo(struct_cajera, que_caja);
        //printf("\nNumero de clientes en la fila: %d elemento guardo %d, Frente tiene: %d", Size(mis_cajas), mi_elemento.cliente, Front(mis_cajas).cliente);

    }
    return ID;
}

int seleccionar_caja(int no_cajas)
{
    srand(time(NULL));
    return rand()%no_cajas;
}

int cajas_abiertas()
{
    int no_cajas;
    do
    {
        printf("\n Cuantas cajas estaran abiertas? -> ");
        scanf("%d", &no_cajas);
    }
    while(no_cajas > 9 || no_cajas < 1);
    return no_cajas;
}

int tiempo_clientes()
{
    int tiempo_llegada;
    do
    {
        printf("\n Cuanto tiempo tardan en llegar los clientes? -> ");
        scanf("%d", &tiempo_llegada);
    }
    while(tiempo_llegada > 1000 || tiempo_llegada < 100);
    return tiempo_llegada;
}

void colocar_texo(cajera struct_cajera, int caja)
{
    para_texto mi_texto;

    mi_texto.atendiendo = 0;
    mi_texto.en_espera = 0;
    mi_texto.tam_cola = 0;
    mi_texto.ultima = 0;
    mi_texto.atendidos = 0;

    if(struct_cajera.atendiendo <= 0)
        struct_cajera.atendiendo = 0;

    if(struct_cajera.siguiente <= 0)
        struct_cajera.siguiente = 0;

    if(struct_cajera.tam_fila <= 0)
        struct_cajera.tam_fila = 0;

    if(struct_cajera.ultimo <= 0)
        struct_cajera.ultimo = 0;

    mi_texto.atendiendo = struct_cajera.atendiendo;
    mi_texto.en_espera = struct_cajera.siguiente;
    mi_texto.tam_cola = struct_cajera.tam_fila;
    mi_texto.ultima = struct_cajera.ultimo;
    mi_texto.atendidos = struct_cajera.he_atendido;

    texto_caja(caja, mi_texto);
}


void texto_caja(int opcion, para_texto texto)
{
    switch(opcion)
    {
    case 0:
        Texto1(texto);
        break;
    case 1:
        Texto2(texto);
        break;
    case 2:
        Texto3(texto);
        break;
    case 3:
        Texto4(texto);
        break;
    case 4:
        Texto5(texto);
        break;
    case 5:
        Texto6(texto);
        break;
    case 6:
        Texto7(texto);
        break;
    case 7:
        Texto8(texto);
        break;
    case 8:
        Texto9(texto);
        break;
    }
}

boolean podemos_cerrar(int no_cajas, cola * mis_cajeras, int atendidos)
{
    int i, j = 0;
    boolean status = FALSE;
    for(i=0; i<no_cajas; i++)
    {
        if(Size(&mis_cajeras[i]) > 0)
        {
            j++;
        }
    }
    if(j==0)
    {
        if(atendidos >= 100)
        {
            status = TRUE;
        }
        else
        {
            status = FALSE;
        }
    }
    else if(atendidos>=100)
    {
        if(j==0)
        {
            status = TRUE;
        }
        else
        {
            status = FALSE;
        }
    }
    else
    {
        status = FALSE;
    }
    return status;
}
