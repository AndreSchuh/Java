package br.andre.estudos.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCepExemplo {
    // Regex para validação de cep
    private static final String CEP_REGEX = "^\\d{5}-\\d{3}$";

    public static boolean isValidCep(String cep) {
        Pattern pattern = Pattern.compile(CEP_REGEX);
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String cep = "12345-678";
        if (isValidCep(cep)) {
            System.out.println("O CEP é válido.");
        } else {
            System.out.println("O CEP não é válido.");
        }
    }
}
