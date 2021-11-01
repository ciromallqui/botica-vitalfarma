package cross_cuting;

import controller.ProductoController;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaProductRender extends DefaultTableCellRenderer{
    private JLabel componente;
    private int stock=0;
    private int stockMinimo = 0;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        componente.setHorizontalAlignment(LEADING);
        componente.setIcon(null);
        ProductoController productoController = new ProductoController();
        
//        if(row%2==0){
//            componente.setBackground(new java.awt.Color(255,204,102));
//        }
//        else{
//            componente.setBackground(new java.awt.Color(204,204,204));
//        } 
        
        componente.setBackground(new java.awt.Color(255,255,255));
        if(column==1){
            stockMinimo = productoController.obtenerStockMinimo(String.valueOf(value));
        }
        if(column==6){
            stock = Integer.parseInt(String.valueOf(value));
        }
        if(stock<=stockMinimo){
            
            if(column==7){
                componente.setHorizontalAlignment(CENTER);
                componente.setBackground(Color.WHITE);
                componente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semaforo_rojo.png")));
            }
        }
        if(stock>stockMinimo && stock<=(stockMinimo*2)){
            if(column==7){
                componente.setHorizontalAlignment(CENTER);
                componente.setBackground(Color.WHITE);
                componente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semaforo_amarillo.png")));
            }
        }
        if(stock>(stockMinimo*2)){
            if(column==7){
                componente.setHorizontalAlignment(CENTER);
                componente.setBackground(Color.WHITE);
                componente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semaforo_azul.png")));
            }
        }
        
        if(isSelected){
            if(column!=7)
                componente.setBackground(new java.awt.Color(255,172,13));
        }
        return componente;
    }
    
}
