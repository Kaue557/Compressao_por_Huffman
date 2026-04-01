import java.io.*;

public class Compressor {
    public void comprimir(String origem, String destino, int[] frequencia, String[] dicionario) throws IOException {
        try (FileInputStream fis = new FileInputStream(origem);
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(destino))) {

            // Escreve o CABEÇALHO
            for (int f : frequencia) {
                dos.writeInt(f);
            }

            // Codificação e escrita dos dados
            StringBuilder bufferBits = new StringBuilder();
            int byteLido;
            while ((byteLido = fis.read()) != -1) {
                bufferBits.append(dicionario[byteLido]);

                // Enquanto tiver pelo menos 8 bits, grava um byte real
                while (bufferBits.length() >= 8) {
                    String byteStr = bufferBits.substring(0, 8);
                    dos.writeByte(Integer.parseInt(byteStr, 2));
                    bufferBits.delete(0, 8);
                }
            }

            // Grava os bits restantes / append com 0s a direita
            if (bufferBits.length() > 0) {
                while (bufferBits.length() < 8) bufferBits.append("0");
                dos.write(Integer.parseInt(bufferBits.toString(), 2));
            }
        }
    }
}