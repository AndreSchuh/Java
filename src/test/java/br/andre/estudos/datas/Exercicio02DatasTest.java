package br.andre.estudos.datas;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercicio02DatasTest {

    String dataExemplo = "09/09/2008";

    @Test
    void formataDataTest(){
        LocalDate dataEsperada = LocalDate.of(2008, 9, 9);
        assertEquals( Exercicio01Datas.formataData(dataExemplo), dataEsperada, "A data formatada deveria ser 09/01/2008.");
    }

    @Test
    void mesesParaSomarDataTest(){
        LocalDateTime dataEsperada = LocalDateTime.of(2008, 11, 9, 00, 00);
        assertEquals( Exercicio02Datas.mesesParaSomarData(dataExemplo, 2), dataEsperada);
    }

    @Test
    void horaFinalData(){
        LocalDateTime horaEsperada = LocalDateTime.of(2008, 9, 9, 23, 59,59, 999999999);
        assertEquals(Exercicio02Datas.horaFinalData(dataExemplo), horaEsperada);
    }

    @Test
    void mesesParaSubtrairDataTest(){
        LocalDateTime dataEsperada = LocalDateTime.of(2008, 06, 9, 00, 00);
        assertEquals(dataEsperada, Exercicio02Datas.mesesParaSubtrairData(dataExemplo, 3));
    }

    @Test
    void anosParaSomarDataTest(){
        LocalDateTime dataEsperada = LocalDateTime.of(2013, 9, 9, 00, 00);
        assertEquals( dataEsperada, (Exercicio02Datas.anosParaSomarData(dataExemplo, 5)));
    }

    @Test
    void anosParaSubtrairDataTest(){
        LocalDateTime dataEsperada = LocalDateTime.of(2000, 9, 9, 00, 00);
        assertEquals(dataEsperada, Exercicio02Datas.anosParaSubtrairData(dataExemplo, 8));
    }

    @Test
    void horasParaSomarDataTest(){
        LocalDateTime dataEsperada = LocalDateTime.of(2008, 9, 9, 5, 00);
        assertEquals(dataEsperada, Exercicio02Datas.horasParaSomarData(dataExemplo, 5));
    }

    @Test
    void minutosParaSomarDataTest(){
        LocalDateTime dataEsperada = LocalDateTime.of(2008, 9, 9, 00, 25);
        assertEquals(dataEsperada, Exercicio02Datas.minutosParaSomarData(dataExemplo, 25));
    }

    @Test
    void segundosParaSomarDataTest(){
        LocalDateTime dataEsperada = LocalDateTime.of(2008, 9, 9, 00, 00, 05);
        assertEquals(dataEsperada, Exercicio02Datas.segundosParaSomarData(dataExemplo, 5));
    }
}

