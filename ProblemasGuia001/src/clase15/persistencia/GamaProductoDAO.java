/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase15.persistencia;

import clase15.dominio.entidad.GamaProducto;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author pc
 */

public final class GamaProductoDAO extends DAO {

    public void guardarGamaProducto(GamaProducto gamaProducto) throws Exception {
        try {
            if (gamaProducto == null) {
                throw new Exception("Debe indicar la gama de producto");
            }

            String sql = "INSERT INTO GamaProducto (gama, descripcion_texto, descripcion_html, imagen)"
                    + "VALUES ( '" + gamaProducto.getGama() + "' , '" + gamaProducto.getDescripcionTexto() + "' , '" + gamaProducto.getDescripcionHtml() + "' , '" + gamaProducto.getImagen() + "' );";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void modificarGamaProducto(GamaProducto gamaProducto) throws Exception {
        try {
            if (gamaProducto == null) {
                throw new Exception("Debe indicar la gama de producto que desea modificar");
            }

            String sql = "UPDATE GamaProducto SET "
                    + "gama = '" + gamaProducto.getGama() + "' , "
                    + "descripcion_texto = '" + gamaProducto.getDescripcionTexto() + "' , "
                    + "descripcion_html = '" + gamaProducto.getDescripcionHtml() + "' , "
                    + "imagen = '" + gamaProducto.getImagen() + "' "
                    + "WHERE gama = '" + gamaProducto.getGama() + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarGamaProducto(String gama) throws Exception {
        try {

            String sql = "DELETE FROM GamaProducto WHERE gama = '" + gama + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public GamaProducto buscarGamaProductoPorGama(String gama) throws Exception {
        try {

            String sql = "SELECT * FROM GamaProducto "
                    + " WHERE gama = '" + gama + "'";

            consultarBase(sql);

            GamaProducto gamaProducto = null;
            while (resultado.next()) {
                gamaProducto = new GamaProducto();
                gamaProducto.setId(resultado.getInt(1));
                gamaProducto.setGama(resultado.getString(2));
                gamaProducto.setDescripcionTexto(resultado.getString(3));
                gamaProducto.setDescripcionHtml(resultado.getString(4));
                gamaProducto.setImagen(resultado.getString(5));
            }
            desconectarBase();
            return gamaProducto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<GamaProducto> listarGamaProductos() throws Exception {
        try {
            String sql = "SELECT gama, descripcion_texto, descripcion_html, imagen FROM GamaProducto ";

            consultarBase(sql);

            GamaProducto gamaProducto = null;
            Collection<GamaProducto> gamaProductos = new ArrayList();
            while (resultado.next()) {
                gamaProducto = new GamaProducto();
                gamaProducto.setGama(resultado.getString(1));
                gamaProducto.setDescripcionTexto(resultado.getString(2));
                gamaProducto.setDescripcionHtml(resultado.getString(3));
                gamaProducto.setImagen(resultado.getString(4));
                gamaProductos.add(gamaProducto);
            }
            desconectarBase();
            return gamaProductos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}


