package controller;

import aplication_class.CProducto;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import model.ParametroMapper;
import model.ProductoMapper;

public class ProductoController {
    private final ProductoMapper productoMapper;
    private final ParametroMapper parametroMapper;
    
    public ProductoController(){
        productoMapper = new ProductoMapper();
        parametroMapper = new ParametroMapper();
    }
    
    public void cargarPresentacion(JComboBox cb){
        this.productoMapper.cargarPresentacion(cb);
    }
    
    public void cargarPresentacion(TextAutoCompleter tx){
        this.productoMapper.cargarPresentacion(tx);
    }
    
    public void mostrarPresentacion(DefaultTableModel modelo,String idProducto){
        this.productoMapper.mostrarPresentacion(modelo,idProducto);
    }
    
    public String obtenerIdPresentacion(String presentacion){
        return this.productoMapper.obtenerIdPresentacion(presentacion);
    }
    
    public void insertarPresentacion(String present){
        this.productoMapper.insertarPresentacion(present);
    }
    public void actualizarPresentacion(String id, String presentacion){
        this.productoMapper.actualizarPresentacion(id, presentacion);
    }
    public void eliminarPresentacion(String id){
        this.productoMapper.eliminarPresentacion(id);
    }
    
    public int validarPresentacion(String presentacion){
        return this.productoMapper.validarPresentacion(presentacion);
    }
            
    //PRODUNCO
    public void mostrarProducto(DefaultTableModel modelo, String nompreProducto){
        this.productoMapper.mostrarProducto(modelo, nompreProducto, null);
    }
    
    public void mostrarProducto(DefaultTableModel modelo, String nompreProducto, String presentacion){
        this.productoMapper.mostrarProducto(modelo, nompreProducto, presentacion);
    }
    
    public void mostrarControlProducto(DefaultTableModel modelo, String nompreProducto, String presentacion){
        this.productoMapper.mostrarControlProducto(modelo, nompreProducto, presentacion);
    }
    
    public CProducto consultarProducto(String idProducto, String fechaVencimiento, int idProductoFechav){
        return this.productoMapper.consultarProducto(idProducto, fechaVencimiento, idProductoFechav);
    }
    
    public String obtenerIndicacionProducto(String idProducto){
        return this.productoMapper.obtenerIndicacionProducto(idProducto);
    }
    
    public int obtenerStockProducto(String idProducto){ //In utilizable
        return productoMapper.obtenerStockProducto(idProducto);
    }
    
    public int obtenerStockMinimo(String idProducto){
        return productoMapper.obtenerStockMinimo(idProducto);
    }
    
    public int insertarProducto(CProducto p){
        if (this.productoMapper.insertarProducto(p) == 1){
            if (this.productoMapper.insertarProductoFechav(p) == 1){
                this.parametroMapper.actualizarContador("CODIGO_PRODUCTO", 
                this.parametroMapper.obtenerContador("CODIGO_PRODUCTO"));
                return 1;
            }
        }else{
            this.parametroMapper.actualizarContador("CODIGO_PRODUCTO", 
            this.parametroMapper.obtenerContador("CODIGO_PRODUCTO"));
            return 0;
        }
        return 0;
    }
    
    public int duplicarProducto(CProducto p){
        if(this.productoMapper.insertarProductoFechav(p) == 1){
            return 1;
        }
        return 0;
    }
    
    public int actualizarProducto(CProducto p){
        if (this.productoMapper.actualizarProducto(p) == 1){
            if (this.productoMapper.actualizarProductoFechav(p) == 1){
                return 1;
            }
        }
        return 0;
    }
    
    public int eliminarProducto(CProducto producto){
        if(this.productoMapper.obtenerCantidadProductoDetalle(producto.getIdProducto())>1){
            if (this.productoMapper.actualizarEstadoProductoFechav(producto.getIdProductoFechav())==1)
                return 1;
        }else{
            if(this.productoMapper.eliminarProducto(producto.getIdProducto())==1){
                if(this.productoMapper.eliminarProductoFechav(producto.getIdProductoFechav())==1)
                    return 1;
            }
        }
        return 0;
    }
}
