package io.github.abhinavjdwij.learn.javathreadbasics;

public class ThreadStaticMethodsDemo {
    public static void main(String[] args) {
        // returns estimated number of active threads
        System.out.println(Thread.activeCount());

        // print all thread names
        System.out.println(Thread.getAllStackTraces().keySet());
    }
}
