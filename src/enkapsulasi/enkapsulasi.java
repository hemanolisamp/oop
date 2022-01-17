/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enkapsulasi;

/**
 *
 * @author HP NOTEBOOK
 */
public class enkapsulasi {
    private String kode;
    public String nama;
     
    void setkode(String code)
    {
        this.kode=code;
    }
    String gethasil()
    {
        return "#"+kode+nama;
    }
}
