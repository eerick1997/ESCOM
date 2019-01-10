library ieee;
use ieee.std_logic_1164.all;

--ALL

entity ALLFF is port(
	E1,E2,CLK,PRE,CLR: in std_logic;
	Q,NQ: inout std_logic;
	SEL: in std_logic_vector(1 downto 0));
end ALLFF;

architecture a_ALLFF of ALLFF is
	Signal Estado: std_logic;
	Signal AUX: std_logic;
begin


			process(PRE,CLR,E1,E2,CLK,SEL,Q,NQ)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Q<='0';
							NQ<='1';
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj
							IF(PRE='1')THEN	---- Pregunta por select antes de todo
								Q<='1';
								NQ<='0';
							ELSIF(SEL="00") THEN  --- HACE SR
								if(E1='0' and E2='0')then
								Q<=Estado;
								NQ<=NOT Estado;
								elsif(E1='0' and E2='1')then
								Q<='1';
								NQ<='0';
								elsif(E1='1' and E2='0')then
								Q<='0';
								NQ<='1';
								elsif(E1='1' and E2='1')then
								Q<='1';
								NQ<='1';
								end if;
							ELSIF(SEL="01") THEN	--- HACE JK
								if(E1='0' and E2='0')then
								Q<=Estado;
								NQ<=NOT Estado;
								elsif(E1='0' and E2='1')then
								Q<='0';
								NQ<='1';
								elsif(E1='1' and E2='0')then
								Q<='1';
								NQ<='0';
								elsif(E1='1' and E2='1')then
								Q<=NOT Estado;	
								NQ<=Estado;
								end if;
								

							ELSIF(SEL="10") THEN	--- HACE T
								if(E1='0')then
								Q<=Estado;
								NQ<=NOT Estado;
								elsif(E1='1')then
								Q<=NOT Estado;	
								NQ<=Estado;
								end if;
							ELSIF(SEL="11") THEN	--- HACE D
								if(E1='0')then
								Q<='0';
								NQ<='1';
								elsif(E1='1')then
								Q<='1';
								NQ<='0';
								end if;
							END IF;

							

						end if;
		
			end process;


			
Estado<=Q;

 END a_ALLFF;
