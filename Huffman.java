public class Huffman{
    int[] frequencia = new int[256];

    // eu nao sei o que eu to fazendo, mas eu to fazendo 
    public void analisaFrequencia(String texto){
        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            frequencia[c]++;
        }
    }

}