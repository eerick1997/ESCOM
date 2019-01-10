library ieee;
use ieee.std_logic_1164.all;

entity reg is port(
	CLK, CLR, CI, CD: in std_logic;
	DATO: in std_logic_vector(7 downto 0);
	CONTROL: in std_logic_vector(1 downto 0);
	Q: inout std_logic_vector(7 downto 0)
);
end entity;

architecture a_reg of reg is
begin
	process(CLK,CLR,CONTROL)
		begin
			IF(CLR = '0') THEN
				Q <= "00000000";
			
			ELSIF (CLK'EVENT AND CLK = '1') THEN
				CASE CONTROL IS
					WHEN "00" => Q <= Q;
					WHEN "01" => Q <= DATO;
					WHEN "10" =>
						FOR I IN 7 DOWNTO 0 LOOP
							IF(I=7) THEN
								Q(I)<= CD;
							ELSE
								Q(I) <= Q(I+1);
							END IF;
						END LOOP;
					WHEN OTHERS =>
						FOR I IN 0 TO 7 LOOP
							IF (I=0) THEN
								Q(I) <= CI;
							ELSE
								Q(I) <= Q(I-1);
							END IF;
						END LOOP;
				END CASE;
			END IF;
		END PROCESS;
	END a_reg;	
					