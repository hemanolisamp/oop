/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

/**
 *
 * @author HP NOTEBOOK
 */
public class transaksi {
    public double harga, jumlah, pembayaran;
    public String id;
    
    public transaksi()
    {
        id="Tr12";
        harga=5000;
        jumlah=2;
        pembayaran=20000;
        
    }
    public void setid(String ID)
    {
        this.id=ID;
    }
    public String getid()
    {
        return id;
    }
    public void setharga (double n_harga)
    {
        this.harga=n_harga;
    }
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
    public void setpembayaran(double n_pembayaran)
    {
        this.pembayaran=n_pembayaran;
    }
    public double getpembayaran()
    {
        return (pembayaran);
    }
}
