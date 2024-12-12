package donaciones;

/**
 *
 * @author daniel
 */
public class Registro {
    
    public static void registro(){
        Usuario usuario = new Usuario();
        System.out.println("- BIENVENIDO A LA PLATAFORMA DE DONACIONES -");
        System.out.println("");
        System.out.println("Complete el registro antes de comenzar: ");
        Usuario.pedirEmail(usuario);
        System.out.println("");
        System.out.println("[✓]Email correcto: " + usuario.getEmail());
        Usuario.pedirPassword(usuario);
        System.out.println("[✓]Contrasena correcta!");
        System.out.println("");
        System.out.println("Cuenta creada correctamente con el usuario " +usuario.getEmail());
    }
    
    public static void main(String[] args) {
        registro();
    }
}
