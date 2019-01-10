library ieee;
use ieee.std_logic_1164.all;

entity DET is port(
	en,clk,clr: in std_logic;
	S: out std_logic
);
end entity;

architecture A_DET of DET is
type ESTADOS is(A,B,C,D,E);
signal EDO_PRESENTE: ESTADOS;
signal EDO_FUTURO: ESTADOS;
BEGIN
	PROCESS(EDO_PRESENTE) BEGIN
		CASE EDO_PRESENTE is
			WHEN A => 
				S <= '0';
				if(en = '0') THEN
					EDO_FUTURO <= A;
				 else
				 	EDO_FUTURO <= B;
				 end if;
			 WHEN B =>
			 	S <= '0';
			 	if(en = '0') THEN
					EDO_FUTURO <= A;
				else
					EDO_FUTURO <= C;
				end if;
			 WHEN C =>
			 	S <= '0';
				if(en = '0') THEN
					EDO_FUTURO <= D;
				else
					EDO_FUTURO <= C;
			   	end if;
			 WHEN D => 
			 	S <= '0';
				if(en = '0') THEN
					EDO_FUTURO <= A;
				else 
					EDO_FUTURO <= E;
				end if;
			  WHEN E =>
			  	EDO_FUTURO <= A;
			  	if(en = '0') THEN
					S <= '0';
				else
				 	S <= '1';
				end if;
			end case;
	end PROCESS;

	PROCESS (clk, clr, EDO_FUTURO) BEGIN
		
		if(clr = '0') THEN
			S<='0';
		elsif(clk'event AND clk = '1') THEN
			EDO_PRESENTE <= EDO_FUTURO;
		end if;

	end PROCESS;
end A_DET;
