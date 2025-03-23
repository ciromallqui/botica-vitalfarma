package cross_cuting;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRowColor extends DefaultTableCellRenderer{
    private JLabel componente;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
        
//        if(row%2==0){
//            componente.setBackground(new java.awt.Color(255,204,102));
//        }
//        else{
//            componente.setBackground(new java.awt.Color(204,204,204));
//        } 
//        if(isSelected){
//            componente.setBackground(new java.awt.Color(255,102,0));
//        }

        if(row%2==0){
            componente.setBackground(new java.awt.Color(255,255,255));
        }
        else{
            componente.setBackground(new java.awt.Color(255,255,255));
        }  
        if(isSelected){
            componente.setBackground(new java.awt.Color(255,172,13));
        }
        return componente;
    }
}