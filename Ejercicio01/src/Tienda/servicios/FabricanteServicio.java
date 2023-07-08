/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.servicios;
import Tienda.entidades.Fabricante;
import Tienda.persistencia.fabricanteDAO;
import java.util.List;
/**
 *
 * @author pc
 */
public class FabricanteServicio {

    private fabricanteDAO dao;

    public FabricanteServicio() {
        this.dao = new fabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {
        try {
            // Validaciones

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            // Verificar si el fabricante ya existe
            if (buscarFabricantePorCodigo(String.valueOf(codigo)) != null) {
                throw new Exception("Ya existe un fabricante con el código indicado: " + codigo);
            }

            // Crear el objeto Fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);

            // Guardar el objeto en la base de datos
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarFabricante(String codigo, String nuevoNombre) throws Exception {
        try {
            // Validaciones
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe indicar el código del fabricante");
            }
            if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nuevo nombre del fabricante");
            }

            // Buscar el objeto Fabricante por el código
            Fabricante fabricante = buscarFabricantePorCodigo(codigo);

            // Validar si se encontró el fabricante
            if (fabricante == null) {
                throw new Exception("No se encontró el fabricante con el código indicado: " + codigo);
            }

            // Modificar el atributo del objeto Fabricante
            fabricante.setNombre(nuevoNombre);

            // Actualizar el objeto en la base de datos
            dao.modificarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(String codigo) throws Exception {
        try {
            // Validaciones
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe indicar el código del fabricante");
            }

            // Buscar el objeto Fabricante por el código
            Fabricante fabricante = buscarFabricantePorCodigo(codigo);

            // Validar si se encontró el fabricante
            if (fabricante == null) {
                throw new Exception("No se encontró el fabricante con el código indicado: " + codigo);
            }

            // Eliminar el objeto de la base de datos
            dao.eliminarFabricante(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(String codigo) throws Exception {
        try {
            // Validaciones
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe indicar el código del fabricante");
            }

            // Buscar el objeto Fabricante por el código en la base de datos
            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Fabricante> listarFabricantes() throws Exception {
        try {
            // Obtener todos los fabricantes de la base de datos
            List<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }
}
