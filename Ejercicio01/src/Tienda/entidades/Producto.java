/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.entidades;

/**
 *
 * @author pc
 */
public class Producto {

    private int codigo, codigo_fabricante;
    private String nombre;
    private Double precio;

    public Producto() {
    }

    public Producto(int codigo, int codigo_fabricante, String nombre, Double precio) {
        this.codigo = codigo;
        this.codigo_fabricante = codigo_fabricante;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "producto{" + "codigo=" + codigo + ", codigo_fabricante=" + codigo_fabricante + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
}
