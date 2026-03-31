public class No implements Comparable<No> {
    /*
    Logo apos terminar a Analise de Frequencia com o vetor de 256 posicoes, o proximo passo eh percorrer esse vetor.
    Para cada posicao que não estiver zerada, criar um objeto No usando o construtor de folhas.
    POR ENQUANTO, SERAO FOLHAS SOLTAS*
    */
    char caractere;
    int frequencia;
    No esquerda, direita;

    // construtor para as folhas (caracteres lidos)
    public No(char caractere, int frequencia){
        this.caractere = caractere;
        this.frequencia = frequencia;
        this.esquerda = null;
        this.direita = null;
    }
    // Construtor para nós internos (soma de frequencias)
    public No(int frequencia, No esquerda, No direita){
        this.caractere = '\0'; // nulo pois sao Nos internos, os unicos que precisam carregar seu devido carectere sao as folhas
        this.frequencia = frequencia; // exemplo: filho a esq tem freq 3 e o da dir tem freq 5, portanto o No interno tera freq 8
        this.esquerda = esquerda;
        this.direita = direita;
    }

    boolean eFolha() {
        return esquerda == null && direita == null;
    }

    @Override
    public int compareTo(No outroNo) {
        return this.frequencia - outroNo.frequencia;
    }
}
