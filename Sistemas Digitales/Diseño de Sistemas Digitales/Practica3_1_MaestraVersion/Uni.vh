module regu ( 
	clk,
	clr,
	cd,
	ci,
	control,
	dato,
	q
	) ;

input  clk;
input  clr;
input  cd;
input  ci;
input [1:0] control;
input [7:0] dato;
inout [7:0] q;
