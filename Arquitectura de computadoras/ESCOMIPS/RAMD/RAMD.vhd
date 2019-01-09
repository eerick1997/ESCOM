----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date:    11:25:34 09/26/2018 
-- Design Name: 
-- Module Name:    RAMD - Behavioral 
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
--Lectura de archivos

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx primitives in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity RAMD is

	GENERIC(
				BDATA : INTEGER := 16; --Bus de datos
				BADDR : INTEGER := 8	  --Bus de direcciones
				
	);
	
    Port ( DIN : in  STD_LOGIC_VECTOR (BDATA-1 downto 0);
           ADR : in  STD_LOGIC_VECTOR (BADDR-1 downto 0);
           CLK : in  STD_LOGIC;
           DOUT : out  STD_LOGIC_VECTOR (BDATA-1 downto 0);
			  --WRITE ENABLE
           WEN : in  STD_LOGIC);
end RAMD;

architecture Behavioral of RAMD is
--Declaramos nuestro arreglo que se comportará como memoria
--Es decir una memoria es un arreglo de 0 a 2^16 - 1 
--Cada vector está creado de vectores del rango de DOUT
TYPE MEMORIA IS ARRAY (0 TO 2**BADDR - 1) OF STD_LOGIC_VECTOR ( DOUT'RANGE );
--Creamos una señal llamada RAMDIST de tipo memoria
SIGNAL RAMDIST : MEMORIA := ( OTHERS => (OTHERS => '0'));
begin
	--Creamos el proceso PRAM
	--Lista sensitiva CLK no depende del flanco de reloj
	PRAM : PROCESS(CLK)
	BEGIN

		--Si el evento del CLK es un flanco de subida
		--IF (CLK'EVENT AND CLK = '1') THEN -- entonces
		  IF ( RISING_EDGE(CLK) ) THEN
		--Queremos que una operación sea síncrona, entonces escribimos
		--ese código dentro de este if
			--Si el write enable esta activo
			--Lectura síncrona
			IF(WEN = '1') THEN --entonces
				RAMDIST( CONV_INTEGER(ADR) ) <= DIN;
			END IF;
		END IF;
	END PROCESS PRAM;
	
	--Escritura asíncrona
	DOUT <= RAMDIST( CONV_INTEGER(ADR) );
end Behavioral;

