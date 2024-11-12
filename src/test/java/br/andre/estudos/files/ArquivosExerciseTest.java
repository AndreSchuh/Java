package br.andre.estudos.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void criaArquivo2Test(){
        ArquivosExercise.criaArquivo2(fileTest);
        File file = new File(fileTest);
        assertTrue(file.exists());
    }

    @Test
    void escreverNoArquivo2Test() throws IOException {
        //aqui escreve um texto no arquivo
        ArquivosExercise.escreverNoArquivo2(fileTest,"texto do arquivo", true);

        //aqui, manualmente, vc percorre o arquivo e joga o conteúdo escrito na variável texto
        StringBuilder texto = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileTest));
        String linha;
        while ((linha = reader.readLine()) != null) {
            texto.append(linha);
        }
        reader.close();

        //aqui vc faz o assert verificando se o conteúdo é igual ao texto que vc escreveu
        assertEquals("texto do arquivo", texto.toString());
    }

    @Test
    void lerArquivoTest() throws IOException{

        ArquivosExercise.escreverNoArquivo2(fileTest,"Este é um texto de teste.", true);
        //-----------------Segue solução proposta ------------------------------------------
        String actualContent = ArquivosExercise.lerArquivo2(fileTest);       // <---- aqui estou chamando o lerArquivo2

        assertEquals(textTest, actualContent);

        //como pode ver criei um método lerArquivo2.
        //Fazendo dessa forma teria que adaptar todo o programa para usar esse método lerArquivo2,
        // mas não é necessário nesse momento, apenas estou te dando um exemplo de como devemos pensar em Teste

    }

    @Test
    void excluiArquivoTest(){
        File file = new File(fileTest);
        ArquivosExercise.excluiArquivo(fileTest);
        assertFalse(file.exists());
    }
}
