package model;

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
    
    private static void mostrar(Registros re){
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
        }
    }
    
    public static Connection conectar(){
        Registros re = new Registros();
        mostrar(re);
        try {
            Class.forName(re.getDriver());
            con=DriverManager.getConnection(re.getUrl()+"/"+re.getDbname(), re.getDbuser(), re.getPassword());
        } catch (ClassNotFoundException | SQLException ex) {}
        if(con==null){
            JOptionPane.showMessageDialog(null, "CONECCIÓN NO ESTABLESIDA");
            System.exit(0);
        }
        return con;
    }
    
    public static void main(String[] args) throws SQLException {
        System.err.println(conectar());
        con.close();
    }
    
    public static List<String> conecMySql(){
        Connection cn;
        Statement st;
        ResultSet rs;
        List<String> datos = new ArrayList<String>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", Validar.claveDB());
            st=cn.createStatement();
            rs=st.executeQuery("SELECT distinct database_name FROM innodb_index_stats");
            while(rs.next()){
                datos.add(rs.getString(1));
            }
        } catch (ClassNotFoundException | SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return datos;
    }
}

class Registros{
    private String driver;
    private String url;
    private String dbname;
    private String dbuser;
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
