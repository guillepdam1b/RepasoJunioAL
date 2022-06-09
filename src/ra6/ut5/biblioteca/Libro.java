package ra6.ut5.biblioteca;
/**
 * Describe un libro de la biblioteca
 *
 */

public class Libro {
	private String titulo;
	private String autor;
	private Genero genero;
	private int ejemplares;

	/**
	 * Constructor de la clase Libro
	 * Recibe todos los datos de un libro en una
	 * cadena de caracteres de la forma
	 * "titulo:autor:genero:ejemplares"
	 * Ej. "Harry potter y el legado maldito:J. K.- Rowling:juvenil:6"
	 *      la Ciudad y los perros:mario- vargas llosa:novela:3
	 * 
	 * A partir de este valor hay que parsear la cadena para extraer
	 * los valores que se asignarán a los atributos. Todos los atributos
	 * se guardan en may?sculas y sin espacios a izquierda y derecha
	 * 
	 * autor contiene el nombre y apellidos del autor separados por un guión
	 * Esto permitirá nombres  compuestos y varios apellidos
	 * "nombre - apellidos" 
	 * 
	 * Ej.   mario- vargas llosa  
	 *       J. K.- Rowling
	 * 
	 * Hay que usar el método privado obtenerAutor()
	 *  (ver el contenido del fichero libros.txt)
	 */
	public Libro(String datosLibro) {
		String[] datos = datosLibro.split(":");
		titulo=datos[0].toUpperCase().trim();
		autor=obtenerAutor(datos[1].toUpperCase().trim());
		genero=Genero.valueOf(datos[2].toUpperCase().trim());
		ejemplares=Integer.parseInt(datos[3].toUpperCase().trim());
	}

	/**
	 *  Recibe el nombre de un autor de la forma "nombre - apellidos" y
	 *  lo devuelve como la cadena "APELLIDOS, NOMBRE"
	 *  No se puede utilizar split() ni charAt() en este método
	 */
	private String obtenerAutor(String autor) {
		String cadena = "";
		for (int i = 0; i < autor.length(); i++) {
			if (autor.substring(i,i+1)=="-"){

			}
		}
		return cadena;
	}

	/**
	 * 
	 * @return accesor para el titulo
	 *       
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * 
	 * @return devuelve el autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * 
	 * @return devuelve el género
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * 
	 * @return devuelve el nº de ejemplares
	 */
	public int getEjemplares() {
		return ejemplares;
	}

	/**
	 * 
	 * mutador para el nº de ejemplares
	 */
	public void incrementar(int ejemplares) {
		this.ejemplares += ejemplares;
	}

	/**
	 * 
	 * @return representación textual del libro
	 */
	public String toString() {
		String str = "\nTitulo: " + getTitulo() + "\nAutor: " + getAutor()
		        + "\nGénero: " + getGenero().toString() + "\tNº ejemplares: "
		        + getEjemplares();

		return str;
	}

	/**
	 *  
	 */
	public void printLibro() {
		System.out.println(this.toString());
	}

}
