module multicontador ( 
	clk,
	clr,
	dato,
	control,
	q
	) ;

input  clk;
input  clr;
input [3:0] dato;
input [2:0] control;
inout [3:0] q;
