/**********************************************************************/
/*   ____  ____                                                       */
/*  /   /\/   /                                                       */
/* /___/  \  /                                                        */
/* \   \   \/                                                       */
/*  \   \        Copyright (c) 2003-2009 Xilinx, Inc.                */
/*  /   /          All Right Reserved.                                 */
/* /---/   /\                                                         */
/* \   \  /  \                                                      */
/*  \___\/\___\                                                    */
/***********************************************************************/

/* This file is designed for use with ISim build 0xfbc00daa */

#define XSI_HIDE_SYMBOL_SPEC true
#include "xsi.h"
#include <memory.h>
#ifdef __GNUC__
#include <stdlib.h>
#else
#include <malloc.h>
#define alloca _alloca
#endif
static const char *ng0 = "/home/erick/Documentos/GitHub/Computer-architecture/ESCOMIPS/MICRO/MEMORIA_PROGRAMA.vhd";
extern char *IEEE_P_3620187407;

int ieee_p_3620187407_sub_5109402382352621412_3965413181(char *, char *, char *);


static void work_a_1690406812_2288309652_p_0(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    int t4;
    int t5;
    unsigned int t6;
    unsigned int t7;
    unsigned int t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;

LAB0:    xsi_set_current_line(113, ng0);

LAB3:    t1 = (t0 + 7728U);
    t2 = *((char **)t1);
    t1 = (t0 + 1032U);
    t3 = *((char **)t1);
    t1 = (t0 + 16272U);
    t4 = ieee_p_3620187407_sub_5109402382352621412_3965413181(IEEE_P_3620187407, t3, t1);
    t5 = (t4 - 0);
    t6 = (t5 * 1);
    xsi_vhdl_check_range_of_index(0, 65535, 1, t4);
    t7 = (25U * t6);
    t8 = (0 + t7);
    t9 = (t2 + t8);
    t10 = (t0 + 9104);
    t11 = (t10 + 56U);
    t12 = *((char **)t11);
    t13 = (t12 + 56U);
    t14 = *((char **)t13);
    memcpy(t14, t9, 25U);
    xsi_driver_first_trans_fast_port(t10);

LAB2:    t15 = (t0 + 9024);
    *((int *)t15) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}


extern void work_a_1690406812_2288309652_init()
{
	static char *pe[] = {(void *)work_a_1690406812_2288309652_p_0};
	xsi_register_didat("work_a_1690406812_2288309652", "isim/aiura_isim_beh.exe.sim/work/a_1690406812_2288309652.didat");
	xsi_register_executes(pe);
}
