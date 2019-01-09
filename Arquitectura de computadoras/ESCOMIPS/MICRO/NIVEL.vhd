library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity NIVEL is
    Port ( CLK : in  STD_LOGIC;
           CLR : in  STD_LOGIC;
           NA : out  STD_LOGIC
			);
end NIVEL;

architecture DETECTOR of NIVEL is

	signal RE : std_logic;  -- Semiflanco superior 
   signal FE : std_logic;  -- Semiflanco inferior

begin
    PRE : PROCESS(CLK, CLR)
    begin
        if( CLR = '1') then
            RE <= '0';
        elsif (RISING_EDGE(CLK)) then
            RE <= NOT RE;
        end if;
    end PROCESS PRE;
    
    PFE : PROCESS(CLK, CLR)
    begin
        if( CLR = '1') then
            FE <= '0';
        elsif (FALLING_EDGE(CLK)) then
            FE <= NOT FE;
        end if;
    end PROCESS PFE;

    NA <= NOT(RE XOR FE);

end DETECTOR;

