package model;

import aplication_class.CTurno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ParametroMapper {
    private static ResultSet rs;
    private static Statement st;
    public int obtenerContador(String tableName){
        int cont=0;
        try {
            st = Conexion.Conectar().createStatement();
            rs = st.executeQuery("SELECT codigo FROM t_parametro WHERE id_parametro='"+tableName+"'");
            while(rs.next()){
                cont = rs.getInt(1)+1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return cont;
    }
    public void actualizarContador(String tableName, int contador){
        try {
            st = Conexion.Conectar().createStatement();
            st.executeUpdate("UPDATE t_parametro SET codigo="+contador+" WHERE id_parametro='"+tableName+"'");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public String horaCambioTurno(){
        try {
            st = Conexion.Conectar().createStatement();
            rs = st.executeQuery("SELECT codigo FROM t_parametro WHERE id_parametro='CAMBIO_TURNO';");
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException ex) {return "0";}
        return "0";
    }
    
    public void cargarTurno(JComboBox combo){
        try {
            st = Conexion.Conectar().createStatement();
            rs = st.executeQuery("SELECT descripcion FROM t_turno;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public List<CTurno> listarTurno(){
        List<CTurno> listaRes = new ArrayList<CTurno>();
        CTurno turno = new CTurno();
        try {
            st = Conexion.Conectar().createStatement();
            rs = st.executeQuery("SELECT id_turno,descripcion,hora_inicio,hora_final FROM t_turno;");
            while(rs.next()){
                turno.setIdTurno(rs.getInt(1));
                turno.setNombre(rs.getString(2));
                turno.setHoraInicial(rs.getString(3));
                turno.setHoraFinal(rs.getString(4));
                listaRes.add(new CTurno(turno));
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
        return listaRes;
    }
    
    public CTurno consultarTurno(String nombre){
        CTurno turno = new CTurno();
        try {
            st = Conexion.Conectar().createStatement();
            rs = st.executeQuery("SELECT id_turno,descripcion,hora_inicio,hora_final FROM t_turno WHERE descripcion='"+nombre+"';");
            while(rs.next()){
                turno.setIdTurno(rs.getInt(1));
                turno.setNombre(rs.getString(2));
                turno.setHoraInicial(rs.getString(3));
                turno.setHoraFinal(rs.getString(4));
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
        return turno;
    }
}
