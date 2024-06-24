package recursividade;

import java.util.ArrayList;
import java.util.List;

public class fibonacci {
    public static void main(String[] args) {
        int numero = (int) (Math.random() * 20);

        System.out.println("Numero: " + numero);
        System.out.println("\nFibonacci:");
        List<Integer> fibonacciSequence = generateFibonacciSequence(numero);
        printFibonacciSequence(fibonacciSequence);
        
    }

    private static int nFibonacci(int numero){
        if(numero == 0){
            return 0;
        }else if(numero == 1){
            return 1;
        }else{
            return nFibonacci(numero - 1) + nFibonacci(numero - 2);
        }
    }

    private static List<Integer> generateFibonacciSequence(int numero) {
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i <= numero; i++) {
            sequence.add(nFibonacci(i));
        }
        return sequence;
    }

    private static void printFibonacciSequence(List<Integer> sequence) {
        for (int number : sequence) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
