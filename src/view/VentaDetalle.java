package view;

import MFC.util.JLibrary.DecimalNumber;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import aplication_class.CProducto;
import aplication_class.CUsuario;
import aplication_class.CVenta;
import controller.ProductoController;
import controller.TurnoController;
import controller.VentaController;
import cross_cuting.TablaProductRender;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import javax.swing.table.JTableHeader;
import view.info.ConfirmDialog;
import view.info.MessageDialog;
import view.info.MessageToast;

public class VentaDetalle extends javax.swing.JInternalFrame {
    DefaultTableModel modelod;
    DefaultTableModel modelop;
    DefaultTableModel modelov;
    JTextField txproducto;
    JTextField txdescuento;
    JTextField txunidad;
    public ProductoController productoController;
    public VentaController ventaController;
    public TurnoController turnoController;
    public ConfirmDialog confirmDialog;
    public MessageDialog messageDialog;
    public MessageToast messageToast;
    public VentaDetalle() {
        initComponents();
        turnoController = new TurnoController();
        productoController = new ProductoController();
        ventaController = new VentaController();
        confirmDialog = new ConfirmDialog(new javax.swing.JFrame(), true);
        messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
        tproducto.setShowHorizontalLines(true);
        tventa.setShowHorizontalLines(true);
        tdetalle.setShowHorizontalLines(true);
        tdetalle.setShowVerticalLines(true);
        
        Date d = new Date();
        String fecha = d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
        DateTimeFormatter stf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate ld = LocalDate.parse(fecha,stf);
        stf = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'del' YYYY");
        lbfecha.setText(stf.format(ld));
        tableDetalle();
        tableVenta();
        productoController.cargarPresentacion(cbcategoria);
        
        txproducto = new JTextField();
        TableColumn tc = tdetalle.getColumnModel().getColumn(1);
        TableCellEditor tce = new DefaultCellEditor(txproducto);
        tc.setCellEditor(tce);
        
        txproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txproductoKeyTyped(evt);
            }
        });
        
        txdescuento = new JTextField();
        tc = tdetalle.getColumnModel().getColumn(4);
        tce = new DefaultCellEditor(txdescuento);
        tc.setCellEditor(tce);
        
        txdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txdescuentoKeyReleased(evt);
            }
        });
        txdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txdescuentoKeyTyped(evt);
            }
        });
        
        txunidad = new JTextField();
        tc = tdetalle.getColumnModel().getColumn(2);
        tce = new DefaultCellEditor(txunidad);
        tc.setCellEditor(tce);
        txunidad.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txunidadKeyReleased(evt);
            }
        });
        txunidad.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txunidadKeyTyped(evt);
            }
        });
        
//        TextAutoCompleter tac = new TextAutoCompleter(txproducto);
//        DProducto.loadProducto(tac);

        this.setSize(920, 350);
    }
    private void tableDetalle(){
        String titulo[] = {"N°","Presentación","Producto","Cantidad","Monto S/.","Descuento S/.",""};
        modelod = new DefaultTableModel(null,titulo){
            @Override
            public boolean isCellEditable(int row, int column) {
                return column !=0 && column !=1 && column !=2 && column !=4;
            }
        };
        tdetalle.setModel(modelod);
        tdetalle.getColumnModel().getColumn(0).setMinWidth(50);
        tdetalle.getColumnModel().getColumn(0).setMaxWidth(50);
        tdetalle.getColumnModel().getColumn(3).setMinWidth(100);
        tdetalle.getColumnModel().getColumn(3).setMaxWidth(100);
        tdetalle.getColumnModel().getColumn(4).setMinWidth(100);
        tdetalle.getColumnModel().getColumn(4).setMaxWidth(100);
        tdetalle.getColumnModel().getColumn(5).setMinWidth(120);
        tdetalle.getColumnModel().getColumn(5).setMaxWidth(120);
        tdetalle.getColumnModel().getColumn(6).setMinWidth(1);
        tdetalle.getColumnModel().getColumn(6).setMaxWidth(1);
        tdetalle.setDefaultRenderer(Object.class, new TableRowColor());
        JTableHeader head = tdetalle.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tdetalle.setTableHeader(head);
    }
    private void tableProducto(){
        String titulop[] = {"N°","Presentación","Producto","Laboratorio","Fecha venc.","Precio unit.","Stock",""};
        modelop = new DefaultTableModel(null,titulop){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tproducto.setModel(modelop);
        tproducto.getColumnModel().getColumn(0).setMinWidth(60);
        tproducto.getColumnModel().getColumn(0).setMaxWidth(60);
        tproducto.getColumnModel().getColumn(4).setMinWidth(120);
        tproducto.getColumnModel().getColumn(4).setMaxWidth(120);
        tproducto.getColumnModel().getColumn(5).setMinWidth(120);
        tproducto.getColumnModel().getColumn(5).setMaxWidth(120);
        tproducto.getColumnModel().getColumn(6).setMinWidth(80);
        tproducto.getColumnModel().getColumn(6).setMaxWidth(80);
        tproducto.getColumnModel().getColumn(7).setMinWidth(1);
        tproducto.getColumnModel().getColumn(7).setMaxWidth(1);
        
        tproducto.setDefaultRenderer(Object.class, new TableRowColor());
        productoController.mostrarProducto(modelop, "");
        JTableHeader head = tproducto.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tproducto.setTableHeader(head);
    }
    private void tableVenta(){
        String titulop[] = {"N°","Presentación","Producto","Laboratorio","Fecha venc.","Cantidad","Monto S/.","Turno"};
        modelov = new DefaultTableModel(null,titulop){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tventa.setModel(modelov);
        tventa.getColumnModel().getColumn(0).setMinWidth(60);
        tventa.getColumnModel().getColumn(0).setMaxWidth(60);
        tventa.getColumnModel().getColumn(4).setMinWidth(120);
        tventa.getColumnModel().getColumn(4).setMaxWidth(120);
        tventa.getColumnModel().getColumn(5).setMinWidth(120);
        tventa.getColumnModel().getColumn(5).setMaxWidth(120);
        tventa.getColumnModel().getColumn(6).setMinWidth(80);
        tventa.getColumnModel().getColumn(6).setMaxWidth(80);
        tventa.getColumnModel().getColumn(7).setMinWidth(100);
        tventa.getColumnModel().getColumn(7).setMaxWidth(100);
        
        tventa.setDefaultRenderer(Object.class, new TableRowColor());
//        productoController.mostrarProducto(modelop, "");
        JTableHeader head = tventa.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tventa.setTableHeader(head);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        eliminar = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        exportar = new javax.swing.JMenuItem();
        PRODUCTO = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tproducto = new javax.swing.JTable();
        cbcategoria = new javax.swing.JComboBox<>();
        txbuscar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txdescripcion = new javax.swing.JEditorPane();
        bexportar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txCantidadProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdetalle = new javax.swing.JTable();
        lbfecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbmonto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txefectivo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lbvuelto = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        tventa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        bbuscar = new javax.swing.JButton();
        bguardar = new javax.swing.JButton();
        beliminar = new javax.swing.JButton();
        bnuevo = new javax.swing.JButton();
        bmostrarVenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        eliminar.setBackground(new java.awt.Color(227, 111, 30));
        eliminar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        eliminar.setMnemonic('X');
        eliminar.setText("ELIMINAR");
        eliminar.setToolTipText("");
        eliminar.setIconTextGap(0);
        eliminar.setOpaque(true);
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(eliminar);

        exportar.setBackground(new java.awt.Color(227, 111, 30));
        exportar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        exportar.setText("EXPORTAR");
        exportar.setOpaque(true);
        exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(exportar);

        PRODUCTO.setTitle("SELECCIONAR PRODUCTO");
        PRODUCTO.setMinimumSize(new java.awt.Dimension(860, 523));
        PRODUCTO.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(227, 111, 30));

        tproducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tproducto.setComponentPopupMenu(jPopupMenu2);
        tproducto.setGridColor(new java.awt.Color(204, 204, 204));
        tproducto.setRowHeight(25);
        tproducto.getTableHeader().setReorderingAllowed(false);
        tproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tproductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tproducto);

        cbcategoria.setBackground(new java.awt.Color(255, 153, 0));
        cbcategoria.setMaximumRowCount(15);
        cbcategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una presentación" }));
        cbcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcategoriaActionPerformed(evt);
            }
        });

        txbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txbuscarMouseClicked(evt);
            }
        });
        txbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txbuscarKeyReleased(evt);
            }
        });

        txdescripcion.setEditable(false);
        jScrollPane3.setViewportView(txdescripcion);

        bexportar.setBackground(new java.awt.Color(227, 111, 30));
        bexportar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bexportar.setForeground(new java.awt.Color(204, 204, 204));
        bexportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exportar.png"))); // NOI18N
        bexportar.setText(" Seleccionar");
        bexportar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        bexportar.setContentAreaFilled(false);
        bexportar.setEnabled(false);
        bexportar.setOpaque(true);
        bexportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bexportarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bexportarMouseExited(evt);
            }
        });
        bexportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexportarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresar el nombre del producto:");

        txCantidadProducto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txCantidadProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCantidadProducto.setText("10");
        txCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCantidadProductoKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ingrese cantidad de producto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bexportar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txCantidadProducto)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bexportar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout PRODUCTOLayout = new javax.swing.GroupLayout(PRODUCTO.getContentPane());
        PRODUCTO.getContentPane().setLayout(PRODUCTOLayout);
        PRODUCTOLayout.setHorizontalGroup(
            PRODUCTOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PRODUCTOLayout.setVerticalGroup(
            PRODUCTOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("ÁREA DE VENTAS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bienes.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        tdetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Producto", "Cantidad", "Monto", "descuento", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tdetalle.setToolTipText("Para realizar cualquier ingreso, dar doble click en la casilla requerida");
        tdetalle.setComponentPopupMenu(jPopupMenu1);
        tdetalle.setGridColor(new java.awt.Color(204, 204, 204));
        tdetalle.setRowHeight(25);
        tdetalle.setShowVerticalLines(false);
        tdetalle.getTableHeader().setReorderingAllowed(false);
        tdetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tdetalleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tdetalleKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tdetalle);
        tdetalle.getAccessibleContext().setAccessibleDescription("");

        lbfecha.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbfecha.setForeground(new java.awt.Color(255, 255, 255));
        lbfecha.setText("19 de Julio del 2018");

        jLabel7.setBackground(new java.awt.Color(244, 178, 35));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Monto total: ");
        jLabel7.setOpaque(true);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lbmonto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbmonto.setText("0.00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("S/. ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbmonto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbmonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel14.setBackground(new java.awt.Color(244, 178, 35));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" Pagó Con: ");
        jLabel14.setOpaque(true);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("S/.");

        txefectivo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txefectivo.setText("0");
        txefectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txefectivoMouseClicked(evt);
            }
        });
        txefectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txefectivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txefectivoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(txefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txefectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel17.setBackground(new java.awt.Color(244, 178, 35));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText(" Vuelto: ");
        jLabel17.setOpaque(true);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        lbvuelto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbvuelto.setText("0.00");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("S/. ");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbvuelto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(jLabel20))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbvuelto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tventa.setModel(new javax.swing.table.DefaultTableModel(
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
        tventa.setGridColor(new java.awt.Color(204, 204, 204));
        tventa.setRowHeight(25);
        tventa.setShowVerticalLines(false);
        jScrollPane4.setViewportView(tventa);

        jPanel3.setBackground(new java.awt.Color(227, 111, 30));

        bbuscar.setBackground(new java.awt.Color(227, 111, 30));
        bbuscar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        bbuscar.setForeground(new java.awt.Color(255, 255, 255));
        bbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscar_boton.png"))); // NOI18N
        bbuscar.setMnemonic('B');
        bbuscar.setText("BUSCAR");
        bbuscar.setToolTipText("Precione Alt + B");
        bbuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bbuscar.setContentAreaFilled(false);
        bbuscar.setMargin(new java.awt.Insets(2, 4, 2, 4));
        bbuscar.setOpaque(true);
        bbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bbuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bbuscarMouseExited(evt);
            }
        });
        bbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbuscarActionPerformed(evt);
            }
        });

        bguardar.setBackground(new java.awt.Color(227, 111, 30));
        bguardar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
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

        beliminar.setBackground(new java.awt.Color(227, 111, 30));
        beliminar.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        beliminar.setForeground(new java.awt.Color(255, 255, 255));
        beliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/eliminar.png"))); // NOI18N
        beliminar.setMnemonic('E');
        beliminar.setText("Eliminar");
        beliminar.setToolTipText("Precione Alt + E");
        beliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        beliminar.setContentAreaFilled(false);
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

        bnuevo.setBackground(new java.awt.Color(227, 111, 30));
        bnuevo.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        bnuevo.setForeground(new java.awt.Color(255, 255, 255));
        bnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nuevo-documento.png"))); // NOI18N
        bnuevo.setMnemonic('N');
        bnuevo.setText(" Nuevo");
        bnuevo.setToolTipText("Precione Alt + N");
        bnuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bnuevo.setContentAreaFilled(false);
        bnuevo.setMargin(new java.awt.Insets(2, 4, 2, 4));
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

        bmostrarVenta.setBackground(new java.awt.Color(227, 111, 30));
        bmostrarVenta.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        bmostrarVenta.setForeground(new java.awt.Color(255, 255, 255));
        bmostrarVenta.setMnemonic('N');
        bmostrarVenta.setText("Mostrar Detalle");
        bmostrarVenta.setToolTipText("Precione Alt + N");
        bmostrarVenta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bmostrarVenta.setContentAreaFilled(false);
        bmostrarVenta.setMargin(new java.awt.Insets(2, 4, 2, 4));
        bmostrarVenta.setOpaque(true);
        bmostrarVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bmostrarVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bmostrarVentaMouseExited(evt);
            }
        });
        bmostrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmostrarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(beliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bmostrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(bbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bmostrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de ventas por turno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbfecha))
                            .addComponent(jLabel1))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
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

    private void bbuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbuscarMouseEntered
        if(bbuscar.isEnabled()) bbuscar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bbuscarMouseEntered

    private void bbuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bbuscarMouseExited
        bbuscar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bbuscarMouseExited

    private void bguardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseEntered
        if(bguardar.isEnabled()) bguardar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bguardarMouseEntered

    private void bguardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bguardarMouseExited
        bguardar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bguardarMouseExited

    private void bnuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnuevoMouseEntered
        bnuevo.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bnuevoMouseEntered

    private void bnuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bnuevoMouseExited
        bnuevo.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bnuevoMouseExited

    private void beliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseEntered
        if(beliminar.isEnabled()) beliminar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_beliminarMouseEntered

    private void beliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliminarMouseExited
        beliminar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_beliminarMouseExited

    private void bbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbuscarActionPerformed
        tableProducto();
        cbcategoria.setSelectedIndex(0);
        txbuscar.setText(null);
        txdescripcion.setText(null);
        PRODUCTO.setLocationRelativeTo(null);
        PRODUCTO.setResizable(false);
        PRODUCTO.setVisible(true);
    }//GEN-LAST:event_bbuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        Main.minuevaVenta.setEnabled(false);
        if(!Main.minuevoControl.isEnabled()) Control.pnuevaVenta.setVisible(false);
        Main.minuevaVenta.setForeground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_formInternalFrameOpened

    private void tdetalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tdetalleKeyReleased
        try{
            if(modelod.getRowCount() > 0){
                if(modelod.getValueAt(tdetalle.getSelectedRow(), 5).toString().length()==0){
                   modelod.setValueAt("0.00",tdetalle.getSelectedRow(), 5); 
                }
                if(evt.getKeyChar()==KeyEvent.VK_ENTER){
                    if(tdetalle.getSelectedColumn()==3){
                        String filtro[] = modelod.getValueAt(tdetalle.getSelectedRow(), 6).toString().split(",");
                        CProducto producto = productoController.consultarProducto(filtro[0], filtro[1]);

                        int stock = producto.getStockActual();
                        double precio = producto.getPrecioVentaUnitario();
                        if(modelod.getValueAt(tdetalle.getSelectedRow(), 3).toString().length()==0){
                            modelod.setValueAt(1, tdetalle.getSelectedRow(), 3);
                        }
                        int cantidad = Integer.parseInt(modelod.getValueAt(tdetalle.getSelectedRow(), 3).toString());
                        if(cantidad <= stock){
                            modelod.setValueAt(DecimalNumber.ReduceDecimal(cantidad*precio,3), tdetalle.getSelectedRow(), 4);
                        }else{ messageDialog.response("La cantidad ingresada es mayor que el stock del producto", 4);
                            modelod.setValueAt(stock, tdetalle.getSelectedRow(), 3);
                            modelod.setValueAt(DecimalNumber.ReduceDecimal(stock*precio,2), tdetalle.getSelectedRow(), 4);
                        }
                    }
                    double monto=0.00, descuento=0.00;
                    for (int i = 0; i < modelod.getRowCount(); i++) {
                        monto = monto + Double.parseDouble(modelod.getValueAt(i, 4).toString());
                        descuento = descuento + Double.parseDouble(modelod.getValueAt(i, 5).toString());
                    }
                    lbmonto.setText(String.valueOf(DecimalNumber.ReduceDecimal(monto-descuento, 2)));
                }
            }
        }catch(NullPointerException | NumberFormatException | java.lang.ArrayIndexOutOfBoundsException ex){}
    }//GEN-LAST:event_tdetalleKeyReleased

    private void tdetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tdetalleKeyTyped
        if(tdetalle.getSelectedColumn()==3 || tdetalle.getSelectedColumn()==4){
            if(evt.getKeyChar()>='9' || evt.getKeyChar()<'9'){
                evt.consume();
            }
            int cantidad = Integer.parseInt(modelod.getValueAt(tdetalle.getSelectedRow(), 3).toString());
            double precio = 0.40;
            modelod.setValueAt(cantidad*precio, tdetalle.getSelectedRow(), 4);
            System.out.println(modelod.getValueAt(tdetalle.getSelectedRow(), 2));
        }
    }//GEN-LAST:event_tdetalleKeyTyped

    private void txefectivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txefectivoMouseClicked
        txefectivo.selectAll();
    }//GEN-LAST:event_txefectivoMouseClicked

    private void txefectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txefectivoKeyReleased
        if(txefectivo.getText().length()==0){
            txefectivo.setText("0");
            lbvuelto.setText("0.00");
            txefectivo.selectAll();
        }else
            lbvuelto.setText(String.valueOf(DecimalNumber.ReduceDecimal(Double.parseDouble(txefectivo.getText())-Double.parseDouble(lbmonto.getText()),2)));
    }//GEN-LAST:event_txefectivoKeyReleased

    private void bguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bguardarActionPerformed
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        try{
            if(modelod.getRowCount()>0 && !lbmonto.getText().equals("0.00")){
                Date d = new Date();
                String fecha = (d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
                CVenta v = new CVenta();
                v.setFechaVenta(fecha);
                v.setMontoTotal(Double.parseDouble(lbmonto.getText()));
                v.setIdUsuario(CUsuario.getIdUsuario());
                v.setIdTurno(turnoController.consultarTurno(Control.lbturno.getText()).getIdTurno());
                int idVenta = ventaController.insertarVenta(v);
                
                if(idVenta > 0){
                    for (int i = 0; i < modelod.getRowCount(); i++) {
                        String filtro[] = modelod.getValueAt(i, 6).toString().split(",");
                        CProducto producto = productoController.consultarProducto(filtro[0], filtro[1]);
                        v.setIdProductoFechav(producto.getIdProductoFechav());
                        v.setCantidadProducto(Integer.parseInt(modelod.getValueAt(i, 3).toString()));
                        v.setMonto(Double.parseDouble(modelod.getValueAt(i, 4).toString()));
                        v.setDescuento(Double.parseDouble(modelod.getValueAt(i, 5).toString()));
                        v.setPrecioCompraUnitario(producto.getPrecioCompraUnitario());
                        v.setIdVenta(idVenta);
                        ventaController.insertarVentaDetalle(v);
                        if(Main.control.isVisible()){
                            for (int j = 0; j < Control.modelo.getRowCount(); j++) {
                                if(Control.modelo.getValueAt(j, 0).toString().equals(filtro[0]) && Control.modelo.getValueAt(j, 5).toString().equals(filtro[1])){
                                    int stock = Integer.parseInt(Control.modelo.getValueAt(j, 7).toString());
                                    int cant = Integer.parseInt(modelod.getValueAt(i, 3).toString());
                                    Control.modelo.setValueAt(""+(stock-cant), j, 7);
                                    Control.tabla.setDefaultRenderer(Object.class, new TablaProductRender());
                                    break;
                                }
                            }
                            Control.lbmonto.setText(DecimalNumber.ReduceDecimal(ventaController.ventaDia((d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()),2)+" S/.");
                        }
                    }
                    nuevo();
                }
                while(modelov.getRowCount()>0){modelov.removeRow(0);}
                ventaController.mostrarProductoVentaDiario(modelov, "");
            }else messageDialog.response("No hay ningún producto agregado para la venta", 4);
        }catch(NumberFormatException | NullPointerException ex){messageDialog.response("Venta no registrada, <br> ingrese los datos correctos", 4);}
    }//GEN-LAST:event_bguardarActionPerformed

    private void beliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarActionPerformed
        try{
            if(tdetalle.getSelectedRowCount()==1){
                int si = confirmDialog.response("¿Está seguro que desea retirar el producto seleccionado?",2);
                if(si==1){
                    modelod.removeRow(tdetalle.getSelectedRow());
                    double monto=0.00;
                    for (int i = 0; i < modelod.getRowCount(); i++) {
                        monto = monto + Double.parseDouble(modelod.getValueAt(i, 4).toString());
                    }
                    lbmonto.setText(String.valueOf(DecimalNumber.ReduceDecimal(monto, 2)));
                    for (int i = 0; i < modelod.getRowCount(); i++) {modelod.setValueAt(i+1, i, 0);}
                }
            }else messageDialog.response("Seleccione el producto que desea retirar", 3);
        }catch(NullPointerException ex){
            for (int i = 0; i < modelod.getRowCount(); i++) {modelod.setValueAt(i+1, i, 0);}
        }
    }//GEN-LAST:event_beliminarActionPerformed

    private void bnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnuevoActionPerformed
        while(modelod.getRowCount()>0){modelod.removeRow(0);}
        nuevo();
    }//GEN-LAST:event_bnuevoActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        try{
            if(tdetalle.getSelectedRowCount()==1){
                int si = confirmDialog.response("¿Está seguro que desea retirar el producto seleccionado?",2);
                if(si==1){
                    modelod.removeRow(tdetalle.getSelectedRow());
                    double monto=0.00;
                    for (int i = 0; i < modelod.getRowCount(); i++) {
                        monto = monto + Double.parseDouble(modelod.getValueAt(i, 4).toString());
                    }
                    lbmonto.setText(String.valueOf(DecimalNumber.ReduceDecimal(monto, 2)));
                    for (int i = 0; i < modelod.getRowCount(); i++) {modelod.setValueAt(i+1, i, 0);}
                }
            } else messageDialog.response("Seleccione el producto que desea retirar", 3);
        }catch(NullPointerException ex){
            for (int i = 0; i < modelod.getRowCount(); i++) {modelod.setValueAt(i+1, i, 0);}
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void exportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarActionPerformed
        bexportar.setEnabled(false);
        if(tproducto.getSelectedRowCount() == 1){
            bexportarActionPerformed(evt);
        } else messageDialog.response("Seleccione un producto", 4);
    }//GEN-LAST:event_exportarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        Main.minuevaVenta.setEnabled(true);
        if(!Main.minuevoControl.isEnabled()) Control.pnuevaVenta.setVisible(true);
        Main.minuevaVenta.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_formInternalFrameClosing

    private void txbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbuscarKeyReleased
        while(modelop.getRowCount()!=0){modelop.removeRow(0);}
        if(cbcategoria.getSelectedIndex()==0){
            productoController.mostrarProducto(modelop, txbuscar.getText());
        }else{
            productoController.mostrarProducto(modelop, txbuscar.getText(), cbcategoria.getSelectedItem().toString());
        }
        bexportar.setEnabled(false);
        bexportar.setForeground(new java.awt.Color(204,204,204));
        bexportar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
    }//GEN-LAST:event_txbuscarKeyReleased

    private void txbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txbuscarMouseClicked
        txbuscar.selectAll();
    }//GEN-LAST:event_txbuscarMouseClicked

    private void cbcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcategoriaActionPerformed
        while(modelop.getRowCount()!=0){modelop.removeRow(0);}
        txbuscar.setText(null);
        if(cbcategoria.getSelectedIndex()==0){
            productoController.mostrarProducto(modelop, txbuscar.getText());
        }else{
            productoController.mostrarProducto(modelop, txbuscar.getText(), cbcategoria.getSelectedItem().toString());
        }
        bexportar.setEnabled(false);
        bexportar.setForeground(new java.awt.Color(204,204,204));
        bexportar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204,204,204), 2, true));
        txbuscar.requestFocus();
    }//GEN-LAST:event_cbcategoriaActionPerformed

    private void bexportarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bexportarMouseEntered
        if(bexportar.isEnabled()) bexportar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bexportarMouseEntered

    private void bexportarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bexportarMouseExited
        bexportar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bexportarMouseExited

    private void bexportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexportarActionPerformed
        try{
            int cantidad = Integer.parseInt(txCantidadProducto.getText());
            int stock = Integer.parseInt(modelop.getValueAt(tproducto.getSelectedRow(), 6).toString());
//            int stock = productoController.obtenerStockProducto(modelop.getValueAt(tproducto.getSelectedRow(), 1).toString());
            if(cantidad<=stock){
                if(modelod.getRowCount()==0){
                    modelod.addRow(new String[]{"",modelop.getValueAt(tproducto.getSelectedRow(), 1).toString(),modelop.getValueAt(tproducto.getSelectedRow(), 2).toString(),txCantidadProducto.getText(),DecimalNumber.ReduceDecimal((cantidad*Double.parseDouble(modelop.getValueAt(tproducto.getSelectedRow(), 5).toString())),2),"0.00",modelop.getValueAt(tproducto.getSelectedRow(), 7).toString()+","+modelop.getValueAt(tproducto.getSelectedRow(), 4).toString()});
                }else{
                    int i;
                    for (i = 0; i < modelod.getRowCount(); i++) {
                        if(modelod.getValueAt(i, 2).equals(modelop.getValueAt(tproducto.getSelectedRow(), 2)) && modelod.getValueAt(i, 6).toString().split(",")[1].equals(modelop.getValueAt(tproducto.getSelectedRow(), 4).toString())){
                            cantidad = cantidad + Integer.parseInt(modelod.getValueAt(i, 3).toString());
                            if(cantidad<=stock){
                                modelod.setValueAt(cantidad, i, 3);
                                modelod.setValueAt(DecimalNumber.ReduceDecimal((Integer.parseInt(modelod.getValueAt(i,3).toString())*Double.parseDouble(modelop.getValueAt(tproducto.getSelectedRow(), 5).toString())),2), i, 4);
                            }else messageDialog.response("La cantidad ingresada es mayor que el stock del producto", 4);
                            break;
                        }
                    }
                    if(modelod.getRowCount()==i){
                        modelod.addRow(new String[]{"",modelop.getValueAt(tproducto.getSelectedRow(), 1).toString(),modelop.getValueAt(tproducto.getSelectedRow(), 2).toString(),txCantidadProducto.getText(),DecimalNumber.ReduceDecimal((cantidad*Double.parseDouble(modelop.getValueAt(tproducto.getSelectedRow(), 5).toString())),2),"0.00",modelop.getValueAt(tproducto.getSelectedRow(), 7).toString()+","+modelop.getValueAt(tproducto.getSelectedRow(), 4).toString()});
                    }
                }
                for (int i = 0; i < modelod.getRowCount(); i++) {
                    modelod.setValueAt(i+1, i, 0);
                }
                double monto=0.00,descuento=0.00;
                for (int i = 0; i < modelod.getRowCount(); i++) {
                    monto = monto + Double.parseDouble(modelod.getValueAt(i, 4).toString());
                    descuento = descuento + Double.parseDouble(modelod.getValueAt(i, 5).toString());
                }
                lbmonto.setText(String.valueOf(DecimalNumber.ReduceDecimal(monto-descuento, 2)));
                if(cantidad<=stock){
                    PRODUCTO.hide();
                }
            }else messageDialog.response("La cantidad ingresada es mayor que el stock del producto", 4);
        }catch(NullPointerException ex){messageDialog.response(ex.getMessage(), 4);}
    }//GEN-LAST:event_bexportarActionPerformed

    private void tproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tproductoMouseClicked
        if(tproducto.getSelectedRowCount()==1){
            txdescripcion.setText(productoController.obtenerIndicacionProducto(modelop.getValueAt(tproducto.getSelectedRow(), 1).toString()));
            bexportar.setEnabled(true);
            bexportar.setForeground(new java.awt.Color(255,255,255));
            bexportar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255,255,255), 2, true));
            txCantidadProducto.setText("1");
            txCantidadProducto.requestFocus();
            txCantidadProducto.selectAll();
        }
    }//GEN-LAST:event_tproductoMouseClicked

    private void txCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCantidadProductoKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0'){
            evt.consume();
        }
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            bexportar.doClick();
        }
    }//GEN-LAST:event_txCantidadProductoKeyTyped

    private void txefectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txefectivoKeyTyped
        if(evt.getKeyChar()>'9' || evt.getKeyChar()<'0'){
            evt.consume();
        }
    }//GEN-LAST:event_txefectivoKeyTyped

    private void bmostrarVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmostrarVentaMouseEntered
        bmostrarVenta.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bmostrarVentaMouseEntered

    private void bmostrarVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmostrarVentaMouseExited
        bmostrarVenta.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bmostrarVentaMouseExited

    private void bmostrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmostrarVentaActionPerformed
        if(bmostrarVenta.getText().equals("Mostrar Detalle")){
            this.setSize(this.getWidth(), 700);
            bmostrarVenta.setText("Ocultar Detalle");
            this.setResizable(true);
            while(modelov.getRowCount()>0){modelov.removeRow(0);}
            ventaController.mostrarProductoVentaDiario(modelov, "");
        }else{
            this.setSize(this.getWidth(), 350);
            bmostrarVenta.setText("Mostrar Detalle");
            this.setResizable(false);
        }
        
    }//GEN-LAST:event_bmostrarVentaActionPerformed

    private void nuevo(){
        while(modelod.getRowCount()>0){modelod.removeRow(0);}
        lbmonto.setText("0.00");
        txefectivo.setText("0");
        lbvuelto.setText("0.00");
        bguardar.setEnabled(true);
        bbuscar.setEnabled(true);
        beliminar.setEnabled(true);
        bguardar.setForeground(new java.awt.Color(255,255,255));
        bbuscar.setForeground(new java.awt.Color(255,255,255));
        beliminar.setForeground(new java.awt.Color(255,255,255));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog PRODUCTO;
    private javax.swing.JButton bbuscar;
    private javax.swing.JButton beliminar;
    private javax.swing.JButton bexportar;
    private javax.swing.JButton bguardar;
    private javax.swing.JButton bmostrarVenta;
    private javax.swing.JButton bnuevo;
    private javax.swing.JComboBox<String> cbcategoria;
    private javax.swing.JMenuItem eliminar;
    private javax.swing.JMenuItem exportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbmonto;
    private javax.swing.JLabel lbvuelto;
    private javax.swing.JTable tdetalle;
    private javax.swing.JTable tproducto;
    private javax.swing.JTable tventa;
    private javax.swing.JTextField txCantidadProducto;
    private javax.swing.JTextField txbuscar;
    private javax.swing.JEditorPane txdescripcion;
    private javax.swing.JTextField txefectivo;
    // End of variables declaration//GEN-END:variables
    private void txproductoKeyTyped(java.awt.event.KeyEvent evt) {
        if(evt.getKeyChar()==KeyEvent.VK_ENTER){
            if(tdetalle.getSelectedColumn()==1){
//                modelod.setValueAt(DProducto.getId(txproducto.getText()), tdetalle.getSelectedRow(), 5);
                modelod.setValueAt("", tdetalle.getSelectedRow(), 2);
                modelod.setValueAt("", tdetalle.getSelectedRow(), 3);
                modelod.setValueAt("0.00", tdetalle.getSelectedRow(), 4);
            }
        }
    }
    
    private void txdescuentoKeyReleased(java.awt.event.KeyEvent evt) {
        
    }
    private void txdescuentoKeyTyped(java.awt.event.KeyEvent evt) {
        if(evt.getKeyChar()<'0' || evt.getKeyChar()>'9'){
            if(evt.getKeyChar()!='.')
                evt.consume();
        }
    }
    
    private void txunidadKeyReleased(java.awt.event.KeyEvent evt) {
        
    }
    private void txunidadKeyTyped(java.awt.event.KeyEvent evt) {
        if(evt.getKeyChar()<'0' || evt.getKeyChar()>'9'){
            evt.consume();
        }
    }
}