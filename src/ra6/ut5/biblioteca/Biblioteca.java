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
	 *  devuelve true si la biblioteca est� llena
	 *  (ya no se pueden a�adir m�s t�tulos distintos)
	 */
	public boolean estaLlena() {
		return pos==libros.length;
	}

	/**
	 * LLega un  libro  a la biblioteca y hay que a�adirlo
	 * El libro se a�ade de forma que quede ordenado por autor
	 * (ojo! no hay que ordenar sino insertar en orden)
	 * 
	 *  
	 *  Si el libro ya est� en la biblioteca
	 *  significa que llega un nuevo ejemplar de ese t�tulo
	 *  por lo tanto se incrementa el n� de ejemplares de ese libro
	 *  
	 *  Si no est� el t�tulo se a?ade como nuevo libro solo si hay sitio
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
		String abecedario="ABCDEFGHIJKLMN�OPQRSTUVWXYZ";
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
	 * Localiza  un libro dado su t�tulo
	 * Es indiferente may�sculas o min�sculas
	 * @return la posici?�n del libro si se encuentra o -1
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
	 *  Obtener todos los t�tulos diferentes
	 *  que contengan en su nombre la cadena str.
	 *  Es indiferente may�sculas o min�sculas
	 *  Los t�tulos se devuelven ordenados
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
	 * Es indiferente may�sculas o min�sculas
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
	 *  borrar los libros del g�nero indicado
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
	 * Representaci�n textual de la biblioteca
	 * Hacerlo de forma eficiente
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Biblioteca - " + nombre + "\n");
		for (int i = 0; i < libros.length; i++) {
			sb.append("Libro n� " + (i+1));
			sb.append(libros[i].toString());
		}
		return sb.toString();
	}

	/**
	 * Lee de un fichero de texto los datos de los libros
	 *   con ayuda de un objeto de la  clase Scanner
	 *   y los guarda en el array. El m�todo devuelve
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
					System.out.println("Error al procesar l�nea de fichero");
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}


	}

}
