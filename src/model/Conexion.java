package model;

import aplication_class.CConfig;
import cross_cuting.Validar;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection con;
    
    private static void mostrar(CConfig re){
        String barra = File.separator;
        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
        File url = new File(ruta+"user.dat");
        try {
            FileInputStream fis = new FileInputStream(url);
            Properties mostrar = new Properties();
            mostrar.load(fis);
            re.setDriver(mostrar.getProperty("driver"));
            re.setUrl(mostrar.getProperty("url"));
            re.setDbname(mostrar.getProperty("dbname"));
            re.setDbuser(mostrar.getProperty("dbuser"));
            re.setPassword(mostrar.getProperty("password"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "El sistema no puede encontrar el archivo de configuración de base de datos");
        }
    }
    
    public static Connection conectar(){
        CConfig re = new CConfig();
        mostrar(re);
        try {
            Class.forName(re.getDriver());
            con=DriverManager.getConnection(re.getUrl()+"/"+re.getDbname(), re.getDbuser(), re.getPassword());
        } catch (ClassNotFoundException | SQLException ex) {}
        if(con==null){
            JOptionPane.showMessageDialog(null, "CONECCIÓN A BASE DE DATOS NO ESTABLESIDA, \n  ASEGURESE DE QUE SU GESTOR ESTÉ ACTIVO");
            System.exit(0);
        }
        return con;
    }
    
    public static void main(String[] args) throws SQLException {
        System.err.println(conecMySql());
        con.close();
    }
    
    public static List<String> conecMySql(){
        Connection cn;
        Statement st;
        ResultSet rs;
        List<String> datos = new ArrayList<>();
        try {
            if(Validar.dbengine().equals("mysql")){
                Class.forName("com.mysql.jdbc.Driver");
                cn=DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", Validar.claveDB());
                st=cn.createStatement();
                rs=st.executeQuery("SELECT distinct database_name FROM innodb_index_stats");
            }else{
                Class.forName("org.postgresql.Driver");
                cn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+Validar.nombreDB(), "postgres", Validar.claveDB());
                st=cn.createStatement();
                rs=st.executeQuery("SELECT datname FROM pg_database");
            }
            while(rs.next()){
                datos.add(rs.getString(1));
            }
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return datos;
    }
}