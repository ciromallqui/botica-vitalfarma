package model;

import aplication_class.CTurno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import view.Main;

public class TurnoMapper {
    private Statement st;
    private ResultSet rs;
    private final Connection cn;
    
    public TurnoMapper(){
        cn = Conexion. conectar();
    }
    
    public int insertarTurno(CTurno t){
        try {
            st = cn.createStatement();
            return st.executeUpdate("INSERT INTO t_turno (descripcion,hora_inicio,hora_final,estado) VALUES('"+t.getNombre()+"','"+t.getHoraInicial()+"','"+t.getHoraFinal()+"','1');");
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Insertar turno:\n"+ ex.getMessage()); 
            return 0;
        }
    }
    
    public int actualizarTurno(CTurno t){
        try {
            st = cn.createStatement();
            return st.executeUpdate("UPDATE t_turno SET descripcion='"+t.getNombre()+"', hora_inicio='"+t.getHoraInicial()+"', hora_final='"+t.getHoraFinal()+"', estado='"+t.getEstado()+"' WHERE id_turno="+t.getIdTurno()+";");
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Actualizar turno:\n"+ ex.getMessage());
            return 0;
        }
    }
    
    public void cargarTurno(JComboBox combo){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT descripcion FROM t_turno WHERE estado='1' AND id_turno > 0;");
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= listar turno en combo:\n"+ ex.getMessage());
        }
    }
    
    public void listarTurno(DefaultTableModel modelo){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT t.id_turno,t.descripcion,t.hora_inicio,t.hora_final,p.descripcion FROM t_turno t INNER JOIN t_parametro p ON p.codigo=t.estado WHERE id_turno > 0 ORDER BY t.id_turno ASC;");
            while(rs.next()){
                modelo.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Listar turnos en la tabla:\n"+ ex.getMessage());
        }
    }
    
    public List<CTurno> listarTurno(){
        List<CTurno> listaRes = new ArrayList<>();
        CTurno turno = new CTurno();
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT id_turno,descripcion,hora_inicio,hora_final FROM t_turno WHERE estado='1';");
            while(rs.next()){
                turno.setIdTurno(rs.getInt(1));
                turno.setNombre(rs.getString(2));
                turno.setHoraInicial(rs.getString(3));
                turno.setHoraFinal(rs.getString(4));
                listaRes.add(new CTurno(turno));
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Listar turno:\n"+ ex.getMessage());
        }
        return listaRes;
    }
    
    public CTurno consultarTurno(String nombre){
        CTurno turno = new CTurno();
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT id_turno,descripcion,hora_inicio,hora_final FROM t_turno WHERE descripcion='"+nombre+"';");
            while(rs.next()){
                turno.setIdTurno(rs.getInt(1));
                turno.setNombre(rs.getString(2));
                turno.setHoraInicial(rs.getString(3));
                turno.setHoraFinal(rs.getString(4));
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Consultar datos de un turno:\n"+ ex.getMessage());
        }
        return turno;
    }
}
