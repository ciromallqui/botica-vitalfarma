package view;

import aplication_class.CUsuario;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author CIRO
 */
public class Main extends javax.swing.JFrame {
    ImageIcon fondo;
    JLabel l;
    public static Control control;
    public Main() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fondo = new ImageIcon(getClass().getResource("/Image/fondo.png"));
        lbnombre.setText(CUsuario.getNombreCompleto());
        control = new Control();
        logoLabel();
    }
    private void logoLabel(){
        l = new JLabel();
        l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png")));
        dtpanel.add(l);
        l.setVisible(true);
        l.setLocation(0, -50);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pmenuBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbnombre = new javax.swing.JLabel();
        marchivo = new javax.swing.JLabel();
        mregistro = new javax.swing.JLabel();
        pmenuArchivo = new javax.swing.JPanel();
        minuevoControl = new javax.swing.JButton();
        miventa = new javax.swing.JButton();
        mireporte = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        micambioUsuario = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        misalir = new javax.swing.JButton();
        midevolucion = new javax.swing.JButton();
        dtpanel = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        pmenuRegistro = new javax.swing.JPanel();
        miproducto = new javax.swing.JButton();
        mipresentacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pmenuBar.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/usu.png"))); // NOI18N

        lbnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnombre.setForeground(new java.awt.Color(255, 255, 255));
        lbnombre.setText("jLabel1");

        marchivo.setBackground(new java.awt.Color(255, 102, 0));
        marchivo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        marchivo.setForeground(new java.awt.Color(255, 255, 255));
        marchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        marchivo.setText("Archivos");
        marchivo.setOpaque(true);
        marchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                marchivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                marchivoMouseExited(evt);
            }
        });

        mregistro.setBackground(new java.awt.Color(255, 102, 0));
        mregistro.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        mregistro.setForeground(new java.awt.Color(255, 255, 255));
        mregistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mregistro.setText("Registros");
        mregistro.setOpaque(true);
        mregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mregistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mregistroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pmenuBarLayout = new javax.swing.GroupLayout(pmenuBar);
        pmenuBar.setLayout(pmenuBarLayout);
        pmenuBarLayout.setHorizontalGroup(
            pmenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pmenuBarLayout.createSequentialGroup()
                .addComponent(marchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 755, Short.MAX_VALUE)
                .addComponent(lbnombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        pmenuBarLayout.setVerticalGroup(
            pmenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pmenuBarLayout.createSequentialGroup()
                .addGroup(pmenuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pmenuBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pmenuBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(7, 7, 7))
            .addComponent(marchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mregistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pmenuArchivo.setBackground(new java.awt.Color(255, 102, 0));

        minuevoControl.setBackground(new java.awt.Color(255, 102, 0));
        minuevoControl.setForeground(new java.awt.Color(255, 255, 255));
        minuevoControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nuevop.png"))); // NOI18N
        minuevoControl.setMnemonic('N');
        minuevoControl.setText("Nuevo control              Alt+N");
        minuevoControl.setContentAreaFilled(false);
        minuevoControl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        minuevoControl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        minuevoControl.setMargin(new java.awt.Insets(2, 2, 2, 2));
        minuevoControl.setOpaque(true);
        minuevoControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minuevoControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minuevoControlMouseExited(evt);
            }
        });
        minuevoControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minuevoControlActionPerformed(evt);
            }
        });

        miventa.setBackground(new java.awt.Color(255, 102, 0));
        miventa.setForeground(new java.awt.Color(255, 255, 255));
        miventa.setMnemonic('V');
        miventa.setText("        Nuevo venta                 Alt+V");
        miventa.setContentAreaFilled(false);
        miventa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miventa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        miventa.setMargin(new java.awt.Insets(2, 2, 2, 2));
        miventa.setOpaque(true);
        miventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miventaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miventaMouseExited(evt);
            }
        });
        miventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miventaActionPerformed(evt);
            }
        });

        mireporte.setBackground(new java.awt.Color(255, 102, 0));
        mireporte.setForeground(new java.awt.Color(255, 255, 255));
        mireporte.setText("        Reportes");
        mireporte.setContentAreaFilled(false);
        mireporte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mireporte.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        mireporte.setMargin(new java.awt.Insets(2, 2, 2, 2));
        mireporte.setMaximumSize(new java.awt.Dimension(211, 35));
        mireporte.setMinimumSize(new java.awt.Dimension(211, 35));
        mireporte.setOpaque(true);
        mireporte.setPreferredSize(new java.awt.Dimension(91, 35));
        mireporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mireporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mireporteMouseExited(evt);
            }
        });
        mireporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mireporteActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSeparator1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSeparator1MouseExited(evt);
            }
        });

        micambioUsuario.setBackground(new java.awt.Color(255, 102, 0));
        micambioUsuario.setForeground(new java.awt.Color(255, 255, 255));
        micambioUsuario.setText("       Cambio de usuario");
        micambioUsuario.setContentAreaFilled(false);
        micambioUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        micambioUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        micambioUsuario.setMargin(new java.awt.Insets(2, 2, 2, 2));
        micambioUsuario.setOpaque(true);
        micambioUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                micambioUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                micambioUsuarioMouseExited(evt);
            }
        });
        micambioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micambioUsuarioActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSeparator2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSeparator2MouseExited(evt);
            }
        });

        misalir.setBackground(new java.awt.Color(255, 102, 0));
        misalir.setForeground(new java.awt.Color(255, 255, 255));
        misalir.setMnemonic('X');
        misalir.setText("        Salir                            Alt+X");
        misalir.setContentAreaFilled(false);
        misalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        misalir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        misalir.setMargin(new java.awt.Insets(2, 2, 2, 2));
        misalir.setOpaque(true);
        misalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                misalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                misalirMouseExited(evt);
            }
        });
        misalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misalirActionPerformed(evt);
            }
        });

        midevolucion.setBackground(new java.awt.Color(255, 102, 0));
        midevolucion.setForeground(new java.awt.Color(255, 255, 255));
        midevolucion.setText("        Devoliciones");
        midevolucion.setContentAreaFilled(false);
        midevolucion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        midevolucion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        midevolucion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        midevolucion.setMaximumSize(new java.awt.Dimension(211, 35));
        midevolucion.setMinimumSize(new java.awt.Dimension(211, 35));
        midevolucion.setOpaque(true);
        midevolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                midevolucionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                midevolucionMouseExited(evt);
            }
        });
        midevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midevolucionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pmenuArchivoLayout = new javax.swing.GroupLayout(pmenuArchivo);
        pmenuArchivo.setLayout(pmenuArchivoLayout);
        pmenuArchivoLayout.setHorizontalGroup(
            pmenuArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pmenuArchivoLayout.createSequentialGroup()
                .addGroup(pmenuArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pmenuArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pmenuArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(misalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(miventa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(minuevoControl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(micambioUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(midevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mireporte, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pmenuArchivoLayout.setVerticalGroup(
            pmenuArchivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pmenuArchivoLayout.createSequentialGroup()
                .addComponent(minuevoControl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(miventa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(midevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mireporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(micambioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(misalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("jLabel2");

        dtpanel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dtpanelLayout = new javax.swing.GroupLayout(dtpanel);
        dtpanel.setLayout(dtpanelLayout);
        dtpanelLayout.setHorizontalGroup(
            dtpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dtpanelLayout.setVerticalGroup(
            dtpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dtpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        pmenuRegistro.setBackground(new java.awt.Color(255, 102, 0));

        miproducto.setBackground(new java.awt.Color(255, 102, 0));
        miproducto.setForeground(new java.awt.Color(255, 255, 255));
        miproducto.setText("        Producto");
        miproducto.setContentAreaFilled(false);
        miproducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miproducto.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        miproducto.setMargin(new java.awt.Insets(2, 2, 2, 2));
        miproducto.setOpaque(true);
        miproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miproductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miproductoMouseExited(evt);
            }
        });
        miproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miproductoActionPerformed(evt);
            }
        });

        mipresentacion.setBackground(new java.awt.Color(255, 102, 0));
        mipresentacion.setForeground(new java.awt.Color(255, 255, 255));
        mipresentacion.setText("        Presentación");
        mipresentacion.setContentAreaFilled(false);
        mipresentacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mipresentacion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        mipresentacion.setMargin(new java.awt.Insets(2, 2, 2, 2));
        mipresentacion.setOpaque(true);
        mipresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mipresentacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mipresentacionMouseExited(evt);
            }
        });
        mipresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mipresentacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pmenuRegistroLayout = new javax.swing.GroupLayout(pmenuRegistro);
        pmenuRegistro.setLayout(pmenuRegistroLayout);
        pmenuRegistroLayout.setHorizontalGroup(
            pmenuRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mipresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        );
        pmenuRegistroLayout.setVerticalGroup(
            pmenuRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pmenuRegistroLayout.createSequentialGroup()
                .addComponent(miproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mipresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dtpanel)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pmenuArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pmenuRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pmenuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pmenuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pmenuArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pmenuRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtpanel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono);
        pmenuArchivo.setSize(207, 225);
        this.repaint();
    }//GEN-LAST:event_formWindowOpened

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        jLabel2.setIcon(icono);
        this.repaint();
        pmenuBar.setSize(this.getWidth(), 40);
        l.setSize(this.getWidth(), this.getHeight());
        dtpanel.setSize(this.getWidth(), this.getHeight());
    }//GEN-LAST:event_formComponentResized

    private void marchivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marchivoMouseEntered
        pmenuArchivo.setSize(207, 225);
        jLabel2.add(pmenuArchivo);
        pmenuArchivo.setLocation(0, 0);
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_marchivoMouseEntered

    private void marchivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marchivoMouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_marchivoMouseExited

    private void minuevoControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minuevoControlMouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
        if(minuevoControl.isEnabled()) minuevoControl.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_minuevoControlMouseEntered

    private void minuevoControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minuevoControlMouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
        minuevoControl.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_minuevoControlMouseExited

    private void miventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miventaMouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
        if(miventa.isEnabled()) miventa.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_miventaMouseEntered

    private void miventaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miventaMouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
        miventa.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_miventaMouseExited

    private void mireporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mireporteMouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
        mireporte.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_mireporteMouseEntered

    private void mireporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mireporteMouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
        mireporte.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mireporteMouseExited

    private void micambioUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioUsuarioMouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
        micambioUsuario.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_micambioUsuarioMouseEntered

    private void micambioUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioUsuarioMouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
        micambioUsuario.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_micambioUsuarioMouseExited

    private void jSeparator1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator1MouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_jSeparator1MouseEntered

    private void jSeparator1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator1MouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_jSeparator1MouseExited

    private void jSeparator2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator2MouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_jSeparator2MouseEntered

    private void jSeparator2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator2MouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_jSeparator2MouseExited

    private void misalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_misalirMouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
        misalir.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_misalirMouseEntered

    private void misalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_misalirMouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
        misalir.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_misalirMouseExited

    private void mregistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mregistroMouseEntered
        pmenuRegistro.setSize(207, 80);
        jLabel2.add(pmenuRegistro);
        pmenuRegistro.setLocation(96, 0);
        mregistro.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_mregistroMouseEntered

    private void mregistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mregistroMouseExited
        pmenuRegistro.setSize(207, 0);
        mregistro.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mregistroMouseExited

    private void miproductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miproductoMouseEntered
        pmenuRegistro.setSize(207, 80);
        mregistro.setBackground(new java.awt.Color(255,153,51));
        if(miproducto.isEnabled()) miproducto.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_miproductoMouseEntered

    private void miproductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miproductoMouseExited
        pmenuRegistro.setSize(207, 0);
        mregistro.setBackground(new java.awt.Color(255,102,0));
        miproducto.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_miproductoMouseExited

    private void mipresentacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mipresentacionMouseEntered
        pmenuRegistro.setSize(207, 80);
        mregistro.setBackground(new java.awt.Color(255,153,51));
        mipresentacion.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_mipresentacionMouseEntered

    private void mipresentacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mipresentacionMouseExited
        pmenuRegistro.setSize(207, 0);
        mregistro.setBackground(new java.awt.Color(255,102,0));
        mipresentacion.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mipresentacionMouseExited

    private void miventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miventaActionPerformed
        VentaDetalle dv = new VentaDetalle();
        dtpanel.add(dv);
        dv.setVisible(true);
    }//GEN-LAST:event_miventaActionPerformed

    private void miproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miproductoActionPerformed
        Producto dv = new Producto();
        dtpanel.add(dv);
        dv.setVisible(true);
        miproducto.setForeground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_miproductoActionPerformed

    private void mipresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mipresentacionActionPerformed
        Presentacion p = new Presentacion(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_mipresentacionActionPerformed

    private void minuevoControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minuevoControlActionPerformed
        control = new Control();
        dtpanel.add(control);
        control.setVisible(true);
        minuevoControl.setEnabled(false);
        minuevoControl.setForeground(new java.awt.Color(204,204,204));
        if(!miventa.isEnabled()){
            Control.pnuevaVenta.setVisible(false);
        }
        if(!miproducto.isEnabled()){
            Control.pproducto.setVisible(false);
        }
    }//GEN-LAST:event_minuevoControlActionPerformed

    private void mireporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mireporteActionPerformed
        Reporte re = new Reporte();
        dtpanel.add(re);
        re.setVisible(true);
    }//GEN-LAST:event_mireporteActionPerformed

    private void midevolucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midevolucionMouseEntered
        pmenuArchivo.setSize(207, 225);
        marchivo.setBackground(new java.awt.Color(255,153,51));
        midevolucion.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_midevolucionMouseEntered

    private void midevolucionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midevolucionMouseExited
        pmenuArchivo.setSize(207, 0);
        marchivo.setBackground(new java.awt.Color(255,102,0));
        midevolucion.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_midevolucionMouseExited

    private void midevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midevolucionActionPerformed
        Devolucion dv = new Devolucion();
        dtpanel.add(dv);
        dv.setVisible(true);
    }//GEN-LAST:event_midevolucionActionPerformed

    private void micambioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micambioUsuarioActionPerformed
        this.dispose();
        Usuario u = new Usuario(new javax.swing.JFrame(), true);
        u.setVisible(true);
    }//GEN-LAST:event_micambioUsuarioActionPerformed

    private void misalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_misalirActionPerformed
    
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane dtpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbnombre;
    private javax.swing.JLabel marchivo;
    private javax.swing.JButton micambioUsuario;
    public static javax.swing.JButton midevolucion;
    public static javax.swing.JButton minuevoControl;
    private javax.swing.JButton mipresentacion;
    public static javax.swing.JButton miproducto;
    private javax.swing.JButton mireporte;
    private javax.swing.JButton misalir;
    public static javax.swing.JButton miventa;
    private javax.swing.JLabel mregistro;
    private javax.swing.JPanel pmenuArchivo;
    private javax.swing.JPanel pmenuBar;
    private javax.swing.JPanel pmenuRegistro;
    // End of variables declaration//GEN-END:variables
}
