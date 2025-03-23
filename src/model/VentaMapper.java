package model;

import aplication_class.CDevolucion;
import aplication_class.CVenta;
import cross_cuting.Validar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.Main;

public class VentaMapper {
    private Statement st;
    private ResultSet rs;
    private final Connection cn;
    
    public VentaMapper(){
        cn = Conexion.conectar();
    }
    
    public int insertarVenta(CVenta v){
        int res;
        try {
            st = cn.createStatement();
            res = st.executeUpdate("INSERT INTO t_venta (id_usuario,id_turno,monto_total,fecha_venta,estado) VALUES("+v.getIdUsuario()+","+v.getIdTurno()+","+v.getMontoTotal()+",'"+v.getFechaVenta()+"','1');");
            return res;
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Insertar venta:\n"+ ex.getMessage());
            return 0;
        }
    }
    
    public void insertarDetalleVenta(CVenta v){
        try {
            st = cn.createStatement();
            st.executeUpdate("INSERT INTO t_venta_detalle (id_venta,id_producto_fechav,cantidad_producto,monto,descuento,precio_compra_unitario,estado) VALUES("+v.getIdVenta()+","+v.getIdProductoFechav()+","+v.getCantidadProducto()+","+v.getMonto()+","+v.getDescuento()+","+v.getPrecioCompraUnitario()+",'1');");
            st.executeUpdate("UPDATE t_producto_fechav SET stock_actual=stock_actual-"+v.getCantidadProducto()+", precio_compra_total=precio_compra_total-(precio_compra_unitario*"+v.getCantidadProducto()+") WHERE id_producto_fechav="+v.getIdProductoFechav());
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= insertar detalles de la venta:\n"+ ex.getMessage());
        }
    }
    
    public int obtenerUltimoId(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT MAX(id_venta) FROM t_venta;");
            if(rs.next()){
                return Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Obtener el último identificador de la venta:\n"+ ex.getMessage());
        }
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
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Mostrar el monto de la venta del día:\n"+ ex.getMessage());
        }
        return venta;
    }
    
    public List<CVenta> mostrarProductoVentaDiario(String nompreProducto, String usuario){
        List<CVenta> lv = new ArrayList<>();
        try {
            st = cn.createStatement();
            String complement = "to_char(v.fecha_venta, 'dd/mm/YYYY')";
            if(Validar.dbengine().equals("mysql")){complement = "DATE_FORMAT(v.fecha_venta,'%d/%m/%Y')";}
            String query = "SELECT p.id_producto, tp.descripcion, p.nombre, p.laboratorio, "+complement+", vd.cantidad_producto, (vd.monto - vd.descuento), t.descripcion, t.id_turno "
                   .concat("FROM t_producto p INNER JOIN t_producto_fechav pf ON pf.id_producto = p.id_producto ")
                   .concat("INNER JOIN t_presentacion tp ON tp.id_presentacion = p.id_presentacion ")
                   .concat("INNER JOIN t_venta_detalle vd ON vd.id_producto_fechav = pf.id_producto_fechav ")
                   .concat("INNER JOIN t_venta v ON v.id_venta = vd.id_venta ")
                   .concat("INNER JOIN t_turno t ON t.id_turno = v.id_turno ")
                   .concat("INNER JOIN t_usuario u ON u.id_usuario = v.id_usuario ")
                   .concat("WHERE vd.estado <> 2 AND u.nombre_usuario = '"+usuario+"' AND p.nombre LIKE '%"+nompreProducto+"%' ")
                   .concat("AND DATE(v.fecha_venta) = DATE(NOW()) ")
//                   .concat("GROUP BY p.id_producto, tp.descripcion, p.nombre, p.laboratorio, date_format(v.fecha_venta,'%d/%m/%Y'), t.descripcion, t.id_turno ")
                   .concat("ORDER BY t.id_turno, v.fecha_venta DESC;");
//                   .concat("ORDER BY t.id_turno, p.nombre, tp.descripcion;");
            rs = st.executeQuery(query);
//            int i=1;
            while(rs.next()){
                CVenta v = new CVenta();
                v.setIdProducto(rs.getString(1));
                v.setPresentacion(rs.getString(2));
                v.setProducto(rs.getString(3));
                v.setLaboratorio(rs.getString(4));
                v.setFechaVenta(rs.getString(5));
                v.setCantidad(rs.getInt(6));
                v.setMonto(rs.getDouble(7));
                v.setTurno(rs.getString(8));
                v.setIdTurno(rs.getInt(9));
                lv.add(v);
                //modelo.addRow(new Object[]{""+(i++),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Mostrar productos en el detalle de ventas:\n"+ ex.getMessage());
        }
        return lv;
    }
    
    //DEVOLUCIÓN
    public void insertarDevolucionProducto(CDevolucion d){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT FN_DEVOLUCION("+d.getIdVenta()+","+d.getIdVentaDetalle()+","+d.getCantidadProducto()+","+d.getMontoDevolucion()+");");
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Insertar una devolución del producto:\n"+ ex.getMessage());
        }
    }
    
    public void mostrarProductoParaDevolucion(DefaultTableModel modelo, String nompreProducto){
        try {
            st = cn.createStatement();
            String complement = "to_char(v.fecha_venta, 'dd/mm/YYYY HH12:MI:SS')";
            if(Validar.dbengine().equals("mysql")){complement = "DATE_FORMAT(v.fecha_venta,'%d/%m/%Y %h:%i:%S %p')";}
            String query = "SELECT p.id_producto, tp.descripcion, p.nombre, "+complement+", vd.cantidad_producto, (vd.monto - vd.descuento), vd.id_venta,vd.id_venta_detalle "
                   .concat("FROM t_producto p INNER JOIN t_producto_fechav pf ON pf.id_producto = p.id_producto ")
                   .concat("INNER JOIN t_presentacion tp ON tp.id_presentacion = p.id_presentacion ")
                   .concat("INNER JOIN t_venta_detalle vd ON vd.id_producto_fechav = pf.id_producto_fechav ")
                   .concat("INNER JOIN t_venta v ON v.id_venta = vd.id_venta ")
                   .concat("WHERE vd.estado <> 2 AND p.nombre LIKE '%"+nompreProducto+"%' ")
//                   .concat("AND (DATE(v.fecha_venta) = DATE(NOW()) OR DATE(v.fecha_venta) = (DATE(NOW())) - INTERVAL 1 DAY) ")
                   .concat("AND (DATE(v.fecha_venta) = DATE(NOW()) OR DATE(v.fecha_venta) = DATE(NOW()) - INTERVAL '1 day') ")
                   .concat("ORDER BY v.fecha_venta DESC;");
            rs = st.executeQuery(query);
            int i=1;
            while(rs.next()){
                modelo.addRow(new Object[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)+","+rs.getString(8)});
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Mostrar productos para la devolución:\n"+ ex.getMessage());
        }
    }
    
    public void mostrarDevoluciones(DefaultTableModel modelo, String nompreProducto){
        try {
            st = cn.createStatement();
            String complement = "to_char(d.fecha_devolucion, 'dd/mm/YYYY')";
            if(Validar.dbengine().equals("mysql")){complement = "DATE_FORMAT(d.fecha_devolucion,'%d/%m/%Y')";}
            String query = "SELECT p.nombre, d.cantidad, d.monto, "+complement+" "
                   .concat("FROM t_devolucion d INNER JOIN t_venta_detalle vd ON vd.id_venta_detalle = d.id_venta_detalle ")
                   .concat("INNER JOIN t_producto_fechav pf ON pf.id_producto_fechav = vd.id_producto_fechav ")
                   .concat("INNER JOIN t_producto p ON p.id_producto = pf.id_producto ")
                   .concat("WHERE p.nombre LIKE '%"+nompreProducto+"%' ")
                   .concat("ORDER BY d.fecha_devolucion DESC;");
            rs = st.executeQuery(query);
            int i=1;
            while(rs.next()){
                modelo.addRow(new Object[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Mostrar productos devueltos:\n"+ ex.getMessage());
        }
    }
    
    public double obtenerPrecioUnitario(String idProducto){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT precio_venta_unitario FROM t_producto WHERE id_producto = '"+idProducto+"';");
            if(rs.next()){
                return rs.getDouble(1);
            }
            cn.close();
            st.close();
        } catch (SQLException ex) {
            Main.txlog.setText(Main.txlog.getText() +"\n======= Obtener precio untario del producto:\n"+ ex.getMessage());
        }
        return 0.00;
    }
}
