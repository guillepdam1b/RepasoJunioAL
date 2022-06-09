package ra1ra2ra3ra4;

/**
 * Modela una Calculadora que registra  una serie de nºs (todos positivos)
 * y calcula  ciertas estadísticas
 */
public class Calculadora {
    private int total;
    private int potencias2;
    private int terminaEn7;
    private int impares;
    private Numero imparMaximo;

    /**
     * constructor para los objetos de la clase Calculadora
     * inicializa adecuadamente los atributos
     */
    public Calculadora() {
        total=0;
        potencias2=0;
        terminaEn7=0;
        impares=0;
        imparMaximo=new Numero(0);
    }

    /**
     * añade un nº a la calculadora
     * Habrá que actualizar adecuadamente el estado de la calculadora
     *
     * @param numero el nº a contabilizar en la calculadora, se recibe un nº positivo
     */
    public void addNumero(Numero numero) {
        total++;
        if (numero.esPotenciaDe2()){
            potencias2++;
        }
        if (numero.acabaEn7()){
            terminaEn7++;
        }
        if (numero.esImpar()){
            impares++;
        }
        if (numero.getValor()>imparMaximo.getValor()){
            imparMaximo=numero;
        }
    }

    /**
     * Muestra en pantalla las estadísticas
     */
    public void printEstadisticas() {
        System.out.println("-----CALCULADORA-----\n");
        System.out.println("Total de números: " + total);
        System.out.println("Acaban en 7: " + terminaEn7);
        System.out.println("Son potencia de dos: " +  potencias2);
        System.out.println("Son impares: " + impares);
        System.out.println("El impar máximo es: " + imparMaximo);
    }
}
