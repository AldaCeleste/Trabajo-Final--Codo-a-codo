package biblioteca;
import java.util.Scanner;

public class MenuStock {
    // Metodo STATIC MENU

    /**
     * Menu operativo del programa que corresponde a la gestion de los titulos de la Biblioteca
     * @param listaUsuarios
     * @param listaLibros
     */
    static void menu(UsuariosRegistrados listaUsuarios, Stock listaLibros) {

        Scanner sc = new Scanner(System.in);
        boolean bandera; // Condición del bucle doWhile

        do {
            bandera = true;

            System.out.println(">>> Menú Librería");
            System.out.println("[1] Consultar Existencias");
            System.out.println("[2] Agregar Nuevo Titulo");
            System.out.println("[3] Modificar Titulo");
            System.out.println("[4] Eliminar Titulo");
            System.out.println("[5] Volver al Menú Anterior");
            System.out.println(" ");

            System.out.print("> Elija una opción: ");

            String input = sc.nextLine();
            System.out.println(" ");

            switch (input) {
                case "1":
                    System.out.println("> Los Libros en disponibilidad son:");
                    System.out.println(" ");
                    listaLibros.showLibros();
                    break;

                case "2":
                    System.out.println("> Ingresando Libro Nuevo");
                    System.out.println(" ");

                    listaLibros.showLibros(); // Mostramos los Libros ya Existentes

                    Libro libro = new Libro(); // Creamos el Objeto Libro
                    libro.setLibro(); // Completamos sus Atributos
                    listaLibros.setLibroALista(libro); // Lo guardamos en la lista
                    listaLibros.saveBDLibros();

                    break;

                case "3":
                    if (!listaLibros.getListaLibros().isEmpty()) { // Verificación de que hay libros en la lista
                        MenuModificacion.menu(listaUsuarios, listaLibros);
                    } else {
                        MenuPrincipal.opcionIncorrecta();
                    }
                    break;

                case "4":
                    if (!listaLibros.getListaLibros().isEmpty()) { // Verificación de que hay libros en la lista

                        System.out.println("> Que Libro desea Eliminar?");
                        System.out.println(" ");

                        listaLibros.eliminarLibroDeLista();

                        listaLibros.showCantidad();
                    } else {
                        MenuPrincipal.opcionIncorrecta();
                    }
                    listaLibros.saveBDLibros();

                    break;

                case "5":
                    System.out.println("> Volviendo al Menú Principal");
                    System.out.println(" ");
                    MenuPrincipal.menu(listaUsuarios, listaLibros);
                    break;
                default:
                    MenuPrincipal.opcionIncorrecta();
                    break;
            }
        } while (bandera);
        sc.close();
    }
}
