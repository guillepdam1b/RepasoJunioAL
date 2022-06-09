package ra1ra2ra3ra4;

public class Numero {
    private int n;

    public Numero(int n) {
        this.n = n;
    }

    public int getValor() {
        return n;
    }

    /**
     * @return true si es impar
     *
     */
    public boolean esImpar() {
        if (n % 2 != 0){
            return true;
        }
        return false;
    }

    /**
     * @return true si termina en 7
     *
     */
    public boolean acabaEn7() {
        int num = n;
        int c = 0;
        while(num>100){
            num=num/10;
            c++;
        }
        int ultimoDigito = num%10;
        if (ultimoDigito == 7){
            return true;
        }
        return false;
    }

    /**
     * @return  true si n es una potencia de 2
     *
     * Por ejemplo, para n =  64 devuelve true
     *              para n = 1  devuelve true
     *              para n =  2  devuelve true
     *              para n = 6  devuelve false
     */
    public boolean esPotenciaDe2() {
        double num = (double) n;
        return Math.pow(num,2) % 1 == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }
}
