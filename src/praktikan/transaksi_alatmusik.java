/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikan;

/**
 *
 * @author HP NOTEBOOK
 */
public abstract class transaksi_alatmusik extends alat_musik{
    public double harga, jumlah, pembayaran;
    public String id;
    
    public transaksi_alatmusik()
    {
       id     = "FF01";
       harga  = 1500000;
       jumlah =19;
       pembayaran  = 1600000;
    }
    public void setid(String ID)
    {
        this.id=ID;
    }
    public String getid()
    {
        return id;
    }
    @Override
    public void setharga (double n_harga)
    {
        this.harga=n_harga;
    }
    @Override
    public double getharga()
    {
        return (harga);
    }
    public void setjumlah(double n_jumlah)
    {
        this.jumlah=n_jumlah;
    }
    public double getjumlah()
    {
        return (jumlah);
    }
    @Override
    public void setpembayaran(double n_pembayaran)
    {
        this.pembayaran=n_pembayaran;
    }
    @Override
    public double getpembayaran()
    {
        return (pembayaran);
    }
    double total()
     {
      return harga*jumlah;
     }
    double kembali()
     {
      return pembayaran-total();
     }

}
