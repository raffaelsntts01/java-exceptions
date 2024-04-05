package excecoes;

import java.io.*;

public class TratamentoExcecao {
    public static void main(String[] args) {
        var exemplo = new TratamentoExcecao();
        var diretorioProjeto = System.getProperty("user.dir");
        var nomeArquivo = "\\Arquivo.txt";
        var texto = """
                Laranja
                Limão
                """;
        var arquivo = new File(diretorioProjeto, nomeArquivo);
        exemplo.writerFile(texto, arquivo.toString());
        exemplo.readerFile(arquivo.toString());
    }
    private void readerFile(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writerFile(String conteudo, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            writer.newLine();
            writer.write(conteudo);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


