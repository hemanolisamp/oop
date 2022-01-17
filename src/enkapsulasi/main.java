/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enkapsulasi;

/**
 *
 * @author HP NOTEBOOK
 */
public class main {
    public static void main(String[] args)
    {
        hewan h = new hewan ();
        h.setnama("sapi");
        System.out.println("hewan :"+h.getnama());
        
        h.setbernafas("paru-paru");
        System.out.println("bernafas dengan :"+h.getbernafas());
    }
}
