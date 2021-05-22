package io.github.abhinavjdwij.learn.javathreadbasics;

public class ThreadStatesDemo {
    private static void printThreadInfo(Thread t) {
        System.out.printf("name :: %s\nisAlive :: %s\nstate :: %s\ngetPriority :: %s\n\n"
                , t.getName(), t.isAlive(), t.getState(), t.getPriority()
        );
    }

    public static void main(String[] args) throws InterruptedException {
        printThreadInfo(Thread.currentThread()); // main thread
        printThreadInfo(new Thread()); // is Alive false
        Thread customThread = new Thread("CustomThread");
        customThread.start(); // isAlive true
        printThreadInfo(customThread);
        Thread.sleep(1000); // main thread sleep
    }
}
