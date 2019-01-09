library IEEE;
use IEEE.STD_LOGIC_1164.all;

package PaqueteControl is
	
	-- |=== COMPONENT DE CONDICION ===|
	COMPONENT CONDICION is
		Port (
				EQ  : out  STD_LOGIC;
				NEQ : out  STD_LOGIC;
				G   : out  STD_LOGIC;
				GET : out  STD_LOGIC;
				LT  : out  STD_LOGIC;
				LET : out  STD_LOGIC;
				BANDERAS : in  STD_LOGIC_VECTOR (3 downto 0)
			
		);
	end COMPONENT;
	-- |============================|
	
	-- |=== COMPONENT DE CONTROL ===|
	COMPONENT CONTROL is
		Port (
				CLK : in  STD_LOGIC;
				CLR : in  STD_LOGIC;

				TIPOR	: in  STD_LOGIC;
				BEQ 	: in  STD_LOGIC;	-- BEQI
				BNEQ 	: in  STD_LOGIC;	-- BNEQI
				BLT 	: in  STD_LOGIC;	-- BLTI
				BLE 	: in  STD_LOGIC;	-- BLETI
				BGT 	: in  STD_LOGIC;	-- BGTI
				BGET 	: in  STD_LOGIC; -- BGETI
			  
				EQ 	: in  STD_LOGIC;
				NEQ 	: in  STD_LOGIC;
				G 		: in  STD_LOGIC;	-- GT
				GET 	: in  STD_LOGIC;	
				LT 	: in  STD_LOGIC;
				LE 	: in  STD_LOGIC;	-- LET
				  
				NA 	: in  STD_LOGIC;
				SDOPC : out  STD_LOGIC;
				SM 	: out STD_LOGIC
		);
	end COMPONENT;
	-- |===========================|
	
	-- |=== COMPONENT DE ESTADO ===|
	COMPONENT ESTADO is
		Port (
				CLK : in  STD_LOGIC;
				CLR : in  STD_LOGIC;
				LF  : in  STD_LOGIC;
				BANDERAS  : in   STD_LOGIC_VECTOR (3 downto 0);
				RBANDERAS : out  STD_LOGIC_VECTOR (3 downto 0)
		);
	end COMPONENT;
	-- |===========================|
	
	-- |=== COMPONENT DE MEM_FUNC ===|
	COMPONENT FUNCION is
		generic(
			BUS_DIR : integer := 4;
			BUS_DAT : integer := 20
		);
	
    Port ( A : in   STD_LOGIC_VECTOR ( BUS_DIR - 1 downto 0);	-- Bus de direccion
           D : out  STD_LOGIC_VECTOR ( BUS_DAT - 1 downto 0) 	-- Bus de datos
			);
	end COMPONENT;
	-- |===========================|
	
	-- |=== COMPONENT DE INSTRUCCION ===|
	COMPONENT INSTRUCCION IS
		Port ( OPCODE : in  STD_LOGIC_VECTOR (4 downto 0);
           TIPOR  : out  STD_LOGIC;
           BEQI   : out  STD_LOGIC;
           BNEQI  : out  STD_LOGIC;
           BLTI   : out  STD_LOGIC;
           BLETI  : out  STD_LOGIC;
           BGTI   : out  STD_LOGIC;
           BGETI  : out  STD_LOGIC
			);
	end COMPONENT;
	-- |===========================|
	
	-- |=== COMPONENT DE NIVEL ===|
	COMPONENT NIVEL IS
		Port ( CLK : in  STD_LOGIC;
				CLR : in  STD_LOGIC;
				NA : out  STD_LOGIC
			);
	end COMPONENT;
	-- |===========================|
	
	-- |=== COMPONENT DE MEM_OPCODE ===|
	COMPONENT OPERACION IS
		generic (	BUS_DIR : integer := 5;
						BUS_DAT : integer := 20
				  );
	
		Port ( A : in   STD_LOGIC_VECTOR ( BUS_DIR - 1 downto 0);	-- Bus de direccion
				 D : out  STD_LOGIC_VECTOR ( BUS_DAT - 1 downto 0) 	-- Bus de datos
			  );
	end COMPONENT;
	-- |===========================|
	
end PaqueteControl;

package body PaqueteControl is


 
end PaqueteControl;
