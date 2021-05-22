package io.github.abhinavjdwij.learn.javathreadbasics;

/*
* Multiple ways of creating threads in java
 */

public class ThreadHello {
    public static void main(String[] args) {
        new Thread(new HelloRunnable()).start();

        Runnable r = () -> System.out.println("Hello from " + Thread.currentThread().getName() +
                " using lambda");
        new Thread(r).start();

        new HelloThread().start();

        new Thread((() -> {
            System.out.println("Hello from " + Thread.currentThread().getName() + " using custom Thread name");
        }), "CustomizedThread").start();

        Runnable x = () -> System.out.println("Hello from thred with custom name : " + Thread.currentThread().getName());

    }
}

class HelloThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Hello from " + Thread.currentThread().getName() + " "
                + "created by extending Thread class");
    }
}

class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from " + Thread.currentThread().getName() + " " +
                " created by implementing Runnable Interface" );
    }
}
