// Este codigo fue desarrollado por los integrantes del equipo: Lina Marcela Tabares, Brayan Velez Chica y Alexander Garcia
//Para la Actividad#2
//Declaramos que este codigo es original y no fue copiado de una fuente externa
//Se utilizó ChatGPT para despejar dudas respecto a la estructura y obtener sugerencias para
// la implementación de ciertas partes del código.
// * Específicamente, ChatGPT nos asistió en:
// * - Estructura básica para la clase CRUDJugador.
// * - Ejemplos de manejo de entradas y salidas usando la clase Scanner para interactuar con el usuario.
// *

import java.util.ArrayList;
import java.util.Scanner;

class Jugador {
    private static int contadorId = 0;
    private int id;
    private String nombre;
    private String posicion;
    private int edad;

    public Jugador(String nombre, String posicion, int edad) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.posicion = posicion;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "ID=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Posición='" + posicion + '\'' +
                ", Edad=" + edad +
                '}';
    }
}

public class Main {
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Menú de Jugadores ---");
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Eliminar Jugador");
            System.out.println("3. Buscar Jugador");
            System.out.println("4. Editar Jugador");
            System.out.println("5. Listar Jugadores");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarJugador();
                    break;
                case 2:
                    eliminarJugador();
                    break;
                case 3:
                    buscarJugador();
                    break;
                case 4:
                    editarJugador();
                    break;
                case 5:
                    listarJugadores();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void agregarJugador() {
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la posición del jugador: ");
        String posicion = scanner.nextLine();
        System.out.print("Ingrese la edad del jugador: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Jugador nuevoJugador = new Jugador(nombre, posicion, edad);
        jugadores.add(nuevoJugador);
        System.out.println("Jugador agregado exitosamente!");
        listarJugadores();
    }

    private static void eliminarJugador() {
        System.out.print("Ingrese el ID del jugador a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            System.out.print("¿Está seguro de que desea eliminar este jugador? (s/n): ");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("s")) {
                jugadores.remove(jugador);
                System.out.println("Jugador eliminado exitosamente.");
                listarJugadores();
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void buscarJugador() {
        System.out.print("Ingrese el ID del jugador a buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            System.out.println(jugador);
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static Jugador buscarJugadorPorId(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }

    private static void editarJugador() {
        System.out.print("Ingrese el ID del jugador a editar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        Jugador jugador = buscarJugadorPorId(id);
        if (jugador != null) {
            System.out.print("Ingrese el nuevo nombre del jugador: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la nueva posición del jugador: ");
            String posicion = scanner.nextLine();
            System.out.print("Ingrese la nueva edad del jugador: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            jugador.setNombre(nombre);
            jugador.setPosicion(posicion);
            jugador.setEdad(edad);

            System.out.println("Jugador editado exitosamente.");
            listarJugadores();
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void listarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en la lista.");
        } else {
            System.out.println("\nLista de Jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }
}
