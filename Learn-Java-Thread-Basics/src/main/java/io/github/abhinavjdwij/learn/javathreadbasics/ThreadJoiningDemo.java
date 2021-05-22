package io.github.abhinavjdwij.learn.javathreadbasics;

public class ThreadJoiningDemo {
    public static void main(String[] args) throws InterruptedException {
        TestClass t1 = new TestClass("t1");
        TestClass t2 = new TestClass("t2");
        TestClass t3 = new TestClass("t3");
        t1.start();
        t1.join(); // wait for t1 to complete
        t2.start(); // parallel to t3
        t3.start(); // parallel to t2
    }
}

class TestClass extends Thread {
    public TestClass(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println("Thread :: " + Thread.currentThread().getName() + " i :: " + i);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
