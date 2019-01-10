module contdec ( 
	clr,
	clk,
	control,
	ent,
	display
	) ;

input  clr;
input  clk;
input [1:0] control;
input [3:0] ent;
inout [6:0] display;
