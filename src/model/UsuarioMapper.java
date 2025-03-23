package model;

import MFC.util.JLibrary.EncryptingKey;
import aplication_class.CAdministrador;
import aplication_class.CUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.Main;

/**
 *@author CIRO
 */
public class UsuarioMapper {
    private static Statement st;
    private static ResultSet rs;
    private static PreparedStatement ps;
    
    private Connection cn;
    
    public UsuarioMapper(){
        cn = Conexion.conectar();
    }
    
    public int ingresar(String usuario, String clave){
        int estado = 0;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT EXISTS(SELECT id_usuario FROM t_usuario WHERE nombre_usuario='"+usuario+"' AND clave='"+EncryptingKey.md5(clave)+"')");
            if(rs.next()){
                if(rs.getBoolean(1))
                    return 1;
                else return 0;
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "INICIE SU GESTIÓN DE BASE DE DATOS");
            return 2;
        }
        return estado;
    }
    
    public void getDatosUsuario(String usuario, String clave){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT id_usuario,nombre,tipo_usuario,nombre_usuario,clave FROM t_usuario WHERE nombre_usuario='"+usuario+"' AND clave='"+EncryptingKey.md5(clave)+"'");
            if(rs.next()){
                CUsuario.setIdUsuario(Integer.parseInt(rs.getString(1)));
                CUsuario.setNombreCompleto(rs.getString(2).toUpperCase());
                CUsuario.setTipoUsuario(rs.getString(3));
                CUsuario.setNombreUsuario(rs.getString(4));
                CUsuario.setClave(rs.getString(5));
            }
        } catch (SQLException | NullPointerException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Obtener datos del usuario:\n"+ ex.getMessage());
        }
    }
    
    public int actualizarUsuario(CAdministrador a){
        try {
            st = cn.createStatement();
            return st.executeUpdate("UPDATE t_usuario SET nombre='"+a.getNombre()+"',nombre_usuario='"+a.getNombreUsuario()+"' WHERE id_usuario="+a.getIdUsuario());
         } catch (SQLException | NullPointerException ex) {
             Main.txlog.setText(Main.txlog.getText() +"\n======= Actualizar datos del usuario:\n"+ ex.getMessage());
             return 0;
         }
    }
    
    public CAdministrador obtenerDatosAdministrador(){
        CAdministrador admin = new CAdministrador();
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT id_usuario,nombre,tipo_usuario,nombre_usuario FROM t_usuario WHERE tipo_usuario='ADMINISTRADOR';");
            if(rs.next()){
                admin.setIdUsuario(rs.getInt(1));
                admin.setNombre(rs.getString(2));
                admin.setTipoUsuario(rs.getString(3));
                admin.setNombreUsuario(rs.getString(4));
            }
        } catch (SQLException | NullPointerException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Obtener datos del administrador:\n"+ ex.getMessage());
        }
        return admin;
    }
    
    public int actualizarClave(String newpassword){
        try {
            st = cn.createStatement();
            return st.executeUpdate("UPDATE t_usuario SET clave='"+EncryptingKey.md5(newpassword)+"' WHERE id_usuario="+CUsuario.getIdUsuario()+"");
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Actualizar clave:\n"+ ex.getMessage());
            return 0;
        }
    }
    
    public int insertarUsuario(CAdministrador u){
        try {
            st = cn.createStatement();
            return st.executeUpdate("INSERT INTO t_usuario(nombre,tipo_usuario,nombre_usuario,clave) VALUES('"+u.getNombre()+"','"+u.getTipoUsuario()+"','"+u.getNombreUsuario()+"','"+EncryptingKey.md5(u.getClave())+"')");
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Insertar nuevo usuario:\n"+ ex.getMessage());
            return 0;
        }
    }
    
    public int eliminarUsuario(int idUsuario){
        try {
            st = cn.createStatement();
            return st.executeUpdate("DELETE FROM t_usuario WHERE id_usuario="+idUsuario+"");
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= elimianr datos de unusuario:\n"+ ex.getMessage());
            return 0;
        }
    }
    
    public void listarUsuario(DefaultTableModel modelo){
        try {
            int i=1;
            st = cn.createStatement();
            rs = st.executeQuery("SELECT nombre,nombre_usuario,tipo_usuario,id_usuario FROM t_usuario ORDER BY id_usuario ASC;");
            while(rs.next()){
                modelo.addRow(new String[]{String.valueOf(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (SQLException | NullPointerException ex) {
            Main.txlog.setText("\n======= Listar usuarios en la tabla:\n"+ ex.getMessage());
        }
    }
    
    public int crearBD(String bd){
        try {
            ps = cn.prepareStatement("CREATE DATABASE "+bd);
            ps.executeUpdate();
            ps.close();
            return 1;
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Crear base de datos:\n"+ ex.getMessage());
            return 0;
        }
    }
}
