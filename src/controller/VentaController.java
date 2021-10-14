package controller;

import aplication_class.CDevolucion;
import aplication_class.CVenta;
import javax.swing.table.DefaultTableModel;
import model.VentaMapper;

public class VentaController {
    public VentaMapper ventaMapper;
    
    public VentaController(){
        ventaMapper = new VentaMapper();
    }
    
    public int insertarVenta(CVenta venta){
        if(ventaMapper.insertarVenta(venta)==1){
            return ventaMapper.obtenerUltimoId();
        }
        return 0;
    }
    
    public void insertarVentaDetalle(CVenta venta){
        ventaMapper.insertarDetalleVenta(venta);
    }
    
    public double ventaDia(String fecha){
        return ventaMapper.ventaDia(fecha);
    }
    
    //DEVOLUCIÓN
    public double obtenerPrecioUnitario(String idProducto){
        return ventaMapper.obtenerPrecioUnitario(idProducto);
    }
    
    public void mostrarProductoParaDevolucion(DefaultTableModel modelo, String nompreProducto){
        ventaMapper.mostrarProductoParaDevolucion(modelo, nompreProducto);
    }
    
    public void insertarDevolucionProducto(CDevolucion devolucion){
        ventaMapper.insertarDevolucionProducto(devolucion);
    }
    
    public void mostrarDevoluciones(DefaultTableModel modelo, String nompreProducto){
        ventaMapper.mostrarDevoluciones(modelo, nompreProducto);
    }
}
