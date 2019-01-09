library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity FUNCION is
	 generic(
			BUS_DIR : integer := 4;
			BUS_DAT : integer := 20
	 );
	
    Port ( A : in   STD_LOGIC_VECTOR ( BUS_DIR - 1 downto 0);	-- Bus de direccion
           D : out  STD_LOGIC_VECTOR ( BUS_DAT - 1 downto 0) 	-- Bus de datos
			);
end FUNCION;

architecture MEMORY of FUNCION is
	
	-- Memoria de microcodigo de funciones.
	constant ADD	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110000011001";	-- 00
	constant SUB	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110000111001";	-- 01
	constant myAND	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110000000001";	-- 02
	constant myOR	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110000001001";	-- 03
	constant myXOR	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110000010001";	-- 04
	constant myNAND : std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110001101001";	-- 05
	constant myNOR	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110001100001";	-- 06
	constant myXNOR : std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110000110001";	-- 07
	constant myNOT	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110001101001";	-- 08
	constant mySLL	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000011100000000000";	-- 09
	constant mySRL	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000010100000000000";	-- 10
	
	type ROM is array (0 to 2**BUS_DIR-1) of std_logic_vector(BUS_DAT - 1 downto 0);
   constant MEM_FUN : ROM := (
        ADD,  		-- 00 : ADD
        SUB,		-- 01 : SUB
        myAND,		-- 02 : AND
        myOR ,		-- 03 : OR
        myXOR,		-- 04 : XOR
        myNAND,	-- 05 : NAND
        myNOR,		-- 06 : NOR
        myXNOR,	-- 07 : XNOR
        myNOT,		-- 08 : NOT
        mySLL,		-- 09 : SLL 
        mySRL,		-- 10 : SRL
        OTHERS => (OTHERS => '0')
    );
	
begin
	
	PROCESS(A)
		BEGIN
			D <= MEM_FUN(CONV_INTEGER(A));
	END PROCESS;
	
--	D <= 	MEM_FUN(0)  when A = "0000" else
--         MEM_FUN(1)  when A = "0001" else
--         MEM_FUN(2)  when A = "0010" else
--         MEM_FUN(3)  when A = "0011" else
--         MEM_FUN(4)  when A = "0100" else
--         MEM_FUN(5)  when A = "0101" else
--         MEM_FUN(6)  when A = "0110" else
--         MEM_FUN(7)  when A = "0111" else
--         MEM_FUN(8)  when A = "1000" else
--         MEM_FUN(9)  when A = "1001" else
--         MEM_FUN(10) when A = "1010" else
--         MEM_FUN(11) when A = "1011" else
--         MEM_FUN(12);

end MEMORY;

