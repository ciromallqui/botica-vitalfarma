package controller;

import aplication_class.CAdministrador;
import javax.swing.table.DefaultTableModel;
import model.UsuarioMapper;

public class UsuarioController {
    private final UsuarioMapper logeoMapper;
    
    public UsuarioController(){
        logeoMapper = new UsuarioMapper();
    }
    
    public int ingresar(String usuario, String clave){
        return logeoMapper.ingresar(usuario, clave);
    }
    
    public void getDatosUsuario(String usuario, String clave){
        logeoMapper.getDatosUsuario(usuario, clave);
    }
    
    public int actualizarUsuario(CAdministrador a){
        return logeoMapper.actualizarUsuario(a);
    }
    
    public CAdministrador obtenerDatosAdministrador(){
        return logeoMapper.obtenerDatosAdministrador();
    }
    
    public int actualizarClave(String newpassword){
        return logeoMapper.actualizarClave(newpassword);
    }
    
    public int insertarUsuario(CAdministrador u){
        return logeoMapper.insertarUsuario(u);
    }
    
    public int eliminarUsuario(int idUsuario){
        return logeoMapper.eliminarUsuario(idUsuario);
    }
    
    public void listarUsuario(DefaultTableModel modelo){
        logeoMapper.listarUsuario(modelo);
    }
}
