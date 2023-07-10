/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estancias;

import estancias.servicios.CasasServicios;
import estancias.servicios.ClientesServicios;
import estancias.servicios.ComentariosServicios;
import estancias.servicios.EstanciasServicios;
import estancias.servicios.FamiliasServicios;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class app {

    private FamiliasServicios familiasServicios;
    private CasasServicios casasServicios;
    private ClientesServicios clientesServicios;
    private EstanciasServicios estanciasServicios;
    private ComentariosServicios comentariosServicios;

    public app() {
        this.familiasServicios = new FamiliasServicios();
        this.casasServicios = new CasasServicios();
        this.clientesServicios = new ClientesServicios();
        this.estanciasServicios = new EstanciasServicios();
        this.casasServicios = new CasasServicios();
        this.comentariosServicios = new ComentariosServicios();
    }

    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú de Consultas:");
            System.out.println("a) Listar familias con al menos 3 hijos y edad máxima inferior a 10 años");
            System.out.println("b) Buscar y listar casas disponibles en Reino Unido en agosto de 2020");
            System.out.println("c) Listar familias con dirección de correo de Hotmail");
            System.out.println("d) Buscar casas disponibles a partir de una fecha y número de días");
            System.out.println("e) Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "a":
                    listarFamiliasConHijos();
                    break;
                case "b":
                    listarCasasDisponiblesEnAgosto2020();
                    break;
                case "c":
                    listarFamiliasConCorreoHotmail();
                    break;
                case "d":
                    buscarCasasDisponibles();
                    break;
                case "e":
                    listarDatosClientesEstancias();
                    break;
                case "f":
                    listarEstanciasCliente();
                    break;
                case "g":
                    incrementarPrecioCasasReinoUnido();
                    break;
                case "h":
                    obtenerNumeroCasasPorPais();
                    break;
                case "i":
                    listarCasasLimpiasReinoUnido();
                    break;
                case "j":
                    insertarDatosEstancias();
                    break;
                case "k":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
    
        private void listarFamiliasConHijos() {
        try {
            System.out.println("Listado de familias con al menos 3 hijos y edad máxima inferior a 10 años:");
            familiasServicios.listarFamiliasConHijos();
        } catch (Exception e) {
            System.out.println("Error al obtener el listado de familias: " + e.getMessage());
        }
    }

    private void listarCasasDisponiblesEnAgosto2020() {
        try {
            System.out.println("Listado de casas disponibles en Reino Unido en agosto de 2020:");
            
            casasServicios.listarCasasDisponiblesEnPeriodo(LocalDate.of(2020, 8, 1), LocalDate.of(2020, 8, 31), "Reino Unido");
        } catch (Exception e) {
            System.out.println("Error al obtener el listado de casas: " + e.getMessage());
        }
    }

    private void listarFamiliasConCorreoHotmail() {
        try {
            System.out.println("Listado de familias con dirección de correo de Hotmail:");
            familiasServicios.listarFamiliasConCorreoHotmail();
        } catch (Exception e) {
            System.out.println("Error al obtener el listado de familias: " + e.getMessage());
        }
    }

    private void buscarCasasDisponibles() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la fecha a partir de la cual buscar casas disponibles (formato: AAAA-MM-DD): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese el número de días para los que desea buscar casas disponibles: ");
        int numDias = scanner.nextInt();
        scanner.nextLine();

        try {
            System.out.println("Listado de casas disponibles a partir de la fecha " + fecha + " para " + numDias + " días:");
            casasServicios.listarCasasDisponiblesAPartirDeFecha(LocalDate.parse(fecha), numDias);
        } catch (Exception e) {
            System.out.println("Error al obtener el listado de casas: " + e.getMessage());
        }
    }
    
     private void listarDatosClientesEstancias() {
        try {
            System.out.println("Listado de datos de clientes con estancias y descripción de la casa:");
            clientesServicios.listarClientesConEstanciasYDescripcionCasa();
        } catch (Exception e) {
            System.out.println("Error al obtener el listado de datos: " + e.getMessage());
        }
    }

    private void listarEstanciasCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del cliente: ");
        String nombre = scanner.next();
        scanner.nextLine();

        try {
            System.out.println("Listado de estancias del cliente:");
            clientesServicios.listarEstanciasCliente(nombre);
        } catch (Exception e) {
            System.out.println("Error al obtener el listado de estancias: " + e.getMessage());
        }
    }

    private void incrementarPrecioCasasReinoUnido() {
        try {
            System.out.println("Incrementando precio por día en 5% para casas del Reino Unido:");
            casasServicios.incrementarPrecioCasasReinoUnido(5);
        } catch (Exception e) {
            System.out.println("Error al incrementar los precios: " + e.getMessage());
        }
    }

    private void obtenerNumeroCasasPorPais() {
        try {
            System.out.println("Obteniendo número de casas por país:");
            casasServicios.obtenerNumeroCasasPorPais();
        } catch (Exception e) {
            System.out.println("Error al obtener el número de casas por país: " + e.getMessage());
        }
    }

    private void listarCasasLimpiasReinoUnido() {
        try {
            System.out.println("Listado de casas 'limpias' en el Reino Unido:");
            casasServicios.listarCasasLimpiasReinoUnido();
        } catch (Exception e) {
            System.out.println("Error al obtener el listado de casas: " + e.getMessage());
        }
    }

    private void insertarDatosEstancias() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ID de la casa: ");
        int idCasa = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nombre del huésped: ");
        String nombreHuesped = scanner.nextLine();

        System.out.print("Ingrese la fecha de inicio de la estancia (formato: AAAA-MM-DD): ");
        String fechaDesde = scanner.nextLine();

        System.out.print("Ingrese la fecha de fin de la estancia (formato: AAAA-MM-DD): ");
        String fechaHasta = scanner.nextLine();

        try {
            estanciasServicios.insertarEstancia(idCliente, idCasa, nombreHuesped, fechaDesde, fechaHasta);
            System.out.println("Estancia insertada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al insertar la estancia: " + e.getMessage());
        }
    }

}
