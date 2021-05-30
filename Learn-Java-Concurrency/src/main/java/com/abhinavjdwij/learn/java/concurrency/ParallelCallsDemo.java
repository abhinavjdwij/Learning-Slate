package com.abhinavjdwij.learn.java.concurrency;

/*
* Task : call MockClient 5 times with delays 1, 2, 3, 4, 5 seconds, all calls should finish in 5 to 5.5 seconds
*/

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelCallsDemo {

    public static void main(String[] args) throws Exception {
        List<Integer> delays = List.of(1000, 2000, 3000, 4000, 5000);

        // Using simple Threads -> return value not available in main method
//        System.out.println("Using simple Threads :: ");
//        delays.forEach((delay) -> {
//            Thread t = new Thread(() -> new MockClient().mockExternalCall(delay));
//            t.start();
//        });
//        System.out.println();

//         Using parallel stream
//        System.out.println("Using parallel stream :: ");
//        delays.parallelStream().map(delay -> new MockClient().mockExternalCall(delay)).forEach(System.out::println);
//        System.out.println();

        // Using Completable Future
        System.out.println("Using Completable Future :: ");
        Stream<CompletableFuture<String>> futures = delays
                .stream()
                .map(delay -> CompletableFuture.supplyAsync(() -> new MockClient().mockExternalCall(delay)));

        System.out.println("Waiting for all processes to complete");
        while (futures.map(future -> future.isDone()).anyMatch(done -> !done)) {
            // Can use timeout using System time here if needed
        }
        System.out.println("All futures completed");
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }


    static class MockClient {
        public String mockExternalCall(int delay) {
            String log = String.format("Called from thread %s with id %s with delay %s", Thread.currentThread().getName(), Thread.currentThread().getId(), delay);
            System.out.println("START : " + log);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("END : " + log);
            return String.format("Hello from %s", Thread.currentThread().getName());
        }
    }
}
