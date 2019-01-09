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
static const char *ng0 = "/home/erick/Documentos/GitHub/Computer-architecture/ESCOMIPS/UCONTROL/TestBench_UCONTROL.vhd";
extern char *STD_TEXTIO;
extern char *IEEE_P_3564397177;
extern char *IEEE_P_2592010699;

unsigned char ieee_p_2592010699_sub_13554554585326073636_503743352(char *, char *, unsigned int , unsigned int );
unsigned char ieee_p_2592010699_sub_2763492388968962707_503743352(char *, char *, unsigned int , unsigned int );
void ieee_p_3564397177_sub_1675032430035817134_91900896(char *, char *, char *, char *);
void ieee_p_3564397177_sub_2250825304603680424_91900896(char *, char *, char *, char *, char *, unsigned char , int );
void ieee_p_3564397177_sub_2518136782373626985_91900896(char *, char *, char *, unsigned char , unsigned char , int );
void ieee_p_3564397177_sub_2863756418437601506_91900896(char *, char *, char *, char *, char *);


static void work_a_3717668923_2372691052_p_0(char *t0)
{
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t5;
    char *t6;
    int64 t7;
    int64 t8;

LAB0:    t1 = (t0 + 4472U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(58, ng0);
    t2 = (t0 + 5136);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)2;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(59, ng0);
    t2 = (t0 + 2288U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 4280);
    xsi_process_wait(t2, t8);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(60, ng0);
    t2 = (t0 + 5136);
    t3 = (t2 + 56U);
    t4 = *((char **)t3);
    t5 = (t4 + 56U);
    t6 = *((char **)t5);
    *((unsigned char *)t6) = (unsigned char)3;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(61, ng0);
    t2 = (t0 + 2288U);
    t3 = *((char **)t2);
    t7 = *((int64 *)t3);
    t8 = (t7 / 2);
    t2 = (t0 + 4280);
    xsi_process_wait(t2, t8);

LAB10:    *((char **)t1) = &&LAB11;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB8:    goto LAB2;

LAB9:    goto LAB8;

LAB11:    goto LAB9;

}

static void work_a_3717668923_2372691052_p_1(char *t0)
{
    char t5[16];
    char t11[8];
    char t12[8];
    char t13[8];
    char t14[8];
    char t15[8];
    char t16[8];
    char t17[8];
    char t21[8];
    char t23[8];
    char t24[8];
    char t25[24];
    char t26[8];
    char t27[8];
    char t28[8];
    char t29[8];
    char t30[24];
    char t31[8];
    char *t1;
    char *t2;
    char *t3;
    char *t4;
    char *t6;
    char *t7;
    int t8;
    unsigned int t9;
    int64 t10;
    int t18;
    char *t19;
    unsigned char t20;
    int t22;

LAB0:    t1 = (t0 + 4720U);
    t2 = *((char **)t1);
    if (t2 == 0)
        goto LAB2;

LAB3:    goto *t2;

LAB2:    xsi_set_current_line(81, ng0);
    t2 = (t0 + 3440U);
    t3 = (t0 + 9775);
    t6 = (t5 + 0U);
    t7 = (t6 + 0U);
    *((int *)t7) = 1;
    t7 = (t6 + 4U);
    *((int *)t7) = 11;
    t7 = (t6 + 8U);
    *((int *)t7) = 1;
    t8 = (11 - 1);
    t9 = (t8 * 1);
    t9 = (t9 + 1);
    t7 = (t6 + 12U);
    *((unsigned int *)t7) = t9;
    std_textio_file_open1(t2, t3, t5, (unsigned char)0);
    xsi_set_current_line(82, ng0);
    t2 = (t0 + 3336U);
    t3 = (t0 + 9786);
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
    xsi_set_current_line(84, ng0);
    t10 = (100 * 1000LL);
    t2 = (t0 + 4528);
    xsi_process_wait(t2, t10);

LAB6:    *((char **)t1) = &&LAB7;

LAB1:    return;
LAB4:    xsi_set_current_line(85, ng0);
    t2 = (t0 + 9799);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(86, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t11, t7, 8U);
    t6 = (t0 + 9512U);
    t8 = (8U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t11, t6, (unsigned char)0, t8);
    xsi_set_current_line(87, ng0);
    t2 = (t0 + 9807);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(88, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t12, t7, 8U);
    t6 = (t0 + 9512U);
    t8 = (8U + 2);
    std_textio_write7(STD_TEXTIO, t2, t3, t12, t6, (unsigned char)0, t8);
    xsi_set_current_line(89, ng0);
    t2 = (t0 + 9815);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(90, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t13, t7, 8U);
    t6 = (t0 + 9512U);
    t8 = (8U + 3);
    std_textio_write7(STD_TEXTIO, t2, t3, t13, t6, (unsigned char)0, t8);
    xsi_set_current_line(91, ng0);
    t2 = (t0 + 9823);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(92, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t14, t7, 8U);
    t6 = (t0 + 9512U);
    std_textio_write7(STD_TEXTIO, t2, t3, t14, t6, (unsigned char)0, 8);
    xsi_set_current_line(93, ng0);
    t2 = (t0 + 9831);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(94, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t15, t7, 8U);
    t6 = (t0 + 9512U);
    std_textio_write7(STD_TEXTIO, t2, t3, t15, t6, (unsigned char)0, 8);
    xsi_set_current_line(95, ng0);
    t2 = (t0 + 9839);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(96, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t16, t7, 8U);
    t6 = (t0 + 9512U);
    t8 = (8U + 4);
    std_textio_write7(STD_TEXTIO, t2, t3, t16, t6, (unsigned char)0, t8);
    xsi_set_current_line(97, ng0);
    t2 = (t0 + 9847);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(98, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t17, t7, 8U);
    t6 = (t0 + 9512U);
    t8 = (8U + 10);
    std_textio_write7(STD_TEXTIO, t2, t3, t17, t6, (unsigned char)0, t8);
    xsi_set_current_line(100, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3336U);
    t4 = (t0 + 3616U);
    std_textio_writeline(STD_TEXTIO, t2, t3, t4);
    xsi_set_current_line(102, ng0);
    t2 = (t0 + 9855);
    *((int *)t2) = 0;
    t3 = (t0 + 9859);
    *((int *)t3) = 51;
    t8 = 0;
    t18 = 51;

LAB8:    if (t8 <= t18)
        goto LAB9;

LAB11:    xsi_set_current_line(149, ng0);
    t2 = (t0 + 3440U);
    std_textio_file_close(t2);
    xsi_set_current_line(150, ng0);
    t2 = (t0 + 3336U);
    std_textio_file_close(t2);
    xsi_set_current_line(152, ng0);

LAB23:    *((char **)t1) = &&LAB24;
    goto LAB1;

LAB5:    goto LAB4;

LAB7:    goto LAB5;

LAB9:    xsi_set_current_line(103, ng0);
    t4 = (t0 + 4528);
    t6 = (t0 + 3440U);
    t7 = (t0 + 3688U);
    std_textio_readline(STD_TEXTIO, t4, t6, t7);
    xsi_set_current_line(105, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3688U);
    t4 = (t0 + 2528U);
    t6 = *((char **)t4);
    t4 = (t0 + 9464U);
    ieee_p_3564397177_sub_2863756418437601506_91900896(IEEE_P_3564397177, t2, t3, t6, t4);
    xsi_set_current_line(106, ng0);
    t2 = (t0 + 2528U);
    t3 = *((char **)t2);
    t2 = (t0 + 5200);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t19 = *((char **)t7);
    memcpy(t19, t3, 5U);
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(108, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3688U);
    t4 = (t0 + 2648U);
    t6 = *((char **)t4);
    t4 = (t0 + 9480U);
    ieee_p_3564397177_sub_2863756418437601506_91900896(IEEE_P_3564397177, t2, t3, t6, t4);
    xsi_set_current_line(109, ng0);
    t2 = (t0 + 2648U);
    t3 = *((char **)t2);
    t2 = (t0 + 5264);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t19 = *((char **)t7);
    memcpy(t19, t3, 4U);
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(111, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3688U);
    t4 = (t0 + 2768U);
    t6 = *((char **)t4);
    t4 = (t0 + 9496U);
    ieee_p_3564397177_sub_2863756418437601506_91900896(IEEE_P_3564397177, t2, t3, t6, t4);
    xsi_set_current_line(112, ng0);
    t2 = (t0 + 2768U);
    t3 = *((char **)t2);
    t2 = (t0 + 5328);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t19 = *((char **)t7);
    memcpy(t19, t3, 4U);
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(114, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3688U);
    t4 = (t0 + 2888U);
    t6 = *((char **)t4);
    t4 = (t6 + 0);
    ieee_p_3564397177_sub_1675032430035817134_91900896(IEEE_P_3564397177, t2, t3, t4);
    xsi_set_current_line(115, ng0);
    t2 = (t0 + 2888U);
    t3 = *((char **)t2);
    t20 = *((unsigned char *)t3);
    t2 = (t0 + 5392);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t19 = *((char **)t7);
    *((unsigned char *)t19) = t20;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(117, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3688U);
    t4 = (t0 + 3008U);
    t6 = *((char **)t4);
    t4 = (t6 + 0);
    ieee_p_3564397177_sub_1675032430035817134_91900896(IEEE_P_3564397177, t2, t3, t4);
    xsi_set_current_line(118, ng0);
    t2 = (t0 + 3008U);
    t3 = *((char **)t2);
    t20 = *((unsigned char *)t3);
    t2 = (t0 + 5456);
    t4 = (t2 + 56U);
    t6 = *((char **)t4);
    t7 = (t6 + 56U);
    t19 = *((char **)t7);
    *((unsigned char *)t19) = t20;
    xsi_driver_first_trans_fast(t2);
    xsi_set_current_line(120, ng0);

LAB14:    t2 = (t0 + 5040);
    *((int *)t2) = 1;
    *((char **)t1) = &&LAB15;
    goto LAB1;

LAB10:    t2 = (t0 + 9855);
    t8 = *((int *)t2);
    t3 = (t0 + 9859);
    t18 = *((int *)t3);
    if (t8 == t18)
        goto LAB11;

LAB20:    t22 = (t8 + 1);
    t8 = t22;
    t4 = (t0 + 9855);
    *((int *)t4) = t8;
    goto LAB8;

LAB12:    t4 = (t0 + 5040);
    *((int *)t4) = 0;
    xsi_set_current_line(121, ng0);
    t2 = (t0 + 1992U);
    t3 = *((char **)t2);
    t2 = (t0 + 2408U);
    t4 = *((char **)t2);
    t2 = (t4 + 0);
    memcpy(t2, t3, 20U);
    xsi_set_current_line(123, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2528U);
    t6 = *((char **)t4);
    memcpy(t21, t6, 5U);
    t4 = (t0 + 9464U);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t21, t4, (unsigned char)0, t22);
    xsi_set_current_line(124, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2648U);
    t6 = *((char **)t4);
    memcpy(t23, t6, 4U);
    t4 = (t0 + 9480U);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t23, t4, (unsigned char)0, t22);
    xsi_set_current_line(125, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2768U);
    t6 = *((char **)t4);
    memcpy(t24, t6, 4U);
    t4 = (t0 + 9496U);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t24, t4, (unsigned char)0, t22);
    xsi_set_current_line(126, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2888U);
    t6 = *((char **)t4);
    t20 = *((unsigned char *)t6);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t20, (unsigned char)0, t22);
    xsi_set_current_line(127, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3008U);
    t6 = *((char **)t4);
    t20 = *((unsigned char *)t6);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t20, (unsigned char)0, 8);
    xsi_set_current_line(128, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2408U);
    t6 = *((char **)t4);
    memcpy(t25, t6, 20U);
    t4 = (t0 + 9448U);
    t22 = (8U + 15);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t25, t4, (unsigned char)0, t22);
    xsi_set_current_line(130, ng0);
    t2 = (t0 + 9863);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(131, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t26, t7, 8U);
    t6 = (t0 + 9512U);
    t22 = (8U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t26, t6, (unsigned char)0, t22);
    xsi_set_current_line(132, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3336U);
    t4 = (t0 + 3616U);
    std_textio_writeline(STD_TEXTIO, t2, t3, t4);
    xsi_set_current_line(134, ng0);

LAB18:    t2 = (t0 + 5056);
    *((int *)t2) = 1;
    *((char **)t1) = &&LAB19;
    goto LAB1;

LAB13:    t3 = (t0 + 1312U);
    t20 = ieee_p_2592010699_sub_13554554585326073636_503743352(IEEE_P_2592010699, t3, 0U, 0U);
    if (t20 == 1)
        goto LAB12;
    else
        goto LAB14;

LAB15:    goto LAB13;

LAB16:    t4 = (t0 + 5056);
    *((int *)t4) = 0;
    xsi_set_current_line(135, ng0);
    t2 = (t0 + 1992U);
    t3 = *((char **)t2);
    t2 = (t0 + 2408U);
    t4 = *((char **)t2);
    t2 = (t4 + 0);
    memcpy(t2, t3, 20U);
    xsi_set_current_line(137, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2528U);
    t6 = *((char **)t4);
    memcpy(t27, t6, 5U);
    t4 = (t0 + 9464U);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t27, t4, (unsigned char)0, t22);
    xsi_set_current_line(138, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2648U);
    t6 = *((char **)t4);
    memcpy(t28, t6, 4U);
    t4 = (t0 + 9480U);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t28, t4, (unsigned char)0, t22);
    xsi_set_current_line(139, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2768U);
    t6 = *((char **)t4);
    memcpy(t29, t6, 4U);
    t4 = (t0 + 9496U);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t29, t4, (unsigned char)0, t22);
    xsi_set_current_line(140, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2888U);
    t6 = *((char **)t4);
    t20 = *((unsigned char *)t6);
    t22 = (8U + 1);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t20, (unsigned char)0, t22);
    xsi_set_current_line(141, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3008U);
    t6 = *((char **)t4);
    t20 = *((unsigned char *)t6);
    ieee_p_3564397177_sub_2518136782373626985_91900896(IEEE_P_3564397177, t2, t3, t20, (unsigned char)0, 8);
    xsi_set_current_line(142, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 2408U);
    t6 = *((char **)t4);
    memcpy(t30, t6, 20U);
    t4 = (t0 + 9448U);
    t22 = (8U + 15);
    ieee_p_3564397177_sub_2250825304603680424_91900896(IEEE_P_3564397177, t2, t3, t30, t4, (unsigned char)0, t22);
    xsi_set_current_line(144, ng0);
    t2 = (t0 + 9871);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    t6 = (t7 + 0);
    memcpy(t6, t2, 8U);
    xsi_set_current_line(145, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3616U);
    t4 = (t0 + 3896U);
    t6 = (t4 + 56U);
    t7 = *((char **)t6);
    memcpy(t31, t7, 8U);
    t6 = (t0 + 9512U);
    t22 = (8U + 1);
    std_textio_write7(STD_TEXTIO, t2, t3, t31, t6, (unsigned char)0, t22);
    xsi_set_current_line(146, ng0);
    t2 = (t0 + 4528);
    t3 = (t0 + 3336U);
    t4 = (t0 + 3616U);
    std_textio_writeline(STD_TEXTIO, t2, t3, t4);
    goto LAB10;

LAB17:    t3 = (t0 + 1312U);
    t20 = ieee_p_2592010699_sub_2763492388968962707_503743352(IEEE_P_2592010699, t3, 0U, 0U);
    if (t20 == 1)
        goto LAB16;
    else
        goto LAB18;

LAB19:    goto LAB17;

LAB21:    goto LAB2;

LAB22:    goto LAB21;

LAB24:    goto LAB22;

}


extern void work_a_3717668923_2372691052_init()
{
	static char *pe[] = {(void *)work_a_3717668923_2372691052_p_0,(void *)work_a_3717668923_2372691052_p_1};
	xsi_register_didat("work_a_3717668923_2372691052", "isim/TestBench_control_isim_translate.exe.sim/work/a_3717668923_2372691052.didat");
	xsi_register_executes(pe);
}
