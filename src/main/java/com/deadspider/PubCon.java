package com.deadspider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class PubCon {

    public static void main(String[] args) {

        BiConsumer<String, String> biCon = (key, val)-> {
            System.out.println(key + " <---> " + val );
        };


        Consumer<String> consumer = (s) -> {
            System.out.println("doesn't return anything only consumes: " + s);
        };

        Supplier<String> name = ()-> {
            Properties props  = new Properties();
            try {
                props.load(Files.newInputStream
                        (new File("src/main/resources/application.properties").toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return (Objects.nonNull(props.get("username"))? props.get("username").toString():null);
        }; // can have different suppliers... this one pulls from properties file, one can pull from DB, API's or other sources

        consumer
                .andThen(s-> System.out.println("Hello, "+ s ))
                .andThen(s-> System.out.println("Hi, " + s))
                .andThen(s-> System.out.println("Howdy, " + s))
                .accept(name.get());

    }
}
