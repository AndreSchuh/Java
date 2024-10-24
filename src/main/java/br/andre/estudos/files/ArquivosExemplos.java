package br.andre.estudos.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivosExemplos {

    public static void main(String[] args) {
        String nomeArquivo = "arquivo.txt";

        incluir(nomeArquivo, "Linha 1");

        incrementar(nomeArquivo, "Linha 2");

        ler(nomeArquivo);

//        delete(nomeArquivo);

    }

    public static void incluir(String fileName, String texto) {
        escrever(fileName, texto, false);
    }

    public static void incrementar(String fileName, String texto) {
        escrever(fileName, texto, true);
    }

    public static void escrever(String fileName, String texto, boolean append) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
            writer.write(texto);
            writer.newLine();
            writer.close();
            System.out.println("Escrita concluída no arquivo " + fileName);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita.");
            e.printStackTrace();
        }
    }

    public static void ler(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a leitura.");
            e.printStackTrace();
        }
    }

    public static void delete(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Arquivo deletado: " + file.getName());
        } else {
            System.out.println("Falha ao deletar o arquivo.");
        }
    }
}
