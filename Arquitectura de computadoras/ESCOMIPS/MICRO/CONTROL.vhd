library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity CONTROL is
    Port ( CLK : in  STD_LOGIC;
           CLR : in  STD_LOGIC;

           TIPOR : in  STD_LOGIC;
           BEQ : in  STD_LOGIC;	-- BEQI
           BNEQ : in  STD_LOGIC;	-- BNEQI
           BLT : in  STD_LOGIC;	-- BLTI
           BLE : in  STD_LOGIC;	-- BLETI
           BGT : in  STD_LOGIC;	-- BGTI
           BGET : in  STD_LOGIC; -- BGETI
			  
           EQ : in  STD_LOGIC;
           NEQ : in  STD_LOGIC;
           G : in  STD_LOGIC;	-- GT
           GET : in  STD_LOGIC;	
           LT : in  STD_LOGIC;
           LE : in  STD_LOGIC;	-- LET
           
			  NA : in  STD_LOGIC;
           SDOPC : out  STD_LOGIC;
           SM : out STD_LOGIC
			);
end CONTROL;

architecture UNIDAD of CONTROL is
	
	TYPE ESTADOS IS(A);
	SIGNAL EDO_ACT, EDO_SIG: ESTADOS;
	
begin
	
	AUTOMATA : PROCESS(TIPOR,BEQ,BNEQ,BLT,BLE,BGT,BGET,NA,EQ,NEQ,LT,LE,G,GET,EDO_ACT)
	BEGIN
SDOPC <= '0';
		SM <= '0';
		case EDO_ACT is
			when a =>
				if TIPOR = '1' then
					SM <= '0';
				else
					if BEQ = '1' then
						if NA = '1' or EQ = '0' then
							SDOPC <= '0';
							SM <= '1';
						else
							SDOPC <= '1';
							SM <= '1';
						end if;
					elsif BNEQ = '1' then
						if NA = '1' or NEQ = '0' then
							SDOPC <= '0';
							SM <= '1';
						else
							SDOPC <= '1';
							SM <= '1';
						end if;
					elsif BLT = '1' then
						if NA = '1' or LT = '0' then
							SDOPC <= '0';
							SM <= '1';
						else
							SDOPC <= '1';
							SM <= '1';
						end if;
					elsif BLE = '1' then
						if NA = '1' or LE = '0' then
							SDOPC <= '0';
							SM <= '1';
						else
							SDOPC <= '1';
							SM <= '1';
						end if;
					elsif BGT = '1' then
						if NA = '1' or G = '0' then
							SDOPC <= '0';
							SM <= '1';
						else
							SDOPC <= '1';
							SM <= '1';
						end if;
					elsif BGET = '1' then
						if NA = '1' or GET = '0' then
							SDOPC <= '0';
							SM <= '1';
						else
							SDOPC <= '1';
							SM <= '1';
						end if;
					else
						SDOPC <= '1';
						SM <= '1';
					end if;
				end if;
				EDO_SIG <= a;
		end case;
	END PROCESS AUTOMATA;
	
	TRANSICION: PROCESS(CLK, CLR)
	BEGIN
		IF(CLR='1') THEN
			EDO_ACT <= A;
		ELSIF(RISING_EDGE(CLK)) THEN
			EDO_ACT <= EDO_SIG;
		END IF;
	END PROCESS TRANSICION;
	
	
end UNIDAD;

