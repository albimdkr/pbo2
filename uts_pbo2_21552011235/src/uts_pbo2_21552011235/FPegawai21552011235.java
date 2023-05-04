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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static uts_pbo2_21552011235.FDaftar21552011235.checkEmailIsReady;
import static uts_pbo2_21552011235.FDaftar21552011235.checkValidateEmaill;

/**
 *
 * @author albin
 */
public class FPegawai21552011235 extends javax.swing.JFrame {
    Connection conn = CKoneksi21552011235.getKoneksi();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    String sql, jk, kode, kosong ;
    
    public FPegawai21552011235() {
        initComponents();
        tampilDataPegawai ();
        updateComboidUser();
        updateComboidDivisi();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    
    private void kodePegawaiOtomatis(){
       
        String divisi = ((String) comboBoxNamaDivisi.getSelectedItem()).substring(0, 3).toUpperCase();
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String tglMasukKerja = dateFormat.format(dateTglMasukKerja.getDate());

        try {
            String sql = "SELECT MAX(kodePegawai) AS kodePegawai FROM tblpegawai";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Object[] obj = new Object[1];
                obj[0] = rs.getString("kodePegawai");
                if (obj[0] == null) {
                    // Jika data tidak ada, eksekusi 3 digit terakhir dengan nilai 001
                    String kodePegawai = divisi + tglMasukKerja + "001";
                    txtFieldKodePegawai.setText(kodePegawai);
                } else {
                    // Jika data ada, ekstrak nilai 3 digit terakhir dan tambahkan 1
                    String str_kd = (String) obj[0];
                    String kd = str_kd.substring(str_kd.length() - 3);
                    int int_code = Integer.parseInt(kd);
                    int_code++;
                    String a = String.format("%03d", int_code);
                    String kodePegawai = divisi + tglMasukKerja + a;
                    txtFieldKodePegawai.setText(kodePegawai);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
    }
}
  
 
  private void tampilDataPegawai (){

        try {
            if (txtFieldCari.getText().isEmpty())  {
                sql = "select * from tblpegawai";
            }else{
                sql = "SELECT * FROM tblpegawai WHERE "
                + "`kodePegawai` LIKE '%"+txtFieldCari.getText()+"%' OR"
                + "`nama`  LIKE '%"+txtFieldCari.getText()+"%' OR "
                + "`jk`  LIKE '%"+txtFieldCari.getText()+"%' OR "
                + "`tglMasuk`  LIKE '%"+txtFieldCari.getText()+"%' OR "
                + "`alamat`  LIKE '%"+txtFieldCari.getText()+"%' OR "
                + "`idUser`  LIKE '%"+txtFieldCari.getText()+"%' OR "
                + "`idDivisi` LIKE '%"+txtFieldCari.getText()+"%'";
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
            tablePegawai.setModel(model);
        } catch (SQLException e) {
        }
    }
  
  
  private void updateComboidUser(){
      sql = "select * from tbluser";
      try {
          st = conn.prepareStatement(sql);
          rs = st.executeQuery(sql);
          while (rs.next()){
              comboBoxIDUser.addItem(rs.getString("idUser"));
          }
      } catch(Exception e) {
      }
  }
  

    private void updateComboidDivisi(){
      sql = "select * from tbldivisi";
      try {
          st = conn.prepareStatement(sql);
          rs = st.executeQuery(sql);
          while (rs.next()){
              comboBoxNamaDivisi.addItem(rs.getString("namaDivisi"));
          }
      } catch(SQLException e) {
      }
  }
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtFieldKodePegawai = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBatal = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFieldAlamat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePegawai = new javax.swing.JTable();
        RBWanita = new javax.swing.JRadioButton();
        RBPria = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFieldNamaPegawai = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtFieldCari = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        comboBoxIDUser = new javax.swing.JComboBox<>();
        Divisi = new javax.swing.JLabel();
        comboBoxNamaDivisi = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        btnTambahDataPegawai = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        dateTglMasukKerja = new com.toedter.calendar.JDateChooser();

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("____________________________________________________________");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" 21552011235_Albi Mudakar Nasyabi");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Form Pegawai");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, 30));

        txtFieldKodePegawai.setBorder(null);
        txtFieldKodePegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldKodePegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldKodePegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 180, 40));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("_______________________________");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 240, 30));

        jLabel8.setText("Jenis Kelamin");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 180, -1));

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnBatal.png"))); // NOI18N
        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBatalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBatalMouseExited(evt);
            }
        });
        jPanel1.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, -1, 50));

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnSimpan.png"))); // NOI18N
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSimpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSimpanMouseExited(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, 50));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("_______________________________");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 240, 30));

        jLabel13.setText("Tanggal Masuk Kerja");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("____________________________________________________________________________");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 580, 30));

        txtFieldAlamat.setBorder(null);
        txtFieldAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldAlamatActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 490, 40));

        jLabel15.setText("Alamat");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        tablePegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePegawai);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 890, 210));

        buttonGroup1.add(RBWanita);
        RBWanita.setText("Wanita");
        RBWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBWanitaActionPerformed(evt);
            }
        });
        jPanel1.add(RBWanita, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 90, -1));

        buttonGroup1.add(RBPria);
        RBPria.setText("Pria");
        RBPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBPriaActionPerformed(evt);
            }
        });
        jPanel1.add(RBPria, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 80, -1));

        jLabel9.setText("Kode Pegawai");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("_______________________________");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 250, 30));

        jLabel17.setText("ID User");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 10));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("________________________________________");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 350, 30));

        txtFieldNamaPegawai.setBorder(null);
        txtFieldNamaPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldNamaPegawaiActionPerformed(evt);
            }
        });
        jPanel1.add(txtFieldNamaPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 280, 40));

        jLabel18.setText("Nama Pegawai");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, -1, -1));

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("________________________________________");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 320, 30));

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
        jPanel1.add(txtFieldCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, 240, 40));

        jLabel20.setText("Masukan Kata Kunci");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, -1, 10));

        jPanel1.add(comboBoxIDUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 190, -1));

        Divisi.setText("Nama Divisi");
        jPanel1.add(Divisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 10));

        jPanel1.add(comboBoxNamaDivisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 190, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("_______________________________");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 240, 30));

        btnTambahDataPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnTambahDataPegawai.png"))); // NOI18N
        btnTambahDataPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahDataPegawaiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTambahDataPegawaiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahDataPegawaiMouseExited(evt);
            }
        });
        jPanel1.add(btnTambahDataPegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 230, 50));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-back-to-24.png"))); // NOI18N
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 30, 50));

        dateTglMasukKerja.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dateTglMasukKerja, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 160, 190, 40));

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFieldKodePegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldKodePegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldKodePegawaiActionPerformed

    private void btnBatalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseEntered
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnBatal.png")));
    }//GEN-LAST:event_btnBatalMouseEntered

    private void btnBatalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseExited
        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnBatal-hover.png")));
    }//GEN-LAST:event_btnBatalMouseExited

    private void btnSimpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseEntered
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnSimpan.png")));
    }//GEN-LAST:event_btnSimpanMouseEntered

    private void btnSimpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseExited
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnSimpan-hover.png")));
    }//GEN-LAST:event_btnSimpanMouseExited

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        txtFieldKodePegawai.setText(null);
        txtFieldNamaPegawai.setText(null);
        buttonGroup1.clearSelection();
        txtFieldAlamat.setText(null);
        dateTglMasukKerja.setCalendar(null);      
    }//GEN-LAST:event_btnBatalMouseClicked

    private void txtFieldAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldAlamatActionPerformed

    private void RBPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBPriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBPriaActionPerformed

    private void RBWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBWanitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RBWanitaActionPerformed

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        if (txtFieldNamaPegawai.getText().isEmpty() || txtFieldAlamat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Pastikan data telah terisi. Ulangi kembali!", "DATA BELUM TERISI !", JOptionPane.WARNING_MESSAGE);
        } else {
            int ok = JOptionPane.showConfirmDialog (null," Apakah Anda Yakin Ingin "
            + "Mengedit Data ?","Konfirmasi Edit Data Pegawai", JOptionPane.YES_NO_OPTION);


            if (ok==0){
                try {
                sql = "UPDATE tblpegawai SET nama=?, jk=?, alamat=?, idUser=? WHERE kodePegawai=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, txtFieldNamaPegawai.getText());
                if (RBPria.isSelected()) {
                      jk = "Pria";
                  }else{
                      jk = "Wanita";
                  }
                ps.setString(2, jk);
                ps.setString(3, txtFieldAlamat.getText());
                ps.setString(4, (String) comboBoxIDUser.getSelectedItem());
                ps.setString(5, txtFieldKodePegawai.getText());
                
              
                ps.executeUpdate();
                tampilDataPegawai();
                JOptionPane.showMessageDialog(null , "Data Berhasil Di Edit");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Di Edit!!!"+e);
                }
            }
        }
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void tablePegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePegawaiMouseClicked
       int baris = tablePegawai.getSelectedRow();
            txtFieldKodePegawai.setText(tablePegawai.getValueAt(baris, 0).toString());
            txtFieldNamaPegawai.setText(tablePegawai.getValueAt(baris, 1).toString());
             if (tablePegawai.getValueAt(baris,2).toString().equals("Pria")){
                 RBPria.setSelected(true);
             } else {
                 RBWanita.setSelected(true);
             }
//          dateTglMasukKerja = dibawah (baris, 3)
            txtFieldAlamat.setText(tablePegawai.getValueAt(baris, 4).toString());
            String idus = tablePegawai.getValueAt(baris,5).toString();
            for (int i = 0; i <comboBoxIDUser.getItemCount(); i++ ){
                if (comboBoxIDUser.getItemAt(i).equalsIgnoreCase(idus)){
                    comboBoxIDUser.setSelectedIndex(i);
                }
            }
            
            String nd = tablePegawai.getValueAt(baris,6).toString();
            for (int i = 0; i <comboBoxNamaDivisi.getItemCount(); i++ ){
                if (comboBoxNamaDivisi.getItemAt(i).equalsIgnoreCase(nd)){
                    comboBoxNamaDivisi.setSelectedIndex(i);
                }
            }
            
            Date tglMsk = null;
            Object ex = null;
            try{
                tglMsk = new SimpleDateFormat("yyyy-MM-dd").parse((String)tablePegawai.getValueAt(baris,3).toString());
            }catch(ParseException e){  
                System.out.println(e);
                Logger.getLogger(FPegawai21552011235.class.getName()).log(Level.SEVERE, null, ex);
            }
            dateTglMasukKerja.setDate(tglMsk);

             
    }//GEN-LAST:event_tablePegawaiMouseClicked

    private void txtFieldNamaPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldNamaPegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldNamaPegawaiActionPerformed

    private void txtFieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCariActionPerformed

    private void txtFieldCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldCariKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCariKeyReleased

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-back-to-24.png")));
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/icons8-back-to-24-hover.png")));
    }//GEN-LAST:event_btnBackMouseExited

    private void btnTambahDataPegawaiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDataPegawaiMouseEntered
       btnTambahDataPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnTambahDataPegawai.png")));
    }//GEN-LAST:event_btnTambahDataPegawaiMouseEntered

    private void btnTambahDataPegawaiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDataPegawaiMouseExited
       btnTambahDataPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/btnTambahDataPegawai-hover.png")));
    }//GEN-LAST:event_btnTambahDataPegawaiMouseExited

    private void btnTambahDataPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDataPegawaiMouseClicked
        if (txtFieldNamaPegawai.getText().isEmpty() || txtFieldAlamat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data harus diisi semua!");
        }else{
            try {
                  kodePegawaiOtomatis();
//                  sql = "INSERT INTO tblpegawai VALUES (?, ?, ?, ?, ?, ?, ?)";
                  sql = "INSERT INTO tblpegawai (kodePegawai, nama, jk, tglMasuk, alamat, idUser, idDivisi) VALUES (?, ?, ?, ?, ?, ?, (SELECT idDivisi FROM tbldivisi WHERE namaDivisi = ?))";
                  ps = conn.prepareStatement(sql);
                  ps.setString(1, txtFieldKodePegawai.getText());
                  ps.setString(2, txtFieldNamaPegawai.getText());
                  if (RBPria.isSelected()) {
                      jk = "Pria";
                  }else{
                      jk = "Wanita";
                  }
                  ps.setString(3, jk);
                  SimpleDateFormat tglMsk = new SimpleDateFormat("yyyy-MM-dd");
                  String date = tglMsk.format(dateTglMasukKerja.getDate());
                  ps.setString( 4, date);
                  ps.setString(5, txtFieldAlamat.getText());
                  ps.setString(6, (String) comboBoxIDUser.getSelectedItem());
                  ps.setString(7, comboBoxNamaDivisi.getSelectedItem().toString());
//                  ps.setString(7, (String) comboBoxNamaDivisi.getSelectedItem());        
//                  String selectedValue = comboBoxNamaDivisi.getSelectedItem().toString(); // get the selected item from the JComboBox as a string
//                  int id = Integer.parseInt(selectedValue); // convert the selected value to an integer
//                  ps.setInt(7, id);

                  ps.executeUpdate();
                  tampilDataPegawai();
                  
                  
//                  FPegawai21552011235 fp = new FPegawai21552011235();
//                  this.dispose();
//                  fp.setVisible(true);
//                  ps.close();
                  JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                  } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnTambahDataPegawaiMouseClicked

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
            java.util.logging.Logger.getLogger(FPegawai21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPegawai21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPegawai21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPegawai21552011235.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FPegawai21552011235().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Divisi;
    private javax.swing.JRadioButton RBPria;
    private javax.swing.JRadioButton RBWanita;
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnSimpan;
    private javax.swing.JLabel btnTambahDataPegawai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboBoxIDUser;
    private javax.swing.JComboBox<String> comboBoxNamaDivisi;
    private com.toedter.calendar.JDateChooser dateTglMasukKerja;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePegawai;
    private javax.swing.JTextField txtFieldAlamat;
    private javax.swing.JTextField txtFieldCari;
    private javax.swing.JTextField txtFieldKodePegawai;
    private javax.swing.JTextField txtFieldNamaPegawai;
    // End of variables declaration//GEN-END:variables
}
