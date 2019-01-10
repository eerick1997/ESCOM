
--  CYPRESS NOVA XVL Structural Architecture

--  JED2VHD Reverse Assembler - 6.3 IR 35


--    VHDL File: C.vhd

--    Date: Wed Oct 18 09:45:03 2017

--  Disassembly from Jedec file for: c22v10

--  Device Ordercode is: PALCE22V10-25PC/PI
library ieee;
use ieee.std_logic_1164.all;

library primitive;
use primitive.primitive.all;


-- Beginning Test Bench Header

ENTITY contdec IS
    PORT (
	                 clr :    in std_logic ;
	                 clk :    in std_logic ;
	             control :    in std_logic_vector (1 downto 0) ;
	                 ent :    in std_logic_vector (3 downto 0) ;
	             display : inout std_logic_vector (6 downto 0)
    );
END contdec;

-- End of Test Bench Header

ARCHITECTURE DSMB of contdec is

	signal jed_node1	: std_logic:='0' ; -- clk
	signal jed_node2	: std_logic:='0' ; -- clr
	signal jed_node3	: std_logic:='0' ; -- ent(3)
	signal jed_node4	: std_logic:='0' ; -- ent(2)
	signal jed_node5	: std_logic:='0' ; -- ent(1)
	signal jed_node6	: std_logic:='0' ; -- ent(0)
	signal jed_node7	: std_logic:='0' ; -- control(1)
	signal jed_node8	: std_logic:='0' ; -- control(0)
	signal jed_node9	: std_logic:='0' ;
	signal jed_node10	: std_logic:='0' ;
	signal jed_node11	: std_logic:='0' ;
	signal jed_node12	: std_logic:='0' ;
	signal jed_node13	: std_logic:='0' ;
	signal jed_node19	: std_logic:='0' ;
	signal jed_node20	: std_logic:='0' ;
	signal jed_node22	: std_logic:='0' ;
	signal jed_node24	: std_logic:='0' ;

	for all: c22v10m use entity primitive.c22v10m (sim);

SIGNAL  one:std_logic:='1';
SIGNAL  zero:std_logic:='0';
SIGNAL  jed_oept_1:std_logic:='0';
--Attribute PIN_NUMBERS of clk:SIGNAL is "0001";

SIGNAL  jed_oept_2:std_logic:='0';
--Attribute PIN_NUMBERS of clr:SIGNAL is "0002";

SIGNAL  jed_oept_3:std_logic:='0';
--Attribute PIN_NUMBERS of ent(3):SIGNAL is "0003";

SIGNAL  jed_oept_4:std_logic:='0';
--Attribute PIN_NUMBERS of ent(2):SIGNAL is "0004";

SIGNAL  jed_oept_5:std_logic:='0';
--Attribute PIN_NUMBERS of ent(1):SIGNAL is "0005";

SIGNAL  jed_oept_6:std_logic:='0';
--Attribute PIN_NUMBERS of ent(0):SIGNAL is "0006";

SIGNAL  jed_oept_7:std_logic:='0';
--Attribute PIN_NUMBERS of control(1):SIGNAL is "0007";

SIGNAL  jed_oept_8:std_logic:='0';
--Attribute PIN_NUMBERS of control(0):SIGNAL is "0008";

SIGNAL  jed_oept_14:std_logic:='0';
SIGNAL  jed_sum_14,jed_fb_14:std_logic:='0';
--Attribute PIN_NUMBERS of display(6):SIGNAL is "0014";

SIGNAL  jed_oept_15:std_logic:='0';
SIGNAL  jed_sum_15,jed_fb_15:std_logic:='0';
--Attribute PIN_NUMBERS of display(4):SIGNAL is "0015";

SIGNAL  jed_oept_16:std_logic:='0';
SIGNAL  jed_sum_16,jed_fb_16:std_logic:='0';
--Attribute PIN_NUMBERS of display(3):SIGNAL is "0016";

SIGNAL  jed_oept_17:std_logic:='0';
SIGNAL  jed_sum_17,jed_fb_17:std_logic:='0';
--Attribute PIN_NUMBERS of display(2):SIGNAL is "0017";

SIGNAL  jed_oept_18:std_logic:='0';
SIGNAL  jed_sum_18,jed_fb_18:std_logic:='0';
--Attribute PIN_NUMBERS of display(0):SIGNAL is "0018";

SIGNAL  jed_oept_21:std_logic:='0';
SIGNAL  jed_sum_21,jed_fb_21:std_logic:='0';
--Attribute PIN_NUMBERS of display(1):SIGNAL is "0021";

SIGNAL  jed_oept_23:std_logic:='0';
SIGNAL  jed_sum_23,jed_fb_23:std_logic:='0';
--Attribute PIN_NUMBERS of display(5):SIGNAL is "0023";

SIGNAL  jed_oept_25:std_logic:='0';
SIGNAL  jed_node25,jed_sum_25:std_logic:='0';
SIGNAL  jed_oept_26:std_logic:='0';
SIGNAL  jed_node26,jed_sum_26:std_logic:='0';

BEGIN
jed_node1 <= clk ;
jed_node2 <= clr ;
jed_node3 <= ent(3) ;
jed_node4 <= ent(2) ;
jed_node5 <= ent(1) ;
jed_node6 <= ent(0) ;
jed_node7 <= control(1) ;
jed_node8 <= control(0) ;
Mcell_14:c22v10m
generic map(reg,
   ninv,
   xreg,
   	25 ns, --tpd
	25 ns, --tea
	25 ns, --ter
	15 ns, --tco
	18 ns, --ts
	0 ns, --th
	14 ns, --twh
	14 ns, --twl
	13 ns, --tcf
	25 ns, --taw
	25 ns, --tar
	25 ns, --tap
	25 ns  --tspr
)
port map(
     d=>jed_sum_14,
     clk=>jed_node1,
     oe=>jed_oept_14,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>display(6),
     fb=>jed_fb_14
   );

Mcell_15:c22v10m
generic map(reg,
   ninv,
   xreg,
   	25 ns, --tpd
	25 ns, --tea
	25 ns, --ter
	15 ns, --tco
	18 ns, --ts
	0 ns, --th
	14 ns, --twh
	14 ns, --twl
	13 ns, --tcf
	25 ns, --taw
	25 ns, --tar
	25 ns, --tap
	25 ns  --tspr
)
port map(
     d=>jed_sum_15,
     clk=>jed_node1,
     oe=>jed_oept_15,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>display(4),
     fb=>jed_fb_15
   );

Mcell_16:c22v10m
generic map(reg,
   ninv,
   xreg,
   	25 ns, --tpd
	25 ns, --tea
	25 ns, --ter
	15 ns, --tco
	18 ns, --ts
	0 ns, --th
	14 ns, --twh
	14 ns, --twl
	13 ns, --tcf
	25 ns, --taw
	25 ns, --tar
	25 ns, --tap
	25 ns  --tspr
)
port map(
     d=>jed_sum_16,
     clk=>jed_node1,
     oe=>jed_oept_16,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>display(3),
     fb=>jed_fb_16
   );

Mcell_17:c22v10m
generic map(reg,
   ninv,
   xreg,
   	25 ns, --tpd
	25 ns, --tea
	25 ns, --ter
	15 ns, --tco
	18 ns, --ts
	0 ns, --th
	14 ns, --twh
	14 ns, --twl
	13 ns, --tcf
	25 ns, --taw
	25 ns, --tar
	25 ns, --tap
	25 ns  --tspr
)
port map(
     d=>jed_sum_17,
     clk=>jed_node1,
     oe=>jed_oept_17,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>display(2),
     fb=>jed_fb_17
   );

Mcell_18:c22v10m
generic map(reg,
   invt,
   xreg,
   	25 ns, --tpd
	25 ns, --tea
	25 ns, --ter
	15 ns, --tco
	18 ns, --ts
	0 ns, --th
	14 ns, --twh
	14 ns, --twl
	13 ns, --tcf
	25 ns, --taw
	25 ns, --tar
	25 ns, --tap
	25 ns  --tspr
)
port map(
     d=>jed_sum_18,
     clk=>jed_node1,
     oe=>jed_oept_18,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>display(0),
     fb=>jed_fb_18
   );

Mcell_21:c22v10m
generic map(reg,
   ninv,
   xreg,
   	25 ns, --tpd
	25 ns, --tea
	25 ns, --ter
	15 ns, --tco
	18 ns, --ts
	0 ns, --th
	14 ns, --twh
	14 ns, --twl
	13 ns, --tcf
	25 ns, --taw
	25 ns, --tar
	25 ns, --tap
	25 ns  --tspr
)
port map(
     d=>jed_sum_21,
     clk=>jed_node1,
     oe=>jed_oept_21,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>display(1),
     fb=>jed_fb_21
   );

Mcell_23:c22v10m
generic map(reg,
   ninv,
   xreg,
   	25 ns, --tpd
	25 ns, --tea
	25 ns, --ter
	15 ns, --tco
	18 ns, --ts
	0 ns, --th
	14 ns, --twh
	14 ns, --twl
	13 ns, --tcf
	25 ns, --taw
	25 ns, --tar
	25 ns, --tap
	25 ns  --tspr
)
port map(
     d=>jed_sum_23,
     clk=>jed_node1,
     oe=>jed_oept_23,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>display(5),
     fb=>jed_fb_23
   );

jed_node25<=jed_sum_25;
jed_node26<=jed_sum_26;
jed_oept_14<=(one);

jed_sum_14<= (((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and (not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and not(not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and (not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and (jed_fb_18)
 and not(jed_node7) and not(not(jed_fb_17)) and (jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(jed_node3) and (jed_node4) and not(jed_node5) and not(jed_node6)
 and (jed_node7) and (jed_node8)) or
(not(jed_node3) and not(jed_node4) and not(jed_node5)
 and (jed_node6) and (jed_node7) and (jed_node8)) or
(not(jed_node7) and not(jed_node8) and (not(jed_fb_14))
));

jed_oept_15<=(one);

jed_sum_15<= ((not(not(jed_fb_23)) and (not(jed_fb_21)) and (jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (jed_node8)
 and (not(jed_fb_16)) and not(not(jed_fb_15)) and (not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and (not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(jed_node3) and not(jed_node4) and (jed_node5) and not(jed_node6)
 and (jed_node7) and (jed_node8)) or
(not(jed_node7) and not(jed_node8) and (not(jed_fb_15))
));

jed_oept_16<=(one);

jed_sum_16<= (((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and (not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and not(not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and (not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_21)) and not(jed_fb_18) and not(jed_node7)
 and not(not(jed_fb_17)) and (jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and (jed_node7)
 and not(not(jed_fb_17)) and not(jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_node7)
 and not(not(jed_fb_17)) and (jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
((jed_node4) and (jed_node5) and (jed_node6) and (jed_node7)
 and (jed_node8)) or
((jed_node4) and not(jed_node5) and not(jed_node6) and (jed_node7)
 and (jed_node8)) or
(not(jed_node4) and not(jed_node5) and (jed_node6) and (jed_node7)
 and (jed_node8)) or
((jed_node3) and (jed_node4) and (jed_node7) and (jed_node8)
) or
((jed_node3) and (jed_node5) and (jed_node7) and (jed_node8)
) or
(not(jed_node7) and not(jed_node8) and (not(jed_fb_16))
));

jed_oept_17<=(one);

jed_sum_17<= ((not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and not(not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and (not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and not(not(jed_fb_17)) and (jed_node8)
 and not(not(jed_fb_16)) and (not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and (not(jed_fb_17)) and not(jed_node8) and (not(jed_fb_16))
 and not(not(jed_fb_15)) and (not(jed_fb_14))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (not(jed_fb_16))
 and not(not(jed_fb_15)) and (not(jed_fb_14))) or
((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and not(jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_21)) and not(jed_fb_18) and not(jed_node7)
 and not(not(jed_fb_17)) and (jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and (jed_node7)
 and not(not(jed_fb_17)) and not(jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_node7)
 and not(not(jed_fb_17)) and (jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
((jed_node3) and (jed_node5) and (jed_node7) and (jed_node8)
) or
((jed_node4) and not(jed_node5) and (jed_node7) and (jed_node8)
) or
((jed_node6) and (jed_node7) and (jed_node8)) or
(not(jed_node7) and (not(jed_fb_17)) and not(jed_node8)
));

jed_oept_18<=(one);

jed_sum_18<= ((not(not(jed_fb_23)) and (not(jed_fb_21)) and (jed_fb_18)
 and (jed_node7) and (not(jed_fb_17)) and not(jed_node8)
 and (not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and (jed_fb_18)
 and (jed_node7) and not(not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and (jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (jed_node8)
 and (not(jed_fb_16)) and not(not(jed_fb_15))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (not(jed_fb_16))
 and not(not(jed_fb_15)) and (not(jed_fb_14))) or
((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and not(not(jed_fb_17)) and not(not(jed_fb_16))
 and (not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and (not(jed_fb_17)) and not(jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and not(not(jed_fb_17)) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and (not(jed_fb_17)) and not(jed_node8) and (not(jed_fb_16))
 and not(not(jed_fb_15))) or
((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node8) and not(not(jed_fb_16)) and not(not(jed_fb_15))
 and not(not(jed_fb_14))) or
((jed_node4) and not(jed_node6) and (jed_node7) and (jed_node8)
) or
((jed_node4) and not(jed_node5) and (jed_node7) and (jed_node8)
) or
(not(jed_node4) and (jed_node5) and (jed_node7) and (jed_node8)
) or
((jed_node3) and (jed_node7) and (jed_node8)) or
(not(jed_fb_18) and not(jed_node7) and not(jed_node8)
));

jed_oept_21<=(one);

jed_sum_21<= ((not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and (not(jed_fb_17)) and not(jed_node8)
 and (not(jed_fb_16)) and not(not(jed_fb_15)) and (not(jed_fb_14))
) or
((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and not(not(jed_fb_17)) and (jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and (jed_fb_18)
 and not(jed_node7) and not(not(jed_fb_17)) and (jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and (jed_node7) and not(not(jed_fb_17)) and not(jed_node8)
 and not(not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and (jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (not(jed_fb_16))
 and not(not(jed_fb_15)) and (not(jed_fb_14))) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(not(jed_fb_17)) and not(jed_node8) and not(not(jed_fb_16))
 and (not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and not(not(jed_fb_17)) and not(not(jed_fb_16))
 and (not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and not(jed_fb_18)
 and (not(jed_fb_17)) and not(jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(jed_node3) and (jed_node5) and (jed_node6) and (jed_node7)
 and (jed_node8)) or
(not(jed_node3) and not(jed_node4) and (jed_node5) and (jed_node7)
 and (jed_node8)) or
(not(jed_node3) and not(jed_node4) and (jed_node6) and (jed_node7)
 and (jed_node8)) or
((not(jed_fb_21)) and not(jed_node7) and not(jed_node8)
));

jed_oept_23<=(one);

jed_sum_23<= ((not(not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and (jed_node8)
 and (not(jed_fb_16)) and not(not(jed_fb_15)) and (not(jed_fb_14))
) or
(not(not(jed_fb_23)) and (not(jed_fb_21)) and (jed_fb_18)
 and (jed_node7) and (not(jed_fb_17)) and not(jed_node8)
 and (not(jed_fb_16)) and not(not(jed_fb_15)) and not(not(jed_fb_14))
) or
((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(jed_node7) and (not(jed_fb_17)) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
((not(jed_fb_23)) and not(not(jed_fb_21)) and not(jed_fb_18)
 and not(not(jed_fb_17)) and not(jed_node8) and not(not(jed_fb_16))
 and not(not(jed_fb_15)) and not(not(jed_fb_14))) or
(not(jed_node3) and (jed_node4) and (jed_node5) and not(jed_node6)
 and (jed_node7) and (jed_node8)) or
(not(jed_node3) and (jed_node4) and not(jed_node5) and (jed_node6)
 and (jed_node7) and (jed_node8)) or
((not(jed_fb_23)) and not(jed_node7) and not(jed_node8)
));

jed_sum_25<= ((not(jed_node2)));

end DSMB;
