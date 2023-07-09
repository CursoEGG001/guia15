/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

/**
 *
 * @author pc
 */


import estancias.entidades.casas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;

public class CasasDAO extends DAO {

    public void guardarCasa(casas casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("Debe indicar la casa");
            }

            String sql = "INSERT INTO Casas (calle, numero, codigo_postal, ciudad, pais, fecha_desde, fecha_hasta, tiempo_minimo, tiempo_maximo, precio_habitacion, tipo_vivienda) "
                    + "VALUES ('" + casa.getCalle() + "', " + casa.getNumero() + ", '" + casa.getCodigo_postal() + "', '" + casa.getCiudad() + "', '" + casa.getPais() + "', '" + casa.getFecha_desde() + "', '" + casa.getFecha_hasta() + "', " + casa.getTiempo_minimo() + ", " + casa.getTiempo_maximo() + ", " + casa.getPrecio_habitacion() + ", '" + casa.getTipo_vivienda() + "')";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarCasa(casas casa) throws Exception {
        try {
            if (casa == null) {
                throw new Exception("Debe indicar la casa que desea modificar");
            }

            String sql = "UPDATE Casas SET "
                    + "calle = '" + casa.getCalle() + "', numero = " + casa.getNumero() + ", codigo_postal = '" + casa.getCodigo_postal() + "', ciudad = '" + casa.getCiudad() + "', pais = '" + casa.getPais() + "', fecha_desde = '" + casa.getFecha_desde() + "', fecha_hasta = '" + casa.getFecha_hasta() + "', tiempo_minimo = " + casa.getTiempo_minimo() + ", tiempo_maximo = " + casa.getTiempo_maximo() + ", precio_habitacion = " + casa.getPrecio_habitacion() + ", tipo_vivienda = '" + casa.getTipo_vivienda() + "' "
                    + "WHERE id_casas = " + casa.getId_casas();

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarCasa(int idCasa) throws Exception {
        try {
            String sql = "DELETE FROM Casas WHERE id_casas = " + idCasa;

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public casas buscarCasaPorId(int idCasa) throws Exception {
        try {
            String sql = "SELECT * FROM Casas WHERE id_casas = " + idCasa;

            consultar(sql);

            casas casa = null;
            while (resultado.next()) {
                casa = new casas();
                casa.setId_casas(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFecha_desde(LocalDate.parse(resultado.getString(7)));
                casa.setFecha_hasta(LocalDate.parse(resultado.getString(8)));
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getDouble(11));
                casa.setTipo_vivienda(resultado.getString(12));
            }
            desconectar();
            return casa;
        } catch (SQLException e) {
            desconectar();
            throw e;
        }
    }

    public Collection<casas> listarCasas() throws Exception {
        try {
            String sql = "SELECT * FROM Casas";

            consultar(sql);

           casas casa = null;
            Collection<casas> casas = new ArrayList<>();
            while (resultado.next()) {
                casa = new casas();
                casa.setId_casas(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigo_postal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFecha_desde(LocalDate.parse(resultado.getString(7)));
                casa.setFecha_hasta(LocalDate.parse(resultado.getString(8)));
                casa.setTiempo_minimo(resultado.getInt(9));
                casa.setTiempo_maximo(resultado.getInt(10));
                casa.setPrecio_habitacion(resultado.getDouble(11));
                casa.setTipo_vivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectar();
            return casas;
        } catch (Exception e) {
            e.printStackTrace();
            desconectar();
            throw new Exception("Error de sistema");
        }
    }
}