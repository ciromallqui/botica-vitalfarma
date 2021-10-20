package model;

import aplication_class.CDevolucion;
import aplication_class.CVenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentaMapper {
    private Statement st;
    private ResultSet rs;
    private Connection cn;
    
    public VentaMapper(){
        cn = Conexion.Conectar();
    }
    
    public int insertarVenta(CVenta v){
        try {
            st = cn.createStatement();
            return st.executeUpdate("INSERT INTO t_venta (id_venta,id_usuario,id_turno,monto_total,fecha_venta,estado) VALUES(null,"+v.getIdUsuario()+","+v.getIdTurno()+","+v.getMontoTotal()+",'"+v.getFechaVenta()+"','1');");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
    
    public void insertarDetalleVenta(CVenta v){
        try {
            st = cn.createStatement();
            st.executeUpdate("INSERT INTO t_venta_detalle (id_venta_detalle,id_venta,id_producto_fechav,cantidad_producto,monto,descuento,precio_compra_unitario,estado) VALUES(null,"+v.getIdVenta()+","+v.getIdProductoFechav()+","+v.getCantidadProducto()+","+v.getMonto()+","+v.getDescuento()+","+v.getPrecioCompraUnitario()+",'1');");
            st.executeUpdate("UPDATE t_producto_fechav SET stock_actual=stock_actual-"+v.getCantidadProducto()+", precio_compra_total=precio_compra_total-(precio_compra_unitario*"+v.getCantidadProducto()+") WHERE id_producto_fechav="+v.getIdProductoFechav());
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public int obtenerUltimoId(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT MAX(id_venta) FROM t_venta;");
            if(rs.next()){
                return Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {}
        return 0;
    }
    
    public double ventaDia(String fecha){
        double venta=0.00;
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT SUM(monto_total) FROM t_venta WHERE DATE(fecha_venta)='"+fecha+"' AND estado <> 2;");
            if(rs.next()){
                venta = rs.getDouble(1);
            }
        } catch (SQLException ex) {}
        return venta;
    }
    
    //DEVOLUCIÓN
    public void insertarDevolucionProducto(CDevolucion d){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT FN_DEVOLUCION("+d.getIdVenta()+","+d.getIdVentaDetalle()+","+d.getCantidadProducto()+","+d.getMontoDevolucion()+") FROM dual;");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public void mostrarProductoParaDevolucion(DefaultTableModel modelo, String nompreProducto){
        try {
            st = cn.createStatement();
            String query = "SELECT p.id_producto, tp.descripcion, p.nombre, date_format(v.fecha_venta,'%d/%m/%Y %h:%i:%S %p'), vd.cantidad_producto, (vd.monto - vd.descuento), vd.id_venta,vd.id_venta_detalle "
                   .concat("FROM t_producto p INNER JOIN t_producto_fechav pf ON pf.id_producto = p.id_producto ")
                   .concat("INNER JOIN t_presentacion tp ON tp.id_presentacion = p.id_presentacion ")
                   .concat("INNER JOIN t_venta_detalle vd ON vd.id_producto_fechav = pf.id_producto_fechav ")
                   .concat("INNER JOIN t_venta v ON v.id_venta = vd.id_venta ")
                   .concat("WHERE vd.estado <> 2 AND p.nombre LIKE '%"+nompreProducto+"%' ")
                   .concat("AND (DATE(v.fecha_venta) = DATE(NOW()) OR DATE(v.fecha_venta) = (DATE(NOW())) - INTERVAL 1 DAY)")
                   .concat("ORDER BY v.fecha_venta ASC;");
            rs = st.executeQuery(query);
            int i=1;
            while(rs.next()){
                modelo.addRow(new Object[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)+","+rs.getString(8)});
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public void mostrarDevoluciones(DefaultTableModel modelo, String nompreProducto){
        try {
            st = cn.createStatement();
            String query = "SELECT p.nombre, d.cantidad, d.monto, date_format(d.fecha_devolucion,'%d/%m/%Y') "
                   .concat("FROM t_devolucion d INNER JOIN t_venta_detalle vd ON vd.id_venta_detalle = d.id_venta_detalle ")
                   .concat("INNER JOIN t_producto_fechav pf ON pf.id_producto_fechav = vd.id_producto_fechav ")
                   .concat("INNER JOIN t_producto p ON p.id_producto = pf.id_producto ")
                   .concat("WHERE p.nombre LIKE '%"+nompreProducto+"%' ")
                   .concat("ORDER BY d.fecha_devolucion ASC;");
            rs = st.executeQuery(query);
            int i=1;
            while(rs.next()){
                modelo.addRow(new Object[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public double obtenerPrecioUnitario(String idProducto){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT precio_venta_unitario FROM t_producto WHERE id_producto = '"+idProducto+"';");
            if(rs.next()){
                return rs.getDouble(1);
            }
        } catch (SQLException ex) {}
        return 0.00;
    }
}
