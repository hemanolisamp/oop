/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_;

/**
 *
 * @author HP NOTEBOOK
 */
public class mobil implements lampu{
    public void gas()
    {
        System.out.println("Mobil berjalan");
    }
    public void rem()
    {
        System.out.println("Kecepatan Mobil Berkurang");
    }
    public void klakson()
    {
        System.out.println("Bel Mobil berbunyi");
    }

    @Override
    public void seton()
    {
        System.out.println("Lampu Menyala");
    }

    @Override
    public void setoff() {
        System.out.println("Lampu Mati");
    }
    public static void main(String[] args)
    {
            mobil obj = new mobil();
            obj.gas();
            obj.rem();
            obj.klakson();
            obj.seton();
            obj.setoff();
     }    
}
