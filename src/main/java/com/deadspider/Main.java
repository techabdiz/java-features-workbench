package com.deadspider;

import com.deadspider.managers.SimplePageManager;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        SimplePageManager pageman = new SimplePageManager();
        IntStream.range(100, 1000)
                //.mapToObj(i->new Node(i))
                .forEach(pageman::add);
        System.out.println(pageman);
    }
}