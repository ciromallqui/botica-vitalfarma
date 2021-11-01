package controller;

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
    
    public void actualizarContador(String tableName, int contador){
        parametroMapper.actualizarContador(tableName, contador);
    }
    
    public void cargarParametro(JComboBox cb, String parametro){
        parametroMapper.cargarParametro(cb, parametro);
    }
}
