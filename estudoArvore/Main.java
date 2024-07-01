package estudoArvore;

public class Main {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<Integer>();
        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(5);
        arvore.adicionar(9);
        arvore.adicionar(7);
        arvore.adicionar(18);
        arvore.adicionar(13);
        arvore.adicionar(20);


        //em ordem: esquerda, cima, direita
        System.out.println("\n\nEm ordem:");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(20);//removendo um nó sem filhos
        System.out.println("\n\nEm ordem:");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(5);//removendo um nó com um filho
        System.out.println("\n\nEm ordem:");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(8);//removendo um nó com dois filhos
        System.out.println("\n\nEm ordem:");
        arvore.emOrdem(arvore.getRaiz());

        arvore.remover(10);//removendo a raiz
        System.out.println("\n\nEm ordem:");
        arvore.emOrdem(arvore.getRaiz());

        //pre ordem: cima, esquerda, direita
        System.out.println("\n\npré-ordem:");
        arvore.preOrdem(arvore.getRaiz());

        //pos ordem: esquerda, direita, cima
        System.out.println("\n\npós-ordem:");
        arvore.posOrdem(arvore.getRaiz());

        
    }
}
