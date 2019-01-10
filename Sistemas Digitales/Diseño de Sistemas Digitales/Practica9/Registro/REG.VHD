library ieee;
use ieee.std_logic_1164.all;

--Registro

entity RegU is port(
	CLK,CLR,CONTROL: in std_logic;
	DATO1: in std_logic_vector(3 downto 0);
	DATO2: in std_logic_vector(3 downto 0);
	A: out std_logic;
	B: out std_logic
	);
	
end RegU;

architecture a_RegU of RegU is
	SIGNAL 	Q1: std_logic_vector(3 downto 0):="0000";
	SIGNAL 	Q2: std_logic_vector(3 downto 0):="0000";
begin

	PROCESS (CLK,CLR,CONTROL)				
		begin								
			IF(CLR='0')THEN
				Q1<="0000";
				Q2<="0000";
			   	DATO1<="0000";
			   	DATO1<="0000";
				A<='0';
				B<='0';
			ELSIF(CLK'EVENT and CLK='1') THEN
				CASE CONTROL IS
					WHEN '0' => 
								Q1 <= DATO1;
								Q2 <= DATO2;
					WHEN OTHERS =>
								A<=Q1(0);
								B<=Q2(0);
								for i in 3 downto 0 loop
									if(i=3)then
										Q1(i)<='0';
										Q2(i)<='0';
									else
										Q1(i)<=Q1(i+1);
										Q2(i)<=Q2(i+1);
									end if;
								end loop;
					
					END CASE;
			END IF;

	end PROCESS;	

 END a_RegU;