package com.abhinavjdwij.learn.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        System.out.println(plus1Func.apply(1));
        System.out.println(times5Func.apply(1));
        System.out.println(plus1Func.andThen(times5Func).apply(1));
        System.out.println(sumOfSqFunc.apply(3, 4));
        System.out.println(sumOfSqFunc.andThen(Math::sqrt).apply(3, 4));
    }

    static Function<Integer, Integer> plus1Func = x -> x+1;

    static Function<Integer, Integer> times5Func = x -> x*5;

    static BiFunction<Integer, Integer, Integer> sumOfSqFunc = (x, y) -> x*x + y*y;
}
