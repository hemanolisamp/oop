/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

/**
 *
 * @author HP NOTEBOOK
 */
public class barang {
   barang()
    {
       kode = "FF001";
       nama = "Thai tea";
       stok = "10";
       harga = "100000";
    }
    private String kode,nama,stok,harga;
   
    public void setkode(String code) 
    {
      this.kode=code;  
    }
    public void setnama(String name) 
    {
     this.nama=name;    
    }
    public void setstok(String stock)
    {
        this.stok=stock;
    }
    public void setharga(String price)
    {
        this.harga=price;
    }
     public String getkode()
     {
        return kode;
     }
     public String getnama()
     {
         return nama;
     }
     public String getstok()
     {
         return stok;
     }
     public String getharga()
     {
         return harga;
     }
}
