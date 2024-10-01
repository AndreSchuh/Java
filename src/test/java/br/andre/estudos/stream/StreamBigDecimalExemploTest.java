package br.andre.estudos.stream;
import br.andre.estudos.streams.StreamsBigDecimalExemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.List;

public class StreamBigDecimalExemploTest {

    List<BigDecimal> numeros = List.of(BigDecimal.valueOf(10),
            BigDecimal.valueOf(20),
            BigDecimal.valueOf(30),
            BigDecimal.valueOf(40),
            BigDecimal.valueOf(50),
            BigDecimal.valueOf(60),
            BigDecimal.valueOf(70));

    @Test
    void calculaSomaTest(){
        BigDecimal somaEsperada = BigDecimal.valueOf(280);
        assertEquals(somaEsperada, StreamsBigDecimalExemplo.calculaSoma(numeros));
    }

    @Test
    void imprimeNumerosAcima50Test(){
        List<BigDecimal> filtroEsperado = List.of(BigDecimal.valueOf(60), BigDecimal.valueOf(70));
        assertEquals(filtroEsperado, StreamsBigDecimalExemplo.imprimeNumerosAcima50(numeros));
    }

    @Test
    void numeros0a50comDesconto20PorCento(){
        List<BigDecimal> filtroComDescontoEsperado = List.of(BigDecimal.valueOf(48), BigDecimal.valueOf(56));
        assertEquals(filtroComDescontoEsperado, StreamsBigDecimalExemplo.numeros0a50comDesconto20PorCento(numeros));
    }

    @Test
    void numeros30a60comDesconto30PorCento(){
        List<BigDecimal> filtroComDescontoEsperado = List.of(BigDecimal.valueOf(21), BigDecimal.valueOf(28), BigDecimal.valueOf(35), BigDecimal.valueOf(42));
        assertEquals(filtroComDescontoEsperado, StreamsBigDecimalExemplo.numeros30a60comDesconto30PorCento(numeros));
    }

    @Test
    void numeros50a100comDesconto35PorCento(){
        List<BigDecimal> filtroComDescontoEsperado = List.of(BigDecimal.valueOf(32.5), BigDecimal.valueOf(39), BigDecimal.valueOf(45.5));
        assertEquals(filtroComDescontoEsperado, StreamsBigDecimalExemplo.numeros50a100comDesconto35PorCento(numeros));
    }

    @Test
    void somaNumeros1QuartilE3Quartil(){
        BigDecimal soma1Quartile3Esperado =BigDecimal.valueOf(10 + 20 + 50 + 60 + 70);
        assertEquals(soma1Quartile3Esperado, StreamsBigDecimalExemplo.somaNumeros1QuartilE3Quartil(numeros));
    }

    @Test
    void imprimeNumeros2Quartil(){
        List<BigDecimal> printEsperado = List.of(BigDecimal.valueOf(30), BigDecimal.valueOf(40), BigDecimal.valueOf(50));
        assertEquals(printEsperado, StreamsBigDecimalExemplo.imprimeNumeros2Quartil(numeros));
    }
}
