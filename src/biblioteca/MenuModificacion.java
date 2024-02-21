package biblioteca;
import java.util.Scanner;

public class MenuModificacion {
    // Metodo STATIC MENU

    /**
     * Menú de Modificacion de Elemento.
     * Contiene todo el proceso de modificacion de un Libro desde su ID.
     */
    public static void menu(UsuariosRegistrados listaUsuarios, Stock listaLibros) {

        Scanner sc = new Scanner(System.in);
        Libro libroBuscado = null;
        String input;

        boolean bandera;

        System.out.println("> Ingresando al menu de Modificación");
        System.out.println(" ");

        libroBuscado = listaLibros.getLibroPorID();

        // Comienza el Menú
        do {
            bandera = false; // condición del Bucle

            // Muestra opción de Modificación
            System.out.println(">>> Opciones de Modificación");
            System.out.println("[1] Modificar Titulo del Libro");
            System.out.println("[2] Modificar Autor");
            System.out.println("[3] Modificar Editorial");
            System.out.println("[4] Modificar ID");
            System.out.println("[5] Modificar Cantidad");
            System.out.println("[6] Terminar Modificación");
            System.out.println(" ");

            // Selecciona Opción
            System.out.print("> Elija una opción: ");
            input = sc.nextLine();
            System.out.println(" ");

            // Estructura de cada opcion:
            // Muestra el Valor antes de ser modificado
            // Se modifica e informa que el cambio ha sido exitoso
            switch (input) {
                case "1":
                    System.out.println("> Modificación del Titulo");
                    System.out.println("- Titulo anterior: " + libroBuscado.getTitulo());
                    System.out.print("- Nuevo Titulo: ");
                    input = sc.nextLine();
                    libroBuscado.setTitulo(input);
                    System.out.println(" ");
                    System.out.println("> Titulo cambiado Exitosamente!");
                    System.out.println(" ");
                    bandera = true;

                    break;
                case "2":
                    System.out.println("> Modificación del Autor");
                    System.out.println("- Autor anterior: " + libroBuscado.getAutor());
                    System.out.print("- Nuevo Autor: ");
                    input = sc.nextLine();
                    libroBuscado.setAutor(input);
                    System.out.println(" ");
                    System.out.println("> Autor cambiado Exitosamente!");
                    System.out.println(" ");
                    bandera = true;
                    break;
                case "3":
                    System.out.println("> Modificación del Editorial");
                    System.out.println("- Editorial anterior: " + libroBuscado.getEditorial());
                    System.out.print("- Nueva Editorial: ");
                    input = sc.nextLine();
                    libroBuscado.setEditorial(input);
                    System.out.println(" ");
                    System.out.println("> Editorial cambiado Exitosamente!");
                    System.out.println(" ");
                    bandera = true;
                    break;
                case "4":
                    System.out.println("> Modificación del Código");
                    System.out.println("- Código anterior: " + libroBuscado.getId());
                    System.out.print("- Nuevo Código: ");
                    input = sc.nextLine();
                    libroBuscado.setId(input);
                    System.out.println(" ");
                    System.out.println("> Código cambiado Exitosamente!");
                    System.out.println(" ");
                    bandera = true;
                    break;
                case "5":
                    System.out.println("> Modificación de la Cantidad de Unidades");
                    System.out.println("- Cantidad anterior: " + libroBuscado.getCantidad());

                    boolean entradaValida = false;

                    while (!entradaValida) {
                        System.out.print("- Nueva Cantidad : ");
                        input = sc.nextLine();

                        try {
                            libroBuscado.setCantidad(Integer.parseInt(input));
                            entradaValida = true;
                        } catch (NumberFormatException e) {
                            System.out.println(" ");
                            MenuPrincipal.opcionIncorrecta();
                        }
                    }

                    System.out.println(" ");
                    System.out.println("> Cantidad cambiada Exitosamente!");
                    System.out.println(" ");
                    bandera = true;
                    break;
                case "6":

                    // Mostrar Como ha quedado el Titulo Modificado
                    System.out.println("> Titulo ha quedado de la siguiente manera:");
                    libroBuscado.showLibro();
                    System.out.println(" ");
                    listaLibros.saveBDLibros();
                    System.out.println(" ");

                    // Volver al menu anterior
                    System.out.println("> Volviendo al menú anterior");
                    System.out.println(" ");

                    bandera = false;
                    MenuStock.menu(listaUsuarios, listaLibros);
                    break;

                default:
                    MenuPrincipal.opcionIncorrecta();
                    bandera = true;
                    break;
            }
            // Vuelve al menu de modificación
        } while (bandera);
        sc.close();
    }
}
