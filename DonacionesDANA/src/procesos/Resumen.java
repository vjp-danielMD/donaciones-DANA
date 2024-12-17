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
    private double totalDonacion;

    // Setters para cada atributo
    public void setResumen(Entrega entrega, DonacionesDinero donaciones) {
        this.producto = entrega.getProducto();
        this.hora = entrega.getHora();
        this.puntoRecogida = entrega.getPuntoRecogida();
        this.totalDonacion =  donaciones.getTotalDonacion();
    }

    @Override
    public String toString() {
        return "Resumen de donación:\n"
                +"Cantidad: " + totalDonacion +"\n"
                +"Resumen de entrega:\n"
                + "Producto: " + producto + "\n"
                + "Hora: " + hora + "\n"
                + "Punto de recogida: " + puntoRecogida + "\n";
    }

}
