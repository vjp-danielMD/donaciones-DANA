package procesos;

import objetos.Usuario;

/**
 * La clase Registro permite registrar un nuevo usuario en la plataforma.
 * Se solicita un email y una contraseña al usuario, validándolos conforme a reglas establecidas.
 * Una vez validados, el usuario queda registrado exitosamente.
 *
 * @author daniel
 */
public class Registro {

    /**
     * Método estático que inicia el proceso de registro de un usuario.
     * Solicita email y contraseña al usuario, validándolos paso a paso.
     * Si los datos son correctos, confirma la creación exitosa de la cuenta.
     */
    public static void registro() {
        Usuario usuario = new Usuario();
        
        System.out.println("- BIENVENIDO A LA PLATAFORMA DE DONACIONES -");
        System.out.println("");
        System.out.println("Complete el registro antes de comenzar: ");
        
        // Solicita el email al usuario
        Usuario.pedirEmail(usuario);
        System.out.println("");
        System.out.println("[✓] Email correcto: " + usuario.getEmail());
        
        // Solicita la contraseña al usuario
        Usuario.pedirPassword(usuario);
        System.out.println("[✓] Contraseña correcta!");
        System.out.println("");
        
        // Confirmación del registro exitoso
        System.out.println("Cuenta creada correctamente con el usuario " + usuario.getEmail());
    }
}
