package com.abhinavjdwij.learn.imperative.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println(isAdult.test(new Person("Abhinav", 25, "Engineer")));
        System.out.println(isAdult.test(new Person("Nidhi", 10, "Student")));
        System.out.println(isSumEven.test(25, 50));
        System.out.println(
                "Is adult and an engineer :: "
                + isAdult.and(isEngineer).test(
                        new Person("Abhinav", 25, "Engineer")
                )
        );
        System.out.println(
                "Is adult or an engineer :: "
                        + isAdult.or(isEngineer).test(
                        new Person("John", 17, "Engineer")
                )
        );
    }

    static Predicate<Person> isAdult = person -> person.age >= 18;

    static Predicate<Person> isEngineer = person -> "Engineer".equals(person.profession);

    static BiPredicate<Integer, Integer> isSumEven = (x, y) -> x+y % 2 == 0;

    static class Person {
        String name;
        Integer age;
        String profession;

        public Person(String name, Integer age, String profession) {
            this.name = name;
            this.age = age;
            this.profession = profession;
        }
    }
}
