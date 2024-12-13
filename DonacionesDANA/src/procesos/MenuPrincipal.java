package procesos;

import java.util.Scanner;

/**
 * Clase MenuPrincipal que muestra el menú principal de la aplicación
 * y permite al usuario interactuar con diferentes opciones.
 * 
 * <p>El menú ofrece las siguientes opciones:
 * <ul>
 *   <li>1: Donar dinero.</li>
 *   <li>2: Donar producto (pendiente de implementación).</li>
 *   <li>3: Salir de la aplicación.</li>
 * </ul>
 * </p>
 *
 * @author daniel
 */
public class MenuPrincipal {

    /**
     * Método que muestra el menú principal y gestiona las opciones seleccionadas por el usuario.
     * 
     * <p>El método se ejecuta en un bucle que permite elegir entre las siguientes opciones:
     * <ol type="1">
     *   <li>Invoca el menú de donación de dinero a través de {@link DonacionesDinero#menuDonarDinero()}.</li>
     *   <li>Reservada para la funcionalidad de donación de productos (por implementar).</li>
     *   <li>Sale del menú y finaliza la ejecución.</li>
     * </ol>
     * </p>
     */
    public static void menuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        int opcion; // Almacena la opción seleccionada por el usuario
        
        // Bucle del menú principal
        do {
            System.out.println("\n- MENU PRINCIPAL -");
            System.out.println("1. Donar dinero");
            System.out.println("2. Donar producto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            
            // Leer la opción del usuario
            opcion = entrada.nextInt();

            // Gestionar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Invoca el menú de donación de dinero
                    DonacionesDinero.menuDonarDinero();
                    break;
                case 2:
                    // Funcionalidad pendiente de implementación
                    System.out.println("La opción de donar productos está en desarrollo.");
                    break;
                case 3:
                    // Salir del menú
                    System.out.println("Saliendo del menú principal...");
                    break;
                default:
                    // Mensaje para opciones no válidas
                    System.out.println("Por favor, selecciona un número válido del menú.");
                    break;
            }
        } while (opcion != 3); // El bucle termina cuando el usuario selecciona "3"
        
        entrada.close(); // Cierra el Scanner para liberar recursos
    }
}
