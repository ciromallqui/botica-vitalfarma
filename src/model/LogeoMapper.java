package model;

import MFC.util.JLibrary.EncryptingKey;
import aplication_class.CUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *@author CIRO
 */
public class LogeoMapper {
    private static Statement st;
    private static ResultSet rs;
    public boolean ingresar(String usuario, String clave){
        boolean estado = false;
        try {
            st = Conexion.Conectar().createStatement();
            rs = st.executeQuery("SELECT EXISTS(SELECT id_usuario FROM t_usuario WHERE nombre_usuario='"+usuario+"' AND clave='"+EncryptingKey.md5(clave)+"')");
            if(rs.next()){
                estado = rs.getBoolean(1);
            }
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "INICIE SU GESTIÓN DE BASE DE DATOS");
        }
        return estado;
    }
    
    public void getDatosUsuario(String usuario, String clave){
        try {
            st = Conexion.Conectar().createStatement();
            rs = st.executeQuery("SELECT id_usuario,nombre,tipo_usuario,nombre_usuario,clave FROM t_usuario WHERE nombre_usuario='"+usuario+"' AND clave='"+EncryptingKey.md5(clave)+"'");
            if(rs.next()){
                CUsuario.setIdUsuario(Integer.parseInt(rs.getString(1)));
                CUsuario.setNombreCompleto(rs.getString(2).toUpperCase());
                CUsuario.setTipoUsuario(rs.getString(3));
                CUsuario.setNombreUsuario(rs.getString(4));
                CUsuario.setClave(rs.getString(5));
            }
        } catch (SQLException | NullPointerException e) {}
    }
}
