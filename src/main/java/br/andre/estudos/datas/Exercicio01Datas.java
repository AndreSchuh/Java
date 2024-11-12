package br.andre.estudos.datas;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio01Datas {

    public static void main(String[] args) throws ParseException {
        int codigoUsuario = 0;

        Scanner scanner = new Scanner(System.in);

        String dataUsuario = "";
        String dataUsuarioEspecifico = "";

        while (true){
            System.out.println("1 - Informe a data de nascimento (formato dd/mm/yyyy)");
            System.out.println("2 - Qual a idade da pessoa? ");
            System.out.println("3 - Que dia da semana ela nasceu?");
            System.out.println("4 - Informe dd/MM/yyyy para saber a idade dela nesta data");
            System.out.println("99 - Sair");
            codigoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (codigoUsuario){
                case 1:
                    System.out.print("Digite a data de nascimento: ");
                    dataUsuario = scanner.nextLine();
                    System.out.printf("Data %s cadastrada \n", formataData(dataUsuario));
                    break;
                case 2:
                    System.out.printf("A idade é %d \n", idadeUsuario(dataUsuario));
                    break;
                case 3:
                    System.out.printf("O dia da semana foi %s \n", diaDaSemanaNascimentoUsuario(dataUsuario));
                    break;
                case 4:
                    System.out.print("Digite a data: ");
                    dataUsuarioEspecifico = scanner.nextLine();
                    System.out.printf("Nessa data o usuário teria %d anos \n", idadeUsuarioDataEspecifica(dataUsuario, dataUsuarioEspecifico));
                    break;
                case 99:
                    System.exit(0);
            }
        }

    }

    static LocalDate formataData(String dataUsuario){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataUsuario, formatter);
    }

    static int idadeUsuario(String dataUsuario) {
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataNascimento = LocalDate.parse(dataUsuario, formataData);
        LocalDate dataAtual = LocalDate.now();


        int idade = Period.between(dataNascimento, dataAtual).getYears();

        return idade;
    }

    static String diaDaSemanaNascimentoUsuario(String dataUsuario){
        LocalDate dataNascimento = formataData(dataUsuario);
        DayOfWeek diaDaSemana = dataNascimento.getDayOfWeek();

        return diaDaSemana.getDisplayName(java.time.format.TextStyle.FULL, new Locale("pt", "BR"));
    }

    static int idadeUsuarioDataEspecifica (String dataUsuario, String dataUsuarioEspecifico){
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate dataUsuarioLocalDate = LocalDate.parse(dataUsuario, formataData);
        LocalDate dataUsuarioEspecificoLocalDate = LocalDate.parse(dataUsuarioEspecifico, formataData);

        int idadeEspecifica = Period.between(dataUsuarioLocalDate, dataUsuarioEspecificoLocalDate).getYears();

        return idadeEspecifica;
    }
}
