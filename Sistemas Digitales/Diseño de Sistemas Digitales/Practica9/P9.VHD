library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_arith.all;
use ieee.std_logic_unsigned.all;

entity RegU is port(
	CLK,CLR,A,B,CONTROL: in bit;
	Cout,S0,S1,S2,S3,S4: out bit
	);
	
end RegU;

architecture a_RegU of RegU is
	SIGNAL CONT: std_logic_vector(2 downto 0):="000";
	SIGNAL Cin: bit:='0';
begin

	PROCESS (CLK,CLR,CONT)				
		begin								
			IF(CLR='0')THEN
				S0<='0';
				S1<='0';
				S2<='0';
				S3<='0';
				S4<='0';
				Cout<='0';
				CONT<="000";
			ELSIF(CLK'EVENT and CLK='1') THEN

				IF (CONTROL='1') THEN
						CASE CONT IS
							WHEN "000" =>
							Cout<=(A AND B)or(Cin AND A)or(Cin and B);
								S0<= A XOR B;
								CONT<=CONT + 1;
							WHEN "001" =>
							Cout<=(A AND B)or(Cin AND A)or(Cin and B);
								S1<= Cin XOR A XOR B;
								CONT<=CONT + 1;
							WHEN "010" =>
							Cout<=(A AND B)or(Cin AND A)or(Cin and B);
								S2<= Cin XOR A XOR B;
								CONT<=CONT + 1;
							WHEN "011" =>
							Cout<=(A AND B)or(Cin AND A)or(Cin and B);
								S3<= Cin XOR A XOR B;
								CONT<=CONT + 1;
							WHEN "100" =>
								Cout<=(A AND B)or(Cin AND A)or(Cin and B);
								S4<= Cin XOR A XOR B;
								CONT<=CONT + 1;
							WHEN OTHERS =>
								S0<=S0;
								S1<=S1;
								S2<=S2;
								S3<=S3;
								S4<=S4;
								Cout<=Cout;
						END CASE;
				END IF;

			END IF;


	end PROCESS;

	Cin<=Cout;
			
 END a_RegU;