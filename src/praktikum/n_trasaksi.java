/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

/**
 *
 * @author HP NOTEBOOK
 */
    public class n_trasaksi extends transaksi{
        public n_trasaksi()
        {
            
           super();
          //id="Tr12";
          //harga=5000;
          //jumlah=2;
          //pembayaran=20000;
        }
        double total()
        {
            return (getharga()*getjumlah());
        }
        double kembali()
        {
            return (getpembayaran()-total());
        }
}
