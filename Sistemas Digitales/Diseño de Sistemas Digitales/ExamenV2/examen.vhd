library ieee;
use ieee.std_logic_1164.all;

entity CONTDEC is port(
	CLR,CLK,CONTROL: in std_logic;
	DISPLAY: inout std_logic_vector(6 downto 0));
end CONTDEC;

architecture a_CONTDEC of CONTDEC is
											------abcdefg
	constant dig1: std_logic_vector(6 downto 0):="1001111";--1
	constant dig2: std_logic_vector(6 downto 0):="0010010";--2
	constant dig3: std_logic_vector(6 downto 0):="0000110";--3
	constant dig4: std_logic_vector(6 downto 0):="1001100";--4
	constant dig5: std_logic_vector(6 downto 0):="0100100";--5
	constant dig6: std_logic_vector(6 downto 0):="0100000";--6

begin

	process(CLR,CLK,CONTROL,DISPLAY)
		begin

			if(CLR='0')then
			DISPLAY<=dig1;
			elsif(CLK'EVENT AND CLK='1')then

				if(CONTROL='0') then
								DISPLAY<=DISPLAY;---RETIENE DATO
				elsif(CONTROL='1') then
							CASE DISPLAY IS	-- CONTEO ASCENDENTE
									WHEN dig1=> DISPLAY<=dig2;
									WHEN dig2=> DISPLAY<=dig3;
									WHEN dig3=> DISPLAY<=dig4;
									WHEN dig4=> DISPLAY<=dig5;
									WHEN dig5=> DISPLAY<=dig6;
									WHEN OTHERS => DISPLAY<=dig1;
								 END CASE;
				end if;

			end if;
	end process;

end a_CONTDEC;