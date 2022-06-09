
package ra6.ut5;

import java.util.Arrays;
import java.util.Random;

public class  RepasoUT5 {

	private static final Random generador = new Random();

	/**
	*  crea un array valores de tamaño tam e inicialízalo
	*  con valores aleatorios entre 5 y 15 (inclusive)
	*  usa el generador para los valores aleatorios
	*/
	public int[] inicializarEnRango(int tam) {
		int[] array = new int[tam];
		for (int i = 0; i < array.length; i++) {
			array[i]=generador.nextInt();
		}
		return array;
	}

	/**
	 *  Dado un array devuelve otro del mismo tamaño
	 *  en el que en cada posición queda la suma de las cifras
	 *  de cada elemento de array
	 *  Si el array recibido es {2034, 12, 223, 5432, 9999}
	 *  el nuevo array será {9, 3, 7, 14, 36}
	 *
	 *  Utiliza sumarCifras()
	 *    
	 */
	public int[] sumarCifras(int[] array) {
		int[] cifras = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			cifras[i]=sumarCifras(array[i]);
		}
		return cifras;
	}

	/**
	*  Dado un nº devuelve la suma de sus cifras
	*  No se puede convertir a String
	*  Usa exlusivamente enteros 
	*/
	public int sumarCifras(int n) {
		int total=0;
		while(n > 0) {
			total += n % 10;
			n = n / 10;
		}
		return total;

	}

	/**
	 *  Dado un array devuelve uno nuevo del mismo tamaño
	 *  en el que se guarda  en cada posición el cuadrado del
	 *  valor que está a la derecha en el original
	 *  Para el último valor se considera que está a la derecha
	 *  el primero
	 *  Si el array recibido es {7, 6, 9,  3, 4}
	 *   el nuevo array ser? {36, 81, 9, 16, 49}
	 */
	public int[] cuadrados(int[] array) {
		int[] array2=new int[array.length];
		int pos=(array2.length-2);
		for (int i = array.length-1; i >= 0; i--) {
			if (i!=0){
				array2[pos]=array[i]*array[i];
				pos--;
			}
			else {
				array2[array2.length-1]=array[i]*array[i];
			}
		}
		return array2;

	}

	/**
	 *  Calcula y devuelve la posición de la fila con suma máxima
	 *  Si array2d = { {1, 2, 3, 4},
	 *                  {5, 13, 6, 7},
	 *                  {3, 7, 8, 2},
	 *                  {9, 8, 7, 5} }
	 *      
	 *  se devolvería 1
	 */
	public int sumaMaxima(int[][] array2D) {
		int resultado=0;
		int pos=0;
		for (int i = 0; i < array2D.length; i++) {
			int suma = 0;
			for (int j = 0; j < array2D[i].length; j++) {
				suma+=array2D[i][j];
			}
			if (suma>resultado){
				resultado=suma;
				pos=i;
			}
		}
		return pos;
	}

	/**
	 *  Dada una cadena devuelve un array con tantas filas y columnas
	 *  como caracteres tenga cadena, y con el contenido indicado
	 *  
	 *  Si cadena = "prueba" se devuelve
	 *  {   {'p', 'p', 'p','p', 'p', 'p'},
	 *      {'r', 'r', 'r','r', 'r', 'r'},
	 *      {'u', 'u', 'u','u', 'u', 'u'},
	 *      {'e', 'e', 'e','e', 'e', 'e'},
	 *      {'b', 'b', 'b','b', 'b', 'b'},
	 *      {'a', 'a', 'a','a', 'a', 'a'} }
	 *   
	 */
	public char[][] strToArray2D(String cadena) {
		int pos = 0;
		char[][] array = new char[cadena.length()][cadena.length()];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j]=cadena.charAt(pos);
			}
			pos++;
		}
		return array;

	}

	/**
	 *  Dada una cadena si tiene una longitud mayor o igual a 3 se
	 *  tranforma en otra nueva. La nueva incluye primer carácter y último en minúsculas
	 *  y el resto en mayúsculas.
	 *  
	 *  Ej - Si cadena = "chaleco" devuelve "cHALECo"
	 *  	Si cadena = "LA" devuelve "LA"
	 *  	Si cadena = "de" devuelve "de"
	 *  	Si cadena = "PALMERA" devuelve "pALMERa"
	 *  
	 */
	public String tranformar(String cadena) {
		cadena.toUpperCase();
		if (cadena.length()>=3){
			for (int i = 0; i < cadena.length(); i++) {
				if (i==1 || i < (cadena.length())-1){
					String.valueOf(cadena.charAt(i)).toLowerCase();
				}
			}
		}
		return cadena;

	}

	/**
	*  Dado un array bidimensional de cadenas hay que obtener un subarrary
	*  con las columnas indicadas transformadas
	*  
	*  obtenerSubarray(array2D, 2, 4) transforma las columnas 2, 3 y 4
	*  devolviendolas como un nuevo array de 2 dimensiones
	*  
	*  obtenerSubarray(array2D, 0, 2) transforma las columnas 0, 1 y 2
	*  devolviendolas como un nuevo array de 2 dimensiones
	*   
	*  La transformación consiste en sustituir cada palabra del original
	*  por una nueva haciendo uso del método transformar()
	*/
	public String[][] obtenerSubarray(String[][] array2D, int c1, int c2) {

		return null;

	}




	public static void main(String[] args) {

		RepasoUT5 repaso = new RepasoUT5();
		System.out.println(" ----- inicializarEnRango ----- ");
		System.out.println(Arrays.toString(repaso.inicializarEnRango(10)));

		System.out.println(" ----- sumarCifras ----- ");
		int[] valores = new int[] { 2034, 12, 223, 5432, 9999 };
		System.out.println(Arrays.toString(valores));
		System.out.println(Arrays.toString(repaso.sumarCifras(valores)));

		System.out.println(" ----- cuadrados ----- ");
		valores = new int[] { 7, 6, 9, 3, 4 };
		System.out.println(Arrays.toString(valores));
		System.out.println(Arrays.toString(repaso.cuadrados(valores)));

		System.out.println(" ----- sumaMaxima ----- ");
		int[][] numeros = { { 1, 2, 3, 4 }, { 5, 13, 6, 7 }, { 3, 7, 8, 2 },
		        { 9, 8, 7, 5 } };

		System.out
		                .println("Fila de suma máxima: "
		                                + repaso.sumaMaxima(numeros));

		System.out.println(" ----- strToArray2D ----- ");
		String cadena = "prueba";
		System.out.println("Cadena " + cadena + " a array2D: ");
		for (char[] fila : repaso.strToArray2D(cadena)) {
			System.out.println(Arrays.toString(fila));
		}

		System.out.println(" ----- obtenerSubarray ----- ");
		String[][] array2D = new String[][] {
		        { "pez", "martillo", "CARAmelo", "casa", "zapato" },
		        { "banco", "Boa", "zapatilla", "la", "bolso" },
		        { "cine", "de", "ayuntamiento", "aULA", "estudiante" },
		        { "ordenador", "DISCO", "usb", "campanario", "y" },
		        { "arteria", "reloj", "vestido", "OLA", "DEDIcatorIA" }, };

		System.out.println("Antes de tranformar el array2D\n ");
		for (String[] fila : array2D) {
			System.out.println(Arrays.toString(fila));
		}
		int c1 = 2;
		int c2 = 4;
		String[][] tranformado = repaso.obtenerSubarray(array2D, c1, c2);
		System.out.println("\nDespués de tranformar el array2D desde columna "
		                + c1 + " hasta columna " + c2 + "\n ");
		for (String[] fila : tranformado) {
			System.out.println(Arrays.toString(fila));
		}

		c1 = 0;
		c2 = 2;
		tranformado = repaso.obtenerSubarray(array2D, c1, c2);
		System.out.println("\nDespués de tranformar el array2D desde columna "
		                + c1 + " hasta columna " + c2 + "\n ");
		for (String[] fila : tranformado) {
			System.out.println(Arrays.toString(fila));
		}
	}
}
