module contdec ( 
	clr,
	clk,
	control,
	dato,
	q
	) ;

input  clr;
input  clk;
input [2:0] control;
input [3:0] dato;
inout [3:0] q;
