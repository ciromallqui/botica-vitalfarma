package view;

import aplication_class.CReporteSolicitud;
import aplication_class.CUsuario;
import controller.ProductoController;
import controller.ReporteController;
import controller.TurnoController;
import cross_cuting.TableHeadCustom;
import cross_cuting.TableRowColor;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import view.info.MessageToast;
import view.info.ReporteMonto;

public class Reporte extends javax.swing.JInternalFrame {
    DefaultTableModel modelo;
    ProductoController productoController;
    ReporteController reporteController;
    TurnoController turnoController;
    CReporteSolicitud filtros;
    public MessageToast messageToast;
    public static String tipoReporte;
    public boolean sowBMonto;
    public Reporte() {
        initComponents();
        productoController = new ProductoController();
        reporteController = new ReporteController();
        turnoController = new TurnoController();
        filtros = new CReporteSolicitud();
        tipoReporte = "D";
        bmonto3.setOpaque(true);
        
        if(!CUsuario.getTipoUsuario().equals("ADMINISTRADOR")){
            tp.remove(1);
            tp.remove(1);
        }
        
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
//        reporteController.listarReporteDiario(modelo, filtros);
        turnoController.cargarTurno(cbturno1);
        turnoController.cargarTurno(cbturno2);
        turnoController.cargarTurno(cbturno3);
        productoController.cargarPresentacion(cbpresentacion1);
        productoController.cargarPresentacion(cbpresentacion2);
        productoController.cargarPresentacion(cbpresentacion3);
//        if(modelo.getRowCount() == 0) bmonto1.setVisible(false);
//        columnSize1();
        reporteDia();
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
    }
    
    private void reporteDia(){
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        sowBMonto = false;
        paviso.setVisible(false);
        List data = reporteController.listarReporteDiario(filtros);
        if(data.size() > 0){
            try {
                JasperReport reporte= (JasperReport) JRLoader.loadObject("ReporteDia.jasper");
                Map parametro = new HashMap();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                parametro.put("plogo",this.getClass().getResourceAsStream("/Image/logo_simple.jpg"));
                parametro.put("ptitulo", "REPORTE DE VENTAS DEL DÍA "+ sdf.format(dfecha.getDate()));
                JasperPrint jprint= JasperFillManager.fillReport(reporte, parametro,new JRBeanCollectionDataSource(data));
                //JasperViewer jRViewer =new JasperViewer(jprint,false); //Para mostrar el reporte en una ventana externa
                JRViewer jRViewer = new JRViewer(jprint);
                board.removeAll();
                board.setLayout(new BorderLayout());        
                board.add(jRViewer, BorderLayout.CENTER);
                jRViewer.setVisible(true);
                board.repaint();
                board.revalidate();
                sowBMonto = true;
            } catch (JRException ex) {
                messageToast.response("No se encontró el archivo para generar el reporte", 250, 70, "danger");
            } 
        }else{
            board.removeAll();
            board.setLayout(new BorderLayout());   
            board.add(paviso, BorderLayout.CENTER);
            bmonto1.setVisible(false);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            lbreporteTitulo.setText("<html><body style='text-decoration: underline;'>REPORTE DE VENTAS DEL DÍA "+ sdf.format(dfecha.getDate()) +"</body></html>");
            paviso.setVisible(true);
        }
    }
    
    private void reporteGeneral(){
        messageToast = new MessageToast(new javax.swing.JFrame(), true);
        sowBMonto = false;
        paviso.setVisible(false);
        List data = reporteController.listarReporteGeneral(filtros);
        if(data.size() > 0){
            try {
                JasperReport reporte= (JasperReport) JRLoader.loadObject("ReporteGeneral.jasper");
                Map parametro = new HashMap();
                parametro.put("plogo",this.getClass().getResourceAsStream("/Image/logo_simple.jpg"));
                if(tipoReporte.equals("M")) parametro.put("ptitulo", "REPORTE DE VENTAS DEL MES DE "+ mesText(mes.getMonth()+1));
                else parametro.put("ptitulo", "REPORTE GENERAL DE VENTAS");
                JasperPrint jprint= JasperFillManager.fillReport(reporte, parametro,new JRBeanCollectionDataSource(data));
                JRViewer jRViewer = new JRViewer(jprint);
                board.removeAll();
                board.setLayout(new BorderLayout());        
                board.add(jRViewer, BorderLayout.CENTER);
                jRViewer.setVisible(true);
                board.repaint();
                board.revalidate();
                sowBMonto = true;
            } catch (JRException ex) {
                messageToast.response("No se encontró el archivo para generar el reporte", 250, 70, "danger");
            }
        }else{
            board.removeAll();
            board.setLayout(new BorderLayout());   
            board.add(paviso, BorderLayout.CENTER);
            if(tipoReporte.equals("M")) lbreporteTitulo.setText("<html><body style='text-decoration: underline;'>REPORTE DE VENTAS DEL MES DE "+ mesText(mes.getMonth()+1) +"</body></html>");
            else lbreporteTitulo.setText("<html><body style='text-decoration: underline;'>REPORTE GENERAL DE VENTAS</body></html>");
            paviso.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tp = new javax.swing.JTabbedPane();
        rpdiario = new javax.swing.JPanel();
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
        jLabel16 = new javax.swing.JLabel();
        rpmensual = new javax.swing.JPanel();
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
        jLabel15 = new javax.swing.JLabel();
        rpgeneral = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        board = new javax.swing.JPanel();
        paviso = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbreporteTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

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

        rpdiario.setBackground(new java.awt.Color(227, 111, 30));
        rpdiario.setPreferredSize(new java.awt.Dimension(832, 100));

        dfecha.setBackground(new java.awt.Color(255, 153, 0));

        cbpresentacion1.setBackground(new java.awt.Color(255, 153, 0));
        cbpresentacion1.setMaximumRowCount(20);
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

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("En caso no se actualice el reporte, presione nuevamente en el TAB [Reporte diario]");

        javax.swing.GroupLayout rpdiarioLayout = new javax.swing.GroupLayout(rpdiario);
        rpdiario.setLayout(rpdiarioLayout);
        rpdiarioLayout.setHorizontalGroup(
            rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rpdiarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rpdiarioLayout.createSequentialGroup()
                        .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbturno1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbpresentacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bactualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bmonto1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        rpdiarioLayout.setVerticalGroup(
            rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rpdiarioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rpdiarioLayout.createSequentialGroup()
                        .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)))
                        .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txproducto1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(dfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbturno1)
                            .addComponent(cbpresentacion1)))
                    .addGroup(rpdiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bmonto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bactualizar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel16))
        );

        tp.addTab("Reporte diario", rpdiario);

        rpmensual.setBackground(new java.awt.Color(227, 111, 30));

        mes.setBackground(new java.awt.Color(255, 153, 0));

        cbpresentacion2.setBackground(new java.awt.Color(255, 153, 0));
        cbpresentacion2.setMaximumRowCount(20);
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

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("En caso no se actualice el reporte, presione nuevamente en el TAB [Reporte mensual]");

        javax.swing.GroupLayout rpmensualLayout = new javax.swing.GroupLayout(rpmensual);
        rpmensual.setLayout(rpmensualLayout);
        rpmensualLayout.setHorizontalGroup(
            rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rpmensualLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rpmensualLayout.createSequentialGroup()
                        .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbturno2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(cbpresentacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bactualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bmonto2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        rpmensualLayout.setVerticalGroup(
            rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rpmensualLayout.createSequentialGroup()
                .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rpmensualLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel14))
                            .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel11)))
                        .addGap(0, 0, 0)
                        .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txproducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbpresentacion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(mes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(cbturno2))))
                    .addGroup(rpmensualLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rpmensualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bactualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bmonto2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel15))
        );

        tp.addTab("Reporte mensual", rpmensual);

        rpgeneral.setBackground(new java.awt.Color(227, 111, 30));

        dfechai.setBackground(new java.awt.Color(255, 153, 0));

        dfechaf.setBackground(new java.awt.Color(255, 153, 0));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("  Fecha inicial");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("  Fecha final");

        cbpresentacion3.setBackground(new java.awt.Color(255, 153, 0));
        cbpresentacion3.setMaximumRowCount(20);
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

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("En caso no se actualice el reporte, presione nuevamente en el TAB [Reporte general]");

        javax.swing.GroupLayout rpgeneralLayout = new javax.swing.GroupLayout(rpgeneral);
        rpgeneral.setLayout(rpgeneralLayout);
        rpgeneralLayout.setHorizontalGroup(
            rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rpgeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rpgeneralLayout.createSequentialGroup()
                        .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dfechai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dfechaf, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbturno3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cbpresentacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txproducto3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bactualizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bmonto3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        rpgeneralLayout.setVerticalGroup(
            rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rpgeneralLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rpgeneralLayout.createSequentialGroup()
                        .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(1, 1, 1)
                        .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dfechaf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(dfechai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbturno3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbpresentacion3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txproducto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(rpgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bmonto3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bactualizar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        tp.addTab("Reporte general", rpgeneral);

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

        paviso.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo_simple.png"))); // NOI18N

        lbreporteTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbreporteTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbreporteTitulo.setText("<html><body style='text-decoration: underline'>REPORTE DE VENTAS DEL DÍA</body></html>");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("El reporte no cuenta con datos para mostrar");

        javax.swing.GroupLayout pavisoLayout = new javax.swing.GroupLayout(paviso);
        paviso.setLayout(pavisoLayout);
        pavisoLayout.setHorizontalGroup(
            pavisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pavisoLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pavisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pavisoLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pavisoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbreporteTitulo)))
                .addContainerGap())
        );
        pavisoLayout.setVerticalGroup(
            pavisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pavisoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pavisoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pavisoLayout.createSequentialGroup()
                        .addComponent(lbreporteTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout boardLayout = new javax.swing.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tp)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tp, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(board, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if(tp.getSelectedIndex()==0){
            tipoReporte = "D";
            modelo = new DefaultTableModel(null, new String[]{"N°","Presentación","Producto","Cantidad","Monto","Hora","Encargado","Turno"});
            tabla.setModel(modelo);
            columnSize1();
            filtros = filtroReporte();
            reporteDia();
//            reporteController.listarReporteDiario(modelo, filtros);
        }
        if(tp.getSelectedIndex()==1){
            tipoReporte = "M";
            modelo = new DefaultTableModel(null, new String[]{"N°","Presentación","Producto","Cantidad","Monto","Encargado","Turno"});
            tabla.setModel(modelo);
            columnSize2();
            filtros = filtroReporte();
            reporteGeneral();
//            reporteController.listarReporteGeneral(modelo, filtros);
        }
        if(tp.getSelectedIndex()==2){
            tipoReporte = "G";
            modelo = new DefaultTableModel(null, new String[]{"N°","Presentación","Producto","Cantidad","Monto","Encargado","Turno"});
            tabla.setModel(modelo);
            columnSize2();
            filtros = filtroReporte();
            reporteGeneral();
//            reporteController.listarReporteGeneral(modelo, filtros);
        }
        if(sowBMonto){
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
//        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
//        reporteController.listarReporteGeneral(modelo, filtros);
        filtros = filtroReporte();
        reporteGeneral();
        if(sowBMonto)
            bmonto2.setVisible(true);
        else bmonto2.setVisible(false);
    }//GEN-LAST:event_bactualizar2ActionPerformed

    private void bactualizar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizar3ActionPerformed
//        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
//        reporteController.listarReporteGeneral(modelo, filtros);
        filtros = filtroReporte();
        reporteGeneral();
        if(sowBMonto)
            bmonto3.setVisible(true);
        else bmonto3.setVisible(false);
    }//GEN-LAST:event_bactualizar3ActionPerformed

    private void bactualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bactualizar1ActionPerformed
//        while(modelo.getRowCount()!=0){modelo.removeRow(0);}
//        reporteController.listarReporteDiario(modelo, filtros);
        filtros = filtroReporte();
        reporteDia();
        if(sowBMonto)
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
    private javax.swing.JPanel board;
    private static javax.swing.JComboBox<String> cbpresentacion1;
    private static javax.swing.JComboBox<String> cbpresentacion2;
    private static javax.swing.JComboBox<String> cbpresentacion3;
    private static javax.swing.JComboBox<String> cbturno1;
    private static javax.swing.JComboBox<String> cbturno2;
    private static javax.swing.JComboBox<String> cbturno3;
    private static com.toedter.calendar.JDateChooser dfecha;
    private static com.toedter.calendar.JDateChooser dfechaf;
    private static com.toedter.calendar.JDateChooser dfechai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbreporteTitulo;
    private static com.toedter.calendar.JMonthChooser mes;
    private javax.swing.JPanel paviso;
    private javax.swing.JPanel rpdiario;
    private javax.swing.JPanel rpgeneral;
    private javax.swing.JPanel rpmensual;
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
//            default:
            case "D":
                item.setFechaVenta(sdf.format(dfecha.getDate()));
                if(cbturno1.getSelectedIndex() > 0) item.setTurno(cbturno1.getSelectedItem().toString());
                if(cbpresentacion1.getSelectedIndex() > 0) item.setPresentacion(cbpresentacion1.getSelectedItem().toString());
                item.setProducto(txproducto1.getText());
                break;
//                return item;
            case "M":
                item.setMes(mes.getMonth()+1);
                if(cbturno2.getSelectedIndex() > 0) item.setTurno(cbturno2.getSelectedItem().toString());
                if(cbpresentacion2.getSelectedIndex() > 0)item.setPresentacion(cbpresentacion2.getSelectedItem().toString());
                item.setProducto(txproducto2.getText());
                break;
//                return item;
            case "G":
                item.setFechaVentaInicial(sdf.format(dfechai.getDate()));
                item.setFechaVentaFinal(sdf.format(dfechaf.getDate()));
                if(cbturno3.getSelectedIndex() > 0) item.setTurno(cbturno3.getSelectedItem().toString());
                if(cbpresentacion3.getSelectedIndex() > 0)item.setPresentacion(cbpresentacion3.getSelectedItem().toString());
                item.setProducto(txproducto3.getText());
                break;
//                return item;
        }
        return item;
    }
    
    private String mesText(int mes){
        switch(mes){
            case 1:
                return "ENERO";
            case 2:
                return "FEBRERO";
            case 3:
                return "MARZO";
            case 4:
                return "ABRIL";
            case 5:
                return "MAYO";
            case 6:
                return "JUNIO";
            case 7:
                return "JULIO";
            case 8:
                return "AGOSTO";
            case 9:
                return "SETIEMBRE";
            case 10:
                return "OCTUBRE";
            case 11:
                return "NOVIEMBRE";
            case 12:
                return "DICIEMBRE";
            default: return "MES DESCONOSIDO";
        }
    }
}
