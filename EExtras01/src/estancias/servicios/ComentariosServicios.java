/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

import estancias.entidades.comentarios;
import estancias.persistencia.comentariosDAO;
import java.util.Collection;
/**
 *
 * @author pc
 */

/**
 * Clase que proporciona servicios relacionados con los comentarios.
 */
public class ComentariosServicios {

    private comentariosDAO dao;

    public ComentariosServicios() {
        this.dao = new comentariosDAO();
    }

    /**
     * Guarda un comentario en la base de datos.
     * 
     * @param comentario El comentario a guardar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void guardarComentario(comentarios comentario) throws Exception {
        try {
            dao.guardarComentario(comentario);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un comentario de la base de datos.
     * 
     * @param idComentario El ID del comentario a eliminar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void eliminarComentario(int idComentario) throws Exception {
        try {
            dao.eliminarComentario(idComentario);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una colección de todos los comentarios en la base de datos.
     * 
     * @return La colección de comentarios.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public Collection<comentarios> listarComentarios() throws Exception {
        try {
            return dao.listarComentarios();
        } catch (Exception e) {
            throw e;
        }
    }
}
