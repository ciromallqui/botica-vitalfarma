package controller;

import aplication_class.CTurno;
import java.util.List;
import javax.swing.JComboBox;
import model.ParametroMapper;

public class ParametroController {
    private final ParametroMapper parametroMapper;
    
    public ParametroController(){
        parametroMapper = new ParametroMapper();
    }
    
    public int obtenerContador(String tableName){
        return parametroMapper.obtenerContador(tableName);
    }
    
    public void cargarTurno(JComboBox combo){
        parametroMapper.cargarTurno(combo);
    }
    
    public void actualizarContador(String tableName, int contador){
        parametroMapper.actualizarContador(tableName, contador);
    }
    
    public String horaCambioTurno(){
        return parametroMapper.horaCambioTurno();
    }
    
    public List<CTurno> obtenerTurno(){
        return parametroMapper.listarTurno();
    }
    
    public CTurno consultarTurno(String nombre){
        return parametroMapper.consultarTurno(nombre);
    }
}
