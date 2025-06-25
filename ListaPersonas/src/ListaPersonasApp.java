import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPersonasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> persona = new ArrayList<>();

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            try {
                salir = ejecutarOpcion(scanner, persona);
            } catch (Exception e) {
                System.out.print("Error " + e);
            }


        }

    }

    private static void mostrarMenu() {
        System.out.println("");
        System.out.println("""
                *** Lista Personas App ***
                
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Proporcione una opcion: ");

    }

    private static boolean ejecutarOpcion(Scanner scanner, List<Persona> personas) {
        int opcion = Integer.parseInt(scanner.nextLine());
        var salir = false;
        switch (opcion) {
            case 1:
                System.out.println("Ingresar nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingresa el email: ");
                String email = scanner.nextLine();

                System.out.print("ingresa el telefono: ");
                String telefono = scanner.nextLine();

                Persona persona = new Persona(nombre, telefono, email);
                personas.add(persona);
                System.out.println("la lista tiens " + personas.size());
                break;
            case 2:
                personas.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Fin del programa");
               salir = true;
                break;
        }
        return salir;
    }
}