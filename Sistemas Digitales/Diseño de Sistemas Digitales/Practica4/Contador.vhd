library ieee;
use ieee.std_logic_1164.all;

--CONTADOR

entity ALLFF is port(
	CLK,CLR,CONTROL: in std_logic;
	Q: inout std_logic_vector(7 downto 0));
end ALLFF;

architecture a_ALLFF of ALLFF is
	Signal Estado,JK: std_logic_vector(7 downto 0):="00000000";
begin
	process(CONTROL,JK,Estado)
	begin
	for i in 0 to 7 loop

		if(i=0)then
			JK(i)<=CONTROL;
		elsif(i=1)then
			JK(i)<=CONTROL AND Q(i-1);
		else
			JK(i)<=JK(i-1) AND Q(i-1);
		end if;
	end loop;
	end process;


						
			process(CLR,CLK,CONTROL,JK,Estado)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Q<="00000000";
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj	

							for i in 0 to 7 loop							
								---------HACE LOS JK														
								if(JK(i)='0')then
								Q(i)<=Estado(i);
								elsif(JK(i)='1')then
								Q(i)<=NOT Estado(i);	
								end if;									
							end loop;
							 
					
						end if;
			end process;

			Estado<=Q;


 END a_ALLFF;