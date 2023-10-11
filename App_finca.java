import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Finca {
    private static Map<String, String> finca = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Registrar");
            System.out.println("2. Actualizar");
            System.out.println("3. Consultar");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    registrarParcela(scanner);
                    break;
                case 2:
                    actualizarParcela(scanner);
                    break;
                case 3:
                    consultarParcela(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 4);
    }

    private static void registrarParcela(Scanner scanner) {
        System.out.print("Ingrese el nombre de la parcela: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción de la parcela: ");
        String descripcion = scanner.nextLine();
        finca.put(nombre, descripcion);
        System.out.println("Parcela registrada correctamente.");
    }

    private static void actualizarParcela(Scanner scanner) {
        System.out.print("Ingrese el nombre de la parcela que desea actualizar: ");
        String nombre = scanner.nextLine();
        if (finca.containsKey(nombre)) {
            System.out.print("Ingrese la nueva descripción de la parcela: ");
            String nuevaDescripcion = scanner.nextLine();
            finca.put(nombre, nuevaDescripcion);
            System.out.println("Parcela actualizada correctamente.");
        } else {
            System.out.println("Parcela no encontrada. Por favor, ingrese un nombre válido.");
        }
    }

    private static void consultarParcela(Scanner scanner) {
        System.out.print("Ingrese el nombre de la parcela que desea consultar: ");
        String nombre = scanner.nextLine();
        if (finca.containsKey(nombre)) {
            String descripcion = finca.get(nombre);
            System.out.println("Descripción de la parcela '" + nombre + "': " + descripcion);
        } else {
            System.out.println("Parcela no encontrada. Por favor, ingrese un nombre válido.");
        }
    }
}