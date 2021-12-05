package model;

import aplication_class.CReporte;
import aplication_class.CReporteMonto;
import aplication_class.CReporteSolicitud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import view.Main;

public class ReporteMapper {
    private Statement st;
    private ResultSet rs;
    private final Connection cn;
    
    public ReporteMapper(){
        cn = Conexion.conectar();
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
        }catch(SQLException ex){
            Main.txlog.setText(Main.txlog.getText() +"\n======= Listar reporte diario:\n"+ ex.getMessage());
        }
    }
    
    public List listarReporteDiario(CReporteSolicitud solicitud){
        if(solicitud.getProducto()==null) solicitud.setProducto("");
        List lista = new ArrayList();
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
                CReporte reporte = new CReporte();
                String turno = rs.getString(7);
                if (turno == null) turno = "Fuera de turno";
                reporte.setNumeracion(""+(i++));
                reporte.setPresentacion(rs.getString(1));
                reporte.setProducto(rs.getString(2));
                reporte.setCantidad(rs.getString(3));
                reporte.setMonto(rs.getString(4));
                reporte.setHora(rs.getString(5));
                reporte.setEncargado(rs.getString(6).toUpperCase());
                reporte.setTurno(turno);
                lista.add(reporte);
            }
        }catch(SQLException ex){
            Main.txlog.setText(Main.txlog.getText() +"\n======= Listar reporte diario:\n"+ ex.getMessage());
        }
        return lista;
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
        }catch(SQLException ex){
            Main.txlog.setText(Main.txlog.getText() +"\n======= Listar reporte general:\n"+ ex.getMessage());
        }
    }
    
    public List listarReporteGeneral(CReporteSolicitud solicitud){
        if(solicitud.getProducto()==null) solicitud.setProducto("");
        List lista = new ArrayList();
        try{
            int i = 1;
            st = cn.createStatement();
            String query = "SELECT pr.descripcion,p.nombre,SUM(vd.cantidad_producto),SUM(vd.monto-vd.descuento),DATE_FORMAT(v.fecha_venta,'%d/%m/%Y'),u.nombre,t.descripcion "
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
                    query = query.concat("GROUP BY pr.descripcion,p.nombre,u.nombre,t.descripcion ORDER BY v.fecha_venta ASC");
            rs = st.executeQuery(query);
            while(rs.next()){
                CReporte reporte = new CReporte();
                String turno = rs.getString(7);
                if (turno == null) turno = "Fuera de turno";
                reporte.setNumeracion(""+(i++));
                reporte.setPresentacion(rs.getString(1));
                reporte.setProducto(rs.getString(2));
                reporte.setCantidad(rs.getString(3));
                reporte.setMonto(rs.getString(4));
                reporte.setFecha(rs.getString(5));
                reporte.setEncargado(rs.getString(6).toUpperCase());
                reporte.setTurno(turno);
                lista.add(reporte);
            }
        }catch(SQLException ex){
            Main.txlog.setText(Main.txlog.getText() +"\n======= Listar reporte general:\n"+ ex.getMessage());
        }
        return lista;
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
        }catch(SQLException ex){
            Main.txlog.setText(Main.txlog.getText() +"\n======= Listar Monto diario:\n"+ ex.getMessage());
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
        }catch(SQLException ex){
            Main.txlog.setText(Main.txlog.getText() +"\n======= listar monto mensual:\n"+ ex.getMessage());
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
        }catch(SQLException ex){
            Main.txlog.setText(Main.txlog.getText() +"\n======= listar monto general:\n"+ ex.getMessage());
        }
        return lista;
    }
}
