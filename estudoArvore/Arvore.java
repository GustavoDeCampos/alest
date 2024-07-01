package estudoArvore;

public class Arvore<TIPO extends Comparable> {
    private Elemento<TIPO> raiz;//raiz da arvore, o primeiro elemento a ser adicionado

    public Arvore() {
        this.raiz = null;//inicializa a raiz da arvore como nula
    }

    public void adicionar(TIPO valor){
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);//ao chamar o metodo adicionar, adiciona um novo elemento na arovre
        if(raiz == null){//se a raiz da arvore estiver nula, o primeiro elemento a ser adicionado sera a raiz da arvore
            this.raiz = novoElemento;
        }else{//se a raiz não estiver nula, será necessario caminhar para esquerda e para a direita dependendo se o numero é maior ou menor que os nós anteriores
            Elemento<TIPO> atual = this.raiz;//o elemento atual é a raiz da arvore pois é o elemento que vai ser comparado com o novo elemento
            while (true) {//loop para comparar o novo elemento com o elemento atual
                if(novoElemento.getValor().compareTo(atual.getValor()) == -1){//se o valor do novo elemento for menor que o valor do elemento atual da arvore
                    if(atual.getEsquerda() != null){//se o nó a esquerda do elemento atual não for nulo, ou seja, se esse nó ja tiver um elemento a esquerda dele
                        atual = atual.getEsquerda();//vai comparar o novo elemento com o nó a esquerda do elemento atual, por exemplo se a raiz é 10 e o novo elemento é 5, mas o 10 ja tem o 8 á sua esquerda, o 5 nao vai ser comparado com o 10, mas sim com o 8 e sera mandado para a esquerda do 8
                    }else{//caso o valor atual não tenha um nó a esquerda
                        atual.setEsquerda(novoElemento);//o novo elemento será adicionado a esquerda do elemento atual
                        break;//sai do loop depois de adicionar o novo elemento
                    }
                }else{//caso o novo elemento seja maior ou igual ao elemento atual
                    if(atual.getDireita() != null){//se o atual tem direita, então o novo elemento será comparado com o nó a direita do atual e assim sucessivamente até encontrar um nó sem direita
                        atual = atual.getDireita();
                    }else{//caso o atual não tenha direita
                        atual.setDireita(novoElemento);//o novo elemento será adicionado a direita do atual
                        break;//sai do loop depois de adicionar o novo elemento
                    }
                }
            }
        }
    }

    public boolean remover(TIPO valor){
        //buscar elemento para saber se ele existe
        Elemento<TIPO> atual = this.raiz; //toda arvore começa a ser percorrida pela raiz
        Elemento<TIPO> paiAtual = null; //o pai do atual começa nulo pois o atual começa pela raiz e a raiz não tem pai, pois é o primeiro elemento
        while (atual != null) {//enquanto o atual não for nulo
            if(atual.getValor().equals(valor)){//se o valor do atual for igual ao valor que queremos remover
                break;//sai do loop
            //se não for igual, então é diferente, logo, é necessario fazer uma comparação para saber se o valor que queremos remover é maior ou menor que o valor do atual
            }else if(valor.compareTo(atual.getValor()) == -1){//se o valor que queremos remover for menor que o valor do atual
                paiAtual = atual;//o pai do atual passa a ser o atual anterior
                atual = atual.getEsquerda();//o atual passa a ser o nó a esquerda do atual
            }else{//se o valor não é igual nem menor, ele só pode ser maior
                paiAtual = atual;//o pai do atual passa a ser o atual anterior
                atual = atual.getDireita();//o atual passa a ser o nó a direita do atual
            }
        }
    
        //verifica se existe o elemento
        if(atual != null){
            //caso 1: o elemento a ser removido tem filhos a esquerda e a direita ou só a direita
            if(atual.getDireita() != null){
                Elemento<TIPO> substituto = atual.getDireita();//o substituto do atual será o nó a direita do atual
                Elemento<TIPO> paiSubstituto = atual;//o pai do substituto será o atual pois o substituto é o nó a direita do atual
                while(substituto.getEsquerda() != null){//o objetivo é que o substituto seja o mais proximo possivel do valor removido, então ele vai para a esquerda até encontrar um nó sem esquerda
                    paiSubstituto = substituto;//o pai do substituto passa a ser o substituto
                    substituto = substituto.getEsquerda();//o substituto passa a ser o nó a esquerda do substituto
                }
                if(paiSubstituto != atual){//se o pai do substituto for diferente do atual, significa que o substituto não é o nó a direita do atual, então ele é o nó a esquerda de um nó a direita do atual
                    paiSubstituto.setEsquerda(substituto.getDireita());//o nó a esquerda do pai do substituto passa a ser o nó a direita do substituto
                    substituto.setDireita(atual.getDireita());//o nó a direita do substituto passa a ser o nó a direita do atual
                }
                substituto.setEsquerda(atual.getEsquerda());//o nó a esquerda do substituto passa a ser o nó a esquerda do atual

                if(paiAtual != null){//em caso de remover a raiz, o paiAtual vai ser null, então é necessario verificar se o paiAtual é diferente de null
                    if(atual.getValor().compareTo(paiAtual.getValor()) == -1){//se o valor do atual for menor que o valor do pai do atual, significa que o atual é o nó a esquerda do pai
                        paiAtual.setEsquerda(substituto);//o nó a esquerda do pai do atual passa a ser o substituto
                    }else{//se o valor atual não é menor que o valor do pai do atual, então ele só pode ser maior ou igual, logo, o atual é o nó a direita do pai
                        paiAtual.setDireita(substituto);//o nó a direita do pai do atual passa a ser o substituto
                    }
                }else{
                    this.raiz = substituto;//se o paiAtual for nulo, então o substituto passa a ser a raiz da arvore
                }
                //uma vez que o substituto foi copiado para o lugar do atual, ele precisa ser removido do lugar onde estava
                if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){//se o valor do substituto for menor que o valor do pai do substituto, significa que o substituto é o nó a esquerda do pai
                    paiSubstituto.setEsquerda(null);//o nó a esquerda do pai do substituto passa a ser nulo
                }else{//se o valor do substituto não é menor que o valor do pai do substituto, então ele só pode ser maior ou igual, logo, o substituto é o nó a direita do pai
                    paiSubstituto.setDireita(null);//o nó a direita do pai do substituto passa a ser nulo
                }
            }else if(atual.getEsquerda() != null){//caso 2: o elemento a ser removido só tem filho a esquerda
                Elemento<TIPO> substituto = atual.getEsquerda();//o substituto do atual será o nó a esquerda do atual
                Elemento<TIPO> paiSubstituto = atual;//o pai do substituto será o atual pois o substituto é o nó a esquerda do atual
                while(substituto.getDireita() != null){//o objetivo é que o substituto seja o mais proximo possivel do valor removido, então ele vai para a direita até encontrar um nó sem direita
                    paiSubstituto = substituto;//o pai do substituto passa a ser o substituto
                    substituto = substituto.getDireita();//o substituto passa a ser o nó a direita do substituto
                }

                if(paiAtual != null){//em caso de remover a raiz, o paiAtual vai ser null, então é necessario verificar se o paiAtual é diferente de null
                    if(atual.getValor().compareTo(paiAtual.getValor()) == -1){//se o valor do atual for menor que o valor do pai do atual, significa que o atual é o nó a esquerda do pai
                        paiAtual.setEsquerda(substituto);//o nó a esquerda do pai do atual passa a ser o substituto
                    }else{//se o valor atual não é menor que o valor do pai do atual, então ele só pode ser maior ou igual, logo, o atual é o nó a direita do pai
                        paiAtual.setDireita(substituto);//o nó a direita do pai do atual passa a ser o substituto
                    }
                }else{
                    this.raiz = substituto;//se o paiAtual for nulo, então o substituto passa a ser a raiz da arvore
                }
                //uma vez que o substituto foi copiado para o lugar do atual, ele precisa ser removido do lugar onde estava
                if(substituto.getValor().compareTo(paiSubstituto.getValor()) == -1){//se o valor do substituto for menor que o valor do pai do substituto, significa que o substituto é o nó a esquerda do pai
                    paiSubstituto.setEsquerda(null);//o nó a esquerda do pai do substituto passa a ser nulo
                }else{//se o valor do substituto não é menor que o valor do pai do substituto, então ele só pode ser maior ou igual, logo, o substituto é o nó a direita do pai
                    paiSubstituto.setDireita(null);//o nó a direita do pai do substituto passa a ser nulo
                }
            }else{//caso 3: o elemento a ser removido não tem filhos

                if(paiAtual != null){//em caso de remover a raiz, o paiAtual vai ser null, então é necessario verificar se o paiAtual é diferente de null
                    if(atual.getValor().compareTo(paiAtual.getValor()) == -1){//se o valor do atual for menor que o valor do pai do atual, significa que o atual é o nó a esquerda do pai
                        paiAtual.setEsquerda(null);//o nó a esquerda do pai do atual passa a ser nulo
                    }else{//se o valor atual não é menor que o valor do pai do atual, então ele só pode ser maior ou igual, logo, o atual é o nó a direita do pai
                        paiAtual.setDireita(null);//o nó a direita do pai do atual passa a ser nulo
                    }
                }else{
                    this.raiz = null;//se o paiAtual for nulo, então a raiz da arvore passa a ser nula
                }
                
            }
    
            return true; //se o atual for diferente de nulo, então o elemento existe
        }else{
            return false; //se o atual for nulo, então o elemento não existe
        }
    }


    public void emOrdem(Elemento<TIPO> atual){
        if(atual != null){
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());
        }
    }

    public void preOrdem(Elemento<TIPO> atual){
        if(atual != null){
            System.out.println(atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());
        }
    }

    public void posOrdem(Elemento<TIPO> atual){
        if(atual != null){
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println(atual.getValor());
        }
    }

    public Elemento<TIPO> getRaiz() {
        return raiz;
    }

    public void setRaiz(Elemento<TIPO> raiz) {
        this.raiz = raiz;
    }
}
