import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Tutor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o caminho do arquivo de texto
        System.out.print("Digite o caminho do arquivo de texto: ");
        String caminhoArquivo = scanner.nextLine();

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo: ");
        String nomeArquivo = scanner.nextLine();

        // Solicita os caracteres a serem removidos
        System.out.print("Digite os caracteres a serem removidos do arquivo: ");
        String caracteresRemover = scanner.nextLine();

        // Monta o caminho completo do arquivo original
        String caminhoCompletoOriginal = caminhoArquivo + "/" + nomeArquivo;

        // Monta o caminho completo para a cópia do arquivo
        String caminhoCompletoCopia = caminhoArquivo + "/copia_" + nomeArquivo;

        try {
            // Realiza a leitura do conteúdo do arquivo original
            BufferedReader reader = new BufferedReader(new FileReader(caminhoCompletoOriginal));
            StringBuilder conteudo = new StringBuilder();
            String linha;

            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            reader.close();

            // Realiza a remoção dos caracteres especificados
            String novoConteudo = removerCaracteres(conteudo.toString(), caracteresRemover);

            // Escreve o novo conteúdo na cópia do arquivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoCompletoCopia));
            writer.write(novoConteudo);
            writer.close();

            System.out.println("Limpeza concluída com sucesso. Cópia do arquivo criada em: " + caminhoCompletoCopia);

        } catch (IOException e) {
            System.err.println("Erro ao manipular o arquivo: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String removerCaracteres(String texto, String caracteres) {
        // Utiliza expressão regular para remover os caracteres especificados
        return texto.replaceAll("[" + caracteres + "]", "");
    }
}
