package org.ThreadPool;

/**
 * Created by Acer1212 on 06.08.2017.
 */
public class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Performing Task 2");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stop Task 2");

    }
}
