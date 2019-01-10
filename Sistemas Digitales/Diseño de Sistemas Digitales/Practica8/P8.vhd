library ieee;
use ieee.std_logic_1164.all;

entity CONTDEC is port(
	CLR,CLK: in std_logic;
	F: in std_logic_vector(3 downto 0);
	C: inout std_logic_vector(2 downto 0);
	DISPLAY: inout std_logic_vector(6 downto 0));
end CONTDEC;

architecture a_CONTDEC of CONTDEC is
											------abcdefg
	constant dig0: std_logic_vector(6 downto 0):="0000001";--0
	constant dig1: std_logic_vector(6 downto 0):="1001111";--1
	constant dig2: std_logic_vector(6 downto 0):="0011010";--2
	constant dig3: std_logic_vector(6 downto 0):="0000110";--3
	constant dig4: std_logic_vector(6 downto 0):="1001100";--4
	constant dig5: std_logic_vector(6 downto 0):="0100100";--5
	constant dig6: std_logic_vector(6 downto 0):="0100000";--6
	constant dig7: std_logic_vector(6 downto 0):="0001111";--7
	constant dig8: std_logic_vector(6 downto 0):="0000000";--8
	constant dig9: std_logic_vector(6 downto 0):="0001100";--9
	constant GATO: std_logic_vector(6 downto 0):="1001000";--#
	constant ASTE: std_logic_vector(6 downto 0):="1001110";--*
	constant NP: std_logic_vector(6 downto 0):="1111111";--*

	SIGNAL AUX: std_logic_vector(6 downto 0);

	begin
	

	process(F,C)
		begin
			CASE F&C is
				WHEN "1110" & "011" => AUX<=dig1;
				WHEN "1110" & "101" => AUX<=dig2;
				WHEN "1110" & "110" => AUX<=dig3;
			   	WHEN "1101" & "011" => AUX<=dig4;
				WHEN "1101" & "101" => AUX<=dig5;
				WHEN "1101" & "110" => AUX<=dig6;
				WHEN "1011" & "011" => AUX<=dig7;
				WHEN "1011" & "101" => AUX<=dig8;
				WHEN "1011" & "110" => AUX<=dig9;
				WHEN "0111" & "011" => AUX<=GATO;
				WHEN "0111" & "101" => AUX<=dig0;
				WHEN "0111" & "110" => AUX<=ASTE;
				WHEN OTHERS =>AUX<=NP;
			end CASE;
	end process;

	process(CLK,CLR)
		begin
			if(CLR='0') then
			C<="110";
		   	elsif(CLK'EVENT AND CLK='1')then
			C<=std_logic_vector(bit_vector(C) ROR 1);
			end if;
	end process;

	process(CLK,CLR,AUX,F,DISPLAY)
		begin
			if(CLR='0') then
			DISPLAY<=NP;
		   	elsif(CLK'EVENT AND CLK='1')then
				if(F="1111")then
				DISPLAY<=DISPLAY;
				else
				DISPLAY<=AUX;
				end if;
			end if;
	end process;

end a_CONTDEC;