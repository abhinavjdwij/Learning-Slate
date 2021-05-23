package io.github.abhinavjdwij.learn.javathreadbasics;

// wait and notify are used when threads need to share information / data
// use carefully, can cause deadlock

public class WaitNotifyDemo {
    public static void main(String[] args) throws Exception {
        NaturalNumberSum naturalNumberSum = new NaturalNumberSum(10);
        naturalNumberSum.start();
        synchronized (naturalNumberSum) {
            naturalNumberSum.wait();
            // without wait / notify / synchronization line below will print total immediately without operation completion
            System.out.println("Sum :: " + naturalNumberSum.total);
        }
    }
}

class NaturalNumberSum extends Thread {
    int total = 0;
    int number;

    public NaturalNumberSum(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 1; i <= number; i++) {
                total += i;
            }
            notify();
        }
    }
}