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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static uts_pbo2_21552011235.FDaftar21552011235.checkEmailIsReady;
import static uts_pbo2_21552011235.FDaftar21552011235.checkValidateEmaill;

/**
 *
 * @author albin
 */
public class FUser21552011235 extends javax.swing.JFrame {
    Connection conn = CKoneksi21552011235.getKoneksi();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    String sql, idUser, level, id, kosong;
    
    public FUser21552011235() {
        initComponents();
        idUserOtomatis();
        tampilDataUser ();
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
 
  private void tampilDataUser (){
        try {
            if (txtFieldCari.getText().isEmpty()) {
                sql = "select * from tbluser";
            }else{
                sql = "SELECT * FROM tbluser WHERE "
                + "`idUser` LIKE '%"+txtFieldCari.getText()+"%' OR"
                + "`email`  LIKE '%"+txtFieldCari.getText()+"%' OR "
                + "`password` LIKE '%"+txtFieldCari.getText()+"%' OR"
                + "`level` LIKE '%"+txtFieldCari.getText()+"%'";
            }
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            DefaultTableModel model = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
               model.addColumn(metaData.getColumnName(i));
            }
            while (rs.next()) {
               Object[] row = new Object[columnCount];
               for (int i = 1; i <= columnCount; i++) {
                  row[i - 1] = rs.getObject(i);
               }
               model.addRow(row);
            }
            tableUser.setModel(model);
        } catch (Exception e) {
        }
    }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFieldIDUser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JLabel();
        btnTambahDataUser = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFieldPassword = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        RBMarketing = new javax.swing.JRadioButton();
        RBProduksi = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtFieldCari = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("____________________________________________________________");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" 21552011235_Albi Mudakar Nasyabi");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Form User");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        txtFieldIDUser.setBorder(null);
        txtFieldIDUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldIDUserActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldIDUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 180, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("_______________________________");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 240, 30));

        jLabel8.setText("Level");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 60, 60, -1));

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
        jPanel1.add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, 40));

        btnTambahDataUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnTambahDataUser.png"))); // NOI18N
        btnTambahDataUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahDataUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTambahDataUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahDataUserMouseExited(evt);
            }
        });
        jPanel1.add(btnTambahDataUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 40));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("_______________________________");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 240, 30));

        txtFieldEmail.setBorder(null);
        txtFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 180, 40));

        jLabel13.setText("Email");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("_______________________________");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 240, 30));

        txtFieldPassword.setBorder(null);
        txtFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 180, 40));

        jLabel15.setText("Password");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
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
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUser);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 480, 140));

        buttonGroup1.add(RBMarketing);
        RBMarketing.setText("Marketing");
        RBMarketing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBMarketingActionPerformed(evt);
            }
        });
        jPanel1.add(RBMarketing, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 100, 90, -1));

        buttonGroup1.add(RBProduksi);
        RBProduksi.setText("Produksi");
        RBProduksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBProduksiActionPerformed(evt);
            }
        });
        jPanel1.add(RBProduksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 100, 80, -1));

        jLabel9.setText("ID User");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("____________________________________________________________________");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 500, 30));

        txtFieldCari.setBorder(null);
        txtFieldCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCariActionPerformed(evt);
            }
        });
        txtFieldCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldCariKeyReleased(evt);
            }
        });
        jPanel1.add(txtFieldCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 450, 40));

        jLabel17.setText("Masukan Kata Kunci");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 10));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-back-to-24.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldIDUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldIDUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldIDUserActionPerformed

    private void btnKembaliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseEntered
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnKembaliDaftar.png")));
    }//GEN-LAST:event_btnKembaliMouseEntered

    private void btnKembaliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseExited
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnKembaliDaftar-hover.png")));
    }//GEN-LAST:event_btnKembaliMouseExited

    private void btnTambahDataUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDataUserMouseEntered
        btnTambahDataUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnTambahDataUser.png")));
    }//GEN-LAST:event_btnTambahDataUserMouseEntered

    private void btnTambahDataUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDataUserMouseExited
        btnTambahDataUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnTambahDataUser-hover.png")));
    }//GEN-LAST:event_btnTambahDataUserMouseExited

    private void btnKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKembaliMouseClicked
        FMenuUtama21552011235 fm = new FMenuUtama21552011235();
        fm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKembaliMouseClicked

    private void txtFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldEmailActionPerformed

    private void txtFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldPasswordActionPerformed

    private void RBProduksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBProduksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBProduksiActionPerformed

    private void RBMarketingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBMarketingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBMarketingActionPerformed

    private void txtFieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCariActionPerformed

    private void btnTambahDataUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDataUserMouseClicked
        if (txtFieldEmail.getText().isEmpty() || txtFieldPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
        }else{
            try {
             // cek email
            if (checkEmailIsReady(txtFieldEmail.getText())) { 
               JOptionPane.showMessageDialog(null, "Email telah terdaftar, lakukan registrasi kembali!");
               txtFieldEmail.setBackground(Color.red);
            }  else {
                  if (checkValidateEmaill(txtFieldEmail.getText())) {
                      JOptionPane.showMessageDialog(null, "Email siap digunakan!");
                      txtFieldEmail.setBackground(Color.green);
                      JOptionPane.showMessageDialog(null, "Format email sudah benar!");
                      txtFieldEmail.setBackground(Color.green); 
                      
                      String password = txtFieldPassword.getText().toString();
                      if (checkValidatePassword(password)) { 
                      JOptionPane.showMessageDialog(null, "Password telah benar!");
//                    txtKodeUser.setBackground(Color.green);
//                    txtUsernameEmail.setBackground(Color.green);
                     txtFieldPassword.setBackground(Color.green);
                      sql = "INSERT INTO tbluser VALUES (?, ?, ?, ?)";
                      ps = conn.prepareStatement(sql);
                      ps.setString(1, txtFieldIDUser.getText());
                      ps.setString(2, txtFieldEmail.getText());
                      ps.setString(3, txtFieldPassword.getText());
                      if (RBProduksi.isSelected()) {
                            level = "Produksi";
                      }else{
                            level = "Marketing";
                      }
                      ps.setString(4, level);
                      ps.executeUpdate();
                      JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

                      FUser21552011235 fu = new FUser21552011235();
                      this.dispose();
                      fu.setVisible(true);
                      ps.close();
                      } else { 
                          JOptionPane.showMessageDialog(null, "Password harus menggunakan gabungan huruf besar, huruf kecil  ,angka dan simbol. Ulangi kembali!");
                          txtFieldPassword.setBackground(Color.red);
                      }                                
        } else {
            JOptionPane.showMessageDialog(null, "Format email salah, harap isi dengan benar!");
            txtFieldEmail.setBackground(Color.red);
        }
        }
                
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnTambahDataUserMouseClicked

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
       int baris = tableUser.getSelectedRow();
            txtFieldIDUser.setText(tableUser.getValueAt(baris, 0).toString());
            txtFieldEmail.setText(tableUser.getValueAt(baris, 1).toString());
            txtFieldPassword.setText(tableUser.getValueAt(baris, 2).toString());
             if (tableUser.getValueAt(baris,3).toString().equals("Produksi")){
                 RBProduksi.setSelected(true);
             } else {
                 RBMarketing.setSelected(true);
             }
             
    }//GEN-LAST:event_tableUserMouseClicked

    private void txtFieldCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCariKeyReleased
       tampilDataUser();
    }//GEN-LAST:event_txtFieldCariKeyReleased

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-back-to-24.png")));
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-back-to-24-hover.png")));
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        FMenuUtama21552011235 fm = new FMenuUtama21552011235();
        fm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

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
            java.util.logging.Logger.getLogger(FUser21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FUser21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FUser21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FUser21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FUser21552011235().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RBMarketing;
    private javax.swing.JRadioButton RBProduksi;
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnKembali;
    private javax.swing.JLabel btnTambahDataUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextField txtFieldCari;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldIDUser;
    private javax.swing.JTextField txtFieldPassword;
    // End of variables declaration//GEN-END:variables
}
