--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   10:17:16 10/18/2018
-- Design Name:   
-- Module Name:   /home/erick/Documentos/Software/Xilinx/ARCHIVO_REGISTROS/TB_ARCHIVO_REGISTROS.vhd
-- Project Name:  ARCHIVO_REGISTROS
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: ARCHIVO_DE_REGISTROS
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
USE ieee.numeric_std.ALL;
 
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY TB_ARCHIVO_REGISTROS IS
END TB_ARCHIVO_REGISTROS;

ARCHITECTURE behavior OF TB_ARCHIVO_REGISTROS IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT ARCHIVO_DE_REGISTROS
    PORT(
         SHAMT : IN  std_logic_vector(3 downto 0);
         DIR : IN  std_logic;
         CLK : IN  std_logic;
         WR : IN  std_logic;
         ADDR_WR : IN  std_logic_vector(3 downto 0);
         ADDR_RD1 : IN  std_logic_vector(3 downto 0);
         ADDR_RD2 : IN  std_logic_vector(3 downto 0);
         WD : IN  std_logic_vector(15 downto 0);
         DINOUT1 : INOUT  std_logic_vector(15 downto 0);
         DOUT2 : OUT  std_logic_vector(15 downto 0);
         SHE : IN  std_logic
        );
    END COMPONENT;
    

   --Inputs
   signal SHAMT : std_logic_vector(3 downto 0) := (others => '0');
   signal DIR : std_logic := '0';
   signal CLK : std_logic := '0';
   signal WR : std_logic := '0';
   signal ADDR_WR : std_logic_vector(3 downto 0) := (others => '0');
   signal ADDR_RD1 : std_logic_vector(3 downto 0) := (others => '0');
   signal ADDR_RD2 : std_logic_vector(3 downto 0) := (others => '0');
   signal WD : std_logic_vector(15 downto 0) := (others => '0');
   signal SHE : std_logic := '0';

	--BiDirs
   signal DINOUT1 : std_logic_vector(15 downto 0);

 	--Outputs
   signal DOUT2 : std_logic_vector(15 downto 0);

   -- Clock period definitions
   constant CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: ARCHIVO_DE_REGISTROS PORT MAP (
          SHAMT => SHAMT,
          DIR => DIR,
          CLK => CLK,
          WR => WR,
          ADDR_WR => ADDR_WR,
          ADDR_RD1 => ADDR_RD1,
          ADDR_RD2 => ADDR_RD2,
          WD => WD,
          DINOUT1 => DINOUT1,
          DOUT2 => DOUT2,
          SHE => SHE
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
	--Archivo con los vectores de prueba
	FILE ARCH_VEC : TEXT;
	--Aquí almacenamos cada línea del archivo
	VARIABLE LINEA_VEC : LINE;
	-----------	VALORES DE ENTRADA ----------
	--READ_REGISTER1
	VARIABLE VAR_ADDR_RD1 : INTEGER;
	--READ_REGISTER2
	VARIABLE VAR_ADDR_RD2 : INTEGER;
	--SHAMT
	VARIABLE VAR_SHAMT : INTEGER;
	--WRITE_REGISTER
	VARIABLE VAR_ADDR_WR : INTEGER;
	--WRITE DATA
	VARIABLE VAR_WD : STD_LOGIC_VECTOR (WD'RANGE);
	--WE
	VARIABLE VAR_WR : STD_LOGIC;
	--SHE
	VARIABLE VAR_SHE : STD_LOGIC;
	--DIR
	VARIABLE VAR_DIR : STD_LOGIC;
	
	--Archivo donde escribiremos el resultado
	FILE ARCH_RES: TEXT;
	--Aquí almacenamos cada línea que vamos a escribir sobre el archivo
	VARIABLE LINEA_RES : LINE;
	-----------	VALORES DE SALIDA ----------
	VARIABLE VAR_DOUT1 : STD_LOGIC_VECTOR (DINOUT1'RANGE);
	VARIABLE VAR_DOUT2 : STD_LOGIC_VECTOR (DOUT2'RANGE);
	
	VARIABLE CADENA : STRING (1 TO 5);
   begin		
		--Abrimos el archivo que contiene los vectores prueba
		file_open(ARCH_VEC, "input.txt", read_mode);
		--Abrimos el archivo que contendrá los resultados
		file_open(ARCH_RES, "output.txt", write_mode);
		--------- ENCABEZADO DE LA TABLA ---------
		CADENA := "  RR1";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "  RR2";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "   SH";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := " WREG";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "   WD";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "   WR";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "  SHE";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "  DIR";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "  RD1";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		CADENA := "  RD2";
		write(LINEA_RES, CADENA, right, CADENA'LENGTH + 1);
		-- AÑADIMOS EL ENCABEZADO AL ARCHIVO
		writeline(ARCH_RES, LINEA_RES);
		
		WAIT FOR 100 NS;
		-- INICIAMOS LA LECTURA DEL ARCHIVO CON LOS VECTORES PRUEBA
		WHILE NOT endfile(ARCH_VEC) LOOP
			--LEEMOS UNA LÍNEA COMPLETA DEL ARCHIVO
			readline(ARCH_VEC, LINEA_VEC);
			--Extraemos los valores dentro del archivo 
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA READ_REGISTER1
			read(LINEA_VEC, VAR_ADDR_RD1);
			ADDR_RD1 <= std_logic_vector(to_unsigned(VAR_ADDR_RD1, ADDR_RD1'LENGTH));
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA READ_REGISTER2
			read(LINEA_VEC, VAR_ADDR_RD2);
			ADDR_RD2 <= std_logic_vector(to_unsigned(VAR_ADDR_RD2, ADDR_RD2'LENGTH));
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA SHAMT
			read(LINEA_VEC, VAR_SHAMT);
			SHAMT <= std_logic_vector(to_unsigned(VAR_SHAMT, SHAMT'LENGTH));
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA WRITE_REGISTER
			read(LINEA_VEC, VAR_ADDR_WR);
			ADDR_WR <= std_logic_vector(to_unsigned(VAR_ADDR_WR, ADDR_WR'LENGTH));
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA WRITE_DATA
			hread(LINEA_VEC, VAR_WD);
			WD <= VAR_WD;
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA WR
			read(LINEA_VEC, VAR_WR);
			WR <= VAR_WR;
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA SHE
			read(LINEA_VEC, VAR_SHE);
			SHE <= VAR_SHE;
			--EXTRAEMOS LO QUE EXISTE EN LA COLUMNA DIR
			read(LINEA_VEC, VAR_DIR);
			DIR <= VAR_DIR;
		
			WAIT UNTIL RISING_EDGE(CLK); --ESPERAMOS AL FLANCO DE SUBIDA
--			VAR_DOUT1 := DINOUT1;
--			VAR_DOUT2 := DOUT2;	
			-- Escribimos el resultado
			--ESCRIBE RR1
			hwrite(LINEA_RES, ADDR_RD1, right, 6);
			--ESCRIBE RR2
			hwrite(LINEA_RES, ADDR_RD2, right, 6);
			--ESCRIBE SH
			hwrite(LINEA_RES, SHAMT, right, 6);
			--ESCRIBE WREG
			hwrite(LINEA_RES, ADDR_WR, right, 6);
			--ESCRIBE WD
			hwrite(LINEA_RES, WD, right, 6);
			--ESCRIBE WR
			write(LINEA_RES, WR, right, 6);
			--ESCRIBE SHE
			write(LINEA_RES, SHE, right, 6);
			--ESCRIBE DIR
			write(LINEA_RES, DIR, right, 6);
			--ESCRIBE RD1
			hwrite(LINEA_RES, DINOUT1, right, 6);
			--ESCRIBE RD2
			hwrite(LINEA_RES, DOUT2, right, 6);
			WRITELINE(ARCH_RES, LINEA_RES);
      END LOOP;
		--CERRAMOS EL ARCHIVO CON LOS VECTORES PRUEBA
		file_close(ARCH_VEC);
		--CERRAMOS EL ARCHIVO CON LOS VECTORES RESULTANTES
		file_close(ARCH_RES);
		wait;
   end process;

END;
