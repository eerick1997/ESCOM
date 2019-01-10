library ieee;
use ieee.std_logic_1164.all;

--FlipFlopDyT

entity FFDyT is port(
	D,CLK,PRE,CLR,SEL: in std_logic;
	Q,NQ: out std_logic);
end FFDyT;

architecture a_FFDyT of FFDyT is
	Signal Estado: std_logic;
begin

			process(PRE,CLR,D,CLK,SEL)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Estado<='0';
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj
							IF(PRE='1')THEN	---- Pregunta por select antes de todo
								Estado<='1';
							ELSIF(SEL='0') THEN  --- HACE T
								if(D='0')then
								Q<=Estado;
								NQ<=NOT Estado;
								elsif(D='1')then
								Q<=NOT Estado;	
								NQ<=Estado;
								end if;
							ELSIF(SEL='1') THEN	--- HACE D
								if(D='0')then
								Q<='0';
								NQ<='1';
								elsif(D='1')then
								Q<='1';
								NQ<='0';
								end if;
							END IF;
						end if;
		
			end process;


Estado<=Q;



end a_FFDyT;
