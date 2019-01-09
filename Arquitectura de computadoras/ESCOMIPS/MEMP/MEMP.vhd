----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    18:29:26 10/07/2018 
-- Design Name: 
-- Module Name:    MEMP - Behavioral 
-- Project Name: 
-- Target Devices: 
-- Tool versions: 
-- Description: 
--
-- Dependencies: 
--
-- Revision: 
-- Revision 0.01 - File Created
-- Additional Comments: 
--
----------------------------------------------------------------------------------
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity MEMP is
	GENERIC(BADDR: INTEGER := 16; 
			  BDATA: INTEGER := 25
			  );
    Port ( A : in  STD_LOGIC_VECTOR (15 downto 0);
           D : out  STD_LOGIC_VECTOR (24 downto 0);
			  CLK : STD_LOGIC
			 );
	
end MEMP;

architecture MEMORIA of MEMP is
--REGISTROS DEL PROCESADOR
CONSTANT R0: STD_LOGIC_VECTOR(3 DOWNTO 0):= "0000";
CONSTANT R1: STD_LOGIC_VECTOR(3 DOWNTO 0):= "0001";
CONSTANT R2: STD_LOGIC_VECTOR(3 DOWNTO 0):= "0010";
CONSTANT R3: STD_LOGIC_VECTOR(3 DOWNTO 0):= "0011";
CONSTANT XX: STD_LOGIC_VECTOR(3 DOWNTO 0):= "0000";
--CONTINUARA
--CODIGOS DE OPERACION DE LAS INSTRUCCIONES
CONSTANT TIPO_R: STD_LOGIC_VECTOR(4 DOWNTO 0):= "00000";
CONSTANT OP_LI	: STD_LOGIC_VECTOR(4 DOWNTO 0):= "00001";
CONSTANT OP_LWI: STD_LOGIC_VECTOR(4 DOWNTO 0):="00010";
CONSTANT OP_SWI: STD_LOGIC_VECTOR(4 DOWNTO 0):= "00011";
CONSTANT OP_B	: STD_LOGIC_VECTOR(4 DOWNTO 0):= "10011";
--CONTINUARA
--CODIGOS DE FUNCION DE LAS INSTRUCCIONES TIPO_R
CONSTANT FUN_ADD: STD_LOGIC_VECTOR(3 DOWNTO 0):= "0000";
CONSTANT FUN_SUB: STD_LOGIC_VECTOR(3 DOWNTO 0):= "0001";
--CONTINUARA
CONSTANT SU: STD_LOGIC_VECTOR(3 DOWNTO 0) := "0000";

TYPE MEMORIA IS ARRAY(0 TO 2** BADDR-1) OF STD_LOGIC_VECTOR(D'RANGE);

CONSTANT MP: MEMORIA := (
		OP_LI		&	R0	&	X"0001", 						--LI RO, #1
		OP_LI		&	R1	&	X"0007", 						--LI RO, #7
		TIPO_R	&	R1	&	R1	&	R0	&	XX	&	FUN_ADD, --CICLO ADD R1, R1, R0
		OP_SWI	&	R1 &	X"0005",							--SWI R1, 5
		OP_B		&	SU & 	X"0002",							--B CICLO
		
		--CONTINUARA
		OTHERS=> (OTHERS => '0')
);


begin
	PROCESS (CLK)
	BEGIN 
	   IF (RISING_EDGE(CLK)) THEN
			D <= MP( CONV_INTEGER(A));
		END IF;
	END PROCESS;
end MEMORIA;