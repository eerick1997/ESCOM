module allff ( 
	e1,
	e2,
	clk,
	pre,
	clr,
	q,
	nq,
	sel
	) ;

input  e1;
input  e2;
input  clk;
input  pre;
input  clr;
inout  q;
inout  nq;
input [1:0] sel;
