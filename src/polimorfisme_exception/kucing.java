/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package polimorfisme_exception;

/**
 *
 * @author HP NOTEBOOK
 */
public class kucing extends hewan{

    @Override
    void suara() {
        System.out.println("gug gug gug");
    }

    @Override
    void makan() {
        System.out.println("teman");    
    }
    
}
