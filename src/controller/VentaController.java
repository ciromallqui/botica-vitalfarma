package controller;

import MFC.util.JLibrary.DecimalNumber;
import aplication_class.CDevolucion;
import aplication_class.CTurno;
import aplication_class.CVenta;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.TurnoMapper;
import model.VentaMapper;

public class VentaController {
    public VentaMapper ventaMapper;
    public TurnoMapper turnoMapper;
    
    public VentaController(){
        ventaMapper = new VentaMapper();
        turnoMapper = new TurnoMapper();
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
    
    public void mostrarProductoVentaDiario(DefaultTableModel model, String nompreProducto, String usuario){
        List<CTurno> lt = turnoMapper.listarTurno();
        List<CVenta> lv = ventaMapper.mostrarProductoVentaDiario(nompreProducto, usuario);
        double monto = 0.0;
        double montoTotal = 0.0;
        if(lv.size() > 0){
            int i = 1;
            for (CTurno t : lt) {
                for (CVenta v : lv) {
                    if(t.getNombre().equals(v.getTurno())){
                        model.addRow(new Object[]{""+(i++),v.getPresentacion(),"<html><body style='font-weight: bold;'>"+ v.getProducto() +"<html><body>",v.getLaboratorio(),v.getFechaVenta(),v.getCantidad(),DecimalNumber.ReduceDecimal(v.getMonto(),2),v.getTurno()});
                        monto = monto + v.getMonto();
                    }
                }
                i = 1;
                if(monto > 0.0){
                    model.addRow(new Object[]{"","","","","","<html><body style='color: blue;font-weight: bold;'>MONTO TURNO</body></html>","<html><body style='color: blue;font-weight: bold;'>"+DecimalNumber.ReduceDecimal(monto,2)+"</body></html>","<html><body style='color: blue;font-weight: bold;'>"+t.getNombre()+"</body></html>"});
                    montoTotal = montoTotal + monto;
                }
                monto = 0.0;
            }
            model.addRow(new Object[]{"","","","","","<html><body style='color: blue;font-weight: bold;'>MONTO TOTAL</body></html>","<html><body style='color: blue;font-weight: bold;'>"+DecimalNumber.ReduceDecimal(montoTotal,2)+"</body></html>",""});
        }
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
