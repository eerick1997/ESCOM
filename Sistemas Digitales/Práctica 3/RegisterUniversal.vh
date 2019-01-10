module reg ( 
	clk,
	clr,
	ci,
	cd,
	dato,
	control,
	q
	) ;

input  clk;
input  clr;
input  ci;
input  cd;
input [7:0] dato;
input [1:0] control;
inout [7:0] q;
