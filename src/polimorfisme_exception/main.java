/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfisme_exception;

/**
 *
 * @author HP NOTEBOOK
 */
public class main {
    
     public static void main(String[] args) {
              
        ibu rt = new ibu_rumah_tangga();
        ibu oop;
        System.out.println("Pekerjaan Ibu Ketika Di Rumah:"+rt.pekerjaan());
        rt.pekerjaan();
        
        
        System.out.println("------------------------------");
        
        ibu gr = new ibu_guru();
        System.out.println("Pekerjaan Ibu Ketika Menjadi Guru:"+gr.pekerjaan());
        gr.pekerjaan();
    }

}
