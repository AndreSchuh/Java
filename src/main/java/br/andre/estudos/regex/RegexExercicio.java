package br.andre.estudos.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExercicio {

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String CPF_REGEX = "^(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})$";

    private static final String CNPJ_REGEX = "^[0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2}$";

    private static final String DATA_REGEX = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    private static final String NUMEROTELEFONE_REGEX = "^([(]?[0]?[1-9]{2}[)]?)[9]?([1-9]{4})-?([0-9]{4})$";

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int opcaoUser = 0;

        String email, cpf, cnpj, data, numeroTelefone;

        do{
            System.out.println("Validando com REGEX");
            System.out.println("01 - Valida o email");
            System.out.println("02 - Valida o CPF");
            System.out.println("03 - Valida o CNPJ");
            System.out.println("04 - Valida a data");
            System.out.println("05 - Valida o número de telefone");
            System.out.println("99 - Sair");
            opcaoUser = scanner.nextInt();
            scanner.nextLine();

            switch(opcaoUser){
                case 1:
                    System.out.print("Digite o email: ");
                    email = scanner.nextLine();
                    validaEmailRegex(email);
                    if(validaEmailRegex(email) == true){
                        System.out.printf("O email %s é válido\n", email);
                    }else{
                        System.out.printf("O email digitado é inválido\n");
                    }
                    break;
                case 2:
                    System.out.print("Digite o CPF: ");
                    cpf = scanner.nextLine();
                    validaCpfRegex(cpf);
                    if(validaCpfRegex(cpf) == true){
                        System.out.printf("O cpf %s é válido\n", cpf);
                    }else{
                        System.out.printf("O cpf digitado é inválido\n");
                    }
                    break;
                case 3:
                    System.out.print("Digite o CNPJ: ");
                    cnpj = scanner.nextLine();
                    validaCnpjRegex(cnpj);
                    if(validaCnpjRegex(cnpj) == true){
                        System.out.printf("O cnpj %s é válido\n", cnpj);
                    }else{
                        System.out.printf("O cnpj digitado é inválido\n");
                    }
                    break;
                case 4:
                    System.out.print("Digite a data: ");
                    data = scanner.nextLine();
                    validaDataRegex(data);
                    if(validaDataRegex(data) == true){
                        System.out.printf("A data %s é válido\n", data);
                    }else{
                        System.out.printf("A data digitada é inválido\n");
                    }
                    break;
                case 5:
                    System.out.print("Digite o número de telefone: ");
                    numeroTelefone = scanner.nextLine();
                    validaNumeroTelefoneRegex(numeroTelefone);
                    if(validaNumeroTelefoneRegex(numeroTelefone) == true){
                        System.out.printf("O número de telefone %s é válido\n", numeroTelefone);
                    }else{
                        System.out.printf("O número de telefone é inválido\n");
                    }
                    break;
                case 99:
                    System.exit(0);
            }

        }while(true);
    }

    static boolean validaEmailRegex(String email){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean validaCpfRegex(String cpf){
        Pattern pattern = Pattern.compile(CPF_REGEX);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }

    static boolean validaCnpjRegex(String cnpj){
        Pattern pattern = Pattern.compile(CNPJ_REGEX);
        Matcher matcher = pattern.matcher(cnpj);
        return matcher.matches();
    }

    static boolean validaDataRegex(String data){
        Pattern pattern = Pattern.compile(DATA_REGEX);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

    static boolean validaNumeroTelefoneRegex(String numeroTelefone){
        Pattern pattern = Pattern.compile(NUMEROTELEFONE_REGEX);
        Matcher matcher = pattern.matcher(numeroTelefone);
        return matcher.matches();
    }
}
