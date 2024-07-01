package BubbleSort;
//complexidade de tempo: O(n^2) - pior caso, O(n) - melhor caso, O(n^2) - caso médio
public class Main {
    public static void main(String[] args) {
        int[] vetor = new int[10];

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }

        int computationalTime = 0;
        int aux = 0;//não pe possivel trocar os numeros de posição direto pelas posições, é necessario uma terceira variavel auxiliar que armazena o valor da frente para que o valor de tras passe pra frente, só entao o valor da frente pode ser passado para tras
        for(int i = 0; i < vetor.length; i++){//o i é o numero que vai ser comparado com os outros, o j é a variavel que vai percorrer todo o vetor comparando cada posição com a posição do i
            computationalTime++;
            for(int j = i + 1; j < vetor.length; j++){//como o j sempre vai começar na posição seguinte a do i, ele sempre vai receber o valor de i+1
                computationalTime++;
                if(vetor[i] > vetor[j]){//se o elemento i for maior que o elemento j, então eles devem trocar de lugar, isso vai ser verdade para cada um dos elementos que o j testar, isso garante que o menor elemento sempre vai estar na primeira posição
                    aux = vetor[j];//auxiliar armazenando o valor da frente
                    vetor[j] = vetor[i];//valor de tras indo pra frente
                    vetor[i] = aux;//valor da frente armazenado no auxiliar indo pra tras e fazendo a troca de posições
                }
            }
        }

        System.out.println("in order");
        for(int i = 0; i < vetor.length; i++) {
            System.out.println("vetor[" + i + "] = " + vetor[i]);
        }
        System.out.println("Computational time: " + computationalTime);
    }
}