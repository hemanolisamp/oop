/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baru;

/**
 *
 * @author HP NOTEBOOK
 */
public class alat_musik {
  public String kode,stok,nama;
   public int harga;
    
    public alat_musik()
     {
       kode = "FF01";
       nama= "Cello";
       stok="19";
       harga = 1500000;
     }
   
    void setkode(String Kode)
    {
        this.kode=Kode;
    }
    void setnama(String Nama)
    {
        this.nama=Nama;
    }
    void setstok(String Stok)
    {
        this.stok=Stok;
    }
    void setharga(int Harga)
    {
        this.harga=Harga;
    }
    String getnama()
    {
        return nama;
    }
    String   getkode()
    {
        return kode;
    }
    String   getstok()
    {
        return stok;
    }
    int   getharga()
    {
        return harga;
    }
}
