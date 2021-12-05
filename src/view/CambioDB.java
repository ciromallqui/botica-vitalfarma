package view;

import cross_cuting.Validar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.ImageIcon;
import model.Conexion;
import view.info.ConfirmDialog;
import view.info.MessageToast;

public class CambioDB extends javax.swing.JDialog {

    public ConfirmDialog confirmDialog;
    public MessageToast messageToast;
    public CambioDB(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        confirmDialog = new ConfirmDialog(new javax.swing.JFrame(), true);
        setIconImage(new ImageIcon(getClass().getResource("/Image/base-de-datosseg.png")).getImage());
        List<String> datos=Conexion.conecMySql();
        for (String dato : datos) {
            if(dato!=null&&!dato.equals("mysql")&&!dato.equals("phpmyadmin")){
                cbdb.addItem(dato);
            }
        }
        cbdb.setSelectedItem(Validar.nombreDB());
        if(cbdb.getItemCount()==1)
            baceptar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbdb = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        baceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONTROL DE BASES DE DATOS");
        setMinimumSize(new java.awt.Dimension(435, 220));
        setPreferredSize(new java.awt.Dimension(435, 220));

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("<html>La base de datos que seleccione será el que administre sus datos, es recomendable cerrar el sistema y ejecutar nuevamente luego del cambio de Base de Datos</html>");

        cbdb.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bases de Datos:");

        baceptar.setBackground(new java.awt.Color(227, 111, 30));
        baceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        baceptar.setForeground(new java.awt.Color(255, 255, 255));
        baceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cheque.png"))); // NOI18N
        baceptar.setText("Aceptar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbdb, 0, 286, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbdb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if(confirmDialog.response("El control de sus datos en muy importante, asegurese de seleccionar la opción correcta<br><br>¿Está seguro que desea usar la base de datos seleccionada?", 2)==1){
            cambiarNombreDB();
            messageToast.setModal(true);
            messageToast.response("Base de datos seleccionado.", 220, 50, "success");
            dispose();
        }
    }//GEN-LAST:event_baceptarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CambioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambioDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CambioDB dialog = new CambioDB(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbdb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
    private void cambiarNombreDB(){
        String barra = File.separator;
        String clave = Validar.claveDB();
        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
        try (FileWriter escribir = new FileWriter(ruta+"user.dat")) {
            PrintWriter guardar = new PrintWriter(escribir);
            guardar.println("driver=com.mysql.jdbc.Driver");
            guardar.println("url=jdbc:mysql://localhost");
            guardar.println("dbname="+cbdb.getSelectedItem().toString());
            guardar.println("dbuser=root");
            guardar.println("password="+clave);
        } catch (IOException ex) {
            messageToast = new MessageToast(new javax.swing.JFrame(), true);
            messageToast.response("El sistema no puede encontrar el archivo de configuración de datos", 250, 80, "danger");
        }
        try(FileWriter escribirDB = new FileWriter(ruta+"database.dat")){
            PrintWriter guardarDB = new PrintWriter(escribirDB);
            guardarDB.println("dbname="+cbdb.getSelectedItem().toString());
            guardarDB.println("password="+clave);
        }catch(IOException ex){
            messageToast.response("El sistema no puede encontrar el archivo de configuración de datos", 250, 80, "danger");
        }
    }
}
