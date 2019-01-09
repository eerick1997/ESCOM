library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity CONTROL is
    Port ( CLK, CLR : in  STD_LOGIC;
           TIPOR, BEQI, BNEQI, BLTI, BLETI, BGTI, BGETI : in  STD_LOGIC;
           EQ, NEQ, G, GET, LT, LET : in  STD_LOGIC;
           NA : in  STD_LOGIC;
           SDOPC, SM : out  STD_LOGIC);
end CONTROL;

architecture UNIDAD of CONTROL is
TYPE ESTADOS IS (A);
SIGNAL EDO_ACT, EDO_SGTE : ESTADOS;
begin
	
	AUTOMATA: PROCESS(EDO_ACT,NA,TIPOR,BEQI,BNEQI,BLTI,BLETI,BGTI,BGETI,EQ,NEQ,G,GET,LT,LET) BEGIN
		SDOPC <= '0';
		SM <= '0';
		CASE EDO_ACT IS
		WHEN
			A => 
			IF(TIPOR = '1') THEN
				IF(BEQI = '1') THEN
					IF(NA = '1') THEN
						SM <= '1';
					ELSE
						IF(EQ = '1') THEN
							SDOPC <= '1';
							SM <= '1';
						ELSE
							SM <= '1';

						END IF;
					END IF;
				ELSIF(BNEQI = '1') THEN
					--CONTINUARA...
				END IF;
			END IF;
			EDO_SGTE <= A;
		END CASE;
	END PROCESS AUTOMATA;
	
	TRANSICION: PROCESS(CLK) BEGIN
	
	END PROCESS TRANSICION;

end UNIDAD;

