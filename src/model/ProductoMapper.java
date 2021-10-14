package model;

import aplication_class.CProducto;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoMapper {
    private Statement st;
    private ResultSet rs;
    private Connection cn;
    
    public ProductoMapper(){
        cn = Conexion.Conectar();
    }
    
    public void cargarPresentacion(JComboBox cb){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT descripcion FROM t_presentacion ORDER BY descripcion ASC;");
            while(rs.next()){
                cb.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public void cargarPresentacion(TextAutoCompleter tx){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT descripcion FROM t_presentacion ORDER BY descripcion ASC;");
            while(rs.next()){
                tx.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public void mostrarPresentacion(DefaultTableModel modelo, String presentacion){
        try {
            int i=1;
            st = cn.createStatement();
            rs = st.executeQuery("SELECT descripcion, id_presentacion FROM t_presentacion WHERE descripcion like '%"+presentacion+"%' ORDER BY descripcion ASC;");
            while(rs.next()){
                modelo.addRow(new String[]{""+(i++),rs.getString(1),rs.getString(2)});
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public String obtenerIdPresentacion(String presentacion){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT id_presentacion FROM t_presentacion WHERE descripcion='"+presentacion+"';");
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException ex) {return "0";}
        return "0";
    }
    
    public int validarPresentacion(String presentacion){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM t_presentacion WHERE descripcion='"+presentacion+"';");
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException ex) {return -1;}
        return -1;
    }
    
    public void insertarPresentacion(String presentacion){
        try {
            st = cn.createStatement();
            st.executeUpdate("INSERT INTO t_presentacion VALUES(null,'"+presentacion+"');");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public void actualizarPresentacion(String idPresentacion, String presentacion){
        try {
            st = cn.createStatement();
            st.executeUpdate("UPDATE t_presentacion SET descripcion='"+presentacion+"' WHERE id_presentacion='"+idPresentacion+"';");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public void eliminarPresentacion(String idPresentacion){
        try {
            st = cn.createStatement();
            st.executeUpdate("DELETE FROM t_presentacion WHERE id_presentacion='"+idPresentacion+"';");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    //PRODUCTO
    public void mostrarProducto(DefaultTableModel modelo, String nompreProducto, String presentacion){
        String categoria = "";
        if(presentacion != null)
            categoria = "AND p.id_presentacion=(SELECT id_presentacion FROM t_presentacion WHERE descripcion='"+presentacion+"') ";
        try {
            st = cn.createStatement();
            String query = "SELECT p.id_producto, p.nombre, p.precio_venta_unitario, date_format(pf.fecha_vencimiento,'%d/%m/%Y'), pf.stock_actual "
                   .concat("FROM t_producto p INNER JOIN t_producto_fechav pf on pf.id_producto = p.id_producto ")
                   .concat("WHERE pf.estado = 1 AND p.nombre LIKE '%"+nompreProducto+"%' ")
                   .concat(categoria)
                   .concat("ORDER BY p.nombre ASC;");
            rs = st.executeQuery(query);
            int i=1;
            while(rs.next()){
                modelo.addRow(new String[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(4),rs.getString(3),rs.getString(5)});
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public void mostrarControlProducto(DefaultTableModel modelo, String nompreProducto, String presentacion){
        String categoria = "";
        if(!presentacion.equals(""))
            categoria = "AND p.id_presentacion=(SELECT id_presentacion FROM t_presentacion WHERE descripcion='"+presentacion+"') ";
        try {
            st = cn.createStatement();
            String query = "SELECT p.id_producto, tp.descripcion, p.nombre, date_format(pf.fecha_vencimiento,'%d/%m/%Y'), p.precio_venta_unitario, pf.stock_actual "
                   .concat("FROM t_producto p INNER JOIN t_producto_fechav pf ON pf.id_producto = p.id_producto ")
                   .concat("INNER JOIN t_presentacion tp ON tp.id_presentacion = p.id_presentacion ")
                   .concat("WHERE pf.estado = 1 AND p.nombre LIKE '%"+nompreProducto+"%' ")
                   .concat(categoria)
                   .concat("ORDER BY p.nombre ASC;");
            rs = st.executeQuery(query);
            int i=1;
            while(rs.next()){
                modelo.addRow(new Object[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),Double.parseDouble(rs.getString(5)),rs.getString(6)});
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }
    
    public CProducto consultarProducto(String idProducto, String fechaVencimiento){
        CProducto res = new CProducto();
        try {
            st = cn.createStatement();
            String query = "SELECT p.id_presentacion, p.id_producto, p.nombre, p.indicacion, p.precio_venta_unitario, p.stock_minimo, date_format(pf.fecha_vencimiento,'%d/%m/%Y'), pf.stock_actual, "
                   .concat("pf.id_producto_fechav, pf.precio_compra_total, pf.precio_compra_unitario, (SELECT descripcion FROM t_presentacion WHERE id_presentacion=p.id_presentacion) AS presentacion ")
                   .concat("FROM t_producto p INNER JOIN t_producto_fechav pf on pf.id_producto = p.id_producto ")
                   .concat("WHERE p.id_producto = '"+idProducto+"' AND date_format(pf.fecha_vencimiento,'%d/%m/%Y')='"+fechaVencimiento+"' ORDER BY p.nombre ASC, pf.id_producto ASC;");
            rs = st.executeQuery(query);
            if(rs.next()){
                res.setIdPresentacion(rs.getString(1));
                res.setIdProducto(rs.getString(2));
                res.setNombre(rs.getString(3));
                res.setIndicacion(rs.getString(4));
                res.setPrecioVentaUnitario(Double.parseDouble(rs.getString(5)));
                res.setStockMinimo(Integer.parseInt(rs.getString(6)));
                res.setFechaVencimiento(rs.getString(7));
                res.setStockActual(Integer.parseInt(rs.getString(8)));
                res.setIdProductoFechav(Integer.parseInt(rs.getString(9)));
                res.setPrecioCompraTotal(Double.parseDouble(rs.getString(10)));
                res.setPrecioCompraUnitario(Double.parseDouble(rs.getString(11)));
                res.setPresentacion(rs.getString(12));
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
        return res;
    }
    
    public String obtenerIndicacionProducto(String idProducto){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT indicacion FROM t_producto WHERE id_producto='"+idProducto+"'");
            if (rs.next()){
                return rs.getString(1);
            }else return null;
        } catch (SQLException ex) {return null;}
    }
    
    public int insertarProducto(CProducto p){
        try {
            st = cn.createStatement();
            return st.executeUpdate("INSERT INTO t_producto (id_producto,nombre,indicacion,precio_venta_unitario,stock_minimo,id_presentacion) VALUES('"+p.getIdProducto()+"','"+p.getNombre()+"','"+p.getIndicacion()+"',"+p.getPrecioVentaUnitario()+","+p.getStockMinimo()+","+p.getIdPresentacion()+");");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
    
    public int actualizarProducto(CProducto p){
        try {
            st = cn.createStatement();
            return st.executeUpdate("UPDATE t_producto SET nombre='"+p.getNombre()+"',indicacion='"+p.getIndicacion()+"',precio_venta_unitario="+p.getPrecioVentaUnitario()+",stock_minimo="+p.getStockMinimo()+",id_presentacion="+p.getIdPresentacion()+" WHERE id_producto='"+p.getIdProducto()+"';");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
    
    public int insertarProductoFechav(CProducto p){
        try {
            st = cn.createStatement();
            return st.executeUpdate("INSERT INTO t_producto_fechav (id_producto_fechav,id_producto,fecha_vencimiento,precio_compra_total,precio_compra_unitario,stock_actual,estado) VALUES(null,'"+p.getIdProducto()+"','"+p.getFechaVencimiento()+"',"+p.getPrecioCompraTotal()+","+p.getPrecioCompraUnitario()+","+p.getStockActual()+",1);");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
    
    public int actualizarProductoFechav(CProducto p){
        try {
            st = cn.createStatement();
            return st.executeUpdate("UPDATE t_producto_fechav SET fecha_vencimiento='"+p.getFechaVencimiento()+"',precio_compra_total="+p.getPrecioCompraTotal()+",precio_compra_unitario="+p.getPrecioCompraUnitario()+",stock_actual="+p.getStockActual()+" WHERE id_producto_fechav="+p.getIdProductoFechav()+";");
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
    
    public int obtenerCantidadProductoDetalle(String idProducto){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT COUNT(*) FROM t_producto_fechav WHERE id_producto='"+idProducto+"'");
            if (rs.next()){
                return Integer.parseInt(rs.getString(1));
            }else return 0;
        } catch (SQLException ex) {return 0;}
    }
    
    public int obtenerStockProducto(String idProducto){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT SUM(stock_actual) FROM t_producto_fechav WHERE estado = 1 AND id_producto='"+idProducto+"'");
            if (rs.next()){
                return Integer.parseInt(rs.getString(1));
            }else return 0;
        } catch (SQLException ex) {return 0;}
    }
    
    public int eliminarProducto(String idProducto){
        try {
            st = cn.createStatement();
            return st.executeUpdate("DELETE FROM t_producto WHERE id_producto="+idProducto);
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
    
    public int eliminarProductoFechav(int idProductoFechav){
        try {
            st = cn.createStatement();
            return st.executeUpdate("DELETE FROM t_producto_fechav WHERE id_producto_fechav="+idProductoFechav);
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
    
    public int actualizarEstadoProductoFechav(int idProductoFechav){
        try {
            st = cn.createStatement();
            return st.executeUpdate("UPDATE t_producto_fechav SET estado = 0 WHERE id_producto_fechav="+idProductoFechav);
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); return 0;}
    }
}
