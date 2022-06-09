package ra1ra2ra3ra4;

import java.util.Scanner;

/**
 * Clase AppCalculadora -  incluye el m�todo main()
 * Arranca la aplicaci�n
 */
public class AppCalculadora {

    /**
     * Crea un objeto Calculadora, pide por teclado al
     * usuario n�meros hasta que se teclee 0,
     * valida que sean positivos, a��delos a la calculadora y
     * muestra al final las estad�sticas
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        int numero=0;
        System.out.println("Introduce n�meros. El cero para salir");
        do {
            System.out.println("N�mero: ");
            numero = sc.nextInt();
            if (numero<=0){
                System.out.println("El n�mero debe ser positivo");
            }else {
                Numero n = new Numero(numero);
                calculadora.addNumero(n);
            }
        } while (numero!=0);
        calculadora.printEstadisticas();
    }
}
