package ra1ra2ra3ra4;

import java.util.Scanner;

/**
 * Clase AppCalculadora -  incluye el método main()
 * Arranca la aplicación
 */
public class AppCalculadora {

    /**
     * Crea un objeto Calculadora, pide por teclado al
     * usuario números hasta que se teclee 0,
     * valida que sean positivos, añádelos a la calculadora y
     * muestra al final las estadísticas
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        int numero=0;
        System.out.println("Introduce números. El cero para salir");
        do {
            System.out.println("Número: ");
            numero = sc.nextInt();
            if (numero<=0){
                System.out.println("El número debe ser positivo");
            }else {
                Numero n = new Numero(numero);
                calculadora.addNumero(n);
            }
        } while (numero!=0);
        calculadora.printEstadisticas();
    }
}
