package br.andre.estudos.stream;

import br.andre.estudos.streams.StreamsBigDecimalExemplo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamBigDecimalExemploTest {

    static List<BigDecimal> numeros = List.of(BigDecimal.valueOf(10),
            BigDecimal.valueOf(20),
            BigDecimal.valueOf(30),
            BigDecimal.valueOf(40),
            BigDecimal.valueOf(50),
            BigDecimal.valueOf(60),
            BigDecimal.valueOf(70));

//    @Test
//    void calculaSomaTest(){
//        BigDecimal somaEsperada = BigDecimal.valueOf(280);
//        assertEquals(somaEsperada, StreamsBigDecimalExemplo.calculaSoma(numeros));
//    }

    @ParameterizedTest
    @MethodSource("forneceListasDeNumeros")
    void calculaSomaTest(List<BigDecimal> numeros, BigDecimal somaEsperada) {
        assertEquals(somaEsperada, StreamsBigDecimalExemplo.calculaSoma(numeros));
    }

    // Método que fornece as listas de números e suas respectivas somas esperadas
    static List<Object[]> forneceListasDeNumeros() {
        return List.of(
                new Object[]{List.of(BigDecimal.valueOf(100), BigDecimal.valueOf(50), BigDecimal.valueOf(130)), BigDecimal.valueOf(280)},
                new Object[]{List.of(BigDecimal.valueOf(200), BigDecimal.valueOf(150)), BigDecimal.valueOf(350)},
                new Object[]{List.of(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30)), BigDecimal.valueOf(60)}
        );
    }

    @Test
    void imprimeNumerosAcima50Test(){
        List<BigDecimal> filtroEsperado = List.of(BigDecimal.valueOf(60), BigDecimal.valueOf(70));
        assertEquals(filtroEsperado, StreamsBigDecimalExemplo.imprimeNumerosAcima50(numeros));
    }

    @Test
    void numeros0a50comDesconto20PorCento(){
        List<BigDecimal> filtroComDescontoEsperado = List.of(
                BigDecimal.valueOf(8.0),
                BigDecimal.valueOf(16.0),
                BigDecimal.valueOf(24.0),
                BigDecimal.valueOf(32.0),
                BigDecimal.valueOf(40.0));
        assertEquals(filtroComDescontoEsperado, StreamsBigDecimalExemplo.numeros0a50comDesconto20PorCento(numeros));
    }

    @Test
    void numeros30a60comDesconto30PorCento(){
        List<BigDecimal> filtroComDescontoEsperado = List.of(
                BigDecimal.valueOf(21.0),
                BigDecimal.valueOf(28.0),
                BigDecimal.valueOf(35.0),
                BigDecimal.valueOf(42.0));
        assertEquals(filtroComDescontoEsperado, StreamsBigDecimalExemplo.numeros30a60comDesconto30PorCento(numeros));
    }

    @Test
    void numeros50a100comDesconto35PorCento(){
       List<BigDecimal> filtroComDescontoEsperado = List.of(
                BigDecimal.valueOf(32.5).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(39).setScale(2, RoundingMode.HALF_UP),
                BigDecimal.valueOf(45.5).setScale(2, RoundingMode.HALF_UP));
        assertEquals(filtroComDescontoEsperado, StreamsBigDecimalExemplo.numeros50a100comDesconto35PorCento(numeros));
//        for (int i = 0; i < filtroComDescontoEsperado.size(); i++) {
//            assertEquals(0, filtroComDescontoEsperado.get(i).compareTo(resultado.get(i)));
//        }
    }

    @Test
    void somaNumeros1QuartilE3Quartil(){
        BigDecimal soma1Quartile3Esperado = BigDecimal.valueOf(10 + 20 + 50 + 70);
        assertEquals(soma1Quartile3Esperado, StreamsBigDecimalExemplo.somaNumeros1QuartilE3Quartil(numeros));
    }

    @Test
    void imprimeNumeros2Quartil(){
        List<BigDecimal> printEsperado = List.of(BigDecimal.valueOf(30), BigDecimal.valueOf(40), BigDecimal.valueOf(50));
        assertEquals(printEsperado, StreamsBigDecimalExemplo.imprimeNumeros2Quartil(numeros));
    }
}
