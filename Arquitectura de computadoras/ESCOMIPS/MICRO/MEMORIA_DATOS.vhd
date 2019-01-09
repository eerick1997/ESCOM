library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity MEMORIA_DATOS is
	
	GENERIC(
				BDATA : INTEGER := 16; --Bus de datos
				BADDR : INTEGER := 16	  --Bus de direcciones
				
	);
	
   Port ( 
			 BUS_DATOS_ENTRADA : in  STD_LOGIC_VECTOR  ( BDATA - 1 downto 0);
          BUS_DATOS_SALIDA	 : out  STD_LOGIC_VECTOR ( BDATA - 1 downto 0);
			 ADR : in  STD_LOGIC_VECTOR (BADDR-1 downto 0);
          CLK : in  STD_LOGIC;
		  --WRITE ENABLE
          WD : in  STD_LOGIC
	);
	
end MEMORIA_DATOS;

architecture RAMD of MEMORIA_DATOS is
	
	--Declaramos nuestro arreglo que se comportar como memoria
	--Es decir una memoria es un arreglo de 0 a 2^16 - 1 
	--Cada vector est creado de vectores del rango de BUS_DATOS_SALIDA
	TYPE MEMORIA IS ARRAY (0 TO 2**BADDR - 1) OF STD_LOGIC_VECTOR ( BUS_DATOS_SALIDA'RANGE );
	--Creamos una seal llamada RAMDIST de tipo memoria
	SIGNAL RAMDIST : MEMORIA := ( OTHERS => (OTHERS => '0'));
	
begin
	--Creamos el proceso PRAM
	--Lista sensitiva CLK no depende del flanco de reloj
	PRAM : PROCESS(CLK)
	BEGIN
		--Si el evento del CLK es un flanco de subida
		--IF (CLK'EVENT AND CLK = '1') THEN -- entonces
		  IF ( RISING_EDGE(CLK) ) THEN
		--Queremos que una operacin sea sncrona, entonces escribimos
		--ese cdigo dentro de este if
			--Si el write enable esta activo
			--Lectura sncrona
			IF(WD = '1') THEN --entonces
				RAMDIST( CONV_INTEGER(ADR) ) <= BUS_DATOS_ENTRADA;
			END IF;
		END IF;
	END PROCESS PRAM;
	
	BUS_DATOS_SALIDA <= RAMDIST(CONV_INTEGER(ADR));
	

end RAMD;

