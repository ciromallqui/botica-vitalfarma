package view;

import aplication_class.CTurno;
import controller.ParametroController;
import controller.TurnoController;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import view.info.MessageToast;

public class ConfigurarTurno extends javax.swing.JDialog {
    
    ParametroController parametroController;
    TurnoController turnoController;
    MessageToast messageToast;
    DefaultTableModel modelo;
    public ConfigurarTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/Image/calendario-color.png")).getImage());
        parametroController = new ParametroController();
        turnoController = new TurnoController();
        parametroController.cargarParametro(cbestado, "ESTADO_TURNO");
        
        String titulo[] = {"N°","Turno","Hora inicio","Hora Final","Estado"};
        modelo = new DefaultTableModel(null,titulo);
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMinWidth(40);
        tabla.getColumnModel().getColumn(0).setMaxWidth(40);
        tabla.getColumnModel().getColumn(2).setMinWidth(80);
        tabla.getColumnModel().getColumn(2).setMaxWidth(80);
        tabla.getColumnModel().getColumn(3).setMinWidth(80);
        tabla.getColumnModel().getColumn(3).setMaxWidth(80);
        tabla.getColumnModel().getColumn(4).setMinWidth(80);
        tabla.getColumnModel().getColumn(4).setMaxWidth(80);
        
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(false);
        tabla.setDefaultRenderer(Object.class, new TableRowColor());
        JTableHeader head = tabla.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tabla.setTableHeader(head);
        turnoController.listarTurno(modelo);
    }

    private void nuevo(){
        txturno.setText("");
        txhoraInicial.setText("");
        txhoraFinal.setText("");
        cbestado.setSelectedIndex(0);
        
        bguardar.setForeground(new java.awt.Color(255,255,255));
        bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
        bguardar.setEnabled(true);
        
        bactualizar.setForeground(new java.awt.Color(204, 204, 204));
        bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        bactualizar.setEnabled(false);
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
        turnoController.listarTurno(modelo);
        txturno.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txhoraInicial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txhoraFinal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txturno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        bactualizar = new javax.swing.JButton();
        bguardar = new javax.swing.JButton();
        bnuevo = new javax.swing.JButton();
        cbestado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONFIGURACIÓN DE TURNOS");

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
        tabla.setGridColor(new java.awt.Color(204, 204, 204));
        tabla.setRowHeight(30);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        txhoraInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txhoraInicialKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hora de Inicio:");

        txhoraFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txhoraFinalKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hora Final:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre de Turno:");

        bactualizar.setBackground(new java.awt.Color(227, 111, 30));
        bactualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bactualizar.setForeground(new java.awt.Color(204, 204, 204));
        bactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        bactualizar.setText("Actualizar");
        bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        bactualizar.setContentAreaFilled(false);
        bactualizar.setEnabled(false);
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

        bguardar.setBackground(new java.awt.Color(227, 111, 30));
        bguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bguardar.setForeground(new java.awt.Color(255, 255, 255));
        bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/guardar.png"))); // NOI18N
        bguardar.setText("Guardar");
        bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bguardar.setContentAreaFilled(false);
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

        bnuevo.setBackground(new java.awt.Color(227, 111, 30));
        bnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bnuevo.setForeground(new java.awt.Color(255, 255, 255));
        bnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nuevo-documento.png"))); // NOI18N
        bnuevo.setText("Nuevo");
        bnuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bnuevo.setContentAreaFilled(false);
        bnuevo.setOpaque(true);
        bnuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bnuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bnuevoMouseExited(evt);
            }
        });
        bnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnuevoActionPerformed(evt);
            }
        });

        cbestado.setBackground(new java.awt.Color(255, 153, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(txhoraInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(txhoraFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txturno)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txturno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txhoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txhoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 13, Short.MAX_VALUE))
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

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        CTurno turno = new CTurno();
        if(txturno.getText().length()==0) {messageToast.response("Ingrese nombre del turno", 220, 50, "danger"); return;}
        if(txhoraInicial.getText().length()!=5) {messageToast.response("Ingrese el formato correcto de hora y minuto inicial", 220, 70, "danger"); return;}
        if(txhoraFinal.getText().length()!=5) {messageToast.response("Ingrese el formato correcto de hora y minuto final", 220, 70, "danger"); return;}
        turno.setNombre(txturno.getText());
        turno.setHoraInicial(txhoraInicial.getText());
        turno.setHoraFinal(txhoraFinal.getText());
        turno.setEstado(String.valueOf(cbestado.getSelectedIndex()+1));
        if(turnoController.insertarTurno(turno)==1){
            nuevo();
            messageToast.response("Datos del turno guardado con éxito", 270, 50, "success");
        }else messageToast.response("No se pudo guardar los datos del turno", 220, 70, "danger");
    }//GEN-LAST:event_bguardarActionPerformed

    private void bactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        CTurno turno = new CTurno();
        if(txturno.getText().length()==0) {messageToast.response("Ingrese nombre del turno", 220, 50, "danger"); return;}
        if(txhoraInicial.getText().length()!=5) {messageToast.response("Ingrese el formato correcto de hora y minuto inicial", 220, 70, "danger"); return;}
        if(txhoraFinal.getText().length()!=5) {messageToast.response("Ingrese el formato correcto de hora y minuto final", 220, 70, "danger"); return;}
        turno.setIdTurno(Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 0).toString()));
        turno.setNombre(txturno.getText());
        turno.setHoraInicial(txhoraInicial.getText());
        turno.setHoraFinal(txhoraFinal.getText());
        turno.setEstado(String.valueOf(cbestado.getSelectedIndex()+1));
        if(turnoController.actualizarTurno(turno)==1){
            nuevo();
            messageToast.response("Datos del turno actualizado con éxito", 270, 50, "success");
        }else messageToast.response("No se pudo actualizar los datos del turno", 220, 70, "danger");
    }//GEN-LAST:event_bactualizarActionPerformed

    private void bnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_bnuevoActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if(tabla.getSelectedRowCount()==1){
            txturno.setText(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
            txhoraInicial.setText(modelo.getValueAt(tabla.getSelectedRow(), 2).toString());
            txhoraFinal.setText(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
            cbestado.setSelectedItem(modelo.getValueAt(tabla.getSelectedRow(), 4).toString());
            
            bactualizar.setForeground(new java.awt.Color(255,255,255));
            bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
            bactualizar.setEnabled(true);
            
            bguardar.setForeground(new java.awt.Color(204, 204, 204));
            bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
            bguardar.setEnabled(false);
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void txhoraInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txhoraInicialKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0' || txhoraInicial.getText().length()==5){
            if (evt.getKeyChar() != ':')
                evt.consume();
            
        }
    }//GEN-LAST:event_txhoraInicialKeyTyped

    private void txhoraFinalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txhoraFinalKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0' || txhoraFinal.getText().length()==5){
            if (evt.getKeyChar() != ':')
                evt.consume();
        }
    }//GEN-LAST:event_txhoraFinalKeyTyped

    private void bguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseEntered
        if (bguardar.isEnabled()) bguardar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bguardarMouseEntered

    private void bguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseExited
        bguardar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bguardarMouseExited

    private void bactualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizarMouseEntered
        if (bactualizar.isEnabled()) bactualizar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bactualizarMouseEntered

    private void bactualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizarMouseExited
        bactualizar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bactualizarMouseExited

    private void bnuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnuevoMouseEntered
        bnuevo.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bnuevoMouseEntered

    private void bnuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnuevoMouseExited
        bnuevo.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bnuevoMouseExited

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigurarTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfigurarTurno dialog = new ConfigurarTurno(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bactualizar;
    private javax.swing.JButton bguardar;
    private javax.swing.JButton bnuevo;
    private javax.swing.JComboBox<String> cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txhoraFinal;
    private javax.swing.JTextField txhoraInicial;
    private javax.swing.JTextField txturno;
    // End of variables declaration//GEN-END:variables
}
