library ieee;
use ieee.std_logic_1164.all;

--FlipFlopD

entity FFD is port(
	D,CLK,PRE,CLR: in std_logic;
	Q,NQ: out std_logic);
end FFD;

architecture a_FFD of FFD is
	Signal Estado: std_logic;
begin

			process(PRE,CLR,D,CLK)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Estado<='0';
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj
								IF(PRE='1')THEN	---- Hace D
								Estado<='1';
								elsif(D='0')then
								Estado<='0';
								elsif(D='1')then
								Estado<='1';
								END IF;
						end if;
		
			end process;


	Q<=Estado;
	NQ<=NOT Estado;


end a_FFD;
