package estudoArvore;

public class Elemento<TIPO> {//os elementos da arvore
    private TIPO valor;//valor do elemento
    private Elemento<TIPO> esquerda;//se o valor for menor que o nó atual, ele será adicionado a esquerda
    private Elemento<TIPO> direita;//se o valor for maior que o nó atual, ele será adicionado a direita

    public Elemento(TIPO novoValor) {//construtor do elemento
        this.valor = novoValor;//inicializa o valor do elemento com o valor passado como parametro
        this.esquerda = null;//inicializa o nó a esquerda como nulo porque ainda não foi adicionado nenhum elemento depois dele
        this.direita = null;//inicializa o nó a direita como nulo porque ainda não foi adicionado nenhum elemento depois dele
    }

    public TIPO getValor() {
        return valor;
    }

    public void setValor(TIPO valor) {
        this.valor = valor;
    }

    public Elemento<TIPO> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento<TIPO> esquerda) {
        this.esquerda = esquerda;
    }

    public Elemento<TIPO> getDireita() {
        return direita;
    }

    public void setDireita(Elemento<TIPO> direita) {
        this.direita = direita;
    }

    
    
}
