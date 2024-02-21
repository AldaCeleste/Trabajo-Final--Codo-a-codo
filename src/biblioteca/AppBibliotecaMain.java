package biblioteca;
public class AppBibliotecaMain {

    // ---------------------------
    // |    Zona de Funciones    |
    // ---------------------------

    // ---------------------------
    // |      Metodo Main        |
    // ---------------------------
    public static void main(String[] args) throws Exception {

        // Creamos los objetos que contienen las listas con las que trabajaremos en todo el programa
        UsuariosRegistrados listaUsuarios = new UsuariosRegistrados();
        Stock               listaLibros   = new Stock();

        //Cargando la base de datos en las listas
        listaUsuarios.cargarBDUsuario();
        listaLibros.cargarBDLibros();


        System.out.println("*---------------------------------*");
        System.out.println("| Bienvenido a Biblioteca Virtual |");
        System.out.println("*---------------------------------*");

        MenuPrincipal.menu(listaUsuarios,listaLibros);
    }
}
