/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum;

/**
 *
 * @author HP NOTEBOOK
 */
public class cetak {
  public static void main(String[] args) 
    {
       barang obj = new barang(); 
       obj.setkode("FF001"); 
       obj.setnama("Thai Tea");
       obj.setstok("10");
       obj.setharga("100000");
        
        System.out.println("Kode Barang ="+ obj.getkode());
        System.out.println("Nama Barang ="+ obj.getnama());
        System.out.println("Stok Barang ="+ obj.getstok());
        System.out.println("Harga Barang ="+ obj.getharga());
    }
}
