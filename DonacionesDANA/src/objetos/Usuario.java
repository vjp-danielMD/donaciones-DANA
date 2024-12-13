package objetos;

import java.util.Scanner;

/**
 * Clase Usuario que representa un usuario con email y contraseña.
 * Permite la validación de email y contraseña mediante reglas predefinidas.
 * 
 * @author daniel
 */
public class Usuario {

    // Atributos de un usuario
    private String email;
    private String password;

    /**
     * Constructor por defecto que inicializa el email y la contraseña a cadenas vacías.
     */
    public Usuario() {
        this.email = "";
        this.password = "";
    }

    /**
     * Constructor parametrizado que inicializa el email y la contraseña con los valores proporcionados.
     *
     * @param email    Email del usuario.
     * @param password Contraseña del usuario.
     */
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Obtiene el email del usuario.
     *
     * @return El email del usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario.
     *
     * @param email El nuevo email del usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Representa el objeto Usuario como una cadena de texto.
     *
     * @return Una cadena que contiene el email y la contraseña del usuario.
     */
    @Override
    public String toString() {
        return "Email: " + email +
               "\nContraseña: " + password;
    }

    /**
     * Pide un email al usuario y lo valida según reglas definidas.
     *
     * @param usuario Objeto Usuario al que se le asignará el email válido.
     * @return El email validado introducido por el usuario.
     */
    public static String pedirEmail(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        int intentos = 1;
        String email;
        do {
            System.out.print("Email: ");
            email = sc.nextLine();
            if (!comprobarEmail(email)) {
                System.out.println("[!] Formato incorrecto.");
                System.out.println(intentos + "º intento.");
            }
            intentos++;
        } while (!comprobarEmail(email) && intentos <= 5);
        usuario.setEmail(email);
        return email;
    }

    /**
     * Comprueba si un email tiene un formato válido.
     *
     * @param email Email a validar.
     * @return true si el email cumple las reglas, false en caso contrario.
     */
    public static boolean comprobarEmail(String email) {
        return email.contains("@") && email.length() >= 8 && (email.contains(".com") || email.contains(".es"));
    }

    /**
     * Pide una contraseña al usuario y la valida según reglas definidas.
     *
     * @param usuario Objeto Usuario al que se le asignará la contraseña válida.
     * @return La contraseña validada introducida por el usuario.
     */
    public static String pedirPassword(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        int intentos = 1;
        String password;
        do {
            System.out.println("Introduzca su contraseña.");
            password = sc.nextLine();
            if (!comprobarPassword(password)) {
                System.out.println("[!]Contraseña incorrecta. Intentelo de nuevo.");
                System.out.println("""
                                   Por favor, asegúrese de que su contraseña tiene, al menos
                                   8 caracteres, un número, una mayúscula, una minúscula y un caracter especial.""");
                System.out.println(intentos + "º intento.");
            }
            intentos++;
        } while (!comprobarPassword(password) && intentos <= 5);
        usuario.setPassword(password);
        return password;
    }

    /**
     * Comprueba si una contraseña cumple con las reglas de seguridad.
     *
     * @param password Contraseña a validar.
     * @return true si la contraseña cumple todas las reglas, false en caso contrario.
     */
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
