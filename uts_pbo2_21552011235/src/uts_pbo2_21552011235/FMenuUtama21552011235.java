/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_pbo2_21552011235;

import uts_pbo2_21552011235.CKoneksi21552011235;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.UserSession;
import koneksi.idDivSession;
import koneksi.idSession;
import koneksi.kodepeSession;
import koneksi.namaSession;

/**
 *
 * @author albin
 */
public class FMenuUtama21552011235 extends javax.swing.JFrame {
    Connection conn = CKoneksi21552011235.getKoneksi();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    
    public FMenuUtama21552011235() {
        initComponents();
        hakakses();
        hallo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @param Nama
     * @param Level
     */
    
    @SuppressWarnings("unchecked")
    
     private void hallo() {
        labelUsername.setText("Anda Sebagai : " + UserSession.getUserLogin());
    }
        private void hakakses() {
        String kodeuser = idSession.getidUSerLogin();
        String status = UserSession.getUserLogin();

        String kodeDiv = idDivSession.getidDivLogin();
        String user = labelUsername.getText();
        if (status.equals("Admin")) {
            try {
                Connection con = CKoneksi21552011235.getKoneksi();
                Statement st = con.createStatement();
                String sql = "Select * from tblpegawai where idUser = '" + kodeuser + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    String namapegawai = rs.getString("nama");
                    String kodepegawai = rs.getString("kodePegawai");
                    String idDIVV = rs.getString("idDivisi");

                    kodepeSession.setkodepegLogin(kodepegawai);
                    idDivSession.setidDivLogin(idDIVV);
                    namaSession.setnamaaLogin(namapegawai);
                }
                
            } catch (Exception e) {
            }

            try {
                Connection con = CKoneksi21552011235.getKoneksi();
                Statement st = con.createStatement();
                String sql = "Select * from tbldivisi where idDivisi = '" + kodeDiv + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                

                }
            } catch (Exception e) {
            }
            btnProduksi.setEnabled(false);
            btnMarketing.setEnabled(false);

        } else if (status.equals("Produksi")) {
            try {
                Connection con = CKoneksi21552011235.getKoneksi();
                Statement st = con.createStatement();
                String sql = "Select * from tblpegawai where idUser = '" + kodeuser + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    String namapegawai = rs.getString("nama");
                    String kodepegawai = rs.getString("kodePegawai");
                    String idDIVV = rs.getString("idDivisi");

                    kodepeSession.setkodepegLogin(kodepegawai);
                    idDivSession.setidDivLogin(idDIVV);
                    namaSession.setnamaaLogin(namapegawai);
                }
            } catch (Exception e) {
            }

            try {
                Connection con = CKoneksi21552011235.getKoneksi();
                Statement st = con.createStatement();
                String sql = "Select * from tbldivisi where idDivisi = '" + kodeDiv + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
         
                }
            } catch (Exception e) {
            }
            btnMarketing.setEnabled(false);
            btnAdmin.setEnabled(false);

        } else {
            try {
                Connection con = CKoneksi21552011235.getKoneksi();
                Statement st = con.createStatement();
                String sql = "Select * from tblpegawai where idUser = '" + kodeuser + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    String namapegawai = rs.getString("nama");
                    String kodepegawai = rs.getString("kodePegawai");
                    String idDIVV = rs.getString("idDivisi");

                    kodepeSession.setkodepegLogin(kodepegawai);
                    idDivSession.setidDivLogin(idDIVV);
                    namaSession.setnamaaLogin(namapegawai);
                }
            } catch (Exception e) {
            }

            try {
                Connection con = CKoneksi21552011235.getKoneksi();
                Statement st = con.createStatement();
                String sql = "Select * from tbldivisi where idDivisi = '" + kodeDiv + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                   
                }
            } catch (Exception e) {
            }
            btnProduksi.setEnabled(false);
            btnAdmin.setEnabled(false);
            //btnProfil.setEnabled(false);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                  

    private void datausActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }
    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelUsername = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnAdmin = new javax.swing.JMenu();
        menuItemDataUser = new javax.swing.JMenuItem();
        menuItemDataPegawai = new javax.swing.JMenuItem();
        btnProduksi = new javax.swing.JMenu();
        menuItemDataDivisi = new javax.swing.JMenuItem();
        menuItemDataAlat = new javax.swing.JMenuItem();
        menuItemDataPenjualanProduksi = new javax.swing.JMenuItem();
        btnMarketing = new javax.swing.JMenu();
        menuItemDataPenjualanMarketing = new javax.swing.JMenuItem();
        btnUbahPassword = new javax.swing.JMenu();
        btnProfil = new javax.swing.JMenu();
        btnLogout = new javax.swing.JMenu();

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("____________________________________________________________");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" 21552011235_Albi Mudakar Nasyabi");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsername.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jPanel1.add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 430, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-test-account-48.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 40));

        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-user-24.png"))); // NOI18N
        btnAdmin.setText("Admin");
        btnAdmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdminMouseExited(evt);
            }
        });

        menuItemDataUser.setText("Data User");
        menuItemDataUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDataUserActionPerformed(evt);
            }
        });
        btnAdmin.add(menuItemDataUser);

        menuItemDataPegawai.setText("Data Pegawai");
        menuItemDataPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDataPegawaiActionPerformed(evt);
            }
        });
        btnAdmin.add(menuItemDataPegawai);

        jMenuBar1.add(btnAdmin);

        btnProduksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-product-24.png"))); // NOI18N
        btnProduksi.setText("Produksi");
        btnProduksi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProduksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProduksiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProduksiMouseExited(evt);
            }
        });

        menuItemDataDivisi.setText("Data Divisi");
        menuItemDataDivisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDataDivisiActionPerformed(evt);
            }
        });
        btnProduksi.add(menuItemDataDivisi);

        menuItemDataAlat.setText("Data Alat");
        menuItemDataAlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDataAlatActionPerformed(evt);
            }
        });
        btnProduksi.add(menuItemDataAlat);

        menuItemDataPenjualanProduksi.setText("Data Penjualan");
        menuItemDataPenjualanProduksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDataPenjualanProduksiActionPerformed(evt);
            }
        });
        btnProduksi.add(menuItemDataPenjualanProduksi);

        jMenuBar1.add(btnProduksi);

        btnMarketing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-stocks-growth-24.png"))); // NOI18N
        btnMarketing.setText("Marketing");
        btnMarketing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnMarketing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMarketingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMarketingMouseExited(evt);
            }
        });

        menuItemDataPenjualanMarketing.setText("Data Penjualan");
        menuItemDataPenjualanMarketing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDataPenjualanMarketingActionPerformed(evt);
            }
        });
        btnMarketing.add(menuItemDataPenjualanMarketing);

        jMenuBar1.add(btnMarketing);

        btnUbahPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-password-24.png"))); // NOI18N
        btnUbahPassword.setText("Ubah Password");
        btnUbahPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUbahPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahPasswordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUbahPasswordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUbahPasswordMouseExited(evt);
            }
        });
        jMenuBar1.add(btnUbahPassword);

        btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-male-user-24.png"))); // NOI18N
        btnProfil.setText("Profil");
        btnProfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProfilMouseExited(evt);
            }
        });
        btnProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfilActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnProfil);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-logout-rounded-24.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jMenuBar1.add(btnLogout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseEntered
       btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-user-24-hover.png")));
    }//GEN-LAST:event_btnAdminMouseEntered

    private void btnAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminMouseExited
       btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-user-24.png")));
    }//GEN-LAST:event_btnAdminMouseExited

    private void btnProduksiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduksiMouseEntered
       btnProduksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-product-24-hover.png")));
    }//GEN-LAST:event_btnProduksiMouseEntered

    private void btnProduksiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProduksiMouseExited
       btnProduksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-product-24.png")));
    }//GEN-LAST:event_btnProduksiMouseExited

    private void btnMarketingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarketingMouseEntered
       btnMarketing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-stocks-growth-24-hover.png")));
    }//GEN-LAST:event_btnMarketingMouseEntered

    private void btnMarketingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarketingMouseExited
       btnMarketing.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-stocks-growth-24.png")));
    }//GEN-LAST:event_btnMarketingMouseExited

    private void btnUbahPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahPasswordMouseEntered
       btnUbahPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-password-24-hover.png")));
    }//GEN-LAST:event_btnUbahPasswordMouseEntered

    private void btnUbahPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahPasswordMouseExited
       btnUbahPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-password-24.png")));
    }//GEN-LAST:event_btnUbahPasswordMouseExited

    private void btnProfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfilMouseEntered
       btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-male-user-24-hover.png")));
    }//GEN-LAST:event_btnProfilMouseEntered

    private void btnProfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfilMouseExited
       btnProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-male-user-24.png")));
    }//GEN-LAST:event_btnProfilMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
       btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-logout-rounded-24-hover.png")));
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
       btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-logout-rounded-24.png")));
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Logout Dari Aplikasi?","Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (ok==0){
                new uts_pbo2_21552011235.Flogin21552011235().setVisible(true);
                dispose();
   
                JOptionPane.showMessageDialog(null , "Anda Berhasil Logout, Silahkan Login kembali!");
        }
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void menuItemDataUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDataUserActionPerformed
        FUser21552011235 fu = new FUser21552011235();
        fu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemDataUserActionPerformed

    private void menuItemDataPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDataPegawaiActionPerformed
        FPegawai21552011235 fp = new FPegawai21552011235();
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemDataPegawaiActionPerformed

    private void menuItemDataDivisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDataDivisiActionPerformed
        FDivisi21552011235 fd = new FDivisi21552011235();
        fd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemDataDivisiActionPerformed

    private void menuItemDataAlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDataAlatActionPerformed
        FAlat21552011235 fl = new FAlat21552011235();
        fl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemDataAlatActionPerformed

    private void menuItemDataPenjualanProduksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDataPenjualanProduksiActionPerformed
        FPenjualan21552011235 fp = new FPenjualan21552011235();
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemDataPenjualanProduksiActionPerformed

    private void menuItemDataPenjualanMarketingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDataPenjualanMarketingActionPerformed
        FPenjualan21552011235 fp = new FPenjualan21552011235();
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItemDataPenjualanMarketingActionPerformed

    private void btnUbahPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahPasswordMouseClicked
        FUbahPassword21552011235 fu = new FUbahPassword21552011235();
        fu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUbahPasswordMouseClicked

    private void btnProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfilActionPerformed
//        FProfil21552011235 fpf = new FProfil21552011235();
//        fpf.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnProfilActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Flogin21552011235 fl = new Flogin21552011235();
        fl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnProfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfilMouseClicked
        FProfil21552011235 fpf = new FProfil21552011235();
        fpf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProfilMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FMenuUtama21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMenuUtama21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMenuUtama21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMenuUtama21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMenuUtama21552011235().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu btnAdmin;
    private javax.swing.JMenu btnLogout;
    private javax.swing.JMenu btnMarketing;
    private javax.swing.JMenu btnProduksi;
    private javax.swing.JMenu btnProfil;
    private javax.swing.JMenu btnUbahPassword;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JMenuItem menuItemDataAlat;
    private javax.swing.JMenuItem menuItemDataDivisi;
    private javax.swing.JMenuItem menuItemDataPegawai;
    private javax.swing.JMenuItem menuItemDataPenjualanMarketing;
    private javax.swing.JMenuItem menuItemDataPenjualanProduksi;
    private javax.swing.JMenuItem menuItemDataUser;
    // End of variables declaration//GEN-END:variables
}
