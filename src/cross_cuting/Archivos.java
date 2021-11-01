package cross_cuting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Archivos {
    public static boolean log(){
        String barra = File.separator;
        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
        File url = new File(ruta+"log.dat");
        boolean estado = false;
        try {
            FileInputStream fis = new FileInputStream(url);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            estado = Boolean.parseBoolean(mostrar.getProperty("mostrar"));
        } catch (IOException ex) {}
        return estado;
    }  
}
