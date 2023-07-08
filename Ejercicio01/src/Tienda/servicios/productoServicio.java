/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.servicios;
import Tienda.entidades.Producto;
import Tienda.persistencia.productoDAO;
import java.util.List;
/**
 *
 * @author pc
 */
public class productoServicio {


    private productoDAO dao;

    public productoServicio() {
        this.dao = new productoDAO();
    }

    public void guardarProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {
        try {
            // Validaciones
            if (buscarProductoPorCodigo(codigo) != null) {
                throw new Exception("Ya existe un producto con el código indicado: " + codigo);
            }

            // Crear el objeto Producto
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigo_fabricante(codigoFabricante);

            // Guardar el producto en la base de datos
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(int codigo, String nuevoNombre, double nuevoPrecio, int nuevoCodigoFabricante) throws Exception {
        try {
            // Buscar el producto por el código
            Producto producto = buscarProductoPorCodigo(codigo);

            // Validar si se encontró el producto
            if (producto == null) {
                throw new Exception("No se encontró el producto con el código indicado: " + codigo);
            }

            // Modificar los atributos del producto
            producto.setNombre(nuevoNombre);
            producto.setPrecio(nuevoPrecio);
            producto.setCodigo_fabricante(nuevoCodigoFabricante);

            // Actualizar el producto en la base de datos
            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            // Buscar el producto por el código
            Producto producto = buscarProductoPorCodigo(codigo);

            // Validar si se encontró el producto
            if (producto == null) {
                throw new Exception("No se encontró el producto con el código indicado: " + codigo);
            }

            // Eliminar el producto de la base de datos
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            // Buscar el producto por el código en la base de datos
            Producto producto = dao.buscarProductoPorCodigo(codigo);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigoFabricante(int codigo_fabricante) throws Exception {
        try {
            // Buscar el producto por el código en la base de datos
            Producto producto = dao.buscarProductoPorCodigoFabricante(codigo_fabricante);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorNombre(String codigo) throws Exception {
        try {
            // Buscar el producto por el código en la base de datos
            Producto producto = dao.buscarProductoPorNombre(codigo);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Producto> listarProductos() throws Exception {
        try {
            // Obtener todos los productos de la base de datos
            List<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
}
