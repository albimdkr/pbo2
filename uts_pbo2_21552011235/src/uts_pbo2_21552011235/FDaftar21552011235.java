/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_pbo2_21552011235;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author albin
 */
public class FDaftar21552011235 extends javax.swing.JFrame {
    Connection conn = CKoneksi21552011235.getKoneksi();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    String sql, idUser, level, id, kosong;
    
    public FDaftar21552011235() {
        initComponents();
        idUserOtomatis();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    private void idUserOtomatis(){
            try {
                    st = conn.createStatement();
                    sql = "SELECT * FROM tbluser order by idUser DESC";
                    rs = st.executeQuery(sql);
                      if (rs.next()) {
                           idUser = rs.getString("idUser").substring(4);
                           id = "" + (Integer.parseInt(idUser) + 1);
                           kosong = "";
                      if (id.length() == 1){
                           kosong = "00";    
                      } else if (id.length() == 2){
                           kosong = "0";
                      } else {
                          kosong = "";
                      }
                      txtFieldIDUser.setText("USER" + kosong + id);
                      } else {
                   txtFieldIDUser.setText("USER001");
                  }
                  rs.close();
                  st.close();
            } catch (NumberFormatException | SQLException e) {
        }
}
    
  public static boolean checkEmailIsReady(String email) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_uts_pbo2_21552011235", "root", "");
            String query = "SELECT * FROM tbluser WHERE email=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
            
            // Tutup koneksi dan statement
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
  }
  
  public static boolean checkValidateEmaill(String email) {
        String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";// Regular Expresion Email
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
  }
  
  public boolean checkValidatePassword(String password) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";  // Regular Expresion Password
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
  }
  
  private void btnDaftar(){
        String id = txtFieldIDUser.getText();
        String email = txtFieldEmail.getText();
        String pass = txtFieldPassword.getText();
        String confirmPass = txtFieldConfirmPassword.getText();
        String lvl = "";
        if (RBProduksi.isSelected()) {
            lvl = "Produksi";
        } else if (RBMarketing.isSelected()) {
            lvl = "Marketing";
        }
        String validatePass = txtFieldPassword.getText().toString();

        if (id.isEmpty() || email.isEmpty() || pass.isEmpty() || lvl.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Pastikan data telah terisi semua. Ulangi kembali!", "DATA BELUM TERISI !", JOptionPane.WARNING_MESSAGE);
        } else if (!confirmPass.equals(pass)) {
            JOptionPane.showMessageDialog(rootPane, "Pastikan Konfirmasi Password sesuai. Ulangi kembali!", "KONFIRMASI PASSWORD TIDAK SESUAI !", JOptionPane.WARNING_MESSAGE);
            titleConfirmPassword.setForeground (Color.red);
        }else{
            try {
            if (checkEmailIsReady(email)) {
               JOptionPane.showMessageDialog(rootPane, "Pastikan Email yang digunakan belum terdaftar, lakukan daftar kembali!. Ulangi kembali!", "EMAIL TELAH TERDAFTAR !", JOptionPane.WARNING_MESSAGE);
               titleEmail.setForeground (Color.red);
            }  else {
                  if (checkValidateEmaill(email)) {
                      JOptionPane.showMessageDialog(null, "Email siap digunakan!");
                      titleEmail.setForeground (Color.black);
                      JOptionPane.showMessageDialog(null, "Format email sudah benar!");
                      titleEmail.setForeground (Color.black);
                      
                      if (checkValidatePassword(validatePass)) { 
                      JOptionPane.showMessageDialog(null, "Password telah benar!");
                      titlePassword.setForeground (Color.black);
                      titleConfirmPassword.setForeground (Color.black);
                      sql = "INSERT INTO tbluser VALUES (?, ?, ?, ?)";
                      ps = conn.prepareStatement(sql);
                      ps.setString(1, id);
                      ps.setString(2, email);
                      ps.setString(3, pass);
                      ps.setString(4, lvl);
                      ps.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

                      Flogin21552011235 fl = new Flogin21552011235();
                      this.dispose();
                      fl.setVisible(true);
                      ps.close();
                      } else { 
                          JOptionPane.showMessageDialog(rootPane, "Pastikan isi password harus menggunakan gabungan huruf besar, huruf kecil  ,angka dan simbol. Ulangi kembali!", "PASSWORD LEMAH !", JOptionPane.WARNING_MESSAGE);
                          titlePassword.setForeground (Color.red);
                      }                                
        } else {
            JOptionPane.showMessageDialog(rootPane, "Pastikan isi format email dengan benar!", "FORMAT EMAIL SALAH !", JOptionPane.WARNING_MESSAGE);
            titleEmail.setForeground (Color.red);
        }
        }
                
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
  }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        titlePassword = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFieldPassword = new javax.swing.JPasswordField();
        titleEmail = new javax.swing.JLabel();
        btnKembali = new javax.swing.JLabel();
        txtFieldConfirmPassword = new javax.swing.JPasswordField();
        titleConfirmPassword = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnDaftar = new javax.swing.JLabel();
        RBProduksi = new javax.swing.JRadioButton();
        RBMarketing = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        txtFieldIDUser = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("____________________________________________________________");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" 21552011235_Albi Mudakar Nasyabi");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("DAFTAR FORM");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        titlePassword.setText("Password");
        jPanel1.add(titlePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("________________________________________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 370, 30));

        txtFieldEmail.setBorder(null);
        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 330, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("________________________________________________");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 370, 30));

        txtFieldPassword.setText("jPasswordField1");
        txtFieldPassword.setBorder(null);
        jPanel1.add(txtFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 330, 40));

        titleEmail.setText("Email");
        jPanel1.add(titleEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnKembaliDaftar.png"))); // NOI18N
        btnKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKembaliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKembaliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKembaliMouseExited(evt);
            }
        });
        jPanel1.add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, 40));

        txtFieldConfirmPassword.setText("jPasswordField1");
        txtFieldConfirmPassword.setBorder(null);
        txtFieldConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldConfirmPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 330, 40));

        titleConfirmPassword.setText("Konfirmasi Password");
        jPanel1.add(titleConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("________________________________________________");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 370, 30));

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
        jPanel1.add(btnDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 120, 40));

        buttonGroup1.add(RBProduksi);
        RBProduksi.setText("Produksi");
        RBProduksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBProduksiActionPerformed(evt);
            }
        });
        jPanel1.add(RBProduksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        buttonGroup1.add(RBMarketing);
        RBMarketing.setText("Marketing");
        RBMarketing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBMarketingActionPerformed(evt);
            }
        });
        jPanel1.add(RBMarketing, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("________________________________________________");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 370, 30));

        txtFieldIDUser.setBorder(null);
        txtFieldIDUser.setEnabled(false);
        txtFieldIDUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldIDUserActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldIDUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 340, 40));

        jLabel13.setText("ID User");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed

    private void btnKembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseEntered
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnKembaliDaftar.png")));
    }//GEN-LAST:event_btnKembaliMouseEntered

    private void btnKembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseExited
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnKembaliDaftar-hover.png")));
    }//GEN-LAST:event_btnKembaliMouseExited

    private void txtFieldConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldConfirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldConfirmPasswordActionPerformed

    private void btnDaftarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDaftarMouseEntered
        btnDaftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnDaftar.png")));
    }//GEN-LAST:event_btnDaftarMouseEntered

    private void btnDaftarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDaftarMouseExited
        btnDaftar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnDaftar-hover.png")));
    }//GEN-LAST:event_btnDaftarMouseExited

    private void btnKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseClicked
        Flogin21552011235 fL = new Flogin21552011235();
        fL.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliMouseClicked

    private void RBProduksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBProduksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBProduksiActionPerformed

    private void RBMarketingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBMarketingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBMarketingActionPerformed

    private void btnDaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDaftarMouseClicked
        btnDaftar();
    }//GEN-LAST:event_btnDaftarMouseClicked

    private void txtFieldIDUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldIDUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldIDUserActionPerformed

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
            java.util.logging.Logger.getLogger(FDaftar21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDaftar21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDaftar21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDaftar21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDaftar21552011235().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBMarketing;
    private javax.swing.JRadioButton RBProduksi;
    private javax.swing.JLabel btnDaftar;
    private javax.swing.JLabel btnKembali;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titleConfirmPassword;
    private javax.swing.JLabel titleEmail;
    private javax.swing.JLabel titlePassword;
    private javax.swing.JPasswordField txtFieldConfirmPassword;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldIDUser;
    private javax.swing.JPasswordField txtFieldPassword;
    // End of variables declaration//GEN-END:variables
}
