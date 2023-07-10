/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

/**
 *
 * @author pc
 */


import estancias.entidades.familias;
import estancias.persistencia.FamiliasDAO;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que proporciona servicios relacionados con las familias.
 */
public class FamiliasServicios {

    private FamiliasDAO dao;

    public FamiliasServicios() {
        this.dao = new FamiliasDAO();
    }

    /**
     * Guarda una familia en la base de datos.
     * 
     * @param familia La familia a guardar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void guardarFamilia(familias familia) throws Exception {
        try {
            dao.guardarFamilia(familia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica una familia en la base de datos.
     * 
     * @param familia La familia a modificar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void modificarFamilia(familias familia) throws Exception {
        try {
            dao.modificarFamilia(familia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina una familia de la base de datos.
     * 
     * @param idFamilia El ID de la familia a eliminar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void eliminarFamilia(int idFamilia) throws Exception {
        try {
            dao.eliminarFamilia(idFamilia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una familia de la base de datos por su ID.
     * 
     * @param idFamilia El ID de la familia.
     * @return La familia encontrada, o null si no se encontró ninguna familia con el ID indicado.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public familias buscarFamiliaPorId(int idFamilia) throws Exception {
        try {
            return dao.buscarFamiliaPorId(idFamilia);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una colección de todas las familias en la base de datos.
     * 
     * @return La colección de familias.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public Collection<familias> listarFamilias() throws Exception {
        try {
            return dao.listarFamilias();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarFamiliasConHijos() {
        try {
            Collection<familias> filtro=this.listarFamilias();
            for (familias coincide : filtro) {
                if(coincide.getEdad_minima()>10 && coincide.getNum_hijos()>2) {
                    System.out.println(coincide);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(FamiliasServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
