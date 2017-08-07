package org.ThreadPool;


import java.util.Random;

public class UseThreadPool {
    public static void main(String[] args) throws IllegalAccessException {
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();
        Task3 t3 = new Task3();
        Task4 t4 = new Task4();

        int taskCount = 0;
        ThreadPool tp = new ThreadPool(2,2);
        while (taskCount < 5){
            Random r = new Random();
            int n = r.nextInt(4);
            if(n == 0)
                tp.execute(t1); // хотим добавить новый таск в очередь
            else if(n==1)
                tp.execute(t2);
            else if(n == 2)
                tp.execute(t3);
            else if (n == 3)
                tp.execute(t4);

            taskCount++;
        }

    }
}
