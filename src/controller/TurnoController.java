package controller;

import aplication_class.CTurno;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import model.TurnoMapper;

public class TurnoController {
    
    TurnoMapper turnoMapper;
    public TurnoController(){
        turnoMapper = new TurnoMapper();
    }
    
    public int insertarTurno(CTurno t){
        return turnoMapper.insertarTurno(t);
    }
    
    public int actualizarTurno(CTurno t){
        return turnoMapper.actualizarTurno(t);
    }
    
    public void cargarTurno(JComboBox combo){
        turnoMapper.cargarTurno(combo);
    }
    
    public List<CTurno> listarTurno(){
        return turnoMapper.listarTurno();
    }
    
    public void listarTurno(DefaultTableModel modelo){
        turnoMapper.listarTurno(modelo);
    }
    
    public CTurno consultarTurno(String nombre){
        return turnoMapper.consultarTurno(nombre);
    }
}
