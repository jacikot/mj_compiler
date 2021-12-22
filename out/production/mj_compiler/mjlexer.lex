
package compiler.pp1;

import java_cup.runtime.Symbol;

%%

//sekcija code
%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
//brojanje linija i kolina
%line
%column

//stanje za citanje komentara
%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

//ignorisanje svih belih znakova
" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

//yytext vraca niz znakova koji je procitan
"program"   { return new_symbol(sym.PROG, yytext());}
"break"     { return new_symbol(sym.BREAK, yytext());}
"class"     { return new_symbol(sym.CLASS, yytext());}
"else"      { return new_symbol(sym.ELSE, yytext());}
"const"     { return new_symbol(sym.CONST, yytext());}
"if"        { return new_symbol(sym.IF, yytext());}
"do"        { return new_symbol(sym.DO, yytext());}
"while"     { return new_symbol(sym.WHILE, yytext());}
"new"       { return new_symbol(sym.NEW, yytext());}
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"read"      { return new_symbol(sym.READ, yytext());}
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
"extends"   { return new_symbol(sym.EXTND, yytext());}
"continue"  { return new_symbol(sym.CONT, yytext());}
"goto"      { return new_symbol(sym.GOTO, yytext());}
"record"      { return new_symbol(sym.RECORD, yytext());}
"+" 		{ return new_symbol(sym.PLUS, yytext()); }
"-" 		{ return new_symbol(sym.MINUS, yytext()); }
"*" 		{ return new_symbol(sym.MUL, yytext()); }
"/" 		{ return new_symbol(sym.DIV, yytext()); }
"%" 		{ return new_symbol(sym.MOD, yytext()); }
"==" 		{ return new_symbol(sym.EQU, yytext()); }
"!=" 		{ return new_symbol(sym.NEQ, yytext()); }
">" 		{ return new_symbol(sym.GRT, yytext()); }
">=" 		{ return new_symbol(sym.GRE, yytext()); }
"<" 		{ return new_symbol(sym.LES, yytext()); }
"<=" 		{ return new_symbol(sym.LEE, yytext()); }
"&&" 		{ return new_symbol(sym.AND, yytext()); }
"||" 		{ return new_symbol(sym.OR, yytext()); }
"=" 		{ return new_symbol(sym.EQUAL, yytext()); }
"++" 		{ return new_symbol(sym.INC, yytext()); }
"--" 		{ return new_symbol(sym.DEC, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
":" 		{ return new_symbol(sym.COLUMN, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"." 		{ return new_symbol(sym.DOT, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }
"[" 		{ return new_symbol(sym.LBRACK, yytext()); }
"]" 		{ return new_symbol(sym.RBRACK, yytext()); }

//prelazak u stanje komentara
"//" {yybegin(COMMENT);}

//sta kod doslo ostajemo u stanju komentara
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

//vrednost tokena je int

("true"|"false") {return new_symbol (sym.BOOL, (Boolean.parseBoolean(yytext()))?1:0); }
[0-9]+  { return new_symbol(sym.NUMBER, Integer.parseInt(yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }
"'"[\x20-\x7E]"'" {return new_symbol (sym.CHAR, yytext()); }


//okida se kad se ne okida nista iznad njega
. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)); }










