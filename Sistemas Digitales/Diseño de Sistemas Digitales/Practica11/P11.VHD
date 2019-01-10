library ieee;
use ieee.std_logic_1164.all;

entity DIS is port(
	CLR,CLK: in std_logic;
	CONMUTA: inout std_logic_vector(2 downto 0):="011";
	DISPLAY: out std_logic_vector(6 downto 0)
	);
end dis;

architecture a_DIS of DIS is					  --abcdefg
	constant letraI: std_logic_vector(6 downto 0):="1001111";--I
	constant letraP: std_logic_vector(6 downto 0):="0011000";--P
	constant letraN: std_logic_vector(6 downto 0):="1101010";--N
begin
	
	PROCESS(CONMUTA)
	BEGIN
		CASE CONMUTA IS
			WHEN "011" => DISPLAY <= letraI;
			WHEN "101" => DISPLAY <= letraP;
			WHEN OTHERS => DISPLAY <= letraN;
		END CASE;
	END PROCESS;


	PROCESS(CLR,CLK)
	BEGIN
		IF(CLR='0')THEN
			CONMUTA<="011";
		ELSIF(CLK'EVENT AND CLK='1')THEN
			CONMUTA<=std_logic_vector(bit_vector(CONMUTA) ROR 1);
		END IF;
	END PROCESS;

end a_DIS;
