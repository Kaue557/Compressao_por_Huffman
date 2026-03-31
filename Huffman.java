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

        /*
        3.1.3 Passo 3: Construção da Árvore de Huffman
        Enquanto o Min-Heap tiver mais de um nó, remova os dois de menor frequência,
        combine-os em um novo nó interno e insira este novo nó de volta no heap.
        */
        while(heap.getSize() > 1){
            // remove os dois de menor frequencia
            No filho_esq = heap.extractMin();
            No filho_dir = heap.extractMin();

            // soma as frequencias de cada um
            int somaFrequencia = filho_esq.frequencia + filho_dir.frequencia;

            // cria um novo No usando o construtor de Nos internos da classe No
            No pai = new No(somaFrequencia, filho_esq, filho_dir);

            //coloca de volta no heap
            heap.insert(pai);
        }
        // Ao final do loop, sobra apenas um No no heap: a RAIZ da arvore
        No raiz = heap.extractMin();
        System.out.println("Arvore de Huffman PRONTA! Raiz tem frequencia: " + raiz.frequencia);

        // Passo 4: Geração da Tabela
        TabelaCodigos gerador = new TabelaCodigos();
        String[] dicionario = gerador.gerar(raiz); // O metodo recursivo acontece aih dentro

        // Teste de saida
        gerador.imprimirTabela();
    }
}