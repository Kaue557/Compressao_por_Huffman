public class GeradorCodigos {

    public String[] gerarTabela(No raiz){
        String [] tabela = new String[256];
        caminhar(raiz, "", tabela);
        return tabela;

    }

    private void caminhar(No atual, String codigoAcumulado, String[] tabela) {
        // se o nó for nulo, apenas retorna para evitar erros
        if (atual == null) return;

        // Caso Base: Se o nó for uma folha, decodifica um caractere
        if (atual.esquerda == null && atual.direita == null) {
            tabela[atual.caractere] =
                    (codigoAcumulado.length() > 0) ? codigoAcumulado : "0";
            return;
        }
        // Caso Recursivo: Continua o "percurso guiado"

        // Se descer para o filho da esquerda, adiciona '0' ao código
        caminhar(atual.esquerda, codigoAcumulado + "0", tabela);

        // Se descer para a direita, adiciona '1' ao código
        caminhar(atual.direita, codigoAcumulado + "1", tabela);
    }
}
