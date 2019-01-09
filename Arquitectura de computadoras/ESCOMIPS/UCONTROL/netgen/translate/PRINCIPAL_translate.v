////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 1995-2013 Xilinx, Inc.  All rights reserved.
////////////////////////////////////////////////////////////////////////////////
//   ____  ____
//  /   /\/   /
// /___/  \  /    Vendor: Xilinx
// \   \   \/     Version: P.20131013
//  \   \         Application: netgen
//  /   /         Filename: PRINCIPAL_translate.v
// /___/   /\     Timestamp: Sat Dec  1 00:54:04 2018
// \   \  /  \ 
//  \___\/\___\
//             
// Command	: -intstyle ise -insert_glbl true -w -dir netgen/translate -ofmt verilog -sim PRINCIPAL.ngd PRINCIPAL_translate.v 
// Device	: 7a100tcsg324-3
// Input file	: PRINCIPAL.ngd
// Output file	: /home/erick/Documentos/GitHub/Computer-architecture/ESCOMIPS/UCONTROL/netgen/translate/PRINCIPAL_translate.v
// # of Modules	: 1
// Design Name	: PRINCIPAL
// Xilinx        : /opt/Xilinx/14.7/ISE_DS/ISE/
//             
// Purpose:    
//     This verilog netlist is a verification model and uses simulation 
//     primitives which may not represent the true implementation of the 
//     device, however the netlist is functionally correct and should not 
//     be modified. This file cannot be synthesized and should only be used 
//     with supported simulation tools.
//             
// Reference:  
//     Command Line Tools User Guide, Chapter 23 and Synthesis and Simulation Design Guide, Chapter 6
//             
////////////////////////////////////////////////////////////////////////////////

`timescale 1 ns/1 ps

module PRINCIPAL (
  CLR, CLK, LF, FUNCODE, OPCODE, BANDERAS, MICRO
);
  input CLR;
  input CLK;
  input LF;
  input [3 : 0] FUNCODE;
  input [4 : 0] OPCODE;
  input [3 : 0] BANDERAS;
  output [19 : 0] MICRO;
  wire FUNCODE_3_IBUF_3;
  wire FUNCODE_2_IBUF_4;
  wire FUNCODE_1_IBUF_5;
  wire FUNCODE_0_IBUF_6;
  wire OPCODE_4_IBUF_7;
  wire OPCODE_3_IBUF_8;
  wire OPCODE_2_IBUF_9;
  wire OPCODE_1_IBUF_10;
  wire OPCODE_0_IBUF_11;
  wire BANDERAS_3_IBUF_12;
  wire BANDERAS_2_IBUF_13;
  wire BANDERAS_1_IBUF_14;
  wire CLR_IBUF_15;
  wire CLK_BUFGP;
  wire LF_IBUF_17;
  wire TIPOR;
  wire BEQ;
  wire BNEQ;
  wire BGT;
  wire SDOP;
  wire MICRO_19_OBUF_31;
  wire MICRO_18_OBUF_32;
  wire MICRO_17_OBUF_33;
  wire MICRO_16_OBUF_34;
  wire MICRO_15_OBUF_35;
  wire MICRO_14_OBUF_36;
  wire MICRO_13_OBUF_37;
  wire MICRO_12_OBUF_38;
  wire MICRO_11_OBUF_39;
  wire MICRO_10_OBUF_40;
  wire MICRO_9_OBUF_41;
  wire MICRO_7_OBUF_42;
  wire MICRO_6_OBUF_43;
  wire MICRO_5_OBUF_44;
  wire MICRO_4_OBUF_45;
  wire MICRO_3_OBUF_46;
  wire MICRO_2_OBUF_47;
  wire MICRO_1_OBUF_48;
  wire MICRO_0_OBUF_49;
  wire \DET_NIVEL/RE_INV_4_o ;
  wire \DET_NIVEL/FE_INV_7_o ;
  wire \DET_NIVEL/RE_53 ;
  wire \DET_NIVEL/FE_54 ;
  wire \MEM_OPCODE/Mram_D32 ;
  wire \MEM_OPCODE/Mram_D41 ;
  wire \MEM_OPCODE/Mram_D42 ;
  wire \MEM_OPCODE/Mram_D51 ;
  wire Mmux_MICRO111_59;
  wire Mmux_MICRO152;
  wire N2;
  wire \CONTROLU/Mmux_SDOPC3 ;
  wire \CONTROLU/Mmux_SDOPC31_63 ;
  wire \CONTROLU/Mmux_SDOPC32_64 ;
  wire \CONTROLU/Mmux_SDOPC34 ;
  wire N4;
  wire Mmux_MICRO3;
  wire Mmux_MICRO6;
  wire Mmux_MICRO14;
  wire Mmux_MICRO141_70;
  wire N6;
  wire N8;
  wire N10;
  wire N11;
  wire N12;
  wire N13;
  wire \CLK_BUFGP/IBUFG_2 ;
  wire \NlwInverterSignal_REG_ESTADO/RBANDERAS_3/C ;
  wire GND;
  wire \NlwInverterSignal_REG_ESTADO/RBANDERAS_2/C ;
  wire \NlwInverterSignal_REG_ESTADO/RBANDERAS_1/C ;
  wire VCC;
  wire \NlwInverterSignal_DET_NIVEL/FE/C ;
  wire [4 : 0] CODEOP;
  wire [3 : 1] \REG_ESTADO/RBANDERAS ;
  wire [7 : 7] CODE_BUS;
  X_FF #(
    .INIT ( 1'b0 ))
  \REG_ESTADO/RBANDERAS_3  (
    .CLK(\NlwInverterSignal_REG_ESTADO/RBANDERAS_3/C ),
    .CE(LF_IBUF_17),
    .RST(CLR_IBUF_15),
    .I(BANDERAS_3_IBUF_12),
    .O(\REG_ESTADO/RBANDERAS [3]),
    .SET(GND)
  );
  X_FF #(
    .INIT ( 1'b0 ))
  \REG_ESTADO/RBANDERAS_2  (
    .CLK(\NlwInverterSignal_REG_ESTADO/RBANDERAS_2/C ),
    .CE(LF_IBUF_17),
    .RST(CLR_IBUF_15),
    .I(BANDERAS_2_IBUF_13),
    .O(\REG_ESTADO/RBANDERAS [2]),
    .SET(GND)
  );
  X_FF #(
    .INIT ( 1'b0 ))
  \REG_ESTADO/RBANDERAS_1  (
    .CLK(\NlwInverterSignal_REG_ESTADO/RBANDERAS_1/C ),
    .CE(LF_IBUF_17),
    .RST(CLR_IBUF_15),
    .I(BANDERAS_1_IBUF_14),
    .O(\REG_ESTADO/RBANDERAS [1]),
    .SET(GND)
  );
  X_FF #(
    .INIT ( 1'b0 ))
  \DET_NIVEL/RE  (
    .CLK(CLK_BUFGP),
    .RST(CLR_IBUF_15),
    .I(\DET_NIVEL/RE_INV_4_o ),
    .O(\DET_NIVEL/RE_53 ),
    .CE(VCC),
    .SET(GND)
  );
  X_FF #(
    .INIT ( 1'b0 ))
  \DET_NIVEL/FE  (
    .CLK(\NlwInverterSignal_DET_NIVEL/FE/C ),
    .RST(CLR_IBUF_15),
    .I(\DET_NIVEL/FE_INV_7_o ),
    .O(\DET_NIVEL/FE_54 ),
    .CE(VCC),
    .SET(GND)
  );
  X_LUT2 #(
    .INIT ( 4'h8 ))
  Mmux_CODEOP51 (
    .ADR0(SDOP),
    .ADR1(OPCODE_4_IBUF_7),
    .O(CODEOP[4])
  );
  X_LUT2 #(
    .INIT ( 4'h8 ))
  Mmux_CODEOP41 (
    .ADR0(SDOP),
    .ADR1(OPCODE_3_IBUF_8),
    .O(CODEOP[3])
  );
  X_LUT2 #(
    .INIT ( 4'h8 ))
  Mmux_CODEOP31 (
    .ADR0(SDOP),
    .ADR1(OPCODE_2_IBUF_9),
    .O(CODEOP[2])
  );
  X_LUT2 #(
    .INIT ( 4'h8 ))
  Mmux_CODEOP21 (
    .ADR0(SDOP),
    .ADR1(OPCODE_1_IBUF_10),
    .O(CODEOP[1])
  );
  X_LUT2 #(
    .INIT ( 4'h8 ))
  Mmux_CODEOP11 (
    .ADR0(SDOP),
    .ADR1(OPCODE_0_IBUF_11),
    .O(CODEOP[0])
  );
  X_LUT6 #(
    .INIT ( 64'hFFFFFFFF44444445 ))
  Mmux_MICRO21 (
    .ADR0(TIPOR),
    .ADR1(CODE_BUS[7]),
    .ADR2(CODEOP[1]),
    .ADR3(CODEOP[4]),
    .ADR4(CODEOP[0]),
    .ADR5(Mmux_MICRO111_59),
    .O(MICRO_10_OBUF_40)
  );
  X_LUT6 #(
    .INIT ( 64'h0040014001400100 ))
  \MICRO<16>1  (
    .ADR0(TIPOR),
    .ADR1(CODEOP[2]),
    .ADR2(CODEOP[3]),
    .ADR3(CODEOP[4]),
    .ADR4(CODEOP[0]),
    .ADR5(CODEOP[1]),
    .O(MICRO_16_OBUF_34)
  );
  X_LUT5 #(
    .INIT ( 32'h0002AAAA ))
  Mmux_MICRO1111 (
    .ADR0(TIPOR),
    .ADR1(FUNCODE_2_IBUF_4),
    .ADR2(FUNCODE_0_IBUF_6),
    .ADR3(FUNCODE_1_IBUF_5),
    .ADR4(FUNCODE_3_IBUF_3),
    .O(Mmux_MICRO111_59)
  );
  X_LUT5 #(
    .INIT ( 32'h00000001 ))
  \DECO_INSTR/TIPOR<4>1  (
    .ADR0(OPCODE_0_IBUF_11),
    .ADR1(OPCODE_4_IBUF_7),
    .ADR2(OPCODE_1_IBUF_10),
    .ADR3(OPCODE_3_IBUF_8),
    .ADR4(OPCODE_2_IBUF_9),
    .O(TIPOR)
  );
  X_LUT5 #(
    .INIT ( 32'h00000008 ))
  \DECO_INSTR/BGTI<4>1  (
    .ADR0(OPCODE_0_IBUF_11),
    .ADR1(OPCODE_4_IBUF_7),
    .ADR2(OPCODE_1_IBUF_10),
    .ADR3(OPCODE_3_IBUF_8),
    .ADR4(OPCODE_2_IBUF_9),
    .O(BGT)
  );
  X_LUT6 #(
    .INIT ( 64'h0000000000001000 ))
  Mmux_MICRO111 (
    .ADR0(TIPOR),
    .ADR1(CODEOP[0]),
    .ADR2(CODEOP[4]),
    .ADR3(CODEOP[2]),
    .ADR4(CODEOP[3]),
    .ADR5(CODEOP[1]),
    .O(MICRO_19_OBUF_31)
  );
  X_LUT6 #(
    .INIT ( 64'h0000000000004000 ))
  Mmux_MICRO101 (
    .ADR0(TIPOR),
    .ADR1(CODEOP[0]),
    .ADR2(CODEOP[4]),
    .ADR3(CODEOP[2]),
    .ADR4(CODEOP[3]),
    .ADR5(CODEOP[1]),
    .O(MICRO_18_OBUF_32)
  );
  X_LUT5 #(
    .INIT ( 32'h00200000 ))
  Mmux_MICRO41 (
    .ADR0(FUNCODE_0_IBUF_6),
    .ADR1(FUNCODE_1_IBUF_5),
    .ADR2(TIPOR),
    .ADR3(FUNCODE_2_IBUF_4),
    .ADR4(FUNCODE_3_IBUF_3),
    .O(MICRO_12_OBUF_38)
  );
  X_LUT5 #(
    .INIT ( 32'h00404000 ))
  Mmux_MICRO51 (
    .ADR0(FUNCODE_2_IBUF_4),
    .ADR1(FUNCODE_3_IBUF_3),
    .ADR2(TIPOR),
    .ADR3(FUNCODE_0_IBUF_6),
    .ADR4(FUNCODE_1_IBUF_5),
    .O(MICRO_13_OBUF_37)
  );
  X_LUT5 #(
    .INIT ( 32'h00200000 ))
  \DECO_INSTR/BNEQI<4>1  (
    .ADR0(OPCODE_3_IBUF_8),
    .ADR1(OPCODE_0_IBUF_11),
    .ADR2(OPCODE_1_IBUF_10),
    .ADR3(OPCODE_4_IBUF_7),
    .ADR4(OPCODE_2_IBUF_9),
    .O(BNEQ)
  );
  X_LUT5 #(
    .INIT ( 32'h00200000 ))
  \DECO_INSTR/BEQI<4>1  (
    .ADR0(OPCODE_3_IBUF_8),
    .ADR1(OPCODE_1_IBUF_10),
    .ADR2(OPCODE_0_IBUF_11),
    .ADR3(OPCODE_4_IBUF_7),
    .ADR4(OPCODE_2_IBUF_9),
    .O(BEQ)
  );
  X_LUT4 #(
    .INIT ( 16'hFF45 ))
  Mmux_MICRO1 (
    .ADR0(TIPOR),
    .ADR1(\MEM_OPCODE/Mram_D32 ),
    .ADR2(N2),
    .ADR3(Mmux_MICRO111_59),
    .O(MICRO_0_OBUF_49)
  );
  X_LUT5 #(
    .INIT ( 32'hF7EFFFEF ))
  \CONTROLU/Mmux_SDOPC31  (
    .ADR0(OPCODE_3_IBUF_8),
    .ADR1(OPCODE_0_IBUF_11),
    .ADR2(OPCODE_4_IBUF_7),
    .ADR3(OPCODE_2_IBUF_9),
    .ADR4(OPCODE_1_IBUF_10),
    .O(\CONTROLU/Mmux_SDOPC3 )
  );
  X_LUT4 #(
    .INIT ( 16'h0002 ))
  \CONTROLU/Mmux_SDOPC32  (
    .ADR0(\CONTROLU/Mmux_SDOPC3 ),
    .ADR1(BNEQ),
    .ADR2(BEQ),
    .ADR3(BGT),
    .O(\CONTROLU/Mmux_SDOPC31_63 )
  );
  X_LUT2 #(
    .INIT ( 4'h6 ))
  \CONTROLU/Mmux_SDOPC33  (
    .ADR0(\DET_NIVEL/RE_53 ),
    .ADR1(\DET_NIVEL/FE_54 ),
    .O(\CONTROLU/Mmux_SDOPC32_64 )
  );
  X_LUT6 #(
    .INIT ( 64'hFFFFFFFF99996696 ))
  \CONTROLU/Mmux_SDOPC35  (
    .ADR0(\REG_ESTADO/RBANDERAS [2]),
    .ADR1(\REG_ESTADO/RBANDERAS [3]),
    .ADR2(OPCODE_1_IBUF_10),
    .ADR3(OPCODE_0_IBUF_11),
    .ADR4(BGT),
    .ADR5(BNEQ),
    .O(\CONTROLU/Mmux_SDOPC34 )
  );
  X_LUT4 #(
    .INIT ( 16'hFBBD ))
  Mmux_MICRO17_SW0 (
    .ADR0(FUNCODE_3_IBUF_3),
    .ADR1(FUNCODE_2_IBUF_4),
    .ADR2(FUNCODE_1_IBUF_5),
    .ADR3(FUNCODE_0_IBUF_6),
    .O(N4)
  );
  X_LUT6 #(
    .INIT ( 64'h00000008FF00FF08 ))
  Mmux_MICRO17 (
    .ADR0(CODEOP[3]),
    .ADR1(CODEOP[1]),
    .ADR2(CODEOP[4]),
    .ADR3(TIPOR),
    .ADR4(CODEOP[2]),
    .ADR5(N4),
    .O(MICRO_6_OBUF_43)
  );
  X_LUT6 #(
    .INIT ( 64'h5777FFFF0222AAAA ))
  Mmux_MICRO32 (
    .ADR0(TIPOR),
    .ADR1(FUNCODE_2_IBUF_4),
    .ADR2(FUNCODE_1_IBUF_5),
    .ADR3(FUNCODE_0_IBUF_6),
    .ADR4(FUNCODE_3_IBUF_3),
    .ADR5(Mmux_MICRO3),
    .O(MICRO_11_OBUF_39)
  );
  X_LUT6 #(
    .INIT ( 64'h0501011010101110 ))
  Mmux_MICRO61 (
    .ADR0(TIPOR),
    .ADR1(CODEOP[4]),
    .ADR2(CODEOP[3]),
    .ADR3(CODEOP[1]),
    .ADR4(CODEOP[0]),
    .ADR5(CODEOP[2]),
    .O(Mmux_MICRO6)
  );
  X_LUT5 #(
    .INIT ( 32'h0020202A ))
  Mmux_MICRO141 (
    .ADR0(TIPOR),
    .ADR1(FUNCODE_3_IBUF_3),
    .ADR2(FUNCODE_0_IBUF_6),
    .ADR3(FUNCODE_2_IBUF_4),
    .ADR4(FUNCODE_1_IBUF_5),
    .O(Mmux_MICRO14)
  );
  X_LUT4 #(
    .INIT ( 16'hFF54 ))
  Mmux_MICRO143 (
    .ADR0(TIPOR),
    .ADR1(Mmux_MICRO141_70),
    .ADR2(\MEM_OPCODE/Mram_D41 ),
    .ADR3(Mmux_MICRO14),
    .O(MICRO_3_OBUF_46)
  );
  X_BUF   FUNCODE_3_IBUF (
    .I(FUNCODE[3]),
    .O(FUNCODE_3_IBUF_3)
  );
  X_BUF   FUNCODE_2_IBUF (
    .I(FUNCODE[2]),
    .O(FUNCODE_2_IBUF_4)
  );
  X_BUF   FUNCODE_1_IBUF (
    .I(FUNCODE[1]),
    .O(FUNCODE_1_IBUF_5)
  );
  X_BUF   FUNCODE_0_IBUF (
    .I(FUNCODE[0]),
    .O(FUNCODE_0_IBUF_6)
  );
  X_BUF   OPCODE_4_IBUF (
    .I(OPCODE[4]),
    .O(OPCODE_4_IBUF_7)
  );
  X_BUF   OPCODE_3_IBUF (
    .I(OPCODE[3]),
    .O(OPCODE_3_IBUF_8)
  );
  X_BUF   OPCODE_2_IBUF (
    .I(OPCODE[2]),
    .O(OPCODE_2_IBUF_9)
  );
  X_BUF   OPCODE_1_IBUF (
    .I(OPCODE[1]),
    .O(OPCODE_1_IBUF_10)
  );
  X_BUF   OPCODE_0_IBUF (
    .I(OPCODE[0]),
    .O(OPCODE_0_IBUF_11)
  );
  X_BUF   BANDERAS_3_IBUF (
    .I(BANDERAS[3]),
    .O(BANDERAS_3_IBUF_12)
  );
  X_BUF   BANDERAS_2_IBUF (
    .I(BANDERAS[2]),
    .O(BANDERAS_2_IBUF_13)
  );
  X_BUF   BANDERAS_1_IBUF (
    .I(BANDERAS[1]),
    .O(BANDERAS_1_IBUF_14)
  );
  X_BUF   CLR_IBUF (
    .I(CLR),
    .O(CLR_IBUF_15)
  );
  X_BUF   LF_IBUF (
    .I(LF),
    .O(LF_IBUF_17)
  );
  X_LUT6 #(
    .INIT ( 64'h2002020275575757 ))
  Mmux_MICRO154 (
    .ADR0(TIPOR),
    .ADR1(FUNCODE_3_IBUF_3),
    .ADR2(FUNCODE_1_IBUF_5),
    .ADR3(FUNCODE_0_IBUF_6),
    .ADR4(FUNCODE_2_IBUF_4),
    .ADR5(N6),
    .O(MICRO_4_OBUF_45)
  );
  X_LUT6 #(
    .INIT ( 64'h5555555540440004 ))
  \CONTROLU/Mmux_SDOPC37  (
    .ADR0(TIPOR),
    .ADR1(\CONTROLU/Mmux_SDOPC32_64 ),
    .ADR2(BEQ),
    .ADR3(N8),
    .ADR4(\REG_ESTADO/RBANDERAS [1]),
    .ADR5(\CONTROLU/Mmux_SDOPC31_63 ),
    .O(SDOP)
  );
  X_LUT6 #(
    .INIT ( 64'h0000000000001000 ))
  Mmux_MICRO131 (
    .ADR0(CODEOP[2]),
    .ADR1(CODEOP[3]),
    .ADR2(SDOP),
    .ADR3(OPCODE_1_IBUF_10),
    .ADR4(TIPOR),
    .ADR5(OPCODE_4_IBUF_7),
    .O(MICRO_2_OBUF_47)
  );
  X_LUT6 #(
    .INIT ( 64'hFFFFFFFF2222222A ))
  Mmux_MICRO62 (
    .ADR0(TIPOR),
    .ADR1(FUNCODE_3_IBUF_3),
    .ADR2(FUNCODE_0_IBUF_6),
    .ADR3(FUNCODE_1_IBUF_5),
    .ADR4(FUNCODE_2_IBUF_4),
    .ADR5(Mmux_MICRO6),
    .O(MICRO_14_OBUF_36)
  );
  X_LUT4 #(
    .INIT ( 16'hA8FD ))
  \CONTROLU/Mmux_SDOPC37_SW0  (
    .ADR0(\REG_ESTADO/RBANDERAS [1]),
    .ADR1(OPCODE_0_IBUF_11),
    .ADR2(BNEQ),
    .ADR3(\CONTROLU/Mmux_SDOPC34 ),
    .O(N8)
  );
  X_LUT5 #(
    .INIT ( 32'h88880080 ))
  Mmux_MICRO201 (
    .ADR0(SDOP),
    .ADR1(OPCODE_2_IBUF_9),
    .ADR2(OPCODE_4_IBUF_7),
    .ADR3(\MEM_OPCODE/Mram_D42 ),
    .ADR4(\MEM_OPCODE/Mram_D51 ),
    .O(MICRO_9_OBUF_41)
  );
  X_LUT6 #(
    .INIT ( 64'h1011111111111111 ))
  Mmux_MICRO154_SW0 (
    .ADR0(\MEM_OPCODE/Mram_D41 ),
    .ADR1(Mmux_MICRO152),
    .ADR2(OPCODE_4_IBUF_7),
    .ADR3(\MEM_OPCODE/Mram_D42 ),
    .ADR4(SDOP),
    .ADR5(OPCODE_2_IBUF_9),
    .O(N6)
  );
  X_LUT5 #(
    .INIT ( 32'h00200000 ))
  Mmux_MICRO153 (
    .ADR0(OPCODE_0_IBUF_11),
    .ADR1(OPCODE_4_IBUF_7),
    .ADR2(SDOP),
    .ADR3(OPCODE_1_IBUF_10),
    .ADR4(OPCODE_3_IBUF_8),
    .O(Mmux_MICRO152)
  );
  X_LUT6 #(
    .INIT ( 64'hFFFFFFFFFFFF4000 ))
  \MEM_OPCODE/Mram_D411  (
    .ADR0(\MEM_OPCODE/Mram_D42 ),
    .ADR1(OPCODE_2_IBUF_9),
    .ADR2(SDOP),
    .ADR3(OPCODE_4_IBUF_7),
    .ADR4(\MEM_OPCODE/Mram_D32 ),
    .ADR5(\MEM_OPCODE/Mram_D51 ),
    .O(\MEM_OPCODE/Mram_D41 )
  );
  X_LUT6 #(
    .INIT ( 64'h5051111100011111 ))
  Mmux_MICRO121 (
    .ADR0(TIPOR),
    .ADR1(\MEM_OPCODE/Mram_D42 ),
    .ADR2(OPCODE_2_IBUF_9),
    .ADR3(OPCODE_4_IBUF_7),
    .ADR4(SDOP),
    .ADR5(\MEM_OPCODE/Mram_D51 ),
    .O(MICRO_1_OBUF_48)
  );
  X_LUT6 #(
    .INIT ( 64'h5555555500011111 ))
  Mmux_MICRO71 (
    .ADR0(TIPOR),
    .ADR1(\MEM_OPCODE/Mram_D42 ),
    .ADR2(OPCODE_2_IBUF_9),
    .ADR3(OPCODE_4_IBUF_7),
    .ADR4(SDOP),
    .ADR5(\MEM_OPCODE/Mram_D51 ),
    .O(MICRO_15_OBUF_35)
  );
  X_LUT6 #(
    .INIT ( 64'hFFFF0155FFFFFFFF ))
  Mmux_MICRO1_SW0 (
    .ADR0(OPCODE_3_IBUF_8),
    .ADR1(OPCODE_0_IBUF_11),
    .ADR2(OPCODE_1_IBUF_10),
    .ADR3(OPCODE_2_IBUF_9),
    .ADR4(OPCODE_4_IBUF_7),
    .ADR5(SDOP),
    .O(N2)
  );
  X_LUT4 #(
    .INIT ( 16'hFF7F ))
  \MEM_OPCODE/Mram_D421  (
    .ADR0(SDOP),
    .ADR1(OPCODE_1_IBUF_10),
    .ADR2(OPCODE_0_IBUF_11),
    .ADR3(OPCODE_3_IBUF_8),
    .O(\MEM_OPCODE/Mram_D42 )
  );
  X_LUT6 #(
    .INIT ( 64'h2000222020200220 ))
  Mmux_MICRO142 (
    .ADR0(SDOP),
    .ADR1(OPCODE_4_IBUF_7),
    .ADR2(OPCODE_2_IBUF_9),
    .ADR3(OPCODE_3_IBUF_8),
    .ADR4(OPCODE_0_IBUF_11),
    .ADR5(OPCODE_1_IBUF_10),
    .O(Mmux_MICRO141_70)
  );
  X_LUT5 #(
    .INIT ( 32'h0001FFFF ))
  \MEM_OPCODE/Mram_D511  (
    .ADR0(OPCODE_0_IBUF_11),
    .ADR1(OPCODE_1_IBUF_10),
    .ADR2(OPCODE_4_IBUF_7),
    .ADR3(OPCODE_3_IBUF_8),
    .ADR4(SDOP),
    .O(\MEM_OPCODE/Mram_D51 )
  );
  X_LUT6 #(
    .INIT ( 64'h0002A22022220220 ))
  Mmux_MICRO31 (
    .ADR0(SDOP),
    .ADR1(OPCODE_4_IBUF_7),
    .ADR2(OPCODE_1_IBUF_10),
    .ADR3(OPCODE_0_IBUF_11),
    .ADR4(OPCODE_3_IBUF_8),
    .ADR5(OPCODE_2_IBUF_9),
    .O(Mmux_MICRO3)
  );
  X_LUT6 #(
    .INIT ( 64'h0000020002000200 ))
  \MEM_OPCODE/Mram_D321  (
    .ADR0(SDOP),
    .ADR1(OPCODE_2_IBUF_9),
    .ADR2(OPCODE_3_IBUF_8),
    .ADR3(OPCODE_4_IBUF_7),
    .ADR4(OPCODE_0_IBUF_11),
    .ADR5(OPCODE_1_IBUF_10),
    .O(\MEM_OPCODE/Mram_D32 )
  );
  X_LUT6 #(
    .INIT ( 64'h2A080A280A280A28 ))
  \MEM_OPCODE/Mram_D71  (
    .ADR0(SDOP),
    .ADR1(OPCODE_3_IBUF_8),
    .ADR2(OPCODE_4_IBUF_7),
    .ADR3(OPCODE_2_IBUF_9),
    .ADR4(OPCODE_0_IBUF_11),
    .ADR5(OPCODE_1_IBUF_10),
    .O(CODE_BUS[7])
  );
  X_LUT6 #(
    .INIT ( 64'h2A080A280A280A28 ))
  Mmux_MICRO181 (
    .ADR0(SDOP),
    .ADR1(OPCODE_3_IBUF_8),
    .ADR2(OPCODE_4_IBUF_7),
    .ADR3(OPCODE_2_IBUF_9),
    .ADR4(OPCODE_0_IBUF_11),
    .ADR5(OPCODE_1_IBUF_10),
    .O(MICRO_7_OBUF_42)
  );
  X_MUX2   Mmux_MICRO163 (
    .IA(N10),
    .IB(N11),
    .SEL(TIPOR),
    .O(MICRO_5_OBUF_44)
  );
  X_LUT6 #(
    .INIT ( 64'h3337373311040400 ))
  Mmux_MICRO163_F (
    .ADR0(CODEOP[4]),
    .ADR1(CODEOP[2]),
    .ADR2(CODEOP[0]),
    .ADR3(CODEOP[3]),
    .ADR4(CODEOP[1]),
    .ADR5(\MEM_OPCODE/Mram_D51 ),
    .O(N10)
  );
  X_LUT4 #(
    .INIT ( 16'h5412 ))
  Mmux_MICRO163_G (
    .ADR0(FUNCODE_3_IBUF_3),
    .ADR1(FUNCODE_1_IBUF_5),
    .ADR2(FUNCODE_0_IBUF_6),
    .ADR3(FUNCODE_2_IBUF_4),
    .O(N11)
  );
  X_MUX2   Mmux_MICRO93 (
    .IA(N12),
    .IB(N13),
    .SEL(CODEOP[3]),
    .O(MICRO_17_OBUF_33)
  );
  X_LUT6 #(
    .INIT ( 64'h0040004000404040 ))
  Mmux_MICRO93_F (
    .ADR0(TIPOR),
    .ADR1(SDOP),
    .ADR2(OPCODE_4_IBUF_7),
    .ADR3(CODEOP[2]),
    .ADR4(CODEOP[1]),
    .ADR5(OPCODE_0_IBUF_11),
    .O(N12)
  );
  X_LUT5 #(
    .INIT ( 32'h10101000 ))
  Mmux_MICRO93_G (
    .ADR0(TIPOR),
    .ADR1(CODEOP[4]),
    .ADR2(CODEOP[2]),
    .ADR3(CODEOP[1]),
    .ADR4(CODEOP[0]),
    .O(N13)
  );
  X_INV   \DET_NIVEL/RE_INV_4_o1_INV_0  (
    .I(\DET_NIVEL/RE_53 ),
    .O(\DET_NIVEL/RE_INV_4_o )
  );
  X_INV   \DET_NIVEL/FE_INV_7_o1_INV_0  (
    .I(\DET_NIVEL/FE_54 ),
    .O(\DET_NIVEL/FE_INV_7_o )
  );
  X_IPAD   CLK_97 (
    .PAD(CLK)
  );
  X_IPAD   \FUNCODE<3>  (
    .PAD(FUNCODE[3])
  );
  X_IPAD   \FUNCODE<2>  (
    .PAD(FUNCODE[2])
  );
  X_IPAD   \FUNCODE<1>  (
    .PAD(FUNCODE[1])
  );
  X_IPAD   \FUNCODE<0>  (
    .PAD(FUNCODE[0])
  );
  X_IPAD   \OPCODE<4>  (
    .PAD(OPCODE[4])
  );
  X_IPAD   \OPCODE<3>  (
    .PAD(OPCODE[3])
  );
  X_IPAD   \OPCODE<2>  (
    .PAD(OPCODE[2])
  );
  X_IPAD   \OPCODE<1>  (
    .PAD(OPCODE[1])
  );
  X_IPAD   \OPCODE<0>  (
    .PAD(OPCODE[0])
  );
  X_IPAD   \BANDERAS<3>  (
    .PAD(BANDERAS[3])
  );
  X_IPAD   \BANDERAS<2>  (
    .PAD(BANDERAS[2])
  );
  X_IPAD   \BANDERAS<1>  (
    .PAD(BANDERAS[1])
  );
  X_IPAD   CLR_110 (
    .PAD(CLR)
  );
  X_IPAD   LF_111 (
    .PAD(LF)
  );
  X_OPAD   \MICRO<19>  (
    .PAD(MICRO[19])
  );
  X_OPAD   \MICRO<18>  (
    .PAD(MICRO[18])
  );
  X_OPAD   \MICRO<17>  (
    .PAD(MICRO[17])
  );
  X_OPAD   \MICRO<16>  (
    .PAD(MICRO[16])
  );
  X_OPAD   \MICRO<15>  (
    .PAD(MICRO[15])
  );
  X_OPAD   \MICRO<14>  (
    .PAD(MICRO[14])
  );
  X_OPAD   \MICRO<13>  (
    .PAD(MICRO[13])
  );
  X_OPAD   \MICRO<12>  (
    .PAD(MICRO[12])
  );
  X_OPAD   \MICRO<11>  (
    .PAD(MICRO[11])
  );
  X_OPAD   \MICRO<10>  (
    .PAD(MICRO[10])
  );
  X_OPAD   \MICRO<9>  (
    .PAD(MICRO[9])
  );
  X_OPAD   \MICRO<8>  (
    .PAD(MICRO[8])
  );
  X_OPAD   \MICRO<7>  (
    .PAD(MICRO[7])
  );
  X_OPAD   \MICRO<6>  (
    .PAD(MICRO[6])
  );
  X_OPAD   \MICRO<5>  (
    .PAD(MICRO[5])
  );
  X_OPAD   \MICRO<4>  (
    .PAD(MICRO[4])
  );
  X_OPAD   \MICRO<3>  (
    .PAD(MICRO[3])
  );
  X_OPAD   \MICRO<2>  (
    .PAD(MICRO[2])
  );
  X_OPAD   \MICRO<1>  (
    .PAD(MICRO[1])
  );
  X_OPAD   \MICRO<0>  (
    .PAD(MICRO[0])
  );
  X_CKBUF   \CLK_BUFGP/BUFG  (
    .I(\CLK_BUFGP/IBUFG_2 ),
    .O(CLK_BUFGP)
  );
  X_CKBUF   \CLK_BUFGP/IBUFG  (
    .I(CLK),
    .O(\CLK_BUFGP/IBUFG_2 )
  );
  X_OBUF   MICRO_19_OBUF (
    .I(MICRO_19_OBUF_31),
    .O(MICRO[19])
  );
  X_OBUF   MICRO_18_OBUF (
    .I(MICRO_18_OBUF_32),
    .O(MICRO[18])
  );
  X_OBUF   MICRO_17_OBUF (
    .I(MICRO_17_OBUF_33),
    .O(MICRO[17])
  );
  X_OBUF   MICRO_16_OBUF (
    .I(MICRO_16_OBUF_34),
    .O(MICRO[16])
  );
  X_OBUF   MICRO_15_OBUF (
    .I(MICRO_15_OBUF_35),
    .O(MICRO[15])
  );
  X_OBUF   MICRO_14_OBUF (
    .I(MICRO_14_OBUF_36),
    .O(MICRO[14])
  );
  X_OBUF   MICRO_13_OBUF (
    .I(MICRO_13_OBUF_37),
    .O(MICRO[13])
  );
  X_OBUF   MICRO_12_OBUF (
    .I(MICRO_12_OBUF_38),
    .O(MICRO[12])
  );
  X_OBUF   MICRO_11_OBUF (
    .I(MICRO_11_OBUF_39),
    .O(MICRO[11])
  );
  X_OBUF   MICRO_10_OBUF (
    .I(MICRO_10_OBUF_40),
    .O(MICRO[10])
  );
  X_OBUF   MICRO_9_OBUF (
    .I(MICRO_9_OBUF_41),
    .O(MICRO[9])
  );
  X_OBUF   MICRO_8_OBUF (
    .I(MICRO_16_OBUF_34),
    .O(MICRO[8])
  );
  X_OBUF   MICRO_7_OBUF (
    .I(MICRO_7_OBUF_42),
    .O(MICRO[7])
  );
  X_OBUF   MICRO_6_OBUF (
    .I(MICRO_6_OBUF_43),
    .O(MICRO[6])
  );
  X_OBUF   MICRO_5_OBUF (
    .I(MICRO_5_OBUF_44),
    .O(MICRO[5])
  );
  X_OBUF   MICRO_4_OBUF (
    .I(MICRO_4_OBUF_45),
    .O(MICRO[4])
  );
  X_OBUF   MICRO_3_OBUF (
    .I(MICRO_3_OBUF_46),
    .O(MICRO[3])
  );
  X_OBUF   MICRO_2_OBUF (
    .I(MICRO_2_OBUF_47),
    .O(MICRO[2])
  );
  X_OBUF   MICRO_1_OBUF (
    .I(MICRO_1_OBUF_48),
    .O(MICRO[1])
  );
  X_OBUF   MICRO_0_OBUF (
    .I(MICRO_0_OBUF_49),
    .O(MICRO[0])
  );
  X_INV   \NlwInverterBlock_REG_ESTADO/RBANDERAS_3/C  (
    .I(CLK_BUFGP),
    .O(\NlwInverterSignal_REG_ESTADO/RBANDERAS_3/C )
  );
  X_ZERO   NlwBlock_PRINCIPAL_GND (
    .O(GND)
  );
  X_INV   \NlwInverterBlock_REG_ESTADO/RBANDERAS_2/C  (
    .I(CLK_BUFGP),
    .O(\NlwInverterSignal_REG_ESTADO/RBANDERAS_2/C )
  );
  X_INV   \NlwInverterBlock_REG_ESTADO/RBANDERAS_1/C  (
    .I(CLK_BUFGP),
    .O(\NlwInverterSignal_REG_ESTADO/RBANDERAS_1/C )
  );
  X_ONE   NlwBlock_PRINCIPAL_VCC (
    .O(VCC)
  );
  X_INV   \NlwInverterBlock_DET_NIVEL/FE/C  (
    .I(CLK_BUFGP),
    .O(\NlwInverterSignal_DET_NIVEL/FE/C )
  );
endmodule


`ifndef GLBL
`define GLBL

`timescale  1 ps / 1 ps

module glbl ();

    parameter ROC_WIDTH = 100000;
    parameter TOC_WIDTH = 0;

//--------   STARTUP Globals --------------
    wire GSR;
    wire GTS;
    wire GWE;
    wire PRLD;
    tri1 p_up_tmp;
    tri (weak1, strong0) PLL_LOCKG = p_up_tmp;

    wire PROGB_GLBL;
    wire CCLKO_GLBL;

    reg GSR_int;
    reg GTS_int;
    reg PRLD_int;

//--------   JTAG Globals --------------
    wire JTAG_TDO_GLBL;
    wire JTAG_TCK_GLBL;
    wire JTAG_TDI_GLBL;
    wire JTAG_TMS_GLBL;
    wire JTAG_TRST_GLBL;

    reg JTAG_CAPTURE_GLBL;
    reg JTAG_RESET_GLBL;
    reg JTAG_SHIFT_GLBL;
    reg JTAG_UPDATE_GLBL;
    reg JTAG_RUNTEST_GLBL;

    reg JTAG_SEL1_GLBL = 0;
    reg JTAG_SEL2_GLBL = 0 ;
    reg JTAG_SEL3_GLBL = 0;
    reg JTAG_SEL4_GLBL = 0;

    reg JTAG_USER_TDO1_GLBL = 1'bz;
    reg JTAG_USER_TDO2_GLBL = 1'bz;
    reg JTAG_USER_TDO3_GLBL = 1'bz;
    reg JTAG_USER_TDO4_GLBL = 1'bz;

    assign (weak1, weak0) GSR = GSR_int;
    assign (weak1, weak0) GTS = GTS_int;
    assign (weak1, weak0) PRLD = PRLD_int;

    initial begin
	GSR_int = 1'b1;
	PRLD_int = 1'b1;
	#(ROC_WIDTH)
	GSR_int = 1'b0;
	PRLD_int = 1'b0;
    end

    initial begin
	GTS_int = 1'b1;
	#(TOC_WIDTH)
	GTS_int = 1'b0;
    end

endmodule

`endif

