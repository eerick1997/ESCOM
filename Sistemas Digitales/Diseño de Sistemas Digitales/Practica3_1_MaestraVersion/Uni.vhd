library ieee;
use ieee.std_logic_1164.all;

--Universal

entity RegU is port(
	CLK,CLR,CD,CI: in std_logic;
	CONTROL: in std_logic_vector(1 downto 0);
	dato: in std_logic_vector(7 downto 0);
	Q: inout std_logic_vector(7 downto 0));
	
end RegU;

architecture a_RegU of RegU is
	signal D: std_logic_vector(7 downto 0);
begin

			
	PROCESS (CLK,CLR,CONTROL)				
		begin								
			IF(CLR='0')THEN
				Q<="00000000";
			ELSIF(CLK'EVENT and CLK='1') THEN
				CASE CONTROL IS
					WHEN "00" => Q <= Q;
					WHEN "01" => Q <= dato;
					WHEN "10" =>
								for i in 7 downto 0 loop
									if(i=7)then
										Q(i)<=CD;
									else
										Q(i)<=Q(i+1);
									end if;
								end loop;
					WHEN OTHERS =>	
								for i in 0 to 7 loop
									if(i=0)then
										Q(i)<=CI;
									else
										Q(i)<=Q(i-1);
									end if;
								end loop;
				END CASE;
			END IF;

	end PROCESS;	


 END a_RegU;