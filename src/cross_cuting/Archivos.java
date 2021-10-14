package cross_cuting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Archivos {
    public static String getTurno(){
        String barra = File.separator;
        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
        File url = new File(ruta+"turno.dat");
        String turno="";
        try {
            FileInputStream fis = new FileInputStream(url);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            turno = mostrar.getProperty("cambio");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return turno;
    }
//    
//    public static String getSerie(){
//        String barra = File.separator;
//        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
//        File url = new File(ruta+"thown.dat");
//        String serie="";
//        try {
//            FileInputStream fis = new FileInputStream(url);
//            Properties mostrar = new Properties();
//            mostrar.load(fis);
//            serie = mostrar.getProperty("serie");
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return serie;
//    }
//    
//    public static void setOrigen(String origen, String serie){
//        String barra = File.separator;
//        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
//        try (FileWriter escribir = new FileWriter(ruta+"thown.dat")) {
//            PrintWriter guardar = new PrintWriter(escribir);
//            guardar.println("origen="+origen);
//            guardar.println("serie="+serie);
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
//    
//    public static boolean getLimit(){
//        String barra = File.separator;
//        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
//        File url = new File(ruta+"bool.dat");
//        boolean estado=false;
//        try {
//            FileInputStream fis = new FileInputStream(url);
//            Properties mostrar = new Properties();
//            mostrar.load(fis);
//            estado = Boolean.parseBoolean(mostrar.getProperty("check"));
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return estado;
//    }
//    
//    public static void setLimit(String estado){
//        String barra = File.separator;
//        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
//        try (FileWriter escribir = new FileWriter(ruta+"bool.dat")) {
//            PrintWriter guardar = new PrintWriter(escribir);
//            guardar.println("check="+estado);
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }
//    
//    public static String getLicece(){
//        String barra = File.separator;
//        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
//        File url = new File(ruta+"licencia");
//        String serie="";
//        try {
//            FileInputStream fis = new FileInputStream(url);
//            Properties mostrar = new Properties();
//            mostrar.load(fis);
//            serie = mostrar.getProperty("Vide(progressio)onerariis");
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//        return serie;
//    }
    
      
  
    static void ComparaHora(){ 
        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");  
        try{  
            String hora1 = "12:25";  
            String hora2 = "12:27";  
  
            Date d1 = formatter.parse(hora1);  
            Date d2 = formatter.parse(hora2);  
              
            if(d1.getTime() > d2.getTime()){  
                System.out.println(hora1 + " es mayor que " + hora2);  
            }  
            else{  
                System.out.println(hora2 + " es mayor que " + hora1);  
            }  
        }  
        catch(Exception e){  
            System.out.println(e);  
        }  
          
    }  
  
  
    public static void main(String[] arg){  
        ComparaHora();  
    }  
}
