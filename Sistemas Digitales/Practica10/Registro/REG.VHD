library ieee;
use ieee.std_logic_1164.all;

--Registro

entity RegU is port(
	CLK,CLR,CONTROL: in std_logic;
	DATO: in std_logic_vector(7 downto 0);
	E: out std_logic
	);
	
end RegU;

architecture a_RegU of RegU is
	SIGNAL 	Q: std_logic_vector(7 downto 0):="00000000";
begin

	PROCESS (CLK,CLR,CONTROL)				
		begin								
			IF(CLR='0')THEN
				Q<="00000000";
				DATO<="00000000";
				E<='0';
			ELSIF(CLK'EVENT and CLK='1') THEN
				CASE CONTROL IS
					WHEN '0' => 
								Q <= DATO;
								
					WHEN OTHERS =>
								E<=Q(0);
								for i in 7 downto 0 loop
									if(i=7)then
										Q(i)<='0';
									else
										Q(i)<=Q(i+1);
									end if;
								end loop;
					END CASE;
			END IF;

	end PROCESS;	

 END a_RegU;