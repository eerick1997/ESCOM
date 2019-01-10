library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use ieee.std_logic_unsigned.all;

entity REGISTROS is port(
	A,B: inout std_logic_vector(3 downto 0);
	C:inout std_logic;
	SA,SB:inout std_logic;
	CLK,CLR,control:in std_logic);
end entity;

architecture AREGISTROS of registros is
signal s1,s2:std_logic_vector(3 downto 0);
begin
process(CLK,CLR,control)begin
	if(clr='0')then
		SA<='0';
		SB<='0';
		s1<="0000";
		s2<="0000";
	elsif(CLK'EVENT and CLK='1')then
		if(control='1')then
			SA<=SA;
			SB<=SB;
			s1<=a;
			s2<=b;
		else
			SA<=s1(0);
			SB<=s2(0);
			s1<=TO_STDLOGICVECTOR(TO_BITVECTOR(s1)SRL(1));
			s2<=TO_STDLOGICVECTOR(TO_BITVECTOR(s2)SRL(1));
		end if;
	end if;
end process;
end AREGISTROS;
