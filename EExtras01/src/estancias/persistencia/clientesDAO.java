/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

import estancias.entidades.clientes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class clientesDAO extends DAO {

    public void guardarCliente(clientes cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar el cliente");
            }

            String sql = "INSERT INTO Clientes (nombre, calle, numero, codigo_postal, ciudad, pais, email) "
                    + "VALUES ('" + cliente.getNombre() + "', '" + cliente.getCalle() + "', " + cliente.getNumero() + ", '" + cliente.getCodigoPostal() + "', '" + cliente.getCiudad() + "', '" + cliente.getPais() + "', '" + cliente.getEmail() + "')";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarCliente(clientes cliente) throws Exception {
        try {
            if (cliente == null) {
                throw new Exception("Debe indicar el cliente que desea modificar");
            }

            String sql = "UPDATE Clientes SET "
                    + "nombre = '" + cliente.getNombre() + "', calle = '" + cliente.getCalle() + "', numero = " + cliente.getNumero() + ", codigo_postal = '" + cliente.getCodigoPostal() + "', ciudad = '" + cliente.getCiudad() + "', pais = '" + cliente.getPais() + "', email = '" + cliente.getEmail() + "' "
                    + "WHERE id_cliente = " + cliente.getIdCliente();

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarCliente(int idCliente) throws Exception {
        try {
            String sql = "DELETE FROM Clientes WHERE id_cliente = " + idCliente;

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public clientes buscarClientePorId(int idCliente) throws Exception {
        try {
            String sql = "SELECT * FROM Clientes WHERE id_cliente = " + idCliente;

            consultar(sql);

            clientes cliente = null;
            while (resultado.next()) {
                cliente = new clientes();
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
            }
            desconectar();
            return cliente;
        } catch (SQLException e) {
            desconectar();
            throw e;
        }
    }

    public Collection<clientes> listarClientes() throws Exception {
        try {
            String sql = "SELECT * FROM Clientes";

            consultar(sql);

            clientes cliente = null;
            Collection<clientes> clientes = new ArrayList<>();
            while (resultado.next()) {
                cliente = new clientes();
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setCalle(resultado.getString(3));
                cliente.setNumero(resultado.getInt(4));
                cliente.setCodigoPostal(resultado.getString(5));
                cliente.setCiudad(resultado.getString(6));
                cliente.setPais(resultado.getString(7));
                cliente.setEmail(resultado.getString(8));
                clientes.add(cliente);
            }
            desconectar();
            return clientes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectar();
            throw new Exception("Error de sistema");
        }
    }
}
