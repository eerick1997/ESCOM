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
static const char *ng0 = "/home/erick/Documentos/GitHub/Computer-architecture/ESCOMIPS/Pila/Pila.vhd";
extern char *IEEE_P_2592010699;
extern char *IEEE_P_3620187407;

unsigned char ieee_p_2592010699_sub_2763492388968962707_503743352(char *, char *, unsigned int , unsigned int );
char *ieee_p_3620187407_sub_2255506239096166994_3965413181(char *, char *, char *, char *, int );
char *ieee_p_3620187407_sub_2255506239096238868_3965413181(char *, char *, char *, char *, int );
int ieee_p_3620187407_sub_5109402382352621412_3965413181(char *, char *, char *);


static void work_a_1026116396_3010917595_p_0(char *t0)
{
    char t12[16];
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
    unsigned char t11;
    unsigned int t13;
    unsigned int t14;
    unsigned char t15;
    char *t16;
    char *t17;
    char *t18;

LAB0:    xsi_set_current_line(31, ng0);
    t1 = (t0 + 1192U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)3);
    if (t4 != 0)
        goto LAB2;

LAB4:    t1 = (t0 + 992U);
    t3 = ieee_p_2592010699_sub_2763492388968962707_503743352(IEEE_P_2592010699, t1, 0U, 0U);
    if (t3 != 0)
        goto LAB5;

LAB6:
LAB3:    t1 = (t0 + 4928);
    *((int *)t1) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(32, ng0);
    t1 = xsi_get_transient_memory(4U);
    memset(t1, 0, 4U);
    t5 = t1;
    memset(t5, (unsigned char)2, 4U);
    t6 = (t0 + 5056);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    memcpy(t10, t1, 4U);
    xsi_driver_first_trans_fast_port(t6);
    goto LAB3;

LAB5:    xsi_set_current_line(34, ng0);
    t2 = (t0 + 1512U);
    t5 = *((char **)t2);
    t4 = *((unsigned char *)t5);
    t11 = (t4 == (unsigned char)3);
    if (t11 != 0)
        goto LAB7;

LAB9:    t1 = (t0 + 1672U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)3);
    if (t4 != 0)
        goto LAB12;

LAB13:
LAB8:    goto LAB3;

LAB7:    xsi_set_current_line(35, ng0);
    t2 = (t0 + 1992U);
    t6 = *((char **)t2);
    t2 = (t0 + 8328U);
    t7 = ieee_p_3620187407_sub_2255506239096166994_3965413181(IEEE_P_3620187407, t12, t6, t2, 1);
    t8 = (t12 + 12U);
    t13 = *((unsigned int *)t8);
    t14 = (1U * t13);
    t15 = (4U != t14);
    if (t15 == 1)
        goto LAB10;

LAB11:    t9 = (t0 + 5056);
    t10 = (t9 + 56U);
    t16 = *((char **)t10);
    t17 = (t16 + 56U);
    t18 = *((char **)t17);
    memcpy(t18, t7, 4U);
    xsi_driver_first_trans_fast_port(t9);
    goto LAB8;

LAB10:    xsi_size_not_matching(4U, t14, 0);
    goto LAB11;

LAB12:    xsi_set_current_line(37, ng0);
    t1 = (t0 + 1992U);
    t5 = *((char **)t1);
    t1 = (t0 + 8328U);
    t6 = ieee_p_3620187407_sub_2255506239096238868_3965413181(IEEE_P_3620187407, t12, t5, t1, 1);
    t7 = (t12 + 12U);
    t13 = *((unsigned int *)t7);
    t14 = (1U * t13);
    t11 = (4U != t14);
    if (t11 == 1)
        goto LAB14;

LAB15:    t8 = (t0 + 5056);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    t16 = (t10 + 56U);
    t17 = *((char **)t16);
    memcpy(t17, t6, 4U);
    xsi_driver_first_trans_fast_port(t8);
    goto LAB8;

LAB14:    xsi_size_not_matching(4U, t14, 0);
    goto LAB15;

}

static void work_a_1026116396_3010917595_p_1(char *t0)
{
    char t15[16];
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
    unsigned char t11;
    unsigned char t12;
    unsigned char t13;
    char *t14;
    unsigned int t16;
    unsigned int t17;

LAB0:    xsi_set_current_line(45, ng0);
    t1 = (t0 + 1192U);
    t2 = *((char **)t1);
    t3 = *((unsigned char *)t2);
    t4 = (t3 == (unsigned char)3);
    if (t4 != 0)
        goto LAB2;

LAB4:    t1 = (t0 + 992U);
    t3 = ieee_p_2592010699_sub_2763492388968962707_503743352(IEEE_P_2592010699, t1, 0U, 0U);
    if (t3 != 0)
        goto LAB5;

LAB6:
LAB3:    t1 = (t0 + 4944);
    *((int *)t1) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(46, ng0);
    t1 = xsi_get_transient_memory(16U);
    memset(t1, 0, 16U);
    t5 = t1;
    memset(t5, (unsigned char)2, 16U);
    t6 = (t0 + 5120);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    memcpy(t10, t1, 16U);
    xsi_driver_first_trans_fast_port(t6);
    goto LAB3;

LAB5:    xsi_set_current_line(48, ng0);
    t2 = (t0 + 1352U);
    t5 = *((char **)t2);
    t4 = *((unsigned char *)t5);
    t11 = (t4 == (unsigned char)3);
    if (t11 != 0)
        goto LAB7;

LAB9:    xsi_set_current_line(55, ng0);
    t1 = (t0 + 2152U);
    t2 = *((char **)t1);
    t1 = (t0 + 8344U);
    t5 = ieee_p_3620187407_sub_2255506239096166994_3965413181(IEEE_P_3620187407, t15, t2, t1, 1);
    t6 = (t15 + 12U);
    t16 = *((unsigned int *)t6);
    t17 = (1U * t16);
    t3 = (16U != t17);
    if (t3 == 1)
        goto LAB13;

LAB14:    t7 = (t0 + 5120);
    t8 = (t7 + 56U);
    t9 = *((char **)t8);
    t10 = (t9 + 56U);
    t14 = *((char **)t10);
    memcpy(t14, t5, 16U);
    xsi_driver_first_trans_fast_port(t7);

LAB8:    goto LAB3;

LAB7:    xsi_set_current_line(49, ng0);
    t2 = (t0 + 1672U);
    t6 = *((char **)t2);
    t12 = *((unsigned char *)t6);
    t13 = (t12 == (unsigned char)3);
    if (t13 != 0)
        goto LAB10;

LAB12:    xsi_set_current_line(52, ng0);
    t1 = (t0 + 1832U);
    t2 = *((char **)t1);
    t1 = (t0 + 5120);
    t5 = (t1 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    memcpy(t8, t2, 16U);
    xsi_driver_first_trans_fast_port(t1);

LAB11:    goto LAB8;

LAB10:    xsi_set_current_line(50, ng0);
    t2 = (t0 + 2472U);
    t7 = *((char **)t2);
    t2 = (t0 + 5120);
    t8 = (t2 + 56U);
    t9 = *((char **)t8);
    t10 = (t9 + 56U);
    t14 = *((char **)t10);
    memcpy(t14, t7, 16U);
    xsi_driver_first_trans_fast_port(t2);
    goto LAB11;

LAB13:    xsi_size_not_matching(16U, t17, 0);
    goto LAB14;

}

static void work_a_1026116396_3010917595_p_2(char *t0)
{
    char t11[16];
    unsigned char t1;
    char *t2;
    unsigned char t3;
    char *t4;
    char *t5;
    unsigned char t6;
    unsigned char t7;
    char *t8;
    unsigned char t9;
    unsigned char t10;
    char *t12;
    char *t13;
    char *t14;
    unsigned int t15;
    unsigned int t16;
    unsigned char t17;
    char *t18;
    char *t19;
    int t20;
    int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    char *t25;
    char *t26;
    char *t27;
    char *t28;
    char *t29;

LAB0:    xsi_set_current_line(63, ng0);
    t2 = (t0 + 992U);
    t3 = xsi_signal_has_event(t2);
    if (t3 == 1)
        goto LAB5;

LAB6:    t1 = (unsigned char)0;

LAB7:    if (t1 != 0)
        goto LAB2;

LAB4:
LAB3:    t2 = (t0 + 4960);
    *((int *)t2) = 1;

LAB1:    return;
LAB2:    xsi_set_current_line(64, ng0);
    t4 = (t0 + 1512U);
    t8 = *((char **)t4);
    t9 = *((unsigned char *)t8);
    t10 = (t9 == (unsigned char)3);
    if (t10 != 0)
        goto LAB8;

LAB10:
LAB9:    goto LAB3;

LAB5:    t4 = (t0 + 1032U);
    t5 = *((char **)t4);
    t6 = *((unsigned char *)t5);
    t7 = (t6 == (unsigned char)3);
    t1 = t7;
    goto LAB7;

LAB8:    xsi_set_current_line(65, ng0);
    t4 = (t0 + 2152U);
    t12 = *((char **)t4);
    t4 = (t0 + 8344U);
    t13 = ieee_p_3620187407_sub_2255506239096166994_3965413181(IEEE_P_3620187407, t11, t12, t4, 1);
    t14 = (t11 + 12U);
    t15 = *((unsigned int *)t14);
    t16 = (1U * t15);
    t17 = (16U != t16);
    if (t17 == 1)
        goto LAB11;

LAB12:    t18 = (t0 + 1992U);
    t19 = *((char **)t18);
    t18 = (t0 + 8328U);
    t20 = ieee_p_3620187407_sub_5109402382352621412_3965413181(IEEE_P_3620187407, t19, t18);
    t21 = (t20 - 0);
    t22 = (t21 * 1);
    t23 = (16U * t22);
    t24 = (0U + t23);
    t25 = (t0 + 5184);
    t26 = (t25 + 56U);
    t27 = *((char **)t26);
    t28 = (t27 + 56U);
    t29 = *((char **)t28);
    memcpy(t29, t13, 16U);
    xsi_driver_first_trans_delta(t25, t24, 16U, 0LL);
    goto LAB9;

LAB11:    xsi_size_not_matching(16U, t16, 0);
    goto LAB12;

}

static void work_a_1026116396_3010917595_p_3(char *t0)
{
    char t3[16];
    char *t1;
    char *t2;
    char *t4;
    char *t5;
    int t6;
    int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    char *t11;
    char *t12;
    char *t13;
    char *t14;
    char *t15;
    char *t16;
    char *t17;

LAB0:    xsi_set_current_line(70, ng0);

LAB3:    t1 = (t0 + 2312U);
    t2 = *((char **)t1);
    t1 = (t0 + 1992U);
    t4 = *((char **)t1);
    t1 = (t0 + 8328U);
    t5 = ieee_p_3620187407_sub_2255506239096238868_3965413181(IEEE_P_3620187407, t3, t4, t1, 1);
    t6 = ieee_p_3620187407_sub_5109402382352621412_3965413181(IEEE_P_3620187407, t5, t3);
    t7 = (t6 - 0);
    t8 = (t7 * 1);
    xsi_vhdl_check_range_of_index(0, 15, 1, t6);
    t9 = (16U * t8);
    t10 = (0 + t9);
    t11 = (t2 + t10);
    t12 = (t0 + 5248);
    t13 = (t12 + 56U);
    t14 = *((char **)t13);
    t15 = (t14 + 56U);
    t16 = *((char **)t15);
    memcpy(t16, t11, 16U);
    xsi_driver_first_trans_fast(t12);

LAB2:    t17 = (t0 + 4976);
    *((int *)t17) = 1;

LAB1:    return;
LAB4:    goto LAB2;

}


extern void work_a_1026116396_3010917595_init()
{
	static char *pe[] = {(void *)work_a_1026116396_3010917595_p_0,(void *)work_a_1026116396_3010917595_p_1,(void *)work_a_1026116396_3010917595_p_2,(void *)work_a_1026116396_3010917595_p_3};
	xsi_register_didat("work_a_1026116396_3010917595", "isim/Pila_TB_isim_beh.exe.sim/work/a_1026116396_3010917595.didat");
	xsi_register_executes(pe);
}
