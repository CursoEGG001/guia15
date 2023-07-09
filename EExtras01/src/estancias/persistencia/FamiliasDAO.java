/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;
import estancias.entidades.familias;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
/**
 *
 * @author pc
 */
public class FamiliasDAO extends DAO {


    public void guardarFamilia(familias familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("Debe indicar la familia");
            }

            String sql = "INSERT INTO Familias (nombre, edad_minima, edad_maxima, num_hijos, email, id_casa_familia) "
                    + "VALUES ('" + familia.getNombre() + "', " + familia.getEdad_minima() + ", " + familia.getEdad_maxima() + ", " + familia.getNum_hijos() + ", '" + familia.getEmail() + "', " + familia.getId_casa_familia() + ")";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void modificarFamilia(familias familia) throws Exception {
        try {
            if (familia == null) {
                throw new Exception("Debe indicar la familia que desea modificar");
            }

            String sql = "UPDATE Familias SET "
                    + "nombre = '" + familia.getNombre() + "', edad_minima = " + familia.getEdad_minima() + ", edad_maxima = " + familia.getEdad_maxima() + ", num_hijos = " + familia.getNum_hijos() + ", email = '" + familia.getEmail() + "', id_casa_familia = " + familia.getId_casa_familia()
                    + " WHERE id_familia = " + familia.getId_familia();

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public void eliminarFamilia(int idFamilia) throws Exception {
        try {
            String sql = "DELETE FROM Familias WHERE id_familia = " + idFamilia;

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectar();
        }
    }

    public familias buscarFamiliaPorId(int idFamilia) throws Exception {
        try {
            String sql = "SELECT * FROM Familias WHERE id_familia = " + idFamilia;

            consultar(sql);

            familias familia = null;
            while (resultado.next()) {
                familia = new familias();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa_familia(resultado.getInt(7));
            }
            desconectar();
            return familia;
        } catch (SQLException e) {
            desconectar();
            throw e;
        }
    }

    public Collection<familias> listarFamilias() throws Exception {
        try {
            String sql = "SELECT * FROM Familias";

            consultar(sql);

            familias familia = null;
            Collection<familias> familias = new ArrayList<>();
            while (resultado.next()) {
                familia = new familias();
                familia.setId_familia(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familia.setId_casa_familia(resultado.getInt(7));
                familias.add(familia);
            }
            desconectar();
            return familias;
        } catch (Exception e) {
            e.printStackTrace();
            desconectar();
            throw new Exception("Error de sistema");
        }
    }
}
