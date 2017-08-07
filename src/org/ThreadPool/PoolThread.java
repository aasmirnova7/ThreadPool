package org.ThreadPool;


import java.util.concurrent.BlockingQueue;


// Описываем сами потоки из пула
public class PoolThread extends Thread{
    private BlockingQueue taskQueue = null; //task queue from where thread will take tasks
    private boolean isStopped = false; // is thread stopped

    public PoolThread(BlockingQueue queue){
        taskQueue = queue; // set the task queue from where thread will take its task from
    }

    public void run(){
        while (!isStopped){ //if not stopped then pick task and execute in loop
            Runnable runnable = null;
            try {
                runnable = (Runnable) taskQueue.take(); //take your task
                runnable.run(); //run it
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void stopThread(){
        isStopped = true;
        this.interrupt(); // stop thread
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }

}
