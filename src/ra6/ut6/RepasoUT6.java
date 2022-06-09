
package ra6.ut6;

import java.util.*;

/**
 * Define un atributo ciudades mediante un map que asocie un nombre de
 * ciudad con la relación de temperaturas medias habidas en
 * cada uno de los siete días de una semana concreta
 * Importa el orden de las ciudades
 *
 */

public class RepasoUT6 {

	private TreeMap<String, List<Double>> ciudades;

	/**
	 * inicializa adecuadamente el atributo
	 */
	public RepasoUT6() {
		ciudades = new TreeMap<>();
	}

	/**
	 * añade la ciudad y sus temperaturas al map
	 * Si la ciudad ya existe se muestra un mensaje y se ignoran los datos
	 * La ciudad siempre se añade en mayúsculas
	 * 
	 * datosCiudad contiene una cadena con la información de una ciudad.
	 * El formato de esta línea es ciudad:temperatura1:temperatura2:....:temperatura7
	 * Ejemplo      pamplona: 15.2: 17.4:15.2: 13:14:14.8: 15.1
	 * Puede haber espacios entre los datos
	 *  
	 */
	public void addCiudad(String datosCiudad) {
		ArrayList<Double> temperaturas = new ArrayList<>();
		String[] parse = datosCiudad.split(":");
		String ciudad = parse[0].toUpperCase();
		if (ciudades.containsKey(ciudad)){
			System.out.println("La ciudad " + ciudad + " existe");
		}else{
			for (int i = 1; i < parse.length; i++) {
				temperaturas.add(Double.parseDouble(parse[i].trim()));
			}
		}
		ciudades.put(ciudad,temperaturas);
	}


	/**
	 * dada una ciudad devuelve la temperatura media de la semana
	 * Si no existe la ciudad se devuelve -1
	 */
	public double mediaDe(String ciudad) {
		List<Double> temperaturas = ciudades.get(ciudad);
		double suma = 0.0;
		for (Double t : temperaturas) {
			suma+=t;
		}
		return suma / temperaturas.size();
	}

	/**
	 * muestra cada ciudad, sus temperaturas a lo largo de la semana
	 * y su temperatura media semanal foramteada a 2 decimales
	 * usar el conjunto de entradas
	 */
	public void mostrarMediaSemanal() {
		StringBuilder sb = new StringBuilder();
		for (String s : ciudades.keySet()) {
			List<Double> temperaturas = ciudades.get(s);
			sb.append(s + ": ");
			for (Double t : temperaturas) {
				sb.append(t + ", ");
			}
			sb.append("\n---- Media: " + String.format("%.2f",mediaDe(s)) + "\n");
		}
		System.out.println(sb.toString());
	}

	/**
	 * dada una ciudad borra todas las temperaturas inferiores a una dada
	 * Asumimos que existe la ciudad
	 * Se devuelve cuántas temperaturas se han borrado
	 */
	public int borrar(String ciudad, double temp) {
		List<Double> temperaturas = ciudades.get(ciudad.toUpperCase());
		int c = 0;
		for (int i = 0; i < temperaturas.size(); i++) {
			if (temperaturas.get(i)<=temp){
				temperaturas.remove(i);
				c++;
			}
		}
		return c;
	}

	/**
	 * 
	 * @return la ciudad en la que hubo la mayor temperatura en viernes
	 * (la primera encontrada)
	 */
	public String mayorTemperaturaViernes() {
		String ciudad = "";
		double max = 0.0;
		for (String s : ciudades.keySet()) {
			List<Double> temperaturas = ciudades.get(s);
			if (temperaturas.get(temperaturas.size()-2)>max){
				max= temperaturas.get(temperaturas.size()-2);
				ciudad = s;
			}
		}
		return ciudad;

	}

	/**
	 *  crea y devuelve un map pero ahora las claves son temperaturas medias
	 *  semanales y el valor asociado ciudades que han tenido esa temperatura media
	 *   
	 */
	public TreeMap<Double, TreeSet<String>> mismaTemperaturaMedia() {
		TreeMap<Double, TreeSet<String>> retorno = new TreeMap<>();
		TreeSet<String> ciudadesConTemp = new TreeSet<>();
		List<Double> temps = new ArrayList<>();
		for (String s : ciudades.keySet()) {
			temps.add(mediaDe(s));
		}
		for (int i = 0; i < temps.size(); i++) {
			for (String s : ciudades.keySet()) {
				if (mediaDe(s)==temps.get(i)){
					ciudadesConTemp.add(s);
				}
			}
			retorno.put(temps.get(i),ciudadesConTemp);
		}
		return retorno;

	}

	public static void main(String[] args) {
		RepasoUT6 repaso = new RepasoUT6();
		repaso.addCiudad("pamplona: 15.2: 17.4:15.2: 13:14:14.8: 15.1");
		repaso.addCiudad("zaragoza: 18: 19:21: 17:19:19: 22");
		repaso.addCiudad("vitoria: 15: 13:12: 11:14:15: 12.8");
		repaso.addCiudad("madrid: 21: 21 :17: 18:19:20: 21");
		repaso.addCiudad("bilbao: 15.1: 17.4:15.2: 13:14:14.8: 15.2");
		repaso.addCiudad("donosti: 18: 16:17: 17:16:16: 19");
		repaso.addCiudad("tudela: 19: 21 :19: 17:19:18: 22");
		repaso.addCiudad("huesca: 13: 15:11: 12:15:14: 12.8");

		System.out.println(" ----- mostrarMediaSemanal ----- \n");
		repaso.mostrarMediaSemanal();

		System.out.println("\n ----- borrar ----- \n");
		String ciudad = "madrid";
		double temp = 20;
		System.out.println("Borrando de " + ciudad
		        + " las temperaturas inferiores a " + temp);
		int borradas = repaso.borrar(ciudad, temp);
		System.out.println("Borradas" + borradas);
		repaso.mostrarMediaSemanal();

		System.out.println("\n ----- mayorTemperaturaViernes ----- \n");
		System.out.println("Mayor temperatura en viernes fue en "
		        + repaso.mayorTemperaturaViernes());

		System.out.println(" \n----- mismaTemperaturaMedia ----- \n");
		repaso.mismaTemperaturaMedia()
		        .forEach((temperatura, ciudades) -> System.out.println(
		                String.format("%5.2f", temperatura) + ":" + ciudades));
	}

}
