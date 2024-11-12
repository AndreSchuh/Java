package br.andre.estudos.datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio02Datas {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args){
        int codigoUsuario = 0;

        Scanner scanner = new Scanner(System.in);

        String dataUsuario = "";
        int numeroUsuario = 0;

        while (true){
            System.out.println("1 - Informe uma data (formato dd/mm/yyyy)");
            System.out.println("2 - Imprima o início do dia desta data");
            System.out.println("3 - Imprima o fim do dia desta data");
            System.out.println("4 - Informe o número de meses para somar na data");
            System.out.println("5 - Informe o número de meses para subtrair da data");
            System.out.println("6 - Informe o número de anos para somar na data");
            System.out.println("7 - Informe o número de anos para subtrair da data");
            System.out.println("8 - Informe hh para somar na data");
            System.out.println("9 - Informe mm para somar na data");
            System.out.println("10 - Informe ss para somar na data");
            System.out.println("99 - Sair");
            codigoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (codigoUsuario){
                case 1:
                    System.out.print("Digite a data: ");
                    dataUsuario = scanner.nextLine();
                    System.out.printf("Data %s cadastrada \n", formataData(dataUsuario));
                    break;
                case 2:
                    System.out.printf("Hora inicial: %s \n", formataData(dataUsuario));
                    break;
                case 3:
                    System.out.printf("Hora final: %s \n", horaFinalData(dataUsuario));
                    break;
                case 4:
                    System.out.print("Digite o número de meses para somar na data: ");
                    numeroUsuario = scanner.nextInt();
                    System.out.printf("A data com os meses somados é %s \n", mesesParaSomarData(dataUsuario, numeroUsuario));
                    break;
                case 5:
                    System.out.print("Digite o número de meses para subtrair na data: ");
                    numeroUsuario = scanner.nextInt();
                    System.out.printf("A data com os meses subtraídos é %s \n", mesesParaSubtrairData(dataUsuario, numeroUsuario));
                    break;
                case 6:
                    System.out.print("Digite o número de anos para somar na data: ");
                    numeroUsuario = scanner.nextInt();
                    System.out.printf("A data com os anos somados é %s \n", anosParaSomarData(dataUsuario, numeroUsuario));
                    break;
                case 7:
                    System.out.print("Digite o número de anos para subtrair na data: ");
                    numeroUsuario = scanner.nextInt();
                    System.out.printf("A data com os anos subtraídos é %s \n", anosParaSubtrairData(dataUsuario, numeroUsuario));
                    break;
                case 8:
                    System.out.print("Digite o número de horas para somar na data: ");
                    numeroUsuario = scanner.nextInt();
                    System.out.printf("A data com as horas somadas é %s \n", horasParaSomarData(dataUsuario, numeroUsuario));
                    break;
                case 9:
                    System.out.print("Digite o número de minutos para somar na data: ");
                    numeroUsuario = scanner.nextInt();
                    System.out.printf("A data com os minutos somados é %s \n", minutosParaSomarData(dataUsuario, numeroUsuario));
                    break;
                case 10:
                    System.out.print("Digite o número de segundos para somar na data: ");
                    numeroUsuario = scanner.nextInt();
                    System.out.printf("A data com os segundos somados é %s \n", segundosParaSomarData(dataUsuario, numeroUsuario));
                    break;
                case 99:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Digite o código novamente!");
            }
        }
    }

    static LocalDateTime formataData(String dataUsuario){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);
        return dataFormatada.atStartOfDay();
    }

    static LocalDateTime mesesParaSomarData (String dataUsuario, int mesesParaSomar){
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);

        LocalDateTime dataFinal = dataFormatada.plusMonths(mesesParaSomar).atStartOfDay();

        return dataFinal;
    }

    static LocalDateTime horaFinalData (String dataUsuario){
        return  formataData(dataUsuario).with(LocalTime.MAX);
    }

    static LocalDateTime mesesParaSubtrairData (String dataUsuario, int mesesParaSubtrair){
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);

        LocalDateTime dataFinal = dataFormatada.minusMonths(mesesParaSubtrair).atStartOfDay();

        return dataFinal;
    }

    static LocalDateTime anosParaSomarData (String dataUsuario, int anosParaSomar){
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);

        LocalDateTime dataFinal = dataFormatada.plusYears(anosParaSomar).atStartOfDay();

        return dataFinal;
    }

    static LocalDateTime anosParaSubtrairData (String dataUsuario, int anosParaSubtrair){
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);

        LocalDateTime dataFinal = dataFormatada.minusYears(anosParaSubtrair).atStartOfDay();

        return dataFinal;
    }

    static LocalDateTime horasParaSomarData (String dataUsuario, int horasParaSomar){
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);

        LocalDateTime dataHora = dataFormatada.atStartOfDay();

        return dataHora.plusHours(horasParaSomar);
    }

    static LocalDateTime minutosParaSomarData (String dataUsuario, int minutosParaSomar){
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);

        LocalDateTime dataHora = dataFormatada.atStartOfDay();

        return dataHora.plusMinutes(minutosParaSomar);
    }

    static LocalDateTime segundosParaSomarData (String dataUsuario, int segundosParaSomar){
        LocalDate dataFormatada = LocalDate.parse(dataUsuario, formatter);

        LocalDateTime dataHora = dataFormatada.atStartOfDay();

        return dataHora.plusSeconds(segundosParaSomar);
    }
}
