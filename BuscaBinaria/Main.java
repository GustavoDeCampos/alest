package BuscaBinaria;
//complexidade de tempo: O(log n) - pior caso, O(1) - melhor caso, O(log n) - caso médio
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[11];
        Scanner keyboard = new Scanner(System.in);

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = i;
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }
        System.out.print("Write the number you search: ");
        int searchedValue = keyboard.nextInt();

        boolean found = false;
        int comptutationalTime = 0;
        int begin = 0;
        int end = vetor.length - 1;
        int middle;
        while(begin <= end){ //garante que o algoritimo só vai funcionar enquanto o inicio estiver para a esquerda e o fim para a direita, caso o inicio seja maior que o fim, o valor não existe no vetor
            middle = (int) (begin + end) / 2; //para achar o meio do vetor, é necesario somar o inicio com o fim e dividir por 2
            comptutationalTime++;
            if(vetor[middle] == searchedValue){ //se o valor do meio do vetor for igual o valor procurado
                found = true;
                break;
            }else if(vetor[middle] < searchedValue){ //se o valor do meio for menor que o valor buscado, o inicio passa a ser o proximo valor de pois do meio, pois ja sabemos que nenhum numero antes do meio incluindo o meio é o valor buscado
                begin = middle + 1;
            }else{//se o valor buscado não está no meio e nem é maior que o valor do meio, então ele só pode ser menor, então o fim passa a ser a posição que vem antes do meio atual. pois sabemos que nenhum valor maior que o valor do meio incluindo o meio é o valor buscado
                end = middle - 1;
            }
        }

        if(found){
            System.out.println("Number found!");
        } else {
            System.out.println("Number not found!");
        }
        System.out.println("Computational time: " + comptutationalTime);
    }
}
