package br.andre.estudos.stream;
import br.andre.estudos.streams.StreamsBigDecimalExemplo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.util.List;

public class StreamBigDecimalExemploTest {

    List<BigDecimal> numeros = List.of(BigDecimal.valueOf(10), BigDecimal.valueOf(20), BigDecimal.valueOf(30));

    @Test
    void calculaSomaTest(){
        BigDecimal somaEsperada = BigDecimal.valueOf(60);
        assertEquals(somaEsperada, StreamsBigDecimalExemplo.calculaSoma(numeros));
    }

    @Test
    void imprimeNumerosAcima50Test(){

    }
}
