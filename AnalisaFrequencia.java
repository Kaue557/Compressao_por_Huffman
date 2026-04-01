import java.io.FileInputStream;
import java.io.IOException;

public class AnalisaFrequencia {

    // o metodo recebe a "origem" diretamente da main
    public int[] realizarAnalise(String caminhoArquivo) {

        int[] frequencia = new int[256];

        // FileInputStream le os dados de um arquivo como uma sequencia de bytes
        try (FileInputStream fis = new FileInputStream(caminhoArquivo)) {
            int byteLido;
            while ((byteLido = fis.read()) != -1) {
                frequencia[byteLido]++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return frequencia; // Retorna o vetor preenchido
    }
}