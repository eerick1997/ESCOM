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
		SM 	<= '0';
		SDOPC <= '0';
		CASE( EDO_ACT ) IS
			WHEN A => EDO_SIG <= A;
				IF( TIPOR = '0' )THEN
					IF( BEQ = '1' )THEN
						IF( NA = '1' )THEN
							SM <= '1';
						ELSE
							IF( EQ = '1' )THEN
								SM 	<= '1';
								SDOPC <= '1';
							ELSE
								SM <= '1';
							END IF;
						END IF;
					ELSIF( BNEQ = '1' )THEN
						IF( NA = '1' )THEN
							SM <= '1';
						ELSE
							IF( NEQ = '1' )THEN
								SM 	<= '1';
								SDOPC <= '1';
							ELSE
								SM <= '1';
							END IF;
						END IF;
					ELSIF( BGT = '1' )THEN
							IF( NA = '1' )THEN
							SM <= '1';
						ELSE
							IF( G = '1' )THEN
								SM 	<= '1';
								SDOPC <= '1';
							ELSE
								SM <= '1';
							END IF;
						END IF;
					ELSIF( BGET = '1' )THEN
							IF( NA = '1' )THEN
							SM <= '1';
						ELSE
							IF( GET = '1' )THEN
								SM 	<= '1';
								SDOPC <= '1';
							ELSE
								SM <= '1';
							END IF;
						END IF;
					ELSIF( BLT = '1' )THEN
							IF( NA = '1' )THEN
							SM <= '1';
						ELSE
							IF( LT = '1' )THEN
								SM 	<= '1';
								SDOPC <= '1';
							ELSE
								SM <= '1';
							END IF;
						END IF;
					ELSIF( BLE = '1' )THEN
						IF( NA = '1' )THEN
							SM <= '1';
						ELSE
							IF( LE = '1' )THEN
								SM 	<= '1';
								SDOPC <= '1';
							ELSE
								SM <= '1';
							END IF;
						END IF;
					ELSE
						SM 	<= '1';
						SDOPC <= '1';
					END IF;
				END IF;
		END CASE;
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

