/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package baru;

/**
 *
 * @author HP NOTEBOOK
 */
public class main {
    public static void main(String[]args)
    {
        alat_musik obj = new alat_musik();
        
        obj.setkode("19HM");
        obj.setnama("Cello");
        obj.setharga(25000000);
        
        System.out.println("Kode = "+obj.getkode());
        System.out.println("Nama = "+obj.getnama());
        System.out.println("Harga = "+"Rp. "+obj.getharga());
        
        obj.setkode("10HM");
        obj.setnama("Biola");
        obj.setharga(2000000);
        
        System.out.println("\n"+"Kode = "+obj.getkode());
        System.out.println("Nama = "+obj.getnama());
        System.out.println("Harga = "+"Rp. "+obj.getharga());
    }
}
