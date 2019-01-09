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
    FOR = 268,
    OR = 269,
    AND = 270,
    GT = 271,
    GE = 272,
    LT = 273,
    LE = 274,
    EQ = 275,
    NE = 276,
    UNARYMINUS = 277,
    NOT = 278
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
#define FOR 268
#define OR 269
#define AND 270
#define GT 271
#define GE 272
#define LT 273
#define LE 274
#define EQ 275
#define NE 276
#define UNARYMINUS 277
#define NOT 278

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 18 "vector_cal.y" /* yacc.c:1906  */

    double comp;
    Vector* vec;
    Symbol* sym;
    Inst* inst;
    int eval;

#line 111 "y.tab.h" /* yacc.c:1906  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_Y_TAB_H_INCLUDED  */
