package br.andre.estudos.listas;

import org.junit.jupiter.api.Test;

import java.util.Queue;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListasExerciseTest {

    String taskName = "Comer";

    ListasExercise task = new ListasExercise();
//    List<String> taskTest;


    @Test
    void addTaskTest() {

        Queue<String> resultado = task.addTask(taskName);
        assertTrue(resultado.contains(taskName));
//        assertEquals(task.addTask(taskName), resultado);

        // deve ser colocado isso pois se a task não tem ordem de execução dos testes na classe,
        // portanto, se o objeto não estiver vazio no inicio do outro teste, pode ocorrer problema
        task.removeTask(taskName);
    }

    @Test
    void removeTaskTest(){
        //antes de remover é necessário adicionar
        Queue<String> resultado = task.addTask(taskName);

        resultado = task.removeTask(taskName);
        assertEquals(0, resultado.size());
    }

    @Test
    void completeTaskTest(){
        task.addTask("Jogar");
        task.addTask("Ler");
        task.addTask("Treinar");

        Set<String> completedTask = task.completeTask();
        assertNotNull(completedTask);
//        assertTrue(task.completedTasks.contains(completedTask));// não é aconselhado invocar o completedTasks desta maneira.
        assertTrue(completedTask.contains("Jogar"));

        // deve ser colocado isso pois se a task não tem ordem de execução dos testes na classe,
        // portanto, se o objeto não estiver vazio no inicio do outro teste, pode ocorrer problema
        task.removeTask("Jogar");
        task.removeTask("Ler");
        task.removeTask("Treinar");
    }
}
