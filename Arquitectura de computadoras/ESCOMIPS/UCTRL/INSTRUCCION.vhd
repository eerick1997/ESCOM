library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity INSTRUCCION is
    Port ( OPCODE : in  STD_LOGIC_VECTOR (4 downto 0);
           TIPOR : out  STD_LOGIC;
           BEQI : out  STD_LOGIC;
           BNEQI : out  STD_LOGIC;
           BLTI : out  STD_LOGIC;
           BLETI : out  STD_LOGIC;
           BGTI : out  STD_LOGIC;
           BGETI : out  STD_LOGIC);
end INSTRUCCION;

architecture DECODIFICADOR of INSTRUCCION is
CONSTANT OP_TIPOR : STD_LOGIC_VECTOR(4 DOWNTO 0) := "00000";
CONSTANT OP_BEQI : STD_LOGIC_VECTOR(4 DOWNTO 0) := "01101";
begin

	TIPOR <= '1' WHEN (OPCODE = OP_TIPOR) 
	ELSE '0';
	BEQI <= '1' WHEN (OPCODE = OP_BEQI)
	ELSE '0';
	---CONTINUARA

end DECODIFICADOR;

