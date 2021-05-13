package com.abhinavjdwij.learn.imperative.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

// Suppliers can be thought of as functions that take no inputs but return a value
public class _Supplier {
    public static void main(String[] args) {
        System.out.println(supplyFriendNames.get());
    }

    static Supplier<List<String>> supplyFriendNames = () -> {
        System.out.println("Building list of friends...");
        return List.of(
                "John",
                "Jane",
                "Tom"
        );
    };
}
