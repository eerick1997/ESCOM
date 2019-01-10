library ieee;
use ieee.std_logic_1164.all;

--Flip Flop tipo JK
entity ffjk is port(
	J,K,CLK,PRE,CLR: in std_logic;
	Q,NQ: inout std_logic);
end ffjk;

architecture a_ffjk of ffjk is
	begin
		process(PRE,CLR,J,K,CLK)
			begin
				if(CLR='0') THEN
					Q <= '0';
					NQ <= '1';
				elsif (CLK'event and CLK ='1') THEN
					if(PRE='1') THEN
						Q <= '1';
						NQ <= '0';
					elsif(J='0' AND K='0') THEN
						Q <= Q;
						NQ <= NOT Q;
					elsif (J='0' AND K='1') THEN
						Q <= '0';
						NQ <= '1';
					elsif (J='1' AND K='0') THEN
						Q <= '1';
						NQ <= '0';
					elsif (J='1' AND K='1') THEN
						Q <= NOT Q;
						NQ <= Q;
					end if;
				 end if;
		end process;
end a_ffjk;	
				
				
								