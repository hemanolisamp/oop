/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package overloding;

/**
 *
 * @author Mark Lee
 *
 *
 */
public class main {
       public static void main(String[] args) {
        hitung obj = new hitung();
        
        System.out.println("Hasil dari Method non parameter="+ obj.penjumlahan());
        System.out.println("--------------------------------------------------");
        System.out.println("Hasil dari Method dengan parameter="+ obj.penjumlahan(10, 10));
    }
}
