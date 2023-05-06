/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_pbo2_21552011235;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static uts_pbo2_21552011235.FMenuUtama21552011235.btnAdmin;
import static uts_pbo2_21552011235.FMenuUtama21552011235.btnLogout;
import static uts_pbo2_21552011235.FMenuUtama21552011235.btnMarketing;
import static uts_pbo2_21552011235.FMenuUtama21552011235.btnProduksi;
import static uts_pbo2_21552011235.FMenuUtama21552011235.btnProfil;
import static uts_pbo2_21552011235.FMenuUtama21552011235.btnUbahPassword;

/**
 *
 * @author albin
 */
public class Flogin21552011235 extends javax.swing.JFrame {
    String nama,email,level;
    /**
     * Creates new form Flogin21552011235
     */
    public Flogin21552011235() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    
    
   private void login (){
        if (txtFieldEmail.getText().isEmpty() || txtPassword.getText().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Pastikan username atau password telah terisi. Ulangi kembali!", "ADA YANG KURANG !", JOptionPane.WARNING_MESSAGE);
        else {
                try{
                    Connection con = CKoneksi21552011235.getKoneksi();
                    Statement st = con.createStatement();
                    // String sql = "SELECT * FROM tb_user inner join tb_pegawai on "+ "tb_pegawai.kode_user = tb_user.kode_user WHERE username =? and password =?;";
                    String sql = "SELECT * FROM tbluser JOIN tblpegawai ON " + "tbluser.idUser = tblpegawai.idUser WHERE tbluser.email = '"+txtFieldEmail.getText()+"' AND tbluser.password = '"+txtPassword.getText()+"'";
                    ResultSet rs = st.executeQuery (sql);
                        if (rs.next()) {
                        level = rs.getString("level");
                        email = rs.getString("email");
                            if (level.equals("Admin")){
                                    JOptionPane.showMessageDialog(null,"Login Berhasil sebagai "+level);
                                    FMenuUtama21552011235 fmu  = new FMenuUtama21552011235();
                                    btnAdmin.setEnabled(true);
                                    btnUbahPassword.setEnabled(true);
                                    btnProfil.setEnabled(true);
                                    btnLogout.setEnabled(true);
                                    btnProduksi.setEnabled(false);
                                    btnMarketing.setEnabled(false);
                                    level = rs.getString("level");
                                    fmu.setData(nama, level);
                                    fmu.setVisible(true);
                                    
                                    } else if (level.equals("Produksi")){
                                    JOptionPane.showMessageDialog(null,"Login Berhasil sebagai "+level);
                                    FMenuUtama21552011235 fm  = new FMenuUtama21552011235();
                                    btnAdmin.setEnabled(false);
                                    btnUbahPassword.setEnabled(true);
                                    btnProfil.setEnabled(true);
                                    btnLogout.setEnabled(true);
                                    btnProduksi.setEnabled(true);
                                    btnMarketing.setEnabled(false);
                                    fm.setVisible(true);
                                    } else if (level.equals("Marketing")){
                                    JOptionPane.showMessageDialog(null,"Login Berhasil sebagai "+level);
                                    FMenuUtama21552011235 fm  = new FMenuUtama21552011235();
                                    btnAdmin.setEnabled(false);
                                    btnUbahPassword.setEnabled(true);
                                    btnProfil.setEnabled(true);
                                    btnLogout.setEnabled(true);
                                    btnProduksi.setEnabled(false);
                                    btnMarketing.setEnabled(true);
                                    fm.setVisible(true);
                                    }
                                    rs.close();
                                    st.close();
                                    this.dispose();
                            }else  {
                                JOptionPane.showMessageDialog(rootPane, "Username atau password anda salah !!!. Ulangi kembali!", "ADA YANG SALAH !", JOptionPane.WARNING_MESSAGE);
                                }
                        } catch (HeadlessException | SQLException e) {
                            System.out.println("Error: " +e);
                    }
            }
   }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JLabel();
        btnDaftar = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("____________________________________________________________");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" 21552011235_Albi Mudakar Nasyabi");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("LOGIN FORM");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("________________________________________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 370, 30));

        txtFieldEmail.setBorder(null);
        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 330, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("________________________________________________");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 370, 30));

        txtPassword.setText("jPasswordField1");
        txtPassword.setBorder(null);
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 330, 40));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnLogin.png"))); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 110, 40));

        btnDaftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnDaftar.png"))); // NOI18N
        btnDaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDaftarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDaftarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDaftarMouseExited(evt);
            }
        });
        jPanel1.add(btnDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 120, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/cover-login.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 350));

        jLabel12.setText("Email");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnLogin.png")));
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnLogin-hover.png")));
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnDaftarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDaftarMouseEntered
        btnDaftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnDaftar.png")));
    }//GEN-LAST:event_btnDaftarMouseEntered

    private void btnDaftarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDaftarMouseExited
        btnDaftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnDaftar-hover.png")));
    }//GEN-LAST:event_btnDaftarMouseExited

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        login();

    }//GEN-LAST:event_btnLoginMouseClicked

    private void btnDaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDaftarMouseClicked
        FDaftar21552011235 fd = new FDaftar21552011235();
        fd.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnDaftarMouseClicked

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
            java.util.logging.Logger.getLogger(Flogin21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flogin21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flogin21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flogin21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flogin21552011235().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDaftar;
    private javax.swing.JLabel btnLogin;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
