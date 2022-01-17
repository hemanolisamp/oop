/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abstrak;

/**
 *
 * @author HP NOTEBOOK
 */
public class kelinci extends hewan{

    @Override
    void setnama() {
        System.out.println("namanya: kutil babi");
       
    }

    @Override
    void setmakanan() {
        System.out.println("makannya: temen");
       
    }
    public static void main(String[] args){
        kelinci obj = new kelinci();
        
        obj.setnama();
        obj.setmakanan();
        
        System.out.println("kecepatan lari kelinci = "+obj.cepatlari()+"km/jam");
    }
}
