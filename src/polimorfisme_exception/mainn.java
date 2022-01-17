/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfisme_exception;

/**
 *
 * @author HP NOTEBOOK
 */
public class mainn {
    public static void main(String[] args)
    {
        hewan oop;
        kucing k = new kucing();
        oop = k;
        oop.suara();
        oop.makan();
        
        ayam a = new ayam();
        oop = a;
        oop.suara();
        oop.makan();
    }
}
