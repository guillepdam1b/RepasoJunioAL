package ra6.ut5.biblioteca;
import java.util.Arrays;

public class DemoBiblioteca {

	/**
	*  Punto de entrada a la aplicación. Contiene código para probar
	*  todos los métodos de la clase Biblioteca
	*/
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca("Biblioteca del IES M. Ana Sanz",
		        10);
		biblioteca.cargarDeFichero();

		System.out.println("\nSituación inicial de la biblioteca");
		System.out.println("--------------------------------------");
		System.out.println(biblioteca.toString());

		System.out.println("---------------------------");
		String str = "poTTer";
		String[] titulos = biblioteca.titulos(str);
		System.out.println("T?tulos ordenados que contienen la cadena \"" + str
		        + "\"\n" + Arrays.toString(titulos));

		System.out.println("---------------------------");
		String autor = "Vargas Llosa, Mario";
		int total = biblioteca.totalEjemplaresDeAutor(autor);
		System.out.println("\nEjemplares en la biblioteca del autor \"" + autor
		        + "\": " + total + "\n");

		System.out.println("---------------------------");
		Genero genero = Genero.BIOGRAFIA;
		biblioteca.borrarDeGenero(genero);
		System.out.println("\nDespués de borrar los títulos del género "
		        + genero.toString());
		System.out.println(biblioteca.toString());

	}

}
