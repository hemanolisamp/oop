/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author HP NOTEBOOK
 */
public class GUI_transaksimusik extends javax.swing.JFrame {

    /**
     * Creates new form GUI_transaksimusik
     */
    public GUI_transaksimusik() {
        initComponents();
                tampil();
    }

      public Connection conn;
    
public void koneksi() throws SQLException {
        try {
            conn=null;
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/1718027_pratikan?user=root&password=");
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(GUI_transaksimusik.class.getName()).log(Level.SEVERE,null, ex);
        } 
        catch (SQLException e) 
        {
            Logger.getLogger(GUI_transaksimusik.class.getName()).log(Level.SEVERE,null, e);
        } 
        catch (Exception es) 
        {
        Logger.getLogger(GUI_transaksimusik.class.getName()).log(Level.SEVERE,null, es);
        }
    }

public void refresh()
    {
        new GUI_transaksimusik().setVisible(true);
        this.setVisible(false);
    }

        public void tampil() {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID");
        tabelhead.addColumn("KODE");
        tabelhead.addColumn("NAMA");
        tabelhead.addColumn("HARGA");
        tabelhead.addColumn("JUMLAH");
        tabelhead.addColumn("TOTAL");
        tabelhead.addColumn("BAYAR");
        tabelhead.addColumn("KEMBALI");
        try {
            koneksi();
            String sql = "select * from tb_transaksimusik";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while(res.next()){
                tabelhead.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),
                res.getString(4),res.getString(5),res.getString(6), res.getString(7), 
                res.getString(8)});
            }
            table_data.setModel(tabelhead);
        } catch (Exception e) {
        }
    }

public void insert(){
        String id = txt_id.getText();
        String kode = txt_kode.getText();
        String nama = txt_nama.getText();
        String harga = txt_harga.getText();
        String jumlah = txt_jumlah.getText();
        String total = txt_total.getText();
        String bayar = txt_bayar.getText();
        String kembalian = txt_kembalian.getText();
        try 
        {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_transaksimusik(ID, KODE, NAMA, HARGA, JUMLAH, TOTAL, BAYAR, KEMBALI)values('"+id+"','"+kode+"','"+nama+"','"+harga+"','"+jumlah+"','"+total+"'"+ ",'"+bayar+"','"+kembalian+"')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Memasukkan Transaksi Baru!");
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Transaksi Gagal!");
        }
        refresh();
    }
     
public void update(){
        String id = txt_id.getText();
        String jumlah = txt_jumlah.getText();
        String total = txt_total.getText();
        String bayar = txt_bayar.getText();
        String kembalian = txt_kembalian.getText();
        try 
        {
            Statement statement = conn.createStatement();
            statement.executeUpdate("update tb_transaksimusik set ID ='"+id+"',"
              + "JUMLAH='"+jumlah+"',TOTAL='"+total+"',BAYAR='"+bayar+"',KEMBALI='"+kembalian+"' " + "where ID = '"+id+"'");
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Berhasil Merubah Transaksi!");
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        refresh();
    }
         
        public void delete(){
        int ok=JOptionPane.showConfirmDialog(null,"Anda Yakin Menghapus Data ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            try
            {
                String sql="delete from tb_transaksimusik where ID='"+txt_id.getText()+"'";
                java.sql.PreparedStatement
                stmt=conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil di hapus");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Data gagal di hapus");
            }
        }
        refresh();
    }
        
        public void cariID(){
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("ID");
        tabelhead.addColumn("KODE");
        tabelhead.addColumn("NAMA");
        tabelhead.addColumn("HARGA");
        tabelhead.addColumn("JUMLAH");
        tabelhead.addColumn("TOTAL");
        tabelhead.addColumn("BAYAR");
        tabelhead.addColumn("KEMBALI");
        try
        {
        koneksi();
        Statement statement=conn.createStatement();
        String sql="SELECT * FROM tb_transaksimusik WHERE `ID` like '%"+txt_cari.getText()+"%'";
        ResultSet rs=statement.executeQuery(sql);
        if(rs.next())
        {
        txt_id.setText(rs.getString(1));
        txt_kode.setText(rs.getString(2));
        txt_nama.setText(rs.getString(3));
        txt_harga.setText(rs.getString(4));
        txt_jumlah.setText(rs.getString(5));
        txt_total.setText(rs.getString(6));
        txt_bayar.setText(rs.getString(7));
	txt_kembalian.setText(rs.getString(8));
        }
        else{
            JOptionPane.showMessageDialog(null, "ID penjualan yang Anda cari tidak ada");
        }
        statement.close();
        }
        catch (Exception e)
        {
            System.out.println("Error."+e);
        } 
    }
        
    public void carikode(){
       try {
           koneksi();
           Statement statement = conn.createStatement(); {
           String sql="select * from tb_transaksimusik where KODE like '%"+txt_kode.getText()+"%'";
           ResultSet rs=statement.executeQuery(sql);
            if(rs.next())
            {
                txt_kode.setText(rs.getString(2));
                txt_nama.setText(rs.getString(3));
                txt_harga.setText(rs.getString(4));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Barang yang ada cari tidak ada!");
            }
            statement.close();
            }
       }
        catch(Exception ex)
        {
                System.out.println("Error."+ex);
        } 
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_jumlah = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_bayar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_hitung = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_proses = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_harga = new javax.swing.JTextField();
        txt_cari = new javax.swing.JTextField();
        btn_cari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_riset = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_tokomusik = new javax.swing.JButton();
        btn_kode = new javax.swing.JButton();
        txt_kode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 20)); // NOI18N
        jLabel1.setText("TRANSAKSI ALAT MUSIK");

        jLabel2.setText("ID TRANSAKSI KONSUMEN");

        jLabel3.setText("HARGA ");

        btn_hitung.setText("HITUNG");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        jLabel4.setText("JUMLAH PEMBELIAN ALAT MUSIK");

        btn_proses.setText("PROSES");
        btn_proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prosesActionPerformed(evt);
            }
        });

        jLabel5.setText("TOTAL HARGA");

        jLabel6.setText("UANG DIBAYAR");

        jLabel7.setText("UANG KEMBALIAN");

        btn_cari.setText("CARI ID");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "KODE", "NAMA", "HARGA", "JUMLAH", "TOTAL", "DIBAYAR", "KEMBALI"
            }
        ));
        jScrollPane1.setViewportView(table_data);

        btn_insert.setText("INSERT");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_riset.setText("RISET");
        btn_riset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_risetActionPerformed(evt);
            }
        });

        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_tokomusik.setText("TOKO ALAT MUSIK ====>>");
        btn_tokomusik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tokomusikActionPerformed(evt);
            }
        });

        btn_kode.setText("CARI KODE");
        btn_kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kodeActionPerformed(evt);
            }
        });

        jLabel8.setText("NAMA ALAT MUSIK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cari)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(btn_kode)
                                        .addComponent(jLabel8))
                                    .addGap(31, 31, 31))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(89, 89, 89)))
                            .addComponent(jLabel5)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btn_insert)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update)
                        .addGap(32, 32, 32)
                        .addComponent(btn_riset)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addContainerGap(64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_tokomusik)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btn_hitung))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(btn_proses)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_cari)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_insert)
                            .addComponent(btn_update)
                            .addComponent(btn_riset)
                            .addComponent(btn_delete)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_kode))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(btn_hitung)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_tokomusik)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_proses)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addContainerGap(52, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
      try{
        n_alat_musik obj = new n_alat_musik();

        obj.setid(txt_id.getText());
        obj.setharga(Double.parseDouble(txt_harga.getText()));
        obj.setjumlah(Double.parseDouble(txt_jumlah.getText()));
        
        txt_total.setText(Double.toString(obj.total()));
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, "salah inputan");
      }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btn_prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prosesActionPerformed
       try{
        n_alat_musik obj = new n_alat_musik();

        obj.setharga(Double.parseDouble(txt_harga.getText()));
        obj.setjumlah(Double.parseDouble(txt_jumlah.getText()));
        txt_total.setText(Double.toString(obj.total()));
        obj.setpembayaran(Double.parseDouble(txt_bayar.getText()));
        txt_kembalian.setText(Double.toString(obj.kembali()));
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "salah input");
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_prosesActionPerformed

    private void btn_tokomusikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tokomusikActionPerformed
       GUI_alatmusik obj = new GUI_alatmusik();
        obj.show();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tokomusikActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        insert();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        update();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_risetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_risetActionPerformed
    
        txt_id.setText("");
        txt_kode.setText("");
        txt_nama.setText("");
        txt_harga.setText("");
        txt_jumlah.setText("");
        txt_total.setText("");
        txt_bayar.setText("");
        txt_kembalian.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_risetActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        cariID();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kodeActionPerformed
        carikode();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kodeActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_transaksimusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_transaksimusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_transaksimusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_transaksimusik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_transaksimusik().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_kode;
    private javax.swing.JButton btn_proses;
    private javax.swing.JButton btn_riset;
    private javax.swing.JButton btn_tokomusik;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_data;
    private javax.swing.JTextField txt_bayar;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kembalian;
    private javax.swing.JTextField txt_kode;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
