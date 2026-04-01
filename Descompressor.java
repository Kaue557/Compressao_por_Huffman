import java.io.*;

public class Descompressor {
    public void descomprimir(String origem, String destino) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(origem));
             FileOutputStream fos = new FileOutputStream(destino)) {

            // Reconstrói a tabela de frequências do cabeçalho
            int[] freq = new int[256];
            long totalCaracteres = 0;
            for (int i = 0; i < 256; i++) {
                freq[i] = dis.readInt();
                totalCaracteres += freq[i];
            }

            // Reconstrói a Árvore de Huffman (Mesma lógica da compressão, a proposito)
            No raiz = reconstruirArvore(freq);

            // Percurso guiado pelos bits
            No atual = raiz;
            long caracteresEscritos = 0;

            if (raiz.eFolha()) {
                for (long i = 0; i < totalCaracteres; i++) {
                    fos.write(raiz.caractere);
                }
                return;
            }

            while (caracteresEscritos < totalCaracteres) {
                int b = dis.readUnsignedByte();
                for (int i = 7; i >= 0 && caracteresEscritos < totalCaracteres; i--) {
                    int bit = (b >> i) & 1;

                    // 0 = esquerda, 1 = direita
                    atual = (bit == 0) ? atual.esquerda : atual.direita;

                    // Folha
                    if (atual.esquerda == null && atual.direita == null) {
                        fos.write(atual.caractere);
                        caracteresEscritos++;
                        atual = raiz; // Volta para a raiz
                    }
                }
            }
        }
    }

    private No reconstruirArvore(int[] freq) {
        MinHeap heap = new MinHeap();
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) heap.insert(new No((char) i, freq[i]));
        }
        while (heap.getSize() > 1) {
            No esq = heap.extractMin();
            No dir = heap.extractMin();
            heap.insert(new No(esq.frequencia + dir.frequencia, esq, dir));
        }
        return heap.extractMin();
    }
}