package aplication_class;
public class CVenta {
    private int idVenta;
    private int idTurno;
    private int idUsuario;
    private double montoTotal;
    private String fechaVenta;
    //DETALLE
    private int idVentaDetalle;
    private String idProducto;
    private int idProductoFechav;
    private int cantidadProducto;
    private double monto;
    private double descuento;
    private double precioCompraUnitario;
    //MÁS DETALLES
    private String presentacion;
    private String turno;
    private String producto;
    private String laboratorio;
    private int cantidad;
    

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdVentaDetalle() {
        return idVentaDetalle;
    }

    public void setIdVentaDetalle(int idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioCompraUnitario() {
        return precioCompraUnitario;
    }

    public void setPrecioCompraUnitario(double precioCompraUnitario) {
        this.precioCompraUnitario = precioCompraUnitario;
    }

    public int getIdProductoFechav() {
        return idProductoFechav;
    }

    public void setIdProductoFechav(int idProductoFechav) {
        this.idProductoFechav = idProductoFechav;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
