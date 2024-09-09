package br.andre.estudos.listas;

import java.util.*;

public class ListasExercise {

//    public static List<String> tasks;
    Set<String> completedTasks;
    Queue<String> taskQueue;

    public ListasExercise() {
//        tasks = new ArrayList<>();
        completedTasks = new HashSet<>();
        taskQueue = new LinkedList<>();
    }

    public Queue<String> addTask(String nameTask) {
//        tasks.add(nameTask);
        taskQueue.add(nameTask);
        return taskQueue;
    }

    public void displayPendingTasks() {
        Iterator<String> iterator = taskQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        for (String task : tasks) {
//            System.out.println(task);
//        }
    }

    public Queue<String> removeTask(String nameTask){
//        tasks.remove(nameTask);
        taskQueue.remove(nameTask);
        return taskQueue;
    }

    public Set<String> completeTask() {
        System.out.println("------------------");
        String task = taskQueue.poll();
        if (task != null) {
            completedTasks.add(task);
//            return task;
            return completedTasks;
        } else {
            return null;
        }
    }
}