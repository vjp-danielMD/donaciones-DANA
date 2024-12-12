package donaciones;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class MenuPrincipal {
    
    public static void menuPrincipal() {

        int opcion;

        do {
            System.out.println("- MENU PRINCIPAL -");
            System.out.println("1. Donar dinero");
            System.out.println("2. Donar producto");
            System.out.println("3. Salir");

            Scanner entrada = new Scanner(System.in);

            System.out.print("Elige una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:

                    DonacionesDinero.menuDonarDinero();

                    break;

                case 2:
                    //menuDonarProducto
                    break;

                case 3:
                    break; //salir

                default:
                    System.out.println("Por favor, presione un numero del menu");
                    break;

            }
        } while (opcion != 3);

    }
}
