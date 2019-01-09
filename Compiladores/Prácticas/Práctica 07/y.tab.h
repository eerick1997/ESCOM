/* A Bison parser, made by GNU Bison 3.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* Undocumented macros, especially those whose name start with YY_,
   are private implementation details.  Do not rely on them.  */

#ifndef YY_YY_Y_TAB_H_INCLUDED
# define YY_YY_Y_TAB_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    VAR = 258,
    BLTIN = 259,
    INDEF = 260,
    VEC = 261,
    NUMERO = 262,
    WHILE = 263,
    IF = 264,
    ELSE = 265,
    PRINT = 266,
    STRING = 267,
    FUNCTION = 268,
    PROCEDURE = 269,
    RETURN = 270,
    FUNC = 271,
    PROC = 272,
    READ = 273,
    ARG = 274,
    NUMBER = 275,
    OR = 276,
    AND = 277,
    GT = 278,
    GE = 279,
    LT = 280,
    LE = 281,
    EQ = 282,
    NE = 283,
    NOT = 284
  };
#endif
/* Tokens.  */
#define VAR 258
#define BLTIN 259
#define INDEF 260
#define VEC 261
#define NUMERO 262
#define WHILE 263
#define IF 264
#define ELSE 265
#define PRINT 266
#define STRING 267
#define FUNCTION 268
#define PROCEDURE 269
#define RETURN 270
#define FUNC 271
#define PROC 272
#define READ 273
#define ARG 274
#define NUMBER 275
#define OR 276
#define AND 277
#define GT 278
#define GE 279
#define LT 280
#define LE 281
#define EQ 282
#define NE 283
#define NOT 284

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 17 "hoc4.y" /* yacc.c:1906  */

	Symbol *sym; /*apuntador de la tabla de símbolos*/
	Inst *inst; /* instrucción de máquina*/
	double val;
	Vector *vec;
	int narg;/*Nùmero de argumentos*/

#line 123 "y.tab.h" /* yacc.c:1906  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
