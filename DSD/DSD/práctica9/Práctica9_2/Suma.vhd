library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use ieee.std_logic_unsigned.all;

entity suma is port(
	a,b,control,clk,clr:in std_logic;
	c:inout std_logic;
	s:inout std_logic_vector(3 downto 0));
end entity;

architecture asuma of suma is
signal z:std_logic_vector(2 downto 0):="000";
begin
	process(clr,clk,control)begin
	if(clr='1')then
		c<='0';
		s<="0000";
		z<="000";
	elsif(clk'event and clk='1')then
		if(control='1')then
			c<='0';
			s<="0000";
			z<="000";
		else
			if(z="100")then
			c<=c;
			s<=s;
			z<=z;
			else
				c<=(c and a) or (c and b) or (a and b);
				s<=TO_STDLOGICVECTOR(TO_BITVECTOR(s)SRL(1));
				s(3)<=c xor (a xor b);
				z<=z+1;
			end if;
		end if;
	end if;
	end process;
end asuma;
