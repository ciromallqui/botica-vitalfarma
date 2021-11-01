package view;

import controller.UsuarioController;
import java.awt.Color;
import view.info.MessageDialog;
public class Usuario extends javax.swing.JDialog {
    public UsuarioController logeoController;
    private final MessageDialog messageDialog;
    public Usuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        logeoController = new UsuarioController();
        this.setLocationRelativeTo(null);
        lblogo.requestFocus();
//        EnlargeWindow ew = new EnlargeWindow(500);
//        ew.EnlargeHeight(this, 453, 9);
//        ew.StartTime();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblogo = new javax.swing.JLabel();
        baceptar = new javax.swing.JButton();
        bcancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txusuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txclave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lblogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_simple.png"))); // NOI18N

        baceptar.setBackground(new java.awt.Color(255, 102, 0));
        baceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        baceptar.setForeground(new java.awt.Color(255, 255, 255));
        baceptar.setText("Ingresar");
        baceptar.setContentAreaFilled(false);
        baceptar.setOpaque(true);
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

        bcancelar.setBackground(new java.awt.Color(255, 51, 0));
        bcancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bcancelar.setForeground(new java.awt.Color(255, 255, 255));
        bcancelar.setText("Cancelar");
        bcancelar.setContentAreaFilled(false);
        bcancelar.setOpaque(true);
        bcancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcancelarMouseExited(evt);
            }
        });
        bcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcancelarActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/account.png"))); // NOI18N
        jLabel5.setOpaque(true);

        txusuario.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txusuario.setForeground(new java.awt.Color(153, 153, 153));
        txusuario.setText("admin");
        txusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txusuarioMouseClicked(evt);
            }
        });
        txusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txusuarioKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/candado-cerrado.png"))); // NOI18N
        jLabel3.setOpaque(true);

        txclave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txclave.setForeground(new java.awt.Color(153, 153, 153));
        txclave.setText("123");
        txclave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txclaveMouseClicked(evt);
            }
        });
        txclave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txclaveKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txclave, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txclave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lblogo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblogo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
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

    private void baceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baceptarMouseEntered
        baceptar.setBackground(new Color(255,153,0));
    }//GEN-LAST:event_baceptarMouseEntered

    private void baceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baceptarMouseExited
        baceptar.setBackground(new Color(255,102,0));
    }//GEN-LAST:event_baceptarMouseExited

    private void baceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baceptarActionPerformed
        if(!txusuario.getText().equals("") && !txusuario.getText().equals("Usuario")){
            if(!String.valueOf(txclave.getPassword()).equals("") && !String.valueOf(txclave.getPassword()).equals("********")){
                int confirmar = logeoController.ingresar(txusuario.getText(), new String(txclave.getPassword()));
                if(confirmar==1){
                    logeoController.getDatosUsuario(txusuario.getText(), new String(txclave.getPassword()));
                    this.dispose();
                    new Main().setVisible(true);
                } else if(confirmar==0) messageDialog.response("Nombre de usuario o clave es incorrecto, <br> ingrese sus credenciales nuevamente", 4);
            } else messageDialog.response("Ingrese su contraseña", 3);
        } else messageDialog.response("Ingrese el usuario", 3);
        
    }//GEN-LAST:event_baceptarActionPerformed

    private void bcancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcancelarMouseEntered
        bcancelar.setBackground(new Color(255,0,0));
    }//GEN-LAST:event_bcancelarMouseEntered

    private void bcancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcancelarMouseExited
        bcancelar.setBackground(new Color(255,51,0));
    }//GEN-LAST:event_bcancelarMouseExited

    private void bcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcancelarActionPerformed
        System.exit(0);

    }//GEN-LAST:event_bcancelarActionPerformed

    private void txusuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txusuarioKeyReleased
        if(!txusuario.getText().equals("Usuario")){
            txusuario.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txusuarioKeyReleased

    private void txusuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txusuarioMouseClicked
        if(txusuario.getText().equals("Usuario")){
            txusuario.setText("");
            txusuario.setForeground(new Color(0,0,0));
        }
        if(String.valueOf(txclave.getPassword()).equals("")){
            txclave.setText("");
            txclave.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txusuarioMouseClicked

    private void txclaveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txclaveKeyReleased
        if(!String.valueOf(txclave.getPassword()).equals("Usuario")){
            txclave.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txclaveKeyReleased

    private void txclaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txclaveMouseClicked
        if(String.valueOf(txclave.getPassword()).equals("")){
            txclave.setText("");
            txclave.setForeground(new Color(0,0,0));
        }
        if(txusuario.getText().equals("")){
            txusuario.setText("Usuario");
            txusuario.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txclaveMouseClicked

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
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario dialog = new Usuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton baceptar;
    private javax.swing.JButton bcancelar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblogo;
    private javax.swing.JPasswordField txclave;
    private javax.swing.JTextField txusuario;
    // End of variables declaration//GEN-END:variables
}
