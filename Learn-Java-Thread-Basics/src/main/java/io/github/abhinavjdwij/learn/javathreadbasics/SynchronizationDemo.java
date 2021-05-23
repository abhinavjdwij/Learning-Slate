package io.github.abhinavjdwij.learn.javathreadbasics;

import java.util.List;

public class SynchronizationDemo {
    private static int counter = 1; // the variable can also be synchronized (create class and use synchronized variable and method)

    // if not synchronized, this method will return ambiguous output in concurrent environment
    private static synchronized int incrementAndGetId(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return counter++;
    }

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Counter :: " + incrementAndGetId()
                + " Thread name :: " + Thread.currentThread().getName());
        List.of(
                new Thread(r, "T1"),
                new Thread(r, "T2"),
                new Thread(r, "T3"),
                new Thread(r, "T4"),
                new Thread(r, "T5")
        ).forEach(Thread::start);
    }
}
