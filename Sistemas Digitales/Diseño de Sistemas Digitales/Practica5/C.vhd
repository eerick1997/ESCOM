library ieee;
use ieee.std_logic_1164.all;

entity CONTDEC is port(
	CLR,CLK: in std_logic;
	CONTROL: in std_logic_vector(1 downto 0);
	ent: in std_logic_vector(3 downto 0);
	DISPLAY: inout std_logic_vector(6 downto 0));
end CONTDEC;

architecture a_CONTDEC of CONTDEC is
											------abcdefg
	constant dig0: std_logic_vector(6 downto 0):="0000001";--0
	constant dig1: std_logic_vector(6 downto 0):="1001111";--1
	constant dig2: std_logic_vector(6 downto 0):="0010010";--2
	constant dig3: std_logic_vector(6 downto 0):="0000110";--3
	constant dig4: std_logic_vector(6 downto 0):="1001100";--4
	constant dig5: std_logic_vector(6 downto 0):="0100100";--5
	constant dig6: std_logic_vector(6 downto 0):="0100000";--6
	constant dig7: std_logic_vector(6 downto 0):="0001111";--7
	constant dig8: std_logic_vector(6 downto 0):="0000000";--8
	constant dig9: std_logic_vector(6 downto 0):="0001100";--9

begin

	process(CLR,CLK,CONTROL,DISPLAY)
		begin

			if(CLR='0')then
			DISPLAY<=dig0;
			elsif(CLK'EVENT AND CLK='1')then
				CASE CONTROL is
					WHEN "00" => DISPLAY<=DISPLAY; -- RETIENE DATO
					WHEN "01" => CASE DISPLAY IS	-- CONTEO ASCENDENTE
									WHEN dig0=> DISPLAY<=dig1;
									WHEN dig1=> DISPLAY<=dig2;
									WHEN dig2=> DISPLAY<=dig3;
									WHEN dig3=> DISPLAY<=dig4;
									WHEN dig4=> DISPLAY<=dig5;
									WHEN dig5=> DISPLAY<=dig6;
									WHEN dig6=> DISPLAY<=dig7;
									WHEN dig7=> DISPLAY<=dig8;
									WHEN dig8=> DISPLAY<=dig9;
									WHEN dig9=> DISPLAY<=dig0;
									WHEN OTHERS => DISPLAY<=dig0;
								 END CASE;
					WHEN "10" => CASE DISPLAY IS	-- CONTEO DESCENDENTE
									WHEN dig9=> DISPLAY<=dig8;
									WHEN dig8=> DISPLAY<=dig7;
									WHEN dig7=> DISPLAY<=dig6;
									WHEN dig6=> DISPLAY<=dig5;
									WHEN dig5=> DISPLAY<=dig4;
									WHEN dig4=> DISPLAY<=dig3;
									WHEN dig3=> DISPLAY<=dig2;
									WHEN dig2=> DISPLAY<=dig1;
									WHEN dig1=> DISPLAY<=dig0;
									WHEN dig0=> DISPLAY<=dig9;
									WHEN OTHERS => DISPLAY<=dig0;
								   END CASE;
					WHEN OTHERS => CASE ent is	---CARGA DATO
									WHEN "0000"=> DISPLAY<=dig0;
									WHEN "0001"=> DISPLAY<=dig1;
									WHEN "0010"=> DISPLAY<=dig2;
									WHEN "0011"=> DISPLAY<=dig3;
									WHEN "0100"=> DISPLAY<=dig4;
									WHEN "0101"=> DISPLAY<=dig5;
									WHEN "0110"=> DISPLAY<=dig6;
									WHEN "0111"=> DISPLAY<=dig7;
									WHEN "1000"=> DISPLAY<=dig8;
									WHEN OTHERS => DISPLAY<=dig9;
								   END CASE;
				END CASE;

			end if;
	end process;

end a_CONTDEC;