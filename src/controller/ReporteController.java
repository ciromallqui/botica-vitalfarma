package controller;

import aplication_class.CReporteSolicitud;
import javax.swing.table.DefaultTableModel;
import model.ReporteMapper;

public class ReporteController {
    private final ReporteMapper reporteMapper;
    
    public ReporteController(){
        reporteMapper = new ReporteMapper();
    }
    
    public void listarReporteDiario(DefaultTableModel model, CReporteSolicitud solicitud){
        reporteMapper.listarReporteDiario(model, solicitud);
    }
    
    public void listarReporteGeneral(DefaultTableModel model, CReporteSolicitud solicitud){
        reporteMapper.listarReporteGeneral(model, solicitud);
    }
}
