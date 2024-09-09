package br.andre.estudos.streams;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StreamsBigDecimalExemplo {
    public static void main(String[] args) {
        Set<BigDecimal> numeros = geraSetComBigDecimal(10);
        imprimeSetComNumeros(numeros);
        calculaSoma(numeros);
        imprimeNumerosAcima50(numeros);
        numeros0a50comDesconto20PorCento(numeros);
        numeros30a60comDesconto30PorCento(numeros);
        numeros50a100comDesconto35PorCento(numeros);
        somaNumeros1QuartilE3Quartil(numeros);
        imprimeNumeros2Quartil(numeros);
    }

    private static Set<BigDecimal> geraSetComBigDecimal(int limit) {
        Set<BigDecimal> numeros = new HashSet<>();
        Random random = new Random();
        for(int i = 0; i< limit; i++) {
            numeros.add(BigDecimal.valueOf(random.nextDouble(100)).setScale(2, RoundingMode.HALF_UP));
        }
        return numeros;
    }

    private static void imprimeSetComNumeros(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("Imprimindo set com números");

        System.out.println(numeros);

    }

    private static void calculaSoma(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("A soma dos números é: ");
        BigDecimal soma = numeros.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add); // O reduce é uma função que vai associar o .ZERO e vai somar com ::add usando a stream
        System.out.println(soma);
    }

    private static void imprimeNumerosAcima50(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("Números acima de 50 são: ");

        numeros.stream()
                .filter(n -> n.compareTo(BigDecimal.valueOf(50)) > 0) // O filter como o nome já diz vai usar esse método dentro dele para fazer algo parecido com if else
                .forEach(System.out::println); // imprime cada número
    }

    private static void numeros0a50comDesconto20PorCento(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("Números 0 a 50 com 20% de desconto: ");

        numeros.stream()
                .filter(n -> n.compareTo(BigDecimal.valueOf(50)) <= 0) // Faz o "if else" de número entre 0 e 50
                .map(n -> n.multiply(BigDecimal.valueOf(0.8))) // Aplica a cada elemento passado pelo filtro o desconto multiplicando por 0.8
                .forEach(System.out::println);
    }

    private static void numeros30a60comDesconto30PorCento(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("Números 30 a 60 com 30% de desconto: ");

        numeros.stream()
                .filter(n -> n.compareTo(BigDecimal.valueOf(60)) <= 30)
                .map(n -> n.multiply(BigDecimal.valueOf(0.7)))
                .forEach(System.out::println);
    }

    private static void numeros50a100comDesconto35PorCento(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("Números 50 a 100 com 35% de desconto: ");

        numeros.stream()
                .filter(n -> n.compareTo(BigDecimal.valueOf(100)) <= 50)
                .map(n -> n.multiply(BigDecimal.valueOf(0.65)))
                .forEach(System.out::println);
    }

    private static void somaNumeros1QuartilE3Quartil(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("Soma dos números do 1º e 3º quartis: ");

        BigDecimal soma1Quartil = numeros.stream()
                .filter(n -> n.compareTo(BigDecimal.valueOf(0)) <= 0 && n.compareTo(BigDecimal.valueOf(25)) <= 0)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal soma3Quartil = numeros.stream()
                .filter(n -> n.compareTo(BigDecimal.valueOf(50)) <= 0 && n.compareTo(BigDecimal.valueOf(75)) <= 0)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal somaTotal = soma1Quartil.add(soma3Quartil);
        System.out.println(somaTotal);
    }

    private static void imprimeNumeros2Quartil(Set<BigDecimal> numeros){
        System.out.println("-----------------------------------");
        System.out.println("Imprime os números do 2º quartil: ");

        numeros.stream()
                .filter(n -> n.compareTo(BigDecimal.valueOf(25)) > 0 && n.compareTo(BigDecimal.valueOf(50)) <= 0)
                .forEach(System.out::println);
    }
}
