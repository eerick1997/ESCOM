library ieee;
use ieee.std_logic_1164.all;

entity proyect is
	port (A: in std_logic_vector (1 downto 0); 
		d: out std_logic_vector (7 downto 0)); 
	end proyect;

architecture arqproyect of proyect is
	begin
	process (A) begin
		case A is 
		    when "00" => d <= "00000010";
			when "01" => d <= "10011110"; 
			when "10" => d <= "00100100"; 
			when "11" => d <= "00001100"; 
			
			when others => d <= "11111110"; 
		end case;
	end process;
end arqproyect;
