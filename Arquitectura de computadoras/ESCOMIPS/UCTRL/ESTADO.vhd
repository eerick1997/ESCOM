library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity ESTADO is
    Port ( CLK, CLR, LF : in  STD_LOGIC;
           BANDERAS : in  STD_LOGIC_VECTOR (3 downto 0);
           RBANDERAS : out  STD_LOGIC_VECTOR (3 downto 0));
end ESTADO;

architecture REGISTRO of ESTADO is

begin
	PREG: PROCESS(CLK, CLR) BEGIN
		IF(CLR = '1') THEN
			RBANDERAS <= (OTHERS => '0');
		ELSIF( FALLING_EDGE(CLK) ) THEN
			IF(LF = '1') THEN
				RBANDERAS <= BANDERAS;
			END IF;
		END IF;
	END PROCESS PREG;
end REGISTRO;

