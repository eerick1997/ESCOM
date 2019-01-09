library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity ALU is
	GENERIC(N: integer:= 16);
    Port ( A : in  STD_LOGIC_VECTOR (N-1 downto 0);
           B : in  STD_LOGIC_VECTOR (N-1 downto 0);
           ALUOP : in STD_LOGIC_VECTOR(3 downto 0);
           RES : inout  STD_LOGIC_VECTOR (N-1 downto 0);
			  FLAGS : out STD_LOGIC_VECTOR(3 DOWNTO 0)
		);
end ALU;

-- BANDERAS:
--	FLAGS(0) = C
--	FLAGS(1) = Z
--	FLAGS(2) = N
--	FLAGS(3) = OV

-- ALU_OPERACION:
--	ALUOP(0) = OP_0
--  ALUOP(1) = OP_1
--  ALUOP(2) = B_INVERT
--  ALUOP(3) = A_INVERT

architecture UA of ALU is
	SIGNAL EA, EB : STD_LOGIC_VECTOR(N-1 downto 0);
	SIGNAL C_AND, C_OR, C_XOR, sum : STD_LOGIC_VECTOR(N-1 downto 0);
	SIGNAL C : STD_LOGIC_VECTOR(N downto 0);
begin
	
	C(0) <= ALUOP(2);
	
	principal: for i in 0 to N-1 generate
		EA(i) <= A(i) xor ALUOP(3);
		EB(i) <= B(i) xor ALUOP(2);
		
		C_AND(i) <= EA(i) and EB(i);
		C_OR(i) <= EA(i) or EB(i);
		C_XOR(i) <= EA(i) xor EB(i);
		sum(i) <= EA(i) xor EB(i) xor C(i);
	end generate principal;
	
	calculateCarry: process(EA, EB, C, C_XOR, C_AND, ALUOP)
	variable curr, prod : std_logic;
	begin
		C(0) <= ALUOP(2);
		for i in 0 to N-1 loop
			curr := '0';
			for j in -1 to i loop
				if j = -1 then
					prod := C(0);
				else
					prod := C_AND(j);
				end if;
				for k in j+1 to i loop
					prod := prod and C_XOR(k);
				end loop;
				curr := curr or prod;
			end loop;
			C(i+1) <= curr;
		end loop;
	end process calculateCarry;
	
	FLAGS(1) <= '1' when res = (res'range => '0')
						 else '0';
	FLAGS(2) <= res(N-1);
	
	with ALUOP(1 downto 0) select FLAGS(0) <=
		C(N) when "11",
		'0' when others;
		
	with ALUOP(1 downto 0) select FLAGS(3) <=
		C(N) xor C(N-1) when "11",
		'0' when others;
	
	with ALUOP(1 downto 0) select res <=
		C_AND when "00",
		C_OR  when "01",
		C_XOR when "10",
		sum   when "11",
		(others => '0') when others;

end UA;

