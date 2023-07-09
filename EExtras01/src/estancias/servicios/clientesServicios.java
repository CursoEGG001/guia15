/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

import estancias.entidades.Clientes;
import estancias.persistencia.clientesDAO;
import java.util.Collection;

/**
 *
 * @author pc
 */
public class clientesServicios {

    /**
     * Clase que proporciona servicios relacionados con los clientes.
     */
    private clientesDAO dao;

    public clientesServicios() {
        this.dao = new clientesDAO();
    }

    /**
     * Guarda un cliente en la base de datos.
     *
     * @param cliente El cliente a guardar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void guardarCliente(Clientes cliente) throws Exception {
        try {
            dao.guardarCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Modifica un cliente en la base de datos.
     *
     * @param cliente El cliente a modificar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void modificarCliente(Clientes cliente) throws Exception {
        try {
            dao.modificarCliente(cliente);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param idCliente El ID del cliente a eliminar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void eliminarCliente(int idCliente) throws Exception {
        try {
            dao.eliminarCliente(idCliente);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene un cliente de la base de datos por su ID.
     *
     * @param idCliente El ID del cliente.
     * @return El cliente encontrado, o null si no se encontró ningún cliente con el ID indicado.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public Clientes buscarClientePorId(int idCliente) throws Exception {
        try {
            return dao.buscarClientePorId(idCliente);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Obtiene una colección de todos los clientes en la base de datos.
     *
     * @return La colección de clientes.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public Collection<Clientes> listarClientes() throws Exception {
        try {
            return dao.listarClientes();
        } catch (Exception e) {
            throw e;
        }
    }
}
