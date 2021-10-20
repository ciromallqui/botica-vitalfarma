package view;

import MFC.util.JLibrary.DecimalNumber;
import aplication_class.CTurno;
import controller.ParametroController;
import controller.ProductoController;
import controller.VentaController;
import cross_cuting.Archivos;
import cross_cuting.TablaProductRender;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *@author CIRO
 */
public class Control extends javax.swing.JInternalFrame {
    JTextField e;
    public static DefaultTableModel modelo;
    public ProductoController productoController;
    public VentaController ventaController;
    public static ParametroController parametroController;
    public Control() {
        initComponents();
        productoController = new ProductoController();
        ventaController = new VentaController();
        parametroController = new ParametroController();
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(false);
        txbuscar.requestFocus();
        Hora h = new Hora(parametroController.horaCambioTurno());
        this.fecha();
        this.table();
        lbitems.setText(modelo.getRowCount()+"");
        
    }
    private void fecha(){
        Date d = new Date();
        String fecha = d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900);
        DateTimeFormatter stf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate ld = LocalDate.parse(fecha,stf);
        stf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lbfecha.setText(stf.format(ld));
        lbmonto.setText(DecimalNumber.ReduceDecimal(ventaController.ventaDia((d.getYear()+1900)+"-"+(d.getMonth()+1)+"-"+d.getDate()),2)+" S/.");
    }
    private void table(){
        String titulo[] = {"N°","Código","Presentación","Producto","Fecha venc.","Precio Unit.","Stock","E.Stock"};
        modelo = new DefaultTableModel(null,titulo){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(0).setMaxWidth(60);
        tabla.getColumnModel().getColumn(1).setMaxWidth(70);
        tabla.getColumnModel().getColumn(4).setMinWidth(120);
        tabla.getColumnModel().getColumn(4).setMaxWidth(120);
        tabla.getColumnModel().getColumn(5).setMinWidth(120);
        tabla.getColumnModel().getColumn(5).setMaxWidth(120);
        tabla.getColumnModel().getColumn(6).setMaxWidth(80);
        tabla.getColumnModel().getColumn(7).setMaxWidth(80);
        tabla.setDefaultRenderer(Object.class, new TablaProductRender());
        JTableHeader head = tabla.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tabla.setTableHeader(head);
        
        productoController.mostrarControlProducto(modelo, "", "");
        cbpresentacion.addItem("Seleccionar");
        productoController.cargarPresentacion(cbpresentacion);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbitems = new javax.swing.JLabel();
        lbmonto = new javax.swing.JLabel();
        pnuevaVenta = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        preporte = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        prefrescar = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        cbpresentacion = new javax.swing.JComboBox<>();
        txbuscar = new javax.swing.JTextField();
        pproducto = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pdevolucion = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbturno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONTROL PRINCIPAL DE MEDICAMENTOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/punto.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 200));
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
            }
        });

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        jPanel2.setBackground(new java.awt.Color(227, 111, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total de Items    :");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total de Ventas :");

        lbitems.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbitems.setForeground(new java.awt.Color(255, 255, 255));
        lbitems.setText("000000");

        lbmonto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbmonto.setForeground(new java.awt.Color(255, 255, 255));
        lbmonto.setText("999923.00 S/. ");

        pnuevaVenta.setBackground(new java.awt.Color(227, 111, 30));
        pnuevaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnuevaVentaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnuevaVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnuevaVentaMouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/carrito_compra.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nueva Venta");

        javax.swing.GroupLayout pnuevaVentaLayout = new javax.swing.GroupLayout(pnuevaVenta);
        pnuevaVenta.setLayout(pnuevaVentaLayout);
        pnuevaVentaLayout.setHorizontalGroup(
            pnuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnuevaVentaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnuevaVentaLayout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnuevaVentaLayout.setVerticalGroup(
            pnuevaVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnuevaVentaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(20, 20, 20))
        );

        preporte.setBackground(new java.awt.Color(227, 111, 30));
        preporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                preporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                preporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                preporteMouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/estadistica-inferencial.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Reportes");

        javax.swing.GroupLayout preporteLayout = new javax.swing.GroupLayout(preporte);
        preporte.setLayout(preporteLayout);
        preporteLayout.setHorizontalGroup(
            preporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(preporteLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        preporteLayout.setVerticalGroup(
            preporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, preporteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        separador.setOrientation(javax.swing.SwingConstants.VERTICAL);

        prefrescar.setBackground(new java.awt.Color(227, 111, 30));
        prefrescar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prefrescarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                prefrescarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prefrescarMouseExited(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/actualizar_lista.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Refrescar");

        javax.swing.GroupLayout prefrescarLayout = new javax.swing.GroupLayout(prefrescar);
        prefrescar.setLayout(prefrescarLayout);
        prefrescarLayout.setHorizontalGroup(
            prefrescarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prefrescarLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        prefrescarLayout.setVerticalGroup(
            prefrescarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prefrescarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cbpresentacion.setBackground(new java.awt.Color(255, 153, 0));
        cbpresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbpresentacionActionPerformed(evt);
            }
        });

        txbuscar.setBackground(new java.awt.Color(250, 250, 250));
        txbuscar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        txbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txbuscarKeyReleased(evt);
            }
        });

        pproducto.setBackground(new java.awt.Color(227, 111, 30));
        pproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pproductoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pproductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pproductoMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/medicina.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Productos");

        javax.swing.GroupLayout pproductoLayout = new javax.swing.GroupLayout(pproducto);
        pproducto.setLayout(pproductoLayout);
        pproductoLayout.setHorizontalGroup(
            pproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pproductoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(32, 32, 32))
        );
        pproductoLayout.setVerticalGroup(
            pproductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pproductoLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Buscar por nombre del producto");

        pdevolucion.setBackground(new java.awt.Color(227, 111, 30));
        pdevolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pdevolucionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pdevolucionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pdevolucionMouseExited(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/intercambiar.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Devolución");

        javax.swing.GroupLayout pdevolucionLayout = new javax.swing.GroupLayout(pdevolucion);
        pdevolucion.setLayout(pdevolucionLayout);
        pdevolucionLayout.setHorizontalGroup(
            pdevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(pdevolucionLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pdevolucionLayout.setVerticalGroup(
            pdevolucionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pdevolucionLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar por Presentación");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbitems, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(preporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pdevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(prefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(txbuscar)
                        .addComponent(cbpresentacion, 0, 409, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separador)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(cbpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(txbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbitems))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbmonto))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(prefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pproducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(preporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pdevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Código", "Categoría", "Producto", "Precio Und.", "Stock", "Estado Stock"
            }
        ));
        tabla.setGridColor(new java.awt.Color(153, 153, 153));
        tabla.setRowHeight(30);
        tabla.setShowVerticalLines(false);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        jPanel4.setBackground(new java.awt.Color(244, 178, 35));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("  Turno:");

        lbturno.setBackground(new java.awt.Color(255, 255, 255));
        lbturno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbturno.setText("mañana");
        lbturno.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        lbturno.setOpaque(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbturno))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(lbturno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/calendario.png"))); // NOI18N

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbfecha.setForeground(new java.awt.Color(255, 255, 255));
        lbfecha.setText("00/00/0000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbfecha)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbfecha)
                        .addComponent(jLabel4)))
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

    private void pnuevaVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnuevaVentaMouseClicked
        VentaDetalle v = new VentaDetalle();
        Main.dtpanel.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_pnuevaVentaMouseClicked

    private void preporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preporteMouseClicked
        Reporte re = new Reporte();
        Main.dtpanel.add(re);
        re.setVisible(true);
        
    }//GEN-LAST:event_preporteMouseClicked

    private void prefrescarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prefrescarMouseClicked
        this.table();
        while(cbpresentacion.getItemCount()>1)
            cbpresentacion.removeItemAt(1);
        cbpresentacion.addItem("Seleccionar");
        productoController.cargarPresentacion(cbpresentacion);
        lbitems.setText(modelo.getRowCount()+"");
        txbuscar.setText(null);
        cbpresentacion.removeItemAt(1);
    }//GEN-LAST:event_prefrescarMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Main.minuevoControl.setEnabled(true);
        Main.minuevoControl.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_formInternalFrameClosed

    private void cbpresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbpresentacionActionPerformed
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
        if(cbpresentacion.getSelectedIndex()!=0)
            productoController.mostrarControlProducto(modelo, "", cbpresentacion.getSelectedItem().toString());
        else
            productoController.mostrarControlProducto(modelo, "", "");
        txbuscar.setText(null);
        txbuscar.requestFocus();
    }//GEN-LAST:event_cbpresentacionActionPerformed

    private void txbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txbuscarKeyReleased
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
        if(cbpresentacion.getSelectedIndex()>0){
            productoController.mostrarControlProducto(modelo, txbuscar.getText(), cbpresentacion.getSelectedItem().toString());
        }else{
            productoController.mostrarControlProducto(modelo, txbuscar.getText(), "");
        }
        
    }//GEN-LAST:event_txbuscarKeyReleased

    private void pproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pproductoMouseClicked
        Producto p = new Producto();
        Main.dtpanel.add(p);
        p.setVisible(true);
    }//GEN-LAST:event_pproductoMouseClicked

    private void pdevolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdevolucionMouseClicked
        Devolucion d = new Devolucion();
        Main.dtpanel.add(d);
        d.setVisible(true);
    }//GEN-LAST:event_pdevolucionMouseClicked

    private void pproductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pproductoMouseEntered
        pproducto.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_pproductoMouseEntered

    private void pproductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pproductoMouseExited
        pproducto.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_pproductoMouseExited

    private void pnuevaVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnuevaVentaMouseEntered
        pnuevaVenta.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_pnuevaVentaMouseEntered

    private void pnuevaVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnuevaVentaMouseExited
        pnuevaVenta.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_pnuevaVentaMouseExited

    private void preporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preporteMouseEntered
        preporte.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_preporteMouseEntered

    private void preporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preporteMouseExited
        preporte.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_preporteMouseExited

    private void pdevolucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdevolucionMouseEntered
        pdevolucion.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_pdevolucionMouseEntered

    private void pdevolucionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pdevolucionMouseExited
        pdevolucion.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_pdevolucionMouseExited

    private void prefrescarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prefrescarMouseEntered
        prefrescar.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_prefrescarMouseEntered

    private void prefrescarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prefrescarMouseExited
        prefrescar.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_prefrescarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbpresentacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbitems;
    public static javax.swing.JLabel lbmonto;
    public static javax.swing.JLabel lbturno;
    public static javax.swing.JPanel pdevolucion;
    public static javax.swing.JPanel pnuevaVenta;
    public static javax.swing.JPanel pproducto;
    private javax.swing.JPanel prefrescar;
    private javax.swing.JPanel preporte;
    private javax.swing.JSeparator separador;
    public static javax.swing.JTable tabla;
    private javax.swing.JTextField txbuscar;
    // End of variables declaration//GEN-END:variables
}
class Hora implements Runnable{
    String hora,minutos,segundos,ampm;
    Thread h1;
    public String canbioTurno = "0";
    javax.swing.JLabel lbhora = new javax.swing.JLabel();
    public Hora(String canbioTurno){
        this.canbioTurno = canbioTurno;
        h1 = new Thread(this);
        h1.start();
    }
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while(ct == h1) {
            calcula();
            //Venta.lbfecha.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
            comparaHora(hora + ":" + minutos);
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {}
        }
    }
    public void calcula () {        
    Calendar calendario = new GregorianCalendar();
    Date fechaHoraActual = new Date();
    calendario.setTime(fechaHoraActual);
    ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
    
    if(ampm.equals("PM")){
     int h = calendario.get(Calendar.HOUR_OF_DAY);
     hora = h>9?""+h:"0"+h;
    }else{
     hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY);            
    }
    minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
    segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND); 
    }
    private void comparaHora(String time){ 
        SimpleDateFormat formatter = new SimpleDateFormat("kk:mm");  
        try{
            boolean turno = false;
            Date horaActual = formatter.parse(time);
            List<CTurno> turnoLista = Control.parametroController.obtenerTurno();
            for (int i = 0; i < turnoLista.size(); i++) {
                Date horaInicial = formatter.parse(turnoLista.get(i).getHoraInicial());
                Date horaFinal = formatter.parse(turnoLista.get(i).getHoraFinal());
                if(horaInicial.getTime() <= horaActual.getTime() && horaActual.getTime() <= horaFinal.getTime()){
                    Control.lbturno.setText(turnoLista.get(i).getNombre());
                    turno = true;
                    break;
                }
            }
            if (!turno) Control.lbturno.setText("Fuera de turno");
        }  
        catch(Exception e){  
            System.out.println(e);  
        }  
          
    }
}