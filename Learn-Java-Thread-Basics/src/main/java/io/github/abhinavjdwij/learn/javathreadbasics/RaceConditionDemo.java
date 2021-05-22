package io.github.abhinavjdwij.learn.javathreadbasics;

public class RaceConditionDemo {
    private static int val = 100;

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " executing ");
            if (val == 100) {
                val /= 5;
            }
        }, "By-5-Thread");
        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " executing ");
            val = 25;
        }, "To-25-Thread");
        t1.start();
        t2.start();
        // t1 and t2 will have race condition, final value of val is non-deterministic
        Thread.sleep(1000); // allow some time for evaluation
        System.out.println("Final value of val :: " + val);

    }
}
