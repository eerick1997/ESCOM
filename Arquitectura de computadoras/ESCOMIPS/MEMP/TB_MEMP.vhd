--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   21:57:09 10/07/2018
-- Design Name:   
-- Module Name:   /home/erick/Documentos/Software/Xilinx/MEMP/TB_MEMP.vhd
-- Project Name:  MEMP
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: MEMP
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
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY TB_MEMP IS
END TB_MEMP;
 
ARCHITECTURE behavior OF TB_MEMP IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT MEMP
    PORT(
         A : IN  std_logic_vector(15 downto 0);
         D : OUT  std_logic_vector(24 downto 0);
         CLK : IN  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal A : std_logic_vector(15 downto 0) := (others => '0');
   signal CLK : std_logic := '0';

 	--Outputs
   signal D : std_logic_vector(24 downto 0);

   -- Clock period definitions
   constant CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: MEMP PORT MAP (
          A => A,
          D => D,
          CLK => CLK
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
	--Variable que usaremos para escribir sobre el archivo
	VARIABLE LINEA_RES : LINE;
	--Variable que tiene el vector resultante
	VARIABLE VAR_D : STD_LOGIC_VECTOR (24 DOWNTO 0);
	
	--Archivo que contiene los vectores prueba
	FILE ARCH_VEC : TEXT;
	--Variable que usaremos para obtener linea a linea información del archivo
	VARIABLE LINEA_VEC : LINE;
	--Variable que usaremos para leer la señal de entrada A
	VARIABLE VAR_A : STD_LOGIC_VECTOR (15 DOWNTO 0);
	--Esta variable la usaremos para escribir los encabezados
	--del archido que tendra el valor de los vectores resultantes
	VARIABLE CADENA : STRING (1 TO 6);
	
   begin		
	
		--Abrimos el archivo que tiene los vectores prueba
		file_open(ARCH_VEC, "vectores.txt", READ_MODE); --Abrimos el archivo en modo lectura
		--Abrimos el archivo que tendrá el resultado
		file_open(ARCH_RES, "resultado.txt", WRITE_MODE); --Abrimos el archivo en modo escritura
		
		-------------	ENCABEZADO DE LA TABLA --------------
		CADENA := "     A";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "OPCODE";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "19..16";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "15..12";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := " 11..8";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "  7..4";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		CADENA := "  3..0";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH+1);
		--Escribimoe el encabezado en el archivo
		writeline(ARCH_RES, LINEA_RES);
      -- hold reset state for 100 ns.
      wait for 100 ns;	

		FOR I IN 0 TO 6 LOOP --Leemos 7 vectores prueba
			--Leemos una línea completa del archivo 
			readline(ARCH_VEC, LINEA_VEC);
			
			hread(LINEA_VEC, VAR_A);
			A <= VAR_A;
			
			WAIT UNTIL RISING_EDGE(CLK); --Esperamos el flanco de subida
			
			VAR_D := D;
			--Escribimos A
			hwrite(LINEA_RES, VAR_A, right, 7);
			--Escribimos OPCODE
			write(LINEA_RES, VAR_D(24 DOWNTO 20),right, 7);
			--Escribimos los bits 19..16
			write(LINEA_RES, VAR_D(19 DOWNTO 16) ,right, 7);
			--Escribimos los bits 15..12
			write(LINEA_RES, VAR_D(15 DOWNTO 12),right, 7);
			--Escribimos los bits 11..8
			write(LINEA_RES, VAR_D(11 DOWNTO 8),right, 7);
			--Escribimos los bits 7..4
			write(LINEA_RES, VAR_D(7 DOWNTO 4),right, 7);
			--Escribimos los bits 3..0
			write(LINEA_RES, VAR_D(3 DOWNTO 0),right, 7);
			--Escribimos el resultado en el archivo
			writeline(ARCH_RES, LINEA_RES);
			
		END LOOP;
		--Cerramos el archivo del cual leímos 
		file_close(ARCH_VEC);
		--Cerramos el archivo del resultado
		file_close(ARCH_RES);
      wait;
   end process;

END;
