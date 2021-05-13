package com.abhinavjdwij.learn.combinatorpattern;

import java.time.LocalDate;

import static com.abhinavjdwij.learn.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@mail.com",
                "1223334567",
                LocalDate.of(2000, 01, 01)
        );

        // This is lazy evaluation
        System.out.println(emailValidation()
                .and(phoneNumberValidation())
                .and(isAdultValidation())
                .apply(customer));
    }
}
