package util;

import java.util.Scanner;

public class Entrega {

    private String producto;
    private int hora;
    private Usuario usuario;
    private String puntoRecogida;

    public Entrega() {
        this.producto = "";
        this.hora = 0;
        this.usuario = new Usuario();
        this.puntoRecogida = "";
    }

    public Entrega(String producto, int hora, Usuario usuario, String puntoRecogida) {
        this.producto = producto;
        this.hora = hora;
        this.usuario = usuario;
        this.puntoRecogida = puntoRecogida;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getPuntoRecogida() {
        return puntoRecogida;
    }

    public void setPuntoRecogida(String puntoRecogida) {
        this.puntoRecogida = puntoRecogida;
    }

    public static String pedirNombreProducto(Entrega entrega) {
        String producto = "";
        System.out.print("¿Qué producto quieres donar? : ");
        Scanner entrada = new Scanner(System.in);
        entrega.setProducto(producto);
        return entrada.nextLine();
    }

    public static int pedirHora(Entrega entrega) {
        Scanner entrada = new Scanner(System.in);
        int hora;
        do {
            System.out.print("Introduce una hora de entrega (entre 7 y 24): ");
            while (!entrada.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                entrada.nextInt();
            }
            hora = entrada.nextInt();
        } while (hora < 7 || hora > 24);
        entrega.setHora(hora) ;
        return hora;
    }

    public static String seleccionarPuntoRecogida(Entrega entrega) {
        Scanner entrada = new Scanner(System.in);
        String punto1;
        String punto2;
        int hora = pedirHora(entrega);
        if (hora >= 7 && hora <= 10) {
            punto1 = "Calle Algarroba, 11. CP: 27855. Horario: 7 - 10";
            punto2 = "Avenida Lazarillo de Tormes, 2. CP: 27855. Horario: 7 - 10";
        } else if (hora > 10 && hora <= 15) {
            punto1 = "Calle Francisco Perez, 1. CP: 27855. Horario: 11 - 15";
            punto2 = "Calle Salome Montero, 22. CP: 27855. Horario: 11 - 15";
        } else if (hora > 15 && hora <= 19) {
            punto1 = "Calle Teresa de Calcuta, s/n. CP: 27855. Horario: 16 - 19";
            punto2 = "Avenida Marco Polo, 4. CP: 27855. Horario: 16 - 19";
        } else if (hora > 19 && hora <= 24) {
            punto1 = "Calle Luis Saavedra, s/n. CP: 27855. Horario: 20 - 24";
            punto2 = "Calle Rodrigo Aleman, 5. CP: 27855. Horario: 20 - 24";
        } else {
            return "No hay puntos de entrega disponibles para esta hora.";
        }

        System.out.println("- Puntos de entrega disponibles en tu horario -");
        System.out.println("1. " + punto1);
        System.out.println("2. " + punto2);

        int opcion;
        do {
            System.out.print("Elige un punto de entrega (1 o 2): ");
            while (!entrada.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                entrada.next();
            }
            opcion = entrada.nextInt();
        } while (opcion < 1 || opcion > 2);
        if (opcion == 1) {
            entrega.setPuntoRecogida(punto1);
            return punto1;
        } else {
            entrega.setPuntoRecogida(punto2);
            return punto2;
        }
    }

    @Override
    public String toString() {
        return "Estos son los datos de tu donacion: "
                +"\nEntrega de: " + usuario + ": "
                +"\nProducto: " + producto
                +"\nHora: " + hora
                +"\nPunto de entrega: " +puntoRecogida;
    }
}   
