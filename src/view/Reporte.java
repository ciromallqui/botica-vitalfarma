package view;

import aplication_class.CReporteSolicitud;
import controller.ParametroController;
import controller.ProductoController;
import controller.ReporteController;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import view.info.ReporteMonto;

/**
 *@author CIRO
 */
public class Reporte extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;
    ProductoController productoController;
    ReporteController reporteController;
    ParametroController parametroController;
    CReporteSolicitud filtros;
    public static String tipoReporte;
    public Reporte() {
        initComponents();
        productoController = new ProductoController();
        reporteController = new ReporteController();
        parametroController = new ParametroController();
        filtros = new CReporteSolicitud();
        tipoReporte = "D";
        bmonto3.setOpaque(true);
        
        modelo = new DefaultTableModel(null, new String[]{"N°","Presentación","Producto","Cantidad","Monto","Hora","Encargado","Turno"});
        tabla.setModel(modelo);
        
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dfecha.setDate(sdf.parse(date));
            dfechai.setDate(sdf.parse(date));
            dfechaf.setDate(sdf.parse(date));
        } catch (ParseException ex) {}
        
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
        filtros.setFechaVenta(sdff.format(dfecha.getDate()));
        reporteController.listarReporteDiario(modelo, filtros);
        parametroController.cargarTurno(cbturno1);
        parametroController.cargarTurno(cbturno2);
        parametroController.cargarTurno(cbturno3);
        productoController.cargarPresentacion(cbpresentacion1);
        productoController.cargarPresentacion(cbpresentacion2);
        productoController.cargarPresentacion(cbpresentacion3);
        if(modelo.getRowCount() == 0) bmonto1.setVisible(false);
        columnSize1();
    }
    
    private void columnSize1(){
        tabla.getColumnModel().getColumn(0).setMaxWidth(70);
        tabla.getColumnModel().getColumn(3).setMaxWidth(80);
        tabla.getColumnModel().getColumn(4).setMaxWidth(70);
        tabla.getColumnModel().getColumn(5).setMaxWidth(90);
        tabla.getColumnModel().getColumn(6).setMinWidth(300);
        tabla.getColumnModel().getColumn(6).setMaxWidth(300);
        tabla.getColumnModel().getColumn(7).setMinWidth(120);
        tabla.getColumnModel().getColumn(7).setMaxWidth(120);
        tabla.setDefaultRenderer(Object.class, new TableRowColor());
        JTableHeader head = tabla.getTableHeader();
        head.setDefaultRenderer(new TableHeadCustom());
        tabla.setTableHeader(head);
        tabla.setShowHorizontalLines(true);
        tabla.setShowVerticalLines(false);
    }
    
    private void columnSize2(){
        tabla.getColumnModel().getColumn(0).setMaxWidth(70);
        tabla.getColumnModel().getColumn(3).setMaxWidth(80);
        tabla.getColumnModel().getColumn(4).setMaxWidth(70);
        tabla.getColumnModel().getColumn(5).setMinWidth(300);
        tabla.getColumnModel().getColumn(5).setMaxWidth(300);
        tabla.getColumnModel().getColumn(6).setMinWidth(120);
        tabla.getColumnModel().getColumn(6).setMaxWidth(120);
//        tabla.setDefaultRenderer(Object.class, new TableRowColor());
//        tabla.setShowHorizontalLines(true);
//        tabla.setShowVerticalLines(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tp = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        dfecha = new com.toedter.calendar.JDateChooser();
        cbpresentacion1 = new javax.swing.JComboBox<>();
        bactualizar1 = new javax.swing.JButton();
        cbturno1 = new javax.swing.JComboBox<>();
        txproducto1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bmonto1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        mes = new com.toedter.calendar.JMonthChooser();
        cbpresentacion2 = new javax.swing.JComboBox<>();
        bactualizar2 = new javax.swing.JButton();
        cbturno2 = new javax.swing.JComboBox<>();
        txproducto2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bmonto2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        dfechai = new com.toedter.calendar.JDateChooser();
        dfechaf = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbpresentacion3 = new javax.swing.JComboBox<>();
        bactualizar3 = new javax.swing.JButton();
        cbturno3 = new javax.swing.JComboBox<>();
        txproducto3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bmonto3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REPORTE DE VENTAS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/estadistica.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        tp.setBackground(new java.awt.Color(227, 111, 30));
        tp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tpMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(227, 111, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(832, 100));

        dfecha.setBackground(new java.awt.Color(255, 153, 0));

        cbpresentacion1.setBackground(new java.awt.Color(255, 153, 0));
        cbpresentacion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar presentación" }));

        bactualizar1.setBackground(new java.awt.Color(227, 111, 30));
        bactualizar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bactualizar1.setForeground(new java.awt.Color(255, 255, 255));
        bactualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscar_boton.png"))); // NOI18N
        bactualizar1.setText("Buscar");
        bactualizar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bactualizar1.setContentAreaFilled(false);
        bactualizar1.setOpaque(true);
        bactualizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bactualizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bactualizar1MouseExited(evt);
            }
        });
        bactualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualizar1ActionPerformed(evt);
            }
        });

        cbturno1.setBackground(new java.awt.Color(255, 153, 0));
        cbturno1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar turrno" }));

        txproducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txproducto1KeyReleased(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("  Turno");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("  Fecha de venta");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("  Presentación");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("  Nombre  del producto");

        bmonto1.setBackground(new java.awt.Color(227, 111, 30));
        bmonto1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bmonto1.setForeground(new java.awt.Color(255, 255, 255));
        bmonto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/etiqueta-de-precio.png"))); // NOI18N
        bmonto1.setText(" Mostrar Monto");
        bmonto1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bmonto1.setContentAreaFilled(false);
        bmonto1.setOpaque(true);
        bmonto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bmonto1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bmonto1MouseExited(evt);
            }
        });
        bmonto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmonto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbturno1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbpresentacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bactualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bmonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txproducto1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(dfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbturno1)
                            .addComponent(cbpresentacion1)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bmonto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bactualizar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tp.addTab("Reporte diario", jPanel2);

        jPanel3.setBackground(new java.awt.Color(227, 111, 30));

        mes.setBackground(new java.awt.Color(255, 153, 0));

        cbpresentacion2.setBackground(new java.awt.Color(255, 153, 0));
        cbpresentacion2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar presentación" }));

        bactualizar2.setBackground(new java.awt.Color(227, 111, 30));
        bactualizar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bactualizar2.setForeground(new java.awt.Color(255, 255, 255));
        bactualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscar_boton.png"))); // NOI18N
        bactualizar2.setText("Buscar");
        bactualizar2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bactualizar2.setContentAreaFilled(false);
        bactualizar2.setOpaque(true);
        bactualizar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bactualizar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bactualizar2MouseExited(evt);
            }
        });
        bactualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualizar2ActionPerformed(evt);
            }
        });

        cbturno2.setBackground(new java.awt.Color(255, 153, 0));
        cbturno2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar turno" }));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  Nombre del producto");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("  Mes");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("  Turno");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("  Presentación");

        bmonto2.setBackground(new java.awt.Color(227, 111, 30));
        bmonto2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bmonto2.setForeground(new java.awt.Color(255, 255, 255));
        bmonto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/etiqueta-de-precio.png"))); // NOI18N
        bmonto2.setText(" Mostrar Monto");
        bmonto2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bmonto2.setContentAreaFilled(false);
        bmonto2.setOpaque(true);
        bmonto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bmonto2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bmonto2MouseExited(evt);
            }
        });
        bmonto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmonto2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbturno2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(cbpresentacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bactualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bmonto2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel11)))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbpresentacion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(mes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(cbturno2))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bactualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bmonto2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tp.addTab("Reportes mensuales", jPanel3);

        jPanel4.setBackground(new java.awt.Color(227, 111, 30));

        dfechai.setBackground(new java.awt.Color(255, 153, 0));

        dfechaf.setBackground(new java.awt.Color(255, 153, 0));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("  Fecha inicial");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("  Fecha final");

        cbpresentacion3.setBackground(new java.awt.Color(255, 153, 0));
        cbpresentacion3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar presentación" }));

        bactualizar3.setBackground(new java.awt.Color(227, 111, 30));
        bactualizar3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bactualizar3.setForeground(new java.awt.Color(255, 255, 255));
        bactualizar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/buscar_boton.png"))); // NOI18N
        bactualizar3.setText("Buscar");
        bactualizar3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bactualizar3.setContentAreaFilled(false);
        bactualizar3.setOpaque(true);
        bactualizar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bactualizar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bactualizar3MouseExited(evt);
            }
        });
        bactualizar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bactualizar3ActionPerformed(evt);
            }
        });

        cbturno3.setBackground(new java.awt.Color(255, 153, 0));
        cbturno3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar turno" }));

        txproducto3.setMaximumSize(new java.awt.Dimension(400, 2147483647));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("  Nombre del producto");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("  Turno");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("  Presentación");

        bmonto3.setBackground(new java.awt.Color(227, 111, 30));
        bmonto3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bmonto3.setForeground(new java.awt.Color(255, 255, 255));
        bmonto3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/etiqueta-de-precio.png"))); // NOI18N
        bmonto3.setText(" Mostrar Monto");
        bmonto3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        bmonto3.setContentAreaFilled(false);
        bmonto3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bmonto3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bmonto3MouseExited(evt);
            }
        });
        bmonto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmonto3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dfechai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dfechaf, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbturno3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cbpresentacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txproducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bactualizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bmonto3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dfechaf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(dfechai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbturno3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbpresentacion3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txproducto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bmonto3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bactualizar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tp.addTab("Otros reportes", jPanel4);

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
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
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

    private void tpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tpMouseClicked
//        filtros = new CReporteSolicitud();
        if(tp.getSelectedIndex()==0){
            tipoReporte = "D";
            modelo = new DefaultTableModel(null, new String[]{"N°","Presentación","Producto","Cantidad","Monto","Hora","Encargado","Turno"});
            tabla.setModel(modelo);
            columnSize1();

//            String date = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            try {
//                dfecha.setDate(sdf.parse(date));
//            } catch (ParseException ex) {}
            
//            SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
//            filtros.setFechaVenta(sdff.format(dfecha.getDate()));
//            if(cbturno1.getSelectedIndex() > 0 )filtros.setTurno(cbturno1.getSelectedItem().toString());
//            if(cbpresentacion1.getSelectedIndex() > 0) filtros.setPresentacion(cbpresentacion1.getSelectedItem().toString());
//            filtros.setProducto(txproducto1.getText());
            filtros = filtroReporte();
            reporteController.listarReporteDiario(modelo, filtros);
        }
        if(tp.getSelectedIndex()==1){
            tipoReporte = "M";
            modelo = new DefaultTableModel(null, new String[]{"N°","Presentación","Producto","Cantidad","Monto","Encargado","Turno"});
            tabla.setModel(modelo);
            columnSize2();
//            String fecha = new SimpleDateFormat("M").format(new java.util.Date());
//            mes.setMonth(Integer.parseInt(fecha)-1);
//            filtros.setMes(mes.getMonth()+1);
//            if(cbturno2.getSelectedIndex() > 0)filtros.setTurno(cbturno2.getSelectedItem().toString());
//            if(cbpresentacion2.getSelectedIndex() > 0) filtros.setPresentacion(cbpresentacion2.getSelectedItem().toString());
//            filtros.setProducto(txproducto2.getText());
            filtros = filtroReporte();
            reporteController.listarReporteGeneral(modelo, filtros);
        }
        if(tp.getSelectedIndex()==2){
            tipoReporte = "G";
            modelo = new DefaultTableModel(null, new String[]{"N°","Presentación","Producto","Cantidad","Monto","Encargado","Turno"});
            tabla.setModel(modelo);
            columnSize2();
            
//            String date = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            try {
//                dfechai.setDate(sdf.parse(date));
//                dfechaf.setDate(sdf.parse(date));
//            } catch (ParseException ex) {}
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            filtros.setFechaVentaInicial(sdf.format(dfechai.getDate()));
//            filtros.setFechaVentaFinal(sdf.format(dfechaf.getDate()));
//            if(cbturno3.getSelectedIndex() > 0) filtros.setTurno(cbturno3.getSelectedItem().toString());
//            if(cbpresentacion3.getSelectedIndex() > 0) filtros.setPresentacion(cbpresentacion3.getSelectedItem().toString());
//            filtros.setProducto(txproducto3.getText());
            filtros = filtroReporte();
            reporteController.listarReporteGeneral(modelo, filtros);
        }
        if(modelo.getRowCount() > 0){
            bmonto1.setVisible(true);
            bmonto2.setVisible(true);
            bmonto3.setVisible(true);
        }else{
            bmonto1.setVisible(false);
            bmonto2.setVisible(false);
            bmonto3.setVisible(false);
        }
    }//GEN-LAST:event_tpMouseClicked

    private void bactualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizar2ActionPerformed
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
//        filtros.setTurno(null);
//        filtros.setPresentacion(null);
//        filtros.setMes(mes.getMonth()+1);
//        if(cbturno2.getSelectedIndex() > 0) filtros.setTurno(cbturno2.getSelectedItem().toString());
//        if(cbpresentacion2.getSelectedIndex() > 0)filtros.setPresentacion(cbpresentacion2.getSelectedItem().toString());
//        filtros.setProducto(txproducto2.getText());
        filtros = filtroReporte();
        reporteController.listarReporteGeneral(modelo, filtros);
//        if(cbpresentacion2.getSelectedIndex()==0)
//            DReportes.CargarReporte2(modelo, mes.getMonth()+1, "");
//        else
//            DReportes.CargarReporte2(modelo, mes.getMonth()+1, cbpresentacion2.getSelectedItem().toString())
        if(modelo.getRowCount() > 0)
            bmonto2.setVisible(true);
        else bmonto2.setVisible(false);
    }//GEN-LAST:event_bactualizar2ActionPerformed

    private void bactualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizar3ActionPerformed
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
//        filtros.setTurno(null);
//        filtros.setPresentacion(null);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        filtros.setFechaVentaInicial(sdf.format(dfechai.getDate()));
//        filtros.setFechaVentaFinal(sdf.format(dfechaf.getDate()));
//        if(cbturno3.getSelectedIndex() > 0) filtros.setTurno(cbturno3.getSelectedItem().toString());
//        if(cbpresentacion3.getSelectedIndex() > 0)filtros.setPresentacion(cbpresentacion3.getSelectedItem().toString());
//        filtros.setProducto(txproducto3.getText());
        filtros = filtroReporte();
        reporteController.listarReporteGeneral(modelo, filtros);
        if(modelo.getRowCount() > 0)
            bmonto3.setVisible(true);
        else bmonto3.setVisible(false);
//        if(cbpresentacion3.getSelectedIndex()==0)
//            DReportes.CargarReporte3(modelo,sdf.format(date1),sdf.format(date2),"");
//        else
//            DReportes.CargarReporte3(modelo,sdf.format(date1),sdf.format(date2), cbpresentacion3.getSelectedItem().toString());
    }//GEN-LAST:event_bactualizar3ActionPerformed

    private void bactualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizar1ActionPerformed
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
//        filtros.setTurno(null);
//        filtros.setPresentacion(null);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        filtros.setFechaVenta(sdf.format(dfecha.getDate()));
//        if(cbturno1.getSelectedIndex() > 0) filtros.setTurno(cbturno1.getSelectedItem().toString());
//        if(cbpresentacion1.getSelectedIndex() > 0)filtros.setPresentacion(cbpresentacion1.getSelectedItem().toString());
//        filtros.setProducto(txproducto1.getText());
        filtros = filtroReporte();
        reporteController.listarReporteDiario(modelo, filtros);
        if(modelo.getRowCount() > 0)
            bmonto1.setVisible(true);
        else bmonto1.setVisible(false);
    }//GEN-LAST:event_bactualizar1ActionPerformed

    private void txproducto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txproducto1KeyReleased
        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
        filtros.setProducto(txproducto1.getText());
        reporteController.listarReporteDiario(modelo, filtros);
    }//GEN-LAST:event_txproducto1KeyReleased

    private void bactualizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizar1MouseEntered
        bactualizar1.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bactualizar1MouseEntered

    private void bactualizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizar1MouseExited
        bactualizar1.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bactualizar1MouseExited

    private void bactualizar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizar2MouseEntered
        bactualizar2.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bactualizar2MouseEntered

    private void bactualizar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizar2MouseExited
        bactualizar2.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bactualizar2MouseExited

    private void bactualizar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizar3MouseEntered
        bactualizar3.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bactualizar3MouseEntered

    private void bactualizar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bactualizar3MouseExited
        bactualizar3.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bactualizar3MouseExited

    private void bmonto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmonto1ActionPerformed
        ReporteMonto p = new ReporteMonto(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_bmonto1ActionPerformed

    private void bmonto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmonto2ActionPerformed
        ReporteMonto p = new ReporteMonto(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_bmonto2ActionPerformed

    private void bmonto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmonto3ActionPerformed
        ReporteMonto p = new ReporteMonto(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_bmonto3ActionPerformed

    private void bmonto1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmonto1MouseEntered
        bmonto1.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bmonto1MouseEntered

    private void bmonto1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmonto1MouseExited
        bmonto1.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bmonto1MouseExited

    private void bmonto2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmonto2MouseEntered
        bmonto2.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bmonto2MouseEntered

    private void bmonto2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmonto2MouseExited
        bmonto2.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bmonto2MouseExited

    private void bmonto3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmonto3MouseEntered
        bmonto3.setBackground(new java.awt.Color(255,153,0));
    }//GEN-LAST:event_bmonto3MouseEntered

    private void bmonto3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmonto3MouseExited
        bmonto3.setBackground(new java.awt.Color(227,111,30));
    }//GEN-LAST:event_bmonto3MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bactualizar1;
    private javax.swing.JButton bactualizar2;
    private javax.swing.JButton bactualizar3;
    private javax.swing.JButton bmonto1;
    private javax.swing.JButton bmonto2;
    private javax.swing.JButton bmonto3;
    private static javax.swing.JComboBox<String> cbpresentacion1;
    private static javax.swing.JComboBox<String> cbpresentacion2;
    private static javax.swing.JComboBox<String> cbpresentacion3;
    private static javax.swing.JComboBox<String> cbturno1;
    private static javax.swing.JComboBox<String> cbturno2;
    private static javax.swing.JComboBox<String> cbturno3;
    private static com.toedter.calendar.JDateChooser dfecha;
    private static com.toedter.calendar.JDateChooser dfechaf;
    private static com.toedter.calendar.JDateChooser dfechai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private static com.toedter.calendar.JMonthChooser mes;
    private javax.swing.JTable tabla;
    private javax.swing.JTabbedPane tp;
    private static javax.swing.JTextField txproducto1;
    private static javax.swing.JTextField txproducto2;
    private static javax.swing.JTextField txproducto3;
    // End of variables declaration//GEN-END:variables

    public static CReporteSolicitud filtroReporte(){
        CReporteSolicitud item = new CReporteSolicitud();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        switch(tipoReporte){
            default:
            case "D":
                item.setFechaVenta(sdf.format(dfecha.getDate()));
                if(cbturno1.getSelectedIndex() > 0) item.setTurno(cbturno1.getSelectedItem().toString());
                if(cbpresentacion1.getSelectedIndex() > 0)item.setPresentacion(cbpresentacion1.getSelectedItem().toString());
                item.setProducto(txproducto1.getText());
                return item;
            case "M":
                item.setMes(mes.getMonth()+1);
                if(cbturno2.getSelectedIndex() > 0) item.setTurno(cbturno2.getSelectedItem().toString());
                if(cbpresentacion2.getSelectedIndex() > 0)item.setPresentacion(cbpresentacion2.getSelectedItem().toString());
                item.setProducto(txproducto2.getText());
                return item;
            case "G":
                item.setFechaVentaInicial(sdf.format(dfechai.getDate()));
                item.setFechaVentaFinal(sdf.format(dfechaf.getDate()));
                if(cbturno3.getSelectedIndex() > 0) item.setTurno(cbturno3.getSelectedItem().toString());
                if(cbpresentacion3.getSelectedIndex() > 0)item.setPresentacion(cbpresentacion3.getSelectedItem().toString());
                item.setProducto(txproducto3.getText());
                return item;
        }
    }
}
