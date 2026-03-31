public class GeradorCodigos {

    public String[] gerarTabela(No raiz){
        String [] tabela = new String[256];
        caminhar(raiz, "", tabela);
        return tabela;

    }

    private void caminhar(No atual, String codigoAcumulado, String[] tabela) {
        // 1. Segurança: se o nó for nulo, apenas retorna para evitar erros
        if (atual == null) return;

        // 2. Caso Base: Se o nó for uma folha, decodificamos um caractere!
        if (atual.esquerda == null && atual.direita == null) {
            // Guardamos o código acumulado no índice correspondente ao caractere
            tabela[atual.caractere] = codigoAcumulado;
            return;
        }
        // 3. Caso Recursivo: Continuamos o "percurso guiado"

        // Se descermos para o filho da esquerda, adicionamos '0' ao código
        caminhar(atual.esquerda, codigoAcumulado + "0", tabela);

        // Se descermos para a direita, adicionamos '1' ao código
        caminhar(atual.direita, codigoAcumulado + "1", tabela);
    }
}
