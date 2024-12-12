package donaciones;

import java.util.Scanner;

/**
 *
 * @author Víctor
 */
public class DonacionesDinero {
    
    public static void menuDonarDinero() {
        Scanner entrada = new Scanner(System.in);
        double donacion;
        double totalDonacion = 0;
        int opcion;

        do {
            System.out.println("- Donaciones -");
            System.out.println("1. 1 euro");
            System.out.println("2. 20 euros");
            System.out.println("3. 50 euros");
            System.out.println("4. Otra cantidad");
            System.out.println("5. Volver atras");
            System.out.println("Elige una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:
                    donacion = 1;
                    totalDonacion += donacion;
                    System.out.println("Has donado 1 euro. Con esta donación ayudarás con 1 litro de leche para bebés");
                    break;

                case 2:
                    donacion = 20;
                    totalDonacion += donacion;
                    System.out.println("Has donado 20 euros. Con esta donación ayudarás con mantas y pañales para las familias que lo necesitan");
                    break;

                case 3:
                    donacion = 50;
                    totalDonacion += donacion;
                    System.out.println("Has donado 50 euros. Con esta donación alimentarás a 4 familias durante 3 días");
                    break;

                case 4:
                    System.out.print("Introduce una cantidad: ");
                    donacion = entrada.nextDouble();

                    if (donacion < 1) {
                        System.out.println("Por favor, ponga una cantidad superior a 1 €");
                    } else if (donacion > 1 && donacion < 20) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 2 familias durante 2 días");
                        totalDonacion += donacion;
                    } else if (donacion > 20 && donacion < 50) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 5 familias durante 3 días");
                        totalDonacion += donacion;
                    } else if (donacion > 50 && donacion < 90) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 8 familias durante 3 días");
                        totalDonacion += donacion;
                    } else if (donacion > 90 && donacion < 150) {
                        System.out.println("Has donado " + donacion + " euros. Con esta cantidad ayudarás a mejorar la vida de 10 familias durante 3 días");
                        totalDonacion += donacion;
                    } else {
                        System.out.println("Has donado " + donacion + " euros. Con este dinero puedes ayudar a muchas familias durante varios días.");
                        totalDonacion += donacion;
                    }
                    break;

                case 5:
                    System.out.println("Volviendo atrás...");
                    break;

                default:
                    System.out.println("Introduzca un número correcto");
            }

            System.out.println("Total donado hasta ahora: " + totalDonacion + " euros");
        } while (opcion != 5);
    }
}
