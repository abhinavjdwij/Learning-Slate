package io.github.abhinavjdwij.learn.javathreadbasics;

// CountDownLatch is used to execute concurrent operations fixed number of times (until value of CountDownLatch becomes 0)

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int countDownSize = 5;
        CountDownLatch countDownLatch = new CountDownLatch(countDownSize);
        List<WorkerThread> workerThreads = List.of(
                new WorkerThread("T1", countDownLatch, 1000),
                new WorkerThread("T2", countDownLatch, 2000),
                new WorkerThread("T3", countDownLatch, 3000),
                new WorkerThread("T4", countDownLatch, 4000),
                new WorkerThread("T5", countDownLatch, 5000)
        );
        workerThreads.forEach(WorkerThread::start);
        countDownLatch.await();
        System.out.println("All threads executed");
    }
}

class WorkerThread extends Thread {
    CountDownLatch countDownLatch;
    Integer timeOutMillis;

    public WorkerThread(String name, CountDownLatch countDownLatch, Integer timeOutMillis) {
        super(name);
        this.countDownLatch = countDownLatch;
        this.timeOutMillis = timeOutMillis;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread started :: " + Thread.currentThread().getName());
            Thread.sleep(this.timeOutMillis);
            countDownLatch.countDown();
            System.out.println("CountDown decremented by :: " + Thread.currentThread().getName() + ", Countdown :: " + countDownLatch.getCount());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}