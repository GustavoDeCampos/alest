package recursividade;

public class fatorial {
    public static void main(String[] args) {
        int numero = (int) (Math.random() * 10);

        System.out.println("Numero: " + numero);

        System.out.println("\n\nFatorial:");
        System.out.println(nFatorial(numero));
    }

    private static int nFatorial(int numero){
        if(numero == 0){
            return 1;
        }else{
            return numero * nFatorial(numero-1);
        }
    }
}
