package com.deadspider;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {

        BiPredicate<String, String> s = (a,b)->a.startsWith(b);

        System.out.println(s.test("hello", "h"));


        Predicate<String> p =
                ((Predicate<String>) str-> str.startsWith("h"))
                .and(str->str.split(" ").length > 2)
                .or(str->str.contains("test")).or(Predicate.not(str->str.contains("string")));

        System.out.println(p.test("h das string"));

    }

    public static <T> boolean check(T t, Predicate<T> p) {
        return p.test(t);
    }

    public static <T> boolean check(T t, Predicate<T> p,
                                    Predicate<T> q) {
        return p.and(p).test(t);
    }
}