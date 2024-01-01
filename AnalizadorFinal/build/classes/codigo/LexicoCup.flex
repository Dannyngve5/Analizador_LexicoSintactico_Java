package codigo;
import java_cup.runtime.Symbol;
%%
%class LexicoCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t \r \n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/* Palabras reservadas */

/* Palabra reservada Numeral */
( "#" ) {return new Symbol(sym.Numeral, yychar, yyline, yytext());}

/* Palabra reservada Include */
( include ) {return new Symbol(sym.Include, yychar, yyline, yytext());}

/* Palabra reservada Define */
( define ) {return new Symbol(sym.Define, yychar, yyline, yytext());}

/* Palabra reservada Iostream */
( iostream ) {return new Symbol(sym.Iostream, yychar, yyline, yytext());}

/* Palabra reservada Break */
( break ) {return new Symbol(sym.Break, yychar, yyline, yytext());}

/* Palabra reservada Case */
( case ) {return new Symbol(sym.Case, yychar, yyline, yytext());}

/* Palabra reservada Char */
( char ) {return new Symbol(sym.Char, yychar, yyline, yytext());}

/* Palabra reservada Const */
( const ) {return new Symbol(sym.Const, yychar, yyline, yytext());}

/* Palabra reservada Continue */
( continue ) {return new Symbol(sym.Continue, yychar, yyline, yytext());}

/* Palabra reservada Default */
( default ) {return new Symbol(sym.Default, yychar, yyline, yytext());}

/* Palabra reservada Do */
( do ) {return new Symbol(sym.Do, yychar, yyline, yytext());}

/* Palabra reservada Double */
( double ) {return new Symbol(sym.Double, yychar, yyline, yytext());}

/* Palabra reservada Float */
( float ) {return new Symbol(sym.Float, yychar, yyline, yytext());}

/* Palabra reservada For */
( for ) {return new Symbol(sym.For, yychar, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}

/* Palabra reservada Else */
( else ) {return new Symbol(sym.Else, yychar, yyline, yytext());}

/* Palabra reservada Int */
(int) {return new Symbol(sym.Int, yychar, yyline, yytext());}

/* Palabra reservada Long */
(long) {return new Symbol(sym.Long, yychar, yyline, yytext());}

/* Palabra reservada Register */
(register) {return new Symbol(sym.Register, yychar, yyline, yytext());}

/* Palabra reservada Return */
(return) {return new Symbol(sym.Return, yychar, yyline, yytext());}

/* Palabra reservada Short */
(short) {return new Symbol(sym.Short, yychar, yyline, yytext());}

/* Palabra reservada Byte */
(byte) {return new Symbol(sym.Byte, yychar, yyline, yytext());}

/* Palabra reservada Bool */
(bool) {return new Symbol(sym.Bool, yychar, yyline, yytext());}

/* Palabra reservada Unsigned */
(unsigned) {return new Symbol(sym.Unsigned, yychar, yyline, yytext());}

/* Palabra reservada Struct */
(struct) {return new Symbol(sym.Struct, yychar, yyline, yytext());}

/* Palabra reservada Switch */
(switch) {return new Symbol(sym.Switch, yychar, yyline, yytext());}

/* Palabra reservada Typedef */
(typedef) {return new Symbol(sym.Typedef, yychar, yyline, yytext());}

/* Palabra reservada Void */
(void) {return new Symbol(sym.Void, yychar, yyline, yytext());}

/* Palabra reservada While */
(while) {return new Symbol(sym.While, yychar, yyline, yytext());}


/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}


/* Tipo de dato String */
( String ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}

/* Operador Igual */
( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.Suma, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.Resta, yychar, yyline, yytext());}

/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.Division, yychar, yyline, yytext());}

/* Operador Modulo */
( "%" ) {return new Symbol(sym.Modulo, yychar, yyline, yytext());}

/* Operador logico de conjunción */
( "&&" ) {return new Symbol(sym.Conjuncion, yychar, yyline, yytext());}

/* Operador logico de disyunción */
( "||" ) {return new Symbol(sym.Disyuncion, yychar, yyline, yytext());}

/* Operador logicos Negación */
( "!" ) {return new Symbol(sym.Negacion, yychar, yyline, yytext());}

/*Operador Relacional MayorQue */
( ">" ) {return new Symbol(sym.MayorQue, yychar, yyline, yytext());}

/*Operador Relacional MenorQue */
( "<" ) {return new Symbol(sym.MenorQue, yychar, yyline, yytext());}

/*Operador Relacional EsIgual */
( "==" ) {return new Symbol(sym.EsIgual, yychar, yyline, yytext());}

/*Operador Relacional Diferente */
( "!=" ) {return new Symbol(sym.Diferente, yychar, yyline, yytext());}

/*Operador Relacional MayorIgual */
( ">=" ) {return new Symbol(sym.MayorIgual, yychar, yyline, yytext());}

/*Operador Relacional MenorIgual */
( "<=" ) {return new Symbol(sym.MenorIgual, yychar, yyline, yytext());}

/*Operador Binario ConjuncionBit */
( "&" ) {return new Symbol(sym.ConjuncionBit, yychar, yyline, yytext());}

/*Operador Binario DisyuncionBit */
( "|" ) {return new Symbol(sym.DisyuncionBit, yychar, yyline, yytext());}

/*Operador Binario Desplazamiento izquierda */
( "<<" ) {return new Symbol(sym.DesplazamientoI, yychar, yyline, yytext());}

/*Operador Binario Desplazamiento derecha */
( ">>" ) {return new Symbol(sym.DesplazamientoD, yychar, yyline, yytext());}

/* Operador Atribucion AsignacionSuma*/
( "+=" ) {return new Symbol(sym.AsignacionSuma, yychar, yyline, yytext());}

/* Operador Atribucion AsignacionResta*/
( "-=" ) {return new Symbol(sym.AsignacionResta, yychar, yyline, yytext());}

/* Operador Atribucion AsignacionMultiplicacion*/
( "*=" ) {return new Symbol(sym.AsignacionMultiplicacion, yychar, yyline, yytext());}

/* Operador Atribucion AsignacionDivision*/
( "/=" ) {return new Symbol(sym.AsignacionDivision, yychar, yyline, yytext());}

/* Operador Atribucion AsignacionModulo*/
( "%=" ) {return new Symbol(sym.AsignacionModulo, yychar, yyline, yytext());}

/* Operador Incremento*/
( "++" ) {return new Symbol(sym.Incremento, yychar, yyline, yytext());}

/* Operador Decremento*/
( "--" ) {return new Symbol(sym.Decremento, yychar, yyline, yytext());}

/* Operador True*/
( true ) {return new Symbol(sym.True, yychar, yyline, yytext());}

/* Operador False*/
( false ) {return new Symbol(sym.False, yychar, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parent_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parent_c, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}

/* Marcador de inicio de algoritmo */
( "main" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}

/* Punto y Coma */
( ";" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

/* Punto */
( "." ) {return new Symbol(sym.Punto, yychar, yyline, yytext());}

/* Dos Puntos */
( ":" ) {return new Symbol(sym.DosPuntos, yychar, yyline, yytext());}

/* Coma */
( "," ) {return new Symbol(sym.Coma, yychar, yyline, yytext());}

/* Funcion Printf */
( printf ) {return new Symbol(sym.PrintF, yychar, yyline, yytext());}

/* Funcion Scanf */
( scanf ) {return new Symbol(sym.ScanF, yychar, yyline, yytext());}

/* Funcion Cin */
( cin ) {return new Symbol(sym.Cin, yychar, yyline, yytext());}

/* Funcion Cout */
( cout ) {return new Symbol(sym.Cout, yychar, yyline, yytext());}

/* Funcion Using */
( using ) {return new Symbol(sym.Using, yychar, yyline, yytext());}

/* Funcion Namespace */
( namespace ) {return new Symbol(sym.Namespace, yychar, yyline, yytext());}

/* Funcion STD */
( std ) {return new Symbol(sym.Std, yychar, yyline, yytext());}

/* Fin de Linea */
( endl ) {return new Symbol(sym.Endl, yychar, yyline, yytext());}

/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Numero */
{D}+ |-{D}+ |{D}+"."+{D}|-{D}+"."+{D} {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}


