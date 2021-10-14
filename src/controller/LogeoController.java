package controller;

import model.LogeoMapper;

public class LogeoController {
    private final LogeoMapper logeoMapper;
    
    public LogeoController(){
        logeoMapper = new LogeoMapper();
    }
    
    public boolean ingresar(String usuario, String clave){
        return logeoMapper.ingresar(usuario, clave);
    }
    
    public void getDatosUsuario(String usuario, String clave){
        logeoMapper.getDatosUsuario(usuario, clave);
    }
}
