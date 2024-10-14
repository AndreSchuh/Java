package br.andre.estudos.files;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArquivosExerciseTest {

    private static final String fileTest = "testFile.txt";
    private static final String textTest = "Este é um texto de teste.";

    @BeforeEach
    void setUp() {
        // Executa antes de cada teste, para garantir um ambiente limpo
        File file = new File(fileTest);
        if (file.exists()) {
            file.delete();
        }
    }

    @AfterEach
    void tearDown() {
        // Executa após cada teste, para limpar o ambiente de teste
        File file = new File(fileTest);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void criaArquivoTest(){
        assertTrue(ArquivosExercise.criaArquivo(fileTest));
        assertFalse(ArquivosExercise.criaArquivo(fileTest));
    }

    @Test
    void escreverNoArquivoTest(){
        assertTrue(ArquivosExercise.escreverNoArquivo(fileTest, textTest, true));
    }

    @Test
    void lerArquivoTest(){
        ArquivosExercise.escreverNoArquivo(fileTest, textTest, true);
        assertTrue(ArquivosExercise.lerArquivo(fileTest));
    }

    @Test
    void excluiArquivoTest(){
        File file = new File(fileTest);
        ArquivosExercise.excluiArquivo(fileTest);
        assertFalse(file.exists());
    }
}
