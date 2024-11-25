package br.andre.estudos.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegexExercicioTest {

    @Test
    void validaEmailRegexTest(){
        assertTrue(RegexExercicio.validaEmailRegex("teste@email.com"));
        assertFalse(RegexExercicio.validaEmailRegex("testeemailcom"));
    }

    @Test
    void validaCpfRegexTest(){
        assertTrue(RegexExercicio.validaCpfRegex("123.456.789-10"));
        assertFalse(RegexExercicio.validaCpfRegex("1234567891"));
    }

    @Test
    void validaCnpjRegexTest(){
        assertTrue(RegexExercicio.validaCnpjRegex("12.345.789/0001-10"));
        assertFalse(RegexExercicio.validaCnpjRegex("1234578900011"));
    }

    @Test
    void validaDataRegexTest(){
        assertTrue(RegexExercicio.validaDataRegex("12/10/5678"));
        assertFalse(RegexExercicio.validaDataRegex("123/4/56"));
    }

    @Test
    void validaNumeroTelefoneRegexTest(){
        assertTrue(RegexExercicio.validaNumeroTelefoneRegex("(012)995746243"));
        assertTrue(RegexExercicio.validaNumeroTelefoneRegex("(012)95746243"));
        assertFalse(RegexExercicio.validaNumeroTelefoneRegex("(1234)5678"));
    }
}
