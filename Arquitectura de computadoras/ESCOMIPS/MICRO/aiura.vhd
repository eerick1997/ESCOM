LIBRARY ieee;
USE ieee.std_logic_1164.ALL;
 
ENTITY aiura IS
END aiura;
 
ARCHITECTURE behavior OF aiura IS 
 
    COMPONENT PROCESADOR
    PORT(
         CLK : IN  std_logic;
         CLR : IN  std_logic;
         DATAIN : OUT  std_logic_vector(15 downto 0)
        );
    END COMPONENT;
    

   --Inputs
   signal CLK : std_logic := '0';
   signal CLR : std_logic := '0';

 	--Outputs
   signal DATAIN : std_logic_vector(15 downto 0);

   -- Clock period definitions
   constant CLK_period : time := 10 ns;
 
BEGIN
 
	-- Instantiate the Unit Under Test (UUT)
   uut: PROCESADOR PORT MAP (
          CLK => CLK,
          CLR => CLR,
          DATAIN => DATAIN
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
   begin		

      CLR <= '1';
		wait until rising_edge(CLK);
		CLR <= '0';
		for i in 1 to 50 LOOP
			wait until rising_edge(CLK);
		end LOOP;
      wait;
   end process;

END;
