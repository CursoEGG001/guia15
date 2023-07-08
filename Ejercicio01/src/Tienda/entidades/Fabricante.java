/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.entidades;

/**
 *
 * @author pc
 */
public class Fabricante {
    
    private String Nombre;
    private int codigo;

    public Fabricante() {
    }

    public Fabricante(String Nombre, int codigo) {
        this.Nombre = Nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "fabricante{" + "Nombre=" + Nombre + ", codigo=" + codigo + '}';
    }
    
}
