package view;

import controller.ProductoController;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import view.info.ConfirmDialog;
import view.info.MessageDialog;
import view.info.MessageToast;

public class Presentacion extends javax.swing.JDialog {
    DefaultTableModel modelo;
    public ProductoController productoController;
    private final ConfirmDialog confirmDialog;
    private final MessageDialog messageDialog;
    private final MessageToast messageToast;
    public Presentacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/Image/categorias.png")).getImage());
        
        productoController = new ProductoController();
        confirmDialog = new ConfirmDialog(new javax.swing.JFrame(), true);
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        
        modelo = new DefaultTableModel(null, new String[]{"N°","Presentación",""});
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMaxWidth(50);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        productoController.mostrarPresentacion(modelo,"");
        
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(false);
        tabla.setDefaultRenderer(Object.class, new TableRowColor());
        JTableHeader head = tabla.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tabla.setTableHeader(head);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txpresentacion = new javax.swing.JTextField();
        bguardar = new javax.swing.JButton();
        bactualizar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRESENTACIÓN DE MEDICAMENTOS");

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla.setGridColor(new java.awt.Color(153, 153, 153));
        tabla.setRowHeight(25);
        tabla.setShowVerticalLines(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 51));
        jLabel1.setText("Presentación:");

        bguardar.setBackground(new java.awt.Color(227, 111, 30));
        bguardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bguardar.setForeground(new java.awt.Color(255, 255, 255));
        bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/guardar.png"))); // NOI18N
        bguardar.setMnemonic('G');
        bguardar.setText(" Guardar");
        bguardar.setToolTipText("Precione Alt + G");
        bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bguardar.setContentAreaFilled(false);
        bguardar.setMargin(new java.awt.Insets(2, 4, 2, 4));
        bguardar.setOpaque(true);
        bguardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bguardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bguardarMouseExited(evt);
            }
        });
        bguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bguardarActionPerformed(evt);
            }
        });

        bactualizar.setBackground(new java.awt.Color(227, 111, 30));
        bactualizar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bactualizar.setForeground(new java.awt.Color(204, 204, 204));
        bactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        bactualizar.setText("Actualizar");
        bactualizar.setToolTipText("");
        bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        bactualizar.setContentAreaFilled(false);
        bactualizar.setEnabled(false);
        bactualizar.setMargin(new java.awt.Insets(2, 4, 2, 4));
        bactualizar.setOpaque(true);
        bactualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bactualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bactualizarMouseExited(evt);
            }
        });
        bactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualizarActionPerformed(evt);
            }
        });

        beliminar.setBackground(new java.awt.Color(227, 111, 30));
        beliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        beliminar.setForeground(new java.awt.Color(204, 204, 204));
        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar.png"))); // NOI18N
        beliminar.setText("Eliminar");
        beliminar.setToolTipText("");
        beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        beliminar.setContentAreaFilled(false);
        beliminar.setEnabled(false);
        beliminar.setMargin(new java.awt.Insets(2, 4, 2, 4));
        beliminar.setOpaque(true);
        beliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                beliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                beliminarMouseExited(evt);
            }
        });
        beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliminarActionPerformed(evt);
            }
        });

        bbuscar.setBackground(new java.awt.Color(227, 111, 30));
        bbuscar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        bbuscar.setForeground(new java.awt.Color(255, 255, 255));
        bbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscar_boton.png"))); // NOI18N
        bbuscar.setToolTipText("");
        bbuscar.setBorderPainted(false);
        bbuscar.setContentAreaFilled(false);
        bbuscar.setFocusPainted(false);
        bbuscar.setFocusable(false);
        bbuscar.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bbuscar.setOpaque(true);
        bbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(beliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseEntered
        if(bguardar.isEnabled()) bguardar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bguardarMouseEntered

    private void bguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseExited
        bguardar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bguardarMouseExited

    private void bactualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizarMouseEntered
        if(bactualizar.isEnabled()) bactualizar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bactualizarMouseEntered

    private void bactualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizarMouseExited
        bactualizar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bactualizarMouseExited

    private void beliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseEntered
        if(beliminar.isEnabled()) beliminar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_beliminarMouseEntered

    private void beliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseExited
        beliminar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_beliminarMouseExited

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        if(txpresentacion.getText().length()>0){
            if(productoController.validarPresentacion(txpresentacion.getText())==0){
                while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                productoController.insertarPresentacion(txpresentacion.getText());
                productoController.mostrarPresentacion(modelo,"");
                txpresentacion.setText(null);
                txpresentacion.requestFocus();
                
                bactualizar.setEnabled(false);
                beliminar.setEnabled(false);
                bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
                beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
                bactualizar.setForeground(new java.awt.Color(204,204,204));
                beliminar.setForeground(new java.awt.Color(204,204,204));
                messageToast.response("Presentación guardado correctamente", 280, 50, "success");
            } else messageDialog.response("La presentación que desea guardar ya existe", 3);
        } else messageDialog.response("Ingrese nombre de presentación", 4);
    }//GEN-LAST:event_bguardarActionPerformed

    private void bactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizarActionPerformed
        if(txpresentacion.getText().length()>0){
            if(tabla.getSelectedRowCount()==1){
                productoController.actualizarPresentacion(modelo.getValueAt(tabla.getSelectedRow(), 2).toString(),txpresentacion.getText());
                modelo.setValueAt(txpresentacion.getText(),tabla.getSelectedRow(),1);
                
                messageToast.response("Presentación actualizada correctamente", 300, 50, "success");
            } else messageDialog.response("Seleccione una fila", 3);
        } else messageDialog.response("Ingrese una presentación válida", 3);
    }//GEN-LAST:event_bactualizarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
        if(tabla.getSelectedRowCount()==1){
            if(confirmDialog.response("¿Realmente desea Eliminar la presentación seleccionada?", 2)==1){
                productoController.eliminarPresentacion(modelo.getValueAt(tabla.getSelectedRow(), 2).toString());
                while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                productoController.mostrarPresentacion(modelo,"");
                txpresentacion.setText(null);
                
                bactualizar.setEnabled(false);
                beliminar.setEnabled(false);
                bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
                beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
                bactualizar.setForeground(new java.awt.Color(204,204,204));
                beliminar.setForeground(new java.awt.Color(204,204,204));
                messageToast.response("Presentación eliminado correctamente", 300, 50, "success");
            }
        }else messageDialog.response("Seleccione una fila", 3);
        txpresentacion.requestFocus();
    }//GEN-LAST:event_beliminarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        txpresentacion.setText(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
        bactualizar.setEnabled(true);
        beliminar.setEnabled(true);
        bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
        beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
        bactualizar.setForeground(new java.awt.Color(255,255,255));
        beliminar.setForeground(new java.awt.Color(255,255,255));
        txpresentacion.requestFocus();
    }//GEN-LAST:event_tablaMouseClicked

    private void bbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbuscarActionPerformed
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
        productoController.mostrarPresentacion(modelo,txpresentacion.getText());
        
        bactualizar.setEnabled(false);
        beliminar.setEnabled(false);
        bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
        beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
        bactualizar.setForeground(new java.awt.Color(204,204,204));
        beliminar.setForeground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_bbuscarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            Presentacion dialog = new Presentacion(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bactualizar;
    private javax.swing.JButton bbuscar;
    private javax.swing.JButton beliminar;
    private javax.swing.JButton bguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txpresentacion;
    // End of variables declaration//GEN-END:variables
}
