package com.abhinavjdwij.learn.misc;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCase = input -> {
            if (input.isBlank()) {
                throw new IllegalArgumentException("Invalid input");
            }
            return input.toUpperCase();
        };
        System.out.println(upperCase.apply("Abhinav"));

        BiFunction<String, String, String> greet = (message, name) -> {
            return message + ", " + name;
        };
        System.out.println(greet.apply("Hello", "Abhinav"));
    }
}
