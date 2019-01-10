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

	----------------------------------------------
												--
	MUX0: PROCESS (CONTROL)						--
		begin									--
			case control is						--
				WHEN "00" => D(0) <=Q(0);		--
				WHEN "01" => D(0) <=Dato(0);	-- CASO BASE
				WHEN "10" => D(0) <=CD;		--<---
				WHEN OTHERS => D(0) <=Q(1);		--
			end case;							--
	end PROCESS MUX0;							--		
												--

			
	MUX1: PROCESS (CONTROL)				
				begin								
					case control is					
						WHEN "00" => D(1) <=Q(1);		
						WHEN "01" => D(1) <=Dato(1);
						WHEN "10" => D(1) <=Q(0);		
						WHEN OTHERS => D(1) <=Q(2);
					end case;							
	end PROCESS MUX1;	

	MUX2: PROCESS (CONTROL)				
				begin								
					case control is					
						WHEN "00" => D(2) <=Q(2);		
						WHEN "01" => D(2) <=Dato(2);
						WHEN "10" => D(2) <=Q(1);		
						WHEN OTHERS => D(2) <=Q(3);
					end case;							
	end PROCESS MUX2;	

	MUX3: PROCESS (CONTROL)				
				begin								
					case control is					
						WHEN "00" => D(3) <=Q(3);		
						WHEN "01" => D(3) <=Dato(3);
						WHEN "10" => D(3) <=Q(2);		
						WHEN OTHERS => D(3) <=Q(4);
					end case;							
	end PROCESS MUX3;	

	MUX4: PROCESS (CONTROL)				
				begin								
					case control is					
						WHEN "00" => D(4) <=Q(4);		
						WHEN "01" => D(4) <=Dato(4);
						WHEN "10" => D(4) <=Q(3);		
						WHEN OTHERS => D(4) <=Q(5);
					end case;							
	end PROCESS MUX4;	

	MUX5: PROCESS (CONTROL)				
				begin								
					case control is					
						WHEN "00" => D(5) <=Q(5);		
						WHEN "01" => D(5) <=Dato(5);
						WHEN "10" => D(5) <=Q(4);		
						WHEN OTHERS => D(5) <=Q(6);
					end case;							
	end PROCESS MUX5;	

	MUX6: PROCESS (CONTROL)				
				begin								
					case control is					
						WHEN "00" => D(6) <=Q(6);		
						WHEN "01" => D(6) <=Dato(6);
						WHEN "10" => D(6) <=Q(5);		
						WHEN OTHERS => D(6) <=Q(7);
					end case;							
	end PROCESS MUX6;	


   	MUX7: PROCESS (CONTROL)				
				begin								
					case control is					
						WHEN "00" => D(7) <=Q(7);		
						WHEN "01" => D(7) <=Dato(7);
						WHEN "10" => D(7) <=Q(6);		
						WHEN OTHERS => D(7) <=CI;
					end case;							
	end PROCESS MUX7;	

	PROCESS(CLR,CLK)
		begin
			IF(CLR='0')THEN
				Q<="00000000";
			ELSIF(CLK'EVENT and CLK='1') THEN
				Q<=D;
			END IF;


	END PROCESS;


 END a_RegU;
