package io.github.abhinavjdwij.learn.javathreadbasics;

// synchronized block is used to get lock on an object

public class SynchronizedBlockDemo {
    public static void main(String[] args) {
        CountDown countDown = new CountDown();
        Runnable r = () -> {synchronized(countDown) { countDown.begin(); }};

        // without synchronization they will work in parallel, and can impact each other, the output will be non-deterministic
        new Thread(r, "T1").start();
        new Thread(r, "T2").start();
    }
}

class CountDown {
    public void begin(int start, int end) {
        try {
            assert (start >= end);
            System.out.println("CountDown begins :: " + Thread.currentThread().getName());
            for (int i = start; i >= end; i--) {
                System.out.printf("*  %d  *\n", i);
            }
            System.out.println("CountDown complete :: " + Thread.currentThread().getName());
        } catch (Exception e) {
            System.out.println("Exception in CountDown :: " + e.getMessage());
        }
    }

    public void begin() {
        begin(10, 1);
    }
}