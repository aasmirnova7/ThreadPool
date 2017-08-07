package org.ThreadPool;


public class Task4 implements Runnable {

    @Override
    public void run() {
        System.out.println("Performing Task 4");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stop Task 4");

    }
}
