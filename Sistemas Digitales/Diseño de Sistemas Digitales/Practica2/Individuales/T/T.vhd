library ieee;
use ieee.std_logic_1164.all;

--FlipFlopT

entity FFT is port(
	T,CLK,PRE,CLR: in std_logic;
	Q,NQ: out std_logic);
end FFT;

architecture a_FFT of FFT is
	Signal Estado: std_logic;
begin

			process(PRE,CLR,T,CLK)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Estado<='0';
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj
								IF(PRE='1')THEN	---- Hace T
								Estado<='1';
								elsif(T='0')then
								Estado<=Estado;
								elsif(T='1')then
								Estado<=NOT Estado;
								END IF;
						end if;
		
			end process;


	Q<=Estado;
	NQ<=NOT Estado;


end a_FFT;
