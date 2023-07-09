/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.entidades;

/**
 *
 * @author pc
 */
public class familias {
    
    private int Id_familia;
    private String Nombre;
    private int Edad_maxima;
    private int Edad_minima;
    private String Email;
    private int Num_hijos;
    private int Id_casa_familia;

    public familias() {
    }

    public familias(int Id_familia, String Nombre, int Edad_maxima, int Edad_minima, String Email, int Num_hijos, int Id_casa_familia) {
        this.Id_familia = Id_familia;
        this.Nombre = Nombre;
        this.Edad_maxima = Edad_maxima;
        this.Edad_minima = Edad_minima;
        this.Email = Email;
        this.Num_hijos = Num_hijos;
        this.Id_casa_familia = Id_casa_familia;
    }



    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad_maxima() {
        return Edad_maxima;
    }

    public void setEdad_maxima(int Edad_maxima) {
        this.Edad_maxima = Edad_maxima;
    }

    public int getEdad_minima() {
        return Edad_minima;
    }

    public void setEdad_minima(int Edad_minima) {
        this.Edad_minima = Edad_minima;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getNum_hijos() {
        return Num_hijos;
    }

    public void setNum_hijos(int Num_hijos) {
        this.Num_hijos = Num_hijos;
    }

    public int getId_casa_familia() {
        return Id_casa_familia;
    }

    public void setId_casa_familia(int Id_casa_familia) {
        this.Id_casa_familia = Id_casa_familia;
    }

    @Override
    public String toString() {
        return "familias{" + "Nombre=" + Nombre + ", Edad_maxima=" + Edad_maxima + ", Edad_minima=" + Edad_minima + ", Email=" + Email + ", Num_hijos=" + Num_hijos + ", Id_casa_familia=" + Id_casa_familia + '}';
    }

    public int getId_familia() {
        return Id_familia;
    }

    public void setId_familia(int Id_familia) {
        this.Id_familia = Id_familia;
    }


    
}
