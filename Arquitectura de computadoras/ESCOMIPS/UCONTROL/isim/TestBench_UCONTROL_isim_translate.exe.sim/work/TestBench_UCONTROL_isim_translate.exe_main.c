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

#include "xsi.h"

struct XSI_INFO xsi_info;

char *IEEE_P_2592010699;
char *STD_STANDARD;
char *IEEE_P_3620187407;
char *IEEE_P_3499444699;
char *STD_TEXTIO;
char *IEEE_P_3564397177;
char *VL_P_2533777724;


int main(int argc, char **argv)
{
    xsi_init_design(argc, argv);
    xsi_register_info(&xsi_info);

    xsi_register_min_prec_unit(-12);
    work_m_16541823861846354283_2073120511_init();
    simprims_ver_u_12786726827258733405_1131516744_init();
    simprims_ver_m_09253638010417583746_3752318385_init();
    simprims_ver_u_09260761047239827718_3351940313_init();
    simprims_ver_m_03252886117992735132_3745003551_init();
    simprims_ver_m_03252886117992735132_1529224445_init();
    simprims_ver_m_14322894815338266048_2072126948_init();
    simprims_ver_m_14322894815338266048_3753097336_init();
    simprims_ver_m_14322894815338266048_0432188092_init();
    simprims_ver_m_14322894815338266048_2610324868_init();
    simprims_ver_m_14322894815338266048_1395513069_init();
    simprims_ver_m_14322894815338266048_1632927386_init();
    simprims_ver_m_14322894815338266048_1904157701_init();
    simprims_ver_m_14322894815338266048_2902249099_init();
    simprims_ver_m_14322894815338266048_0389428012_init();
    simprims_ver_m_14322894815338266048_0998770580_init();
    simprims_ver_m_14322894815338266048_4181056881_init();
    simprims_ver_m_14322894815338266048_1666335679_init();
    simprims_ver_m_14322894815338266048_3983764436_init();
    simprims_ver_m_14322894815338266048_0486607370_init();
    simprims_ver_m_14322894815338266048_3648316791_init();
    simprims_ver_m_14322894815338266048_2393197633_init();
    simprims_ver_m_14322894815338266048_0137969525_init();
    simprims_ver_m_14322894815338266048_1366613717_init();
    simprims_ver_m_14322894815338266048_3029487635_init();
    simprims_ver_m_14322894815338266048_1413458643_init();
    simprims_ver_m_14322894815338266048_3696402794_init();
    simprims_ver_m_14322894815338266048_0345464880_init();
    simprims_ver_m_07469524036140029493_1734229923_init();
    simprims_ver_m_07469524036140029493_3577986652_init();
    simprims_ver_m_07469524036140029493_0791863495_init();
    simprims_ver_m_07469524036140029493_3535806149_init();
    simprims_ver_m_07469524036140029493_1947321957_init();
    simprims_ver_m_07469524036140029493_4263921780_init();
    simprims_ver_m_07469524036140029493_4058942750_init();
    simprims_ver_m_07469524036140029493_0054788661_init();
    simprims_ver_m_07469524036140029493_1270669399_init();
    simprims_ver_m_07469524036140029493_2867886613_init();
    simprims_ver_m_05548409876658398341_2650073369_init();
    simprims_ver_m_05548409876658398341_1433350400_init();
    simprims_ver_m_05548409876658398341_2378907658_init();
    simprims_ver_m_05548409876658398341_1337134077_init();
    simprims_ver_m_05548409876658398341_1548387469_init();
    simprims_ver_m_05548409876658398341_3430773391_init();
    simprims_ver_m_05548409876658398341_4158684129_init();
    simprims_ver_m_00358400182994406296_2021654676_init();
    simprims_ver_u_13644963114211519797_1323274903_init();
    simprims_ver_m_09053309457855292502_0897309690_init();
    simprims_ver_m_00358400182994406296_3226743947_init();
    simprims_ver_m_02253721222203995675_2662658903_init();
    simprims_ver_m_12318166303807365835_3151998091_init();
    simprims_ver_m_00358400182994406296_1349438147_init();
    simprims_ver_m_04567189716726560339_1692233196_init();
    simprims_ver_m_06621322055533463077_0818475687_init();
    simprims_ver_m_06621322055533463077_1080494567_init();
    work_m_05238863870657269735_0784871489_init();
    ieee_p_2592010699_init();
    ieee_p_3499444699_init();
    ieee_p_3620187407_init();
    std_textio_init();
    ieee_p_3564397177_init();
    vl_p_2533777724_init();
    work_a_2576661623_2372691052_init();


    xsi_register_tops("work_a_2576661623_2372691052");
    xsi_register_tops("work_m_16541823861846354283_2073120511");

    IEEE_P_2592010699 = xsi_get_engine_memory("ieee_p_2592010699");
    xsi_register_ieee_std_logic_1164(IEEE_P_2592010699);
    STD_STANDARD = xsi_get_engine_memory("std_standard");
    IEEE_P_3620187407 = xsi_get_engine_memory("ieee_p_3620187407");
    IEEE_P_3499444699 = xsi_get_engine_memory("ieee_p_3499444699");
    STD_TEXTIO = xsi_get_engine_memory("std_textio");
    IEEE_P_3564397177 = xsi_get_engine_memory("ieee_p_3564397177");
    VL_P_2533777724 = xsi_get_engine_memory("vl_p_2533777724");

    return xsi_run_simulation(argc, argv);

}
