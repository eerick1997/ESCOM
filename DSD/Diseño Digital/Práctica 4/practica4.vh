module codec ( 
	clk,
	clr,
	carga,
	y,
	display
	) ;

input  clk;
input  clr;
input [3:0] carga;
input [1:0] y;
inout [6:0] display;
