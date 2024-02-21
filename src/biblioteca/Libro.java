package biblioteca;
import java.util.Scanner;

public class Libro {

    // Campos
    private String titulo;
    private String autor;
    private String editorial;
    private String id;
    private int cantidad;

    // Atributo privado que solo se utiliza en las funciones de la Clase
    private Scanner sc = new Scanner(System.in);

    // Constructores
    public Libro(String titulo, String autor, String editorial, String id, int cantidad) {
        this.titulo = titulo.toUpperCase();
        this.autor = autor.toUpperCase();
        this.editorial = editorial.toUpperCase();
        this.id = id.toUpperCase();
        this.cantidad = cantidad;
    }

    public Libro() {
    }

    // Setters and Getters
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo.toUpperCase();
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor.toUpperCase();
    }

    public String getEditorial() {
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial.toUpperCase();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id.toUpperCase();
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // ---------------------------
    // |     Metodos Propios     |
    // ---------------------------

    /**
     * Ingresar libro parametro a parametro por teclado
     */
    public void setLibro() {

        String input;

        do {
            System.out.println("------------------------------");
            System.out.println("> Ingresaremos un nuevo Libro:");
            System.out.println("");
            System.out.print("- Titulo   : ");
            input = sc.nextLine();
            setTitulo(input);
            System.out.print("- Autor    : ");
            input = sc.nextLine();
            setAutor(input);
            System.out.print("- Editorial: ");
            input = sc.nextLine();
            setEditorial(input);
            System.out.print("- Código   : ");
            input = sc.nextLine();
            setId(input);

            // Se prepara al sistema por si usuario ingresa un String en vez de un nro
            boolean entradaValida = false;

            while (!entradaValida) {
                System.out.print("- Cantidad : ");
                input = sc.nextLine();

                try {
                    cantidad = Integer.parseInt(input);
                    entradaValida = true;
                } catch (NumberFormatException e) {
                    System.out.println(" ");
                    MenuPrincipal.opcionIncorrecta();
                }
            }


            System.out.println("------------------------------");
            System.out.println(" ");

            System.out.print("> ¿Los datos Ingresados son correctos? (S/N) ");
            input = sc.nextLine();
            input = input.toUpperCase();

        } while (!input.equals("S"));

        System.out.println("> ¡Nuevo Libro Ingresado Correctamente!");

        System.out.println(" ");
    }

    /**
     * Imprime en pantalla un libro con todos sus atributos
     */
    public void showLibro() {
        System.out.println("------------------------------");
        System.out.println("- Titulo   : " + titulo);
        System.out.println("- Autor    : " + autor);
        System.out.println("- Editorial: " + editorial);
        System.out.println("- Código   : " + id);
        System.out.println("- Cantidad : " + cantidad);
        System.out.println("------------------------------");
    }

    /**
     * Imprime El Titulo y la cantidad de libros de ese titulo que tenemos
     */
    public void showCantidad() {
        System.out.println("------------------------------");
        System.out.println("- Titulo : " + titulo + " - Cant: " + cantidad + " -");
        System.out.println("------------------------------");
    }

    /**
     * Imprime el Titulo y el ID de un libros
     */
    public void showTituloID() {
        System.out.println("------------------------------");
        System.out.println("- Titulo : " + titulo + " - ID: " + id + " -");
        System.out.println("------------------------------");
    }

}
