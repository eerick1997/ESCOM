library ieee;
use ieee.std_logic_1164.all;

entity DET is port(
	CLK,CLR,E: in std_logic;
	S: out std_logic
	);
end DET;

architecture a_DET of DET is
	type ESTADOS is(A,B,C,D);
	SIGNAL EDO_PRESENTE: ESTADOS;
	SIGNAL EDO_FUTURO: ESTADOS;
begin
	
	PROCESS(EDO_PRESENTE,E,CLR)
	BEGIN	
	IF(CLR='1') THEN
		CASE EDO_PRESENTE IS
			WHEN A => 
					IF (E='0')THEN
						EDO_FUTURO<=A;
						S<='0';
					ELSE
						EDO_FUTURO<=B;
						S<='0';
					END IF;	   
			WHEN B => 
					IF (E='0')THEN
						EDO_FUTURO<=A;
						S<='0';
					ELSE
						EDO_FUTURO<=C;
						S<='0';
					END IF;
			WHEN C => 
					IF (E='0')THEN
						EDO_FUTURO<=D;
						S<='0';
					ELSE
						EDO_FUTURO<=B;
						S<='0';
					END IF;
			WHEN D => 
					IF (E='0')THEN
						EDO_FUTURO<=A;
						S<='1';
					ELSE
						EDO_FUTURO<=A;
						S<='0';
					END IF;
		END CASE;
	END IF;
	END PROCESS;

	PROCESS(CLK,CLR)
	BEGIN
		IF(CLR = '0')THEN
			S<='0';
		ELSIF(CLK'EVENT AND CLK='1')THEN				
			EDO_PRESENTE<=EDO_FUTURO;
		END IF;
	END PROCESS;	

end a_DET;
