package biblioteca;
import java.util.Scanner;

public class Usuario {

    // Campos
    private String nombre;
    private String password;
    // Atributo privado que solo se utiliza en las funciones de la Clase
    private Scanner sc = new Scanner (System.in);

    // Constructores
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }
    // Constructor Vacio
    public Usuario() {
    }

    // Setters and Getters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // ---------------------------
    // |     Metodos Propios     |
    // ---------------------------

    /**
     * Ingresar todos los Campos del Objeto Usuario
     */
    public void setUsuario() {
        String letras;

        System.out.println("------------------------------");
        System.out.println("> Se creará un nuevo Usuario:");
        System.out.println("");
        System.out.print("- Usuario  : ");
        letras = sc.nextLine();
        setNombre(letras);
        System.out.print("- Password : ");
        letras = sc.nextLine();

        setPassword(letras);
        System.out.println("------------------------------");
        System.out.println(" ");
        System.out.println("> ¡Nuevo Usuario Registrado Correctamente!");
        System.out.println(" ");
    }

    /**
     * Imprime a Pantalla el Tag Usuario + el Nombre
     */
    public void showUsuario() {
        System.out.println("- Usuario : " + getNombre());
        System.out.println("- Password: ****");
    }

}
