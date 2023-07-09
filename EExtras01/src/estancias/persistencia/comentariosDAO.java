/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

import estancias.entidades.Comentarios;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author pc
 */
public class comentariosDAO extends DAO {

    public void guardarComentario(Comentarios comentario) throws Exception {
        try {
            if (comentario == null) {
                throw new Exception("Debe indicar el comentario");
            }

            String sql = "INSERT INTO Comentarios (id_casa) "
                    + "VALUES (" + comentario.getId_casa() + ")";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarComentario(int idComentario) throws Exception {
        try {
            String sql = "DELETE FROM Comentarios WHERE id_comentario = " + idComentario;

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public Collection<Comentarios> listarComentarios() throws Exception {
        try {
            String sql = "SELECT * FROM Comentarios";

            consultar(sql);

            Comentarios comentario = null;
            Collection<Comentarios> comentarios = new ArrayList<>();
            while (resultado.next()) {
                comentario = new Comentarios();
                comentario.setId_comentario(resultado.getInt(1));
                comentario.setId_casa(resultado.getInt(2));
                comentarios.add(comentario);
            }
            desconectar();
            return comentarios;
        } catch (Exception e) {
            e.printStackTrace();
            desconectar();
            throw new Exception("Error de sistema");
        }
    }
}
