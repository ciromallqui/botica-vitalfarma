package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import view.Main;

public class ParametroMapper {
    private static ResultSet rs;
    private static Statement st;
    private Connection cn;
    
    public ParametroMapper(){
        cn = Conexion. conectar();
    }
    
    public int obtenerContador(String tableName){
        int cont=0;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT codigo FROM t_parametro WHERE id_parametro='"+tableName+"';");
            while(rs.next()){
                cont = rs.getInt(1)+1;
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Obtener secuencia de identificador de producto:\n"+ ex.getMessage());
        }
        return cont;
    }
    public void actualizarContador(String tableName, int contador){
        try {
            st = cn.createStatement();
            st.executeUpdate("UPDATE t_parametro SET codigo="+contador+" WHERE id_parametro='"+tableName+"';");
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Actulizar secuencia de identificador de producto:\n"+ ex.getMessage());
        }
    }
    
    public void cargarParametro(JComboBox cb, String parametro){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT descripcion FROM t_parametro WHERE id_parametro='"+parametro+"' ORDER BY codigo ASC;");
            while(rs.next()){
                cb.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Cargar lista desplegable:\n"+ ex.getMessage());
        }
    }
}
