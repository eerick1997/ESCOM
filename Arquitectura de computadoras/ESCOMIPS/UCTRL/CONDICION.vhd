library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity CONDICION is
    Port ( RBANDERAS : in  STD_LOGIC_VECTOR (3 downto 0);
           EQ, NEQ, LT, LE, G, GET : out  STD_LOGIC);
end CONDICION;

architecture BLOQUE of CONDICION is

-- BANDERAS(0) : C 
-- BANDERAS(1) : Z
-- BANDERAS(2) : N
-- BANDERAS(3) : OV

begin

	EQ <= RBANDERAS(1);
	G <= (NOT RBANDERAS(1))AND ( NOT (RBANDERAS(2) XOR RBANDERAS(3)));
	--CONTINUARÁ

end BLOQUE;

