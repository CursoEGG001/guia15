/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.servicios;

/**
 *
 * @author pc
 */
import estancias.entidades.clientes;
import estancias.persistencia.clientesDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Clase que proporciona servicios relacionados con los clientes.
 */
public class ClientesServicios {

    private clientesDAO dao;

    public ClientesServicios() {
        this.dao = new clientesDAO();
    }

    /**
     * Guarda un cliente en la base de datos.
     *
     * @param cliente El cliente a guardar.
     * @throws Exception Si ocurre un error durante la operación.
     */
    public void guardarCliente(clientes cliente) throws Exception {
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
    public void modificarCliente(clientes cliente) throws Exception {
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
    public clientes buscarClientePorId(int idCliente) throws Exception {
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
    public Collection<clientes> listarClientes() throws Exception {
        try {
            return dao.listarClientes();
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarClientesConEstanciasYDescripcionCasa() throws SQLException {
        try {
            String sql = "SELECT `estancias`.`id_estancia`,\n"
                    + "    `estancias`.`id_cliente`,\n"
                    + "    `estancias`.`id_casa`,\n"
                    + "    `estancias`.`nombre_huesped`,\n"
                    + "    `estancias`.`fecha_desde`,\n"
                    + "    `estancias`.`fecha_hasta`,`comentarios`.`id_comentario`,`comentarios`.`comentario`\n"
                    + "FROM `estancias_exterior`.`estancias`LEFT JOIN `estancias_exterior`.`clientes`\n"
                    + "ON `clientes`.`id_cliente`=`estancias`.`id_cliente`\n"
                    + "LEFT JOIN `estancias_exterior`.`comentarios` ON `estancias`.`id_casa`=`comentarios`.`id_casa`;";

            ResultSet unaConsulta = dao.consultar(sql);

            while (unaConsulta.next()) {
                if (unaConsulta.getString(7) != null) {
                    System.out.println(unaConsulta.getString(4) + " : " + unaConsulta.getString(8));
                }
            }
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public void listarEstanciasCliente(String nombre) throws SQLException {
        try {
            String sql = "SELECT `clientes`.`id_cliente`,\n"
                    + "    `clientes`.`nombre`,\n"
                    + "    `clientes`.`calle`,\n"
                    + "    `clientes`.`numero`,\n"
                    + "    `clientes`.`codigo_postal`,\n"
                    + "    `clientes`.`ciudad`,\n"
                    + "    `clientes`.`pais`,\n"
                    + "    `clientes`.`email`\n"
                    + "FROM `estancias_exterior`.`clientes`\n"
                    + "left join `estancias_exterior`.`estancias`\n"
                    + "on `estancias`.`id_cliente`=`clientes`.`id_cliente`;";
            
            ResultSet lasEstancias = dao.consultar(sql);

            while (lasEstancias.next()) {
                if (lasEstancias.getString(2).contains(nombre)) {
                    System.out.println(lasEstancias.getString(2) + " : " + lasEstancias.getString(3)+ " "+ lasEstancias.getInt(4) + "C.P.: "+lasEstancias.getInt(5) );
                }
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }
}
