library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity ESTADO is
    Port ( CLK : in  STD_LOGIC;
           CLR : in  STD_LOGIC;
           LF  : in  STD_LOGIC;
           BANDERAS  : in   STD_LOGIC_VECTOR (3 downto 0);
           RBANDERAS : out  STD_LOGIC_VECTOR (3 downto 0));
end ESTADO;

architecture REGISTRO of ESTADO is

begin
	PREG : PROCESS(CLK, CLR)
	begin
		if( CLR = '1') then
			RBANDERAS <= (OTHERS => '0');
		elsif (FALLING_EDGE(CLK)) then
			if(LF = '1') then
				RBANDERAS <= BANDERAS;
			end if;
		end if;
	end process PREG;
end REGISTRO;
