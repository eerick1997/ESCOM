library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity INSTRUCCION is
    Port ( OPCODE : in  STD_LOGIC_VECTOR (4 downto 0);
           TIPOR  : out  STD_LOGIC;
           BEQI   : out  STD_LOGIC;
           BNEQI  : out  STD_LOGIC;
           BLTI   : out  STD_LOGIC;
           BLETI  : out  STD_LOGIC;
           BGTI   : out  STD_LOGIC;
           BGETI  : out  STD_LOGIC
			);
end INSTRUCCION;

architecture DECODIFICADOR of INSTRUCCION is
	
	constant OP_TIPOR : std_logic_vector( 4 downto 0) := "00000";  -- 0
   constant OP_BEQI  : std_logic_vector( 4 downto 0) := "01101";  -- 13
   constant OP_BNEQI : std_logic_vector( 4 downto 0) := "01110";  -- 14
   constant OP_BLTI  : std_logic_vector( 4 downto 0) := "01111";  -- 15
   constant OP_BLETI : std_logic_vector( 4 downto 0) := "10000";  -- 16
   constant OP_BGTI  : std_logic_vector( 4 downto 0) := "10001";  -- 17
   constant OP_BGETI : std_logic_vector( 4 downto 0) := "10010";  -- 18
		
begin

	TIPOR <= '1' when ( OPCODE = OP_TIPOR ) else '0';
   BEQI  <= '1' when ( OPCODE = OP_BEQI )  else '0';
   BNEQI <= '1' when ( OPCODE = OP_BNEQI ) else '0';
   BLTI  <= '1' when ( OPCODE = OP_BLTI )  else '0';
   BLETI <= '1' when ( OPCODE = OP_BLETI ) else '0';
   BGTI  <= '1' when ( OPCODE = OP_BGTI )  else '0';
   BGETI <= '1' when ( OPCODE = OP_BGETI ) else '0';

end DECODIFICADOR;

