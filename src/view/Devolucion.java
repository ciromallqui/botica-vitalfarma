package view;

import MFC.util.JLibrary.DecimalNumber;
import aplication_class.CDevolucion;
import controller.VentaController;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import view.info.ConfirmDialog;
import view.info.MessageDialog;
import view.info.MessageToast;

public class Devolucion extends javax.swing.JInternalFrame {

    private static DefaultTableModel modelo1;
    private static DefaultTableModel modelo2;
    private final VentaController ventaController;
    private final ConfirmDialog confirmDialog;
    private final MessageDialog messageDialog;
    public Devolucion() {
        initComponents();
        ventaController = new VentaController();
        confirmDialog = new ConfirmDialog(new javax.swing.JFrame(), true);
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        pdata.setVisible(false);
        table();
    }
    
    private void table(){        
        String titulo1[] = {"N°","Código","Presentación","Producto","Fecha de venta","Cantidad","Monto S/.",""};
        modelo1 = new DefaultTableModel(null,titulo1){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String titulo2[] = {"N°","Producto","Cantidad","Monto","Fecha devolución"};
        modelo2 = new DefaultTableModel(null,titulo2){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tdevolucion1.setModel(modelo1);
        tdevolucion1.getColumnModel().getColumn(0).setMaxWidth(60);
        tdevolucion1.getColumnModel().getColumn(1).setMaxWidth(70);
        tdevolucion1.getColumnModel().getColumn(4).setMaxWidth(150);
        tdevolucion1.getColumnModel().getColumn(4).setMinWidth(150);
        tdevolucion1.getColumnModel().getColumn(5).setMaxWidth(120);
        tdevolucion1.getColumnModel().getColumn(5).setMinWidth(120);
        tdevolucion1.getColumnModel().getColumn(6).setMinWidth(100);
        tdevolucion1.getColumnModel().getColumn(6).setMaxWidth(100);
        tdevolucion1.getColumnModel().getColumn(7).setMaxWidth(0);
        
        tdevolucion2.setModel(modelo2);
        tdevolucion2.getColumnModel().getColumn(0).setMaxWidth(60);
        tdevolucion2.getColumnModel().getColumn(2).setMaxWidth(80);
        tdevolucion2.getColumnModel().getColumn(3).setMaxWidth(100);
        tdevolucion2.getColumnModel().getColumn(4).setMinWidth(130);
        tdevolucion2.getColumnModel().getColumn(4).setMaxWidth(140);
        
        tdevolucion1.setShowHorizontalLines(true);
        tdevolucion1.setShowVerticalLines(false);
        tdevolucion1.setDefaultRenderer(Object.class, new TableRowColor());
        JTableHeader head = tdevolucion1.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tdevolucion1.setTableHeader(head);
        
        tdevolucion2.setShowHorizontalLines(true);
        tdevolucion2.setShowVerticalLines(false);
        tdevolucion2.setDefaultRenderer(Object.class, new TableRowColor());
        JTableHeader head2 = tdevolucion2.getTableHeader();
        head2.setDefaultRenderer(new TableHeadCustom());
        tdevolucion2.setTableHeader(head2);
        
        ventaController.mostrarProductoParaDevolucion(modelo1, "");
        ventaController.mostrarDevoluciones(modelo2, "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txproducto1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdevolucion1 = new javax.swing.JTable();
        pdata = new javax.swing.JPanel();
        baceptar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbdescripcion = new javax.swing.JLabel();
        txcantidad = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lbdescripcion1 = new javax.swing.JLabel();
        txmonto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tdevolucion2 = new javax.swing.JTable();
        txproducto2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("DEVOLUCIONES");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/devolucion_dinero.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        jPanel2.setBackground(new java.awt.Color(227, 111, 30));

        txproducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txproducto1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese nombre del producto:");

        tdevolucion1.setModel(new javax.swing.table.DefaultTableModel(
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
        tdevolucion1.setGridColor(new java.awt.Color(153, 153, 153));
        tdevolucion1.setRowHeight(30);
        tdevolucion1.setShowVerticalLines(false);
        tdevolucion1.getTableHeader().setReorderingAllowed(false);
        tdevolucion1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdevolucion1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tdevolucion1);

        pdata.setBackground(new java.awt.Color(227, 111, 30));

        baceptar.setBackground(new java.awt.Color(227, 111, 30));
        baceptar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        baceptar.setForeground(new java.awt.Color(255, 255, 255));
        baceptar.setText("Aceptar");
        baceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        baceptar.setContentAreaFilled(false);
        baceptar.setOpaque(true);
        baceptar.setPreferredSize(new java.awt.Dimension(87, 30));
        baceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                baceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                baceptarMouseExited(evt);
            }
        });
        baceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baceptarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(244, 178, 35));

        lbdescripcion.setBackground(new java.awt.Color(244, 178, 35));
        lbdescripcion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbdescripcion.setText(" Cantidad de Paracetamol devuelto: ");
        lbdescripcion.setOpaque(true);

        txcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txcantidad.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txcantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txcantidadMouseClicked(evt);
            }
        });
        txcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txcantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txcantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lbdescripcion)
                .addGap(0, 0, 0)
                .addComponent(txcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(244, 178, 35));

        lbdescripcion1.setBackground(new java.awt.Color(244, 178, 35));
        lbdescripcion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbdescripcion1.setText(" Monto devuelto S/.: ");
        lbdescripcion1.setOpaque(true);

        txmonto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txmonto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txmontoMouseClicked(evt);
            }
        });
        txmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txmontoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txmontoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbdescripcion1)
                .addGap(0, 0, 0)
                .addComponent(txmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdescripcion1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pdataLayout = new javax.swing.GroupLayout(pdata);
        pdata.setLayout(pdataLayout);
        pdataLayout.setHorizontalGroup(
            pdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdataLayout.createSequentialGroup()
                .addContainerGap(290, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pdataLayout.setVerticalGroup(
            pdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pdataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pdata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ventas activas para la devolución", jPanel2);

        jPanel3.setBackground(new java.awt.Color(227, 111, 30));

        tdevolucion2.setModel(new javax.swing.table.DefaultTableModel(
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
        tdevolucion2.setGridColor(new java.awt.Color(153, 153, 153));
        tdevolucion2.setRowHeight(30);
        tdevolucion2.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tdevolucion2);

        txproducto2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txproducto2KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese nombre del producto:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 468, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Productos devueltos", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void baceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baceptarActionPerformed
        int si = confirmDialog.response("¿Está seguro que desea realizar la devolución?", 2);
        if(si==1){
            CDevolucion devolucion = new CDevolucion();
            devolucion.setIdVenta(Integer.parseInt(String.valueOf(modelo1.getValueAt(tdevolucion1.getSelectedRow(), 7)).split(",")[0]));
            devolucion.setIdVentaDetalle(Integer.parseInt(String.valueOf(modelo1.getValueAt(tdevolucion1.getSelectedRow(), 7)).split(",")[1]));
            devolucion.setCantidadProducto(Integer.parseInt(txcantidad.getText()));
            devolucion.setMontoDevolucion(Double.parseDouble(txmonto.getText()));
            ventaController.insertarDevolucionProducto(devolucion);
            while(modelo1.getRowCount()>0){modelo1.removeRow(0);}
            while(modelo2.getRowCount()>0){modelo2.removeRow(0);}
            ventaController.mostrarProductoParaDevolucion(modelo1, txproducto1.getText());
            ventaController.mostrarDevoluciones(modelo2, txproducto2.getText());
        }
    }//GEN-LAST:event_baceptarActionPerformed

    private void tdevolucion1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdevolucion1MouseClicked
        String descripcion = modelo1.getValueAt(tdevolucion1.getSelectedRow(), 3).toString();
        String cantidad = modelo1.getValueAt(tdevolucion1.getSelectedRow(), 5).toString();
        lbdescripcion.setText(" Cantidad de "+descripcion+" devuelto: ");
        txmonto.setText(modelo1.getValueAt(tdevolucion1.getSelectedRow(), 6).toString());
        txcantidad.setText(cantidad);
        txcantidad.requestFocus();
        txcantidad.selectAll();
        pdata.setVisible(true);
    }//GEN-LAST:event_tdevolucion1MouseClicked

    private void txcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txcantidadKeyReleased
        if(txcantidad.getText().equals("")) {
            txcantidad.setText("1");
            txcantidad.selectAll();
        }
        if(Integer.parseInt(txcantidad.getText()) > Integer.parseInt(String.valueOf(modelo1.getValueAt(tdevolucion1.getSelectedRow(), 5)))){
            messageDialog.response("La cantidad ingresada no debe ser mayor a "+ modelo1.getValueAt(tdevolucion1.getSelectedRow(), 5), 3);
            txcantidad.setText(modelo1.getValueAt(tdevolucion1.getSelectedRow(), 5).toString());
        }
        if (!txmonto.getText().substring(txmonto.getText().length()-1, txmonto.getText().length()).equals(".")){
            txmonto.setText(DecimalNumber.ReduceDecimal((Integer.parseInt(txcantidad.getText()) * ventaController.obtenerPrecioUnitario(modelo1.getValueAt(tdevolucion1.getSelectedRow(), 1).toString())),2)+"");        
        }
    }//GEN-LAST:event_txcantidadKeyReleased

    private void txcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txcantidadKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0'){
            evt.consume();
        }
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            baceptar.doClick();
        }
    }//GEN-LAST:event_txcantidadKeyTyped

    private void txmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txmontoKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0'){
            if (evt.getKeyChar() != '.')
                evt.consume();
        }
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            baceptar.doClick();
        }
    }//GEN-LAST:event_txmontoKeyTyped

    private void txmontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txmontoKeyReleased
        if(txmonto.getText().equals("")) {
            txmonto.setText("0.00");
            txmonto.selectAll();
        }
    }//GEN-LAST:event_txmontoKeyReleased

    private void txmontoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txmontoMouseClicked
        if(txmonto.getCaretPosition() == txmonto.getText().length()){
            txmonto.selectAll();
        }
    }//GEN-LAST:event_txmontoMouseClicked

    private void txcantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txcantidadMouseClicked
        if(txcantidad.getCaretPosition() == txcantidad.getText().length()){
            txcantidad.selectAll();
        }
    }//GEN-LAST:event_txcantidadMouseClicked

    private void baceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baceptarMouseEntered
        baceptar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_baceptarMouseEntered

    private void baceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baceptarMouseExited
        baceptar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_baceptarMouseExited

    private void txproducto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txproducto1KeyReleased
        while(modelo1.getRowCount()>0){modelo1.removeRow(0);}
        ventaController.mostrarProductoParaDevolucion(modelo1, txproducto1.getText());
    }//GEN-LAST:event_txproducto1KeyReleased

    private void txproducto2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txproducto2KeyReleased
        while(modelo2.getRowCount()>0){modelo2.removeRow(0);}
        ventaController.mostrarDevoluciones(modelo2, txproducto2.getText());
    }//GEN-LAST:event_txproducto2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbdescripcion;
    private javax.swing.JLabel lbdescripcion1;
    private javax.swing.JPanel pdata;
    private javax.swing.JTable tdevolucion1;
    private javax.swing.JTable tdevolucion2;
    private javax.swing.JTextField txcantidad;
    private javax.swing.JTextField txmonto;
    private javax.swing.JTextField txproducto1;
    private javax.swing.JTextField txproducto2;
    // End of variables declaration//GEN-END:variables
}
