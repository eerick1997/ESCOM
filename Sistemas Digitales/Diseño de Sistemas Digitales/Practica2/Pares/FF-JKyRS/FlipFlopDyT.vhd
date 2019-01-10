library ieee;
use ieee.std_logic_1164.all;

--FlipFlopJKyRS

entity FFJKyRS is port(
	J,K,CLK,PRE,CLR,SEL: in std_logic;
	Q,NQ: out std_logic);
end FFJKyRS;

architecture a_FFJKyRS of FFJKyRS is
	Signal Estado: std_logic;
begin

			process(PRE,CLR,J,K,CLK,SEL)
				begin
						if(CLR='0')THEN	----- Pregunta por Clear primero
							Estado<='0';
						elsif(CLK='1' AND CLK'EVENT)THEN ---- Activa Reloj
							IF(PRE='1')THEN	---- Pregunta por select antes de todo
								Estado<='1';
							ELSIF(SEL='0') THEN  --- HACE JK
								if(J='0' and K='0')then
								Estado<=Estado;
								elsif(J='0' and K='1')then
								Estado<='0';
								elsif(J='1' and K='0')then
								Estado<='1';
								elsif(J='1' and K='1')then
								Estado<=NOT Estado;
								end if;
							ELSIF(SEL='1') THEN	--- HACE RS
								if(J='0' and K='0')then
								Estado<=Estado;
								elsif(J='0' and K='1')then
								Estado<='1';
								elsif(J='1' and K='0')then
								Estado<='0';
								elsif(J='1' and K='1')then
								Estado<='0';
								end if;
							END IF;
						end if;
		
			end process;


	Q<=Estado;
	NQ<=NOT Estado;


end a_FFJKyRS;
