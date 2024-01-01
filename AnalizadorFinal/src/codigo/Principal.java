package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author asant
 */
public class Principal {
    public static void main(String[] args) throws Exception{
        String ruta="../AnalizadorFinal/src/codigo/Lexico.flex";
        String ruta2="../AnalizadorFinal/src/codigo/LexicoCup.flex";
        String [] rutaS = {"-parser","Sintaxis","../AnalizadorFinal/src/codigo/Sintaxis.cup"};
        generar(ruta,ruta2,rutaS);
    }
    public static void generar(String ruta, String ruta2, String [] rutaS) throws IOException, Exception{
        File archivo;
        archivo= new File(ruta);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("../AnalizadorFinal/src/codigo/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("../AnalizadorFinal/sym.java"), 
                Paths.get("../AnalizadorFinal/src/codigo/sym.java")
        );
        Path rutaSin = Paths.get("../AnalizadorFinal/src/codigo/Sintaxis.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("../AnalizadorFinal/Sintaxis.java"), 
                Paths.get("../AnalizadorFinal/src/codigo/Sintaxis.java")
        );
    }
}
