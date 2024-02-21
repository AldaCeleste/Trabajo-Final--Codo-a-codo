package biblioteca;
import java.util.Scanner;

public class MenuPrincipal {
    //Atributos
    //Constructores

    // Método STATIC

    /**
     * Menu Principal del programa, ejecuta la sección de Usuarios.
     * @param listaUsuarios
     * @param listaLibros
     */
    static void menu(UsuariosRegistrados listaUsuarios, Stock listaLibros) {

        Scanner sc = new Scanner(System.in);
        boolean bandera;

        do {
            bandera = true;
            System.out.println(">>> Menú Principal");
            System.out.println("[1] Iniciar Sesión");
            System.out.println("[2] Crear Usuario");
            System.out.println("[3] Salir");
            System.out.println(" ");

            System.out.print("> Elija una opción: ");
            String input = sc.nextLine();
            System.out.println(" ");

            switch (input) {
                case "1":

                    listaUsuarios.showUsuariosRegistrados(); // Mostramos los Usuarios Registrados

                    if (listaUsuarios.validacionUsuario()) { // Si el Validador es True
                        MenuStock.menu(listaUsuarios, listaLibros); // Ingresamos al Menu Stock
                    }

                    break;
                case "2":
                    Usuario usuario = new Usuario(); // Creamos el Objeto Usuario
                    usuario.setUsuario(); // Completamos sus Atributos
                    listaUsuarios.setNuevoUsuario(usuario); // Lo guardamos en la lista
                    listaUsuarios.saveBDUsuario();
                    break;
                case "3":
                    System.out.println("> Saliendo de la Aplicación");
                    System.out.println(" ");
                    listaUsuarios.saveBDUsuario();
                    listaLibros.saveBDLibros();
                    System.out.println(" ");
                    System.out.println("*----------------------------------------------*");
                    System.out.println("| ¡Muchas Gracias por usar Biblioteca Virtual! |");
                    System.out.println("*----------------------------------------------*");
                    System.out.println(" ");
                    System.exit(0);
                    break;
                default:
                    opcionIncorrecta();
                    break;
            }
        } while (bandera);
        sc.close();
    }

    /**
     * Mensaje de error
     */
    static void opcionIncorrecta() {
        System.out.println("x x x x x x x x x x x x x x x x x x x");
        System.out.println("x La opción ingresada es incorrecta x");
        System.out.println("x x x x x x x x x x x x x x x x x x x");
        System.out.println(" ");
        System.out.println("> Vuelva a Intentarlo");
        System.out.println(" ");
    }

}
