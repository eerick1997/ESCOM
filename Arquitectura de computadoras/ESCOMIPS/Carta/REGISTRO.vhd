library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

--Para el registro IB es shift y corrimiento en un bit, y LB = LA
entity REGISTRO is

	 GENERIC(N : INTEGER := 8);

    Port ( CLK, CLR : in  STD_LOGIC;
           SHIFT, LA : in  STD_LOGIC;
           D : in  STD_LOGIC_VECTOR (N-1 downto 0);
           Q : inout  STD_LOGIC_VECTOR (N-1 downto 0));
end REGISTRO;

architecture programa of REGISTRO is
	begin

		PCONT: PROCESS (CLK, CLR)
		begin
			IF(CLR = '1') THEN
				Q <= (OTHERS => '0');
			ELSIF( RISING_EDGE(CLK)) THEN
				IF(LA = '1') THEN
					Q <= D;
				ELSIF(SHIFT = '1') THEN
					--Se castea a BITVECTOR para el corrimiento a la derecha y STD_LOGIC para asignar
					Q <= TO_STDLOGICVECTOR (TO_BITVECTOR (Q) SRL 1); 
				END IF;
			END IF;
		END PROCESS PCONT;
end programa;

