package biblioteca;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


public class Stock {

    private List<Libro> listaLibros = new ArrayList<Libro>();
    private File archivoLibros = new File("bdLibros.txt");

    // Atributos privados que solo se utilizan en las funciones de la Clase
    private Scanner sc = new Scanner(System.in);
    private String input;
    private Libro libroBuscado = null;
    private boolean bandera;

    // Constructor
    public Stock() {
    }

    // ---------------------------
    // |     Metodos Propios     |
    // ---------------------------

    // Getter
    /**
     * Devuelve la Lista de Libros
     * 
     * @return Un Array List de Objetos Libro
     */
    public List<Libro> getListaLibros() {
        return this.listaLibros;
    }

    /**
     * Seleccionar Libro por ID.
     * Este metodo imprime en pantalla la lista de titulos disponibles con su ID
     * Luego solicita que ingresemos un ID del libro buscado y nos lo devuelve.
     * 
     * @return El objeto tipo libro que estabamos buscando desde dentro del
     *         ArrayList
     */
    public Libro getLibroPorID() {

        System.out.println("--- Lista de Libros Disponibles ---");

        // Mostrar lista de libros a modificar
        showListaId(listaLibros);

        // Buble de selecion de Libro por ID
        do {
            bandera = true;
            System.out.print("> Ingrese el Id del Titulo: ");
            input = sc.nextLine();
            for (Libro libro : listaLibros) {
                if (libro.getId().equals(input.toUpperCase())) {
                    libroBuscado = libro;
                    bandera = false;
                }
            }
        } while (bandera);

        // Imprime el libro buscado en pantalla
        if (libroBuscado != null) {
            libroBuscado.showLibro();
        }
        System.out.println(" ");

        return libroBuscado;
    }

    /**
     * Ingresa un nuevo Libro a la Lista
     * 
     * @param libro
     */
    public void setLibroALista(Libro libro) {
        listaLibros.add(libro);
    }

    /**
     * Imprime todos los Libros con todos sus Atributos
     */
    public void showLibros() {
        int contador = 0;
        for (Libro libro : listaLibros) {
            libro.showLibro();
            contador++;
        }
        System.out.println("Total de Titulos disponibles: " + contador);
        System.out.println(" ");
    }

    /**
     * Imprime solo los Titulos con sus Cantidades y la sumatoria total de Libros en
     * la Biblioteca
     */
    public void showCantidad() {
        int contador = 0;
        for (Libro libro : listaLibros) {
            libro.showCantidad();
            contador = contador + libro.getCantidad();
        }
        System.out.println("En la Biblioteca hay: " + contador + " libros");
        System.out.println(" ");
    }

    /**
     * Imprime La lista de Titulos con sus IDs
     * 
     * @param listaLibros
     */
    public void showListaId(List<Libro> listaLibros) {
        for (Libro libro : listaLibros) {
            libro.showTituloID();
        }
        System.out.println(" ");
    }

    /**
     * Elimina un Libro de la lista de libros seleccionandolo por ID
     */
    public void eliminarLibroDeLista() {

        libroBuscado = getLibroPorID();

        System.out.print("> ¿Esta usted seguro que desea borrar? (S/N) ");
        input = sc.nextLine();
        System.out.println(" ");

        if(input.toUpperCase().equals("S")){

            Iterator<Libro> iterator = listaLibros.iterator();
            while (iterator.hasNext()) {
                
                Libro libro = iterator.next();
                
                if (libro.getId().equals(libroBuscado.getId())) {
                    
                    iterator.remove(); // Eliminar el libro de la lista
                }
            }
        }
    }

    /**
     * Carga la Lista de Libros registrados desde "bdLibros.txt" al ArrayList
     */
    public boolean cargarBDLibros() {
        boolean loaded;
        try {
            Scanner lector = new Scanner(archivoLibros);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String titulo = partes[0];
                    String autor = partes[1];
                    String editorial = partes[2];
                    String id = partes[3];
                    int cantidad = Integer.parseInt(partes[4]);
                    Libro libro = new Libro(titulo,autor,editorial,id,cantidad);
                    listaLibros.add(libro);
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
    public boolean saveBDLibros() {
        boolean saved;

        try {
            FileWriter escritor = new FileWriter(archivoLibros);
            
            for (Libro libro : listaLibros) {
                escritor.write(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getEditorial() + "," + libro.getId() + "," + libro.getCantidad() + "\n");
            }

            escritor.close(); // Cerramos el Escritor

            System.out.println("> La Base de Datos de Libros se ha guardado exitosamente.");
            saved = true;
        } catch (IOException e) {
            System.out.println("> Error al guardar el archivo Base de Datos de Libros: " + e.getMessage());
            saved = false;
        }
        return saved;
    }


}
