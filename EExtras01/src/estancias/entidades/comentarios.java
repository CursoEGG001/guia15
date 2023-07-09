/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.entidades;

/**
 *
 * @author pc
 */
public class comentarios {
    
    private int Id_casa;
    private int Id_comentario;
    private String comentario;

    public comentarios() {
    }

    public comentarios(int Id_casa, int Id_comentario, String comentario) {
        this.Id_casa = Id_casa;
        this.Id_comentario = Id_comentario;
        this.comentario = comentario;
    }

    public int getId_casa() {
        return Id_casa;
    }

    public void setId_casa(int Id_casa) {
        this.Id_casa = Id_casa;
    }

    public int getId_comentario() {
        return Id_comentario;
    }

    public void setId_comentario(int Id_comentario) {
        this.Id_comentario = Id_comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "comentarios{" + "Id_casa=" + Id_casa + ", Id_comentario=" + Id_comentario + ", comentario=" + comentario + '}';
    }


    
}
