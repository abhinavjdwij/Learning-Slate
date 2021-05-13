package com.abhinavjdwij.learn.imperative.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Consumers can be thought of as void functions
public class _Consumer {
    public static void main(String[] args) {
        greeting.accept(new Person("Abhinav", 12345));
        customGreeting.accept(new Person("Abhinav", 12345), "Hi");
    }

    static Consumer<Person> greeting =
            p -> System.out.println(
                    "Hello, " + p.name
                    + ".. Your phone number is " + p.phone
            );

    static BiConsumer<Person, String> customGreeting =
            (person, greeting) -> System.out.println(
                    greeting + ", " + person.name
                    + ".. Your phone number is " + person.phone
            );

    static class Person {
        String name;
        Integer phone;

        public Person(String name, Integer phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}
