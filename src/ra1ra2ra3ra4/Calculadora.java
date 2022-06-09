package ra1ra2ra3ra4;

/**
 * Modela una Calculadora que registra  una serie de n�s (todos positivos)
 * y calcula  ciertas estad�sticas
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
     * a�ade un n� a la calculadora
     * Habr� que actualizar adecuadamente el estado de la calculadora
     *
     * @param numero el n� a contabilizar en la calculadora, se recibe un n� positivo
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
     * Muestra en pantalla las estad�sticas
     */
    public void printEstadisticas() {
        System.out.println("-----CALCULADORA-----\n");
        System.out.println("Total de n�meros: " + total);
        System.out.println("Acaban en 7: " + terminaEn7);
        System.out.println("Son potencia de dos: " +  potencias2);
        System.out.println("Son impares: " + impares);
        System.out.println("El impar m�ximo es: " + imparMaximo);
    }
}
