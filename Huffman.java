public class Huffman {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java -jar huffman.jar <c/d> <origem> <destino>");
            return;
        }

        String comando = args[0];
        String origem = args[1];
        String destino = args[2];

        try {
            if (comando.equalsIgnoreCase("-c")) {
                // Etapa 1: Frequência
                AnalisaFrequencia analisador = new AnalisaFrequencia();
                int[] freq = analisador.realizarAnalise(origem);

                // Etapa 2 e 3: Árvore
                MinHeap heap = new MinHeap();
                for (int i = 0; i < 256; i++) {
                    if (freq[i] > 0) heap.insert(new No((char) i, freq[i]));
                }
                while (heap.getSize() > 1) {
                    No esq = heap.extractMin();
                    No dir = heap.extractMin();
                    heap.insert(new No(esq.frequencia + dir.frequencia, esq, dir));
                }

                No raiz = heap.extractMin();

                if (raiz == null) {
                    throw new RuntimeException("Arquivo vazio ou inválido.");
                }

                // Etapa 4: Tabela de Códigos
                GeradorCodigos gerador = new GeradorCodigos();
                String[] dicionario = gerador.gerarTabela(raiz);

                // Etapa 5: Gravação
                new Compressor().comprimir(origem, destino, freq, dicionario);
                System.out.println("Compressão concluída: " + destino);

            } else if (comando.equalsIgnoreCase("-d")) {
                new Descompressor().descomprimir(origem, destino);
                System.out.println("Descompressão concluída: " + destino);
            }
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}