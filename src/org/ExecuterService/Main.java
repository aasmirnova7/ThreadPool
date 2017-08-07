package org.ExecuterService;

import java.util.concurrent.*;

// Проверка методов интерфейса ExecutorService
public class Main {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        /*
        // Для метода execute
        executorService.execute(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });*/

        // Для метода submit
        Future future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println("Asynchronous task");
            }
        });

        try {
            System.out.println(future.get()); //returns null if the task has finished correctly.
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
