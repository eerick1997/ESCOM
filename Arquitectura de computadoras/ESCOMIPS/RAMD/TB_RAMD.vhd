--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   17:38:54 10/02/2018
-- Design Name:   
-- Module Name:   /home/erick/Documentos/Software/Xilinx/RAMD/TB_RAMD.vhd
-- Project Name:  RAMD
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: RAMD
-- 
-- Dependencies:
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
--
-- Notes: 
-- This testbench has been automatically generated using types std_logic and
-- std_logic_vector for the ports of the unit under test.  Xilinx recommends
-- that these types always be used for the top-level I/O of a design in order
-- to guarantee that the testbench will bind correctly to the post-implementation 
-- simulation model.
--------------------------------------------------------------------------------
LIBRARY ieee;
LIBRARY STD;
USE STD.TEXTIO.ALL;
USE ieee.std_logic_TEXTIO.ALL;	--PERMITE USAR STD_LOGIC 

USE ieee.std_logic_1164.ALL;
USE ieee.std_logic_UNSIGNED.ALL;
USE ieee.std_logic_ARITH.ALL;
 
ENTITY TB_RAMD IS
END TB_RAMD;
 
ARCHITECTURE behavior OF TB_RAMD IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT RAMD
    PORT(
         DIN : IN  std_logic_vector(15 downto 0);
         ADR : IN  std_logic_vector(7 downto 0);
         CLK : IN  std_logic;
         DOUT : OUT  std_logic_vector(15 downto 0);
         WEN : IN  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal DIN : std_logic_vector(15 downto 0) := (others => '0');
   signal ADR : std_logic_vector(7 downto 0) := (others => '0');
   signal CLK : std_logic := '0';
   signal WEN : std_logic := '0';

 	--Outputs
   signal DOUT : std_logic_vector(15 downto 0);

   -- Clock period definitions
   constant CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: RAMD PORT MAP (
          DIN => DIN,
          ADR => ADR,
          CLK => CLK,
          DOUT => DOUT,
          WEN => WEN
        );

   -- Clock process definitions
   CLK_process :process
   begin
		CLK <= '0';
		wait for CLK_period/2;
		CLK <= '1';
		wait for CLK_period/2;
   end process;
 

   -- Stimulus process
   stim_proc: process
	
	--Archivo donde escribiremos los vectores resultantes
	FILE ARCH_RES : TEXT;
	--Esta variable contiene la línea a escribir en el archivo
	VARIABLE LINEA_RES : LINE;
	--Esta variable será la que tendrá el vaector resultante
	VARIABLE VAR_DOUT : STD_LOGIC_VECTOR (15 DOWNTO 0);
	
	--Archivo donde obtendremos los vectores prueba
	FILE ARCH_VEC : TEXT;
	--Esta variable nos servirá para obtener una línea del vector prueba
	VARIABLE LINEA_VEC : LINE;
	--Esta variable tendrá el valor de la variable DIN
	VARIABLE VAR_DIN : STD_LOGIC_VECTOR (15 DOWNTO 0);
	--Esta variable tendrá el valor de la variable ADR
	VARIABLE VAR_ADR : STD_LOGIC_VECTOR (7 DOWNTO 0);
	--Esta variable tendrá el valor de la variable WEN
	VARIABLE VAR_WEN : STD_LOGIC;
	--Esta variable tendrá almacenada una cadena la cual usaremos para leer
	--el archivo que contiene los vectores de prueba
	VARIABLE CADENA : STRING (1 TO 4);
	
   begin		
		--Abrimos el archivo que contiene los vectores de prueba
		file_open(ARCH_VEC, "vectores.txt", READ_MODE); --Modo lectura
		--Abrimos el archivo que contendra los resultados
		file_open(ARCH_RES, "resultado.txt", WRITE_MODE); --Modo escritura
		
		-------------    ENCABEZADO DE LA TABLA    -------------
		CADENA := "  Di";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "   A";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "  WD"; 	
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "  Do";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		--Añadimos al archivo el encabezado
		writeline(ARCH_RES, LINEA_RES);
      
		WAIT FOR 100 NS;
		
		---- LECTURA EL ARCHIVO CON LOS VECTORES DE PRUEBA ----
		FOR I IN 0 TO 11 LOOP --Tenemos 12 vectores de prueba
			--Leemos una línea completa de nuestro archivo con los vectores prueba
			readline(ARCH_VEC, LINEA_VEC);
			--Leemos lo que contenga la columna en Di
			hread(LINEA_VEC, VAR_DIN);
			DIN <= VAR_DIN;
			--Leemos lo que contenga la columna ADR
			hread(LINEA_VEC, VAR_ADR);
			ADR <= VAR_ADR;
			--Leemos lo que contenga la columna WEN
			read(LINEA_VEC, VAR_WEN);
			WEN <= VAR_WEN;
			
			WAIT UNTIL RISING_EDGE(CLK); --Esperamos al flanco de subida
			
			VAR_DOUT := DOUT;
			--Escribe DIN
			hwrite(LINEA_RES, VAR_DIN, right, 5);
			--Escribe ADR
			hwrite(LINEA_RES, VAR_ADR, right, 5);
			--Escribe WEN
			write(LINEA_RES, VAR_WEN, right, 5);
			--Escribe DOUT
			hwrite(LINEA_RES, VAR_DOUT, right, 5);
			--Escribimos en el archivo res
			writeline(ARCH_RES, LINEA_RES);
			
		END LOOP;
		--Cerramos el archivo de vectores prueba
		file_close(ARCH_VEC);
		--Cerramos el archivo de vectores resultantes
		file_close(ARCH_RES);
		
      wait;
   end process;
END;
