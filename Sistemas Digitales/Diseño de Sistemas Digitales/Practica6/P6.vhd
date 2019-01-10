library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use ieee.std_logic_unsigned.all;


entity CONTDEC is port(
	CLR,CLK: in std_logic;
	CONTROL: in std_logic_vector(2 downto 0);
	DATO: in bit_vector(3 downto 0);
	Q: out bit_vector(3 downto 0));
end CONTDEC;

architecture a_CONTDEC of CONTDEC is
	SIGNAL VAR: bit_vector(3 downto 0);

begin

	PROG: PROCESS(CLR,CLK,CONTROL,VAR)
		BEGIN
			if(CLR='0')then
		
				VAR<="0000";

			elsif(CLK'EVENT AND CLK='1')then
				CASE CONTROL is
					WHEN "000" =>  -- CONTEO ASCENDENTE
										
										VAR<=bit_vector(std_logic_vector(VAR)+1);

					WHEN "001" =>  -- CONTEO DESCENDENTE
										
										VAR<=bit_vector(std_logic_vector(VAR)-1);

					WHEN "010" =>  -- RETIENE DATO
										
										VAR<=VAR;

					WHEN "011" =>  -- CONTEO ANILLO DERECHA	
										
										VAR<=VAR ROR 1;

					WHEN "100" =>  -- CONTEO ANILLO IZQUIERDA
										
										VAR<=VAR ROL 1;

					WHEN "101" =>  -- CONTEO ASCENDENTE GRAY
										
										VAR<=bit_vector(std_logic_vector(VAR)+1);

					WHEN "110" =>  -- CONTEO DESCENDENTE GRAY	
										
										VAR<=bit_vector(std_logic_vector(VAR)-1);
	
					WHEN OTHERS => 	-- CARGAR DATO	
										
										VAR<=DATO;
				END CASE;

			end if;
	END PROCESS PROG;



	DECO: PROCESS(Q,VAR,CONTROL)
		BEGIN

		IF(CONTROL="101")THEN
		Q<=VAR XOR (VAR SRL 1);
		ELSIF(CONTROL="110")THEN
	   	Q<=VAR XOR (VAR SRL 1);
		ELSE
		Q<=VAR;
		END IF;

	END PROCESS DECO;


end a_CONTDEC;
