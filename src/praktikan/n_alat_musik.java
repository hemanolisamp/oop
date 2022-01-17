/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikan;

/**
 *
 * @author HP NOTEBOOK
 */
public class n_alat_musik  extends transaksi_alatmusik {
    public n_alat_musik()
     {
       kode_alatmusik = "FF01";
       nama_alatmusik = "cello";
       stok="19";
       harga = 15000000;
     }
    @Override
    double total()
     {
      return (getharga()*getjumlah());
     }
    @Override
    double kembali()
     {
      return (getpembayaran()-total());
     }
}
