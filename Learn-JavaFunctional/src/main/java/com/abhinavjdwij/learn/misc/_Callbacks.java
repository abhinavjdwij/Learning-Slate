package com.abhinavjdwij.learn.misc;

import java.util.function.Consumer;
import java.util.function.Function;

public class _Callbacks {
    public static void main(String[] args) {
        hello1("Abhinav", null, (firstName) -> {
            System.out.println("No Surname for " + firstName);
        });
        hello2("Abhinav", null, () -> {
            System.out.println("No Surname available");
        });
    }

    // java equivalent of callback in JS
    static void hello1(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }
}
