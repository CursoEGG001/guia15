/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase15;

import Tienda.entidades.Producto;
import Tienda.servicios.FabricanteServicio;
import Tienda.servicios.productoServicio;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    private static FabricanteServicio fabricanteServicio;
    private static productoServicio productoServicio;
    private static Scanner scanner;

    public static void main(String[] args) {
        fabricanteServicio = new FabricanteServicio();
        productoServicio = new productoServicio();
        scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("Menu de Consultas:");
            System.out.println("a) Lista el nombre de todos los productos");
            System.out.println("b) Lista los nombres y los precios de todos los productos");
            System.out.println("c) Listar productos con precio entre 120 y 202");
            System.out.println("d) Listar todos los Portátiles");
            System.out.println("e) Listar el nombre y el precio del producto más barato");
            System.out.println("f) Ingresar un producto");
            System.out.println("g) Ingresar un fabricante");
            System.out.println("h) Editar un producto");
            System.out.println("q) Salir");

            System.out.print("Ingrese la opción deseada: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "a":
                    listarNombreProductos();
                    break;
                case "b":
                    listarNombresYPreciosProductos();
                    break;
                case "c":
                    listarProductosPorRangoPrecio();
                    break;
                case "d":
                    listarPortatiles();
                    break;
                case "e":
                    listarProductoMasBarato();
                    break;
                case "f":
                    ingresarProducto();
                    break;
                case "g":
                    ingresarFabricante();
                    break;
                case "h":
                    editarProducto();
                    break;
                case "q":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    break;
            }

            System.out.println();
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    private static void listarNombreProductos() {
        try {
            List<Producto> productos = productoServicio.listarProductos();

            System.out.println("Nombre de todos los productos:");

            for (Producto producto : productos) {
                System.out.println(producto.getNombre());
            }
        } catch (Exception e) {
            System.out.println("Error al listar los productos: " + e.getMessage());
        }
    }

    private static void listarNombresYPreciosProductos() {
        try {
            List<Producto> productos = productoServicio.listarProductos();

            System.out.println("Nombres y precios de todos los productos:");

            for (Producto producto : productos) {
                System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            }
        } catch (Exception e) {
            System.out.println("Error al listar los productos: " + e.getMessage());
        }
    }

    private static void listarProductosPorRangoPrecio() {
        try {
            double precioMinimo = 120;
            double precioMaximo = 202;

            List<Producto> productos = productoServicio.listarProductos();

            System.out.println("Productos con precio entre " + precioMinimo + " y " + precioMaximo + ":");

            for (Producto producto : productos) {
                if (producto.getPrecio() >= precioMinimo && producto.getPrecio() <= precioMaximo) {
                    System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar los productos: " + e.getMessage());
        }
    }

    private static void listarPortatiles() {
        try {
            List<Producto> productos = productoServicio.listarProductos();

            System.out.println("Portátiles:");

            for (Producto producto : productos) {
                if (producto.getNombre().contains("Portátil")) {
                    System.out.println("Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al listar los productos: " + e.getMessage());
        }
    }

    private static void listarProductoMasBarato() {
        try {
            List<Producto> productos = productoServicio.listarProductos();

            Producto productoMasBarato = null;

            for (Producto producto : productos) {
                if (productoMasBarato == null || producto.getPrecio() < productoMasBarato.getPrecio()) {
                    productoMasBarato = producto;
                }
            }

            if (productoMasBarato != null) {
                System.out.println("Producto más barato:");
                System.out.println("Nombre: " + productoMasBarato.getNombre() + ", Precio: " + productoMasBarato.getPrecio());
            } else {
                System.out.println("No se encontraron productos.");
            }
        } catch (Exception e) {
            System.out.println("Error al listar los productos: " + e.getMessage());
        }
    }

    private static void ingresarProducto() {
        try {
            System.out.print("Ingrese el código del producto: ");
            int codigo = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese el código del fabricante: ");
            int codigoFabricante = Integer.parseInt(scanner.nextLine());

            productoServicio.guardarProducto(codigo, nombre, precio, codigoFabricante);
            System.out.println("Producto ingresado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al ingresar el producto: " + e.getMessage());
        }
    }

    private static void ingresarFabricante() {
        try {
            System.out.print("Ingrese el código del fabricante: ");
            int codigo = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nombre del fabricante: ");
            String nombre = scanner.nextLine();

            fabricanteServicio.crearFabricante(codigo, nombre);
            System.out.println("Fabricante ingresado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al ingresar el fabricante: " + e.getMessage());
        }
    }

    private static void editarProducto() {
        try {
            System.out.print("Ingrese el código del producto a editar: ");
            int codigo = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nuevo nombre del producto: ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Ingrese el nuevo precio del producto: ");
            double nuevoPrecio = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese el nuevo código del fabricante: ");
            int nuevoCodigoFabricante = Integer.parseInt(scanner.nextLine());

            productoServicio.modificarProducto(codigo, nuevoNombre, nuevoPrecio, nuevoCodigoFabricante);
            System.out.println("Producto editado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al editar el producto: " + e.getMessage());
        }
    }
}
