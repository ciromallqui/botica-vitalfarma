package aplication_class;
public class CUsuario {
    static String nombreCompleto;
    static int idUsuario;
    static String clave;
    static String nombreUsuario;
    static String tipoUsuario;

    public static String getNombreCompleto() {
        return nombreCompleto;
    }

    public static void setNombreCompleto(String nombreCompleto) {
        CUsuario.nombreCompleto = nombreCompleto;
    }

    public static int getIdUsuario() {
        return idUsuario;
    }

    public static void setIdUsuario(int idUsuario) {
        CUsuario.idUsuario = idUsuario;
    }

    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        CUsuario.clave = clave;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        CUsuario.nombreUsuario = nombreUsuario;
    }

    public static String getTipoUsuario() {
        return tipoUsuario;
    }

    public static void setTipoUsuario(String tipoUsuario) {
        CUsuario.tipoUsuario = tipoUsuario;
    }
}
