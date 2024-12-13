package principal;

import procesos.MenuPrincipal;
import procesos.Registro;

/**
 * Clase Main que representa el punto de entrada de la aplicación.
 * 
 * <p>Este programa comienza ejecutando el proceso de registro de usuarios
 * y, una vez completado, muestra el menú principal de la plataforma.</p>
 *
 * @author daniel
 */
public class Main {
    
    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * <p>Primero, se ejecuta el método {@link Registro#registro()} para registrar
     * al usuario. Luego, se llama al método {@link MenuPrincipal#menuPrincipal()}
     * que muestra las opciones principales de la plataforma.</p>
     *
     * @param args Argumentos de la línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        // Iniciar el proceso de registro
        Registro.registro();
        
        // Mostrar el menú principal
        MenuPrincipal.menuPrincipal();
    }
}
