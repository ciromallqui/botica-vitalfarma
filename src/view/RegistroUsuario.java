package view;

import aplication_class.CAdministrador;
import controller.UsuarioController;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import view.info.ConfirmDialog;
import view.info.MessageDialog;
import view.info.MessageToast;

public class RegistroUsuario extends javax.swing.JDialog {
    public DefaultTableModel modelo;
    public ConfirmDialog confirmDialog;
    public MessageDialog messageDialog;
    public MessageToast messageToast;
    public UsuarioController usuarioController;
    public RegistroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Image/chico.png")).getImage());
        confirmDialog = new ConfirmDialog(new javax.swing.JFrame(), true);
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        usuarioController = new UsuarioController();
        table();
        nuevo();
    }
    
    private void table(){
        String titulo[] = {"N°","Nombre Completo","Nombre de Usuario","Tipo de Usuario",""};
        modelo = new DefaultTableModel(null,titulo);
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMinWidth(40);
        tabla.getColumnModel().getColumn(0).setMaxWidth(40);
        tabla.getColumnModel().getColumn(3).setMinWidth(150);
        tabla.getColumnModel().getColumn(3).setMaxWidth(150);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.setDefaultRenderer(Object.class, new TableRowColor());
        JTableHeader head = tabla.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tabla.setTableHeader(head);
        usuarioController.listarUsuario(modelo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        eliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txnombreUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bguardar = new javax.swing.JButton();
        bactualizar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        txtipoUsuario = new javax.swing.JTextField();
        txclave = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        eliminar.setText("ELIMINAR");
        eliminar.setToolTipText("");
        jPopupMenu1.add(eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRO DE USUARIOS");

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 247));
        jLabel1.setText("Nombres y Apellidos:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(229, 229, 247));
        jLabel2.setText("Usuario de Acceso:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(229, 229, 247));
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(229, 229, 247));
        jLabel4.setText("Tipo de Usuario:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N°", "Nombre", "DNI", "Tipo Usuario"
            }
        ));
        tabla.setComponentPopupMenu(jPopupMenu1);
        tabla.setRowHeight(30);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

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

        beliminar.setBackground(new java.awt.Color(227, 111, 30));
        beliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        beliminar.setForeground(new java.awt.Color(204, 204, 204));
        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar.png"))); // NOI18N
        beliminar.setText("Eliminar");
        beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        beliminar.setContentAreaFilled(false);
        beliminar.setEnabled(false);
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

        txtipoUsuario.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txtipoUsuario.setText("EMPLEADO");
        txtipoUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 204));
        txtipoUsuario.setEnabled(false);

        txclave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txclave.setText("12345678");
        txclave.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txclave.setEnabled(false);

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Se recomienda usar su N° de DNI para el usuario de acceso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txnombre)
                            .addComponent(txnombreUsuario)
                            .addComponent(txtipoUsuario)
                            .addComponent(txclave))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txnombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txclave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
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

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if(modelo.getValueAt(tabla.getSelectedRow(), 3).equals("ADMINISTRADOR")){
            txnombre.setEnabled(false);
            txnombreUsuario.setEnabled(false);
            bguardar.setEnabled(false);
            bguardar.setForeground(new java.awt.Color(204, 204, 204));
            bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
            bactualizar.setEnabled(false);
            bactualizar.setForeground(new java.awt.Color(204, 204, 204));
            bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
            beliminar.setEnabled(false);
            beliminar.setForeground(new java.awt.Color(204, 204, 204));
            beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        }else{
            txnombre.setEnabled(true);
            txnombreUsuario.setEnabled(true);
            bguardar.setEnabled(false);
            bguardar.setForeground(new java.awt.Color(204, 204, 204));
            bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
            bactualizar.setEnabled(true);
            bactualizar.setForeground(new java.awt.Color(255, 255, 255));
            bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
            beliminar.setEnabled(true);
            beliminar.setForeground(new java.awt.Color(255, 255, 255));
            beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        }
        txclave.setText("********");
        txnombre.setText(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
        txnombreUsuario.setText(modelo.getValueAt(tabla.getSelectedRow(), 2).toString());
        txtipoUsuario.setText(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_tablaMouseClicked

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        if(txnombre.getText().length() > 2){
            if(txnombreUsuario.getText().length() > 4){
                CAdministrador a = new CAdministrador();
                a.setNombre(txnombre.getText());
                a.setNombreUsuario(txnombreUsuario.getText());
                a.setTipoUsuario(txtipoUsuario.getText());
                a.setClave(txclave.getText());
                usuarioController.insertarUsuario(a);
                while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                usuarioController.listarUsuario(modelo);
                nuevo();
                messageToast = new MessageToast(new javax.swing.JFrame(), true);
                messageToast.response("Usuario registrado", 200, 50, "success");
            }else messageDialog.response("El usuario de acceso debe tener almeno 4 caracteres", 4);
        }else messageDialog.response("Ingrese un nombre correcto de la persona", 4);
    }//GEN-LAST:event_bguardarActionPerformed

    private void bactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizarActionPerformed
        if(txnombre.getText().length() > 2){
            if(txnombreUsuario.getText().length() > 4){
                CAdministrador a = new CAdministrador();
                a.setNombre(txnombre.getText());
                a.setNombreUsuario(txnombreUsuario.getText());
                a.setIdUsuario(Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 4).toString()));
                usuarioController.actualizarUsuario(a);
                while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                usuarioController.listarUsuario(modelo);
                nuevo();
                messageToast = new MessageToast(new javax.swing.JFrame(), true);
                messageToast.response("Usuario actualizado", 200, 50, "success");
            }else messageDialog.response("El usuario de acceso debe tener almeno 4 caracteres", 4);
        }else messageDialog.response("Ingrese un nombre correcto de la persona", 4);
    }//GEN-LAST:event_bactualizarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
        if(tabla.getSelectedRowCount()==1){
            if(confirmDialog.response("¿Está seguro que desea eliminar al usuario?", 2)==1){
                usuarioController.eliminarUsuario(Integer.parseInt(modelo.getValueAt(tabla.getSelectedRow(), 4).toString()));
                while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                usuarioController.listarUsuario(modelo);
                nuevo();
                messageToast = new MessageToast(new javax.swing.JFrame(), true);
                messageToast.response("Usuario eliminado", 200, 50, "success");
            }
        }else messageDialog.response("Seleccione un registro", 3);
    }//GEN-LAST:event_beliminarActionPerformed

    private void beliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseExited
        beliminar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_beliminarMouseExited

    private void beliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseEntered
        if(beliminar.isEnabled()) beliminar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_beliminarMouseEntered

    private void nuevo(){
        txtipoUsuario.setText("EMPLEADO");
        txnombre.setText("");
        txnombreUsuario.setText("");
        txclave.setText(password());
        bguardar.setEnabled(true);
        bguardar.setForeground(new java.awt.Color(255, 255, 255));
        bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bactualizar.setEnabled(false);
        bactualizar.setForeground(new java.awt.Color(204, 204, 204));
        bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        beliminar.setEnabled(false);
        beliminar.setForeground(new java.awt.Color(204, 204, 204));
        beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
    }
    
    String password(){
        Random random = new Random();
        String pass="";
        String setOfCharacters = "ABCDEFGHIJ12345KLMNOPQRSTUVWXYZ67890";
        for(int i = 0; i < 8; i++){
            int randomInt = random.nextInt((int)(Math.random()*36+1));
            pass = pass + setOfCharacters.charAt(randomInt);
        }
        return pass;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RegistroUsuario dialog = new RegistroUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton beliminar;
    private javax.swing.JButton bguardar;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txclave;
    private javax.swing.JTextField txnombre;
    private javax.swing.JTextField txnombreUsuario;
    private javax.swing.JTextField txtipoUsuario;
    // End of variables declaration//GEN-END:variables
}
