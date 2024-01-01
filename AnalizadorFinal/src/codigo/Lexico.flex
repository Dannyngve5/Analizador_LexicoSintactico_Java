package codigo;
import static codigo.Tokens.*;
%%
%class Lexico
%type Tokens
%line
%char
%unicode
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ \t \r]+
C= ["..."]
%{
    public String lexemas;
%}
%%
/* Palabras reservadas */

/* Palabra reservada Numeral */
( "#" ) {lexemas=yytext(); return Numeral;}

/* Palabra reservada Include */
( include ) {lexemas=yytext(); return Include;}

/* Palabra reservada Define */
( define ) {lexemas=yytext(); return Define;}

/* Palabra reservada Iostream */
( iostream ) {lexemas=yytext(); return Iostream;}

/* Palabra reservada Break */
( break ) {lexemas=yytext(); return Break;}

/* Palabra reservada Case */
( case ) {lexemas=yytext(); return Case;}

/* Palabra reservada Char */
( char ) {lexemas=yytext(); return Char;}

/* Palabra reservada Const */
( const ) {lexemas=yytext(); return Const;}

/* Palabra reservada Continue */
( continue ) {lexemas=yytext(); return Continue;}

/* Palabra reservada Default */
( default ) {lexemas=yytext(); return Default;}

/* Palabra reservada Do */
( do ) {lexemas=yytext(); return Do;}

/* Palabra reservada Double */
( double ) {lexemas=yytext(); return Double;}

/* Palabra reservada Float */
( float ) {lexemas=yytext(); return Float;}

/* Palabra reservada For */
( for ) {lexemas=yytext(); return For;}

/* Palabra reservada If */
( if ) {lexemas=yytext(); return If;}

/* Palabra reservada Else */
( else ) {lexemas=yytext(); return Else;}

/* Palabra reservada Int */
(int) {lexemas=yytext(); return Int;}

/* Palabra reservada Long */
(long) {lexemas=yytext(); return Long;}

/* Palabra reservada Register */
(register) {lexemas=yytext(); return Register;}

/* Palabra reservada Return */
(return) {lexemas=yytext(); return Return;}

/* Palabra reservada Short */
(short) {lexemas=yytext(); return Short;}

/* Palabra reservada Byte */
(byte) {lexemas=yytext(); return Byte;}

/* Palabra reservada Bool */
(bool) {lexemas=yytext(); return Bool;}

/* Palabra reservada Unsigned */
(unsigned) {lexemas=yytext(); return Unsigned;}

/* Palabra reservada Struct */
(struct) {lexemas=yytext(); return Struct;}

/* Palabra reservada Switch */
(switch) {lexemas=yytext(); return Switch;}

/* Palabra reservada Typedef */
(typedef) {lexemas=yytext(); return Typedef;}

/* Palabra reservada Void */
(void) {lexemas=yytext(); return Void;}

/* Palabra reservada While */
(while) {lexemas=yytext(); return While;}


/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Salto de linea */
( "\n" ) {return Linea;}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}


/* Tipo de dato String */
( String ) {lexemas=yytext(); return Cadena;}

/* Comillas */
( "\"" ) {lexemas=yytext(); return Comillas;}

/* Operador Igual */
( "=" ) {lexemas=yytext(); return Igual;}

/* Operador Suma */
( "+" ) {lexemas=yytext(); return Suma;}

/* Operador Resta */
( "-" ) {lexemas=yytext(); return Resta;}

/* Operador Multiplicacion */
( "*" ) {lexemas=yytext(); return Multiplicacion;}

/* Operador Division */
( "/" ) {lexemas=yytext(); return Division;}

/* Operador Modulo */
( "%" ) {lexemas=yytext(); return Modulo;}

/* Operador logico de conjunción */
( "&&" ) {lexemas=yytext(); return Conjuncion;}

/* Operador logico de disyunción */
( "||" ) {lexemas=yytext(); return Disyuncion;}

/* Operador logicos Negación */
( "!" ) {lexemas=yytext(); return Negacion;}

/*Operador Relacional MayorQue */
( ">" ) {lexemas=yytext(); return MayorQue;}

/*Operador Relacional MenorQue */
( "<" ) {lexemas=yytext(); return MenorQue;}

/*Operador Relacional EsIgual */
( "==" ) {lexemas=yytext(); return EsIgual;}

/*Operador Relacional Diferente */
( "!=" ) {lexemas=yytext(); return Diferente;}

/*Operador Relacional MayorIgual */
( ">=" ) {lexemas=yytext(); return MayorIgual;}

/*Operador Relacional MenorIgual */
( "<=" ) {lexemas=yytext(); return MenorIgual;}

/*Operador Binario ConjuncionBit */
( "&" ) {lexemas=yytext(); return ConjuncionBit;}

/*Operador Binario DisyuncionBit */
( "|" ) {lexemas=yytext(); return DisyuncionBit;}

/*Operador Binario Desplazamiento izquierda */
( "<<" ) {lexemas=yytext(); return DesplazamientoI;}

/*Operador Binario Desplazamiento derecha */
( ">>" ) {lexemas=yytext(); return DesplazamientoD;}

/* Operador Atribucion AsignacionSuma*/
( "+=" ) {lexemas=yytext(); return AsignacionSuma;}

/* Operador Atribucion AsignacionResta*/
( "-=" ) {lexemas=yytext(); return AsignacionResta;}

/* Operador Atribucion AsignacionMultiplicacion*/
( "*=" ) {lexemas=yytext(); return AsignacionMultiplicacion;}

/* Operador Atribucion AsignacionDivision*/
( "/=" ) {lexemas=yytext(); return AsignacionDivision;}

/* Operador Atribucion AsignacionModulo*/
( "%=" ) {lexemas=yytext(); return AsignacionModulo;}

/* Operador Incremento*/
( "++" ) {lexemas=yytext(); return Incremento;}

/* Operador Decremento*/
( "--" ) {lexemas=yytext(); return Decremento;}

/* Operador True*/
( true ) {lexemas=yytext(); return True;}

/* Operador False*/
( false ) {lexemas=yytext(); return False;}

/* Parentesis de apertura */
( "(" ) {lexemas=yytext(); return Parent_a;}

/* Parentesis de cierre */
( ")" ) {lexemas=yytext(); return Parent_c;}

/* Llave de apertura */
( "{" ) {lexemas=yytext(); return Llave_a;}

/* Llave de cierre */
( "}" ) {lexemas=yytext(); return Llave_c;}

/* Corchete de apertura */
( "[" ) {lexemas=yytext(); return Corchete_a;}

/* Corchete de cierre */
( "]" ) {lexemas=yytext(); return Corchete_c;}

/* Marcador de inicio de algoritmo */
( "main" ) {lexemas=yytext(); return Main;}

/* Punto y Coma */
( ";" ) {lexemas=yytext(); return P_coma;}

/* Punto */
( "." ) {lexemas=yytext(); return Punto;}

/* Dos puntos */
( ":" ) {lexemas=yytext(); return DosPuntos;}

/* Coma */
( "," ) {lexemas=yytext(); return Coma;}

/* Funcion Printf */
( printf ) {lexemas=yytext(); return PrintF;}

/* Funcion Scanf */
( scanf ) {lexemas=yytext(); return ScanF;}

/* Funcion Cin */
( cin ) {lexemas=yytext(); return Cin;}

/* Funcion Cout */
( cout ) {lexemas=yytext(); return Cout;}

/* Funcion Using */
( using ) {lexemas=yytext(); return Using;}

/* Funcion Namespace */
( namespace ) {lexemas=yytext(); return Namespace;}

/* Funcion STD */
( std ) {lexemas=yytext(); return Std;}

/* Fin de linea */
( endl ) {lexemas=yytext(); return Endl;}

/* Identificador */
{L}({L}|{D})* {lexemas=yytext(); return Identificador;}

/* Método  override */ ( Override )
{lexemas=yytext(); return Overrides ; }

/* Palabra reservada Util*/ ( util )
{lexemas=yytext(); return Util; }

/*Palabra reservada*/
( abstract ) {lexemas=yytext(); return Abstract; }

/*Palabra reservada*/
( assert ) {lexemas=yytext(); return Assert; }

/*Palabra reservada*/
( catch ) {lexemas=yytext(); return Cath; }

/*Palabra reservada*/
( class ) {lexemas=yytext(); return Class; }

/*Palabra reservada*/
( enum ) {lexemas=yytext(); return Enum; }

/*Palabra reservada*/
( extends ) {lexemas=yytext(); return Extends; }

/*Palabra reservada*/
( final ) {lexemas=yytext(); return Final; }

/*Palabra reservada*/
( finally ) {lexemas=yytext(); return Finally; }

/*Palabra reservada*/
( goto ) {lexemas=yytext(); return Goto; }

/*Palabra reservada*/
( implements ) {lexemas=yytext(); return Implements; }

 /*Palabra reservada*/
( import ) {lexemas=yytext(); return Import; }

/*Palabra reservada*/
( instanceof ) {lexemas=yytext(); return Instanceof; }

/*Palabra reservada*/
( interface ) {lexemas=yytext(); return Interface; }

/*Palabra reservada*/
( native ) {lexemas=yytext(); return Native; }

/*Palabra reservada*/
( private ) {lexemas=yytext(); return Private; }

/*Palabra reservada*/
( protected ) {lexemas=yytext(); return Protected; }

/*Palabra reservada*/
( public ) {lexemas=yytext(); return Public; }

/*Palabra reservada*/
( static ) {lexemas=yytext(); return Static; }

/*Palabra reservada*/
( super ) {lexemas=yytext(); return Super; }

/*Palabra reservada*/
( this ) {lexemas=yytext(); return This; }

/*Palabra reservada*/
( throw ) {lexemas=yytext(); return Throw; }

/*Palabra reservada*/
( try ) {lexemas=yytext(); return Try; }

/*Palabra reservada*/
( volatile ) {lexemas=yytext(); return Volatile; }

/*Palabra reservada*/
( transient ) {lexemas=yytext(); return Transient; }

/*Palabra reservada*/
( synchronized ) {lexemas=yytext(); return Synchronized; }

/* arroba */ 
( "@" ) {lexemas=yytext(); return Arroba; }

/* union  */
( union ) {lexemas=yytext(); return Union; }

/*Numeros reales*/
{D}+("."{D}+)?(e("+"|"-")?{D}+)? {lexemas=yytext(); return NumeroR; }

/*Numeros reales negativos*/
[-]{D}+("."{D}+)?(e("+"|"-")?{D}+)? {lexemas=yytext(); return NumeroR_negativo; }

/* Numero */
{D}+ |-{D}+ |{D}+"."+{D} |-{D}+"."+{D} {lexemas=yytext(); return Numero;}





/* Error de analisis */
 . {return ERROR;}

