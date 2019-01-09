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
    NUMBER = 258,
    VAR = 259,
    INDEF = 260,
    VECTOR = 261,
    NUMB = 262,
    PRINT = 263,
    WHILE = 264,
    IF = 265,
    ELSE = 266,
    BLTIN = 267,
    OR = 268,
    AND = 269,
    GT = 270,
    GE = 271,
    LT = 272,
    LE = 273,
    EQ = 274,
    NE = 275,
    UNARYMINUS = 276,
    NOT = 277
  };
#endif
/* Tokens.  */
#define NUMBER 258
#define VAR 259
#define INDEF 260
#define VECTOR 261
#define NUMB 262
#define PRINT 263
#define WHILE 264
#define IF 265
#define ELSE 266
#define BLTIN 267
#define OR 268
#define AND 269
#define GT 270
#define GE 271
#define LT 272
#define LE 273
#define EQ 274
#define NE 275
#define UNARYMINUS 276
#define NOT 277

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 18 "vector_cal.y" /* yacc.c:1906  */

    double comp;
    Vector* vec;
    Symbol* sym;
    Inst* inst;
    //Añadida en la práctica 5
    int eval;

#line 110 "y.tab.h" /* yacc.c:1906  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
