library ieee;
use ieee.std_logic_1164.all;

entity PRAC1 is port(

	A,B,C,D,sel,ref: in std_logic_vector (1 downto 0);
	z1: out std_logic_vector (1 downto 0);
	Display: out std_logic_vector (6 downto 0));
	

end PRAC1;

architecture A_PRAC1 of PRAC1 is
		signal z: std_logic_vector (1 downto 0);
		signal AUX: std_logic_vector (2 downto 0);	----- gfedcba
		constant igual: std_logic_vector (6 downto 0) := "0110111";
		constant mayor: std_logic_vector (6 downto 0) := "0100111";
		constant menor: std_logic_vector (6 downto 0) := "0110011";
begin

	with sel select z <=
 	A when "00",
	B when "01",
	C when "10",
	D when others;

	z1 <=z;

	AUX<=
	"100" when (z=ref) else 
	"010" when (z>ref) else
	"001" when (z<ref) else
	"000";

	Display<=
	igual when AUX="100" else
	mayor when AUX="010" else
	menor when AUX="001" else
	"1111111";

end A_PRAC1;