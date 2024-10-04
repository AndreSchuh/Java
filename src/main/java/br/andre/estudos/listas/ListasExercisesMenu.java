package br.andre.estudos.listas;
import java.util.*;

public class ListasExercisesMenu {

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        ListasExercise operator = new ListasExercise();
        int respostaUser;
        String nameTask;

        while (true){
            System.out.println("________________________________");
            System.out.println("------- GERENCIAR TAREFA -------");
            System.out.println("________________________________");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas pendentes");
            System.out.println("3 - Remover tarefa");
            System.out.println("4 - Completar tarefa");
            System.out.println("99 - Sair");
            respostaUser = scanner.nextInt();
            scanner.nextLine();

            switch(respostaUser){
                case 1:
                    System.out.println("------------------");
                    System.out.println("Digite o nome da tarefa");
                    nameTask = scanner.nextLine();
                    operator.addTask(nameTask);
                    System.out.println("Tarefa adicionada");
                    System.out.println("------------------");
                    break;

                case 2:
                    System.out.println("------------------");
                    System.out.println("Tarefas pendentes:");
                    operator.displayPendingTasks();
                    break;

                case 3:
                    System.out.println("------------------");
                    System.out.println("Digite o nome da tarefa");
                    nameTask = scanner.nextLine();
                    operator.removeTask(nameTask);
                    System.out.println("Tarefa removida com sucesso");
                    System.out.println("------------------");
                    break;

                case 4:
                    Set<String> completedTask = operator.completeTask();
                    if (completedTask != null) {
                        System.out.println("Tarefa : " + completedTask + " completada");
                    } else {
                        System.out.println("Nenhuma tarefa para completar");
                    }
                    break;

                case 99:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
}