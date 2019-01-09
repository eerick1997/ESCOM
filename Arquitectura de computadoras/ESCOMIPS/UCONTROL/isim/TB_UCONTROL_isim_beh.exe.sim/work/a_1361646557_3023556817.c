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
static const char *ng0 = "/home/erick/Documentos/GitHub/Computer-architecture/ESCOMIPS/UCONTROL/PRINCIPAL.vhd";



static void work_a_1361646557_3023556817_p_0(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    unsigned char t4;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;
    char *t17;

LAB0:    xsi_set_current_line(51, ng0);
    t1 = (t0 + 5032U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)2);
    if (t4 != 0)
        goto LAB3;

LAB4:
LAB5:    t11 = (t0 + 1192U);
    t12 = *((char **)t11);
    t11 = (t0 + 7272);
    t13 = (t11 + 56U);
    t14 = *((char **)t13);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    memcpy(t16, t12, 5U);
    xsi_driver_first_trans_fast(t11);

LAB2:    t17 = (t0 + 7160);
    *((int *)t17) = 1;

LAB1:    return;
LAB3:    t1 = (t0 + 12825);
    t6 = (t0 + 7272);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    memcpy(t10, t1, 5U);
    xsi_driver_first_trans_fast(t6);
    goto LAB2;

LAB6:    goto LAB2;

}

static void work_a_1361646557_3023556817_p_1(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    unsigned char t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;

LAB0:    xsi_set_current_line(69, ng0);
    t1 = (t0 + 4872U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)3);
    if (t4 != 0)
        goto LAB3;

LAB4:
LAB5:    t10 = (t0 + 2152U);
    t11 = *((char **)t10);
    t10 = (t0 + 7336);
    t12 = (t10 + 56U);
    t13 = *((char **)t12);
    t14 = (t13 + 56U);
    t15 = *((char **)t14);
    memcpy(t15, t11, 20U);
    xsi_driver_first_trans_fast_port(t10);

LAB2:    t16 = (t0 + 7176);
    *((int *)t16) = 1;

LAB1:    return;
LAB3:    t1 = (t0 + 2312U);
    t5 = *((char **)t1);
    t1 = (t0 + 7336);
    t6 = (t1 + 56U);
    t7 = *((char **)t6);
    t8 = (t7 + 56U);
    t9 = *((char **)t8);
    memcpy(t9, t5, 20U);
    xsi_driver_first_trans_fast_port(t1);
    goto LAB2;

LAB6:    goto LAB2;

}

static void work_a_1361646557_3023556817_p_2(char *t0)
{
    char *t1;
    char *t2;
    unsigned char t3;
    unsigned char t4;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;
    char *t17;

LAB0:    xsi_set_current_line(70, ng0);
    t1 = (t0 + 5032U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)2);
    if (t4 != 0)
        goto LAB3;

LAB4:
LAB5:    t11 = (t0 + 1192U);
    t12 = *((char **)t11);
    t11 = (t0 + 7400);
    t13 = (t11 + 56U);
    t14 = *((char **)t13);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    memcpy(t16, t12, 5U);
    xsi_driver_first_trans_fast(t11);

LAB2:    t17 = (t0 + 7192);
    *((int *)t17) = 1;

LAB1:    return;
LAB3:    t1 = (t0 + 12830);
    t6 = (t0 + 7400);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    memcpy(t10, t1, 5U);
    xsi_driver_first_trans_fast(t6);
    goto LAB2;

LAB6:    goto LAB2;

}


extern void work_a_1361646557_3023556817_init()
{
	static char *pe[] = {(void *)work_a_1361646557_3023556817_p_0,(void *)work_a_1361646557_3023556817_p_1,(void *)work_a_1361646557_3023556817_p_2};
	xsi_register_didat("work_a_1361646557_3023556817", "isim/TB_UCONTROL_isim_beh.exe.sim/work/a_1361646557_3023556817.didat");
	xsi_register_executes(pe);
}
