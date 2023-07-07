/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase15.dominio.entidad;

/**
 *
 * @author pc
 */
public class GamaProducto {

    private int Id;
    protected String Gama;
    protected String DescripcionTexto;
    protected String DescripcionHtml;
    protected String Imagen;
    
    public GamaProducto() {
    }

    public String getGama() {
        return Gama;
    }

    public void setGama(String Gama) {
        this.Gama = Gama;
    }

    public String getDescripcionTexto() {
        return DescripcionTexto;
    }

    public void setDescripcionTexto(String DescripcionTexto) {
        this.DescripcionTexto = DescripcionTexto;
    }

    public String getDescripcionHtml() {
        return DescripcionHtml;
    }

    public void setDescripcionHtml(String DescripcionHtml) {
        this.DescripcionHtml = DescripcionHtml;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "GamaProducto{" + "Id=" + Id + ", Gama=" + Gama + ", DescripcionTexto=" + DescripcionTexto + ", DescripcionHtml=" + DescripcionHtml + ", Imagen=" + Imagen + '}';
    }


}
