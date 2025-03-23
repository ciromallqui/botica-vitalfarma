package aplication_class;
public class CProducto {
    private String idProducto;
    private int idProductoFechav;
    private String nombre;
    private String indicacion;
    private double precioCompraTotal;
    private double precioCompraUnitario;
    private double precioVentaUnitario;
    private int stockMinimo;
    private int stockActual;
    private String idPresentacion;
    private String presentacion;
    private String fechaVencimiento;
    private String laboratorio;

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProductoFechav() {
        return idProductoFechav;
    }

    public void setIdProductoFechav(int idProductoFechav) {
        this.idProductoFechav = idProductoFechav;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public double getPrecioCompraTotal() {
        return precioCompraTotal;
    }

    public void setPrecioCompraTotal(double precioCompraTotal) {
        this.precioCompraTotal = precioCompraTotal;
    }

    public double getPrecioCompraUnitario() {
        return precioCompraUnitario;
    }

    public void setPrecioCompraUnitario(double precioCompraUnitario) {
        this.precioCompraUnitario = precioCompraUnitario;
    }

    public double getPrecioVentaUnitario() {
        return precioVentaUnitario;
    }

    public void setPrecioVentaUnitario(double precioVentaUnitario) {
        this.precioVentaUnitario = precioVentaUnitario;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public String getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(String idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
}
