import java.util.Scanner;

public class SistemaGestionTrabajadores {
    // Arreglos paralelos para almacenar datos de hasta 3 trabajadores
    static String[] nombres = new String[3];
    static int[] claves = new int[3];
    static double[] sueldos = new double[3];
    static int[] horasTrabajadas = new int[3];
    static int contadorTrabajadores = 0; // Contador de trabajadores registrados

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    altaTrabajadores(scanner);
                    break;
                case 2:
                    consultasGenerales();
                    break;
                case 3:
                    consultasPorClave(scanner);
                    break;
                case 4:
                    consultasPorNombre(scanner);
                    break;
                case 5:
                    salirPrograma();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Método para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("===== SISTEMA DE GESTIÓN DE TRABAJADORES =====");
        System.out.println("1. Alta de trabajadores");
        System.out.println("2. Consultas generales");
        System.out.println("3. Consultas por clave");
        System.out.println("4. Consultas por nombre");
        System.out.println("5. Salir");
        System.out.println("==============================================");
        System.out.print("Seleccione una opción: ");
    }

    // Método para dar de alta trabajadores
    public static void altaTrabajadores(Scanner scanner) {
        if (contadorTrabajadores >= 3) {
            System.out.println("No se pueden registrar más de 3 trabajadores.");
            return;
        }

        System.out.println("Ingrese los datos del trabajador:");
        System.out.print("Nombre: ");
        nombres[contadorTrabajadores] = scanner.nextLine();
        System.out.print("Clave (número de empleado): ");
        claves[contadorTrabajadores] = scanner.nextInt();
        System.out.print("Sueldo: ");
        sueldos[contadorTrabajadores] = scanner.nextDouble();
        System.out.print("Horas trabajadas: ");
        horasTrabajadas[contadorTrabajadores] = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        contadorTrabajadores++;
        System.out.println("Trabajador registrado exitosamente.");
    }

    // Método para consultas generales (mostrar todos los trabajadores)
    public static void consultasGenerales() {
        if (contadorTrabajadores == 0) {
            System.out.println("No hay trabajadores registrados.");
            return;
        }

        System.out.println("Lista de trabajadores registrados:");
        for (int i = 0; i < contadorTrabajadores; i++) {
            System.out.println("Trabajador " + (i + 1) + ":");
            System.out.println("  Nombre: " + nombres[i]);
            System.out.println("  Clave: " + claves[i]);
            System.out.println("  Sueldo: " + sueldos[i]);
            System.out.println("  Horas trabajadas: " + horasTrabajadas[i]);
            System.out.println();
        }
    }

    // Método para consultas por clave
    public static void consultasPorClave(Scanner scanner) {
        System.out.print("Ingrese la clave del trabajador: ");
        int claveBuscada = scanner.nextInt();
        boolean encontrado = false;

        for (int i = 0; i < contadorTrabajadores; i++) {
            if (claves[i] == claveBuscada) {
                System.out.println("Trabajador encontrado:");
                System.out.println("  Nombre: " + nombres[i]);
                System.out.println("  Clave: " + claves[i]);
                System.out.println("  Sueldo: " + sueldos[i]);
                System.out.println("  Horas trabajadas: " + horasTrabajadas[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un trabajador con esa clave.");
        }
    }

    // Método para consultas por nombre
    public static void consultasPorNombre(Scanner scanner) {
        System.out.print("Ingrese el nombre del trabajador: ");
        String nombreBuscado = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < contadorTrabajadores; i++) {
            if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Trabajador encontrado:");
                System.out.println("  Nombre: " + nombres[i]);
                System.out.println("  Clave: " + claves[i]);
                System.out.println("  Sueldo: " + sueldos[i]);
                System.out.println("  Horas trabajadas: " + horasTrabajadas[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un trabajador con ese nombre.");
        }
    }

    // Método para salir del programa
    public static void salirPrograma() {
        System.out.println("Gracias por usar el Sistema de Gestión de Trabajadores. ¡Hasta luego!");
    }
}
