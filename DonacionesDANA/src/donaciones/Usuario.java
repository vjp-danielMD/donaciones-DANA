package donaciones;

import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class Usuario {

    //componentes de un usario
    private String email;
    private String password;

    public Usuario() {
        this.email = "";
        this.password = "";
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Email: " +email
                + "\nContrasena: " +password;
    }

    public static String pedirEmail(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        int intentos = 1;
        String email;
        do {
            System.out.print("Email: ");
            email = sc.nextLine();
            comprobarEmail(email);
            if (comprobarEmail(email) == false) {
                System.out.println("[!] Formato incorrecto.");
                System.out.println(intentos + "º intento.");                
            }
            intentos++;
        } while (comprobarEmail(email) == false && intentos <= 5);
        usuario.setEmail(email);
        return email;
    }

    public static boolean comprobarEmail(String email) {
        return email.contains("@") && email.length()>=8 && (email.contains(".com") || email.contains(".es"));
    }

    public static String pedirPassword(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        int intentos = 1;
        String password;
        do {
            System.out.println("Introduzca su contrasena.");
            System.out.println("");
            password = sc.nextLine();
            comprobarPassword(password);
            if (comprobarPassword(password)==false) {
                System.out.println("[!]Contrasena incorrecta. Intentelo de nuevo.");
                System.out.println("""
                                   Por favor, asegurese de que su contrasena tiene, al menos
                                   8 caracteres, un numero, una mayuscula, una minuscula y un caracter especial.""");
                System.out.println(intentos+1 + "º intento.");
            }
            intentos++;
        } while (comprobarPassword(password) == false && intentos <= 5);
        usuario.setPassword(password);
        return password;
    }

    public static boolean comprobarPassword(String password) {
        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneEspecial = false;
        boolean tieneNumero = false;

        String caracteresEspeciales = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i); // obtiene el caracter en la posicion 'i'

            if (Character.isUpperCase(c)) {
                tieneMayus = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinus = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (caracteresEspeciales.contains(String.valueOf(c))) {
                tieneEspecial = true;
            }
        }
        return tieneMayus && tieneMinus && tieneNumero && tieneEspecial;
    }

}
