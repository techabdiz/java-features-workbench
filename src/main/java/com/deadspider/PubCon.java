package com.deadspider;

import java.util.function.Consumer;

public class PubCon {

    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> {
            System.out.println("doesn't return anything only consumes: " + s);
        };

        consumer
                .andThen(s-> System.out.println("Hello, "+ s))
                .andThen(s-> System.out.println("Hi, " + s))
                .andThen(s-> System.out.println("Howdy, " + s))
                .accept("Doe, Jonathan");
    }
}
