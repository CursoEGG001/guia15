/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

/**
 *
 * @author pc
 */


import estancias.entidades.estancias;
import estancias.persistencia.estanciasDAO;
import java.util.Collection;

/**
 * Clase que proporciona servicios relacionados con las estancias.
 */
public class EstanciasServicios {

    private estanciasDAO dao;

    public EstanciasServicios() {
        this.dao = new estanciasDAO();
    }

    /**
     * Guarda una estancia en la base de datos.
     * 
     * @param estancia La estancia a guardar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void guardarEstancia(estancias estancia) throws Exception {
        try {
            dao.guardarEstancia(estancia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica una estancia en la base de datos.
     * 
     * @param estancia La estancia a modificar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void modificarEstancia(estancias estancia) throws Exception {
        try {
            dao.modificarEstancia(estancia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina una estancia de la base de datos.
     * 
     * @param idEstancia El ID de la estancia a eliminar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void eliminarEstancia(int idEstancia) throws Exception {
        try {
            dao.eliminarEstancia(idEstancia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una estancia de la base de datos por su ID.
     * 
     * @param idEstancia El ID de la estancia.
     * @return La estancia encontrada, o null si no se encontró ninguna estancia con el ID indicado.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public estancias buscarEstanciaPorId(int idEstancia) throws Exception {
        try {
            return dao.buscarEstanciaPorId(idEstancia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una colección de todas las estancias en la base de datos.
     * 
     * @return La colección de estancias.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public Collection<estancias> listarEstancias() throws Exception {
        try {
            return dao.listarEstancias();
        } catch (Exception e) {
            throw e;
        }
    }
}
