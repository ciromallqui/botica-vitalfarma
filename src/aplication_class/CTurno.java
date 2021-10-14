package aplication_class;
public class CTurno {
    private int idTurno;
    private String nombre;
    private String horaInicial;
    private String horaFinal;
    
    public CTurno(){}
    public CTurno(CTurno turno){
        this.idTurno = turno.idTurno;
        this.nombre = turno.nombre;
        this.horaInicial = turno.horaInicial;
        this.horaFinal = turno.horaFinal;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
    
}
