/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase15;

import clase15.dominio.servicios.GamaProductoServicio;
import com.mysql.jdbc.Driver;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ProblemasGuia001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GamaProductoServicio primero = new GamaProductoServicio();
        
        try {
            primero.crearGamaProducto("electrico", "Es un producto eléctrico", "Http://localhost/index.html", "tiouno.jpeg");
            primero.imprimirGamaProductos();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error del sistema :\n" + ex.getMessage());
        }
        try {
            primero.crearGamaProducto("barata", "Nuevo componente barato", "hachetetepedospuntosbarrabarralocal", "elBarato.jpg");
            primero.modificarGamaProducto("barato", "un componente barato", "http://localhost/index.mhtml", "laBarata.jpg");
            primero.imprimirGamaProductos();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error del sistema :\n" + ex.getMessage());
        }
        try {

            primero.buscarGamaProductoPorGama("Ornamentales");
            primero.imprimirGamaProductos();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error del sistema :\n" + ex.getMessage());
        }
        try {
            primero.crearGamaProducto("electronico", "Es un producto eléctrico sofisticado", "Http://localhost/index23.html", "tiouno2.jpeg");
            primero.eliminarGamaProducto("electronico");
            primero.imprimirGamaProductos();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error del sistema :\n" + ex.getMessage());
        }
        try {
            primero.listarGamaProductos();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error del sistema :\n" + ex.getMessage());
        }
    }

}
