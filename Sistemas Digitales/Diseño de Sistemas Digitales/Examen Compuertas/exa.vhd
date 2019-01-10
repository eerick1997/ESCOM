library ieee;
use ieee.std_logic_1164.all;

--CONTADOR

entity ALLFF is port(
	CLK,CLR,CONTROL: in std_logic;
	Q: inout std_logic_vector(2 downto 0));
end ALLFF;

architecture a_ALLFF of ALLFF is
	Signal D: std_logic_vector(2 downto 0);
begin

	process(CONTROL,D)
	begin
	for i in 0 to 2 loop

		if(i=0)then
			D(i)<=(NOT CONTROL AND Q(0))OR(CONTROL AND NOT Q(0));
		elsif(i=1)then
			D(i)<=(NOT CONTROL AND Q(1))OR(NOT Q(2)AND NOT Q(0))OR(CONTROL AND NOT Q(1)AND Q(0));
		elsif(i=2)then
			D(i)<=(Q(2)AND NOT Q(1))OR(NOT CONTROL AND Q(2))OR(CONTROL AND Q(1)AND Q(0));
		end if;
	end loop;
	end process;


						
			process(CLR,CLK,CONTROL,D)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Q<="001";
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj	

							for i in 0 to 2 loop							
								---------HACE LOS D														
								if(D(i)='0')then
								Q(i)<='0';
								elsif(D(i)='1')then
								Q(i)<='1';	
								end if;									
							end loop;
							 
					
						end if;
			end process;


 END a_ALLFF;