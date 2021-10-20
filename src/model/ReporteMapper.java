package model;

import aplication_class.CReporteMonto;
import aplication_class.CReporteSolicitud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteMapper {
    private Statement st;
    private ResultSet rs;
    private final Connection cn;
    
    public ReporteMapper(){
        cn = Conexion.Conectar();
    }
    
    public void listarReporteDiario(DefaultTableModel model, CReporteSolicitud solicitud){
        if(solicitud.getProducto()==null) solicitud.setProducto("");
        try{
            int i = 1;
            st = cn.createStatement();
            String query = "SELECT pr.descripcion,p.nombre,vd.cantidad_producto,vd.monto-vd.descuento,TIME(v.fecha_venta) AS hora,u.nombre,t.descripcion "
                    .concat("FROM t_venta v INNER JOIN t_venta_detalle vd ON vd.id_venta = v.id_venta INNER JOIN t_producto_fechav pf ON pf.id_producto_fechav = vd.id_producto_fechav ")
                    .concat("INNER JOIN t_producto p ON p.id_producto = pf.id_producto INNER JOIN t_usuario u ON u.id_usuario = v.id_usuario LEFT JOIN t_turno t ON t.id_turno = v.id_turno ")
                    .concat("INNER JOIN t_presentacion pr ON pr.id_presentacion = p.id_presentacion ")
                    .concat("WHERE vd.estado <> 2 AND v.estado <> 2 AND p.nombre like '%"+solicitud.getProducto()+"%' ");
                    if(solicitud.getFechaVenta() != null)
                        query = query.concat("AND DATE(v.fecha_venta) = '"+solicitud.getFechaVenta()+"' ");
                    if(solicitud.getTurno() != null)
                        query = query.concat("AND t.descripcion = '"+solicitud.getTurno()+"' ");
                    if(solicitud.getPresentacion()!= null)
                        query = query.concat("AND pr.descripcion = '"+solicitud.getPresentacion()+"' ");
                    
            rs = st.executeQuery(query);
            while(rs.next()){
                String turno = rs.getString(7);
                if (turno == null) turno = "Fuera de turno";
                model.addRow(new String[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6).toUpperCase(),turno});
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void listarReporteGeneral(DefaultTableModel model, CReporteSolicitud solicitud){
        if(solicitud.getProducto()==null) solicitud.setProducto("");
        try{
            int i = 1;
            st = cn.createStatement();
            String query = "SELECT pr.descripcion,p.nombre,SUM(vd.cantidad_producto),SUM(vd.monto-vd.descuento),u.nombre,t.descripcion "
                    .concat("FROM t_venta v INNER JOIN t_venta_detalle vd ON vd.id_venta = v.id_venta LEFT JOIN t_producto_fechav pf ON pf.id_producto_fechav = vd.id_producto_fechav ")
                    .concat("INNER JOIN t_producto p ON p.id_producto = pf.id_producto INNER JOIN t_usuario u ON u.id_usuario = v.id_usuario LEFT JOIN t_turno t ON t.id_turno = v.id_turno ")
                    .concat("INNER JOIN t_presentacion pr ON pr.id_presentacion = p.id_presentacion ")
                    .concat("WHERE vd.estado <> 2 AND v.estado <> 2 AND p.nombre like '%"+solicitud.getProducto()+"%' ");
                    if(solicitud.getMes()> 0)
                        query = query.concat("AND MONTH(v.fecha_venta) = "+solicitud.getMes()+" ");
                    if(solicitud.getFechaVentaInicial()!= null)
                        query = query.concat("AND DATE(v.fecha_venta) BETWEEN '"+solicitud.getFechaVentaInicial()+"' AND '"+solicitud.getFechaVentaFinal()+"' ");
                    if(solicitud.getTurno() != null)
                        query = query.concat("AND t.descripcion = '"+solicitud.getTurno()+"' ");
                    if(solicitud.getPresentacion()!= null)
                        query = query.concat("AND pr.descripcion = '"+solicitud.getPresentacion()+"' ");
                    query = query.concat("GROUP BY pr.descripcion,p.nombre,u.nombre,t.descripcion ORDER BY p.nombre ASC");
            rs = st.executeQuery(query);
            while(rs.next()){
                String turno = rs.getString(6);
                if (turno == null) turno = "Fuera de turno";
                model.addRow(new String[]{""+(i++),rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5).toUpperCase(),turno});
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public List<CReporteMonto> listaMontoDiario(CReporteSolicitud solicitud){
        if(solicitud.getProducto()==null) solicitud.setProducto("");
        List<CReporteMonto> lista = new ArrayList<CReporteMonto>();
        try{
            st = cn.createStatement();
            String query = "SELECT SUM(vd.monto-vd.descuento), SUM(vd.precio_compra_unitario * vd.cantidad_producto), t.descripcion "
                    .concat("FROM t_venta v INNER JOIN t_venta_detalle vd ON vd.id_venta = v.id_venta INNER JOIN t_producto_fechav pf ON pf.id_producto_fechav = vd.id_producto_fechav ")
                    .concat("INNER JOIN t_producto p ON p.id_producto = pf.id_producto INNER JOIN t_usuario u ON u.id_usuario = v.id_usuario LEFT JOIN t_turno t ON t.id_turno = v.id_turno ")
                    .concat("INNER JOIN t_presentacion pr ON pr.id_presentacion = p.id_presentacion ")
                    .concat("WHERE vd.estado <> 2 AND v.estado <> 2 AND p.nombre like '%"+solicitud.getProducto()+"%' ");
                    if(solicitud.getFechaVenta() != null)
                        query = query.concat("AND DATE(v.fecha_venta) = '"+solicitud.getFechaVenta()+"' ");
                    if(solicitud.getTurno() != null)
                        query = query.concat("AND t.descripcion = '"+solicitud.getTurno()+"' ");
                    if(solicitud.getPresentacion()!= null)
                        query = query.concat("AND pr.descripcion = '"+solicitud.getPresentacion()+"' ");
                    query = query.concat("GROUP BY t.descripcion ORDER BY t.id_turno ASC;");
                    
            rs = st.executeQuery(query);
            while(rs.next()){
                CReporteMonto item = new CReporteMonto();
                item.setMontoVenta(rs.getString(1));
                item.setMontoCompra(String.valueOf(rs.getDouble(2)));
                item.setTurno(rs.getString(3));
                lista.add(item);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }
    
    public List<CReporteMonto> listaMontoMensual(CReporteSolicitud solicitud){
        if(solicitud.getProducto()==null) solicitud.setProducto("");
        List<CReporteMonto> lista = new ArrayList<CReporteMonto>();
        
        try{
            st = cn.createStatement();
            String query = "SELECT SUM(vd.monto-vd.descuento), SUM(vd.precio_compra_unitario * vd.cantidad_producto), t.descripcion "
                    .concat("FROM t_venta v INNER JOIN t_venta_detalle vd ON vd.id_venta = v.id_venta LEFT JOIN t_producto_fechav pf ON pf.id_producto_fechav = vd.id_producto_fechav ")
                    .concat("INNER JOIN t_producto p ON p.id_producto = pf.id_producto INNER JOIN t_usuario u ON u.id_usuario = v.id_usuario LEFT JOIN t_turno t ON t.id_turno = v.id_turno ")
                    .concat("INNER JOIN t_presentacion pr ON pr.id_presentacion = p.id_presentacion ")
                    .concat("WHERE vd.estado <> 2 AND v.estado <> 2 AND p.nombre like '%"+solicitud.getProducto()+"%' ");
                    if(solicitud.getMes()> 0)
                        query = query.concat("AND MONTH(v.fecha_venta) = "+solicitud.getMes()+" ");
                    if(solicitud.getTurno() != null)
                        query = query.concat("AND t.descripcion = '"+solicitud.getTurno()+"' ");
                    if(solicitud.getPresentacion()!= null)
                        query = query.concat("AND pr.descripcion = '"+solicitud.getPresentacion()+"' ");
                    query = query.concat("GROUP BY t.descripcion ORDER BY t.id_turno ASC;");
            rs = st.executeQuery(query);
            while(rs.next()){
                CReporteMonto item = new CReporteMonto();
                item.setMontoVenta(rs.getString(1));
                item.setMontoCompra(String.valueOf(rs.getDouble(2)));
                item.setTurno(rs.getString(3));
                lista.add(item);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }
    
    public List<CReporteMonto> listaMontoGeneral(CReporteSolicitud solicitud){
        if(solicitud.getProducto()==null) solicitud.setProducto("");
        List<CReporteMonto> lista = new ArrayList<CReporteMonto>();
        try{
            st = cn.createStatement();
            String query = "SELECT SUM(vd.monto - vd.descuento), SUM(vd.precio_compra_unitario * vd.cantidad_producto), t.descripcion "
                    .concat("FROM t_venta v INNER JOIN t_venta_detalle vd ON vd.id_venta = v.id_venta LEFT JOIN t_producto_fechav pf ON pf.id_producto_fechav = vd.id_producto_fechav ")
                    .concat("INNER JOIN t_producto p ON p.id_producto = pf.id_producto INNER JOIN t_usuario u ON u.id_usuario = v.id_usuario LEFT JOIN t_turno t ON t.id_turno = v.id_turno ")
                    .concat("INNER JOIN t_presentacion pr ON pr.id_presentacion = p.id_presentacion ")
                    .concat("WHERE vd.estado <> 2 AND v.estado <> 2 AND p.nombre like '%"+solicitud.getProducto()+"%' ");
                    if(solicitud.getFechaVentaInicial()!= null)
                        query = query.concat("AND DATE(v.fecha_venta) BETWEEN '"+solicitud.getFechaVentaInicial()+"' AND '"+solicitud.getFechaVentaFinal()+"' ");
                    if(solicitud.getTurno() != null)
                        query = query.concat("AND t.descripcion = '"+solicitud.getTurno()+"' ");
                    if(solicitud.getPresentacion()!= null)
                        query = query.concat("AND pr.descripcion = '"+solicitud.getPresentacion()+"' ");
                    query = query.concat("GROUP BY t.descripcion ORDER BY t.id_turno ASC;");
            rs = st.executeQuery(query);
            while(rs.next()){
                CReporteMonto item = new CReporteMonto();
                item.setMontoVenta(rs.getString(1));
                item.setMontoCompra(String.valueOf(rs.getDouble(2)));
                item.setTurno(rs.getString(3));
                lista.add(item);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return lista;
    }
}
