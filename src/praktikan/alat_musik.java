/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikan;

/**
 *
 * @author HP NOTEBOOK
 */
public class alat_musik {
    public String stok,kode_alatmusik,nama_alatmusik;
    public double harga,pembelian,pembayaran;
    
    public alat_musik()
     {
       kode_alatmusik = "FF01";
       nama_alatmusik = "cello";
       stok="19";
       harga = 1500000;
     }
    
    public void setkode(String code) 
     {
      this.kode_alatmusik=code;  
     }
    public String getkode()
     {
      return kode_alatmusik;
     }
    public void setnama(String name) 
     {
      this.nama_alatmusik=name;    
     }
    public String getnama()
     {
      return nama_alatmusik;
     }
    public void setstok(String stock)
     {
      this.stok=stock;
     }
    public String getstok()
     {
      return stok;
     }
    public void setharga(double price)
     {
      this.harga=price;
     }
    public double getharga()
     {
      return (harga);
     }
    public void setpembelian(double n_pembelian)
     {
      this.pembelian=n_pembelian;
     }
    public double getpembelian()
     {
      return (pembelian);
     }
    public void setpembayaran(double n_pembayaran)
     {
      this.pembayaran=n_pembayaran;
     }
    public double getpembayaran()
     {
      return (pembayaran);
     }
}
