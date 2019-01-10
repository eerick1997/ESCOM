library ieee;
use ieee.std_logic_1164.all;

entity teclado is port(
	F: in std_logic_vector(3 downto 0);
	CLK, CLR: in std_logic;
	c: inout std_logic_vector(2 downto 0);
	display: inout std_logic_vector(6 downto 0));
end teclado;

architecture a_teclado of teclado is
constant dig0: std_logic_vector(6 downto 0):= "0000001";
constant dig1: std_logic_vector(6 downto 0):= "1001111";
constant dig2: std_logic_vector(6 downto 0):= "0010010";
constant dig3: std_logic_vector(6 downto 0):= "0000110";
constant dig4: std_logic_vector(6 downto 0):= "1001100";
constant dig5: std_logic_vector(6 downto 0):= "0100100";
constant dig6: std_logic_vector(6 downto 0):= "0100000";
constant dig7: std_logic_vector(6 downto 0):= "0001110";
constant dig8: std_logic_vector(6 downto 0):= "0000000";
constant dig9: std_logic_vector(6 downto 0):= "0001100";
constant digH: std_logic_vector(6 downto 0):= "1001000";
constant digA: std_logic_vector(6 downto 0):= "0001000";
constant NP: std_logic_vector(6 downto 0):= "1111111";


constant F0: std_logic_vector(3 downto 0):="1101";
constant F1: std_logic_vector(3 downto 0):="1011";
constant F2: std_logic_vector(3 downto 0):="0111";
constant F3: std_logic_vector(3 downto 0):="1111";


constant C0: std_logic_vector(2 downto 0):="110";
constant C1: std_logic_vector(2 downto 0):="101";
constant C2: std_logic_vector(2 downto 0):="011";

signal Aux: std_logic_vector(6 downto 0);
begin

	DECO: process(F, C) begin
		CASE F & C is
			WHEN (F0)&(C0) => Aux <= dig6;
			WHEN (F0)&(C1) => Aux <= dig5; 
			WHEN (F0)&(C2) => Aux <= dig4;
			WHEN (F1)&(C0) => Aux <= dig9;
			WHEN (F1)&(C1) => Aux <= dig8; 
			WHEN (F1)&(C2) => Aux <= dig7;
			WHEN (F2)&(C0) => Aux <= diga;
			WHEN (F2)&(C1) => Aux <= dig0; 
			WHEN (F2)&(C2) => Aux <= digH;
			WHEN (F3)&(C0) => Aux <= dig3;
			WHEN (F3)&(C1) => Aux <= dig2; 
			WHEN (F3)&(C2) => Aux <= dig1;

			WHEN OTHERS => Aux <= NP;
		END CASE;
	END process DECO;

		ANILLO: process(CLK, CLR) begin
			if(CLR = '0') THEN
				C <= "110";
			elsif(CLK'EVENT AND CLK = '1') THEN
				C <= std_logic_vector(BIT_VECTOR(C) ROR 1);
			end if;
		END process ANILLO;

		REG: process(CLK, CLR, F) begin
			if(CLR = '0') THEN
				display <= NP;
			elsif(CLK'EVENT AND CLK = '1') THEN
				if(F = F3) THEN
					display <= display;
				else
					display <= Aux;
				end if;
			 end if;
		end process REG;
end a_teclado;
