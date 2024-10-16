package br.andre.estudos.files;

import java.io.*;
import java.util.Scanner;

public class ArquivosExercise {

    static String nomeArquivo;

    public static void main(String[] args){
        int opcaoUser;
        String textoUser, opcaoUserExcluir;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Manipulação de arquivos!");

        do{
            System.out.println("1. Criar novo arquivo");
            System.out.println("2. Adicionar texto");
            System.out.println("3. Ler o arquivo completo");
            System.out.println("4. Deletar o arquivo");
            System.out.println("5. Encerrar programa");

            System.out.print("Digite uma das opções: ");
            opcaoUser = scanner.nextInt();
            scanner.nextLine();

            switch(opcaoUser){
                case 1:
                    System.out.print("Digite o nome do arquivo: ");
                    nomeArquivo = scanner.nextLine();
                    criaArquivo(nomeArquivo);
                    break;
                case 2:
                    System.out.print("Digite o nome do arquivo que deseja escrever: ");
                    nomeArquivo = scanner.nextLine();
                    System.out.print("Digite o texto que deseja incluir: ");
                    textoUser = scanner.nextLine();
                    escreverNoArquivo(nomeArquivo, textoUser, true);
                    break;
                case 3:
                    System.out.print("Digite o nome do arquivo que deseja ler: ");
                    nomeArquivo = scanner.nextLine();
                    lerArquivo(nomeArquivo);
                    break;
                case 4:
                    System.out.print("Digite o nome do arquivo: ");
                    nomeArquivo = scanner.nextLine();
                    System.out.printf("Deseja mesmo excluir o arquivo %s? S - sim | N - não", nomeArquivo);
                    opcaoUserExcluir = scanner.nextLine();

                    if(opcaoUserExcluir.equalsIgnoreCase("S")){
                        excluiArquivo(nomeArquivo);
                    }
                    break;
                case 5:
                    System.out.println("SAINDO!");
                    System.exit(0);
            }
        }while(true);
    }

    public static boolean escreverNoArquivo(String fileName, String texto, boolean append) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append));
            writer.write(texto);
            writer.newLine();
            writer.close();
            System.out.println("Escrita concluída no arquivo " + fileName);
            return true;
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita.");
            e.printStackTrace();
            return false;
        }
    }

    public static void escreverNoArquivo2(String fileName, String texto, boolean append) {
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

    public static boolean criaArquivo(String nomeArquivo){
        try {
            File arquivo = new File(nomeArquivo);

            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado: " + arquivo.getName());
                return true;
            } else {
                System.out.println("O arquivo já existe.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo.");
            e.printStackTrace();
            return false;
        }
    }
 public static void criaArquivo2(String nomeArquivo){
        try {
            File arquivo = new File(nomeArquivo);

            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado: " + arquivo.getName());
            } else {
                System.out.println("O arquivo já existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao criar o arquivo.");
            e.printStackTrace();
        }
    }

    public static boolean lerArquivo(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            reader.close();
            return true;
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a leitura.");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean excluiArquivo(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("Arquivo deletado: " + file.getName());
            return true;
        } else {
            System.out.println("Falha ao deletar o arquivo.");
        return false;
        }
    }
}
