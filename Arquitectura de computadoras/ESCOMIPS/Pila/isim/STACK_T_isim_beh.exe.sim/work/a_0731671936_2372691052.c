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
static const char *ng0 = "/home/erick/Documentos/GitHub/Computer-architecture/ESCOMIPS/Pila/Pila_TB.vhd";
extern char *STD_TEXTIO;
extern char *IEEE_P_3564397177;
extern char *IEEE_P_2592010699;

unsigned char ieee_p_2592010699_sub_2763492388968962707_503743352(char *, char *, unsigned int , unsigned int );
void ieee_p_3564397177_sub_1675032430035817134_91900896(char *, char *, char *, char *);
void ieee_p_3564397177_sub_2250825304603680424_91900896(char *, char *, char *, char *, char *, unsigned char , int );
void ieee_p_3564397177_sub_2258168291854845616_91900896(char *, char *, char *, char *, char *, unsigned char , int );
void ieee_p_3564397177_sub_2518136782373626985_91900896(char *, char *, char *, unsigned char , unsigned char , int );
void ieee_p_3564397177_sub_2863978933202788330_91900896(char *, char *, char *, char *, char *);


static void work_a_0731671936_2372691052_p_0(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    int64 t7;
    int64 t8;

LAB0:    t1 = (t0 + 4872U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(61, ng0);
    t2 = (t0 + 5520);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)2;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(62, ng0);
    t2 = (t0 + 2448U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 4680);
    xsi_process_wait(t2, t8);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(63, ng0);
    t2 = (t0 + 5520);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)3;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(64, ng0);
    t2 = (t0 + 2448U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 4680);
    xsi_process_wait(t2, t8);

LAB10:    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB8:    goto LAB2;

LAB9:    goto LAB8;

LAB11:    goto LAB9;

}

static void work_a_0731671936_2372691052_p_1(char *t0)
{
    char t5[16];
    char t10[8];
    char t11[8];
    char t12[8];
    char t13[8];
    char t14[8];
    char t15[8];
    char t16[8];
    char t20[8];
    char t21[16];
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t6;
    char *t7;
    int t8;
    unsigned int t9;
    int t17;
    char *t18;
    unsigned char t19;
    int t22;

LAB0:    t1 = (t0 + 5120U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(87, ng0);
    t2 = (t0 + 3840U);
    t3 = (t0 + 10070);
    t6 = (t5 + 0U);
    t7 = (t6 + 0U);
    *((int *)t7) = 1;
    t7 = (t6 + 4U);
    *((int *)t7) = 9;
    t7 = (t6 + 8U);
    *((int *)t7) = 1;
    t8 = (9 - 1);
    t9 = (t8 * 1);
    t9 = (t9 + 1);
    t7 = (t6 + 12U);
    *((unsigned int *)t7) = t9;
    std_textio_file_open1(t2, t3, t5, (unsigned char)0);
    xsi_set_current_line(88, ng0);
    t2 = (t0 + 3736U);
    t3 = (t0 + 10079);
    t6 = (t5 + 0U);
    t7 = (t6 + 0U);
    *((int *)t7) = 1;
    t7 = (t6 + 4U);
    *((int *)t7) = 10;
    t7 = (t6 + 8U);
    *((int *)t7) = 1;
    t8 = (10 - 1);
    t9 = (t8 * 1);
    t9 = (t9 + 1);
    t7 = (t6 + 12U);
    *((unsigned int *)t7) = t9;
    std_textio_file_open1(t2, t3, t5, (unsigned char)1);
    xsi_set_current_line(90, ng0);
    t2 = (t0 + 10089);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 6U);
    xsi_set_current_line(91, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t10, t7, 6U);
    t6 = (t0 + 9792U);
    t8 = (6U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t10, t6, (unsigned char)0, t8);
    xsi_set_current_line(92, ng0);
    t2 = (t0 + 10095);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 6U);
    xsi_set_current_line(93, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t11, t7, 6U);
    t6 = (t0 + 9792U);
    t8 = (6U + 2);
    std_textio_write7(STD_TEXTIO, t2, t3, t11, t6, (unsigned char)0, t8);
    xsi_set_current_line(94, ng0);
    t2 = (t0 + 10101);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 6U);
    xsi_set_current_line(95, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t12, t7, 6U);
    t6 = (t0 + 9792U);
    t8 = (6U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t12, t6, (unsigned char)0, t8);
    xsi_set_current_line(96, ng0);
    t2 = (t0 + 10107);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 6U);
    xsi_set_current_line(97, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t13, t7, 6U);
    t6 = (t0 + 9792U);
    t8 = (6U + 2);
    std_textio_write7(STD_TEXTIO, t2, t3, t13, t6, (unsigned char)0, t8);
    xsi_set_current_line(98, ng0);
    t2 = (t0 + 10113);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 6U);
    xsi_set_current_line(99, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t14, t7, 6U);
    t6 = (t0 + 9792U);
    t8 = (6U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t14, t6, (unsigned char)0, t8);
    xsi_set_current_line(100, ng0);
    t2 = (t0 + 10119);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 6U);
    xsi_set_current_line(101, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t15, t7, 6U);
    t6 = (t0 + 9792U);
    t8 = (6U + 2);
    std_textio_write7(STD_TEXTIO, t2, t3, t15, t6, (unsigned char)0, t8);
    xsi_set_current_line(102, ng0);
    t2 = (t0 + 10125);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 6U);
    xsi_set_current_line(103, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 4296U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t16, t7, 6U);
    t6 = (t0 + 9792U);
    t8 = (6U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t16, t6, (unsigned char)0, t8);
    xsi_set_current_line(104, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 3736U);
    t4 = (t0 + 4088U);
    std_textio_writeline(STD_TEXTIO, t2, t3, t4);
    xsi_set_current_line(106, ng0);
    t2 = (t0 + 10131);
    *((int *)t2) = 0;
    t3 = (t0 + 10135);
    *((int *)t3) = 19;
    t8 = 0;
    t17 = 19;

LAB4:    if (t8 <= t17)
        goto LAB5;

LAB7:    xsi_set_current_line(134, ng0);
    t2 = (t0 + 3840U);
    std_textio_file_close(t2);
    xsi_set_current_line(135, ng0);
    t2 = (t0 + 3736U);
    std_textio_file_close(t2);
    xsi_set_current_line(138, ng0);

LAB15:    *((char **)t1) = &&LAB16;

LAB1:    return;
LAB5:    xsi_set_current_line(107, ng0);
    t4 = (t0 + 4928);
    t6 = (t0 + 3840U);
    t7 = (t0 + 4016U);
    std_textio_readline(STD_TEXTIO, t4, t6, t7);
    xsi_set_current_line(108, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4016U);
    t4 = (t0 + 2568U);
    t6 = *((char **)t4);
    t4 = (t0 + 9744U);
    ieee_p_3564397177_sub_2863978933202788330_91900896(IEEE_P_3564397177, t2, t3, t6, t4);
    xsi_set_current_line(109, ng0);
    t2 = (t0 + 2568U);
    t3 = *((char **)t2);
    t2 = (t0 + 5584);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t18 = *((char **)t7);
    memcpy(t18, t3, 16U);
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(110, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4016U);
    t4 = (t0 + 2928U);
    t6 = *((char **)t4);
    t4 = (t6 + 0);
    ieee_p_3564397177_sub_1675032430035817134_91900896(IEEE_P_3564397177, t2, t3, t4);
    xsi_set_current_line(111, ng0);
    t2 = (t0 + 2928U);
    t3 = *((char **)t2);
    t19 = *((unsigned char *)t3);
    t2 = (t0 + 5648);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t18 = *((char **)t7);
    *((unsigned char *)t18) = t19;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(112, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4016U);
    t4 = (t0 + 2808U);
    t6 = *((char **)t4);
    t4 = (t6 + 0);
    ieee_p_3564397177_sub_1675032430035817134_91900896(IEEE_P_3564397177, t2, t3, t4);
    xsi_set_current_line(113, ng0);
    t2 = (t0 + 2808U);
    t3 = *((char **)t2);
    t19 = *((unsigned char *)t3);
    t2 = (t0 + 5712);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t18 = *((char **)t7);
    *((unsigned char *)t18) = t19;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(114, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4016U);
    t4 = (t0 + 2688U);
    t6 = *((char **)t4);
    t4 = (t6 + 0);
    ieee_p_3564397177_sub_1675032430035817134_91900896(IEEE_P_3564397177, t2, t3, t4);
    xsi_set_current_line(115, ng0);
    t2 = (t0 + 2688U);
    t3 = *((char **)t2);
    t19 = *((unsigned char *)t3);
    t2 = (t0 + 5776);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t18 = *((char **)t7);
    *((unsigned char *)t18) = t19;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(116, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4016U);
    t4 = (t0 + 3168U);
    t6 = *((char **)t4);
    t4 = (t6 + 0);
    ieee_p_3564397177_sub_1675032430035817134_91900896(IEEE_P_3564397177, t2, t3, t4);
    xsi_set_current_line(117, ng0);
    t2 = (t0 + 3168U);
    t3 = *((char **)t2);
    t19 = *((unsigned char *)t3);
    t2 = (t0 + 5840);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t18 = *((char **)t7);
    *((unsigned char *)t18) = t19;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(119, ng0);

LAB10:    t2 = (t0 + 5440);
    *((int *)t2) = 1;
    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB6:    t2 = (t0 + 10131);
    t8 = *((int *)t2);
    t3 = (t0 + 10135);
    t17 = *((int *)t3);
    if (t8 == t17)
        goto LAB7;

LAB12:    t22 = (t8 + 1);
    t8 = t22;
    t4 = (t0 + 10131);
    *((int *)t4) = t8;
    goto LAB4;

LAB8:    t4 = (t0 + 5440);
    *((int *)t4) = 0;
    xsi_set_current_line(122, ng0);
    t2 = (t0 + 2152U);
    t3 = *((char **)t2);
    t2 = (t0 + 3408U);
    t4 = *((char **)t2);
    t2 = (t4 + 0);
    memcpy(t2, t3, 16U);
    xsi_set_current_line(123, ng0);
    t2 = (t0 + 1992U);
    t3 = *((char **)t2);
    t2 = (t0 + 3288U);
    t4 = *((char **)t2);
    t2 = (t4 + 0);
    memcpy(t2, t3, 4U);
    xsi_set_current_line(124, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 2568U);
    t6 = *((char **)t4);
    memcpy(t5, t6, 16U);
    t4 = (t0 + 9744U);
    ieee_p_3564397177_sub_2258168291854845616_91900896(IEEE_P_3564397177, t2, t3, t5, t4, (unsigned char)0, 6);
    xsi_set_current_line(125, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 2928U);
    t6 = *((char **)t4);
    t19 = *((unsigned char *)t6);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t19, (unsigned char)0, 6);
    xsi_set_current_line(126, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 2808U);
    t6 = *((char **)t4);
    t19 = *((unsigned char *)t6);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t19, (unsigned char)0, 7);
    xsi_set_current_line(127, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 2688U);
    t6 = *((char **)t4);
    t19 = *((unsigned char *)t6);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t19, (unsigned char)0, 8);
    xsi_set_current_line(128, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 3168U);
    t6 = *((char **)t4);
    t19 = *((unsigned char *)t6);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t19, (unsigned char)0, 7);
    xsi_set_current_line(129, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 3288U);
    t6 = *((char **)t4);
    memcpy(t20, t6, 4U);
    t4 = (t0 + 9760U);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t20, t4, (unsigned char)0, 9);
    xsi_set_current_line(130, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 4088U);
    t4 = (t0 + 3408U);
    t6 = *((char **)t4);
    memcpy(t21, t6, 16U);
    t4 = (t0 + 9776U);
    ieee_p_3564397177_sub_2258168291854845616_91900896(IEEE_P_3564397177, t2, t3, t21, t4, (unsigned char)0, 8);
    xsi_set_current_line(131, ng0);
    t2 = (t0 + 4928);
    t3 = (t0 + 3736U);
    t4 = (t0 + 4088U);
    std_textio_writeline(STD_TEXTIO, t2, t3, t4);
    goto LAB6;

LAB9:    t3 = (t0 + 992U);
    t19 = ieee_p_2592010699_sub_2763492388968962707_503743352(IEEE_P_2592010699, t3, 0U, 0U);
    if (t19 == 1)
        goto LAB8;
    else
        goto LAB10;

LAB11:    goto LAB9;

LAB13:    goto LAB2;

LAB14:    goto LAB13;

LAB16:    goto LAB14;

}


extern void work_a_0731671936_2372691052_init()
{
	static char *pe[] = {(void *)work_a_0731671936_2372691052_p_0,(void *)work_a_0731671936_2372691052_p_1};
	xsi_register_didat("work_a_0731671936_2372691052", "isim/STACK_T_isim_beh.exe.sim/work/a_0731671936_2372691052.didat");
	xsi_register_executes(pe);
}
