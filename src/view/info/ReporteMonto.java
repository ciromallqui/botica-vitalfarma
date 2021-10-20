package view.info;

import MFC.util.JLibrary.DecimalNumber;
import aplication_class.CReporteMonto;
import controller.ReporteController;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import view.Reporte;

public class ReporteMonto extends javax.swing.JDialog {
    public ReporteMonto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Image/precio-bajo.png")).getImage());
        DefaultListModel modeloLista = new DefaultListModel();
        lmonto.setModel(modeloLista);
        double montoTotal = 0.00;
        double montoGanado = 0.00;
        ReporteController reporteController = new ReporteController();
        List<CReporteMonto> lista = reporteController.listaMontoDiario(Reporte.filtroReporte(), Reporte.tipoReporte);
        for (CReporteMonto item : lista) {
            modeloLista.addElement(item.getTurno() + ": " +item.getMontoVenta()+" S/.");
            montoTotal += Double.parseDouble(item.getMontoVenta());
            montoGanado += Double.parseDouble(item.getMontoVenta()) - Double.parseDouble(item.getMontoCompra());
        }
        modeloLista.addElement("---------------------------");
        modeloLista.addElement("Total: "+ DecimalNumber.ReduceDecimal(montoTotal, 2) +" S/.");
        modeloLista.addElement(" ");
        modeloLista.addElement("Ganancia: "+ DecimalNumber.ReduceDecimal(montoGanado, 2) +" S/.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lmonto = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MONTO");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(227, 111, 30));

        jScrollPane1.setBackground(new java.awt.Color(244, 178, 35));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(244, 178, 35), 5, true));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        lmonto.setBackground(new java.awt.Color(244, 178, 35));
        lmonto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lmonto.setForeground(new java.awt.Color(255, 255, 255));
        lmonto.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lmonto.setSelectionBackground(new java.awt.Color(227, 111, 30));
        lmonto.setVisibleRowCount(7);
        jScrollPane1.setViewportView(lmonto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(ReporteMonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteMonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteMonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteMonto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReporteMonto dialog = new ReporteMonto(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lmonto;
    // End of variables declaration//GEN-END:variables
}
