package view;

import cross_cuting.Validar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import view.info.InputDialog;
import view.info.MessageDialog;
import view.info.MessageToast;

public class Backap extends javax.swing.JDialog {
    private String path;
    public MessageDialog messageDialog;
    public InputDialog inputDialog;
    public MessageToast messageToast;
    public Backap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        inputDialog = new InputDialog(new javax.swing.JFrame(), true);
        
        setIconImage(new ImageIcon(getClass().getResource("/Image/base-de-datosseg.png")).getImage());
        lbdb.setText(Validar.nombreDB());
        bdb.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rbbackap = new javax.swing.JRadioButton();
        rbrestaurar = new javax.swing.JRadioButton();
        baceptar = new javax.swing.JButton();
        txruta = new javax.swing.JTextField();
        barchivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbdb = new javax.swing.JLabel();
        bdb = new javax.swing.JButton();
        lbmsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CONTROL DE BASES DE DATOS");

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        buttonGroup1.add(rbbackap);
        rbbackap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbbackap.setForeground(new java.awt.Color(255, 255, 255));
        rbbackap.setText("Generar backup de base de datos");
        rbbackap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbbackapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbrestaurar);
        rbrestaurar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbrestaurar.setForeground(new java.awt.Color(255, 255, 255));
        rbrestaurar.setText("Restaurar base de datos");
        rbrestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbrestaurarActionPerformed(evt);
            }
        });

        baceptar.setBackground(new java.awt.Color(255, 153, 0));
        baceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        baceptar.setForeground(new java.awt.Color(204, 204, 204));
        baceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cheque.png"))); // NOI18N
        baceptar.setText("Aceptar");
        baceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        baceptar.setContentAreaFilled(false);
        baceptar.setEnabled(false);
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

        txruta.setBackground(new java.awt.Color(204, 204, 204));
        txruta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txruta.setEnabled(false);

        barchivo.setBackground(new java.awt.Color(255, 153, 0));
        barchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/carpeta.png"))); // NOI18N
        barchivo.setToolTipText("");
        barchivo.setContentAreaFilled(false);
        barchivo.setEnabled(false);
        barchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barchivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barchivoMouseExited(evt);
            }
        });
        barchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barchivoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Base de datos:");

        lbdb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdb.setForeground(new java.awt.Color(255, 204, 0));
        lbdb.setText("nameDB");

        bdb.setBackground(new java.awt.Color(255, 153, 0));
        bdb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/base-de-datos.png"))); // NOI18N
        bdb.setToolTipText("Crear nuva base de datos");
        bdb.setContentAreaFilled(false);
        bdb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bdbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bdbMouseExited(evt);
            }
        });
        bdb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdbActionPerformed(evt);
            }
        });

        lbmsg.setForeground(new java.awt.Color(0, 0, 102));
        lbmsg.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbdb)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bdb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txruta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(barchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbbackap)
                                .addGap(18, 18, 18)
                                .addComponent(rbrestaurar)))
                        .addComponent(baceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbmsg))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbbackap)
                    .addComponent(rbrestaurar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbdb))
                    .addComponent(bdb, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lbmsg)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barchivo)
                    .addComponent(txruta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(baceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void barchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barchivoActionPerformed
        try {
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this);
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            path = path.replace('\\', '/');
            if(rbbackap.isSelected()){
                Calendar c=Calendar.getInstance();
                String fecha=String.valueOf(c.get(Calendar.DATE));
                fecha=fecha+"-"+String.valueOf(c.get(Calendar.MONTH));
                fecha=fecha+"-"+String.valueOf(c.get(Calendar.YEAR));
                path = path+"-"+fecha+".sql";
            }
            txruta.setText(path);
        } catch (NullPointerException | IndexOutOfBoundsException e) {messageDialog.response("tenga más cuidado al seleccionar el archivo", 4);}
    }//GEN-LAST:event_barchivoActionPerformed

    private void baceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baceptarActionPerformed
        if(txruta.getText().length() > 0){
            if(rbbackap.isSelected()){
                generarBackupMySQL();
            }
            else{
                restaurarBackapMySql();
            }
        }else messageDialog.response("Seleccione la ruta del archivo", 3);
    }//GEN-LAST:event_baceptarActionPerformed

    private void rbbackapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbbackapActionPerformed
        baceptar.setEnabled(true);
        barchivo.setEnabled(true);
        bdb.setVisible(false);
        txruta.setText("");
        baceptar.setForeground(new java.awt.Color(255, 255, 255));
        baceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        lbmsg.setText("El backup se creará con este nombre de base de datos");
        barchivo.setToolTipText("Seleccione la ruta donde desea guardar el backup");
    }//GEN-LAST:event_rbbackapActionPerformed

    private void barchivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barchivoMouseEntered
        barchivo.setOpaque(true);
    }//GEN-LAST:event_barchivoMouseEntered

    private void barchivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barchivoMouseExited
        barchivo.setOpaque(false);
    }//GEN-LAST:event_barchivoMouseExited

    private void rbrestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbrestaurarActionPerformed
        baceptar.setEnabled(true);
        barchivo.setEnabled(true);
        bdb.setVisible(true);
        txruta.setText("");
        baceptar.setForeground(new java.awt.Color(255, 255, 255));
        baceptar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        lbmsg.setText("Asegúrese de que el backup de la base de datos tenga este nombre");
        barchivo.setToolTipText("Seleccione el archivo .sql, el cual desea restaurar");
    }//GEN-LAST:event_rbrestaurarActionPerformed

    private void bdbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdbMouseEntered
        bdb.setOpaque(true);
    }//GEN-LAST:event_bdbMouseEntered

    private void bdbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bdbMouseExited
        bdb.setOpaque(false);
    }//GEN-LAST:event_bdbMouseExited

    private void bdbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdbActionPerformed
        String name = inputDialog.response("Ingrse el nuevo nombre de base de datos");
        if(!name.equals("KO")){
            cambiarNombre(name);
            lbdb.setText(Validar.nombreDB());
        }
    }//GEN-LAST:event_bdbActionPerformed

    private void baceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baceptarMouseExited
        baceptar.setOpaque(false);
    }//GEN-LAST:event_baceptarMouseExited

    private void baceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baceptarMouseEntered
        baceptar.setOpaque(true);
    }//GEN-LAST:event_baceptarMouseEntered

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Backap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Backap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Backap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Backap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Backap dialog = new Backap(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baceptar;
    private javax.swing.JButton barchivo;
    private javax.swing.JButton bdb;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbdb;
    private javax.swing.JLabel lbmsg;
    private javax.swing.JRadioButton rbbackap;
    private javax.swing.JRadioButton rbrestaurar;
    private javax.swing.JTextField txruta;
    // End of variables declaration//GEN-END:variables
    private void generarBackupMySQL(){
        try{
            Runtime runtime = Runtime.getRuntime();
            FileWriter fw = new FileWriter(path);
            Process child = runtime.exec("C:/xampp/mysql/bin/mysqldump.exe --opt --password="+Validar.claveDB()+" --user=root "
                    + "--databases "+Validar.nombreDB()+" -R"); 
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);

            String line;
            while( (line=br.readLine()) != null ) {
                fw.write(line + "\n");
            }
            fw.close();
            irs.close();
            br.close();
            
            messageToast = new MessageToast(new javax.swing.JFrame(), true);
            messageToast.setModal(true);
            messageToast.response("Archivo generado correctamente", 230, 50, "success");
        }catch(Exception e){
            messageDialog.response("No se pudo generar el backup, reinicie la aplicación he intente de nuevo", 4);
        }
    }
    private void restaurarBackapMySql(){
        String restoreCmd = "C:/xampp/mysql/bin/mysql --user=root --password="+Validar.claveDB()+" --host=localhost -e \"source " + path;
        Process runtimProcess;
        try {
            runtimProcess = Runtime.getRuntime().exec(restoreCmd);
            int proceCom = runtimProcess.waitFor();
            
            if (proceCom==0) {
                messageToast = new MessageToast(new javax.swing.JFrame(), true);
                messageToast.setModal(true);
                messageToast.response("La base de datos de restauró correctamente", 250, 50, "success");
                dispose();
            }else{
                messageDialog.response("No se pudo restaurar la base de tados, <br>verifique su archivo de datos", 4);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    private void cambiarNombre(String name){
        String clave = Validar.claveDB();
        String barra = File.separator;
        String ruta = System.getProperty("user.dir")+barra+"registro"+barra;
        try (FileWriter escribir = new FileWriter(ruta+"database.dat")) {
            PrintWriter guardar = new PrintWriter(escribir);
            guardar.println("dbname="+name);
            guardar.println("password="+clave);
        } catch (IOException ex) {
            messageDialog.response(ex.getMessage(), 4);
        }
    }
}