/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;
import estancias.entidades.estancias;
import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;
/**
 *
 * @author pc
 */
public class estanciasDAO extends DAO {


    public void guardarEstancia(estancias estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar la estancia");
            }

            String sql = "INSERT INTO Estancia (id_cliente, id_casa, nombre_huesped, fecha_desde, fecha_hasta) "
                    + "VALUES (" + estancia.getId_cliente() + ", " + estancia.getId_casa() + ", '" + estancia.getNombre_huesped() + "', '" + estancia.getFecha_desde() + "', '" + estancia.getFecha_hasta() + "')";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarEstancia(estancias estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar la estancia que desea modificar");
            }

            String sql = "UPDATE Estancia SET "
                    + "id_cliente = " + estancia.getId_cliente() + ", id_casa = " + estancia.getId_casa() + ", nombre_huesped = '" + estancia.getNombre_huesped() + "', fecha_desde = '" + estancia.getFecha_desde() + "', fecha_hasta = '" + estancia.getFecha_hasta() + "' "
                    + "WHERE id_estancia = " + estancia.getId_estancia();

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarEstancia(int idEstancia) throws Exception {
        try {
            String sql = "DELETE FROM Estancia WHERE id_estancia = " + idEstancia;

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public estancias buscarEstanciaPorId(int idEstancia) throws Exception {
        try {
            String sql = "SELECT * FROM Estancia WHERE id_estancia = " + idEstancia;

            consultar(sql);

            estancias estancia = null;
            while (resultado.next()) {
                estancia = new estancias();
                estancia.setId_estancia(resultado.getInt(1));
                estancia.setId_cliente(resultado.getInt(2));
                estancia.setId_casa(resultado.getInt(3));
                estancia.setNombre_huesped(resultado.getString(4));
                estancia.setFecha_desde(LocalDate.parse(resultado.getString(5)));
                estancia.setFecha_hasta(LocalDate.parse(resultado.getString(6)));
            }
            desconectar();
            return estancia;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public Collection<estancias> listarEstancias() throws Exception {
        try {
            String sql = "SELECT * FROM Estancia";

            consultar(sql);

            estancias estancia = null;
            Collection<estancias> estancias = new ArrayList<>();
            while (resultado.next()) {
                estancia = new estancias();
                estancia.setId_estancia(resultado.getInt(1));
                estancia.setId_cliente(resultado.getInt(2));
                estancia.setId_casa(resultado.getInt(3));
                estancia.setNombre_huesped(resultado.getString(4));
                estancia.setFecha_desde(LocalDate.parse(resultado.getString(5)));
                estancia.setFecha_hasta(LocalDate.parse(resultado.getString(6)));
                estancias.add(estancia);
            }
            desconectar();
            return estancias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectar();
            throw new Exception("Error de sistema");
        }
    }
}
