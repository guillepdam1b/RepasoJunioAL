package ra6.ut5.biblioteca;

/**
 * Modela una biblioteca
 *  
 */
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Biblioteca {

	private String nombre;
	private Libro[] libros;
	private int pos;

	/**
	 * Constructor de la clase Biblioteca
	 */
	public Biblioteca(String nombre, int n) {
		this.nombre=nombre;
		libros=new Libro[n];
		pos=0;
	}

	/**
	 * Accesor para el nombre de la biblioteca
	 * 
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 *  devuelve true si la biblioteca está llena
	 *  (ya no se pueden añadir más títulos distintos)
	 */
	public boolean estaLlena() {
		return pos==libros.length;
	}

	/**
	 * LLega un  libro  a la biblioteca y hay que añadirlo
	 * El libro se añade de forma que quede ordenado por autor
	 * (ojo! no hay que ordenar sino insertar en orden)
	 * 
	 *  
	 *  Si el libro ya está en la biblioteca
	 *  significa que llega un nuevo ejemplar de ese título
	 *  por lo tanto se incrementa el nº de ejemplares de ese libro
	 *  
	 *  Si no está el título se a?ade como nuevo libro solo si hay sitio
	 *   
	 *   
	 */
	public void addLibro(Libro libro) {
		for (int i = 0; i < libros.length; i++) {
			// INSERTAR EN ORDEN
			if (libros[i].getTitulo()!= libro.getTitulo() && !estaLlena()) {
				if (posicionLetra(libros[i].getTitulo().substring(0,1),libros[i+1].getTitulo().substring(0,1))==1){
					libros[i]=libro;
				}
			}
			if (libros[i].equals(libro)){
				libro.incrementar(1);
			}
		}
	}

	private int posicionLetra(String pal1, String pal2){
		String abecedario="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		String letra1 = pal1.substring(0,1);
		String letra2 = pal2.substring(0,1);
		for (int i = 0; i < abecedario.length(); i++) {
			if (letra1==abecedario.substring(i,i+1)){
				return 1;
			}
			if (letra2==abecedario.substring(i,i+1)){
				return -1;
			}
		}
		return 0;
	}

	/**
	 * Localiza  un libro dado su título
	 * Es indiferente mayúsculas o minúsculas
	 * @return la posici?ón del libro si se encuentra o -1
	 *          si no existe 
	 */
	public int localizarLibro(String titulo) {
		for (int i = 0; i < libros.length; i++) {
			if (libros[i].getTitulo().contains(titulo)){
				return i;
			}
		}
		return -1;

	}

	/**
	 *  Obtener todos los títulos diferentes
	 *  que contengan en su nombre la cadena str.
	 *  Es indiferente mayúsculas o minúsculas
	 *  Los títulos se devuelven ordenados
	 */
	public String[] titulos(String str) {
		String[] titulos = new String[pos];
		int c=0;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i].getTitulo().contains(str)){
				titulos[c]=libros[i].getTitulo();
				c++;
			}
		}
		Arrays.sort(titulos);
		return titulos;
	}

	/**
	 * Cantidad de ejemplares de todos los libros
	 * del autor indicado
	 * Es indiferente mayúsculas o minúsculas
	 */
	public int totalEjemplaresDeAutor(String autor) {
		int c=0;
		for (int i = 0; i < libros.length; i++) {
			if (libros[i].getTitulo().contains(autor)){
				c+=libros[i].getEjemplares();
			}
		}
		return c;
	}

	/**
	 *  borrar los libros del género indicado
	 */
	public void borrarDeGenero(Genero genero) {
		for (int i = 0; i < libros.length; i++) {
			if (libros[i].getGenero()==genero){
				this.libros[i - 1] = this.libros[i];
				pos--;
			}
		}
	}

	/**
	 * Representación textual de la biblioteca
	 * Hacerlo de forma eficiente
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Biblioteca - " + nombre + "\n");
		for (int i = 0; i < libros.length; i++) {
			sb.append("Libro nº " + (i+1));
			sb.append(libros[i].toString());
		}
		return sb.toString();
	}

	/**
	 * Lee de un fichero de texto los datos de los libros
	 *   con ayuda de un objeto de la  clase Scanner
	 *   y los guarda en el array. El método devuelve
	 *   la cantidad de libros que no han podido ser registrados
	 */
	public void cargarDeFichero() {
		try (Scanner fichero = new Scanner(new File("resources/libros.txt"));) {
			while (fichero.hasNextLine()) {
				try {
					Libro libro = new Libro(fichero.nextLine());
					addLibro(libro);
				}
				catch (NumberFormatException e) {
					System.out.println("Error al procesar línea de fichero");
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
