package biblioteca;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuariosRegistrados {

    // Campos
    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private File archivoUsuarios = new File("bdUsuarios.txt");

    // Atributos privados que solo se utilizan en las funciones de la Clase
    Scanner sc = new Scanner(System.in);

    // Constructor
    public UsuariosRegistrados() {
    }

    // Getter
    public List<Usuario> getListaUsuarios() {
        return this.listaUsuarios;
    }

    // ---------------------------
    // |     Metodos Propios     |
    // ---------------------------

    /**
     * Ingresa un Objeto Usuario a la Lista de Usuarios
     * 
     * @param usuario
     */
    public void setNuevoUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    /**
     * Imprime a Pantalla la Lista de Usuarios Registrados
     */
    public void showUsuariosRegistrados() {
        int contador = 0;
        System.out.println("---------------------------------");
        System.out.println("| Lista de Usuarios Registrados |");
        System.out.println("---------------------------------");

        for (Usuario usuario : listaUsuarios) {
            usuario.showUsuario();
            System.out.println("---------------------------------");
            contador++;
        }
        System.out.println("Total de Usuarios Registrados: " + contador);
        System.out.println(" ");
    }

    /**
     * Verifica Usuario y Contraseña con los Usuarios Registrados en la Base de
     * Datos, para
     * 
     * @return boolean
     */
    public boolean validacionUsuario() {

        System.out.println("> Ingrese su Usuario Registrado");
        System.out.print("- Usuario : ");
        String usu = sc.nextLine();
        usu = usu.toUpperCase(); // Lo pasamos a mayuscula para asegurarnos la comparación

        System.out.print("- Password: ");
        String password = sc.nextLine(); // No la pasamos a mayuscula por que nos interesa que sea CaseSensitive

        System.out.println(" ");

        boolean validador = false;

        for (Usuario usuario : listaUsuarios) { // Recorremos la lista de objetos usuarios
            if ((usuario.getNombre().equals(usu)) && (usuario.getPassword().equals(password))) {
                validador = true;
            }
        }

        if (validador) {
            System.out.println("-------- Acceso Permitido -------");
            System.out.println(" ");
            System.out.println("> Bienvenido: " + usu);
            System.out.println(" ");
        } else {
            System.out.println("x x x x x x x x x x x x x x x x x x x x x");
            System.out.println("x ¡Acceso Denegado, vuelva a intentar!  x");
            System.out.println("x x x x x x x x x x x x x x x x x x x x x");
            System.out.println(" ");

        }
        return validador;
    }

    /**
     * Carga la Lista de Usuarios registrados en "bdUsuarios.txt"
     */
    public boolean cargarBDUsuario() {
        boolean loaded;
        try {
            Scanner lector = new Scanner(archivoUsuarios);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");

                if (partes.length == 2) {
                    String nombre = partes[0];
                    String contraseña = partes[1];
                    Usuario usuAux = new Usuario(nombre, contraseña);
                    listaUsuarios.add(usuAux);
                }
            }
            lector.close(); // Cerramos el Lector
            System.out.println("Archivo recuperado exitosamente.");
            loaded = true;
        } catch (IOException e) {
            System.out.println("Error al recuperar el archivo: " + e.getMessage());
            loaded = false;
        }
        return loaded;
    }

    /**
     * Guarda la Lista de Usuarios registrados en "bdUsuarios.txt"
     */
    public boolean saveBDUsuario() {
        boolean saved;

        try {
            FileWriter escritor = new FileWriter(archivoUsuarios);

            for (Usuario usuario : listaUsuarios) {
                escritor.write(usuario.getNombre() + "," + usuario.getPassword() + "\n");
            }

            escritor.close(); // Cerramos el Escritor

            System.out.println("> La Base de Datos de Usuarios se ha guardado exitosamente.");
            saved = true;
        } catch (IOException e) {
            System.out.println("> Error al guardar el archivo Base de Datos de Usuarios: " + e.getMessage());
            saved = false;
        }
        return saved;
    }
}
