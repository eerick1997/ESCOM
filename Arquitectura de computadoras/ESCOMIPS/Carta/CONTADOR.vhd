library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
entity CONTADOR is
	 GENERIC(N : INTEGER := 4);
    Port ( CLK, CLR : in  STD_LOGIC;
           IB, LB : in  STD_LOGIC;
           D : in  STD_LOGIC_VECTOR (N-1 downto 0);
           Q : inout  STD_LOGIC_VECTOR (N-1 downto 0));
end CONTADOR;

architecture PROGRAMA of CONTADOR is

begin

	PCONT: PROCESS (CLK, CLR)
	begin
		IF(CLR = '1') THEN
			Q <= (OTHERS => '0');
		ELSIF( RISING_EDGE(CLK)) THEN
			IF(LB = '1') THEN
				Q <= D;
			ELSIF(IB = '1') THEN
				Q <= Q+1;
			END IF;
		END IF;
	END PROCESS PCONT;
end PROGRAMA;

