/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgfor;

/**
 *
 * @author pedro
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        String[] opciones = {
            "Agregar Nombre",
            "Eliminar Nombre",
            "Actualizar Nombre",
            "Mostrar Nombres",
            "Salir"
        };
        int opcion;

        do {
            System.out.println("\n--- MENU DE NOMBRES ---");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }

            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre a agregar: ");
                    nombres.add(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Nombre a eliminar: ");
                    String eliminar = scanner.nextLine();
                    if (nombres.removeIf(n -> n.equalsIgnoreCase(eliminar))) {
                        System.out.println("Nombre eliminado.");
                    } else {
                        System.out.println("Nombre no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Nombre a actualizar: ");
                    String viejo = scanner.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < nombres.size(); i++) {
                        if (nombres.get(i).equalsIgnoreCase(viejo)) {
                            System.out.print("Nuevo nombre: ");
                            nombres.set(i, scanner.nextLine());
                            System.out.println("Nombre actualizado.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) System.out.println("Nombre no encontrado.");
                }
                case 4 -> {
                    System.out.println("Lista de nombres:");
                    for (String nombre : nombres) {
                        System.out.println("- " + nombre);
                    }
                }
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
