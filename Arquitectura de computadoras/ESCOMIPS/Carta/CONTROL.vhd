library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity CONTROL is
    Port ( CLK, CLR : in  STD_LOGIC;
           INI, Z, A0 : in  STD_LOGIC;
           LA, SH, LB, IB, S : out  STD_LOGIC);
end CONTROL;

architecture UNIDAD of CONTROL is
	TYPE ESTADOS IS (A, B, C);
	SIGNAL EDO_ACT, EDO_SGTE : ESTADOS;

begin
	
	AUTOMATA : PROCESS( EDO_ACT, INI, Z, A0 )
	BEGIN
		--Se inicializan todas las banderas con 0
		LA <= '0';
		SH <= '0';
		LB <= '0';
		IB <= '0';
		S  <= '0';
		CASE EDO_ACT IS 
			WHEN A => LB <= '1'; --Salida MOORE: Las asignaciones van despues de la flecha
				IF(INI = '1') THEN
					EDO_SGTE <= B;
				ELSE 
					LA <= '1';
					EDO_SGTE <= A;
				END IF;

			WHEN B => SH <= '1'; --Salida MOORE: Las asignaciones van despues de la flecha
				IF(Z = '1') THEN
					EDO_SGTE <= C;
				ELSE
					IF(A0 = '1') THEN
						IB <= '1';
						EDO_SGTE <= B;
					ELSE
						EDO_SGTE <= B;
					END IF;
				END IF;
			
			WHEN C => S <= '1';
				IF(INI = '1') THEN
					EDO_SGTE <= C;
				ELSE
					EDO_SGTE <= A;
				END IF;
		END CASE;
	END PROCESS AUTOMATA;
	
	TRANSICION : PROCESS( CLK, CLR )
	BEGIN
		IF( CLR = '1') THEN
			EDO_ACT <= A;
		ELSIF(RISING_EDGE(CLK)) THEN
			EDO_ACT <= EDO_SGTE;
		END IF;
		
	END PROCESS TRANSICION;
	

end UNIDAD;

