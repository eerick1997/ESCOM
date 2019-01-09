library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use work.PaqueteControl.all;

entity PRINCIPAL is
	port(
		FUNCODE : in STD_LOGIC_VECTOR(3 downto 0);
		OPCODE : in STD_LOGIC_VECTOR(4 downto 0);
		BANDERAS: in STD_LOGIC_VECTOR(3 downto 0);
		CLR : in STD_LOGIC;
		CLK : in STD_LOGIC;
		LF : in STD_LOGIC;
		MICRO : out STD_LOGIC_VECTOR(19 downto 0)
		);
end PRINCIPAL;

architecture PROGRAMA of PRINCIPAL is
	
	SIGNAL FUN_BUS, CODE_BUS	: STD_LOGIC_VECTOR(19 downto 0);
	SIGNAL BANDERAS_SAL			:  STD_LOGIC_VECTOR (3 downto 0);
	SIGNAL CODEOP 					: STD_LOGIC_VECTOR (4 downto 0);
	SIGNAL EQ, NEQ, LT, LET, G, GET : STD_LOGIC;
	SIGNAL TIPOR, BEQ, BLT, BLE, BGT, BGET, BNEQ : STD_LOGIC;
	SIGNAL SM, SDOP: STD_LOGIC;
	SIGNAL NA: STD_LOGIC;

begin

	DECO_INSTR : INSTRUCCION Port MAP (
				  OPCODE => OPCODE,
				  TIPOR  => TIPOR,
				  BEQI   => BEQ,
				  BNEQI  => BNEQ,
				  BLTI   => BLT,
				  BLETI  => BLE,
				  BGTI   => BGT,
				  BGETI  => BGET
	);


	DET_NIVEL : NIVEL port Map(
					CLK => CLK,
					CLR => CLR,
					NA  => NA
				);

	MEM_FUNC : FUNCION PORT MAP(
					A => FUNCODE,
					D => FUN_BUS
	);
	CODEOP <= "00000" WHEN SDOP='0' ELSE OPCODE;

	MEM_OPCODE : OPERACION Port MAP(
				A => CODEOP,
				D => CODE_BUS
	);

	COND: CONDICION Port Map(
			EQ  => EQ,
         NEQ => NEQ,
         G   => G,
         GET => GET,
         LT  => LT,
         LET => LET,
         BANDERAS => BANDERAS_SAL
	);


	MICRO<= CODE_BUS WHEN SM='1'ELSE FUN_BUS;
	CODEOP <= "00000" WHEN SDOP='0' ELSE OPCODE;



	CONTROLU : CONTROL Port MAP(
				CLK => CLK,
				CLR => CLR,

				TIPOR => TIPOR,
				BEQ   => BEQ,
				BNEQ  => BNEQ,
				BLT   => BLT,
				BLE   => BLE,
				BGT   => BGT,
				BGET  => BGET,
			  
				EQ    => EQ,
				NEQ   => NEQ,
				G 		=> G,
				GET   => GET,
				LT 	=> LT,
				LE    => LET,
           
				NA    => NA, 
				SDOPC => SDOP,
				SM 	=> SM
			 );

   REG_ESTADO: ESTADO Port MAP(
					CLK =>  CLK,
					CLR =>  CLR,
					LF  =>  LF,
					BANDERAS  => BANDERAS,
					RBANDERAS => BANDERAS_SAL
	);

end PROGRAMA;
