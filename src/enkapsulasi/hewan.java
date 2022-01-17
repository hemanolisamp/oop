/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package enkapsulasi;

/**
 *
 * @author HP NOTEBOOK
 */
public class hewan {
    private String nama,bernafas;
    public String getnama()
    {
        return nama;
    }
    public String getbernafas()
    {
        return bernafas;
    }
    public void setnama(String name)
    {
       this.nama=name;
    }
    public void setbernafas(String breath)
    {
        this.bernafas=breath;
    }
}
