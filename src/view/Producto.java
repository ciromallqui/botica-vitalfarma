package view;

import aplication_class.CProducto;
import controller.ParametroController;
import controller.ProductoController;
import cross_cuting.Codigo;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import view.info.ConfirmDialog;
import view.info.InputDialog;
import view.info.MessageDialog;
import view.info.MessageToast;

public class Producto extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;
    ProductoController productoController;
    ParametroController parametroController;
    CProducto producto;
    ConfirmDialog confirmDialog;
    MessageDialog messageDialog;
    InputDialog inputDialog;
    MessageToast messageToast;
    
    public Producto() {
        initComponents();
        confirmDialog = new ConfirmDialog(new javax.swing.JFrame(), true);
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        inputDialog = new InputDialog(new javax.swing.JFrame(), true);
        
        productoController = new ProductoController();
        parametroController = new ParametroController();
        productoController.cargarPresentacion(cbcategoria);
        
//        TextAutoCompleter tac = new TextAutoCompleter(txpresentacion); //Para el caso que las presentaciones son demasiadas
//        productoController.cargarPresentacion(tac);
        
        lbcodigo.setText(Codigo.idText("P", 5, parametroController.obtenerContador("CODIGO_PRODUCTO")));
        table();
        columnWidth();
    }
    private void table(){
        String titulo[] = {"N°","Código","Nombre del producto","Fecha Venc.","Precio unit. S/.","Stock"};
        modelo = new DefaultTableModel(null,titulo);
        tabla.setModel(modelo);
        productoController.mostrarProducto(modelo,"");
    }
    private void columnWidth(){
        tabla.getColumnModel().getColumn(0).setMinWidth(40);
        tabla.getColumnModel().getColumn(0).setMaxWidth(40);
        tabla.getColumnModel().getColumn(1).setMinWidth(60);
        tabla.getColumnModel().getColumn(1).setMaxWidth(60);
        tabla.getColumnModel().getColumn(3).setMinWidth(120);
        tabla.getColumnModel().getColumn(3).setMaxWidth(120);
        tabla.getColumnModel().getColumn(4).setMinWidth(120);
        tabla.getColumnModel().getColumn(4).setMaxWidth(120);
        tabla.getColumnModel().getColumn(5).setMinWidth(70);
        tabla.getColumnModel().getColumn(5).setMaxWidth(70);
        
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mcargar = new javax.swing.JMenuItem();
        meliminar = new javax.swing.JMenuItem();
        mduplicar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbcategoria = new javax.swing.JComboBox<>();
        bcategoria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txindicacion = new javax.swing.JEditorPane();
        jLabel2 = new javax.swing.JLabel();
        txnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txprecioVentaUnitario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txstockActual = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        bguardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        beliminar = new javax.swing.JButton();
        bactualizar = new javax.swing.JButton();
        bnuevo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        dchfechaVencimiento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txprecioCompraTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bduplicar = new javax.swing.JButton();
        txstockMinimo = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbcodigo = new javax.swing.JLabel();
        txbuscarp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        mcargar.setBackground(new java.awt.Color(255, 102, 0));
        mcargar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mcargar.setText("MOSTRAR TODO");
        mcargar.setOpaque(true);
        mcargar.setPreferredSize(new java.awt.Dimension(141, 30));
        mcargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mcargarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mcargar);

        meliminar.setBackground(new java.awt.Color(255, 102, 0));
        meliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        meliminar.setText("ELIMINAR");
        meliminar.setOpaque(true);
        meliminar.setPreferredSize(new java.awt.Dimension(141, 30));
        meliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(meliminar);

        mduplicar.setBackground(new java.awt.Color(255, 102, 0));
        mduplicar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mduplicar.setText("DUPLICAR");
        mduplicar.setOpaque(true);
        mduplicar.setPreferredSize(new java.awt.Dimension(141, 30));
        mduplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mduplicarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mduplicar);

        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE PRODUCTOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/producto.png"))); // NOI18N
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Presentación:");

        cbcategoria.setBackground(new java.awt.Color(255, 153, 0));
        cbcategoria.setEditable(true);
        cbcategoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar presentación" }));
        cbcategoria.setInheritsPopupMenu(true);

        bcategoria.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        bcategoria.setForeground(new java.awt.Color(0, 0, 153));
        bcategoria.setText("Agregar Presentación");
        bcategoria.setContentAreaFilled(false);
        bcategoria.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bcategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bcategoriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bcategoriaMouseExited(evt);
            }
        });
        bcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcategoriaActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(txindicacion);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre del producto:");

        txnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txnombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txnombreMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio total de compra:");

        txprecioVentaUnitario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txprecioVentaUnitario.setText("0.00");
        txprecioVentaUnitario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txprecioVentaUnitarioMouseClicked(evt);
            }
        });
        txprecioVentaUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txprecioVentaUnitarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txprecioVentaUnitarioKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("S/.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Stock actual:");

        txstockActual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Indicaciones:");

        bguardar.setBackground(new java.awt.Color(227, 111, 30));
        bguardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bguardar.setForeground(new java.awt.Color(255, 255, 255));
        bguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/guardar.png"))); // NOI18N
        bguardar.setText(" GUARDAR");
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

        beliminar.setBackground(new java.awt.Color(227, 111, 30));
        beliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        beliminar.setForeground(new java.awt.Color(204, 204, 204));
        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar.png"))); // NOI18N
        beliminar.setText("ELIMINAR");
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

        bactualizar.setBackground(new java.awt.Color(227, 111, 30));
        bactualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bactualizar.setForeground(new java.awt.Color(204, 204, 204));
        bactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar.png"))); // NOI18N
        bactualizar.setText(" ACTUALIZAR");
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

        bnuevo.setBackground(new java.awt.Color(227, 111, 30));
        bnuevo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bnuevo.setForeground(new java.awt.Color(255, 255, 255));
        bnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nuevo-documento.png"))); // NOI18N
        bnuevo.setText("NUEVO");
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

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "N°", "Código", "Nombre", "Precio", "Stock"
            }
        ));
        tabla.setToolTipText("Presione \"Click derecho\" para más opciones");
        tabla.setComponentPopupMenu(jPopupMenu1);
        tabla.setGridColor(new java.awt.Color(153, 153, 153));
        tabla.setRowHeight(25);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha  de vencimiento:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Precio de venta unitario:");

        txprecioCompraTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txprecioCompraTotal.setText("0.00");
        txprecioCompraTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txprecioCompraTotalMouseClicked(evt);
            }
        });
        txprecioCompraTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txprecioCompraTotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txprecioCompraTotalKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("S/.");

        bduplicar.setBackground(new java.awt.Color(227, 111, 30));
        bduplicar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bduplicar.setForeground(new java.awt.Color(204, 204, 204));
        bduplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/intercambiar.png"))); // NOI18N
        bduplicar.setText(" DUPLICAR");
        bduplicar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        bduplicar.setContentAreaFilled(false);
        bduplicar.setEnabled(false);
        bduplicar.setOpaque(true);
        bduplicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bduplicarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bduplicarMouseExited(evt);
            }
        });
        bduplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bduplicarActionPerformed(evt);
            }
        });

        txstockMinimo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Stock mínimo:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Código de producto:");

        lbcodigo.setBackground(new java.awt.Color(255, 255, 255));
        lbcodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcodigo.setForeground(new java.awt.Color(102, 102, 102));
        lbcodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbcodigo.setText("P00001");
        lbcodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        lbcodigo.setOpaque(true);

        txbuscarp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txbuscarpKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Buscar por nombre del producto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bduplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txprecioCompraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txprecioVentaUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dchfechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txstockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txstockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(jSeparator1))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcodigo)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bcategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txbuscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bcategoria)
                    .addComponent(txbuscarp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchfechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txstockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txstockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txprecioCompraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel9)
                                .addComponent(txprecioVentaUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bduplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void bguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseEntered
        if (bguardar.isEnabled()) bguardar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bguardarMouseEntered

    private void bguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseExited
        bguardar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bguardarMouseExited

    private void beliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseEntered
        if (beliminar.isEnabled()) beliminar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_beliminarMouseEntered

    private void beliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseExited
        beliminar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_beliminarMouseExited

    private void bactualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizarMouseEntered
        if (bactualizar.isEnabled()) bactualizar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bactualizarMouseEntered

    private void bactualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizarMouseExited
        bactualizar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bactualizarMouseExited

    private void bnuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnuevoMouseEntered
        if (bnuevo.isEnabled()) bnuevo.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bnuevoMouseEntered

    private void bnuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnuevoMouseExited
        bnuevo.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bnuevoMouseExited

    private void bcategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcategoriaMouseEntered
        bcategoria.setForeground(new java.awt.Color(51, 204, 255));
    }//GEN-LAST:event_bcategoriaMouseEntered

    private void bcategoriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcategoriaMouseExited
        bcategoria.setForeground(new java.awt.Color(0, 0, 153));
    }//GEN-LAST:event_bcategoriaMouseExited

    private void bcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcategoriaActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        String presentacion = inputDialog.response("Ingrese nueva presentación");
        try{
            if(presentacion.length()>0){
                if(!presentacion.equals("KO")){
                    productoController.insertarPresentacion(presentacion);
                    cbcategoria.removeAllItems();
                    cbcategoria.addItem("Seleccionar presentación");
                    productoController.cargarPresentacion(cbcategoria);
                }
            } else messageToast.response("Ingrese una presentación correcta", 250, 50, "danger");
        }catch(NullPointerException eX){}
        
    }//GEN-LAST:event_bcategoriaActionPerformed

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        if(cbcategoria.getSelectedIndex()>0){
            if(txnombre.getText().length()>0){
                if (dchfechaVencimiento.getDate() == null) {messageToast.response("Ingrese fecha de vencimiento", 250, 50, "warning"); return;}
                CProducto p = new CProducto();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fv = dchfechaVencimiento.getDate();
                p.setIdProducto(lbcodigo.getText());
                p.setNombre(txnombre.getText());
                p.setIndicacion(txindicacion.getText());
                p.setPrecioCompraTotal(Double.parseDouble(txprecioCompraTotal.getText()));
                p.setPrecioCompraUnitario(Double.parseDouble(txprecioCompraTotal.getText())/Integer.parseInt(txstockActual.getValue().toString()));
                p.setPrecioVentaUnitario(Double.parseDouble(txprecioVentaUnitario.getText()));
                p.setStockActual(Integer.parseInt(txstockActual.getValue().toString()));
                p.setStockMinimo(Integer.parseInt(txstockMinimo.getValue().toString()));
                p.setFechaVencimiento(sdf.format(fv));
                p.setIdPresentacion(productoController.obtenerIdPresentacion(cbcategoria.getSelectedItem().toString()));
                if (productoController.insertarProducto(p) == 1){
                    messageToast.response("Datos del producto guardados correctamente", 350, 50, "success");
                    lbcodigo.setText(Codigo.idText("P", 5, parametroController.obtenerContador("CODIGO_PRODUCTO")));
                    while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                    productoController.mostrarProducto(modelo,"");
                } else messageToast.response("No se pudo registrar el producto", 250, 50, "warning");
            } else messageToast.response("Ingrese nombre del producto", 250, 50, "warning");
        } else messageToast.response("Seleccione una presentación", 250, 50, "warning");
    }//GEN-LAST:event_bguardarActionPerformed

    private void txnombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txnombreMouseClicked
        txnombre.selectAll();
    }//GEN-LAST:event_txnombreMouseClicked

    private void txprecioVentaUnitarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txprecioVentaUnitarioMouseClicked
        txprecioVentaUnitario.selectAll();
    }//GEN-LAST:event_txprecioVentaUnitarioMouseClicked

    private void txprecioVentaUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txprecioVentaUnitarioKeyReleased
        if(txprecioVentaUnitario.getText().length()==0){
            txprecioVentaUnitario.setText("0.00");
            txprecioVentaUnitario.selectAll();
        }
    }//GEN-LAST:event_txprecioVentaUnitarioKeyReleased

    private void bactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true); 
        if(cbcategoria.getSelectedIndex()>0){
            if(txnombre.getText().length()>0){
                if (dchfechaVencimiento.getDate() == null) {messageToast.response("Ingrese fecha de vencimiento", 250, 50, "warning"); return;}
                CProducto p = new CProducto();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fv = dchfechaVencimiento.getDate();
                p.setIdProducto(lbcodigo.getText());
                p.setNombre(txnombre.getText());
                p.setIndicacion(txindicacion.getText());
                p.setPrecioCompraTotal(Double.parseDouble(txprecioCompraTotal.getText()));
                p.setPrecioCompraUnitario(Double.parseDouble(txprecioCompraTotal.getText())/Integer.parseInt(txstockActual.getValue().toString()));
                p.setPrecioVentaUnitario(Double.parseDouble(txprecioVentaUnitario.getText()));
                p.setStockActual(Integer.parseInt(txstockActual.getValue().toString()));
                p.setStockMinimo(Integer.parseInt(txstockMinimo.getValue().toString()));
                p.setFechaVencimiento(sdf.format(fv));
                p.setIdPresentacion(producto.getIdPresentacion());
                p.setIdProductoFechav(producto.getIdProductoFechav());
                if (productoController.actualizarProducto(p) == 1){
                    messageToast.response("Datos actualizado correctamente", 250, 50, "success");
                    nuevo();
                } else messageDialog.response("No se pudo actualizar los datos del producto", 4);
            } else messageToast.response("Ingrese nombre del producto", 250, 50, "warning");
        } else messageToast.response("Seleccione una presentación", 250, 50, "warning");
    }//GEN-LAST:event_bactualizarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if(tabla.getSelectedRowCount()>0){
            bactualizar.setEnabled(true);
            beliminar.setEnabled(true);
            bduplicar.setEnabled(true);
            bguardar.setEnabled(false);
            bguardar.setForeground(new java.awt.Color(204,204,204));
            beliminar.setForeground(new java.awt.Color(255,255,255));
            bactualizar.setForeground(new java.awt.Color(255,255,255));
            bduplicar.setForeground(new java.awt.Color(255,255,255));
            bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
            bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
            bduplicar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
            beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
            lbcodigo.setText(modelo.getValueAt(tabla.getSelectedRow(), 1).toString());
            
            producto = productoController.consultarProducto(modelo.getValueAt(tabla.getSelectedRow(), 1).toString(), modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
            cbcategoria.setSelectedItem(producto.getPresentacion());
            txnombre.setText(producto.getNombre());
            txprecioCompraTotal.setText(producto.getPrecioCompraTotal()+"");
            txprecioVentaUnitario.setText(producto.getPrecioVentaUnitario()+"");
            txstockMinimo.setValue(producto.getStockMinimo());
            txstockActual.setValue(producto.getStockActual());
            txindicacion.setText(producto.getIndicacion());
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dchfechaVencimiento.setDate(ft.parse(producto.getFechaVencimiento()));
            } catch (ParseException ex) {
                messageDialog.response("Formato de fecha de vencimiento incorrecto", 4);
            }
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void mcargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mcargarActionPerformed
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
        productoController.mostrarProducto(modelo,"");
    }//GEN-LAST:event_mcargarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        if(tabla.getSelectedRowCount()>1){messageDialog.response("Seleccione un solo registro", 4); return;}
        if(tabla.getSelectedRowCount()==1){
            int si = confirmDialog.response("¿Está seguro que desea eliminar el registro?", 2);
            if(si==1){
                if(productoController.eliminarProducto(producto)==1){
                    while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                    productoController.mostrarProducto(modelo,"");
                    nuevo();
                }else messageToast.response("No se pudo eliminar el registro", 250, 50, "warning");
            }
        } else messageToast.response("Seleccione un producto que desea eliminar", 250, 50, "warning");
    }//GEN-LAST:event_beliminarActionPerformed

    private void bnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_bnuevoActionPerformed

    private void meliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meliminarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        if(tabla.getSelectedRowCount()>1){messageDialog.response("Seleccione un solo registro", 4); return;}
        if(tabla.getSelectedRowCount()==1){
            int si = confirmDialog.response("¿Está seguro que desea eliminar el registro?", 2);
            if(si==1){
                if(productoController.eliminarProducto(producto)==1){
                    while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                    productoController.mostrarProducto(modelo,"");
                    nuevo();
                }else messageToast.response("No se pudo eliminar el registro", 250, 50, "warning");
            }
        } else messageToast.response("Seleccione un producto que desea eliminar", 250, 50, "warning");
    }//GEN-LAST:event_meliminarActionPerformed

    private void txprecioCompraTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txprecioCompraTotalMouseClicked
        txprecioCompraTotal.selectAll();
    }//GEN-LAST:event_txprecioCompraTotalMouseClicked

    private void txprecioCompraTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txprecioCompraTotalKeyReleased
        if(txprecioCompraTotal.getText().length()==0){
            txprecioCompraTotal.setText("0.00");
            txprecioCompraTotal.selectAll();
        }
    }//GEN-LAST:event_txprecioCompraTotalKeyReleased

    private void bduplicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bduplicarMouseEntered
        if (bduplicar.isEnabled()) bduplicar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bduplicarMouseEntered

    private void bduplicarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bduplicarMouseExited
        bduplicar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bduplicarMouseExited

    private void bduplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bduplicarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        int si = confirmDialog.response("¿Está seguro que desea duplicar el producto?", 2);
        if(si==1){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fv = dchfechaVencimiento.getDate();
            producto.setFechaVencimiento(sdf.format(fv));
            productoController.duplicarProducto(producto);
            while(modelo.getRowCount()!=0){modelo.removeRow(0);}
            productoController.mostrarProducto(modelo,"");
            messageToast.response("El producto ha sido duplicado", 220, 50, "warning");
        }
    }//GEN-LAST:event_bduplicarActionPerformed

    private void txbuscarpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbuscarpKeyReleased
        while(modelo.getRowCount()!=0){
            modelo.removeRow(0);
        }
        productoController.mostrarProducto(modelo, txbuscarp.getText());
    }//GEN-LAST:event_txbuscarpKeyReleased

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Main.miproducto.setEnabled(true);
        Control.pproducto.setVisible(true);
        Main.miproducto.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Main.miproducto.setEnabled(false);
        Control.pproducto.setVisible(false);
        Main.miproducto.setForeground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_formInternalFrameOpened

    private void txprecioCompraTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txprecioCompraTotalKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0'){
            if (evt.getKeyChar() != '.')
                evt.consume();
        }
    }//GEN-LAST:event_txprecioCompraTotalKeyTyped

    private void txprecioVentaUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txprecioVentaUnitarioKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0'){
            if (evt.getKeyChar() != '.')
                evt.consume();
        }
    }//GEN-LAST:event_txprecioVentaUnitarioKeyTyped

    private void mduplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mduplicarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        if(tabla.getSelectedRowCount()==1){
            int si = confirmDialog.response("¿Está seguro que desea duplicar el producto?", 2);
            if(si==1){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fv = dchfechaVencimiento.getDate();
                producto.setFechaVencimiento(sdf.format(fv));
                productoController.duplicarProducto(producto);
                while(modelo.getRowCount()!=0){modelo.removeRow(0);}
                productoController.mostrarProducto(modelo,"");
                messageToast.response("El producto ha sido duplicado", 220, 50, "warning");
            }
        } else messageToast.response("Seleccione un producto que desea duplicar", 230, 60, "danger");
    }//GEN-LAST:event_mduplicarActionPerformed
    
    private void nuevo(){
        lbcodigo.setText(Codigo.idText("P", 5, parametroController.obtenerContador("CODIGO_PRODUCTO")));
        cbcategoria.setSelectedIndex(0);
        txnombre.setText(null);
        txprecioVentaUnitario.setText("0.00");
        txprecioCompraTotal.setText("0.00");
        txstockMinimo.setValue(0);
        txstockActual.setValue(0);
        txindicacion.setText(null);
        dchfechaVencimiento.setDate(null);
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
        productoController.mostrarProducto(modelo,"");
        bguardar.setEnabled(true);
        beliminar.setEnabled(false);
        bactualizar.setEnabled(false);
        bduplicar.setEnabled(false);
        bguardar.setForeground(new java.awt.Color(255,255,255));
        beliminar.setForeground(new java.awt.Color(204,204,204));
        bactualizar.setForeground(new java.awt.Color(204,204,204));
        bduplicar.setForeground(new java.awt.Color(204,204,204));
        bactualizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
        beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
        bduplicar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
        bguardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
        txnombre.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bactualizar;
    private javax.swing.JButton bcategoria;
    private javax.swing.JButton bduplicar;
    private javax.swing.JButton beliminar;
    private javax.swing.JButton bguardar;
    private javax.swing.JButton bnuevo;
    private javax.swing.JComboBox<String> cbcategoria;
    private com.toedter.calendar.JDateChooser dchfechaVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbcodigo;
    private javax.swing.JMenuItem mcargar;
    private javax.swing.JMenuItem mduplicar;
    private javax.swing.JMenuItem meliminar;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txbuscarp;
    private javax.swing.JEditorPane txindicacion;
    private javax.swing.JTextField txnombre;
    private javax.swing.JTextField txprecioCompraTotal;
    private javax.swing.JTextField txprecioVentaUnitario;
    private javax.swing.JSpinner txstockActual;
    private javax.swing.JSpinner txstockMinimo;
    // End of variables declaration//GEN-END:variables
}
