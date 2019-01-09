library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity Divisor is
	GENERIC(DIV : INTEGER := 52428800);
    Port ( OSC_CLK : in  STD_LOGIC;
           CLK : inout  STD_LOGIC;
           CLR : in  STD_LOGIC);
end Divisor;

architecture Programa of Divisor is
--SIGNAL CONT: STD_LOGIC_VECTOR(25 downto 0);
SIGNAL CONT: INTEGER RANGE 0 TO DIV-1;
begin
	PDIV: PROCESS(OSC_CLK, CLR) BEGIN
		
		IF(CLR = '1') THEN
			--CLR <= (OTHERS => '0');
			CONT <= 0;
			CLK <= '0';
		ELSIF(RISING_EDGE(OSC_CLK)) THEN
			CONT <= CONT + 1;
			--IF(CONT = "11"&X"200000") THEN
			IF(CONT = 0) THEN
				CLK <= NOT CLK;
				--CONT <= (OTHERS => '0');
				--CONT <= 0;
			END IF;
		END IF;
	END PROCESS PDIV;
end Programa;

