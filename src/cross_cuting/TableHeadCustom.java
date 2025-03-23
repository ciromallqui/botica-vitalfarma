package cross_cuting;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class TableHeadCustom implements TableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent component = null;
        
        if( value instanceof String ) {
            component = new JLabel((String) value);
            ((JLabel)component).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)component).setSize( 40, component.getWidth() );   
            ((JLabel)component).setPreferredSize( new Dimension(6, component.getWidth())  );
        }         
   
        component.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
        component.setOpaque(true);
        component.setBackground( new Color(236,234,219) );
//        component.setBackground( new Color(65,65,65) );
        component.setForeground(new Color(0,0,0));
        component.setFont(new Font("Tahoma",1,14));
        
        return component;
    }
}
