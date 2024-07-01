package BuscaLinear;
//complexidade de tempo: O(n) - pior caso, O(1) - melhor caso, O(n) - caso médio
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] vetor = new int[8];

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * 10);
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }

        System.out.print("Write the number you search: ");
        int valor = keyboard.nextInt();

        int comptutationalTime = 0;
        boolean found = false;
        for(int i = 0; i < vetor.length; i++){
            comptutationalTime++;
            if(vetor[i] == valor){
                found = true;
                break;
            }
            
        }

        if(found){
            System.out.println("Number found!");
        } else {
            System.out.println("NUmber not found!");
        }
        System.out.println("Computational time: " + comptutationalTime);
    }
}
