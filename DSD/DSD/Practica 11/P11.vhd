library ieee;

use ieee.std_logic_1164.all;

entity P11 is port(
	CLK, CLR: in bit;
	CHANGE: inout bit_vector(2 downto 0):="011";
	DISPLAY: out bit_vector(6 downto 0)
	);
end P11;

architecture AP11 of P11 is 
	
											-- ABCDEFG	
	constant letraI: bit_vector(6 downto 0):= "1001111"; --I
	constant letraP: bit_vector(6 downto 0):= "0011000"; --P
	constant letraN: bit_vector(6 downto 0):= "1101010"; --N
	constant nothing: bit_vector(6 downto 0):= "1111110"; -- "-"
	
	
	begin
		CAMBIOS:PROCESS(CHANGE)
			begin
				case CHANGE is
					when "011" => DISPLAY <= letraI;
					when "101" => DISPLAY <= letraP;
					when "110" => DISPLAY <= letraN;
					when others => DISPLAY <= nothing;
				end case;
			end PROCESS CAMBIOS;
			
		PROCESS(CLK,CLR)
			begin
				if(CLR = '0') then
					CHANGE <= "011";
				
				elsif(CLK'EVENT AND CLK='1') then
					CHANGE <= CHANGE ROR 1;
				
				end if;
				
			end process;		 
	end AP11;
	
	