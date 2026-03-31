public class Descompressao {

    public static String descomprimir(String binario, No raiz) {
        StringBuilder resultado = new StringBuilder();
        No atual = raiz;

        for (int i = 0; i < binario.length(); i++) {
            char bit = binario.charAt(i);

            if (bit == '0') {
                atual = atual.esquerda;
            } else if (bit == '1') {
                atual = atual.direita;
            }

            // Quando chega em uma folha, adiciona o caractere
            if (atual.eFolha()) {
                resultado.append(atual.caractere);
                atual = raiz; // volta para a raiz
            }
        }
        return resultado.toString();
    }
}