package com.abhinavjdwij.learn.optionals;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object val = Optional.ofNullable(null)
                .orElseGet(() -> "default");
        System.out.println("val :: " + val);

        Optional.ofNullable("Hi")
                .ifPresent(System.out::println);

//        Optional.ofNullable(null)
//                .orElseThrow(() -> new IllegalStateException("Null Value Exception"));

        List.of(
                Optional.ofNullable(null),
                Optional.ofNullable("INPUT1")
        ).forEach(optional -> {
            optional.ifPresentOrElse(
                    (input) -> {
                        System.out.println("Input is not null " + input);
                    },
                    () -> {
                        System.out.println("Null Input");
                    }
            );
        });

        // throw exception + return value combination
        String optionalGreeting1 = Optional.ofNullable("Abhinav")
                .map(optional -> {
                    return "Hello, " + optional;
                })
                .orElseThrow(() -> new IllegalArgumentException("Null name / No greetings"));
        System.out.println(optionalGreeting1);
        String optionalGreeting2 = Optional.ofNullable(null)
                .map(optional -> {
                    return "Hello, " + optional;
                })
                .orElseGet(() -> "Hello, World!");
        System.out.println(optionalGreeting2);
    }
}
