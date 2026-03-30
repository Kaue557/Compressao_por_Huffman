public class Huffman {
    public static void main(String[] args) {
        /*
        ------------------- DISCLAIMER -------------------
        TESTE ESCRITO PELO GPT, PODEMOS (OU DEVEMOS) TIRAR DEPOIS
        PARRA TESTAR, ESCREVA NO ARQUIVO teste.txt E PASSE O CAMINHO ABSOLUTO DO arquivo QUANDO RODAR O PROGRAMA
        */

        // 1. Instancia a classe de analise
        AnalisaFrequencia analisador = new AnalisaFrequencia();

        // 2. Chama o metodo e guarda o resultado no vetor 'freq'
        int[] freq = analisador.realizarAnalise();

        // 3. Teste: Imprimir caracteres encontrados (Etapa 1 do projeto)
        System.out.println("\n--- TESTE DE FREQUÊNCIA ---");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                // Imprime o caractere (cast para char), o código ASCII e a frequência
                System.out.println("Caractere '" + (char)i + "' (ASCII " + i + "): " + freq[i]);
            }
        }

        //---------------------------------------------------------------------------------------
        // 1. Criar o Min-Heap
        MinHeap heap = new MinHeap();

        // 2. Criar os nós folha e inserir no heap (Passo 2 do projeto)
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                No folha = new No((char) i, freq[i]);
                heap.insert(folha);
            }
        }

        System.out.println("Min-Heap inicial construído com sucesso!");

        // Próximo passo será o loop de extração para montar a árvore...
    }
}