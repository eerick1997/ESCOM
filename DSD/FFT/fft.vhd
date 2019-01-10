library ieee;
use ieee.std_logic_1164.all;

--Flip Flop tipo T
entity fft is port(
	T,CLK,PRE,CLR: in std_logic;
	Q,NQ: inout std_logic);
end fft;

architecture a_fft of fft is
	begin
		process(PRE,CLR,CLK)
			begin
				if(CLR ='0') THEN
					Q <= '0';
					NQ <= '1';
				elsif (CLK'event and CLK ='1') THEN
					if(PRE ='1') THEN
						Q <= '1';
						NQ <= '0';
					elsif (T='0') THEN
						Q <= Q;
						NQ <= NOT Q;
					elsif(T='1') THEN
						Q <= NOT Q;
						NQ <= Q;
					end if;
				end if;
		end process;
end a_fft;
						
