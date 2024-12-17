package procesos;

import java.util.Scanner;

/**
 * La clase DonacionesDinero permite a los usuarios realizar donaciones monetarias 
 * seleccionando entre cantidades predefinidas o introduciendo una cantidad personalizada.
 * El sistema calcula y muestra el total donado acumulado y ofrece información
 * sobre el impacto de cada donación.
 * 
 * @author daniel
 */
public class DonacionesDinero {
    
    /**
     * Muestra un menú interactivo para que el usuario realice donaciones.
     * Permite seleccionar entre cantidades predefinidas o ingresar una cantidad personalizada.
     * El proceso finaliza cuando el usuario elige la opción de "volver atrás".
     */
    public static void menuDonarDinero() {
        Scanner entrada = new Scanner(System.in);
        double donacion;            // Monto de una donación individual
        double totalDonacion = 0;   // Suma total de las donaciones realizadas
        int opcion;                 // Opción seleccionada por el usuario

        // Bucle principal del menú
        do {
            // Mostrar opciones del menú
            System.out.println("- Donaciones -");
            System.out.println("1. 1 euro");
            System.out.println("2. 20 euros");
            System.out.println("3. 50 euros");
            System.out.println("4. Otra cantidad");
            System.out.println("5. Volver atrás");
            System.out.print("Elige una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    donacion = 1;
                    totalDonacion += donacion;
                    System.out.println("Has donado 1 euro. Con esta donación ayudarás con 1 litro de leche para bebés.");
                    break;

                case 2:
                    donacion = 20;
                    totalDonacion += donacion;
                    System.out.println("Has donado 20 euros. Con esta donación ayudarás con mantas y pañales para las familias que lo necesitan.");
                    break;

                case 3:
                    donacion = 50;
                    totalDonacion += donacion;
                    System.out.println("Has donado 50 euros. Con esta donación alimentarás a 4 familias durante 3 días.");
                    break;

                case 4:
                    // Solicitar una cantidad personalizada
                    System.out.print("Introduce una cantidad: ");
                    donacion = entrada.nextDouble();
                    
                    // Validar y clasificar la cantidad introducida
                    if (donacion < 1) {
                        System.out.println("Por favor, ponga una cantidad superior a 1 €.");
                    } else if (donacion > 1 && donacion < 20) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 2 familias durante 2 días.");
                        totalDonacion += donacion;
                    } else if (donacion >= 20 && donacion < 50) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 5 familias durante 3 días.");
                        totalDonacion += donacion;
                    } else if (donacion >= 50 && donacion < 90) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 8 familias durante 3 días.");
                        totalDonacion += donacion;
                    } else if (donacion >= 90 && donacion < 150) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 10 familias durante 3 días.");
                        totalDonacion += donacion;
                    } else {
                        System.out.println("Has donado " + donacion + " euros. Con este dinero puedes ayudar a muchas familias durante varios días.");
                        totalDonacion += donacion;
                    }
                    break;

                case 5:
                    // Opción de salir del menú
                    System.out.println("Volviendo atrás...");
                    break;

                default:
                    // Mensaje en caso de seleccionar una opción inválida
                    System.out.println("Introduzca un número correcto.");
            }

            // Mostrar el total donado hasta el momento
            System.out.println("Total donado hasta ahora: " + totalDonacion + " euros");
            System.out.println();

        } while (opcion != 5); // Finaliza cuando el usuario selecciona la opción 5
    }
}