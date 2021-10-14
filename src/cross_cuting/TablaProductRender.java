package cross_cuting;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TablaProductRender extends DefaultTableCellRenderer{
    private JLabel componente;
    private int num=0;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
        componente.setHorizontalAlignment(LEADING);
        componente.setIcon(null);
//        if(row%2==0){
//            componente.setBackground(new java.awt.Color(255,204,102));
//        }
//        else{
//            componente.setBackground(new java.awt.Color(204,204,204));
//        } 

        componente.setBackground(new java.awt.Color(255,255,255));
        if(column==6){
            num = Integer.parseInt(String.valueOf(value));
        }
        if(num<=5){
            if(column==7){
                componente.setHorizontalAlignment(CENTER);
                componente.setBackground(Color.WHITE);
                componente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semaforo_rojo.png")));
            }
        }
        if(num>5 && num<=10){
            if(column==7){
                componente.setHorizontalAlignment(CENTER);
                componente.setBackground(Color.WHITE);
                componente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semaforo_amarillo.png")));
            }
        }
        if(num>10){
            if(column==7){
                componente.setHorizontalAlignment(CENTER);
                componente.setBackground(Color.WHITE);
                componente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/semaforo_verde.png")));
            }
        }
        
        if(isSelected){
            if(column!=7)
                componente.setBackground(new java.awt.Color(255,172,13));
        }
        return componente;
    }
    
}
