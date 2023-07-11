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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void listarCasasDisponiblesEnPeriodo(LocalDate desde, LocalDate hasta, String ubicacion) throws Exception {
        try {
            Collection<casas> filtro = this.listarCasas();
            for (casas unaCasa : filtro) {
                if (unaCasa.getCiudad().equals(ubicacion)) {
                    if (unaCasa.getFecha_desde().isAfter(desde) && unaCasa.getFecha_hasta().isBefore(hasta)) {
                        System.out.println(unaCasa);
                    }
                    
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void listarCasasDisponiblesAPartirDeFecha(LocalDate fechaInicio, int numDias) throws Exception {
        try {
            Collection<casas> filtro = this.listarCasas();
            for (casas disponible : filtro) {
                if (disponible.getFecha_desde().isAfter(fechaInicio) && disponible.getFecha_hasta().isBefore(fechaInicio.plusDays(numDias))) {
                    System.out.println(disponible);
                    
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void incrementarPrecioCasasReinoUnido(double i) throws Exception {
        try {
            Collection<casas> indice = new ArrayList<>();
            Collection<casas> filtro = this.listarCasas();
            for (casas disponible : filtro) {
                if (disponible.getPais().contains("Reino Unido")) {
                    System.out.println(disponible.getId_casas());
                    indice.add(disponible);
                }
            }
            casas casa = null;
            for (casas aModificar : indice) {
                casa = aModificar;
                casa.setPrecio_habitacion(aModificar.getPrecio_habitacion() * 1.05);
            }
            dao.modificarCasa(casa);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void obtenerNumeroCasasPorPais() throws SQLException {
        
        try {
            String sql = "SELECT `pais`,count(`pais`) FROM `estancias_exterior`.`casas` group by `pais`";
            
            ResultSet filtro = dao.consultar(sql);
            while (filtro.next()) {
                System.out.println(filtro.getString(1) + " : " + filtro.getInt(2));
            }
        } catch (SQLException ex) {
            throw ex;
        }
        
    }
}
