package br.andre.estudos.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSenhaExemplo {
    // Regex para validação de senha forte
    /*
    Mínimo de 8 caracteres.
    Pelo menos uma letra minúscula.
    Pelo menos uma letra maiúscula.
    Pelo menos um número.
    Pelo menos um caractere especial (ex: @, $, !, %, *, ?, &).
    
    Onde
    
    (?=.*[a-z]): Exige pelo menos uma letra minúscula.
    (?=.*[A-Z]): Exige pelo menos uma letra maiúscula.
    (?=.*\\d): Exige pelo menos um dígito.
    (?=.*[@$!%*?&]): Exige pelo menos um caractere especial.
    [A-Za-z\\d@$!%*?&]{8,}: Exige que a senha tenha pelo menos 8 caracteres e que use apenas caracteres válidos.
     */
    private static final String STRONG_PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";


    public static void main(String[] args) {
        String password = "SenhaForte@123";
        if (isStrongPassword(password)) {
            System.out.println("A senha é forte.");
        } else {
            System.out.println("A senha não é forte.");
        }
    }

    public static boolean isStrongPassword(String password) {
        Pattern pattern = Pattern.compile(STRONG_PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
