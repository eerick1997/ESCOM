/* A Bison parser, made by GNU Bison 3.2.  */

/* Bison implementation for Yacc-like parsers in C

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

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Undocumented macros, especially those whose name start with YY_,
   are private implementation details.  Do not rely on them.  */

/* Identify Bison output.  */
#define YYBISON 1

/* Bison version.  */
#define YYBISON_VERSION "3.2"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 0

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1




/* First part of user prologue.  */
#line 1 "hoc4.y" /* yacc.c:338  */

#include <stdio.h>
#include <math.h>
#include "vector_cal.h"
#define code2(c1,c2) 		code(c1); code(c2)
#define code3(c1,c2,c3)		code(c1); code(c2); code(c3)

void warning(char *s, char *t);
int yyerror (char *s);
void execerror(char *s, char *t);
void run();
int indef;


#line 84 "y.tab.c" /* yacc.c:338  */
# ifndef YY_NULLPTR
#  if defined __cplusplus
#   if 201103L <= __cplusplus
#    define YY_NULLPTR nullptr
#   else
#    define YY_NULLPTR 0
#   endif
#  else
#   define YY_NULLPTR ((void*)0)
#  endif
# endif

/* Enabling verbose error messages.  */
#ifdef YYERROR_VERBOSE
# undef YYERROR_VERBOSE
# define YYERROR_VERBOSE 1
#else
# define YYERROR_VERBOSE 0
#endif

/* In a future release of Bison, this section will be replaced
   by #include "y.tab.h".  */
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
#line 17 "hoc4.y" /* yacc.c:353  */

	Symbol *sym; /*apuntador de la tabla de símbolos*/
	Inst *inst; /* instrucción de máquina*/
	double val;
	Vector *vec;
	int narg;/*Nùmero de argumentos*/

#line 193 "y.tab.c" /* yacc.c:353  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_Y_TAB_H_INCLUDED  */



#ifdef short
# undef short
#endif

#ifdef YYTYPE_UINT8
typedef YYTYPE_UINT8 yytype_uint8;
#else
typedef unsigned char yytype_uint8;
#endif

#ifdef YYTYPE_INT8
typedef YYTYPE_INT8 yytype_int8;
#else
typedef signed char yytype_int8;
#endif

#ifdef YYTYPE_UINT16
typedef YYTYPE_UINT16 yytype_uint16;
#else
typedef unsigned short yytype_uint16;
#endif

#ifdef YYTYPE_INT16
typedef YYTYPE_INT16 yytype_int16;
#else
typedef short yytype_int16;
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif ! defined YYSIZE_T
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned
# endif
#endif

#define YYSIZE_MAXIMUM ((YYSIZE_T) -1)

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif

#ifndef YY_ATTRIBUTE
# if (defined __GNUC__                                               \
      && (2 < __GNUC__ || (__GNUC__ == 2 && 96 <= __GNUC_MINOR__)))  \
     || defined __SUNPRO_C && 0x5110 <= __SUNPRO_C
#  define YY_ATTRIBUTE(Spec) __attribute__(Spec)
# else
#  define YY_ATTRIBUTE(Spec) /* empty */
# endif
#endif

#ifndef YY_ATTRIBUTE_PURE
# define YY_ATTRIBUTE_PURE   YY_ATTRIBUTE ((__pure__))
#endif

#ifndef YY_ATTRIBUTE_UNUSED
# define YY_ATTRIBUTE_UNUSED YY_ATTRIBUTE ((__unused__))
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YYUSE(E) ((void) (E))
#else
# define YYUSE(E) /* empty */
#endif

#if defined __GNUC__ && ! defined __ICC && 407 <= __GNUC__ * 100 + __GNUC_MINOR__
/* Suppress an incorrect diagnostic about yylval being uninitialized.  */
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN \
    _Pragma ("GCC diagnostic push") \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")\
    _Pragma ("GCC diagnostic ignored \"-Wmaybe-uninitialized\"")
# define YY_IGNORE_MAYBE_UNINITIALIZED_END \
    _Pragma ("GCC diagnostic pop")
#else
# define YY_INITIAL_VALUE(Value) Value
#endif
#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif


#if ! defined yyoverflow || YYERROR_VERBOSE

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's 'empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (0)
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
             && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* ! defined yyoverflow || YYERROR_VERBOSE */


#if (! defined yyoverflow \
     && (! defined __cplusplus \
         || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yytype_int16 yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (sizeof (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (sizeof (yytype_int16) + sizeof (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)                           \
    do                                                                  \
      {                                                                 \
        YYSIZE_T yynewbytes;                                            \
        YYCOPY (&yyptr->Stack_alloc, Stack, yysize);                    \
        Stack = &yyptr->Stack_alloc;                                    \
        yynewbytes = yystacksize * sizeof (*Stack) + YYSTACK_GAP_MAXIMUM; \
        yyptr += yynewbytes / sizeof (*yyptr);                          \
      }                                                                 \
    while (0)

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, (Count) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYSIZE_T yyi;                         \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (0)
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  2
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   284

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  44
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  18
/* YYNRULES -- Number of rules.  */
#define YYNRULES  64
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  125

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   284

#define YYTRANSLATE(YYX)                                                \
  ((unsigned) (YYX) <= YYMAXUTOK ? yytranslate[YYX] : YYUNDEFTOK)

/* YYTRANSLATE[TOKEN-NUM] -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex, without out-of-bounds checking.  */
static const yytype_uint8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
      35,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,    24,     2,     2,     2,     2,
      37,    38,    23,    21,    41,    22,    25,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    36,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,    42,     2,    43,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,    39,     2,    40,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    26,    27,    28,    29,
      30,    31,    32,    33,    34
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint8 yyrline[] =
{
       0,    46,    46,    47,    48,    49,    50,    51,    52,    55,
      56,    59,    60,    61,    62,    63,    64,    68,    73,    77,
      81,    84,    87,    90,    93,    94,    95,    98,    99,   100,
     101,   102,   103,   104,   105,   106,   107,   108,   109,   110,
     111,   112,   113,   114,   115,   116,   117,   118,   119,   122,
     125,   126,   127,   128,   131,   131,   133,   133,   138,   139,
     140,   143,   144,   145,   148
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 0
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "VAR", "BLTIN", "INDEF", "VEC", "NUMERO",
  "WHILE", "IF", "ELSE", "PRINT", "STRING", "FUNCTION", "PROCEDURE",
  "RETURN", "FUNC", "PROC", "READ", "ARG", "NUMBER", "'+'", "'-'", "'*'",
  "'#'", "'.'", "OR", "AND", "GT", "GE", "LT", "LE", "EQ", "NE", "NOT",
  "'\\n'", "'='", "'('", "')'", "'{'", "'}'", "','", "'['", "']'",
  "$accept", "list", "asgn", "stmt", "cond", "while", "if", "end",
  "stmtlist", "exp", "begin", "prlist", "defn", "$@1", "$@2", "procname",
  "arglist", "vector", YY_NULLPTR
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[NUM] -- (External) token number corresponding to the
   (internal) symbol number NUM (which must be that of a token).  */
static const yytype_uint16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,    43,    45,    42,    35,    46,   276,   277,   278,   279,
     280,   281,   282,   283,   284,    10,    61,    40,    41,   123,
     125,    44,    91,    93
};
# endif

#define YYPACT_NINF -86

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-86)))

#define YYTABLE_NINF -1

#define yytable_value_is_error(Yytable_value) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int16 yypact[] =
{
     -86,    80,   -86,   -31,   -21,   -17,   -86,   -86,     5,   -86,
     -86,   162,     0,     0,   -16,   -10,    17,   162,   -86,   -86,
       7,     6,    10,     9,     9,   220,    13,   -86,   -86,   162,
     162,   -86,   -86,   235,     1,    12,    14,   235,   -86,   -86,
     -86,   -86,   -86,    49,   162,   162,   -86,   117,    35,   -86,
     -86,   162,   130,   130,   162,   162,    46,   162,   162,   162,
     162,   162,   162,   162,   162,   162,   162,   -86,   -86,   235,
     184,   158,   162,   162,    30,    31,    36,   235,   245,   -86,
     -86,   -86,   235,    53,   202,   -86,   -86,    78,    78,   -86,
       4,     4,   156,   251,   -86,   -86,   -86,   -86,   -86,   -86,
     -86,   -86,   235,   235,   -36,   -19,    39,    41,   -86,    26,
     -86,   -86,    72,   -86,   162,   -86,   130,   130,   -86,   130,
     235,   -86,   -86,   -86,   -86
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       2,     0,     1,     0,    28,     0,    21,    22,     0,    49,
      49,    12,     0,     0,     0,    29,     0,     0,     3,    24,
       0,    30,     0,     0,     0,     0,     0,    27,     8,     0,
       0,    51,    30,    50,    15,     0,     0,    13,    58,    59,
      60,    54,    56,     0,     0,     0,    48,     0,     0,     5,
       6,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     7,     4,     9,
       0,     0,    61,    61,     0,     0,     0,    10,    38,    25,
      19,    26,    11,     0,     0,    23,    23,    34,    35,    37,
      39,    36,    47,    46,    40,    41,    42,    43,    44,    45,
      33,    53,    52,    62,     0,     0,     0,     0,    32,     0,
      20,    16,    17,    31,     0,    14,     0,     0,    64,     0,
      63,    55,    57,    23,    18
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int8 yypgoto[] =
{
     -86,   -86,    84,   -41,    62,   -86,   -86,   -85,   -86,    -1,
      77,   -86,   -86,   -86,   -86,    79,    43,   -86
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int8 yydefgoto[] =
{
      -1,     1,    32,    22,    52,    23,    24,   111,    47,    82,
      35,    34,    26,    74,    75,    41,   104,    27
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_uint8 yytable[] =
{
      25,   112,   113,    38,    28,   114,    81,    33,     4,     5,
      37,    85,    86,    39,    40,    29,    46,    31,     9,   115,
      30,    43,   114,    14,    15,    16,    44,    48,    69,    70,
      59,    60,    61,    62,    63,    64,    65,    66,   124,    17,
      45,    49,    71,    77,    78,    50,    51,    20,    68,    72,
      84,    73,    76,    87,    88,    83,    90,    91,    92,    93,
      94,    95,    96,    97,    98,    99,    89,   106,   107,   118,
     102,   103,   103,   109,   108,   121,   122,   116,   123,   117,
       2,     3,   119,     4,     5,    21,    53,    36,     6,     7,
       0,     8,    42,     9,    10,    11,    12,    13,    14,    15,
      16,    56,    57,    58,    59,    60,    61,    62,    63,    64,
      65,    66,     0,   120,    17,    18,   105,     0,     0,    19,
       4,     5,    20,     0,     0,     6,     7,     0,     8,     0,
       9,    10,    11,     4,     5,    14,    15,    16,     6,     7,
       0,     8,     0,     9,    10,    11,     0,     0,    14,    15,
      16,    17,    79,     0,     0,     0,    19,    80,     0,    20,
       0,     4,     5,     0,    17,     4,     5,     0,     0,    19,
     101,     9,    20,     0,     0,     9,    14,    15,    16,     0,
      14,    15,    16,    60,    61,    62,    63,    64,    65,    66,
       0,     0,    17,     0,     0,     0,    17,     0,     0,     0,
      20,     0,     0,     0,    20,    54,    55,    56,    57,    58,
      59,    60,    61,    62,    63,    64,    65,    66,     0,     0,
       0,     0,   100,    54,    55,    56,    57,    58,    59,    60,
      61,    62,    63,    64,    65,    66,     0,     0,     0,     0,
     110,    54,    55,    56,    57,    58,    59,    60,    61,    62,
      63,    64,    65,    66,     0,    67,    54,    55,    56,    57,
      58,    59,    60,    61,    62,    63,    64,    65,    66,    57,
      58,    59,    60,    61,    62,    63,    64,    65,    66,    61,
      62,    63,    64,    65,    66
};

static const yytype_int8 yycheck[] =
{
       1,    86,    38,     3,    35,    41,    47,     8,     3,     4,
      11,    52,    53,    13,    14,    36,    17,    12,    13,    38,
      37,    37,    41,    18,    19,    20,    36,    20,    29,    30,
      26,    27,    28,    29,    30,    31,    32,    33,   123,    34,
      23,    35,    41,    44,    45,    35,    37,    42,    35,    37,
      51,    37,     3,    54,    55,    20,    57,    58,    59,    60,
      61,    62,    63,    64,    65,    66,    20,    37,    37,    43,
      71,    72,    73,    20,    38,   116,   117,    38,   119,    38,
       0,     1,    10,     3,     4,     1,    24,    10,     8,     9,
      -1,    11,    13,    13,    14,    15,    16,    17,    18,    19,
      20,    23,    24,    25,    26,    27,    28,    29,    30,    31,
      32,    33,    -1,   114,    34,    35,    73,    -1,    -1,    39,
       3,     4,    42,    -1,    -1,     8,     9,    -1,    11,    -1,
      13,    14,    15,     3,     4,    18,    19,    20,     8,     9,
      -1,    11,    -1,    13,    14,    15,    -1,    -1,    18,    19,
      20,    34,    35,    -1,    -1,    -1,    39,    40,    -1,    42,
      -1,     3,     4,    -1,    34,     3,     4,    -1,    -1,    39,
      12,    13,    42,    -1,    -1,    13,    18,    19,    20,    -1,
      18,    19,    20,    27,    28,    29,    30,    31,    32,    33,
      -1,    -1,    34,    -1,    -1,    -1,    34,    -1,    -1,    -1,
      42,    -1,    -1,    -1,    42,    21,    22,    23,    24,    25,
      26,    27,    28,    29,    30,    31,    32,    33,    -1,    -1,
      -1,    -1,    38,    21,    22,    23,    24,    25,    26,    27,
      28,    29,    30,    31,    32,    33,    -1,    -1,    -1,    -1,
      38,    21,    22,    23,    24,    25,    26,    27,    28,    29,
      30,    31,    32,    33,    -1,    35,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    28,
      29,    30,    31,    32,    33
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,    45,     0,     1,     3,     4,     8,     9,    11,    13,
      14,    15,    16,    17,    18,    19,    20,    34,    35,    39,
      42,    46,    47,    49,    50,    53,    56,    61,    35,    36,
      37,    12,    46,    53,    55,    54,    54,    53,     3,    13,
      14,    59,    59,    37,    36,    23,    53,    52,    20,    35,
      35,    37,    48,    48,    21,    22,    23,    24,    25,    26,
      27,    28,    29,    30,    31,    32,    33,    35,    35,    53,
      53,    41,    37,    37,    57,    58,     3,    53,    53,    35,
      40,    47,    53,    20,    53,    47,    47,    53,    53,    20,
      53,    53,    53,    53,    53,    53,    53,    53,    53,    53,
      38,    12,    53,    53,    60,    60,    37,    37,    38,    20,
      38,    51,    51,    38,    41,    38,    38,    38,    43,    10,
      53,    47,    47,    47,    51
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    44,    45,    45,    45,    45,    45,    45,    45,    46,
      46,    47,    47,    47,    47,    47,    47,    47,    47,    47,
      48,    49,    50,    51,    52,    52,    52,    53,    53,    53,
      53,    53,    53,    53,    53,    53,    53,    53,    53,    53,
      53,    53,    53,    53,    53,    53,    53,    53,    53,    54,
      55,    55,    55,    55,    57,    56,    58,    56,    59,    59,
      59,    60,    60,    60,    61
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     0,     2,     3,     3,     3,     3,     3,     3,
       3,     1,     1,     2,     5,     2,     4,     4,     7,     3,
       3,     1,     1,     0,     0,     2,     2,     1,     1,     1,
       1,     5,     4,     4,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     3,     3,     3,     3,     2,     0,
       1,     1,     3,     3,     0,     6,     0,     6,     1,     1,
       1,     0,     1,     3,     5
};


#define yyerrok         (yyerrstatus = 0)
#define yyclearin       (yychar = YYEMPTY)
#define YYEMPTY         (-2)
#define YYEOF           0

#define YYACCEPT        goto yyacceptlab
#define YYABORT         goto yyabortlab
#define YYERROR         goto yyerrorlab


#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                  \
do                                                              \
  if (yychar == YYEMPTY)                                        \
    {                                                           \
      yychar = (Token);                                         \
      yylval = (Value);                                         \
      YYPOPSTACK (yylen);                                       \
      yystate = *yyssp;                                         \
      goto yybackup;                                            \
    }                                                           \
  else                                                          \
    {                                                           \
      yyerror (YY_("syntax error: cannot back up")); \
      YYERROR;                                                  \
    }                                                           \
while (0)

/* Error token number */
#define YYTERROR        1
#define YYERRCODE       256



/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)                        \
do {                                            \
  if (yydebug)                                  \
    YYFPRINTF Args;                             \
} while (0)

/* This macro is provided for backward compatibility. */
#ifndef YY_LOCATION_PRINT
# define YY_LOCATION_PRINT(File, Loc) ((void) 0)
#endif


# define YY_SYMBOL_PRINT(Title, Type, Value, Location)                    \
do {                                                                      \
  if (yydebug)                                                            \
    {                                                                     \
      YYFPRINTF (stderr, "%s ", Title);                                   \
      yy_symbol_print (stderr,                                            \
                  Type, Value); \
      YYFPRINTF (stderr, "\n");                                           \
    }                                                                     \
} while (0)


/*-----------------------------------.
| Print this symbol's value on YYO.  |
`-----------------------------------*/

static void
yy_symbol_value_print (FILE *yyo, int yytype, YYSTYPE const * const yyvaluep)
{
  FILE *yyoutput = yyo;
  YYUSE (yyoutput);
  if (!yyvaluep)
    return;
# ifdef YYPRINT
  if (yytype < YYNTOKENS)
    YYPRINT (yyo, yytoknum[yytype], *yyvaluep);
# endif
  YYUSE (yytype);
}


/*---------------------------.
| Print this symbol on YYO.  |
`---------------------------*/

static void
yy_symbol_print (FILE *yyo, int yytype, YYSTYPE const * const yyvaluep)
{
  YYFPRINTF (yyo, "%s %s (",
             yytype < YYNTOKENS ? "token" : "nterm", yytname[yytype]);

  yy_symbol_value_print (yyo, yytype, yyvaluep);
  YYFPRINTF (yyo, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

static void
yy_stack_print (yytype_int16 *yybottom, yytype_int16 *yytop)
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)                            \
do {                                                            \
  if (yydebug)                                                  \
    yy_stack_print ((Bottom), (Top));                           \
} while (0)


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

static void
yy_reduce_print (yytype_int16 *yyssp, YYSTYPE *yyvsp, int yyrule)
{
  unsigned long yylno = yyrline[yyrule];
  int yynrhs = yyr2[yyrule];
  int yyi;
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %lu):\n",
             yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr,
                       yystos[yyssp[yyi + 1 - yynrhs]],
                       &(yyvsp[(yyi + 1) - (yynrhs)])
                                              );
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)          \
do {                                    \
  if (yydebug)                          \
    yy_reduce_print (yyssp, yyvsp, Rule); \
} while (0)

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args)
# define YY_SYMBOL_PRINT(Title, Type, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif


#if YYERROR_VERBOSE

# ifndef yystrlen
#  if defined __GLIBC__ && defined _STRING_H
#   define yystrlen strlen
#  else
/* Return the length of YYSTR.  */
static YYSIZE_T
yystrlen (const char *yystr)
{
  YYSIZE_T yylen;
  for (yylen = 0; yystr[yylen]; yylen++)
    continue;
  return yylen;
}
#  endif
# endif

# ifndef yystpcpy
#  if defined __GLIBC__ && defined _STRING_H && defined _GNU_SOURCE
#   define yystpcpy stpcpy
#  else
/* Copy YYSRC to YYDEST, returning the address of the terminating '\0' in
   YYDEST.  */
static char *
yystpcpy (char *yydest, const char *yysrc)
{
  char *yyd = yydest;
  const char *yys = yysrc;

  while ((*yyd++ = *yys++) != '\0')
    continue;

  return yyd - 1;
}
#  endif
# endif

# ifndef yytnamerr
/* Copy to YYRES the contents of YYSTR after stripping away unnecessary
   quotes and backslashes, so that it's suitable for yyerror.  The
   heuristic is that double-quoting is unnecessary unless the string
   contains an apostrophe, a comma, or backslash (other than
   backslash-backslash).  YYSTR is taken from yytname.  If YYRES is
   null, do not copy; instead, return the length of what the result
   would have been.  */
static YYSIZE_T
yytnamerr (char *yyres, const char *yystr)
{
  if (*yystr == '"')
    {
      YYSIZE_T yyn = 0;
      char const *yyp = yystr;

      for (;;)
        switch (*++yyp)
          {
          case '\'':
          case ',':
            goto do_not_strip_quotes;

          case '\\':
            if (*++yyp != '\\')
              goto do_not_strip_quotes;
            /* Fall through.  */
          default:
            if (yyres)
              yyres[yyn] = *yyp;
            yyn++;
            break;

          case '"':
            if (yyres)
              yyres[yyn] = '\0';
            return yyn;
          }
    do_not_strip_quotes: ;
    }

  if (! yyres)
    return yystrlen (yystr);

  return (YYSIZE_T) (yystpcpy (yyres, yystr) - yyres);
}
# endif

/* Copy into *YYMSG, which is of size *YYMSG_ALLOC, an error message
   about the unexpected token YYTOKEN for the state stack whose top is
   YYSSP.

   Return 0 if *YYMSG was successfully written.  Return 1 if *YYMSG is
   not large enough to hold the message.  In that case, also set
   *YYMSG_ALLOC to the required number of bytes.  Return 2 if the
   required number of bytes is too large to store.  */
static int
yysyntax_error (YYSIZE_T *yymsg_alloc, char **yymsg,
                yytype_int16 *yyssp, int yytoken)
{
  YYSIZE_T yysize0 = yytnamerr (YY_NULLPTR, yytname[yytoken]);
  YYSIZE_T yysize = yysize0;
  enum { YYERROR_VERBOSE_ARGS_MAXIMUM = 5 };
  /* Internationalized format string. */
  const char *yyformat = YY_NULLPTR;
  /* Arguments of yyformat. */
  char const *yyarg[YYERROR_VERBOSE_ARGS_MAXIMUM];
  /* Number of reported tokens (one for the "unexpected", one per
     "expected"). */
  int yycount = 0;

  /* There are many possibilities here to consider:
     - If this state is a consistent state with a default action, then
       the only way this function was invoked is if the default action
       is an error action.  In that case, don't check for expected
       tokens because there are none.
     - The only way there can be no lookahead present (in yychar) is if
       this state is a consistent state with a default action.  Thus,
       detecting the absence of a lookahead is sufficient to determine
       that there is no unexpected or expected token to report.  In that
       case, just report a simple "syntax error".
     - Don't assume there isn't a lookahead just because this state is a
       consistent state with a default action.  There might have been a
       previous inconsistent state, consistent state with a non-default
       action, or user semantic action that manipulated yychar.
     - Of course, the expected token list depends on states to have
       correct lookahead information, and it depends on the parser not
       to perform extra reductions after fetching a lookahead from the
       scanner and before detecting a syntax error.  Thus, state merging
       (from LALR or IELR) and default reductions corrupt the expected
       token list.  However, the list is correct for canonical LR with
       one exception: it will still contain any token that will not be
       accepted due to an error action in a later state.
  */
  if (yytoken != YYEMPTY)
    {
      int yyn = yypact[*yyssp];
      yyarg[yycount++] = yytname[yytoken];
      if (!yypact_value_is_default (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative indexes in
             YYCHECK.  In other words, skip the first -YYN actions for
             this state because they are default actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST - yyn + 1;
          int yyxend = yychecklim < YYNTOKENS ? yychecklim : YYNTOKENS;
          int yyx;

          for (yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck[yyx + yyn] == yyx && yyx != YYTERROR
                && !yytable_value_is_error (yytable[yyx + yyn]))
              {
                if (yycount == YYERROR_VERBOSE_ARGS_MAXIMUM)
                  {
                    yycount = 1;
                    yysize = yysize0;
                    break;
                  }
                yyarg[yycount++] = yytname[yyx];
                {
                  YYSIZE_T yysize1 = yysize + yytnamerr (YY_NULLPTR, yytname[yyx]);
                  if (! (yysize <= yysize1
                         && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
                    return 2;
                  yysize = yysize1;
                }
              }
        }
    }

  switch (yycount)
    {
# define YYCASE_(N, S)                      \
      case N:                               \
        yyformat = S;                       \
      break
    default: /* Avoid compiler warnings. */
      YYCASE_(0, YY_("syntax error"));
      YYCASE_(1, YY_("syntax error, unexpected %s"));
      YYCASE_(2, YY_("syntax error, unexpected %s, expecting %s"));
      YYCASE_(3, YY_("syntax error, unexpected %s, expecting %s or %s"));
      YYCASE_(4, YY_("syntax error, unexpected %s, expecting %s or %s or %s"));
      YYCASE_(5, YY_("syntax error, unexpected %s, expecting %s or %s or %s or %s"));
# undef YYCASE_
    }

  {
    YYSIZE_T yysize1 = yysize + yystrlen (yyformat);
    if (! (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
      return 2;
    yysize = yysize1;
  }

  if (*yymsg_alloc < yysize)
    {
      *yymsg_alloc = 2 * yysize;
      if (! (yysize <= *yymsg_alloc
             && *yymsg_alloc <= YYSTACK_ALLOC_MAXIMUM))
        *yymsg_alloc = YYSTACK_ALLOC_MAXIMUM;
      return 1;
    }

  /* Avoid sprintf, as that infringes on the user's name space.
     Don't have undefined behavior even if the translation
     produced a string with the wrong number of "%s"s.  */
  {
    char *yyp = *yymsg;
    int yyi = 0;
    while ((*yyp = *yyformat) != '\0')
      if (*yyp == '%' && yyformat[1] == 's' && yyi < yycount)
        {
          yyp += yytnamerr (yyp, yyarg[yyi++]);
          yyformat += 2;
        }
      else
        {
          yyp++;
          yyformat++;
        }
  }
  return 0;
}
#endif /* YYERROR_VERBOSE */

/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

static void
yydestruct (const char *yymsg, int yytype, YYSTYPE *yyvaluep)
{
  YYUSE (yyvaluep);
  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yytype, yyvaluep, yylocationp);

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YYUSE (yytype);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}




/* The lookahead symbol.  */
int yychar;

/* The semantic value of the lookahead symbol.  */
YYSTYPE yylval;
/* Number of syntax errors so far.  */
int yynerrs;


/*----------.
| yyparse.  |
`----------*/

int
yyparse (void)
{
    int yystate;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus;

    /* The stacks and their tools:
       'yyss': related to states.
       'yyvs': related to semantic values.

       Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* The state stack.  */
    yytype_int16 yyssa[YYINITDEPTH];
    yytype_int16 *yyss;
    yytype_int16 *yyssp;

    /* The semantic value stack.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs;
    YYSTYPE *yyvsp;

    YYSIZE_T yystacksize;

  int yyn;
  int yyresult;
  /* Lookahead token as an internal (translated) token number.  */
  int yytoken = 0;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;

#if YYERROR_VERBOSE
  /* Buffer for error messages, and its allocated size.  */
  char yymsgbuf[128];
  char *yymsg = yymsgbuf;
  YYSIZE_T yymsg_alloc = sizeof yymsgbuf;
#endif

#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  yyssp = yyss = yyssa;
  yyvsp = yyvs = yyvsa;
  yystacksize = YYINITDEPTH;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yystate = 0;
  yyerrstatus = 0;
  yynerrs = 0;
  yychar = YYEMPTY; /* Cause a token to be read.  */
  goto yysetstate;

/*------------------------------------------------------------.
| yynewstate -- Push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
 yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;

 yysetstate:
  *yyssp = (yytype_int16) yystate;

  if (yyss + yystacksize - 1 <= yyssp)
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYSIZE_T yysize = (YYSIZE_T) (yyssp - yyss + 1);

#ifdef yyoverflow
      {
        /* Give user a chance to reallocate the stack.  Use copies of
           these so that the &'s don't force the real ones into
           memory.  */
        YYSTYPE *yyvs1 = yyvs;
        yytype_int16 *yyss1 = yyss;

        /* Each stack pointer address is followed by the size of the
           data in use in that stack, in bytes.  This used to be a
           conditional around just the two extra args, but that might
           be undefined if yyoverflow is a macro.  */
        yyoverflow (YY_("memory exhausted"),
                    &yyss1, yysize * sizeof (*yyssp),
                    &yyvs1, yysize * sizeof (*yyvsp),
                    &yystacksize);
        yyss = yyss1;
        yyvs = yyvs1;
      }
#else /* no yyoverflow */
# ifndef YYSTACK_RELOCATE
      goto yyexhaustedlab;
# else
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
        goto yyexhaustedlab;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
        yystacksize = YYMAXDEPTH;

      {
        yytype_int16 *yyss1 = yyss;
        union yyalloc *yyptr =
          (union yyalloc *) YYSTACK_ALLOC (YYSTACK_BYTES (yystacksize));
        if (! yyptr)
          goto yyexhaustedlab;
        YYSTACK_RELOCATE (yyss_alloc, yyss);
        YYSTACK_RELOCATE (yyvs_alloc, yyvs);
#  undef YYSTACK_RELOCATE
        if (yyss1 != yyssa)
          YYSTACK_FREE (yyss1);
      }
# endif
#endif /* no yyoverflow */

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YYDPRINTF ((stderr, "Stack size increased to %lu\n",
                  (unsigned long) yystacksize));

      if (yyss + yystacksize - 1 <= yyssp)
        YYABORT;
    }

  YYDPRINTF ((stderr, "Entering state %d\n", yystate));

  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;

/*-----------.
| yybackup.  |
`-----------*/
yybackup:

  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either YYEMPTY or YYEOF or a valid lookahead symbol.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token: "));
      yychar = yylex ();
    }

  if (yychar <= YYEOF)
    {
      yychar = yytoken = YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);

  /* Discard the shifted token.  */
  yychar = YYEMPTY;

  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- Do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     '$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
        case 5:
#line 49 "hoc4.y" /* yacc.c:1645  */
    {code2(pop,STOP); return 1;}
#line 1389 "y.tab.c" /* yacc.c:1645  */
    break;

  case 6:
#line 50 "hoc4.y" /* yacc.c:1645  */
    {code(STOP); return 1;}
#line 1395 "y.tab.c" /* yacc.c:1645  */
    break;

  case 7:
#line 51 "hoc4.y" /* yacc.c:1645  */
    {code2(print,STOP); return 1;}
#line 1401 "y.tab.c" /* yacc.c:1645  */
    break;

  case 8:
#line 52 "hoc4.y" /* yacc.c:1645  */
    {yyerror;}
#line 1407 "y.tab.c" /* yacc.c:1645  */
    break;

  case 9:
#line 55 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst) = (yyvsp[0].inst); code3(varpush,(Inst)(yyvsp[-2].sym),assign);}
#line 1413 "y.tab.c" /* yacc.c:1645  */
    break;

  case 10:
#line 56 "hoc4.y" /* yacc.c:1645  */
    {defonly("$");code2(argassign,(Inst)(yyvsp[-2].narg)); (yyval.inst) = (yyvsp[0].inst);}
#line 1419 "y.tab.c" /* yacc.c:1645  */
    break;

  case 11:
#line 59 "hoc4.y" /* yacc.c:1645  */
    {code(pop);}
#line 1425 "y.tab.c" /* yacc.c:1645  */
    break;

  case 12:
#line 60 "hoc4.y" /* yacc.c:1645  */
    {defonly("return");code(procret);}
#line 1431 "y.tab.c" /* yacc.c:1645  */
    break;

  case 13:
#line 61 "hoc4.y" /* yacc.c:1645  */
    {defonly("return");(yyval.inst)=(yyvsp[0].inst);code(funcret);}
#line 1437 "y.tab.c" /* yacc.c:1645  */
    break;

  case 14:
#line 62 "hoc4.y" /* yacc.c:1645  */
    { (yyval.inst) = (yyvsp[-3].inst); code3(call,(Inst)(yyvsp[-4].sym),(Inst)(yyvsp[-1].narg));}
#line 1443 "y.tab.c" /* yacc.c:1645  */
    break;

  case 15:
#line 63 "hoc4.y" /* yacc.c:1645  */
    { (yyval.inst)  = (yyvsp[0].inst);}
#line 1449 "y.tab.c" /* yacc.c:1645  */
    break;

  case 16:
#line 64 "hoc4.y" /* yacc.c:1645  */
    {
											((yyvsp[-3].inst))[1] = (Inst)(yyvsp[-1].inst);  /* cuerpo de la iteración*/
											((yyvsp[-3].inst))[2] = (Inst)(yyvsp[0].inst);  /* terminar si la condición no se cumple*/}
#line 1457 "y.tab.c" /* yacc.c:1645  */
    break;

  case 17:
#line 68 "hoc4.y" /* yacc.c:1645  */
    { /* proposición if que no emplea else*/
				
											((yyvsp[-3].inst))[1] = (Inst)(yyvsp[-1].inst); /* parte then */
											((yyvsp[-3].inst))[3] = (Inst)(yyvsp[0].inst); }
#line 1466 "y.tab.c" /* yacc.c:1645  */
    break;

  case 18:
#line 73 "hoc4.y" /* yacc.c:1645  */
    { /* proposición if ocn parte else*/
											((yyvsp[-6].inst))[1] = (Inst)(yyvsp[-4].inst); /*parte then*/
											((yyvsp[-6].inst))[2] = (Inst)(yyvsp[-1].inst); /*paret else*/
											((yyvsp[-6].inst))[3] = (Inst)(yyvsp[0].inst); }
#line 1475 "y.tab.c" /* yacc.c:1645  */
    break;

  case 19:
#line 77 "hoc4.y" /* yacc.c:1645  */
    { (yyval.inst) = (yyvsp[-1].inst);}
#line 1481 "y.tab.c" /* yacc.c:1645  */
    break;

  case 20:
#line 81 "hoc4.y" /* yacc.c:1645  */
    {code(STOP); (yyval.inst) = (yyvsp[-1].inst);}
#line 1487 "y.tab.c" /* yacc.c:1645  */
    break;

  case 21:
#line 84 "hoc4.y" /* yacc.c:1645  */
    { (yyval.inst) = code3(whilecode,STOP,STOP);}
#line 1493 "y.tab.c" /* yacc.c:1645  */
    break;

  case 22:
#line 87 "hoc4.y" /* yacc.c:1645  */
    { (yyval.inst) = code(ifcode); code3(STOP,STOP,STOP);}
#line 1499 "y.tab.c" /* yacc.c:1645  */
    break;

  case 23:
#line 90 "hoc4.y" /* yacc.c:1645  */
    {code(STOP); (yyval.inst) = progp; }
#line 1505 "y.tab.c" /* yacc.c:1645  */
    break;

  case 24:
#line 93 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst) = progp;}
#line 1511 "y.tab.c" /* yacc.c:1645  */
    break;

  case 27:
#line 98 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst) = code2(constpush, (Inst)(yyvsp[0].sym));}
#line 1517 "y.tab.c" /* yacc.c:1645  */
    break;

  case 28:
#line 99 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst) = code3(varpush,(Inst)(yyvsp[0].sym),eval);}
#line 1523 "y.tab.c" /* yacc.c:1645  */
    break;

  case 29:
#line 100 "hoc4.y" /* yacc.c:1645  */
    {defonly("$"); (yyval.inst) = code2(arg,(Inst)(yyvsp[0].narg));}
#line 1529 "y.tab.c" /* yacc.c:1645  */
    break;

  case 31:
#line 102 "hoc4.y" /* yacc.c:1645  */
    { (yyval.inst) = (yyvsp[-3].inst); code3(call,(Inst)(yyvsp[-4].sym),(Inst)(yyvsp[-1].narg));}
#line 1535 "y.tab.c" /* yacc.c:1645  */
    break;

  case 32:
#line 103 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst)= code2(varread,(Inst)(yyvsp[-1].sym));}
#line 1541 "y.tab.c" /* yacc.c:1645  */
    break;

  case 33:
#line 104 "hoc4.y" /* yacc.c:1645  */
    {code2(bltin,(Inst)(yyvsp[-3].sym)->u.ptr);}
#line 1547 "y.tab.c" /* yacc.c:1645  */
    break;

  case 34:
#line 105 "hoc4.y" /* yacc.c:1645  */
    {code(add);}
#line 1553 "y.tab.c" /* yacc.c:1645  */
    break;

  case 35:
#line 106 "hoc4.y" /* yacc.c:1645  */
    {code(sub);}
#line 1559 "y.tab.c" /* yacc.c:1645  */
    break;

  case 36:
#line 107 "hoc4.y" /* yacc.c:1645  */
    {code(punto);}
#line 1565 "y.tab.c" /* yacc.c:1645  */
    break;

  case 37:
#line 108 "hoc4.y" /* yacc.c:1645  */
    {code(mul);}
#line 1571 "y.tab.c" /* yacc.c:1645  */
    break;

  case 38:
#line 109 "hoc4.y" /* yacc.c:1645  */
    {code(mul);}
#line 1577 "y.tab.c" /* yacc.c:1645  */
    break;

  case 39:
#line 110 "hoc4.y" /* yacc.c:1645  */
    {code(cruz);}
#line 1583 "y.tab.c" /* yacc.c:1645  */
    break;

  case 40:
#line 111 "hoc4.y" /* yacc.c:1645  */
    {code(gt);}
#line 1589 "y.tab.c" /* yacc.c:1645  */
    break;

  case 41:
#line 112 "hoc4.y" /* yacc.c:1645  */
    {code(ge);}
#line 1595 "y.tab.c" /* yacc.c:1645  */
    break;

  case 42:
#line 113 "hoc4.y" /* yacc.c:1645  */
    {code(lt);}
#line 1601 "y.tab.c" /* yacc.c:1645  */
    break;

  case 43:
#line 114 "hoc4.y" /* yacc.c:1645  */
    {code(le);}
#line 1607 "y.tab.c" /* yacc.c:1645  */
    break;

  case 44:
#line 115 "hoc4.y" /* yacc.c:1645  */
    {code(eq);}
#line 1613 "y.tab.c" /* yacc.c:1645  */
    break;

  case 45:
#line 116 "hoc4.y" /* yacc.c:1645  */
    {code(ne);}
#line 1619 "y.tab.c" /* yacc.c:1645  */
    break;

  case 46:
#line 117 "hoc4.y" /* yacc.c:1645  */
    {code(and);}
#line 1625 "y.tab.c" /* yacc.c:1645  */
    break;

  case 47:
#line 118 "hoc4.y" /* yacc.c:1645  */
    {code(or);}
#line 1631 "y.tab.c" /* yacc.c:1645  */
    break;

  case 48:
#line 119 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst) = (yyvsp[0].inst); code(not);}
#line 1637 "y.tab.c" /* yacc.c:1645  */
    break;

  case 49:
#line 122 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst) = progp;}
#line 1643 "y.tab.c" /* yacc.c:1645  */
    break;

  case 50:
#line 125 "hoc4.y" /* yacc.c:1645  */
    {code(prexpr);}
#line 1649 "y.tab.c" /* yacc.c:1645  */
    break;

  case 51:
#line 126 "hoc4.y" /* yacc.c:1645  */
    {(yyval.inst)  = code2(prstr,(Inst)(yyvsp[0].sym));}
#line 1655 "y.tab.c" /* yacc.c:1645  */
    break;

  case 52:
#line 127 "hoc4.y" /* yacc.c:1645  */
    {code(prexpr);}
#line 1661 "y.tab.c" /* yacc.c:1645  */
    break;

  case 53:
#line 128 "hoc4.y" /* yacc.c:1645  */
    {code2(prstr,(Inst)(yyvsp[0].sym));}
#line 1667 "y.tab.c" /* yacc.c:1645  */
    break;

  case 54:
#line 131 "hoc4.y" /* yacc.c:1645  */
    {(yyvsp[0].sym)->type=FUNCTION; indef =1;}
#line 1673 "y.tab.c" /* yacc.c:1645  */
    break;

  case 55:
#line 132 "hoc4.y" /* yacc.c:1645  */
    {code(procret);define((yyvsp[-4].sym));indef=0;}
#line 1679 "y.tab.c" /* yacc.c:1645  */
    break;

  case 56:
#line 133 "hoc4.y" /* yacc.c:1645  */
    {(yyvsp[0].sym)->type = PROCEDURE; indef = 1;}
#line 1685 "y.tab.c" /* yacc.c:1645  */
    break;

  case 57:
#line 134 "hoc4.y" /* yacc.c:1645  */
    {code(procret);define((yyvsp[-4].sym)); indef=0;}
#line 1691 "y.tab.c" /* yacc.c:1645  */
    break;

  case 61:
#line 143 "hoc4.y" /* yacc.c:1645  */
    {(yyval.narg)=0;}
#line 1697 "y.tab.c" /* yacc.c:1645  */
    break;

  case 62:
#line 144 "hoc4.y" /* yacc.c:1645  */
    {(yyval.narg) = 1;}
#line 1703 "y.tab.c" /* yacc.c:1645  */
    break;

  case 63:
#line 145 "hoc4.y" /* yacc.c:1645  */
    {(yyval.narg) = (yyvsp[-2].narg) + 1;}
#line 1709 "y.tab.c" /* yacc.c:1645  */
    break;

  case 64:
#line 148 "hoc4.y" /* yacc.c:1645  */
    {Vector *v = creaVector(3);
											v->vec[0] = (yyvsp[-3].val);
											v->vec[1] = (yyvsp[-2].val);
											v->vec[2] = (yyvsp[-1].val);
											(yyval.sym) = install("",VEC,v);}
#line 1719 "y.tab.c" /* yacc.c:1645  */
    break;


#line 1723 "y.tab.c" /* yacc.c:1645  */
      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", yyr1[yyn], &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);

  *++yyvsp = yyval;

  /* Now 'shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */
  {
    const int yylhs = yyr1[yyn] - YYNTOKENS;
    const int yyi = yypgoto[yylhs] + *yyssp;
    yystate = (0 <= yyi && yyi <= YYLAST && yycheck[yyi] == *yyssp
               ? yytable[yyi]
               : yydefgoto[yylhs]);
  }

  goto yynewstate;


/*--------------------------------------.
| yyerrlab -- here on detecting error.  |
`--------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYEMPTY : YYTRANSLATE (yychar);

  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
#if ! YYERROR_VERBOSE
      yyerror (YY_("syntax error"));
#else
# define YYSYNTAX_ERROR yysyntax_error (&yymsg_alloc, &yymsg, \
                                        yyssp, yytoken)
      {
        char const *yymsgp = YY_("syntax error");
        int yysyntax_error_status;
        yysyntax_error_status = YYSYNTAX_ERROR;
        if (yysyntax_error_status == 0)
          yymsgp = yymsg;
        else if (yysyntax_error_status == 1)
          {
            if (yymsg != yymsgbuf)
              YYSTACK_FREE (yymsg);
            yymsg = (char *) YYSTACK_ALLOC (yymsg_alloc);
            if (!yymsg)
              {
                yymsg = yymsgbuf;
                yymsg_alloc = sizeof yymsgbuf;
                yysyntax_error_status = 2;
              }
            else
              {
                yysyntax_error_status = YYSYNTAX_ERROR;
                yymsgp = yymsg;
              }
          }
        yyerror (yymsgp);
        if (yysyntax_error_status == 2)
          goto yyexhaustedlab;
      }
# undef YYSYNTAX_ERROR
#endif
    }



  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

      if (yychar <= YYEOF)
        {
          /* Return failure if at end of input.  */
          if (yychar == YYEOF)
            YYABORT;
        }
      else
        {
          yydestruct ("Error: discarding",
                      yytoken, &yylval);
          yychar = YYEMPTY;
        }
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:

  /* Pacify compilers like GCC when the user code never invokes
     YYERROR and the label yyerrorlab therefore never appears in user
     code.  */
  if (/*CONSTCOND*/ 0)
     goto yyerrorlab;

  /* Do not reclaim the symbols of the rule whose action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;      /* Each real token shifted decrements this.  */

  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
        {
          yyn += YYTERROR;
          if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYTERROR)
            {
              yyn = yytable[yyn];
              if (0 < yyn)
                break;
            }
        }

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
        YYABORT;


      yydestruct ("Error: popping",
                  yystos[yystate], yyvsp);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", yystos[yyn], yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturn;

/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturn;

#if !defined yyoverflow || YYERROR_VERBOSE
/*-------------------------------------------------.
| yyexhaustedlab -- memory exhaustion comes here.  |
`-------------------------------------------------*/
yyexhaustedlab:
  yyerror (YY_("memory exhausted"));
  yyresult = 2;
  /* Fall through.  */
#endif

yyreturn:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval);
    }
  /* Do not reclaim the symbols of the rule whose action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
                  yystos[*yyssp], yyvsp);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif
#if YYERROR_VERBOSE
  if (yymsg != yymsgbuf)
    YYSTACK_FREE (yymsg);
#endif
  return yyresult;
}
#line 155 "hoc4.y" /* yacc.c:1903  */

#include <stdio.h>
#include <ctype.h>
#include <signal.h>
#include <setjmp.h>
#include <string.h>

char	*progname;
int 	lineno = 1;
jmp_buf  begin;
int 	indef;
char 	*infile;
FILE	*fin;
char	**gargv;
int 	gargc;
int 	c;/*global for use by warning()*/


int yylex (){
  	int c;
  	while ((c = getchar ()) == ' ' || c == '\t')  
  		/*SALTA BLANCOS*/;
 	if (c == EOF)                            
    	return 0;
  	if (isdigit (c)){
		double d;
      	ungetc (c, stdin);
      	scanf ("%lf", &yylval.val);
	    return NUMBER;
    }
	if(isalpha(c)){
		Symbol *s;
		char sbuf[200], *p=sbuf;
		do {
			*p++=c;
		} while ((c=getchar())!=EOF && isalnum(c));
		ungetc(c, stdin);
		*p='\0';
		if((s=lookup(sbuf))==(Symbol *)NULL)
			s=install(sbuf, INDEF,NULL);
		yylval.sym=s;   
        if(s->type == INDEF)
			return VAR;
        else 
            return s->type; 
	}
  	if(c == '\n')
		lineno++;
	if( c == '$'){ /*¿Argumento?*/
		int n = 0;
		while(isdigit(c=getc(fin)))
			n =  10 * n + c - '0';
		ungetc(c,fin);
		if(n == 0)
			execerror("strange $...", (char *)0);
		yylval.narg = n;
		return ARG;
	}
	if( c == '"'){/*cadena entrecomillada*/
		char sbuf[100], *p,*emalloc();
		for(p=sbuf;(c=getc(fin))!= '"';p++){
			if(c == '\n' || c == EOF)
				execerror("missing quote","");
			if(p >= sbuf + sizeof(sbuf) - 1){
				*p = '\0';
				execerror("string too long",sbuf);			
			}
			*p = backslash(c);
		}
		*p = 0;
		yylval.sym = (Symbol *)emalloc(strlen(sbuf)+1);
		strcpy(yylval.sym, sbuf);
		return STRING;
	}
	switch (c){
	case '>':	return follow('=',GE,GT);
	case '<':	return follow('=',LE,LT);
	case '=':	return follow('=',EQ,'=');
	case '!':	return follow('=',NE,NOT);
	case '|':	return follow('|',OR,'|');
	case '&':	return follow('&',AND,'&');
	case '\n':	lineno++; return '\n';
	default:	return c;
	}
  	return c;                                
}
follow (expect,ifyes,ifno)
{
	int c = getchar();

	if(c == expect)
		return ifyes;
	ungetc(c, stdin);
	return ifno;
}

void defonly(char *s)	/*advertencia en caso de definición ilegal*/
{
	if(!indef)
		execerror(s,"used outside definition");
}

void execerror(char *s, char *t){
	warning(s, t);
	longjmp(begin, 0);
}

void fpecatch(){
	execerror("excepcion de punto flotante", (char *)0);
}

int main (int argc, char *argv[]){	
   int i;
   void fpecatch();
   progname = argv[0];
   if(argc == 1){	/*fake an argument list*/
	static char *stdinonly[] = { "-"};
	gargv = stdinonly;
	gargc = 1;
   }else{
	gargv = argv +1;
	gargc = argc -1;
   }
   init();
   while(moreinput())
	run();
   return 0;
}

void moreinput()
{
	if(gargc--<=0)
		return 0;
	if(fin && fin !=stdin)
		fclose(fin);
	infile = *gargv++;
	lineno = 1;
	if(strcmp(infile,"-") == 0){
		fin = stdin;
		infile = 0;
	}else if((fin =fopen(infile,"r")) ==NULL){
		fprintf(stderr,"%s: cannot open %s\n",progname,infile);
		return moreinput();
	}
	return 1;
}

void run()/* ejecutar hasta al fin de archivo (EOF)*/
{
	setjmp(begin);
	signal(SIGFPE,fpecatch);
	for(initcode();yyparse();initcode())
		execute(progbase);
}

int yyerror (char *s) {
   printf("%s",s);
   return 0;
}

void backslash(c) /*obtener el siguiente caràcter con las \ interpretadas */
int c;
{
	char *index(); /* 'strchr()' en algunos sistemas */
	static char transtab[] ="b\bf\fn\nr\rt\t";
	if( c != '\\')
		return c;
	c = getc(fin);
	if( islower(c) && index(transtab,c))
		return index(transtab,c)[1];
	return c;
}


void warning(char *s, char *t)
{
	//fprintf (stderr, "%s: %s", progname, s);
	//if(t)
		//fprintf (stderr, " %s", t);
	//fprintf (stderr, "cerca de la linea %d\n", lineno);
}
