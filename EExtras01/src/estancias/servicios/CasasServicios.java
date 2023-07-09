/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

/**
 *
 * @author pc
 */


import estancias.entidades.casas;
import estancias.persistencia.casasDAO;
import java.util.Collection;

/**
 * Clase que proporciona servicios relacionados con las casas.
 */
public class CasasServicios {

    private casasDAO dao;

    public CasasServicios() {
        this.dao = new casasDAO();
    }

    /**
     * Guarda una casa en la base de datos.
     * 
     * @param casa La casa a guardar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void guardarCasa(casas casa) throws Exception {
        try {
            dao.guardarCasa(casa);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica una casa en la base de datos.
     * 
     * @param casa La casa a modificar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void modificarCasa(casas casa) throws Exception {
        try {
            dao.modificarCasa(casa);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina una casa de la base de datos.
     * 
     * @param idCasa El ID de la casa a eliminar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void eliminarCasa(int idCasa) throws Exception {
        try {
            dao.eliminarCasa(idCasa);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una casa de la base de datos por su ID.
     * 
     * @param idCasa El ID de la casa.
     * @return La casa encontrada, o null si no se encontró ninguna casa con el ID indicado.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public casas buscarCasaPorId(int idCasa) throws Exception {
        try {
            return dao.buscarCasaPorId(idCasa);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una colección de todas las casas en la base de datos.
     * 
     * @return La colección de casas.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public Collection<casas> listarCasas() throws Exception {
        try {
            return dao.listarCasas();
        } catch (Exception e) {
            throw e;
        }
    }
}