/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase15.dominio.servicios;

import clase15.dominio.entidad.GamaProducto;
import clase15.persistencia.GamaProductoDAO;
import java.util.Collection;

/**
 *
 * @author pc
 */
public class GamaProductoServicio {

    private GamaProductoDAO dao;

    public GamaProductoServicio() {
        this.dao = new GamaProductoDAO();
    }
public void crearGamaProducto(String gama, String descripcionTexto, String descripcionHtml, String imagen) throws Exception {
        try {
            // Validaciones
            if (gama == null || gama.trim().isEmpty()) {
                throw new Exception("Debe indicar la gama");
            }
            if (descripcionTexto == null || descripcionTexto.trim().isEmpty()) {
                throw new Exception("Debe indicar la descripción de texto");
            }
            if (descripcionHtml == null || descripcionHtml.trim().isEmpty()) {
                throw new Exception("Debe indicar la descripción HTML");
            }
            if (imagen == null || imagen.trim().isEmpty()) {
                throw new Exception("Debe indicar la imagen");
            }

            // Verificar si la gama ya existe
            if (buscarGamaProductoPorGama(gama) != null) {
                throw new Exception("Ya existe una gama con el nombre indicado: " + gama);
            }

            // Crear el objeto GamaProducto
            GamaProducto gamaProducto = new GamaProducto();
            gamaProducto.setGama(gama);
            gamaProducto.setDescripcionTexto(descripcionTexto);
            gamaProducto.setDescripcionHtml(descripcionHtml);
            gamaProducto.setImagen(imagen);

            // Guardar el objeto en la base de datos
            dao.guardarGamaProducto(gamaProducto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarGamaProducto(String gama, String nuevaDescripcionTexto, String nuevaDescripcionHtml, String nuevaImagen) throws Exception {
        try {
            // Validaciones
            if (gama == null || gama.trim().isEmpty()) {
                throw new Exception("Debe indicar la gama");
            }
            if (nuevaDescripcionTexto == null || nuevaDescripcionTexto.trim().isEmpty()) {
                throw new Exception("Debe indicar la nueva descripción de texto");
            }
            if (nuevaDescripcionHtml == null || nuevaDescripcionHtml.trim().isEmpty()) {
                throw new Exception("Debe indicar la nueva descripción HTML");
            }
            if (nuevaImagen == null || nuevaImagen.trim().isEmpty()) {
                throw new Exception("Debe indicar la nueva imagen");
            }

            // Buscar el objeto GamaProducto por la gama
            GamaProducto gamaProducto = buscarGamaProductoPorGama(gama);

            // Validar si se encontró la gama
            if (gamaProducto == null) {
                throw new Exception("No se encontró la gama con el nombre indicado: " + gama);
            }

            // Modificar los atributos del objeto GamaProducto
            gamaProducto.setDescripcionTexto(nuevaDescripcionTexto);
            gamaProducto.setDescripcionHtml(nuevaDescripcionHtml);
            gamaProducto.setImagen(nuevaImagen);

            // Actualizar el objeto en la base de datos
            dao.modificarGamaProducto(gamaProducto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarGamaProducto(String gama) throws Exception {
        try {
            // Validaciones
            if (gama == null || gama.trim().isEmpty()) {
                throw new Exception("Debe indicar la gama");
            }

            // Buscar el objeto GamaProducto por la gama
            GamaProducto gamaProducto = buscarGamaProductoPorGama(gama);

            // Validar si se encontró la gama
            if (gamaProducto == null) {
                throw new Exception("No se encontró la gama con el nombre indicado: " + gama);
            }

            // Eliminar el objeto de la base de datos
            dao.eliminarGamaProducto(gamaProducto.getGama());
        } catch (Exception e) {
            throw e;
        }
    }

    public GamaProducto buscarGamaProductoPorGama(String gama) throws Exception {
        try {
            // Validaciones
            if (gama == null || gama.trim().isEmpty()) {
                throw new Exception("Debe indicar la gama");
            }

            // Buscar el objeto GamaProducto por la gama en la base de datos
            GamaProducto gamaProducto = dao.buscarGamaProductoPorGama(gama);

            return gamaProducto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<GamaProducto> listarGamaProductos() throws Exception {
        try {
            // Obtener todas las gamas de productos de la base de datos
            Collection<GamaProducto> gamaProductos = dao.listarGamaProductos();

            return gamaProductos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirGamaProductos() throws Exception {
        try {
            // Obtener todas las gamas de productos de la base de datos
            Collection<GamaProducto> gamaProductos = listarGamaProductos();

            // Imprimir los gamaProductos
            if (gamaProductos.isEmpty()) {
                throw new Exception("No existen gamas de productos para imprimir");
            } else {
                for (GamaProducto gamaProducto : gamaProductos) {
                    System.out.println(gamaProducto.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}