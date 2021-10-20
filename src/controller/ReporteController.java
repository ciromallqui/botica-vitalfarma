package controller;

import aplication_class.CReporteMonto;
import aplication_class.CReporteSolicitud;
import java.util.List;
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
    
    public List<CReporteMonto> listaMontoDiario(CReporteSolicitud solicitud, String tipoReporte){
        switch(tipoReporte){
            case "D":
                return reporteMapper.listaMontoDiario(solicitud);
            case "M":
                return reporteMapper.listaMontoMensual(solicitud);
            case "G":
                return reporteMapper.listaMontoGeneral(solicitud);
            default: return reporteMapper.listaMontoDiario(solicitud);
        }
    }
}
