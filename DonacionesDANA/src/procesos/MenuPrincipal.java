package procesos;

import java.util.Scanner;
import util.Entrega;
import util.Usuario;

/**
 * Clase MenuPrincipal que muestra el menú principal de la aplicación y permite
 * al usuario interactuar con diferentes opciones.
 *
 * <p>
 * El menú ofrece las siguientes opciones:
 * <ul>
 * <li>1: Donar dinero.</li>
 * <li>2: Donar producto.</li>
 * <li>3: Salir de la aplicación.</li>
 * </ul>
 * </p>
 *
 * @author daniel
 */
public class MenuPrincipal {

    /**
     * Método que muestra el menú principal y gestiona las opciones
     * seleccionadas por el usuario.
     *
     * <p>
     * El método se ejecuta en un bucle que permite elegir entre las siguientes
     * opciones:
     * <ol type="1">
     * <li>Invoca el menú de donación de dinero a través de
     * {@link DonacionesDinero#menuDonarDinero()}.</li>
     * <li>Invoca los métodos de donar producto.</li>
     * <li>Sale del menú y finaliza la ejecución, mostrando el resumen de las
     * operaciones realizadas.</li>
     * </ol>
     * </p>
     */
    public static void menuPrincipal() {
        Scanner entrada = new Scanner(System.in);
        Entrega entrega = new Entrega();
        Resumen resumen = new Resumen();
        DonacionesDinero donacion = new DonacionesDinero();
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
                    
                    Entrega.pedirNombreProducto(entrega);
                    Entrega.seleccionarPuntoRecogida(entrega);
                    resumen.setResumen(entrega, donacion);
                    break;
                case 3:
                    // Salir del menú
                    System.out.println("¡Gracias por participar!");
                    // Mostrar resumen de las donaciones
                    System.out.println(resumen.toString());
                    break;
                default:
                    // Mensaje para opciones no válidas
                    System.out.println("Por favor, selecciona un número válido del menú.");
                    break;
            }
        } while (opcion != 3); // El bucle termina cuando el usuario selecciona "3"
    }
}
