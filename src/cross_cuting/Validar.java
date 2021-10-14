package cross_cuting;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Validar {
    public static String NombreDB(){
        String name="";
        String barra = File.separator;
        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
        File url = new File(ruta+"database.dat");
        try {
            FileInputStream fis = new FileInputStream(url);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            name = mostrar.getProperty("dbname");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return name;
    }
    
    public static String ClaveDB(){
        String pass="";
        String barra = File.separator;
        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
        File url = new File(ruta+"database.dat");
        try {
            FileInputStream fis = new FileInputStream(url);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            pass = mostrar.getProperty("password");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return pass;
    }
}
