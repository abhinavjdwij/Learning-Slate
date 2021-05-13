package com.abhinavjdwij.learn.imperative.functionalinterface;

import com.abhinavjdwij.learn.imperative.Main;

import java.util.List;
import java.util.stream.Collectors;

import static com.abhinavjdwij.learn.imperative.functionalinterface._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", OTHER)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> {
                    return FEMALE.equals(person.gender);
                });

        boolean atleastOneFemale = people.stream()
                .anyMatch(person -> {
                    return FEMALE.equals(person.gender);
                });

        boolean noNullGender = people.stream()
                .noneMatch(person -> person == null);

        System.out.println(containsOnlyFemales);
        System.out.println(atleastOneFemale);
        System.out.println(noNullGender);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender {
        MALE, FEMALE, OTHER
    }
}
