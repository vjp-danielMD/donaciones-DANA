package donaciones;

/**
 *
 * @author daniel
 */
public class Registro {
    
    public static void registro(){
        System.out.println("- BIENVENIDO A LA PLATAFORMA DE DONACIONES -");
        System.out.println("Complete el registro antes de comenzar: ");
        Usuario.pedirEmail();
        Usuario.pedirPassword();
    }
    
    public static void main(String[] args) {
        registro();
    }
}
