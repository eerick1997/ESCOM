library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity CONDICION is
    Port ( EQ  : out  STD_LOGIC;
           NEQ : out  STD_LOGIC;
           G   : out  STD_LOGIC;
           GET : out  STD_LOGIC;
           LT  : out  STD_LOGIC;
           LET : out  STD_LOGIC;
           BANDERAS : in  STD_LOGIC_VECTOR (3 downto 0)
			);
end CONDICION;

-- BANDERAS (0) - C
-- BANDERAS (1) - Z
-- BANDERAS (2) - N
-- BANDERAS (3) - OV

architecture BLOQUE of CONDICION is
	 -- EQ  = Z 
    -- G   = ~Z AND ~(N XOR OV)
    -- GET = Z OR ~(N XOR OV)
    -- LT  = ~Z AND (N XOR OV)
    -- LET = Z OR (N XOR OV)
    -- NEQ = ~Z
begin
	
	EQ  <= BANDERAS(1);
   NEQ <= ( NOT BANDERAS(1) );
   G   <= (NOT BANDERAS(1)) AND (NOT ( BANDERAS(2) XOR BANDERAS(3) ) );
   GET <= BANDERAS(1) OR (NOT ( BANDERAS(2) XOR BANDERAS(3) ) );
   LT  <= ( BANDERAS(2) XOR BANDERAS(3) ) AND (NOT BANDERAS(1));
   LET <= ( BANDERAS(1) ) OR ( BANDERAS(2) XOR BANDERAS(3) );

end BLOQUE;

