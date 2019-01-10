library ieee;
use ieee.std_logic_1164.all;
use ieee.std_logic_unsigned.all;

entity multicontador is port(

		CLK,CLR:in std_logic;
		dato:in std_logic_vector(3 downto 0);
		control: in std_logic_vector(2 downto 0);
		Q: inout std_logic_vector(3 downto 0)	
);
end entity;

architecture amulticontador of multicontador is
begin 
	process(CLK,CLR,control)
	begin 
		 if(CLR='0') then
			Q<="0000";
		 elsif(CLK'event and CLK='1') then
				case control is
					when "000"=>Q<=Q;
					when "001"=>Q<=Q+1;
					when "011"=>Q<=Q-1;
					when "010"=>Q<=dato;
					when "110"=>Q<=to_stdlogicvector(to_bitvector(Q) ROR 1);	    
					when "111"=>Q<=to_stdlogicvector(to_bitvector(Q) ROL 1);
					when "101"=>
							 case Q is
								when "0000"=>Q<="0001";
								when "0001"=>Q<="0011";
								when "0011"=>Q<="0010";
								when "0010"=>Q<="0110";
								when "0110"=>Q<="0111";
								when "0111"=>Q<="0101";
								when "0101"=>Q<="0100";
								when "0100"=>Q<="1100";
								when "1100"=>Q<="1101";
								when "1101"=>Q<="1111";
								when "1111"=>Q<="1110";
								when "1110"=>Q<="1010";
								when "1010"=>Q<="1011";
								when "1011"=>Q<="1001";
								when "1001"=>Q<="1000";
								when others=>Q<="0000";
	                          end case;
						when others=>
							case Q is
								when "0000"=>Q<="1000";
								when "1000"=>Q<="1001";
								when "1001"=>Q<="1011";
								when "1011"=>Q<="1010";
								when "1010"=>Q<="1110";
								when "1110"=>Q<="1111";
								when "1111"=>Q<="1101";
								when "1101"=>Q<="1100";
								when "1100"=>Q<="0100";
								when "0100"=>Q<="0101";
								when "0101"=>Q<="0111";
								when "0111"=>Q<="0110";
								when "0110"=>Q<="0010";
								when "0010"=>Q<="0011";
								when "0011"=>Q<="0001";
								when others=>Q<="0000";
	                        end case;				
				end case;
			end if;
		end process;
end amulticontador;