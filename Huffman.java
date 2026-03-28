public class Huffman {
    public static void main(String[] args) {
        /*
        ------------------- DISCLAIMER -------------------
        TESTE ESCRITO PELO GPT, PODEMOS (OU DEVEMOS) TIRAR DEPOIS
        PARRA TESTAR, ESCREVA NO ARQUIVO teste.txt E PASSE O CAMINHO ABSOLUTO DO arquivo QUANDO RODAR O PROGRAMA
        */

        // 1. Instancia a classe de análise
        AnalisaFrequencia analisador = new AnalisaFrequencia();

        // 2. Chama o metodo e guarda o resultado no vetor 'freq'
        int[] freq = analisador.realizarAnalise();

        // 3. Teste: Imprimir caracteres encontrados (Etapa 1 do projeto) [cite: 127]
        System.out.println("\n--- TESTE DE FREQUÊNCIA ---");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                // Imprime o caractere (cast para char), o código ASCII e a frequência [cite: 129]
                System.out.println("Caractere '" + (char)i + "' (ASCII " + i + "): " + freq[i]);
            }
        }
    }
}