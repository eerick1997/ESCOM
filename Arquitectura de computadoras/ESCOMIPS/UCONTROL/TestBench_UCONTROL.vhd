LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
USE ieee.std_logic_UNSIGNED.ALL;
USE STD.TEXTIO.ALL;
USE ieee.std_logic_ARITH.ALL;
USE ieee.std_logic_TEXTIO.ALL;
 
ENTITY TestBench_UCONTROL IS
END TestBench_UCONTROL;
 
ARCHITECTURE behavior OF TestBench_UCONTROL IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT PRINCIPAL
    PORT(
         FUNCODE : IN  std_logic_vector(3 downto 0);
         OPCODE : IN  std_logic_vector(4 downto 0);
         BANDERAS : IN  std_logic_vector(3 downto 0);
         CLR : IN  std_logic;
         CLK : IN  std_logic;
         LF : IN  std_logic;
         MICRO : OUT  std_logic_vector(19 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal FUNCODE : std_logic_vector(3 downto 0) := (others => '0');
   signal OPCODE : std_logic_vector(4 downto 0) := (others => '0');
   signal BANDERAS : std_logic_vector(3 downto 0) := (others => '0');
   signal CLR : std_logic := '0';
   signal CLK : std_logic := '0';
   signal LF : std_logic := '0';

 	--Outputs
   signal MICRO : std_logic_vector(19 downto 0);

   -- Clock period definitions
   constant CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: PRINCIPAL PORT MAP (
          FUNCODE => FUNCODE,
          OPCODE => OPCODE,
          BANDERAS => BANDERAS,
          CLR => CLR,
          CLK => CLK,
          LF => LF,
          MICRO => MICRO
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
	FILE ARCH_RESULTADO: TEXT;
	FILE ARCH_ENTRADA: TEXT;
	VARIABLE VAR_OP_CODE: STD_LOGIC_VECTOR(4 DOWNTO 0);
	VARIABLE VAR_FUN_CODE: STD_LOGIC_VECTOR (3 DOWNTO 0);
	VARIABLE VAR_BANDERAS: STD_LOGIC_VECTOR(3 DOWNTO 0);
	VARIABLE	VAR_CLR: STD_LOGIC;
	VARIABLE VAR_LF: STD_LOGIC;
	VARIABLE VAR_MICRO: STD_LOGIC_VECTOR(19 DOWNTO 0);
	
	VARIABLE LINEA_ENTRADA: line;
	VARIABLE LINEA_RESULTADO: line;
	VARIABLE CADENA: STRING(1 TO 8);
	--VARIABLE VAR_NIVEL;
	
   begin		
      file_open(ARCH_ENTRADA, "input.txt", READ_MODE);
		file_open(ARCH_RESULTADO, "output.txt", WRITE_MODE);
		
		wait for 100 NS;
		
		CADENA := " OP_CODE";
		write(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH+1);
		CADENA := "FUN_CODE";
		write(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH+2);
		CADENA := "BANDERAS";
		write(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH+3);
		CADENA := "     CLR";
		write(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH);
		CADENA := "      LF";
		write(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH);
		CADENA := "MICROINS";
		write(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH+4);
		CADENA := "   NIVEL";
		write(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH+10);
		writeline(ARCH_RESULTADO, LINEA_RESULTADO);
		ciclo: FOR I IN 0 TO 51 LOOP
			readline(ARCH_ENTRADA, LINEA_ENTRADA);
			
			read(LINEA_ENTRADA, VAR_OP_CODE);
			OPCODE <= VAR_OP_CODE;
			
			read(LINEA_ENTRADA, VAR_FUN_CODE);
			FUNCODE <= VAR_FUN_CODE;
			
			read(LINEA_ENTRADA, VAR_BANDERAS);
			BANDERAS <= VAR_BANDERAS;
			
			read(LINEA_ENTRADA, VAR_CLR);
			CLR <= VAR_CLR;
			
			read(LINEA_ENTRADA, VAR_LF);
			LF <= VAR_LF;
			
			WAIT UNTIL FALLING_EDGE(CLK); --ESPERAMOS FLANCO DE BAJADA
			VAR_MICRO := MICRO;
			
			write(LINEA_RESULTADO, VAR_OP_CODE, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_FUN_CODE, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_BANDERAS, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_CLR, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_LF, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_MICRO, RIGHT, CADENA'LENGTH+15);
			CADENA := "    ALTO";
			
			WRITE(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH+1);
			WRITELINE(ARCH_RESULTADO, LINEA_RESULTADO);
			
			WAIT UNTIL RISING_EDGE(CLK); --ESPERAMOS FLANCO DE SUBIDA
			VAR_MICRO := MICRO;
			
			write(LINEA_RESULTADO, VAR_OP_CODE, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_FUN_CODE, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_BANDERAS, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_CLR, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_LF, RIGHT, CADENA'LENGTH+1);
			write(LINEA_RESULTADO, VAR_MICRO, RIGHT, CADENA'LENGTH+15);
			CADENA := "    BAJO";
			
			WRITE(LINEA_RESULTADO, CADENA, RIGHT, CADENA'LENGTH+1);
			WRITELINE(ARCH_RESULTADO, LINEA_RESULTADO);
		END LOOP;
		
		FILE_CLOSE(ARCH_ENTRADA);
		FILE_CLOSE(ARCH_RESULTADO);
      wait;
   end process;

END;
