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
static int ng0[] = {0, 0};
static int ng1[] = {1095521093, 0, 70, 0};
static unsigned int ng2[] = {1U, 1U};
static unsigned int ng3[] = {0U, 0U};
static int ng4[] = {1, 0};



static int TChk_101_18_tstmp(char *t1)
{
    char t4[8];
    int t0;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    unsigned int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    char *t19;
    char *t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    unsigned int t25;

LAB0:    t2 = (t1 + 4312U);
    t3 = *((char **)t2);
    t2 = ((char*)((ng0)));
    memset(t4, 0, 8);
    t5 = (t3 + 4);
    t6 = (t2 + 4);
    t7 = *((unsigned int *)t3);
    t8 = *((unsigned int *)t2);
    t9 = (t7 ^ t8);
    t10 = *((unsigned int *)t5);
    t11 = *((unsigned int *)t6);
    t12 = (t10 ^ t11);
    t13 = (t9 | t12);
    t14 = *((unsigned int *)t5);
    t15 = *((unsigned int *)t6);
    t16 = (t14 | t15);
    t17 = (~(t16));
    t18 = (t13 & t17);
    if (t18 != 0)
        goto LAB3;

LAB2:    if (t16 != 0)
        goto LAB4;

LAB5:    t20 = (t4 + 4);
    t21 = *((unsigned int *)t20);
    t22 = (~(t21));
    t23 = *((unsigned int *)t4);
    t24 = (t23 & t22);
    t25 = (t24 != 0);
    t0 = t25;

LAB1:    return t0;
LAB3:    *((unsigned int *)t4) = 1;
    goto LAB5;

LAB4:    t19 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t19) = 1;
    goto LAB5;

}

static int TChk_102_19_tstmp(char *t1)
{
    char t4[8];
    int t0;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    unsigned int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    char *t19;
    char *t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    unsigned int t25;

LAB0:    t2 = (t1 + 4312U);
    t3 = *((char **)t2);
    t2 = ((char*)((ng0)));
    memset(t4, 0, 8);
    t5 = (t3 + 4);
    t6 = (t2 + 4);
    t7 = *((unsigned int *)t3);
    t8 = *((unsigned int *)t2);
    t9 = (t7 ^ t8);
    t10 = *((unsigned int *)t5);
    t11 = *((unsigned int *)t6);
    t12 = (t10 ^ t11);
    t13 = (t9 | t12);
    t14 = *((unsigned int *)t5);
    t15 = *((unsigned int *)t6);
    t16 = (t14 | t15);
    t17 = (~(t16));
    t18 = (t13 & t17);
    if (t18 != 0)
        goto LAB3;

LAB2:    if (t16 != 0)
        goto LAB4;

LAB5:    t20 = (t4 + 4);
    t21 = *((unsigned int *)t20);
    t22 = (~(t21));
    t23 = *((unsigned int *)t4);
    t24 = (t23 & t22);
    t25 = (t24 != 0);
    t0 = t25;

LAB1:    return t0;
LAB3:    *((unsigned int *)t4) = 1;
    goto LAB5;

LAB4:    t19 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t19) = 1;
    goto LAB5;

}

static int TChk_103_20_tstmp(char *t1)
{
    char t4[8];
    int t0;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    unsigned int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    char *t19;
    char *t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    unsigned int t25;

LAB0:    t2 = (t1 + 4152U);
    t3 = *((char **)t2);
    t2 = ((char*)((ng0)));
    memset(t4, 0, 8);
    t5 = (t3 + 4);
    t6 = (t2 + 4);
    t7 = *((unsigned int *)t3);
    t8 = *((unsigned int *)t2);
    t9 = (t7 ^ t8);
    t10 = *((unsigned int *)t5);
    t11 = *((unsigned int *)t6);
    t12 = (t10 ^ t11);
    t13 = (t9 | t12);
    t14 = *((unsigned int *)t5);
    t15 = *((unsigned int *)t6);
    t16 = (t14 | t15);
    t17 = (~(t16));
    t18 = (t13 & t17);
    if (t18 != 0)
        goto LAB3;

LAB2:    if (t16 != 0)
        goto LAB4;

LAB5:    t20 = (t4 + 4);
    t21 = *((unsigned int *)t20);
    t22 = (~(t21));
    t23 = *((unsigned int *)t4);
    t24 = (t23 & t22);
    t25 = (t24 != 0);
    t0 = t25;

LAB1:    return t0;
LAB3:    *((unsigned int *)t4) = 1;
    goto LAB5;

LAB4:    t19 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t19) = 1;
    goto LAB5;

}

static int TChk_104_21_tstmp(char *t1)
{
    char t4[8];
    int t0;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    unsigned int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    char *t19;
    char *t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    unsigned int t25;

LAB0:    t2 = (t1 + 4152U);
    t3 = *((char **)t2);
    t2 = ((char*)((ng0)));
    memset(t4, 0, 8);
    t5 = (t3 + 4);
    t6 = (t2 + 4);
    t7 = *((unsigned int *)t3);
    t8 = *((unsigned int *)t2);
    t9 = (t7 ^ t8);
    t10 = *((unsigned int *)t5);
    t11 = *((unsigned int *)t6);
    t12 = (t10 ^ t11);
    t13 = (t9 | t12);
    t14 = *((unsigned int *)t5);
    t15 = *((unsigned int *)t6);
    t16 = (t14 | t15);
    t17 = (~(t16));
    t18 = (t13 & t17);
    if (t18 != 0)
        goto LAB3;

LAB2:    if (t16 != 0)
        goto LAB4;

LAB5:    t20 = (t4 + 4);
    t21 = *((unsigned int *)t20);
    t22 = (~(t21));
    t23 = *((unsigned int *)t4);
    t24 = (t23 & t22);
    t25 = (t24 != 0);
    t0 = t25;

LAB1:    return t0;
LAB3:    *((unsigned int *)t4) = 1;
    goto LAB5;

LAB4:    t19 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t19) = 1;
    goto LAB5;

}

static int TChk_106_22_tstmp(char *t1)
{
    char t4[8];
    int t0;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    unsigned int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    char *t19;
    char *t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    unsigned int t25;

LAB0:    t2 = (t1 + 4472U);
    t3 = *((char **)t2);
    t2 = ((char*)((ng0)));
    memset(t4, 0, 8);
    t5 = (t3 + 4);
    t6 = (t2 + 4);
    t7 = *((unsigned int *)t3);
    t8 = *((unsigned int *)t2);
    t9 = (t7 ^ t8);
    t10 = *((unsigned int *)t5);
    t11 = *((unsigned int *)t6);
    t12 = (t10 ^ t11);
    t13 = (t9 | t12);
    t14 = *((unsigned int *)t5);
    t15 = *((unsigned int *)t6);
    t16 = (t14 | t15);
    t17 = (~(t16));
    t18 = (t13 & t17);
    if (t18 != 0)
        goto LAB3;

LAB2:    if (t16 != 0)
        goto LAB4;

LAB5:    t20 = (t4 + 4);
    t21 = *((unsigned int *)t20);
    t22 = (~(t21));
    t23 = *((unsigned int *)t4);
    t24 = (t23 & t22);
    t25 = (t24 != 0);
    t0 = t25;

LAB1:    return t0;
LAB3:    *((unsigned int *)t4) = 1;
    goto LAB5;

LAB4:    t19 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t19) = 1;
    goto LAB5;

}

static int TChk_107_23_tstmp(char *t1)
{
    char t4[8];
    int t0;
    char *t2;
    char *t3;
    char *t5;
    char *t6;
    unsigned int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    unsigned int t18;
    char *t19;
    char *t20;
    unsigned int t21;
    unsigned int t22;
    unsigned int t23;
    unsigned int t24;
    unsigned int t25;

LAB0:    t2 = (t1 + 4632U);
    t3 = *((char **)t2);
    t2 = ((char*)((ng0)));
    memset(t4, 0, 8);
    t5 = (t3 + 4);
    t6 = (t2 + 4);
    t7 = *((unsigned int *)t3);
    t8 = *((unsigned int *)t2);
    t9 = (t7 ^ t8);
    t10 = *((unsigned int *)t5);
    t11 = *((unsigned int *)t6);
    t12 = (t10 ^ t11);
    t13 = (t9 | t12);
    t14 = *((unsigned int *)t5);
    t15 = *((unsigned int *)t6);
    t16 = (t14 | t15);
    t17 = (~(t16));
    t18 = (t13 & t17);
    if (t18 != 0)
        goto LAB3;

LAB2:    if (t16 != 0)
        goto LAB4;

LAB5:    t20 = (t4 + 4);
    t21 = *((unsigned int *)t20);
    t22 = (~(t21));
    t23 = *((unsigned int *)t4);
    t24 = (t23 & t22);
    t25 = (t24 != 0);
    t0 = t25;

LAB1:    return t0;
LAB3:    *((unsigned int *)t4) = 1;
    goto LAB5;

LAB4:    t19 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t19) = 1;
    goto LAB5;

}

static int TChk_109_24_tchk(char *t1)
{
    int t0;
    char *t2;
    char *t3;
    unsigned int t4;
    unsigned int t5;
    unsigned int t6;
    unsigned int t7;
    unsigned int t8;

LAB0:    t2 = (t1 + 1752U);
    t3 = *((char **)t2);
    t2 = (t3 + 4);
    t4 = *((unsigned int *)t2);
    t5 = (~(t4));
    t6 = *((unsigned int *)t3);
    t7 = (t6 & t5);
    t8 = (t7 != 0);
    t0 = t8;

LAB1:    return t0;
}

static int TChk_110_25_tchk(char *t1)
{
    int t0;
    char *t2;
    char *t3;
    unsigned int t4;
    unsigned int t5;
    unsigned int t6;
    unsigned int t7;
    unsigned int t8;

LAB0:    t2 = (t1 + 1752U);
    t3 = *((char **)t2);
    t2 = (t3 + 4);
    t4 = *((unsigned int *)t2);
    t5 = (~(t4));
    t6 = *((unsigned int *)t3);
    t7 = (t6 & t5);
    t8 = (t7 != 0);
    t0 = t8;

LAB1:    return t0;
}

static int TChk_111_26_tchk(char *t1)
{
    int t0;
    char *t2;
    char *t3;
    unsigned int t4;
    unsigned int t5;
    unsigned int t6;
    unsigned int t7;
    unsigned int t8;

LAB0:    t2 = (t1 + 1752U);
    t3 = *((char **)t2);
    t2 = (t3 + 4);
    t4 = *((unsigned int *)t2);
    t5 = (~(t4));
    t6 = *((unsigned int *)t3);
    t7 = (t6 & t5);
    t8 = (t7 != 0);
    t0 = t8;

LAB1:    return t0;
}

static void NetDecl_42_0(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    unsigned int t10;
    unsigned int t11;
    char *t12;
    unsigned int t13;
    unsigned int t14;
    char *t15;
    unsigned int t16;
    unsigned int t17;
    char *t18;

LAB0:    t1 = (t0 + 7544U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 15752);
    t3 = *((char **)t2);
    t4 = ((((char*)(t3))) + 40U);
    t5 = *((char **)t4);
    t4 = (t0 + 12432);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t8 = (t7 + 56U);
    t9 = *((char **)t8);
    memset(t9, 0, 8);
    t10 = 1U;
    t11 = t10;
    t12 = (t5 + 4);
    t13 = *((unsigned int *)t5);
    t10 = (t10 & t13);
    t14 = *((unsigned int *)t12);
    t11 = (t11 & t14);
    t15 = (t9 + 4);
    t16 = *((unsigned int *)t9);
    *((unsigned int *)t9) = (t16 | t10);
    t17 = *((unsigned int *)t15);
    *((unsigned int *)t15) = (t17 | t11);
    xsi_driver_vfirst_trans(t4, 0, 0U);
    t18 = (t0 + 12080);
    *((int *)t18) = 1;

LAB1:    return;
}

static void Gate_55_1(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    unsigned int t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    char *t16;
    char *t17;

LAB0:    t1 = (t0 + 7792U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 6312);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t0 + 12496);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    t8 = (t7 + 56U);
    t9 = *((char **)t8);
    t10 = (t9 + 4);
    t11 = (t4 + 4);
    if (*((unsigned int *)t11) == 1)
        goto LAB4;

LAB5:    t12 = *((unsigned int *)t4);
    t13 = (t12 & 1);
    *((unsigned int *)t9) = t13;
    t14 = *((unsigned int *)t11);
    t15 = (t14 & 1);
    *((unsigned int *)t10) = t15;

LAB6:    t16 = (t0 + 12496);
    xsi_driver_vfirst_trans(t16, 0, 0);
    t17 = (t0 + 12096);
    *((int *)t17) = 1;

LAB1:    return;
LAB4:    *((unsigned int *)t9) = 1;
    *((unsigned int *)t10) = 1;
    goto LAB6;

}

static void Gate_57_2(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;

LAB0:    t1 = (t0 + 8040U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 5112U);
    t3 = *((char **)t2);
    t2 = (t0 + 12560);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    xsi_vlog_notGate(t7, t3);
    t8 = (t0 + 12560);
    xsi_driver_vfirst_trans(t8, 0, 0);
    t9 = (t0 + 12112);
    *((int *)t9) = 1;

LAB1:    return;
}

static void Gate_58_3(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;

LAB0:    t1 = (t0 + 8288U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 5592U);
    t3 = *((char **)t2);
    t2 = (t0 + 12624);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    xsi_vlog_notGate(t7, t3);
    t8 = (t0 + 12624);
    xsi_driver_vfirst_trans(t8, 0, 0);
    t9 = (t0 + 12128);
    *((int *)t9) = 1;

LAB1:    return;
}

static void Gate_59_4(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;

LAB0:    t1 = (t0 + 8536U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 5752U);
    t3 = *((char **)t2);
    t2 = (t0 + 12688);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    xsi_vlog_notGate(t7, t3);
    t8 = (t0 + 12688);
    xsi_driver_vfirst_trans(t8, 0, 0);
    t9 = (t0 + 12144);
    *((int *)t9) = 1;

LAB1:    return;
}

static void Gate_60_5(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;

LAB0:    t1 = (t0 + 8784U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 2552U);
    t3 = *((char **)t2);
    t2 = (t0 + 12752);
    t4 = (t2 + 56U);
    t5 = *((char **)t4);
    t6 = (t5 + 56U);
    t7 = *((char **)t6);
    xsi_vlog_notGate(t7, t3);
    t8 = (t0 + 12752);
    xsi_driver_vfirst_trans(t8, 0, 0);
    t9 = (t0 + 12160);
    *((int *)t9) = 1;

LAB1:    return;
}

static void Gate_61_6(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;

LAB0:    t1 = (t0 + 9032U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 5112U);
    t3 = *((char **)t2);
    t2 = (t0 + 1592U);
    t4 = *((char **)t2);
    t2 = (t0 + 12816);
    t5 = (t2 + 56U);
    t6 = *((char **)t5);
    t7 = (t6 + 56U);
    t8 = *((char **)t7);
    xsi_vlog_XorGate(t8, 2, t3, t4);
    t9 = (t0 + 12816);
    xsi_driver_vfirst_trans(t9, 0, 0);
    t10 = (t0 + 12176);
    *((int *)t10) = 1;

LAB1:    return;
}

static void Gate_63_7(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;

LAB0:    t1 = (t0 + 9280U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 2872U);
    t3 = *((char **)t2);
    t2 = (t0 + 3032U);
    t4 = *((char **)t2);
    t2 = (t0 + 3192U);
    t5 = *((char **)t2);
    t2 = (t0 + 5432U);
    t6 = *((char **)t2);
    t2 = (t0 + 12880);
    t7 = (t2 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    xsi_vlog_AndGate(t10, 4, t3, t4, t5, t6);
    t11 = (t0 + 12880);
    xsi_driver_vfirst_trans(t11, 0, 0);
    t12 = (t0 + 12192);
    *((int *)t12) = 1;

LAB1:    return;
}

static void Gate_64_8(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;

LAB0:    t1 = (t0 + 9528U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 2872U);
    t3 = *((char **)t2);
    t2 = (t0 + 3032U);
    t4 = *((char **)t2);
    t2 = (t0 + 3192U);
    t5 = *((char **)t2);
    t2 = (t0 + 3352U);
    t6 = *((char **)t2);
    t2 = (t0 + 12944);
    t7 = (t2 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    xsi_vlog_AndGate(t10, 4, t3, t4, t5, t6);
    t11 = (t0 + 12944);
    xsi_driver_vfirst_trans(t11, 0, 0);
    t12 = (t0 + 12208);
    *((int *)t12) = 1;

LAB1:    return;
}

static void Gate_65_9(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;

LAB0:    t1 = (t0 + 9776U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 2872U);
    t3 = *((char **)t2);
    t2 = (t0 + 5432U);
    t4 = *((char **)t2);
    t2 = (t0 + 5112U);
    t5 = *((char **)t2);
    t2 = (t0 + 13008);
    t6 = (t2 + 56U);
    t7 = *((char **)t6);
    t8 = (t7 + 56U);
    t9 = *((char **)t8);
    xsi_vlog_AndGate(t9, 3, t3, t4, t5);
    t10 = (t0 + 13008);
    xsi_driver_vfirst_trans(t10, 0, 0);
    t11 = (t0 + 12224);
    *((int *)t11) = 1;

LAB1:    return;
}

static void Gate_66_10(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    char *t7;
    char *t8;
    char *t9;
    char *t10;
    char *t11;
    char *t12;

LAB0:    t1 = (t0 + 10024U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 2872U);
    t3 = *((char **)t2);
    t2 = (t0 + 5432U);
    t4 = *((char **)t2);
    t2 = (t0 + 3032U);
    t5 = *((char **)t2);
    t2 = (t0 + 2712U);
    t6 = *((char **)t2);
    t2 = (t0 + 13072);
    t7 = (t2 + 56U);
    t8 = *((char **)t7);
    t9 = (t8 + 56U);
    t10 = *((char **)t9);
    xsi_vlog_AndGate(t10, 4, t3, t4, t5, t6);
    t11 = (t0 + 13072);
    xsi_driver_vfirst_trans(t11, 0, 0);
    t12 = (t0 + 12240);
    *((int *)t12) = 1;

LAB1:    return;
}

static void Cont_68_11(char *t0)
{
    char t3[8];
    char t4[8];
    char t6[16];
    char *t1;
    char *t2;
    char *t5;
    char *t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    char *t13;
    char *t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    char *t18;
    unsigned int t19;
    unsigned int t20;
    unsigned int t21;
    unsigned int t22;
    char *t23;
    char *t24;
    char *t25;
    char *t26;
    char *t27;
    char *t28;
    char *t29;
    char *t30;
    unsigned int t31;
    unsigned int t32;
    char *t33;
    unsigned int t34;
    unsigned int t35;
    char *t36;
    unsigned int t37;
    unsigned int t38;
    char *t39;

LAB0:    t1 = (t0 + 10272U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 744);
    t5 = *((char **)t2);
    t2 = ((char*)((ng1)));
    xsi_vlog_unsigned_equal(t6, 40, t5, 32, t2, 40);
    memset(t4, 0, 8);
    t7 = (t6 + 4);
    t8 = *((unsigned int *)t7);
    t9 = (~(t8));
    t10 = *((unsigned int *)t6);
    t11 = (t10 & t9);
    t12 = (t11 & 1U);
    if (t12 != 0)
        goto LAB4;

LAB5:    if (*((unsigned int *)t7) != 0)
        goto LAB6;

LAB7:    t14 = (t4 + 4);
    t15 = *((unsigned int *)t4);
    t16 = *((unsigned int *)t14);
    t17 = (t15 || t16);
    if (t17 > 0)
        goto LAB8;

LAB9:    t19 = *((unsigned int *)t4);
    t20 = (~(t19));
    t21 = *((unsigned int *)t14);
    t22 = (t20 || t21);
    if (t22 > 0)
        goto LAB10;

LAB11:    if (*((unsigned int *)t14) > 0)
        goto LAB12;

LAB13:    if (*((unsigned int *)t4) > 0)
        goto LAB14;

LAB15:    memcpy(t3, t25, 8);

LAB16:    t26 = (t0 + 13136);
    t27 = (t26 + 56U);
    t28 = *((char **)t27);
    t29 = (t28 + 56U);
    t30 = *((char **)t29);
    memset(t30, 0, 8);
    t31 = 1U;
    t32 = t31;
    t33 = (t3 + 4);
    t34 = *((unsigned int *)t3);
    t31 = (t31 & t34);
    t35 = *((unsigned int *)t33);
    t32 = (t32 & t35);
    t36 = (t30 + 4);
    t37 = *((unsigned int *)t30);
    *((unsigned int *)t30) = (t37 | t31);
    t38 = *((unsigned int *)t36);
    *((unsigned int *)t36) = (t38 | t32);
    xsi_driver_vfirst_trans(t26, 0, 0);
    t39 = (t0 + 12256);
    *((int *)t39) = 1;

LAB1:    return;
LAB4:    *((unsigned int *)t4) = 1;
    goto LAB7;

LAB6:    t13 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t13) = 1;
    goto LAB7;

LAB8:    t18 = ((char*)((ng2)));
    goto LAB9;

LAB10:    t23 = (t0 + 6152);
    t24 = (t23 + 56U);
    t25 = *((char **)t24);
    goto LAB11;

LAB12:    xsi_vlog_unsigned_bit_combine(t3, 1, t18, 1, t25, 1);
    goto LAB16;

LAB14:    memcpy(t3, t18, 8);
    goto LAB16;

}

static void Cont_69_12(char *t0)
{
    char t3[8];
    char t4[8];
    char t6[16];
    char *t1;
    char *t2;
    char *t5;
    char *t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    char *t13;
    char *t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    char *t18;
    unsigned int t19;
    unsigned int t20;
    unsigned int t21;
    unsigned int t22;
    char *t23;
    char *t24;
    char *t25;
    char *t26;
    char *t27;
    char *t28;
    unsigned int t29;
    unsigned int t30;
    char *t31;
    unsigned int t32;
    unsigned int t33;
    char *t34;
    unsigned int t35;
    unsigned int t36;
    char *t37;

LAB0:    t1 = (t0 + 10520U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 880);
    t5 = *((char **)t2);
    t2 = ((char*)((ng1)));
    xsi_vlog_unsigned_equal(t6, 40, t5, 32, t2, 40);
    memset(t4, 0, 8);
    t7 = (t6 + 4);
    t8 = *((unsigned int *)t7);
    t9 = (~(t8));
    t10 = *((unsigned int *)t6);
    t11 = (t10 & t9);
    t12 = (t11 & 1U);
    if (t12 != 0)
        goto LAB4;

LAB5:    if (*((unsigned int *)t7) != 0)
        goto LAB6;

LAB7:    t14 = (t4 + 4);
    t15 = *((unsigned int *)t4);
    t16 = *((unsigned int *)t14);
    t17 = (t15 || t16);
    if (t17 > 0)
        goto LAB8;

LAB9:    t19 = *((unsigned int *)t4);
    t20 = (~(t19));
    t21 = *((unsigned int *)t14);
    t22 = (t20 || t21);
    if (t22 > 0)
        goto LAB10;

LAB11:    if (*((unsigned int *)t14) > 0)
        goto LAB12;

LAB13:    if (*((unsigned int *)t4) > 0)
        goto LAB14;

LAB15:    memcpy(t3, t24, 8);

LAB16:    t23 = (t0 + 13200);
    t25 = (t23 + 56U);
    t26 = *((char **)t25);
    t27 = (t26 + 56U);
    t28 = *((char **)t27);
    memset(t28, 0, 8);
    t29 = 1U;
    t30 = t29;
    t31 = (t3 + 4);
    t32 = *((unsigned int *)t3);
    t29 = (t29 & t32);
    t33 = *((unsigned int *)t31);
    t30 = (t30 & t33);
    t34 = (t28 + 4);
    t35 = *((unsigned int *)t28);
    *((unsigned int *)t28) = (t35 | t29);
    t36 = *((unsigned int *)t34);
    *((unsigned int *)t34) = (t36 | t30);
    xsi_driver_vfirst_trans(t23, 0, 0);
    t37 = (t0 + 12272);
    *((int *)t37) = 1;

LAB1:    return;
LAB4:    *((unsigned int *)t4) = 1;
    goto LAB7;

LAB6:    t13 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t13) = 1;
    goto LAB7;

LAB8:    t18 = ((char*)((ng3)));
    goto LAB9;

LAB10:    t23 = (t0 + 3672U);
    t24 = *((char **)t23);
    goto LAB11;

LAB12:    xsi_vlog_unsigned_bit_combine(t3, 1, t18, 1, t24, 1);
    goto LAB16;

LAB14:    memcpy(t3, t18, 8);
    goto LAB16;

}

static void Cont_70_13(char *t0)
{
    char t3[8];
    char t4[8];
    char t6[16];
    char *t1;
    char *t2;
    char *t5;
    char *t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    char *t13;
    char *t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    char *t18;
    unsigned int t19;
    unsigned int t20;
    unsigned int t21;
    unsigned int t22;
    char *t23;
    char *t24;
    char *t25;
    char *t26;
    char *t27;
    char *t28;
    unsigned int t29;
    unsigned int t30;
    char *t31;
    unsigned int t32;
    unsigned int t33;
    char *t34;
    unsigned int t35;
    unsigned int t36;
    char *t37;

LAB0:    t1 = (t0 + 10768U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 880);
    t5 = *((char **)t2);
    t2 = ((char*)((ng1)));
    xsi_vlog_unsigned_equal(t6, 40, t5, 32, t2, 40);
    memset(t4, 0, 8);
    t7 = (t6 + 4);
    t8 = *((unsigned int *)t7);
    t9 = (~(t8));
    t10 = *((unsigned int *)t6);
    t11 = (t10 & t9);
    t12 = (t11 & 1U);
    if (t12 != 0)
        goto LAB4;

LAB5:    if (*((unsigned int *)t7) != 0)
        goto LAB6;

LAB7:    t14 = (t4 + 4);
    t15 = *((unsigned int *)t4);
    t16 = *((unsigned int *)t14);
    t17 = (t15 || t16);
    if (t17 > 0)
        goto LAB8;

LAB9:    t19 = *((unsigned int *)t4);
    t20 = (~(t19));
    t21 = *((unsigned int *)t14);
    t22 = (t20 || t21);
    if (t22 > 0)
        goto LAB10;

LAB11:    if (*((unsigned int *)t14) > 0)
        goto LAB12;

LAB13:    if (*((unsigned int *)t4) > 0)
        goto LAB14;

LAB15:    memcpy(t3, t24, 8);

LAB16:    t23 = (t0 + 13264);
    t25 = (t23 + 56U);
    t26 = *((char **)t25);
    t27 = (t26 + 56U);
    t28 = *((char **)t27);
    memset(t28, 0, 8);
    t29 = 1U;
    t30 = t29;
    t31 = (t3 + 4);
    t32 = *((unsigned int *)t3);
    t29 = (t29 & t32);
    t33 = *((unsigned int *)t31);
    t30 = (t30 & t33);
    t34 = (t28 + 4);
    t35 = *((unsigned int *)t28);
    *((unsigned int *)t28) = (t35 | t29);
    t36 = *((unsigned int *)t34);
    *((unsigned int *)t34) = (t36 | t30);
    xsi_driver_vfirst_trans(t23, 0, 0);
    t37 = (t0 + 12288);
    *((int *)t37) = 1;

LAB1:    return;
LAB4:    *((unsigned int *)t4) = 1;
    goto LAB7;

LAB6:    t13 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t13) = 1;
    goto LAB7;

LAB8:    t18 = ((char*)((ng3)));
    goto LAB9;

LAB10:    t23 = (t0 + 3512U);
    t24 = *((char **)t23);
    goto LAB11;

LAB12:    xsi_vlog_unsigned_bit_combine(t3, 1, t18, 1, t24, 1);
    goto LAB16;

LAB14:    memcpy(t3, t18, 8);
    goto LAB16;

}

static void Cont_71_14(char *t0)
{
    char t3[8];
    char t4[8];
    char t6[16];
    char *t1;
    char *t2;
    char *t5;
    char *t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    char *t13;
    char *t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    char *t18;
    unsigned int t19;
    unsigned int t20;
    unsigned int t21;
    unsigned int t22;
    char *t23;
    char *t24;
    char *t25;
    char *t26;
    char *t27;
    char *t28;
    unsigned int t29;
    unsigned int t30;
    char *t31;
    unsigned int t32;
    unsigned int t33;
    char *t34;
    unsigned int t35;
    unsigned int t36;
    char *t37;

LAB0:    t1 = (t0 + 11016U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 880);
    t5 = *((char **)t2);
    t2 = ((char*)((ng1)));
    xsi_vlog_unsigned_equal(t6, 40, t5, 32, t2, 40);
    memset(t4, 0, 8);
    t7 = (t6 + 4);
    t8 = *((unsigned int *)t7);
    t9 = (~(t8));
    t10 = *((unsigned int *)t6);
    t11 = (t10 & t9);
    t12 = (t11 & 1U);
    if (t12 != 0)
        goto LAB4;

LAB5:    if (*((unsigned int *)t7) != 0)
        goto LAB6;

LAB7:    t14 = (t4 + 4);
    t15 = *((unsigned int *)t4);
    t16 = *((unsigned int *)t14);
    t17 = (t15 || t16);
    if (t17 > 0)
        goto LAB8;

LAB9:    t19 = *((unsigned int *)t4);
    t20 = (~(t19));
    t21 = *((unsigned int *)t14);
    t22 = (t20 || t21);
    if (t22 > 0)
        goto LAB10;

LAB11:    if (*((unsigned int *)t14) > 0)
        goto LAB12;

LAB13:    if (*((unsigned int *)t4) > 0)
        goto LAB14;

LAB15:    memcpy(t3, t24, 8);

LAB16:    t23 = (t0 + 13328);
    t25 = (t23 + 56U);
    t26 = *((char **)t25);
    t27 = (t26 + 56U);
    t28 = *((char **)t27);
    memset(t28, 0, 8);
    t29 = 1U;
    t30 = t29;
    t31 = (t3 + 4);
    t32 = *((unsigned int *)t3);
    t29 = (t29 & t32);
    t33 = *((unsigned int *)t31);
    t30 = (t30 & t33);
    t34 = (t28 + 4);
    t35 = *((unsigned int *)t28);
    *((unsigned int *)t28) = (t35 | t29);
    t36 = *((unsigned int *)t34);
    *((unsigned int *)t34) = (t36 | t30);
    xsi_driver_vfirst_trans(t23, 0, 0);
    t37 = (t0 + 12304);
    *((int *)t37) = 1;

LAB1:    return;
LAB4:    *((unsigned int *)t4) = 1;
    goto LAB7;

LAB6:    t13 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t13) = 1;
    goto LAB7;

LAB8:    t18 = ((char*)((ng3)));
    goto LAB9;

LAB10:    t23 = (t0 + 3832U);
    t24 = *((char **)t23);
    goto LAB11;

LAB12:    xsi_vlog_unsigned_bit_combine(t3, 1, t18, 1, t24, 1);
    goto LAB16;

LAB14:    memcpy(t3, t18, 8);
    goto LAB16;

}

static void Cont_72_15(char *t0)
{
    char t3[8];
    char t4[8];
    char t6[16];
    char *t1;
    char *t2;
    char *t5;
    char *t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    unsigned int t11;
    unsigned int t12;
    char *t13;
    char *t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    char *t18;
    unsigned int t19;
    unsigned int t20;
    unsigned int t21;
    unsigned int t22;
    char *t23;
    char *t24;
    char *t25;
    char *t26;
    char *t27;
    char *t28;
    unsigned int t29;
    unsigned int t30;
    char *t31;
    unsigned int t32;
    unsigned int t33;
    char *t34;
    unsigned int t35;
    unsigned int t36;
    char *t37;

LAB0:    t1 = (t0 + 11264U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 880);
    t5 = *((char **)t2);
    t2 = ((char*)((ng1)));
    xsi_vlog_unsigned_equal(t6, 40, t5, 32, t2, 40);
    memset(t4, 0, 8);
    t7 = (t6 + 4);
    t8 = *((unsigned int *)t7);
    t9 = (~(t8));
    t10 = *((unsigned int *)t6);
    t11 = (t10 & t9);
    t12 = (t11 & 1U);
    if (t12 != 0)
        goto LAB4;

LAB5:    if (*((unsigned int *)t7) != 0)
        goto LAB6;

LAB7:    t14 = (t4 + 4);
    t15 = *((unsigned int *)t4);
    t16 = *((unsigned int *)t14);
    t17 = (t15 || t16);
    if (t17 > 0)
        goto LAB8;

LAB9:    t19 = *((unsigned int *)t4);
    t20 = (~(t19));
    t21 = *((unsigned int *)t14);
    t22 = (t20 || t21);
    if (t22 > 0)
        goto LAB10;

LAB11:    if (*((unsigned int *)t14) > 0)
        goto LAB12;

LAB13:    if (*((unsigned int *)t4) > 0)
        goto LAB14;

LAB15:    memcpy(t3, t24, 8);

LAB16:    t23 = (t0 + 13392);
    t25 = (t23 + 56U);
    t26 = *((char **)t25);
    t27 = (t26 + 56U);
    t28 = *((char **)t27);
    memset(t28, 0, 8);
    t29 = 1U;
    t30 = t29;
    t31 = (t3 + 4);
    t32 = *((unsigned int *)t3);
    t29 = (t29 & t32);
    t33 = *((unsigned int *)t31);
    t30 = (t30 & t33);
    t34 = (t28 + 4);
    t35 = *((unsigned int *)t28);
    *((unsigned int *)t28) = (t35 | t29);
    t36 = *((unsigned int *)t34);
    *((unsigned int *)t34) = (t36 | t30);
    xsi_driver_vfirst_trans(t23, 0, 0);
    t37 = (t0 + 12320);
    *((int *)t37) = 1;

LAB1:    return;
LAB4:    *((unsigned int *)t4) = 1;
    goto LAB7;

LAB6:    t13 = (t4 + 4);
    *((unsigned int *)t4) = 1;
    *((unsigned int *)t13) = 1;
    goto LAB7;

LAB8:    t18 = ((char*)((ng3)));
    goto LAB9;

LAB10:    t23 = (t0 + 3992U);
    t24 = *((char **)t23);
    goto LAB11;

LAB12:    xsi_vlog_unsigned_bit_combine(t3, 1, t18, 1, t24, 1);
    goto LAB16;

LAB14:    memcpy(t3, t18, 8);
    goto LAB16;

}

static void Always_74_16(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    unsigned int t6;
    unsigned int t7;
    unsigned int t8;
    unsigned int t9;
    unsigned int t10;
    char *t11;
    char *t12;
    unsigned int t13;
    unsigned int t14;
    unsigned int t15;
    unsigned int t16;
    unsigned int t17;
    char *t18;
    char *t19;

LAB0:    t1 = (t0 + 11512U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 12336);
    *((int *)t2) = 1;
    t3 = (t0 + 11544);
    *((char **)t3) = t2;
    *((char **)t1) = &&LAB4;

LAB1:    return;
LAB4:
LAB5:    t4 = (t0 + 2552U);
    t5 = *((char **)t4);
    t4 = (t5 + 4);
    t6 = *((unsigned int *)t4);
    t7 = (~(t6));
    t8 = *((unsigned int *)t5);
    t9 = (t8 & t7);
    t10 = (t9 != 0);
    if (t10 > 0)
        goto LAB6;

LAB7:
LAB14:    t2 = (t0 + 5752U);
    t3 = *((char **)t2);
    t2 = (t0 + 6632);
    xsi_vlogvar_assign_value(t2, t3, 0, 0, 1);
    t2 = (t0 + 5592U);
    t3 = *((char **)t2);
    t2 = (t0 + 6472);
    xsi_vlogvar_assign_value(t2, t3, 0, 0, 1);

LAB8:    goto LAB2;

LAB6:    t11 = (t0 + 472);
    t12 = *((char **)t11);
    t11 = (t12 + 4);
    t13 = *((unsigned int *)t11);
    t14 = (~(t13));
    t15 = *((unsigned int *)t12);
    t16 = (t15 & t14);
    t17 = (t16 != 0);
    if (t17 > 0)
        goto LAB9;

LAB10:
LAB13:    t2 = ((char*)((ng4)));
    t3 = (t0 + 6472);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 1);
    t2 = ((char*)((ng0)));
    t3 = (t0 + 6632);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 1);

LAB11:    goto LAB8;

LAB9:
LAB12:    t18 = ((char*)((ng4)));
    t19 = (t0 + 6632);
    xsi_vlogvar_assign_value(t19, t18, 0, 0, 1);
    t2 = ((char*)((ng0)));
    t3 = (t0 + 6472);
    xsi_vlogvar_assign_value(t3, t2, 0, 0, 1);
    goto LAB11;

}

static void Always_90_17(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;

LAB0:    t1 = (t0 + 11760U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    t2 = (t0 + 12352);
    *((int *)t2) = 1;
    t3 = (t0 + 11792);
    *((char **)t3) = t2;
    *((char **)t1) = &&LAB4;

LAB1:    return;
LAB4:    t4 = (t0 + 4792U);
    t5 = *((char **)t4);
    t4 = (t0 + 6312);
    xsi_vlogvar_assign_value(t4, t5, 0, 0, 1);
    goto LAB2;

}


extern void simprims_ver_m_09253638010417583746_3752318385_init()
{
	static char *pe[] = {(void *)NetDecl_42_0,(void *)Gate_55_1,(void *)Gate_57_2,(void *)Gate_58_3,(void *)Gate_59_4,(void *)Gate_60_5,(void *)Gate_61_6,(void *)Gate_63_7,(void *)Gate_64_8,(void *)Gate_65_9,(void *)Gate_66_10,(void *)Cont_68_11,(void *)Cont_69_12,(void *)Cont_70_13,(void *)Cont_71_14,(void *)Cont_72_15,(void *)Always_74_16,(void *)Always_90_17};
	xsi_register_didat("simprims_ver_m_09253638010417583746_3752318385", "isim/TestBench_UCONTROL_isim_translate.exe.sim/simprims_ver/m_09253638010417583746_3752318385.didat");
	xsi_register_executes(pe);
	xsi_register_timingcheckfuncs(0, (void *)TChk_101_18_tstmp, 0);
	xsi_register_timingcheckfuncs(1, (void *)TChk_102_19_tstmp, 0);
	xsi_register_timingcheckfuncs(2, (void *)TChk_103_20_tstmp, 0);
	xsi_register_timingcheckfuncs(3, (void *)TChk_104_21_tstmp, 0);
	xsi_register_timingcheckfuncs(4, (void *)TChk_106_22_tstmp, 0);
	xsi_register_timingcheckfuncs(5, (void *)TChk_107_23_tstmp, 0);
	xsi_register_timingcheckfuncs(6, 0, (void *)TChk_109_24_tchk);
	xsi_register_timingcheckfuncs(7, 0, (void *)TChk_110_25_tchk);
	xsi_register_timingcheckfuncs(8, 0, (void *)TChk_111_26_tchk);
}
