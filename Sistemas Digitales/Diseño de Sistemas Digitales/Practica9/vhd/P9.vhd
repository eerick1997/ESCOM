
--  CYPRESS NOVA XVL Structural Architecture

--  JED2VHD Reverse Assembler - 6.3 IR 35


--    VHDL File: P9.vhd

--    Date: Sun Dec 10 14:59:01 2017

--  Disassembly from Jedec file for: c22v10

--  Device Ordercode is: PALCE22V10-25PC/PI
library ieee;
use ieee.std_logic_1164.all;

library primitive;
use primitive.primitive.all;


-- Beginning Test Bench Header

ENTITY regu IS
    PORT (
	                 clk :    in std_logic ;
	                 clr :    in std_logic ;
	                   a :    in std_logic ;
	                   b :    in std_logic ;
	             control :    in std_logic ;
	                cout : inout std_logic ;
	                  s0 : inout std_logic ;
	                  s1 : inout std_logic ;
	                  s2 : inout std_logic ;
	                  s3 : inout std_logic ;
	                  s4 : inout std_logic
    );
END regu;

-- End of Test Bench Header

ARCHITECTURE DSMB of regu is

	signal jed_node1	: std_logic:='0' ; -- clk
	signal jed_node2	: std_logic:='0' ; -- b
	signal jed_node3	: std_logic:='0' ; -- a
	signal jed_node4	: std_logic:='0' ; -- control
	signal jed_node5	: std_logic:='0' ; -- clr
	signal jed_node6	: std_logic:='0' ;
	signal jed_node7	: std_logic:='0' ;
	signal jed_node8	: std_logic:='0' ;
	signal jed_node9	: std_logic:='0' ;
	signal jed_node10	: std_logic:='0' ;
	signal jed_node11	: std_logic:='0' ;
	signal jed_node12	: std_logic:='0' ;
	signal jed_node13	: std_logic:='0' ;
	signal jed_node17	: std_logic:='0' ;
	signal jed_node18	: std_logic:='0' ;
	signal jed_node19	: std_logic:='0' ;
	signal jed_node20	: std_logic:='0' ;
	signal jed_node24	: std_logic:='0' ;

	for all: c22v10m use entity primitive.c22v10m (sim);

SIGNAL  one:std_logic:='1';
SIGNAL  zero:std_logic:='0';
SIGNAL  jed_oept_1:std_logic:='0';
--Attribute PIN_NUMBERS of clk:SIGNAL is "0001";

SIGNAL  jed_oept_2:std_logic:='0';
--Attribute PIN_NUMBERS of b:SIGNAL is "0002";

SIGNAL  jed_oept_3:std_logic:='0';
--Attribute PIN_NUMBERS of a:SIGNAL is "0003";

SIGNAL  jed_oept_4:std_logic:='0';
--Attribute PIN_NUMBERS of control:SIGNAL is "0004";

SIGNAL  jed_oept_5:std_logic:='0';
--Attribute PIN_NUMBERS of clr:SIGNAL is "0005";

SIGNAL  jed_oept_14:std_logic:='0';
SIGNAL  jed_sum_14,jed_fb_14:std_logic:='0';
--Attribute PIN_NUMBERS of s4:SIGNAL is "0014";

SIGNAL  jed_oept_15:std_logic:='0';
SIGNAL  jed_sum_15,jed_fb_15:std_logic:='0';
--Attribute PIN_NUMBERS of s2:SIGNAL is "0015";

SIGNAL  jed_oept_16:std_logic:='0';
SIGNAL  jed_sum_16,jed_fb_16:std_logic:='0';
--Attribute PIN_NUMBERS of cout:SIGNAL is "0016";

SIGNAL  jed_oept_17:std_logic:='0';
SIGNAL cont_1:std_logic:='0';
SIGNAL  jed_sum_17,jed_fb_17:std_logic:='0';
--Attribute PIN_NUMBERS of jed_node17:SIGNAL is "0017";

SIGNAL  jed_oept_18:std_logic:='0';
SIGNAL cont_2:std_logic:='0';
SIGNAL  jed_sum_18,jed_fb_18:std_logic:='0';
--Attribute PIN_NUMBERS of jed_node18:SIGNAL is "0018";

SIGNAL  jed_oept_20:std_logic:='0';
SIGNAL cont_0:std_logic:='0';
SIGNAL  jed_sum_20,jed_fb_20:std_logic:='0';
--Attribute PIN_NUMBERS of jed_node20:SIGNAL is "0020";

SIGNAL  jed_oept_21:std_logic:='0';
SIGNAL  jed_sum_21,jed_fb_21:std_logic:='0';
--Attribute PIN_NUMBERS of s0:SIGNAL is "0021";

SIGNAL  jed_oept_22:std_logic:='0';
SIGNAL  jed_sum_22,jed_fb_22:std_logic:='0';
--Attribute PIN_NUMBERS of s1:SIGNAL is "0022";

SIGNAL  jed_oept_23:std_logic:='0';
SIGNAL  jed_sum_23,jed_fb_23:std_logic:='0';
--Attribute PIN_NUMBERS of s3:SIGNAL is "0023";

SIGNAL  jed_oept_25:std_logic:='0';
SIGNAL  jed_node25,jed_sum_25:std_logic:='0';
SIGNAL  jed_oept_26:std_logic:='0';
SIGNAL  jed_node26,jed_sum_26:std_logic:='0';

BEGIN
jed_node1 <= clk ;
jed_node2 <= b ;
jed_node3 <= a ;
jed_node4 <= control ;
jed_node5 <= clr ;
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
     y=>s4,
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
     y=>s2,
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
     y=>cout,
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
     y=>jed_node17,
     fb=>jed_fb_17
   );

Mcell_18:c22v10m
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
     d=>jed_sum_18,
     clk=>jed_node1,
     oe=>jed_oept_18,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>jed_node18,
     fb=>jed_fb_18
   );

Mcell_20:c22v10m
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
     d=>jed_sum_20,
     clk=>jed_node1,
     oe=>jed_oept_20,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>jed_node20,
     fb=>jed_fb_20
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
     y=>s0,
     fb=>jed_fb_21
   );

Mcell_22:c22v10m
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
     d=>jed_sum_22,
     clk=>jed_node1,
     oe=>jed_oept_22,
     ss=>jed_sum_26,
     ar=>jed_sum_25,
     y=>s1,
     fb=>jed_fb_22
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
     y=>s3,
     fb=>jed_fb_23
   );

cont_1 <= jed_fb_17;
cont_2 <= jed_fb_18;
cont_0 <= jed_fb_20;
jed_node25<=jed_sum_25;
jed_node26<=jed_sum_26;
jed_oept_14<=(one);

jed_sum_14<= (((jed_node2) and (jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and (not(jed_fb_18)) and not(not(jed_fb_17)) and (not(jed_fb_16))
) or
(not(jed_node2) and not(jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and (not(jed_fb_18)) and not(not(jed_fb_17)) and (not(jed_fb_16))
) or
((jed_node2) and not(jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and (not(jed_fb_18)) and not(not(jed_fb_17)) and not(not(jed_fb_16))
) or
(not(jed_node2) and (jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and (not(jed_fb_18)) and not(not(jed_fb_17)) and not(not(jed_fb_16))
) or
((not(jed_fb_17)) and (not(jed_fb_14))) or
((not(jed_fb_20)) and (not(jed_fb_14))) or
(not(not(jed_fb_18)) and (not(jed_fb_14))) or
(not(jed_node4) and (not(jed_fb_14))));

jed_oept_15<=(one);

jed_sum_15<= (((jed_node2) and (jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and (not(jed_fb_16))
) or
(not(jed_node2) and not(jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and (not(jed_fb_16))
) or
((jed_node2) and not(jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and not(not(jed_fb_16))
) or
(not(jed_node2) and (jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and not(not(jed_fb_16))
) or
((not(jed_fb_18)) and (not(jed_fb_15))) or
((not(jed_fb_20)) and (not(jed_fb_15))) or
(not(not(jed_fb_17)) and (not(jed_fb_15))) or
(not(jed_node4) and (not(jed_fb_15))));

jed_oept_16<=(one);

jed_sum_16<= (((jed_node2) and (jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and not(not(jed_fb_17))) or
((jed_node2) and (jed_node3) and (jed_node4) and not(not(jed_fb_18))
) or
((not(jed_fb_18)) and (not(jed_fb_17)) and (not(jed_fb_16))
) or
((not(jed_fb_20)) and (not(jed_fb_18)) and (not(jed_fb_16))
) or
((jed_node2) and (not(jed_fb_16))) or
((jed_node3) and (not(jed_fb_16))) or
(not(jed_node4) and (not(jed_fb_16))));

jed_sum_17<= (((jed_node4) and (not(jed_fb_20)) and not(not(jed_fb_18))
 and not(not(jed_fb_17))) or
((not(jed_fb_18)) and (not(jed_fb_17))) or
(not(not(jed_fb_20)) and (not(jed_fb_17))) or
(not(jed_node4) and (not(jed_fb_17))));

jed_sum_18<= (((jed_node4) and (not(jed_fb_20)) and (not(jed_fb_17))
) or
((not(jed_fb_18))));

jed_sum_20<= (((jed_node4) and (not(jed_fb_18)) and not(not(jed_fb_17))
) or
((jed_node4) and not(not(jed_fb_20)) and not(not(jed_fb_18))
) or
((not(jed_fb_20)) and (not(jed_fb_18))) or
(not(jed_node4) and (not(jed_fb_20))));

jed_oept_21<=(one);

jed_sum_21<= (((jed_node2) and not(jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and not(not(jed_fb_18)) and not(not(jed_fb_17))) or
(not(jed_node2) and (jed_node3) and (jed_node4) and not(not(jed_fb_20))
 and not(not(jed_fb_18)) and not(not(jed_fb_17))) or
((not(jed_fb_21)) and (not(jed_fb_18))) or
((not(jed_fb_21)) and (not(jed_fb_17))) or
((not(jed_fb_21)) and (not(jed_fb_20))) or
((not(jed_fb_21)) and not(jed_node4)));

jed_oept_22<=(one);

jed_sum_22<= (((jed_node2) and (jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and not(not(jed_fb_17)) and (not(jed_fb_16))
) or
(not(jed_node2) and not(jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and not(not(jed_fb_17)) and (not(jed_fb_16))
) or
((jed_node2) and not(jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and not(not(jed_fb_17)) and not(not(jed_fb_16))
) or
(not(jed_node2) and (jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and not(not(jed_fb_17)) and not(not(jed_fb_16))
) or
((not(jed_fb_22)) and (not(jed_fb_18))) or
((not(jed_fb_22)) and (not(jed_fb_17))) or
((not(jed_fb_22)) and not(not(jed_fb_20))) or
((not(jed_fb_22)) and not(jed_node4)));

jed_oept_23<=(one);

jed_sum_23<= (((jed_node2) and (jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and (not(jed_fb_16))
) or
(not(jed_node2) and not(jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and (not(jed_fb_16))
) or
((jed_node2) and not(jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and not(not(jed_fb_16))
) or
(not(jed_node2) and (jed_node3) and (jed_node4) and (not(jed_fb_20))
 and not(not(jed_fb_18)) and (not(jed_fb_17)) and not(not(jed_fb_16))
) or
((not(jed_fb_23)) and (not(jed_fb_18))) or
((not(jed_fb_23)) and not(not(jed_fb_20))) or
((not(jed_fb_23)) and not(not(jed_fb_17))) or
((not(jed_fb_23)) and not(jed_node4)));

jed_sum_25<= ((not(jed_node5)));

end DSMB;
