library ieee;
use ieee.std_logic_1164.all;

--FlipFlopRS

entity FFRS is port(
	R,S,CLK,PRE,CLR: in std_logic;
	Q,NQ: out std_logic);
end FFRS;

architecture a_FFRS of FFRS is
	Signal Estado: std_logic;
begin

			process(PRE,CLR,R,S,CLK)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Estado<='0';
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj
								IF(PRE='1')THEN	---- Hace RS
								Estado<='1';
								elsif(R='0' and S='0')then
								Estado<=Estado;
								elsif(R='0' and S='1')then
								Estado<='1';
								elsif(R='1' and S='0')then
								Estado<='0';
								elsif(R='1' and S='1')then
								Estado<='0';
								END IF;
						end if;
		
			end process;


	Q<=Estado;
	NQ<=NOT Estado;


end a_FFRS;
