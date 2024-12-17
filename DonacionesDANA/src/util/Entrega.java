package util;

import java.util.Scanner;

/**
 * Clase que representa una entrega de donación, incluyendo información
 * sobre el producto, la hora de entrega, el usuario asociado y el punto de recogida.
 * 
 * @author daniel
 */
public class Entrega {

    private String producto;
    private int hora;
    private Usuario usuario;
    private String puntoRecogida;

    /**
     * Constructor por defecto que inicializa los atributos con valores predeterminados.
     */
    public Entrega() {
        this.producto = "";
        this.hora = 0;
        this.usuario = new Usuario();
        this.puntoRecogida = "";
    }

    /**
     * Constructor parametrizado que inicializa todos los atributos de la entrega.
     * 
     * @param producto       Nombre del producto donado.
     * @param hora           Hora de la entrega (en formato 24 horas).
     * @param usuario        Usuario que realiza la donación.
     * @param puntoRecogida  Punto de recogida de la donación.
     */
    public Entrega(String producto, int hora, Usuario usuario, String puntoRecogida) {
        this.producto = producto;
        this.hora = hora;
        this.usuario = usuario;
        this.puntoRecogida = puntoRecogida;
    }

    /**
     * Obtiene el nombre del producto donado.
     * 
     * @return Nombre del producto.
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Establece el nombre del producto donado.
     * 
     * @param producto Nombre del producto.
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la hora de la entrega.
     * 
     * @return Hora de la entrega (formato 24 horas).
     */
    public int getHora() {
        return hora;
    }

    /**
     * Establece la hora de la entrega.
     * 
     * @param hora Hora de la entrega (formato 24 horas).
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el usuario asociado a la entrega.
     * 
     * @return Usuario asociado.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado a la entrega.
     * 
     * @param usuario Usuario que realiza la donación.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el punto de recogida de la entrega.
     * 
     * @return Punto de recogida.
     */
    public String getPuntoRecogida() {
        return puntoRecogida;
    }

    /**
     * Establece el punto de recogida de la entrega.
     * 
     * @param puntoRecogida Dirección del punto de recogida.
     */
    public void setPuntoRecogida(String puntoRecogida) {
        this.puntoRecogida = puntoRecogida;
    }

    /**
     * Solicita al usuario que introduzca el nombre del producto a donar
     * y lo asigna al objeto de entrega.
     * 
     * @param entrega Objeto {@code Entrega} en el que se asignará el producto.
     * @return Nombre del producto introducido.
     */
    public static String pedirNombreProducto(Entrega entrega) {
        String producto;
        Scanner entrada = new Scanner(System.in);
        System.out.print("¿Qué producto quieres donar? : ");
        producto = entrada.nextLine();
        entrega.setProducto(producto);
        return producto;
    }

    /**
     * Solicita al usuario que introduzca una hora de entrega válida y la asigna
     * al objeto de entrega.
     * 
     * @param entrega Objeto {@code Entrega} en el que se asignará la hora.
     * @return Hora de entrega introducida.
     */
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
        entrega.setHora(hora);
        return hora;
    }

    /**
     * Presenta al usuario una lista de puntos de recogida disponibles según
     * la hora seleccionada, permitiendo elegir uno.
     * 
     * @param entrega Objeto {@code Entrega} en el que se asignará el punto de recogida.
     * @return Dirección del punto de recogida seleccionado.
     */
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

    /**
     * Devuelve una representación en forma de cadena de la entrega,
     * incluyendo información sobre el usuario, producto, hora y punto de recogida.
     * 
     * @return Descripción de la entrega.
     */
    @Override
    public String toString() {
        return "Estos son los datos de tu donacion: "
                + "\nEntrega de: " + usuario + ": "
                + "\nProducto: " + producto
                + "\nHora: " + hora
                + "\nPunto de entrega: " + puntoRecogida;
    }
}
