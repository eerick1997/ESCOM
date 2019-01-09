library IEEE;
use IEEE.STD_LOGIC_1164.all;
use work.PaqueteControl.all;

package PaqueteEscomips is

component PILA is	
	PORT(
		CLK, CLR: IN STD_LOGIC;
		WPC, UP, DW: IN STD_LOGIC;
		D: IN STD_LOGIC_VECTOR(15 DOWNTO 0);
		Q: INOUT STD_LOGIC_VECTOR(15 DOWNTO 0)
	);
end component;

component PRINCIPAL_CONTROL is	
	PORT(
			FUNCODE : in STD_LOGIC_VECTOR(3 downto 0);
			OPCODE : in STD_LOGIC_VECTOR(4 downto 0);
			BANDERAS: in STD_LOGIC_VECTOR(3 downto 0);
			CLR : in STD_LOGIC;
			CLK : in STD_LOGIC;
			LF : in STD_LOGIC;
			MICRO : out STD_LOGIC_VECTOR(19 downto 0)
		);

end component;

	
component MEMORIA_PROGRAMA is
	PORT(
		A : in  STD_LOGIC_VECTOR (15 downto 0);
      D : out  STD_LOGIC_VECTOR (24 downto 0)
	);
end component;


component ARCHIVO_REGISTROS IS

	GENERIC(
		NBITS_ADDR : INTEGER := 4;
		NBITS_DATA : INTEGER := 16
	);
	
	PORT(
		SHAMT: IN STD_LOGIC_VECTOR( NBITS_ADDR - 1 DOWNTO 0);
		DIR : IN STD_LOGIC;
		
		CLK : IN STD_LOGIC;
		WR : IN STD_LOGIC;
		
		ADDR_WR : IN STD_LOGIC_VECTOR( NBITS_ADDR - 1 DOWNTO 0 );
		ADDR_RD1 : IN STD_LOGIC_VECTOR( NBITS_ADDR - 1 DOWNTO 0 );
		ADDR_RD2 : IN STD_LOGIC_VECTOR( NBITS_ADDR - 1 DOWNTO 0 );
		WD : IN STD_LOGIC_VECTOR( NBITS_DATA - 1 DOWNTO 0 );		
		DINOUT1 : INOUT STD_LOGIC_VECTOR ( NBITS_DATA - 1 DOWNTO 0);
		DOUT2 : OUT STD_LOGIC_VECTOR ( NBITS_DATA - 1 DOWNTO 0);	
		SHE : IN STD_LOGIC			
	);	
END component;

	-- |=== COMPONENT DE DIVISOR DE FRECUENCIA ===|
	COMPONENT DIVISOR_FRECUENCIA is
	
		GENERIC( DIV: INTEGER := 52428800);
	 
		Port ( OSC : in  STD_LOGIC;
				 CLR : in  STD_LOGIC;
             CLK: inout  STD_LOGIC
			  );
	
	end COMPONENT;
	-- |============================|

component ALU is

	Generic ( N : INTEGER := 16 );
	
	Port (
			A : in  STD_LOGIC_VECTOR (N-1 downto 0);
         B : in  STD_LOGIC_VECTOR (N-1 downto 0);
         ALUOP : in STD_LOGIC_VECTOR(3 downto 0);
         RES : inout  STD_LOGIC_VECTOR (N-1 downto 0);
			FLAGS : out STD_LOGIC_VECTOR(3 DOWNTO 0)
		);
end component;


component MEMORIA_DATOS is
	
	GENERIC(
				BDATA : INTEGER := 16;
				BADDR : INTEGER := 16	 
				
	);
	
   Port ( 
			 BUS_DATOS_ENTRADA : in  STD_LOGIC_VECTOR  ( BDATA - 1 downto 0);
          BUS_DATOS_SALIDA	 : out  STD_LOGIC_VECTOR ( BDATA - 1 downto 0);
			 ADR : in  STD_LOGIC_VECTOR (BADDR-1 downto 0);
          CLK : in  STD_LOGIC;
          WD : in  STD_LOGIC
	);
	
end component;

--component Divisor_Escomips is
--    Port ( clk_in, clr : in  STD_LOGIC;
--           clk_out : out  STD_LOGIC);
--end component;

--COMPONENT PrincipalControl is
--	port(
--	CodFun_IN: in std_logic_vector(3 downto 0); --3-0
--	CodOP_IN:in std_logic_vector(4 downto 0); --- 24-20
--	banderas: in std_logic_vector(3 downto 0);
--	clr :IN  std_logic; 
--	clk: IN std_logic;
--	LF : IN STD_LOGIC;
--	MICRO :OUT std_logic_vector(19 downto 0)	
--	);
--end COMPONENT;

end PaqueteEscomips;

package body PaqueteEscomips is 
end PaqueteEscomips;
