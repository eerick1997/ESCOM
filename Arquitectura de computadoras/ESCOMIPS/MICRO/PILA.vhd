library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity PILA is
	PORT(
		CLK, CLR: IN STD_LOGIC;
		WPC, UP, DW: IN STD_LOGIC;
		D: IN STD_LOGIC_VECTOR(15 DOWNTO 0);
		Q: INOUT STD_LOGIC_VECTOR(15 DOWNTO 0)
	);
end PILA;

architecture PROGRAMA of PILA is
TYPE MEMORIA IS ARRAY (0 TO 15) OF STD_LOGIC_VECTOR(15 DOWNTO 0);
signal reg: memoria;
signal read_data: std_logic_vector(15 downto 0);
signal sp: std_logic_vector(3 downto 0);	
signal in_pc: std_logic_vector(15 downto 0);
begin

	read_data <= reg(conv_integer(sp - 1));
	in_pc <= D when DW = '0' else read_data;

	ram_d: process(CLK)
	begin
		if rising_edge(CLK) then
			if UP = '1' then
				reg(conv_integer(sp)) <= Q + 1;
			end if;
		end if;
	end process ram_d;
	
	stack_pointer: process(clk, clr)
	begin
		if clr = '1' then
			sp <= (others => '0');
		elsif rising_edge(clk) then
			if DW = '1' then
				sp <= sp - 1;
			elsif UP = '1' then
				sp <= sp + 1;
			end if;
		end if;
	end process stack_pointer;
	
	program_counter: process(clk, clr)
	begin
		if clr = '1' then
			Q <= (others => '0');
		elsif rising_edge(clk) then
			if wpc = '1' then
				Q <= in_pc;
			else
				Q <= Q + 1;
			end if;
		end if;
	end process program_counter;
end PROGRAMA;

