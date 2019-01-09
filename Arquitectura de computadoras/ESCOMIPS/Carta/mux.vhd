library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity mux is
	Port (	aux : in  STD_LOGIC_VECTOR (6 downto 0);
				--DEC
				ec : in  STD_LOGIC;
				--Salida al display
				display : out  STD_LOGIC_VECTOR (6 downto 0)
			);
end mux;

architecture Behavioral of mux is
	constant guion : std_logic_vector(6 downto 0) := "1111110";
begin
	with ec select display <= guion when '0', aux when others;
end Behavioral;

