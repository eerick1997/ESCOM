LIBRARY ieee;
use ieee.std_logic_1164.ALL;
use STD.TEXTIO.ALL;
use IEEE.STD_LOGIC_TEXTIO.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;
use IEEE.numeric_std.ALL;
 
ENTITY STACK_T IS
END STACK_T;
 
ARCHITECTURE behavior OF STACK_T IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
    COMPONENT STACK
    PORT(
         CLK : IN  std_logic;
         CLR : IN  std_logic;
         WPC : IN  std_logic;
         UP : IN  std_logic;
         DW : IN  std_logic;
         D : IN  std_logic_vector(15 downto 0);
         STACK_POINTER : INOUT  std_logic_vector(3 downto 0);
         Q : INOUT  std_logic_vector(15 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal CLK : std_logic := '0';
   signal CLR : std_logic := '0';
   signal WPC : std_logic := '0';
   signal UP : std_logic := '0';
   signal DW : std_logic := '0';
   signal D : std_logic_vector(15 downto 0) := (others => '0');

	--BiDirs
   signal STACK_POINTER : std_logic_vector(3 downto 0);
   signal Q : std_logic_vector(15 downto 0);

   -- Clock period definitions
   constant CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: STACK PORT MAP (
          CLK => CLK,
          CLR => CLR,
          WPC => WPC,
          UP => UP,
          DW => DW,
          D => D,
          STACK_POINTER => STACK_POINTER,
          Q => Q
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
	file ARCH_RESULTADO : TEXT;
   file ARCH_ENTRADA : TEXT;
   VARIABLE VAR_D : std_logic_vector(15 downto 0);
   VARIABLE VAR_WPC : std_logic;
   VARIABLE VAR_DW : std_logic;
   VARIABLE VAR_UP : std_logic;
   VARIABLE VAR_CLK : std_logic;
   VARIABLE VAR_CLR : STD_LOGIC;
	VARIABLE VAR_SP : STD_LOGIC_VECTOR(3 DOWNTO 0);
	VARIABLE VAR_Q : STD_LOGIC_VECTOR(15 DOWNTO 0);
   VARIABLE LINEA_ENTRADA : line;
   VARIABLE LINEA_RESULTADO : line;
   VARIABLE CADENA : STRING(1 TO 6);
	
	
   begin		
   
   file_open(ARCH_ENTRADA, "input.txt", READ_MODE);
   file_open(ARCH_RESULTADO, "output.txt", WRITE_MODE);

   CADENA := "  D   ";
   write(LINEA_RESULTADO, CADENA, right, CADENA'LENGTH + 1);
   CADENA := "  UP  ";
   write(LINEA_RESULTADO, CADENA, right, CADENA'LENGTH + 2);
   CADENA := "  DW  ";
   write(LINEA_RESULTADO, CADENA, right, CADENA'LENGTH + 1);
   CADENA := "  WPC ";
   write(LINEA_RESULTADO, CADENA, right, CADENA'LENGTH + 2);
   CADENA := " CLR  ";
   write(LINEA_RESULTADO, CADENA, right, CADENA'LENGTH + 1);
   CADENA := "  SP  ";
   write(LINEA_RESULTADO, CADENA, right, CADENA'LENGTH + 2);
   CADENA := "   Q  ";
   write(LINEA_RESULTADO, CADENA, right, CADENA'LENGTH + 1);
   writeline(ARCH_RESULTADO, LINEA_RESULTADO);
   
	FOR I IN 0 TO 19 loop
	readline(ARCH_ENTRADA, LINEA_ENTRADA);
	HREAD(LINEA_ENTRADA, VAR_D);
	D <= VAR_D;
	READ(LINEA_ENTRADA, VAR_UP);
	UP <= VAR_UP;
	READ(LINEA_ENTRADA, VAR_DW);
	DW <= VAR_DW;
	READ(LINEA_ENTRADA, VAR_WPC);
	WPC <= VAR_WPC;
	READ(LINEA_ENTRADA, VAR_CLR);
	CLR <= VAR_CLR;
	
	WAIT UNTIL RISING_EDGE(CLK);
   --WAIT FOR 100NS;
	
	VAR_Q := Q;
	VAR_SP := STACK_POINTER;
	Hwrite(LINEA_RESULTADO, VAR_D, right, 6);
   write(LINEA_RESULTADO, VAR_UP, right, 6);
   write(LINEA_RESULTADO, VAR_DW, right, 7);
   write(LINEA_RESULTADO, VAR_WPC, right, 8);
	write(LINEA_RESULTADO, VAR_CLR, right, 7);
   write(LINEA_RESULTADO, VAR_SP, right, 9);
   Hwrite(LINEA_RESULTADO, VAR_Q, right, 8);
	writeline(ARCH_RESULTADO, LINEA_RESULTADO);

   end loop;
   file_close(ARCH_ENTRADA);
   file_close(ARCH_RESULTADO);


      wait;
   end process;

END;
