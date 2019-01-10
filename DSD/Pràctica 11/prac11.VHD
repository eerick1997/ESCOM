library ieee;
use ieee.std_logic_1164.all;

entity IPN is port(

	salida: out std_logic_vector (2 downto 0);
	display: inout std_logic_vector (6 downto 0);
	clr, clk: in std_logic;


);
end entity;

architecture A_IPN of IPN is 
constant digI = std_logic_vector (6 downto 0): = "1001111";
constant digP = std_logic_vector (6 downto 0): = "0011100";
constant digN = std_logic_vector (6 downto 0): = "1101010";

signal aux: std_logic_ vector (2 downto 0);

BEGIN

	anillo: PROCESS(aux, salida, clr, clk) BEGIN
		

		if(clr = '0')
			display <= "1111111";
		elsif(clk'event AND clk = '1') then
			aux <= std_logic_vector(bitvector(aux) ROR 1);
		end if;		

	end PROCESS anillo;
	
	motrar: PROCESS(display, aux) BEGIN
		if(aux = "011") then
			display <= digI;
		elsif(aux = "101") then
			display <= digN;
		elsif(aux = "110") then
			display <= digP;
		else 
			display <= display;
		end if;
	end PROCESS mostrar;
end A_IPN
