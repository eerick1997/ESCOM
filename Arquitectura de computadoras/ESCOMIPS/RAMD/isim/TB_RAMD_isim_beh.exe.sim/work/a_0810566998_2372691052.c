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
static const char *ng0 = "/home/erick/Documentos/Software/Xilinx/RAMD/TB_RAMD.vhd";
extern char *STD_TEXTIO;
extern char *IEEE_P_3564397177;
extern char *IEEE_P_2592010699;

unsigned char ieee_p_2592010699_sub_2763492388968962707_503743352(char *, char *, unsigned int , unsigned int );
void ieee_p_3564397177_sub_1675032430035817134_91900896(char *, char *, char *, char *);
void ieee_p_3564397177_sub_2258168291854845616_91900896(char *, char *, char *, char *, char *, unsigned char , int );
void ieee_p_3564397177_sub_2518136782373626985_91900896(char *, char *, char *, unsigned char , unsigned char , int );
void ieee_p_3564397177_sub_2863978933202788330_91900896(char *, char *, char *, char *, char *);


static void work_a_0810566998_2372691052_p_0(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    int64 t7;
    int64 t8;

LAB0:    t1 = (t0 + 3912U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(81, ng0);
    t2 = (t0 + 4560);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)2;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(82, ng0);
    t2 = (t0 + 1968U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 3720);
    xsi_process_wait(t2, t8);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(83, ng0);
    t2 = (t0 + 4560);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)3;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(84, ng0);
    t2 = (t0 + 1968U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 3720);
    xsi_process_wait(t2, t8);

LAB10:    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB8:    goto LAB2;

LAB9:    goto LAB8;

LAB11:    goto LAB9;

}

static void work_a_0810566998_2372691052_p_1(char *t0)
{
    char t5[16];
    char t10[8];
    char t11[8];
    char t12[8];
    char t13[8];
    char t18[8];
    char t19[16];
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t6;
    char *t7;
    int t8;
    unsigned int t9;
    int64 t14;
    int t15;
    char *t16;
    unsigned char t17;
    int t20;

LAB0:    t1 = (t0 + 4160U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(114, ng0);
    t2 = (t0 + 2880U);
    t3 = (t0 + 7853);
    t6 = (t5 + 0U);
    t7 = (t6 + 0U);
    *((int *)t7) = 1;
    t7 = (t6 + 4U);
    *((int *)t7) = 12;
    t7 = (t6 + 8U);
    *((int *)t7) = 1;
    t8 = (12 - 1);
    t9 = (t8 * 1);
    t9 = (t9 + 1);
    t7 = (t6 + 12U);
    *((unsigned int *)t7) = t9;
    std_textio_file_open1(t2, t3, t5, (unsigned char)0);
    xsi_set_current_line(116, ng0);
    t2 = (t0 + 2776U);
    t3 = (t0 + 7865);
    t6 = (t5 + 0U);
    t7 = (t6 + 0U);
    *((int *)t7) = 1;
    t7 = (t6 + 4U);
    *((int *)t7) = 13;
    t7 = (t6 + 8U);
    *((int *)t7) = 1;
    t8 = (13 - 1);
    t9 = (t8 * 1);
    t9 = (t9 + 1);
    t7 = (t6 + 12U);
    *((unsigned int *)t7) = t9;
    std_textio_file_open1(t2, t3, t5, (unsigned char)1);
    xsi_set_current_line(119, ng0);
    t2 = (t0 + 7878);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 4U);
    xsi_set_current_line(120, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t10, t7, 4U);
    t6 = (t0 + 7584U);
    t8 = (4U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t10, t6, (unsigned char)0, t8);
    xsi_set_current_line(121, ng0);
    t2 = (t0 + 7882);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 4U);
    xsi_set_current_line(122, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t11, t7, 4U);
    t6 = (t0 + 7584U);
    t8 = (4U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t11, t6, (unsigned char)0, t8);
    xsi_set_current_line(123, ng0);
    t2 = (t0 + 7886);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 4U);
    xsi_set_current_line(124, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t12, t7, 4U);
    t6 = (t0 + 7584U);
    t8 = (4U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t12, t6, (unsigned char)0, t8);
    xsi_set_current_line(125, ng0);
    t2 = (t0 + 7890);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 4U);
    xsi_set_current_line(126, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 3336U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t13, t7, 4U);
    t6 = (t0 + 7584U);
    t8 = (4U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t13, t6, (unsigned char)0, t8);
    xsi_set_current_line(128, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 2776U);
    t4 = (t0 + 3056U);
    std_textio_writeline(STD_TEXTIO, t2, t3, t4);
    xsi_set_current_line(130, ng0);
    t14 = (100 * 1000LL);
    t2 = (t0 + 3968);
    xsi_process_wait(t2, t14);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(133, ng0);
    t2 = (t0 + 7894);
    *((int *)t2) = 0;
    t3 = (t0 + 7898);
    *((int *)t3) = 11;
    t8 = 0;
    t15 = 11;

LAB8:    if (t8 <= t15)
        goto LAB9;

LAB11:    xsi_set_current_line(162, ng0);
    t2 = (t0 + 2880U);
    std_textio_file_close(t2);
    xsi_set_current_line(164, ng0);
    t2 = (t0 + 2776U);
    std_textio_file_close(t2);
    xsi_set_current_line(166, ng0);

LAB19:    *((char **)t1) = &&LAB20;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB9:    xsi_set_current_line(135, ng0);
    t4 = (t0 + 3968);
    t6 = (t0 + 2880U);
    t7 = (t0 + 3128U);
    std_textio_readline(STD_TEXTIO, t4, t6, t7);
    xsi_set_current_line(137, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3128U);
    t4 = (t0 + 2208U);
    t6 = *((char **)t4);
    t4 = (t0 + 7552U);
    ieee_p_3564397177_sub_2863978933202788330_91900896(IEEE_P_3564397177, t2, t3, t6, t4);
    xsi_set_current_line(138, ng0);
    t2 = (t0 + 2208U);
    t3 = *((char **)t2);
    t2 = (t0 + 4624);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t16 = *((char **)t7);
    memcpy(t16, t3, 16U);
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(140, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3128U);
    t4 = (t0 + 2328U);
    t6 = *((char **)t4);
    t4 = (t0 + 7568U);
    ieee_p_3564397177_sub_2863978933202788330_91900896(IEEE_P_3564397177, t2, t3, t6, t4);
    xsi_set_current_line(141, ng0);
    t2 = (t0 + 2328U);
    t3 = *((char **)t2);
    t2 = (t0 + 4688);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t16 = *((char **)t7);
    memcpy(t16, t3, 8U);
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(143, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3128U);
    t4 = (t0 + 2448U);
    t6 = *((char **)t4);
    t4 = (t6 + 0);
    ieee_p_3564397177_sub_1675032430035817134_91900896(IEEE_P_3564397177, t2, t3, t4);
    xsi_set_current_line(144, ng0);
    t2 = (t0 + 2448U);
    t3 = *((char **)t2);
    t17 = *((unsigned char *)t3);
    t2 = (t0 + 4752);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t16 = *((char **)t7);
    *((unsigned char *)t16) = t17;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(146, ng0);

LAB14:    t2 = (t0 + 4480);
    *((int *)t2) = 1;
    *((char **)t1) = &&LAB15;
    goto LAB1;

LAB10:    t2 = (t0 + 7894);
    t8 = *((int *)t2);
    t3 = (t0 + 7898);
    t15 = *((int *)t3);
    if (t8 == t15)
        goto LAB11;

LAB16:    t20 = (t8 + 1);
    t8 = t20;
    t4 = (t0 + 7894);
    *((int *)t4) = t8;
    goto LAB8;

LAB12:    t4 = (t0 + 4480);
    *((int *)t4) = 0;
    xsi_set_current_line(148, ng0);
    t2 = (t0 + 1672U);
    t3 = *((char **)t2);
    t2 = (t0 + 2088U);
    t4 = *((char **)t2);
    t2 = (t4 + 0);
    memcpy(t2, t3, 16U);
    xsi_set_current_line(150, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 2208U);
    t6 = *((char **)t4);
    memcpy(t5, t6, 16U);
    t4 = (t0 + 7552U);
    ieee_p_3564397177_sub_2258168291854845616_91900896(IEEE_P_3564397177, t2, t3, t5, t4, (unsigned char)0, 5);
    xsi_set_current_line(152, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 2328U);
    t6 = *((char **)t4);
    memcpy(t18, t6, 8U);
    t4 = (t0 + 7568U);
    ieee_p_3564397177_sub_2258168291854845616_91900896(IEEE_P_3564397177, t2, t3, t18, t4, (unsigned char)0, 5);
    xsi_set_current_line(154, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 2448U);
    t6 = *((char **)t4);
    t17 = *((unsigned char *)t6);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t17, (unsigned char)0, 5);
    xsi_set_current_line(156, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 3056U);
    t4 = (t0 + 2088U);
    t6 = *((char **)t4);
    memcpy(t19, t6, 16U);
    t4 = (t0 + 7536U);
    ieee_p_3564397177_sub_2258168291854845616_91900896(IEEE_P_3564397177, t2, t3, t19, t4, (unsigned char)0, 5);
    xsi_set_current_line(158, ng0);
    t2 = (t0 + 3968);
    t3 = (t0 + 2776U);
    t4 = (t0 + 3056U);
    std_textio_writeline(STD_TEXTIO, t2, t3, t4);
    goto LAB10;

LAB13:    t3 = (t0 + 1312U);
    t17 = ieee_p_2592010699_sub_2763492388968962707_503743352(IEEE_P_2592010699, t3, 0U, 0U);
    if (t17 == 1)
        goto LAB12;
    else
        goto LAB14;

LAB15:    goto LAB13;

LAB17:    goto LAB2;

LAB18:    goto LAB17;

LAB20:    goto LAB18;

}


extern void work_a_0810566998_2372691052_init()
{
	static char *pe[] = {(void *)work_a_0810566998_2372691052_p_0,(void *)work_a_0810566998_2372691052_p_1};
	xsi_register_didat("work_a_0810566998_2372691052", "isim/TB_RAMD_isim_beh.exe.sim/work/a_0810566998_2372691052.didat");
	xsi_register_executes(pe);
}
