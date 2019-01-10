library ieee;
use ieee.std_logic_1164.all;

--FlipFlopRS

entity FFJK is port(
	J,K,CLK,PRE,CLR: in std_logic;
	Q,NQ: out std_logic);
end FFJK;

architecture a_FFJK of FFJK is
	Signal Estado: std_logic;
begin

			process(PRE,CLR,J,K,CLK)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Estado<='0';
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj
								IF(PRE='1')THEN	---- Hace KJ
								Estado<='1';
								elsif(J='0' and K='0')then
								Estado<=Estado;
								elsif(J='0' and K='1')then
								Estado<='0';
								elsif(J='1' and K='0')then
								Estado<='1';
								elsif(J='1' and K='1')then
								Estado<=NOT Estado;
								END IF;
						end if;
		
			end process;


	Q<=Estado;
	NQ<=NOT Estado;


end a_FFJK;
