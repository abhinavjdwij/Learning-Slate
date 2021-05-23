package io.github.abhinavjdwij.learn.javathreadbasics;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List.of(
                new HelloMessage("Abhinav"),
                new HelloMessage("John"),
                new HelloMessage("Jane"),
                new HelloMessage("Joe"),
                new HelloMessage("Joseph"),
                new HelloMessage("Bob"),
                new HelloMessage("Mark"),
                new HelloMessage("Stacy"),
                new HelloMessage("Alex"),
                new HelloMessage("Lynda")
        ).forEach(executorService::execute);
        executorService.shutdown();
    }
}

class HelloMessage implements Runnable {
    private final String message;

    public HelloMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            System.out.println("Message invoked in :: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Message received :: " + this.message + " in :: " + Thread.currentThread().getName());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}