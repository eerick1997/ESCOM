
--  CYPRESS NOVA XVL Structural Architecture

--  JED2VHD Reverse Assembler - 6.3 IR 35


--    VHDL File: Suma.vhd

--    Date: Sun Nov 26 11:29:08 2017

--  Disassembly from Jedec file for: c22v10

--  Device Ordercode is: PALCE22V10-25PC/PI
library ieee;
use ieee.std_logic_1164.all;

library primitive;
use primitive.primitive.all;


-- Beginning Test Bench Header

ENTITY suma IS
    PORT (
	                   a :    in std_logic ;
	                   b :    in std_logic ;
	             control :    in std_logic ;
	                 clk :    in std_logic ;
	                 clr :    in std_logic ;
	                   c : inout std_logic ;
	                   s : inout std_logic_vector (3 downto 0)
    );
END suma;

-- End of Test Bench Header

ARCHITECTURE DSMB of suma is

	signal jed_node1	: std_logic:='0' ; -- clk
	signal jed_node2	: std_logic:='0' ; -- control
	signal jed_node3	: std_logic:='0' ; -- clr
	signal jed_node4	: std_logic:='0' ; -- b
	signal jed_node5	: std_logic:='0' ; -- a
	signal jed_node6	: std_logic:='0' ;
	signal jed_node7	: std_logic:='0' ;
	signal jed_node8	: std_logic:='0' ;
	signal jed_node9	: std_logic:='0' ;
	signal jed_node10	: std_logic:='0' ;
	signal jed_node11	: std_logic:='0' ;
	signal jed_node12	: std_logic:='0' ;
	signal jed_node13	: std_logic:='0' ;
	signal jed_node16	: std_logic:='0' ;
	signal jed_node18	: std_logic:='0' ;
	signal jed_node19	: std_logic:='0' ;
	signal jed_node20	: std_logic:='0' ;
	signal jed_node21	: std_logic:='0' ;
	signal jed_node24	: std_logic:='0' ;

	for all: c22v10m use entity primitive.c22v10m (sim);

SIGNAL  one:std_logic:='1';
SIGNAL  zero:std_logic:='0';
SIGNAL  jed_oept_1:std_logic:='0';
--Attribute PIN_NUMBERS of clk:SIGNAL is "0001";

SIGNAL  jed_oept_2:std_logic:='0';
--Attribute PIN_NUMBERS of control:SIGNAL is "0002";

SIGNAL  jed_oept_3:std_logic:='0';
--Attribute PIN_NUMBERS of clr:SIGNAL is "0003";

SIGNAL  jed_oept_4:std_logic:='0';
--Attribute PIN_NUMBERS of b:SIGNAL is "0004";

SIGNAL  jed_oept_5:std_logic:='0';
--Attribute PIN_NUMBERS of a:SIGNAL is "0005";

SIGNAL  jed_oept_14:std_logic:='0';
SIGNAL  jed_sum_14,jed_fb_14:std_logic:='0';
--Attribute PIN_NUMBERS of c:SIGNAL is "0014";

SIGNAL  jed_oept_15:std_logic:='0';
SIGNAL  jed_sum_15,jed_fb_15:std_logic:='0';
--Attribute PIN_NUMBERS of s(1):SIGNAL is "0015";

SIGNAL  jed_oept_16:std_logic:='0';
SIGNAL z_2:std_logic:='0';
SIGNAL  jed_sum_16,jed_fb_16:std_logic:='0';
--Attribute PIN_NUMBERS of jed_node16:SIGNAL is "0016";

SIGNAL  jed_oept_17:std_logic:='0';
SIGNAL  jed_sum_17,jed_fb_17:std_logic:='0';
--Attribute PIN_NUMBERS of s(3):SIGNAL is "0017";

SIGNAL  jed_oept_20:std_logic:='0';
SIGNAL z_0:std_logic:='0';
SIGNAL  jed_sum_20,jed_fb_20:std_logic:='0';
--Attribute PIN_NUMBERS of jed_node20:SIGNAL is "0020";

SIGNAL  jed_oept_21:std_logic:='0';
SIGNAL z_1:std_logic:='0';
SIGNAL  jed_sum_21,jed_fb_21:std_logic:='0';
--Attribute PIN_NUMBERS of jed_node21:SIGNAL is "0021";

SIGNAL  jed_oept_22:std_logic:='0';
SIGNAL  jed_sum_22,jed_fb_22:std_logic:='0';
--Attribute PIN_NUMBERS of s(0):SIGNAL is "0022";

SIGNAL  jed_oept_23:std_logic:='0';
SIGNAL  jed_sum_23,jed_fb_23:std_logic:='0';
--Attribute PIN_NUMBERS of s(2):SIGNAL is "0023";

SIGNAL  jed_oept_25:std_logic:='0';
SIGNAL  jed_node25,jed_sum_25:std_logic:='0';
SIGNAL  jed_oept_26:std_logic:='0';
SIGNAL  jed_node26,jed_sum_26:std_logic:='0';

BEGIN
jed_node1 <= clk ;
jed_node2 <= control ;
jed_node3 <= clr ;
jed_node4 <= b ;
jed_node5 <= a ;
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
     y=>c,
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
     y=>s(1),
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
     y=>jed_node16,
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
     y=>s(3),
     fb=>jed_fb_17
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
     y=>jed_node21,
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
     y=>s(0),
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
     y=>s(2),
     fb=>jed_fb_23
   );

z_2 <= jed_fb_16;
z_0 <= jed_fb_20;
z_1 <= jed_fb_21;
jed_node25<=jed_sum_25;
jed_node26<=jed_sum_26;
jed_oept_14<=(one);

jed_sum_14<= ((not(jed_node2) and not(not(jed_fb_21)) and not(not(jed_fb_20))
 and (not(jed_fb_16)) and (not(jed_fb_14))) or
(not(jed_node2) and (not(jed_fb_21)) and (jed_node4)
 and (jed_node5)) or
(not(jed_node2) and (jed_node4) and (not(jed_fb_20))
 and (jed_node5)) or
(not(jed_node2) and (jed_node4) and (jed_node5) and not(not(jed_fb_16))
) or
(not(jed_node2) and (jed_node4) and (not(jed_fb_14))
) or
(not(jed_node2) and (jed_node5) and (not(jed_fb_14))
));

jed_oept_15<=(one);

jed_sum_15<= ((not(jed_node2) and not(not(jed_fb_21)) and not(not(jed_fb_20))
 and (not(jed_fb_16)) and (not(jed_fb_15))) or
((not(jed_fb_23)) and not(jed_node2) and (not(jed_fb_21))
) or
((not(jed_fb_23)) and not(jed_node2) and (not(jed_fb_20))
) or
((not(jed_fb_23)) and not(jed_node2) and not(not(jed_fb_16))
));

jed_sum_16<= ((not(jed_node2) and (not(jed_fb_21)) and (not(jed_fb_20))
 and not(not(jed_fb_16))) or
(not(jed_node2) and not(not(jed_fb_20)) and (not(jed_fb_16))
) or
(not(jed_node2) and not(not(jed_fb_21)) and (not(jed_fb_16))
));

jed_oept_17<=(one);

jed_sum_17<= ((not(jed_node2) and (not(jed_fb_21)) and (jed_node4)
 and (jed_node5) and (not(jed_fb_14))) or
(not(jed_node2) and (jed_node4) and (not(jed_fb_20))
 and (jed_node5) and (not(jed_fb_14))) or
(not(jed_node2) and (not(jed_fb_21)) and not(jed_node4)
 and not(jed_node5) and (not(jed_fb_14))) or
(not(jed_node2) and not(jed_node4) and (not(jed_fb_20))
 and not(jed_node5) and (not(jed_fb_14))) or
(not(jed_node2) and (not(jed_fb_21)) and (jed_node4)
 and not(jed_node5) and not(not(jed_fb_14))) or
(not(jed_node2) and (jed_node4) and (not(jed_fb_20))
 and not(jed_node5) and not(not(jed_fb_14))) or
(not(jed_node2) and (not(jed_fb_21)) and not(jed_node4)
 and (jed_node5) and not(not(jed_fb_14))) or
(not(jed_node2) and not(jed_node4) and (not(jed_fb_20))
 and (jed_node5) and not(not(jed_fb_14))) or
(not(jed_node2) and not(not(jed_fb_21)) and not(not(jed_fb_20))
 and (not(jed_fb_17)) and (not(jed_fb_16))) or
(not(jed_node2) and (jed_node4) and (jed_node5) and not(not(jed_fb_16))
 and (not(jed_fb_14))) or
(not(jed_node2) and not(jed_node4) and not(jed_node5)
 and not(not(jed_fb_16)) and (not(jed_fb_14))) or
(not(jed_node2) and (jed_node4) and not(jed_node5) and not(not(jed_fb_16))
 and not(not(jed_fb_14))) or
(not(jed_node2) and not(jed_node4) and (jed_node5) and not(not(jed_fb_16))
 and not(not(jed_fb_14))));

jed_sum_20<= ((not(jed_node2) and (not(jed_fb_21)) and not(not(jed_fb_20))
) or
(not(jed_node2) and not(not(jed_fb_20)) and not(not(jed_fb_16))
));

jed_sum_21<= ((not(jed_node2) and (not(jed_fb_21)) and not(not(jed_fb_20))
) or
(not(jed_node2) and not(not(jed_fb_21)) and (not(jed_fb_20))
));

jed_oept_22<=(one);

jed_sum_22<= ((not(jed_node2) and (not(jed_fb_22)) and not(not(jed_fb_21))
 and not(not(jed_fb_20)) and (not(jed_fb_16))) or
(not(jed_node2) and (not(jed_fb_21)) and (not(jed_fb_15))
) or
(not(jed_node2) and (not(jed_fb_20)) and (not(jed_fb_15))
) or
(not(jed_node2) and not(not(jed_fb_16)) and (not(jed_fb_15))
));

jed_oept_23<=(one);

jed_sum_23<= (((not(jed_fb_23)) and not(jed_node2) and not(not(jed_fb_21))
 and not(not(jed_fb_20)) and (not(jed_fb_16))) or
(not(jed_node2) and (not(jed_fb_21)) and (not(jed_fb_17))
) or
(not(jed_node2) and (not(jed_fb_20)) and (not(jed_fb_17))
) or
(not(jed_node2) and (not(jed_fb_17)) and not(not(jed_fb_16))
));

jed_sum_25<= (((jed_node3)));

end DSMB;
