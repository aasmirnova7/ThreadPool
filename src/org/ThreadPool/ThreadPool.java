package org.ThreadPool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPool {
    private BlockingQueue taskQueue = null; // queue of tasks. Threads pick tasks from there
    private List<PoolThread> threads = new ArrayList<PoolThread>(); //pool of threads which pick the tasks
    private boolean isStopped = false; // is the thread pool started

    public ThreadPool(int noOfThreads, int maxNoOfThreads){ // how many threads in pool. How many tasks in queue
        taskQueue = new ArrayBlockingQueue(maxNoOfThreads);  // выделили очередь потоков

        for(int i=0; i<noOfThreads; ++i){
            // Мы начинаем(добавляем) все потоки в пул
            threads.add(new PoolThread(taskQueue)); //add threads in the pool arrayList
        }
        for (PoolThread thread: threads){
            //Запускаем все потоки в пуле тредов
            thread.start(); // start all threads in constructor of threadPool itself
        }
    }

    public synchronized void execute(Runnable task) throws IllegalAccessException { //task that need to be executed/ Put them in the task queue
        if(this.isStopped) throw //don't put any more tasks here
        new IllegalAccessException("Thread pool is stopped");
          try{
              this.taskQueue.put(task); //put task in queue if NOT FULL
          } catch (InterruptedException e) {
              Logger.getLogger(ThreadPool.class.getName()).log(Level.SEVERE,null,e);
          }
    }

    public synchronized void stop(){
        this.isStopped = true; //stop thread pool
        for(PoolThread thread: threads){
            thread.stopThread(); //stop all threads
        }
    }
}
