--------------------------------------------------------------------------------
-- Company: 
-- Engineer:
--
-- Create Date:   15:14:49 12/05/2018
-- Design Name:   
-- Module Name:   /home/erick/Documentos/GitHub/Computer-architecture/ESCOMIPS/ESCOMIPS/TB_PROCESADOR.vhd
-- Project Name:  ESCOMIPS
-- Target Device:  
-- Tool versions:  
-- Description:   
-- 
-- VHDL Test Bench Created by ISE for module: PROCESADOR
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
USE ieee.std_logic_1164.ALL;
 
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--USE ieee.numeric_std.ALL;
 
ENTITY TB_PROCESADOR IS
END TB_PROCESADOR;
 
ARCHITECTURE behavior OF TB_PROCESADOR IS 
 
    -- Component Declaration for the Unit Under Test (UUT)
 
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
      -- hold reset state for 100 ns.
      wait for 100 ns;	

      wait for CLK_period*10;

      -- insert stimulus here 

      wait;
   end process;

END;
