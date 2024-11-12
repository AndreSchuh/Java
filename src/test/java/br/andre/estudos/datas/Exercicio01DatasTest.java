package br.andre.estudos.datas;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercicio01DatasTest {

    String dataExemplo = "09/01/2008";

    @Test
    void formataDataTest(){
        LocalDate dataEsperada = LocalDate.of(2008, 01, 9);
        assertEquals(dataEsperada, Exercicio01Datas.formataData(dataExemplo), "A data formatada deveria ser 09/01/2008.");
    }

    @Test
    void idadeUsuarioTest(){
        int idadeEsperada = 16;
        assertEquals(idadeEsperada, Exercicio01Datas.idadeUsuario(dataExemplo));
    }

    @Test
    void diaDaSemanaNascimentoUsuarioTest(){
        String diaDaSemanaEsperado = "quarta-feira";
        assertEquals(diaDaSemanaEsperado, Exercicio01Datas.diaDaSemanaNascimentoUsuario(dataExemplo));
    }

    @Test
    void idadeUsuarioDataEspecificaTest(){
        String dataEspecifica = "09/01/2025";
        int idadeEspecificaEsperada = 17;
        assertEquals(idadeEspecificaEsperada, Exercicio01Datas.idadeUsuarioDataEspecifica(dataExemplo, dataEspecifica));
    }
}
