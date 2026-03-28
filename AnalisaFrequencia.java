import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
------------------- DISCLAIMER -------------------
O METODO realizarAnalise RETORNA INT APENAS PARA SER POSSIVEL O TESTE NA MAIN (Huffman)
NO FINAL, ACREDITO QUE MUDAREMOS PARA VOID MESMO, ENTAO O ULTIMO RETURN TBM NAO SERIA NECESSARIO
*/

public class AnalisaFrequencia{
    public int[] realizarAnalise() {

        Scanner sc = new Scanner(System.in);
        int[] frequencia = new int[256];

        System.out.println("Digite o caminho completo do arquivo: ");
        String caminhoArquivo = sc.nextLine();

        // FileInputStream le os dados de um arquivo como uma sequencia de bytes
        try (FileInputStream fis = new FileInputStream(caminhoArquivo)) {
            int byteLido = 0;
            while ((byteLido = fis.read()) != -1) { // ate chegar no final do arquivo, quando chega no final o read() retorna -1
                frequencia[byteLido]++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo" + e.getMessage());
        } finally {
            sc.close();
        }
        return frequencia; // Retorna o vetor preenchido
    }
}