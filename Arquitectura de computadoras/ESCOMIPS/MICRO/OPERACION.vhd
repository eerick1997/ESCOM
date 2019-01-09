library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity OPERACION is

	 generic (	BUS_DIR : integer := 5;
					BUS_DAT : integer := 20
				);
	
    Port ( A : in   STD_LOGIC_VECTOR ( BUS_DIR - 1 downto 0);	-- Bus de direccion
           D : out  STD_LOGIC_VECTOR ( BUS_DAT - 1 downto 0) 	-- Bus de datos
			);
			
end OPERACION;

architecture MEMORY of OPERACION is

	-- Memoria de microcodigo del codigo de operacion (OPCODE)
	
	--Instrucciones de carga y almacenamiento
	constant COMUN	: std_logic_vector( BUS_DAT - 1 downto 0) := "00001000010000111000";	-- 00
	constant LI		: std_logic_vector( BUS_DAT - 1 downto 0) := "00000000100000000000";	-- 01
	constant LWI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100100000000100";	-- 02
	constant LW		: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100101010011000";	-- 23
	constant SWI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00001000000000000110";	-- 03
	constant SW		: std_logic_vector( BUS_DAT - 1 downto 0) := "00001000011010011010";	-- 04
	
	-- Instrucciones aritmeticas
	constant ADDI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110010011001";	-- 05
	constant SUBI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110010111001";	-- 06
	
	-- Instrucciones logicas
	constant ANDI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110010000001";	-- 07
	constant ORI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110010001001";	-- 08
	constant XORI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110010010001";	-- 09
	constant NANDI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110011101001";	-- 10
	constant NORI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110011100001";	-- 11
	constant XNORI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000100110010110001";	-- 12
	
	-- Instrucciones de saltos condicionales e incondicionales
	constant BEQI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00110000010110011001";	-- 13
	constant BNEI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00110000010110011001";	-- 14
	constant BLTI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00110000010110011001";	-- 15
	constant BLETI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00110000010110011001";	-- 16
	constant BGTI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00110000010110011001";	-- 17
	constant BGETI	: std_logic_vector( BUS_DAT - 1 downto 0) := "00110000010110011001";	-- 18
	
	-- Instrucciones de manejo de subrutinas y otras instrucciones
	constant B		: std_logic_vector( BUS_DAT - 1 downto 0) := "00100000000000000000";	-- 19
	constant CALL	: std_logic_vector( BUS_DAT - 1 downto 0) := "10100000000000000000";	-- 20
	constant RET	: std_logic_vector( BUS_DAT - 1 downto 0) := "01000000000000000000";	-- 21
	constant NOP	: std_logic_vector( BUS_DAT - 1 downto 0) := "00000000000000000000";	-- 22
	
	type MEMORY is array (0 to 2**BUS_DIR) of std_logic_vector(BUS_DAT - 1 downto 0);

   constant MEM_OPER : MEMORY := (
				COMUN,	-- 00 : COMUN
				LI, 	-- 01 : LI
				LWI,	-- 02 : LWI
				SWI,	-- 03 : SWI
				SW, 	-- 04 : SW
				ADDI, 	-- 05 : ADDI
				SUBI, 	-- 06 : SUBI
				ANDI, 	-- 07 : ANDI
				ORI, 	-- 08 : ORI
				XORI, 	-- 09 : XORI
				NANDI, 	-- 10 : NANDI
				NORI, 	-- 11 : NORI
				XNORI, 	-- 12 : XNORI
				BEQI, 	-- 13 : BEQI
				BNEI, 	-- 14 : BNEI
				BLTI, 	-- 15 : BLTI
				BLETI, 	-- 16 : BLETI
				BGTI, 	-- 17 : BGTI
				BGETI, 	-- 18 : BGETI
				B, 		-- 19 : B
				CALL, 	-- 20 : CALL
				RET, 	-- 21 : RET
				NOP, 	-- 22 : NOP
				LW, 	-- 23 : LW
        		others => (others =>'0')
    );
	 
begin
	PROCESS(A)
	BEGIN
		D <= MEM_OPER(CONV_INTEGER(A));
	END PROCESS;
--	D <=	MEM_OPER(0)  when A = "00000" else
--         MEM_OPER(1)  when A = "00001" else
--         MEM_OPER(2)  when A = "00010" else
--         MEM_OPER(3)  when A = "00011" else
--         MEM_OPER(4)  when A = "00100" else
--         MEM_OPER(5)  when A = "00101" else
--         MEM_OPER(6)  when A = "00110" else
--         MEM_OPER(7)  when A = "00111" else
--         MEM_OPER(8)  when A = "01000" else
--         MEM_OPER(9)  when A = "01001" else
--         MEM_OPER(10) when A = "01010" else
--         MEM_OPER(11) when A = "01011" else
--         MEM_OPER(12) when A = "01100" else
--         MEM_OPER(13) when A = "01101" else
--         MEM_OPER(14) when A = "01110" else
--         MEM_OPER(15) when A = "01111" else
--         MEM_OPER(16) when A = "10000" else
--         MEM_OPER(17) when A = "10001" else
--         MEM_OPER(18) when A = "10010" else
--         MEM_OPER(19) when A = "10011" else
--         MEM_OPER(20) when A = "10100" else
--         MEM_OPER(21) when A = "10101" else
--         MEM_OPER(22) when A = "10110" else
--         MEM_OPER(23) when A = "10111" else
--         MEM_OPER(24);
	

end MEMORY;

