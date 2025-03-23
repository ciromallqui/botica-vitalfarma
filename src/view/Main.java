package view;

import aplication_class.CUsuario;
import cross_cuting.Archivos;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.info.MessageDialog;
import view.info.MessageToast;

public class Main extends javax.swing.JFrame {
    ImageIcon fondo;
    JLabel l;
    public static Control control;
    boolean viewMenu;
    public Main() {
        initComponents();
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fondo = new ImageIcon(getClass().getResource("/Image/fondo.png"));
        setIconImage(new ImageIcon(getClass().getResource("/Image/logo_icon.png")).getImage());
        lbnombre.setText(CUsuario.getNombreCompleto());
        control = new Control();
        logoLabel();
        miadministrador.setOpaque(true);
        miseguridad.setOpaque(true);
        validarItemsAdmin();
        viewMenu = false;
        
        l.add(LOG);
        LOG.setSize(650, 250);
        if(Archivos.log()) LOG.setVisible(true);
        else LOG.setVisible(false);
    }
    private void logoLabel(){
        l = new JLabel();
        l.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.png")));
        dtpanel.add(l);
        l.setVisible(true);
        l.setLocation(0, -50);
        
    }
    
    private void validarItemsAdmin(){
        try{
            if(!CUsuario.getTipoUsuario().equals("ADMINISTRADOR")){
                mconfiguracion.setVisible(false);
                mregistro.setVisible(false);
            }
        }catch(NullPointerException ex){}
    }
    
    public static String usuario(){
        return CUsuario.getNombreUsuario();
    }
    
    public static String clave(){
        return CUsuario.getClave();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PANELARCHIVO = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        minuevoControl = new javax.swing.JButton();
        minuevaVenta = new javax.swing.JButton();
        midevolucion = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        mireporte = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        micambioUsuario = new javax.swing.JButton();
        misalir = new javax.swing.JButton();
        PANELREGISTRO = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        miproducto = new javax.swing.JButton();
        mipresentacion = new javax.swing.JButton();
        PANELADMIN = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        miadministrador = new javax.swing.JButton();
        miseguridad = new javax.swing.JButton();
        PANELCONFIG = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        miturno = new javax.swing.JButton();
        mibackup = new javax.swing.JButton();
        micambioBd = new javax.swing.JButton();
        micambioLogo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        PANELSEGURIDAD = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        sinuevaCuenta = new javax.swing.JButton();
        sicambioClave = new javax.swing.JButton();
        PANELADMINV = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        micambioClave = new javax.swing.JButton();
        LOG = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txlog = new javax.swing.JTextArea();
        menuBorrarLog = new javax.swing.JPopupMenu();
        borrarMenu = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbnombre = new javax.swing.JLabel();
        marchivo = new javax.swing.JLabel();
        mregistro = new javax.swing.JLabel();
        madministrador = new javax.swing.JLabel();
        mconfiguracion = new javax.swing.JLabel();
        dtpanel = new javax.swing.JDesktopPane();
        lbmain = new javax.swing.JLabel();
        lbmessage = new javax.swing.JLabel();

        PANELARCHIVO.setMinimumSize(new java.awt.Dimension(200, 250));
        PANELARCHIVO.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        PANELARCHIVO.setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        minuevoControl.setBackground(new java.awt.Color(255, 102, 0));
        minuevoControl.setForeground(new java.awt.Color(255, 255, 255));
        minuevoControl.setMnemonic('N');
        minuevoControl.setText("Nuevo Control                  Alt + N");
        minuevoControl.setContentAreaFilled(false);
        minuevoControl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        minuevaVenta.setBackground(new java.awt.Color(255, 102, 0));
        minuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        minuevaVenta.setMnemonic('V');
        minuevaVenta.setText("Nueva Venta                     Atl + V");
        minuevaVenta.setContentAreaFilled(false);
        minuevaVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        minuevaVenta.setOpaque(true);
        minuevaVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minuevaVentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minuevaVentaMouseExited(evt);
            }
        });
        minuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minuevaVentaActionPerformed(evt);
            }
        });

        midevolucion.setBackground(new java.awt.Color(255, 102, 0));
        midevolucion.setForeground(new java.awt.Color(255, 255, 255));
        midevolucion.setText("Devoluciones");
        midevolucion.setContentAreaFilled(false);
        midevolucion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        mireporte.setBackground(new java.awt.Color(255, 102, 0));
        mireporte.setForeground(new java.awt.Color(255, 255, 255));
        mireporte.setText("Reportes");
        mireporte.setContentAreaFilled(false);
        mireporte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mireporte.setOpaque(true);
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

        micambioUsuario.setBackground(new java.awt.Color(255, 102, 0));
        micambioUsuario.setForeground(new java.awt.Color(255, 255, 255));
        micambioUsuario.setText("Cambio de Usuaio");
        micambioUsuario.setContentAreaFilled(false);
        micambioUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        misalir.setBackground(new java.awt.Color(255, 102, 0));
        misalir.setForeground(new java.awt.Color(255, 255, 255));
        misalir.setMnemonic('X');
        misalir.setText("Salir                                   Alt + X");
        misalir.setContentAreaFilled(false);
        misalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(minuevoControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(minuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(midevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(mireporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addComponent(micambioUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(misalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(minuevoControl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(minuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(midevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mireporte, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(micambioUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(misalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PANELARCHIVOLayout = new javax.swing.GroupLayout(PANELARCHIVO.getContentPane());
        PANELARCHIVO.getContentPane().setLayout(PANELARCHIVOLayout);
        PANELARCHIVOLayout.setHorizontalGroup(
            PANELARCHIVOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PANELARCHIVOLayout.setVerticalGroup(
            PANELARCHIVOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PANELREGISTRO.setMinimumSize(new java.awt.Dimension(160, 85));
        PANELREGISTRO.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        PANELREGISTRO.setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 102, 0));

        miproducto.setBackground(new java.awt.Color(255, 102, 0));
        miproducto.setForeground(new java.awt.Color(255, 255, 255));
        miproducto.setText("Producto");
        miproducto.setContentAreaFilled(false);
        miproducto.setHideActionText(true);
        miproducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        mipresentacion.setText("Presentación");
        mipresentacion.setContentAreaFilled(false);
        mipresentacion.setHideActionText(true);
        mipresentacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miproducto, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addComponent(mipresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(mipresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(miproducto, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout PANELREGISTROLayout = new javax.swing.GroupLayout(PANELREGISTRO.getContentPane());
        PANELREGISTRO.getContentPane().setLayout(PANELREGISTROLayout);
        PANELREGISTROLayout.setHorizontalGroup(
            PANELREGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PANELREGISTROLayout.setVerticalGroup(
            PANELREGISTROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PANELADMIN.setMinimumSize(new java.awt.Dimension(207, 85));
        PANELADMIN.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        PANELADMIN.setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(255, 102, 0));

        miadministrador.setBackground(new java.awt.Color(255, 102, 0));
        miadministrador.setForeground(new java.awt.Color(255, 255, 255));
        miadministrador.setText("Datos de Administrador");
        miadministrador.setContentAreaFilled(false);
        miadministrador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miadministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miadministradorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miadministradorMouseExited(evt);
            }
        });
        miadministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miadministradorActionPerformed(evt);
            }
        });

        miseguridad.setBackground(new java.awt.Color(255, 102, 0));
        miseguridad.setForeground(new java.awt.Color(255, 255, 255));
        miseguridad.setText("Seguridad                                      >");
        miseguridad.setContentAreaFilled(false);
        miseguridad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miseguridad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miseguridadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miseguridadMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miadministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(miseguridad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(miadministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(miseguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PANELADMINLayout = new javax.swing.GroupLayout(PANELADMIN.getContentPane());
        PANELADMIN.getContentPane().setLayout(PANELADMINLayout);
        PANELADMINLayout.setHorizontalGroup(
            PANELADMINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PANELADMINLayout.setVerticalGroup(
            PANELADMINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PANELCONFIG.setMinimumSize(new java.awt.Dimension(223, 167));
        PANELCONFIG.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        PANELCONFIG.setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));

        miturno.setBackground(new java.awt.Color(255, 102, 0));
        miturno.setForeground(new java.awt.Color(255, 255, 255));
        miturno.setText("Horario de Turnos");
        miturno.setContentAreaFilled(false);
        miturno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        miturno.setOpaque(true);
        miturno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miturnoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miturnoMouseExited(evt);
            }
        });
        miturno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miturnoActionPerformed(evt);
            }
        });

        mibackup.setBackground(new java.awt.Color(255, 102, 0));
        mibackup.setForeground(new java.awt.Color(255, 255, 255));
        mibackup.setText("Generar Backup de Datos");
        mibackup.setContentAreaFilled(false);
        mibackup.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mibackup.setOpaque(true);
        mibackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mibackupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mibackupMouseExited(evt);
            }
        });
        mibackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mibackupActionPerformed(evt);
            }
        });

        micambioBd.setBackground(new java.awt.Color(255, 102, 0));
        micambioBd.setForeground(new java.awt.Color(255, 255, 255));
        micambioBd.setText("Cambio de Base de Datos");
        micambioBd.setContentAreaFilled(false);
        micambioBd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        micambioBd.setOpaque(true);
        micambioBd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                micambioBdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                micambioBdMouseExited(evt);
            }
        });
        micambioBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micambioBdActionPerformed(evt);
            }
        });

        micambioLogo.setBackground(new java.awt.Color(255, 102, 0));
        micambioLogo.setForeground(new java.awt.Color(255, 255, 255));
        micambioLogo.setText("Cambiar Logo");
        micambioLogo.setContentAreaFilled(false);
        micambioLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        micambioLogo.setOpaque(true);
        micambioLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                micambioLogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                micambioLogoMouseExited(evt);
            }
        });
        micambioLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micambioLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miturno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mibackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(micambioBd, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
            .addComponent(micambioLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(miturno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(micambioLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mibackup, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(micambioBd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout PANELCONFIGLayout = new javax.swing.GroupLayout(PANELCONFIG.getContentPane());
        PANELCONFIG.getContentPane().setLayout(PANELCONFIGLayout);
        PANELCONFIGLayout.setHorizontalGroup(
            PANELCONFIGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PANELCONFIGLayout.setVerticalGroup(
            PANELCONFIGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PANELSEGURIDAD.setMinimumSize(new java.awt.Dimension(167, 85));
        PANELSEGURIDAD.setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(255, 102, 0));

        sinuevaCuenta.setBackground(new java.awt.Color(255, 102, 0));
        sinuevaCuenta.setForeground(new java.awt.Color(255, 255, 255));
        sinuevaCuenta.setText("Administrar Cuenta");
        sinuevaCuenta.setContentAreaFilled(false);
        sinuevaCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sinuevaCuenta.setOpaque(true);
        sinuevaCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sinuevaCuentaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sinuevaCuentaMouseExited(evt);
            }
        });
        sinuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinuevaCuentaActionPerformed(evt);
            }
        });

        sicambioClave.setBackground(new java.awt.Color(255, 102, 0));
        sicambioClave.setForeground(new java.awt.Color(255, 255, 255));
        sicambioClave.setText("Cambiar Clave");
        sicambioClave.setContentAreaFilled(false);
        sicambioClave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sicambioClave.setOpaque(true);
        sicambioClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sicambioClaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sicambioClaveMouseExited(evt);
            }
        });
        sicambioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sicambioClaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sinuevaCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(sicambioClave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(sinuevaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sicambioClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PANELSEGURIDADLayout = new javax.swing.GroupLayout(PANELSEGURIDAD.getContentPane());
        PANELSEGURIDAD.getContentPane().setLayout(PANELSEGURIDADLayout);
        PANELSEGURIDADLayout.setHorizontalGroup(
            PANELSEGURIDADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PANELSEGURIDADLayout.setVerticalGroup(
            PANELSEGURIDADLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PANELADMINV.setMinimumSize(new java.awt.Dimension(209, 45));
        PANELADMINV.setUndecorated(true);

        jPanel7.setBackground(new java.awt.Color(255, 102, 0));

        micambioClave.setBackground(new java.awt.Color(255, 102, 0));
        micambioClave.setForeground(new java.awt.Color(255, 255, 255));
        micambioClave.setText("Cambiar Clave");
        micambioClave.setContentAreaFilled(false);
        micambioClave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        micambioClave.setOpaque(true);
        micambioClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                micambioClaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                micambioClaveMouseExited(evt);
            }
        });
        micambioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                micambioClaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(micambioClave, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(micambioClave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PANELADMINVLayout = new javax.swing.GroupLayout(PANELADMINV.getContentPane());
        PANELADMINV.getContentPane().setLayout(PANELADMINVLayout);
        PANELADMINVLayout.setHorizontalGroup(
            PANELADMINVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PANELADMINVLayout.setVerticalGroup(
            PANELADMINVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        LOG.setBackground(new java.awt.Color(0, 153, 51));
        LOG.setMinimumSize(new java.awt.Dimension(680, 340));
        LOG.setPreferredSize(new java.awt.Dimension(680, 340));

        jScrollPane1.setBackground(new java.awt.Color(227, 111, 30));
        jScrollPane1.setOpaque(false);

        txlog.setBackground(new java.awt.Color(0, 153, 51));
        txlog.setColumns(20);
        txlog.setRows(5);
        txlog.setComponentPopupMenu(menuBorrarLog);
        txlog.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txlog.setEnabled(false);
        jScrollPane1.setViewportView(txlog);

        javax.swing.GroupLayout LOGLayout = new javax.swing.GroupLayout(LOG);
        LOG.setLayout(LOGLayout);
        LOGLayout.setHorizontalGroup(
            LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        LOGLayout.setVerticalGroup(
            LOGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LOGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuBorrarLog.setBackground(new java.awt.Color(227, 111, 30));

        borrarMenu.setBackground(new java.awt.Color(227, 111, 30));
        borrarMenu.setText("BORRAR LOG");
        borrarMenu.setOpaque(true);
        borrarMenu.setPreferredSize(new java.awt.Dimension(135, 35));
        borrarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarMenuActionPerformed(evt);
            }
        });
        menuBorrarLog.add(borrarMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTROL DE VENTAS Y STOCK DE MEDICAMENTOS - v1.9");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
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

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1069, 42));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user_login.png"))); // NOI18N

        lbnombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombre.setForeground(new java.awt.Color(255, 255, 255));
        lbnombre.setText("xxxxxxxxxxxxxx");

        marchivo.setBackground(new java.awt.Color(255, 102, 0));
        marchivo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        marchivo.setForeground(new java.awt.Color(255, 255, 255));
        marchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        marchivo.setText("Archivos");
        marchivo.setOpaque(true);
        marchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marchivoMouseClicked(evt);
            }
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mregistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mregistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mregistroMouseExited(evt);
            }
        });

        madministrador.setBackground(new java.awt.Color(255, 102, 0));
        madministrador.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        madministrador.setForeground(new java.awt.Color(255, 255, 255));
        madministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        madministrador.setText("Administración");
        madministrador.setOpaque(true);
        madministrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                madministradorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                madministradorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                madministradorMouseExited(evt);
            }
        });

        mconfiguracion.setBackground(new java.awt.Color(255, 102, 0));
        mconfiguracion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        mconfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        mconfiguracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mconfiguracion.setText("Configuraciones");
        mconfiguracion.setOpaque(true);
        mconfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mconfiguracionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mconfiguracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mconfiguracionMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(marchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(madministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mconfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 490, Short.MAX_VALUE)
                .addComponent(lbnombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
            .addComponent(marchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mregistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(madministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mconfiguracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dtpanel.setLayer(lbmain, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dtpanel.setLayer(lbmessage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dtpanelLayout = new javax.swing.GroupLayout(dtpanel);
        dtpanel.setLayout(dtpanelLayout);
        dtpanelLayout.setHorizontalGroup(
            dtpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dtpanelLayout.createSequentialGroup()
                .addComponent(lbmain, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbmessage)
                .addContainerGap())
        );
        dtpanelLayout.setVerticalGroup(
            dtpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbmain, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addGroup(dtpanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbmessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
            .addComponent(dtpanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dtpanel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(lbmain.getWidth(), lbmain.getHeight(), Image.SCALE_DEFAULT));
        lbmain.setIcon(icono);
        this.repaint();
    }//GEN-LAST:event_formWindowOpened

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        lbmain.setIcon(icono);
        this.repaint();
        l.setSize(this.getWidth(), this.getHeight());
        dtpanel.setSize(this.getWidth(), this.getHeight());
        LOG.setLocation(this.getWidth()-670, this.getHeight()-290);
    }//GEN-LAST:event_formComponentResized

    private void marchivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marchivoMouseEntered
        marchivo.setBackground(new java.awt.Color(255,153,51));
        if(viewMenu){
            PANELARCHIVO.setLocation(this.getX()+9, this.getY()+marginTop);
            PANELREGISTRO.setVisible(false);
            PANELADMIN.setVisible(false);
            PANELCONFIG.setVisible(false);
            PANELSEGURIDAD.setVisible(false);
            PANELADMINV.setVisible(false);
            PANELARCHIVO.setVisible(true);
            
            mregistro.setBackground(new java.awt.Color(255,102,0));
            madministrador.setBackground(new java.awt.Color(255,102,0));
            mconfiguracion.setBackground(new java.awt.Color(255,102,0));
            
            miseguridad.setBackground(new java.awt.Color(255,102,0));
        }
    }//GEN-LAST:event_marchivoMouseEntered

    private void marchivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marchivoMouseExited
        marchivo.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_marchivoMouseExited

    private void marchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marchivoMouseClicked
        if(viewMenu){
            viewMenu = false;
            PANELARCHIVO.setVisible(false);
        }else{
            viewMenu = true;
            PANELARCHIVO.setLocation(this.getX()+9, this.getY()+marginTop);
            PANELARCHIVO.setVisible(true);
        }
    }//GEN-LAST:event_marchivoMouseClicked

    private void mregistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mregistroMouseEntered
        if(mregistro.isEnabled()){
            mregistro.setBackground(new java.awt.Color(255,153,51));
            if(viewMenu){
                PANELREGISTRO.setLocation(this.getX()+105, this.getY()+marginTop);
                PANELARCHIVO.setVisible(false);
                PANELADMIN.setVisible(false);
                PANELCONFIG.setVisible(false);
                PANELSEGURIDAD.setVisible(false);
                PANELADMINV.setVisible(false);
                PANELREGISTRO.setVisible(true);
                
                marchivo.setBackground(new java.awt.Color(255,102,0));
                madministrador.setBackground(new java.awt.Color(255,102,0));
                mconfiguracion.setBackground(new java.awt.Color(255,102,0));
                
                miseguridad.setBackground(new java.awt.Color(255,102,0));
            }
        }
    }//GEN-LAST:event_mregistroMouseEntered

    private void mregistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mregistroMouseExited
        mregistro.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mregistroMouseExited

    private void mregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mregistroMouseClicked
        if(viewMenu){
            viewMenu = false;
            PANELREGISTRO.setVisible(false);
        }else{
            viewMenu = true;
            PANELREGISTRO.setLocation(this.getX()+105, this.getY()+marginTop);
            PANELREGISTRO.setVisible(true);
        }
    }//GEN-LAST:event_mregistroMouseClicked

    private void madministradorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_madministradorMouseEntered
        madministrador.setBackground(new java.awt.Color(255,153,51));
        if(viewMenu){
            PANELADMIN.setLocation(this.getX()+205, this.getY()+marginTop);
            PANELADMINV.setLocation(this.getX()+105, this.getY()+marginTop);
            PANELARCHIVO.setVisible(false);
            PANELREGISTRO.setVisible(false);
            PANELCONFIG.setVisible(false);
            PANELSEGURIDAD.setVisible(false);
            if(!CUsuario.getTipoUsuario().equals("ADMINISTRADOR"))
                PANELADMINV.setVisible(true);
            else PANELADMIN.setVisible(true);
            
            marchivo.setBackground(new java.awt.Color(255,102,0));
            mregistro.setBackground(new java.awt.Color(255,102,0));
            mconfiguracion.setBackground(new java.awt.Color(255,102,0));
            
            miseguridad.setBackground(new java.awt.Color(255,102,0));
        }
    }//GEN-LAST:event_madministradorMouseEntered

    private void madministradorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_madministradorMouseExited
        madministrador.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_madministradorMouseExited

    private void madministradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_madministradorMouseClicked
        if(!CUsuario.getTipoUsuario().equals("ADMINISTRADOR")){
            if(viewMenu){
                viewMenu = false;
                PANELADMINV.setVisible(false);
            }else{
                viewMenu = true;
                PANELADMINV.setLocation(this.getX()+105, this.getY()+marginTop);
                PANELADMINV.setVisible(true);
            }
        }else{
            if(viewMenu){
                viewMenu = false;
                PANELADMIN.setVisible(false);
            }else{
                viewMenu = true;
                PANELADMIN.setLocation(this.getX()+205, this.getY()+marginTop);
                PANELADMIN.setVisible(true);
            }
        }
    }//GEN-LAST:event_madministradorMouseClicked

    private void mconfiguracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mconfiguracionMouseEntered
        mconfiguracion.setBackground(new java.awt.Color(255,153,51));
        if(viewMenu){
            PANELCONFIG.setLocation(this.getX()+335, this.getY()+marginTop);
            PANELARCHIVO.setVisible(false);
            PANELREGISTRO.setVisible(false);
            PANELADMIN.setVisible(false);
            PANELSEGURIDAD.setVisible(false);
            PANELADMINV.setVisible(false);
            PANELCONFIG.setVisible(true);
            
            marchivo.setBackground(new java.awt.Color(255,102,0));
            mregistro.setBackground(new java.awt.Color(255,102,0));
            madministrador.setBackground(new java.awt.Color(255,102,0));
            
            miseguridad.setBackground(new java.awt.Color(255,102,0));
        }
    }//GEN-LAST:event_mconfiguracionMouseEntered

    private void mconfiguracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mconfiguracionMouseExited
        mconfiguracion.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mconfiguracionMouseExited

    private void mconfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mconfiguracionMouseClicked
        if(viewMenu){
            viewMenu = false;
            PANELCONFIG.setVisible(false);
        }else{
            viewMenu = true;
            PANELCONFIG.setLocation(this.getX()+335, this.getY()+marginTop);
            PANELCONFIG.setVisible(true);
        }
    }//GEN-LAST:event_mconfiguracionMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        PANELARCHIVO.setVisible(false);
        PANELREGISTRO.setVisible(false);
        PANELADMIN.setVisible(false);
        PANELCONFIG.setVisible(false);
        PANELADMINV.setVisible(false);
        PANELSEGURIDAD.setVisible(false);
        viewMenu = false;
        marchivo.setBackground(new java.awt.Color(255,102,0));
        mregistro.setBackground(new java.awt.Color(255,102,0));
        madministrador.setBackground(new java.awt.Color(255,102,0));
        mconfiguracion.setBackground(new java.awt.Color(255,102,0));
        
        miseguridad.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_formMouseClicked

    private void minuevoControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minuevoControlMouseEntered
        if(minuevoControl.isEnabled()) minuevoControl.setBackground(new java.awt.Color(255,153,51));
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_minuevoControlMouseEntered

    private void minuevoControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minuevoControlMouseExited
        minuevoControl.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_minuevoControlMouseExited

    private void minuevoControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minuevoControlActionPerformed
        marchivo.setBackground(new java.awt.Color(255,102,0));
        PANELARCHIVO.setVisible(false);
        viewMenu = false;
        
        control = new Control();
        dtpanel.add(control);
        control.setVisible(true);
        minuevoControl.setEnabled(false);
        minuevoControl.setForeground(new java.awt.Color(204,204,204));
        if(!minuevaVenta.isEnabled()){
            Control.pnuevaVenta.setVisible(false);
        }
        if(!miproducto.isEnabled()){
            Control.pproducto.setVisible(false);
        }
    }//GEN-LAST:event_minuevoControlActionPerformed

    private void minuevaVentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minuevaVentaMouseEntered
        if(minuevaVenta.isEnabled()) minuevaVenta.setBackground(new java.awt.Color(255,153,51));
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_minuevaVentaMouseEntered

    private void minuevaVentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minuevaVentaMouseExited
        minuevaVenta.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_minuevaVentaMouseExited

    private void minuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minuevaVentaActionPerformed
        marchivo.setBackground(new java.awt.Color(255,102,0));
        PANELARCHIVO.setVisible(false);
        viewMenu = false;
        
        VentaDetalle dv = new VentaDetalle();
        dtpanel.add(dv);
        dv.setVisible(true);
    }//GEN-LAST:event_minuevaVentaActionPerformed

    private void midevolucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midevolucionMouseEntered
        if(midevolucion.isEnabled()) midevolucion.setBackground(new java.awt.Color(255,153,51));
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_midevolucionMouseEntered

    private void midevolucionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midevolucionMouseExited
        midevolucion.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_midevolucionMouseExited

    private void midevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midevolucionActionPerformed
        marchivo.setBackground(new java.awt.Color(255,102,0));
        PANELARCHIVO.setVisible(false);
        viewMenu = false;
        
        Devolucion dv = new Devolucion();
        dtpanel.add(dv);
        dv.setVisible(true);
    }//GEN-LAST:event_midevolucionActionPerformed

    private void mireporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mireporteMouseEntered
        mireporte.setBackground(new java.awt.Color(255,153,51));
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_mireporteMouseEntered

    private void mireporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mireporteMouseExited
        mireporte.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mireporteMouseExited

    private void mireporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mireporteActionPerformed
        marchivo.setBackground(new java.awt.Color(255,102,0));
        PANELARCHIVO.setVisible(false);
        viewMenu = false;
        
        Reporte re = new Reporte();
        dtpanel.add(re);
        re.setVisible(true);
    }//GEN-LAST:event_mireporteActionPerformed

    private void micambioUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioUsuarioMouseEntered
        micambioUsuario.setBackground(new java.awt.Color(255,153,51));
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_micambioUsuarioMouseEntered

    private void micambioUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioUsuarioMouseExited
        micambioUsuario.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_micambioUsuarioMouseExited

    private void micambioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micambioUsuarioActionPerformed
        marchivo.setBackground(new java.awt.Color(255,102,0));
        PANELARCHIVO.setVisible(false);
        viewMenu = false;
        
        this.dispose();
        Usuario u = new Usuario(new javax.swing.JFrame(), true);
        u.setVisible(true);
    }//GEN-LAST:event_micambioUsuarioActionPerformed

    private void misalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_misalirMouseEntered
        misalir.setBackground(new java.awt.Color(255,153,51));
        marchivo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_misalirMouseEntered

    private void misalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_misalirMouseExited
        misalir.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_misalirMouseExited

    private void misalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_misalirActionPerformed

    private void miproductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miproductoMouseEntered
        if(miproducto.isEnabled()) miproducto.setBackground(new java.awt.Color(255,153,51));
        mregistro.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_miproductoMouseEntered

    private void miproductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miproductoMouseExited
        miproducto.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_miproductoMouseExited

    private void miproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miproductoActionPerformed
        mregistro.setBackground(new java.awt.Color(255,102,0));
        PANELREGISTRO.setVisible(false);
        viewMenu = false;
        
        Producto dv = new Producto();
        dtpanel.add(dv);
        dv.setVisible(true);
        miproducto.setForeground(new java.awt.Color(204,204,204));
    }//GEN-LAST:event_miproductoActionPerformed

    private void mipresentacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mipresentacionMouseEntered
        mipresentacion.setBackground(new java.awt.Color(255,153,51));
        mregistro.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_mipresentacionMouseEntered

    private void mipresentacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mipresentacionMouseExited
        mipresentacion.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mipresentacionMouseExited

    private void mipresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mipresentacionActionPerformed
        mregistro.setBackground(new java.awt.Color(255,102,0));
        PANELREGISTRO.setVisible(false);
        viewMenu = false;
        
        Presentacion p = new Presentacion(new javax.swing.JFrame(), true);
        p.setVisible(true);
    }//GEN-LAST:event_mipresentacionActionPerformed

    private void miadministradorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miadministradorMouseEntered
        miadministrador.setBackground(new java.awt.Color(255,153,51));
        madministrador.setBackground(new java.awt.Color(255,153,51));
        miseguridad.setBackground(new java.awt.Color(255,102,0));
        PANELSEGURIDAD.setVisible(false);
    }//GEN-LAST:event_miadministradorMouseEntered

    private void miadministradorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miadministradorMouseExited
        miadministrador.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_miadministradorMouseExited

    private void miadministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miadministradorActionPerformed
        madministrador.setBackground(new java.awt.Color(255,102,0));
        PANELADMIN.setVisible(false);
        viewMenu = false;
        
        Administrador dialog = new Administrador(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_miadministradorActionPerformed

    private void miseguridadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miseguridadMouseEntered
        miseguridad.setBackground(new java.awt.Color(255,153,51));
        madministrador.setBackground(new java.awt.Color(255,153,51));
        PANELSEGURIDAD.setLocation(this.getX()+412, this.getY()+120);
        PANELSEGURIDAD.setVisible(true);
    }//GEN-LAST:event_miseguridadMouseEntered

    private void miseguridadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miseguridadMouseExited
//        miseguridad.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_miseguridadMouseExited

    private void sinuevaCuentaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinuevaCuentaMouseEntered
        madministrador.setBackground(new java.awt.Color(255,153,51));
        miseguridad.setBackground(new java.awt.Color(255,153,51));
        sinuevaCuenta.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_sinuevaCuentaMouseEntered

    private void sinuevaCuentaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinuevaCuentaMouseExited
        sinuevaCuenta.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_sinuevaCuentaMouseExited

    private void sinuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinuevaCuentaActionPerformed
        madministrador.setBackground(new java.awt.Color(255,102,0));
        miseguridad.setBackground(new java.awt.Color(255,102,0));
        sinuevaCuenta.setBackground(new java.awt.Color(255,102,0));
        PANELADMIN.setVisible(false);
        PANELSEGURIDAD.setVisible(false);
        viewMenu = false;
        
        RegistroUsuario t = new RegistroUsuario(new javax.swing.JFrame(), true);
        t.setVisible(true);
    }//GEN-LAST:event_sinuevaCuentaActionPerformed

    private void sicambioClaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sicambioClaveMouseEntered
        madministrador.setBackground(new java.awt.Color(255,153,51));
        miseguridad.setBackground(new java.awt.Color(255,153,51));
        sicambioClave.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_sicambioClaveMouseEntered

    private void sicambioClaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sicambioClaveMouseExited
        sicambioClave.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_sicambioClaveMouseExited

    private void sicambioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sicambioClaveActionPerformed
        miseguridad.setBackground(new java.awt.Color(255,102,0));
        madministrador.setBackground(new java.awt.Color(255,102,0));
        sicambioClave.setBackground(new java.awt.Color(255,102,0));
        PANELADMIN.setVisible(false);
        PANELSEGURIDAD.setVisible(false);
        viewMenu = false;
        
        CambioClave t = new CambioClave(new javax.swing.JFrame(), true);
        t.setVisible(true);
    }//GEN-LAST:event_sicambioClaveActionPerformed

    private void miturnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miturnoMouseEntered
        mconfiguracion.setBackground(new java.awt.Color(255,153,51));
        miturno.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_miturnoMouseEntered

    private void miturnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miturnoMouseExited
        miturno.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_miturnoMouseExited

    private void miturnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miturnoActionPerformed
        mconfiguracion.setBackground(new java.awt.Color(255,102,0));
        PANELCONFIG.setVisible(false);
        viewMenu = false;
        
        ConfigurarTurno t = new ConfigurarTurno(new javax.swing.JFrame(), true);
        t.setVisible(true);
    }//GEN-LAST:event_miturnoActionPerformed

    private void mibackupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mibackupMouseEntered
        mconfiguracion.setBackground(new java.awt.Color(255,153,51));
        mibackup.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_mibackupMouseEntered

    private void mibackupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mibackupMouseExited
        mibackup.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_mibackupMouseExited

    private void mibackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mibackupActionPerformed
        mconfiguracion.setBackground(new java.awt.Color(255,102,0));
        PANELCONFIG.setVisible(false);
        viewMenu = false;
        
        Backap dialog = new Backap(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_mibackupActionPerformed

    private void micambioBdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioBdMouseEntered
        mconfiguracion.setBackground(new java.awt.Color(255,153,51));
        micambioBd.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_micambioBdMouseEntered

    private void micambioBdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioBdMouseExited
        micambioBd.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_micambioBdMouseExited

    private void micambioBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micambioBdActionPerformed
        mconfiguracion.setBackground(new java.awt.Color(255,102,0));
        PANELCONFIG.setVisible(false);
        viewMenu = false;
        
        CambioDB dialog = new CambioDB(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_micambioBdActionPerformed

    private void micambioLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioLogoMouseEntered
        mconfiguracion.setBackground(new java.awt.Color(255,153,51));
        micambioLogo.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_micambioLogoMouseEntered

    private void micambioLogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioLogoMouseExited
        micambioLogo.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_micambioLogoMouseExited

    private void micambioLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micambioLogoActionPerformed
        mconfiguracion.setBackground(new java.awt.Color(255,102,0));
        PANELCONFIG.setVisible(false);
        viewMenu = false;
        
        File file;
        byte bye[];
        FileInputStream fileEntrada;
        FileOutputStream fileSalida;
        JFileChooser abrir = new JFileChooser();
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(".jpg & .png", "jpg", "png"); 
        abrir.setFileFilter(filtro); 
        abrir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (abrir.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            MessageDialog messageDialog = new MessageDialog(new javax.swing.JFrame(), true);
            try {
                file = abrir.getSelectedFile();
                BufferedImage Img = ImageIO.read(file);
                bye = new byte[Img.getWidth()*Img.getHeight()];
                fileEntrada = new FileInputStream(file);
                fileEntrada.read(bye);
                
                file = abrir.getSelectedFile();
                fileSalida = new FileOutputStream(new File("src/Image/logo.png").getAbsolutePath());
                fileSalida.write(bye);
                messageDialog.response("Su logo fue guardado correctamente,<br>reinicie el sistema para realizar los cambios", 1);
                logoLabel();
            } catch (IOException ex) {messageDialog.response("Seleccione el archivo con el formato correcto", 4);}
        }
    }//GEN-LAST:event_micambioLogoActionPerformed

    private void micambioClaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioClaveMouseEntered
        madministrador.setBackground(new java.awt.Color(255,153,51));
        micambioClave.setBackground(new java.awt.Color(255,153,51));
    }//GEN-LAST:event_micambioClaveMouseEntered

    private void micambioClaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_micambioClaveMouseExited
        micambioClave.setBackground(new java.awt.Color(255,102,0));
    }//GEN-LAST:event_micambioClaveMouseExited

    private void micambioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_micambioClaveActionPerformed
        madministrador.setBackground(new java.awt.Color(255,102,0));
        micambioClave.setBackground(new java.awt.Color(255,102,0));
        PANELADMINV.setVisible(false);
        viewMenu = false;
        
        CambioClave t = new CambioClave(new javax.swing.JFrame(), true);
        t.setVisible(true);
        if(t.message()==1){
            MessageToast messageToast = new MessageToast(new javax.swing.JFrame(), true);
            messageToast.response("Contraseña actualizada.", 220, 50, "success");
        }
    }//GEN-LAST:event_micambioClaveActionPerformed

    private void borrarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarMenuActionPerformed
        txlog.setText("");
    }//GEN-LAST:event_borrarMenuActionPerformed

    private final int marginTop = 80;
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
    private javax.swing.JPanel LOG;
    private javax.swing.JDialog PANELADMIN;
    private javax.swing.JDialog PANELADMINV;
    private javax.swing.JDialog PANELARCHIVO;
    private javax.swing.JDialog PANELCONFIG;
    private javax.swing.JDialog PANELREGISTRO;
    private javax.swing.JDialog PANELSEGURIDAD;
    private javax.swing.JMenuItem borrarMenu;
    public static javax.swing.JDesktopPane dtpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbmain;
    public static javax.swing.JLabel lbmessage;
    public static javax.swing.JLabel lbnombre;
    private javax.swing.JLabel madministrador;
    private javax.swing.JLabel marchivo;
    private javax.swing.JLabel mconfiguracion;
    private javax.swing.JPopupMenu menuBorrarLog;
    private javax.swing.JButton miadministrador;
    private javax.swing.JButton mibackup;
    private javax.swing.JButton micambioBd;
    private javax.swing.JButton micambioClave;
    private javax.swing.JButton micambioLogo;
    private javax.swing.JButton micambioUsuario;
    public static javax.swing.JButton midevolucion;
    public static javax.swing.JButton minuevaVenta;
    public static javax.swing.JButton minuevoControl;
    private javax.swing.JButton mipresentacion;
    public static javax.swing.JButton miproducto;
    private javax.swing.JButton mireporte;
    private javax.swing.JButton misalir;
    private javax.swing.JButton miseguridad;
    private javax.swing.JButton miturno;
    private javax.swing.JLabel mregistro;
    private javax.swing.JButton sicambioClave;
    private javax.swing.JButton sinuevaCuenta;
    public static javax.swing.JTextArea txlog;
    // End of variables declaration//GEN-END:variables
}
