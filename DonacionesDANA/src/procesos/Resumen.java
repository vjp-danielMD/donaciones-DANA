package procesos;

import util.Entrega;
/**
 *
 * @author daniel
 */
public class Resumen {

    private String producto;
    private int hora;
    private String puntoRecogida;

    // Setters para cada atributo
    public void setResumen(Entrega entrega) {
        this.producto = entrega.getProducto();
        this.hora = entrega.getHora();
        this.puntoRecogida = entrega.getPuntoRecogida();
    }

    @Override
    public String toString() {
        return "Resumen de entrega:\n"
                + "Producto: " + producto + "\n"
                + "Hora: " + hora + "\n"
                + "Punto de recogida: " + puntoRecogida + "\n";
    }

}
