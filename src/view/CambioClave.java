package view;

import MFC.util.JLibrary.EncryptingKey;
import aplication_class.CUsuario;
import controller.UsuarioController;
import javax.swing.ImageIcon;
import view.info.MessageDialog;
import view.info.MessageToast;

/**
 *@author CIRO MF
 */
public class CambioClave extends javax.swing.JDialog {
    private final MessageDialog messageDialog;
    private MessageToast messageToast;
    private static int estado;
    public CambioClave(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        setIconImage(new ImageIcon(getClass().getResource("/Image/nuevop.png")).getImage());
        this.setLocationRelativeTo(null);
        txusuario.setText(CUsuario.getNombreCompleto());
        this.estado = 0;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txusuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txnuevaclave = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txconfirmarclave = new javax.swing.JPasswordField();
        baceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txclave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONTROL DE CONTRASEÑAS");

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombres y Apellidos:");

        txusuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txusuario.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txusuario.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nueva Contraseña :");

        txnuevaclave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Confirmar Contraseña:");

        txconfirmarclave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        baceptar.setBackground(new java.awt.Color(227, 111, 30));
        baceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        baceptar.setForeground(new java.awt.Color(255, 255, 255));
        baceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        baceptar.setText("Actualizar");
        baceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contraseña Actual :");

        txclave.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txusuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txnuevaclave)
                            .addComponent(txclave)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txconfirmarclave, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txclave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txnuevaclave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txconfirmarclave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        baceptar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_baceptarMouseEntered

    private void baceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baceptarMouseExited
        baceptar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_baceptarMouseExited

    private void baceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baceptarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        UsuarioController usuarioController = new UsuarioController();
        if(new String(txclave.getPassword()).length()!=0 && new String(txnuevaclave.getPassword()).length()!=0 && new String(txconfirmarclave.getPassword()).length()!=0){
            if(EncryptingKey.md5(new String(txclave.getPassword())).equals(Main.clave())){
                if(new String(txnuevaclave.getPassword()).equals(new String(txconfirmarclave.getPassword()))){
                    if(usuarioController.actualizarClave(new String(txnuevaclave.getPassword()))==1){
                        CUsuario.setClave(new String(txnuevaclave.getPassword()));
                        estado = 1;
                        this.dispose();
                    }else messageToast.response("No se actualizó la contraseña.", 230, 50, "danger");
                }else messageDialog.response("Las contraseñas que ingresó no coinsiden,<br>ingrese nuevamente su contraseña.", 4);
            }else messageDialog.response("Su contraseña actual no es la correcta.", 4);
        }else messageDialog.response("Ingrese los datos correctos.", 4);
    }//GEN-LAST:event_baceptarActionPerformed

    public int message(){
        return estado;
    }
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
            java.util.logging.Logger.getLogger(CambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambioClave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CambioClave dialog = new CambioClave(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txclave;
    private javax.swing.JPasswordField txconfirmarclave;
    private javax.swing.JPasswordField txnuevaclave;
    private javax.swing.JTextField txusuario;
    // End of variables declaration//GEN-END:variables
}
