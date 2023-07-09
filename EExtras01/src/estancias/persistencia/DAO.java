/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias.persistencia;

/**
 *
 * @author pc
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {

    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;

    public void conectar() throws SQLException {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/estancias_exterior";
                String usuario = "root";
                String pass = "root";
                conexion = DriverManager.getConnection(url, usuario, pass);
            } catch (ClassNotFoundException | SQLException e) {
                throw new SQLException("Error al conectar con la base de datos.", e);
            }
        }
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                throw new SQLException("Error al desconectar de la base de datos.", e);
            }
        }
    }

    public ResultSet consultar(String sql) throws SQLException {
        try {
            Statement statement = conexion.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new SQLException("Error al ejecutar la consulta.", e);
        }
    }

    public void insertarModificarEliminar(String sql) throws SQLException {
        try {
            Statement statement = conexion.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Error al ejecutar la instrucción de inserción.", e);
        }
    }

}
